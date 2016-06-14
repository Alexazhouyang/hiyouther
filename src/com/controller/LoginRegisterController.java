package com.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.mybatis.entity.Boss;
import com.mybatis.entity.Member;
import com.mybatis.entity.User;
import com.mybatis.mapper.BossMapper;
import com.mybatis.mapper.MemberMapper;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.PageFans;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.PageFansBean;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.javabeans.weibo.Company;
import com.qq.connect.oauth.Oauth;
import com.service.LoginRegisterService;
import com.service.ThreadPage.EmailBYFindPwdThread;
import com.service.ThreadPage.EmailThreadForRegister;
import com.taobao.api.ApiException;
import com.tool.GetPicForWeb;
import com.tool.SMS.SendSMStool;

@Controller
@SessionAttributes()

/**
 * @author forvoid 本类用于用户的登录注册和邮箱验证接口
 */
@RequestMapping("/api")
public class LoginRegisterController {

	@Resource
	LoginRegisterService loginRegisterService;
	@Resource
	com.service.OtherPushByHiyoutherService verControll;
	@Resource
	MemberMapper memberMapper;
	@Resource
	com.md5.DesUtil DES;
	@Resource
	com.md5.Md5 md5;
	@Resource
	BossMapper bossMapper;
	/**
	 * 密码找回
	 * 找回方式分为 手机号发送验证码 和邮箱发送验证码(请求希望提供option\type\account)(验证希望提供verid\newpwd\option)
	 * option :mobile \email(发送验证的方式)
	 * type:用户类型（member\boss）
	 * account:帐号
	 * verid：验证码
	 * newpwd:新密码
	 * */
	@RequestMapping("/findpwd")
	public void findpwd(String option ,String type,String account,String verid,String newpwd,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		com.alibaba.fastjson.JSONObject js = new com.alibaba.fastjson.JSONObject();
		HttpSession session = getSession(request);
		//发送验证码部分（需要提供帐号）
		if(account!=null){
			Boolean sign=false;
			//发送验证码前验证操作
			if(option.equals("mobile")){
				if(type.equals("member")){
					Member member = memberMapper.selectByMphone(account);
					if(member!=null){
						sign=true;
					}else{
						js.put("code", -1);
						js.put("info", "没有查到到您在我们网站注册的信息");
					}
				}else if(type.equals("boss")){
					Boss boss = bossMapper.selectByPhone(account);
					if(boss!=null){
						sign=true;
					}else{
						js.put("code", -1);
						js.put("info", "没有查到到您在我们网站注册的信息");
					}
				}else{
					js.put("code", -1);
					js.put("info", "未找到对应的type");
				}
			}else if(option.equals("email")){
				if(type.equals("member")){
					Member member = memberMapper.selectByEmail(account);
					if(member!=null){
						sign=true;
					}else{
						js.put("code", -1);
						js.put("info", "没有查到到您在我们网站注册的信息");
					}
				}else if(type.equals("boss")){
					Boss boss = bossMapper.selectByEmail(account);
					if(boss!=null){
						sign=true;
					}else{
						js.put("code", -1);
						js.put("info", "没有查到到您在我们网站注册的信息");
					}
				}else{
					js.put("code", -1);
					js.put("info", "未找到对应的type");
				}
			}else{
				js.put("code", -1);
				js.put("info", "未找到对应的option");
			}
			//发送操作
			if(sign){
				User user = new User();
				int yanzheng = SendSMStool.gentRanNum();
				user.setMa(yanzheng);
				user.setPhone(account);
				user.setType(type);
				if(option.equals("mobile")){
					int i = verControll.findPwdBYPhone(account, yanzheng);
					if (i == 1) {
						session.setAttribute("user", user);
						// "验证码发送成功！！");
						js.put("code", 1);
						js.put("info", "验证码发送成功！");
					} else {
						js.put("code", -1);
						js.put("info", "验证码发送失败！");
					}
				}else{//发送邮箱验证码
					EmailBYFindPwdThread emailthread = new EmailBYFindPwdThread(account,yanzheng);
					Thread thread = emailthread;
					thread.start();
					session.setAttribute("user", user);
					js.put("code", 1);
					js.put("info", "验证码发送成功！");
				}
			}
		}else{//验证阶段(verid\newpwd\option)
			User user = (User)session.getAttribute("user");
			String nowtype = user.getType();
			String nowaccount = user.getPhone();
			if(option.equals("mobile")){
				if(verid.equals(user.getMa()+"")){
					if(nowtype.equals("member")){
						Member member = memberMapper.selectByMphone(nowaccount);
						member.setMpassword(md5.getMD5(newpwd));
						if(memberMapper.updateByPrimaryKey(member)>0){
							js.put("code", 1);
							js.put("info", "找回密码成功，请使用新密码登录吧！");
						}else{
							js.put("code", -1);
							js.put("info", "未知错误，请联系客服！");
						}
					}else{
						Boss boss = bossMapper.selectByPhone(nowaccount);
						boss.setBpassword(md5.getMD5(newpwd));
						if(bossMapper.updateByPrimaryKey(boss)>0){
							js.put("code", 1);
							js.put("info", "找回密码成功，请使用新密码登录吧！");
						}else{
							js.put("code", -1);
							js.put("info", "未知错误，请联系客服！");
						}
					}
				}else{
					js.put("code", -1);
					js.put("info", "验证码不匹配！");
				}
			}else{
				if(verid.equals(user.getMa()+"")){
					if(nowtype.equals("member")){
						Member member = memberMapper.selectByEmail(nowaccount);
						member.setMpassword(md5.getMD5(newpwd));
						if(memberMapper.updateByPrimaryKey(member)>0){
							js.put("code", 1);
							js.put("info", "找回密码成功，请使用新密码登录吧！");
						}else{
							js.put("code", -1);
							js.put("info", "未知错误，请联系客服！");
						}
					}else{
						Boss boss = bossMapper.selectByEmail(nowaccount);
						boss.setBpassword(md5.getMD5(newpwd));
						if(bossMapper.updateByPrimaryKey(boss)>0){
							js.put("code", 1);
							js.put("info", "找回密码成功，请使用新密码登录吧！");
						}else{
							js.put("code", -1);
							js.put("info", "未知错误，请联系客服！");
						}
					}
				}else{
					js.put("code", -1);
					js.put("info", "验证码不匹配！");
				}
				
			}
		}
		replyJson(response, js);

	}
	public HttpSession getSession(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session==null)
			session=request.getSession();
		return session;
	}
	/**
	 * qq互联
	 * 第三方
	 * qq登录的用户我们需要他的openid，nickname （qq昵称）gender （性别）
	 * figureurl_2（100*100）头像
	 * */
	@RequestMapping("/qqLink")
	public void Register(String type,String access_token,String expires_in,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		HttpSession session = getSession(request);
		JSONObject js = new JSONObject(); 


       //创建seession连接，用于下次再次连接时确认登录类型
		if(type!=null){
			User user = new User();
			user.setType(type);
			session.setAttribute("user", user);
			js.put("code", 1);
			js.put("info", "可以前往qq登录");
			replyJson(response, js);
		}else{
			User user = (User) session.getAttribute("user");
			 OpenID openIDObj =  new OpenID(access_token);
		     String openID = openIDObj.getUserOpenID();
			if(user.getType().equals("member")){
				Member member = memberMapper.selectByQQLink(openID+"/");
				if(member!=null){//数据库有的话就提示登陆成功
					user.setId(member.getMid());
					user.setType("member");
					session.setAttribute("user", user);
					response.sendRedirect("../html/index.html");
				}else{//如果没有就为他创建一个
					Member newmember = new Member();
					UserInfo qzoneUserInfo = new UserInfo(access_token, openID);
				     UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
				     if(userInfoBean.getNickname()!=null){
				    	 newmember.setMemname(userInfoBean.getNickname());
				     }
				     newmember.setMqq(openID+"/");
					if(userInfoBean.getGender()!=null){
						newmember.setMsex(userInfoBean.getGender()!="男"?"man":"man");
					}
					newmember.setMcancel("1");
					newmember.setMtouxiang(userInfoBean.getAvatar().getAvatarURL100()!=null?userInfoBean.getAvatar().getAvatarURL100():"img/etc/init.jpg");
					newmember.setMinsettime(new Date());
					memberMapper.insert(newmember);
					user.setId(newmember.getMid());
					user.setType("member");
					session.setAttribute("user", user);
					response.sendRedirect("../html/index.html");
				}
			}else if(user.getType().equals("boss")){
				Boss boss = bossMapper.selectByQQLink(openID+"/");
				if(boss!=null){//数据库有的话就提示登陆成功
					user.setId(boss.getBid());
					user.setType("boss");
					session.setAttribute("user", user);
					response.sendRedirect("../html/index.html");
				}else{//如果没有就为他创建一个
					 Boss newboss = new Boss();
					UserInfo qzoneUserInfo = new UserInfo(access_token, openID);
				     UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
				     if(userInfoBean.getNickname()!=null){
				    	 newboss.setBusername(userInfoBean.getNickname());// 帐号（手机）
				     }
				     if(userInfoBean.getGender()!=null){
				    	 newboss.setBsex(userInfoBean.getGender()!="男"?"man":"woman");
				     }
				     newboss.setBtouxiang(userInfoBean.getAvatar().getAvatarURL100()!=null?userInfoBean.getAvatar().getAvatarURL100():"img/etc/init.jpg");
				     newboss.setBqq(openID+"/");
				     newboss.setBcancel(1);
				     newboss.setBinsettime(new Date());
					bossMapper.insertSelective(newboss);
					user.setId(newboss.getBid());
					user.setType("boss");
					session.setAttribute("user", user);
					response.sendRedirect("../html/index.html");
				}
			}else{
				js.put("code", -1);
				js.put("info", "没有找到该类型，前端申请qq连接接口时传入类型值出错");
			}
		}
		//}
       //如果数据库有openid我就返回信息成功
      /* if(){
    	   
       }else{//如果没有的话我就创建
    	   
    	   
       }*/
//       OpenID openIDObj =  new OpenID(access_token);
//       String openID = openIDObj.getUserOpenID();
//       UserInfo qzoneUserInfo = new UserInfo(access_token, openID);
//       UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
//       
//       if(){
//       if (userInfoBean.getRet() == 0) {
//           out.println(userInfoBean.getNickname() + "<br/>");
//           out.println(userInfoBean.getGender() + "<br/>");
//           out.println("<image src=" + userInfoBean.getAvatar().getAvatarURL100() + "/><br/>");
//       } else {
//           out.println("很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
//       }
       }


		
	/**
	 * 注册服务 用于hiyouth用户的注册服务 分为短信注册和邮箱注册
	 * type类型由service判断，我只需要在这里调用验证码，并成功验证创建用户即可，或者向用户发送邮箱信息创建用户即可
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/Register")
	public void Register(String type, String option, String account, String pwd, String verid,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		HttpSession session = getSession(request);
		String sessionId = session.getId();
		// sessionId);
		JSONObject js = new JSONObject();
		boolean status = false;
		// "进入register");
		if (option.equals("mobile")) {
			if (account != null) {
				// 验证码发送
				if (type.equals("member")) {
					Member member = memberMapper.selectByMphone(account);
					if (member != null) {
						js.put("code", 0);
						js.put("info", "数据库已经存在该手机号信息");
					} else {
						status = true;
					}
				} else if (type.equals("boss")) {
					Boss boss = bossMapper.selectByPhone(account);
					if (boss != null) {
						js.put("code", 0);
						js.put("info", "数据库已经存在该手机号信息");
					} else {
						status = true;
					}
				}
				if (status) {
					User user = new User();
					int zhuceid = SendSMStool.gentRanNum();
					user.setMa(zhuceid);
					user.setPhone(account);
					user.setType(type);
					int i = 0;
					if(type.equals("boss")){
						 i = verControll.RegisterBYPhoneForBoss(account, zhuceid);
					}else{
						 i = verControll.RegisterBYPhoneForMember(account, zhuceid);
					}
					if (i == 1) {
						session.setAttribute("user", user);
						// "验证码发送成功！！");
						js.put("code", 1);
						js.put("info", "验证码发送成功！");
					} else {
						js.put("code", -1);
						js.put("info", "验证码发送失败！");
					}
				}
			} else {
				// "进入注册页面");
				User user = (User) session.getAttribute("user");
				int Verid = user.getMa();
				if (Verid == Integer.valueOf(verid)) {

					js = loginRegisterService.Register(type, "hiyouth", "mobile", user.getPhone(), pwd);

					if (js.get("code").equals(1)) {
						JSONObject date = (JSONObject) js.get("data");
						user.setId((int) date.get("id"));
						user.setType(type);
						// "---------------------------");
						session.setAttribute("user", user);
						// user.getId());
					}
				} else {
					js.put("code", -1);
					js.put("info", "注册验证失败，前端注意再次发送验证码，间隔时间请把握好！");
				}
			}
		}
		if (option.equals("email")) {
			if (type.equals("member")) {
				Member member = memberMapper.selectByEmail(account);
				if (member != null) {
					js.put("code", 0);
					js.put("info", "数据库已经存在该邮箱信息");
				} else {
					status = true;
				}
			} else if (type.equals("boss")) {
				Boss boss = bossMapper.selectByEmail(account);
				if (boss != null) {
					js.put("code", 0);
					js.put("info", "数据库已经存在该邮箱信息");
				} else {
					status = true;
				}
			}
			if(status){
			// 邮箱验证方式：需要配置邮箱的stmp还有发件人的信息在VerificationByEmailService类中
			js.put("code", 1);
			js.put("info", "邮箱发送中！");
			EmailThreadForRegister emailthread = new EmailThreadForRegister(account, type, pwd);
			Thread thread = emailthread;
			thread.start();

			String passwordjiami = md5.getMD5(pwd);
			if (type.equals("member")) {
				Member member = memberMapper.selectByEmail(account);
				if (member == null) {
					Member newmember = new Member();
					newmember.setMemname("小柚");// 帐号（手机）
					newmember.setMemail(account);// 帐号（邮箱）
					newmember.setMtouxiang("img/etc/member.jpg");
					newmember.setMpassword(passwordjiami);// 密码
					newmember.setMcancel("0");
					newmember.setMinsettime(new Date());
					memberMapper.insertSelective(newmember);
				}
			} else {
				Boss boss = bossMapper.selectByPhone(account);
				if (boss == null) {

					Boss newboss = new Boss();
					newboss.setBusername("大柚");
					newboss.setBemail(account);
					newboss.setBtouxiang("img/etc/boss.jpg");
					newboss.setBpassword(passwordjiami);// 密码
					newboss.setBcancel(0);
					newboss.setBinsettime(new Date());
					bossMapper.insert(newboss);
				}
			}
			}
		}
		replyJson(response, js);
	}

	@RequestMapping("/Login")
	public void Login(String type, String channel, String option, String account, String pwd,
			HttpServletResponse response, HttpServletRequest request) throws ApiException, IOException {
		HttpSession session = getSession(request);
		JSONObject loginjs = new JSONObject();
		if (option != null) {// hiyouth登录
			User user = new User();
			loginjs = loginRegisterService.LoginByHiyouth(type, option, account, pwd);
			// loginjs.get("code"));
			if (loginjs.get("code").equals(1)) {
				JSONObject date = (JSONObject) loginjs.get("data");
				user.setId((int) date.get("id"));
				user.setType(type);
				// "---------------------------");
				// user.getId());
				session.setAttribute("user", user);
			}
		} else {
			User user = new User();
			loginjs = loginRegisterService.LoginByOther(type, channel, account, pwd);
			if (loginjs.get("code").equals(1)) {
				JSONObject date = (JSONObject) loginjs.get("data");
				user.setId((int) date.get("id"));
				user.setType(type);
				// "---------------------------");
				session.setAttribute("user", user);
			}

		}
		replyJson(response, loginjs);
	}

	/**
	 * 用于邮箱验证和邮箱验证信息的再次发送 option:ver\resend 验证、再次发送 emailname:ver
	 * 为邮箱号的DES方式的密钥，resend为再次发送的邮箱号。
	 */

	@RequestMapping("/EmailVer")
	public void emailVer(String option, String emailname, HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		JSONObject js = new JSONObject();
		if (option.equals("ver")) {
			String email = URLDecoder.decode(emailname,"UTF-8");
			js = verControll.emailVer(email);
			
			request.getSession().setAttribute("code", js.get("code"));
			if(js.get("code").equals(1)){
				request.getSession().setAttribute("email", ((JSONObject)js.get("data")).get("email"));
			}
			response.sendRedirect("../html/oops.jsp");

		} else if (option.equals("resend")) {
			int i = verControll.RegisterVerficationBYEmail(emailname);
			if (i == 1){
				js.put("code", 1);
				js.put("info", "注册邮件发送成功");
			} else {
				js.put("code", -1);
				js.put("info", "注册邮件发送失败");
			}
			replyJson(response, js);
		} else {

		}
	}

	private void replyJson(HttpServletResponse response, com.alibaba.fastjson.JSONObject js) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(js.toString());// j.toString());
		response.getWriter().flush();
	}

	private void replyJson(HttpServletResponse response, JSONObject j) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(j.toString());// j.toString());
		response.getWriter().flush();
	}

}
