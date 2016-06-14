package com.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mybatis.entity.Boss;
import com.mybatis.entity.Member;
import com.mybatis.entity.User;
import com.service.ThreadPage.EmailBYBindingThread;
import com.service.ThreadPage.EmailBYFindPwdThread;
import com.tool.SMS.SendSMStool;

@Controller
@SessionAttributes()
@RequestMapping("/api")
/**
 * @author forvoid
 * 用户个人设置
 * 本类用于账户设置（修改密码和找回密码不包括在内）
 * */
public class PersonSetterController {
	@Resource
	com.service.OtherPushByHiyoutherService verControll;
	@Resource
	com.service.PersonSetterService persionSet;
	@Resource
	com.md5.Md5 md5;
	@Resource
	com.mybatis.mapper.MemberMapper memberMapper;
	@Resource
	com.mybatis.mapper.BossMapper bossMapper;
	
	/**
	 * 获取个人需要修改的资料
	 * */
	@RequestMapping("/getPersonForSet")
	public void getPersonForSet(HttpServletResponse response, HttpServletRequest request) throws Exception {
		HttpSession session = getHttpSession(request);
		JSONObject returnjs = new JSONObject(); 
       //创建seession连接，用于下次再次连接时确认登录类型
		User user = getSession(request);
		if (user == null ) {
			returnjs.put("code", -1);
			returnjs.put("info", "未登录");
		} else {
			returnjs=persionSet.getPersonManage(user.getId(), user.getType());
		}
		replyJson(response, returnjs);
	}
	public User getSession(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session==null)
			session=request.getSession();
		User u = (User) session.getAttribute("user");
		return u;
	}
	/**
	 * 用户修改密码接口
	 * */
	@RequestMapping("/updpwd")
	public void updPwd(String oldpwd ,String newpwd,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		HttpSession session = getHttpSession(request);
		User user = (User)session.getAttribute("user");
		JSONObject js = new JSONObject(); 
		if (user == null ) {
			js.put("code", -1);
			js.put("info", "未登录");
		} else {
			if(user.getType().equals("boss")){
			Boss boss = bossMapper.selectByPrimaryKey(user.getId());
			if(boss!=null){
				if(md5.getMD5(oldpwd).equals(boss.getBpassword())){
					boss.setBpassword(md5.getMD5(newpwd));
					bossMapper.updateByPrimaryKey(boss);
					js.put("code", 1);
					js.put("info", "密码修改成功");
				}else{
					js.put("code", -1);
					js.put("info", "原密码输入错误，请重新输入");
				}
			}else{
				js.put("code", -1);
				js.put("info", "请登录后再试");
			}
		}else{
			Member member = memberMapper.selectByPrimaryKey(user.getId());
			if(member!=null){
				if(md5.getMD5(oldpwd).equals(member.getMpassword())){
					member.setMpassword(md5.getMD5(newpwd));
					memberMapper.updateByPrimaryKey(member);
					js.put("code", 1);
					js.put("info", "密码修改成功");
				}else{
					js.put("code", -1);
					js.put("info", "原密码输入错误，请重新输入");
				}
			}else{
				js.put("code", -1);
				js.put("info", "请登录后再试");
			}
		}
		}
		replyJson(response, js);
	}
	/**
	 * 绑定手机号或者更换手机绑定
	 * @throws Exception 
	 * */
	@RequestMapping("/setPhone")
	public void setPhone(String phone,String verid,HttpServletResponse response, HttpServletRequest request) throws Exception{
		JSONObject returnjson = new JSONObject();
		HttpSession session = getHttpSession(request);
		User user = (User)session.getAttribute("user");
		if(user==null){
			returnjson.put("code", -1);
			returnjson.put("info", "未登录");
		}else{
			String type = user.getType();
			Boolean sign = false;
			if(type.equals("member")){
				Member member = memberMapper.selectByMphone(phone);
				if(member!=null){
					returnjson.put("code", -1);
					returnjson.put("info", "数据库已存在该手机号，请更换手机号！");
				}else{
					sign=true;
				}
			}else if(type.equals("boss")){
				Boss boss = bossMapper.selectByPhone(phone);
				if(boss!=null){
					returnjson.put("code", -1);
					returnjson.put("info", "数据库已存在该手机号，请更换手机号！");
				}else{
					sign=true;
				}
			}else{
				returnjson.put("code", -1);
				returnjson.put("info", "未登录！");
			}
			if(verid==null){
				if(sign){
				int yanzheng = SendSMStool.gentRanNum();
				user.setMa(yanzheng);
				int i = verControll.findPwdBYPhone(phone, yanzheng);
				if (i == 1) {
					session.setAttribute("user", user);
					// "验证码发送成功！！");
					returnjson.put("code", 1);
					returnjson.put("info", "验证码发送成功！");
				} else {
					returnjson.put("code", -1);
					returnjson.put("info", "验证码发送失败！");
				}
				}
			}else{
				int id = user.getId();
				if(verid.equals(user.getMa()+"")){
					if(type.equals("boss")){
						Boss boss = bossMapper.selectByPrimaryKey(id);
						if(boss!=null){
							boss.setBphone(phone);
							if(bossMapper.updateByPrimaryKey(boss)>0){
								returnjson.put("code", 1);
								returnjson.put("info", "手机号绑定成功！");
							}else{
								returnjson.put("code", -1);
								returnjson.put("info", "手机号绑定失败，请重新尝试！");
							}
						}else{
							returnjson.put("code", -1);
							returnjson.put("info", "未登录！");
						}
					}else{
						Member member = memberMapper.selectByPrimaryKey(id);
						if(member!=null){
							member.setMphone(phone);
							if(memberMapper.updateByPrimaryKey(member)>0){
								returnjson.put("code", 1);
								returnjson.put("info", "手机号绑定成功！");
							}else{
								returnjson.put("code", -1);
								returnjson.put("info", "手机号绑定失败，请重新尝试！");
							}
						}else{
							returnjson.put("code", -1);
							returnjson.put("info", "未登录！");
						}
					}
				}else{
					returnjson.put("code", -1);
					returnjson.put("info", "验证码不匹配！");
				}
			}
		}
		replyJson(response, returnjson);
	}
	public HttpSession getHttpSession(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session==null)
			session=request.getSession();
		return session;
	}
	/**
	 * 绑定邮箱号
	 * @throws IOException 
	 * */
	@RequestMapping("/setEmail")
	public void setEmail(String email,String verid,HttpServletResponse response, HttpServletRequest request) throws IOException{
		JSONObject returnjson = new JSONObject();
		HttpSession session = getHttpSession(request);
		User user = (User)session.getAttribute("user");
		if(user==null){
			returnjson.put("code", -1);
			returnjson.put("info", "未登录");
		}else{
			String type = user.getType();
			Boolean sign = false;
			if(type.equals("member")){
				Member member = memberMapper.selectByEmail(email);
				if(member!=null){
					returnjson.put("code", -1);
					returnjson.put("info", "数据库已存在该邮箱，请更换邮箱号再试！");
				}else{
					sign=true;
				}
			}else if(type.equals("boss")){
				Boss boss = bossMapper.selectByEmail(email);
				if(boss!=null){
					returnjson.put("code", -1);
					returnjson.put("info", "数据库已存在该邮箱，请更换邮箱号再试！");
				}else{
					sign=true;
				}
			}else{
				returnjson.put("code", -1);
				returnjson.put("info", "未登录！");
			}
			if(verid==null){
				if(sign){
				int zhuceid = SendSMStool.gentRanNum();
				user.setMa(zhuceid);
				EmailBYBindingThread emailthread = new EmailBYBindingThread(email,zhuceid);
				Thread thread = emailthread;
				thread.start();
				session.setAttribute("user", user);
				returnjson.put("code", 1);
				returnjson.put("info", "验证码发送成功！");
				}
			}else{
				int id = user.getId();
				if(verid.equals(user.getMa()+"")){
					if(type.equals("boss")){
						Boss boss = bossMapper.selectByPrimaryKey(id);
						if(boss!=null){
							boss.setBemail(email);
							if(bossMapper.updateByPrimaryKey(boss)>0){
								returnjson.put("code", 1);
								returnjson.put("info", "邮箱绑定成功！");
							}else{
								returnjson.put("code", -1);
								returnjson.put("info", "邮箱绑定失败，请重新尝试！");
							}
						}else{
							returnjson.put("code", -1);
							returnjson.put("info", "未登录！");
						}
					}else{
						Member member = memberMapper.selectByPrimaryKey(id);
						if(member!=null){
							member.setMemail(email);
							if(memberMapper.updateByPrimaryKey(member)>0){
								returnjson.put("code", 1);
								returnjson.put("info", "邮箱绑定成功！");
							}else{
								returnjson.put("code", -1);
								returnjson.put("info", "邮箱绑定失败，请重新尝试！");
							}
						}else{
							returnjson.put("code", -1);
							returnjson.put("info", "未登录！");
						}
					}
				}else{
					returnjson.put("code", -1);
					returnjson.put("info", "验证码不匹配！");
				}
			}
		}
		replyJson(response, returnjson);
	}
	private void replyJson(HttpServletResponse response, JSONArray j) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(j.toString());// j.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}


	private void replyJson(HttpServletResponse response, com.alibaba.fastjson.JSONObject j) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(j.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}
}
