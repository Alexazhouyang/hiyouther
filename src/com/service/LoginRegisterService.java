package com.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.md5.Md5;
import com.mybatis.entity.Admin;
import com.mybatis.entity.Boss;
import com.mybatis.entity.Member;
import com.mybatis.mapper.MemberMapper;
/**
*bug:没有设置注册用户建立时间
*@author forvoid
 * 用于用户的登录注册
 * 该类实现了三个方面的类容：hiyouth 帐号的登录 第三方帐号的登录  hiyouth和第三方帐号的创建
 * 主要对象：member、boss、admin
 * 具体实现：hiyouth账户只负责登录，
 * 			第三方帐号登录，要判断如果数据库有值直接取出，如果数据库没有值将为其创建用户信息。
 * 			实现了hiyouth和第三方用户的创建，hiyouth帐号是在方法内加密，第三方登录是在第三方登录处加密。
 * 返回值：code \ info \可选data
 * 还有一下方法：
 * 			1、验证正则表达式 手机号、邮箱。
 * 			2、密码匹配。
 * 注意事项：1、前端需要传给我第三方密码为000000；
 * 
 * */
import com.taobao.api.ApiException;

import jdk.nashorn.internal.runtime.regexp.joni.Matcher;
@Service
@Transactional
public class LoginRegisterService {
    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";
 
    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
 
    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
 
    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";
 
    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";
 
	
	@Resource
	   MemberMapper memberMapper;
	@Resource
	   com.mybatis.mapper.BossMapper bossMapper;
	@Resource
	   Md5 md5;
	@Resource
	   com.mybatis.mapper.AdminMapper adminMapper;
	SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy月MM日dd HH:MM:SS");
	/**
	 * hiyouth登陆
	 * 服务对象：义工\老板\后台
	 * */
	public JSONObject LoginByHiyouth(String type,String option,String account,String pwd) throws ApiException{
		//对pwd加密处理。
		JSONObject loginjs = new JSONObject();
		JSONObject yonghujs = new JSONObject();
		String password = md5.getMD5(pwd);
		
		
		switch (type) {
			case "member":
				Member member =new Member();
				if(option.equals("mobile")){
					member = memberMapper.selectByMphone(account);
					if(member!=null){
						if(passwordPipei(member.getMpassword(), password)){
							loginjs.put("code", 1);
							loginjs.put("info", "手机号登陆验证成功");
							yonghujs.put("id", member.getMid());
							yonghujs.put("name", member.getMemname());
							loginjs.put("data", yonghujs);
						}else{
							loginjs.put("code", -1);
							loginjs.put("info", "密码输入错误");
						}
					}else{
						loginjs.put("code", 0);
						loginjs.put("info", "该用户没有注册义工账号");
					}
				}else if(option.equals("email")){
					
					String b[] =account.split("@");
					if(b.length>1){
					account = b[0]+"\\@"+b[1];
					//account);
					}
					member = memberMapper.selectByEmail(account);
					if(member!=null){
					if(passwordPipei(member.getMpassword(), password)){
						
						if(!member.getMcancel().equals("0")){
							loginjs.put("code", 1);
							loginjs.put("info", "邮箱登陆验证成功");
							yonghujs.put("id", member.getMid());
							yonghujs.put("name", member.getMemname());
						}else{
							loginjs.put("code", -2);
							loginjs.put("info", "邮箱未验证,激活邮件已经再次发送到您的邮箱!请前往收件箱或垃圾箱查看.");
						}
						loginjs.put("data", yonghujs);
					}else{
						loginjs.put("code", -1);
						loginjs.put("info", "密码输入错误");
					}
					}else{
						loginjs.put("code", 0);
						loginjs.put("info", "该用户没有注册义工账号");
					}
				}else{
					loginjs.put("code", -1);
					loginjs.put("info", "登陆失败，帐号不合法");
				}
				break;
			case "boss":
				Boss boss = new Boss();
				if(option.equals("mobile")){
					boss = bossMapper.selectByPhone(account);
					if(boss!=null){
						if(passwordPipei(boss.getBpassword(), password)){
							loginjs.put("code", 1);
							loginjs.put("info", "手机登陆验证成功");
							yonghujs.put("id", boss.getBid());
							yonghujs.put("name",boss.getBusername());
							loginjs.put("data", yonghujs);
						}else{
							loginjs.put("code", -1);
							loginjs.put("info", "密码输入错误");
						}
					}else{
						loginjs.put("code", 0);
						loginjs.put("info", "该客栈老板没有注册手机账号");
					}
				}else  if(option.equals("email")){
					boss = bossMapper.selectByEmail(account);
					if(boss!=null){
						if(passwordPipei(boss.getBpassword(), password)){
							if(boss.getBcancel()!=0){
								loginjs.put("code", 1);
								loginjs.put("info", "邮箱登陆验证成功");
								yonghujs.put("id", boss.getBid());
								yonghujs.put("name", boss.getBrealname());
							}else{
								loginjs.put("code", -2);
								loginjs.put("info", "邮箱未验证,激活邮件已经再次发送到您的邮箱!请前往收件箱或垃圾箱查看.");
							}
							loginjs.put("data", yonghujs);
						}else{
							loginjs.put("code", -1);
							loginjs.put("info", "密码输入错误");
						}
					}else{
						loginjs.put("code", 0);
						loginjs.put("info", "该客栈老板没有邮箱账号");
					}
				}else{
					loginjs.put("code", -1);
					loginjs.put("info", "登陆失败，帐号不合法");
				}
				
				break;
			case "admin":
				Admin admin = adminMapper.selectByAdaccount(account);
				if(admin!=null){
					if(passwordPipei(admin.getAdpassword(), password)){
						loginjs.put("code", 1);
						loginjs.put("info", "管理员验证成功");
					}else{
						loginjs.put("code", -1);
						loginjs.put("info", "密码输入错误");
					}
				}
				else{
					loginjs.put("code", 0);
					loginjs.put("info", "没有该账号信息");
				}
				break;

			default://"不属于以上三种");
			break;
		}
		return loginjs;
	}
	/**
	 * 第三方登陆
	 * 服务对象：义工\老板\
	 * 通过第三方登陆的密码为：000000
	 * @return 
	 * */
	public JSONObject LoginByOther(String type,String channel,String account,String pwd){
		JSONObject loginjs = new JSONObject();
		JSONObject yonghujs = new JSONObject();
		String password = md5.getMD5(pwd);
		switch (channel) {
			case "qq":
				if(type.equals("member")){
					Member	member = memberMapper.selectByQQ(account);
						if(member!=null){
							if(passwordPipei(member.getMpassword(), password)){
								loginjs.put("code", 1);
								loginjs.put("info", "QQ登陆验证成功");
								yonghujs.put("id", member.getMid());
								loginjs.put("data", yonghujs);
							}else{
								loginjs.put("code", -1);
								loginjs.put("info", "密码输入错误");
							}
						}else{
							//"创建帐号中");
							loginjs = this.Register("member", "qq","qq" ,account, password);
						}
				}
				if(type.equals("boss")){
					Boss	boss = bossMapper.selectByQQ(account);
					if(boss!=null){
						if(passwordPipei(boss.getBpassword(), password)){
							loginjs.put("code", 1);
							loginjs.put("info", "QQ登陆验证成功");
							yonghujs.put("id", boss.getBid());
							loginjs.put("data", yonghujs);
						}else{
							loginjs.put("code", -1);
							loginjs.put("info", "密码输入错误");
						}
					}else{
						//"创建帐号中");
						loginjs = this.Register("boss", "qq","qq", account, password);
					}
				}
				break;
			case "weibo":
				if(type.equals("member")){
					Member	member = memberMapper.selectByWeiBo(account);
						if(member!=null){
							if(passwordPipei(member.getMpassword(), password)){
								loginjs.put("code", 1);
								loginjs.put("info", "微博登陆验证成功");
								yonghujs.put("id", member.getMid());
								loginjs.put("data", yonghujs);
							}else{
								loginjs.put("code", -1);
								loginjs.put("info", "密码输入错误");
							}
						}else{
							//"创建帐号中");
							loginjs = this.Register("member", "weibo", "weibo",account, password);
						}
				}
				if(type.equals("boss")){
					Boss	boss = bossMapper.selectByWeiBo(account);
					if(boss!=null){
						if(passwordPipei(boss.getBpassword(), password)){
							loginjs.put("code", 1);
							loginjs.put("info", "微博i登陆验证成功");
							yonghujs.put("id", boss.getBid());
							loginjs.put("data", yonghujs);
						}else{
							loginjs.put("code", -1);
							loginjs.put("info", "密码输入错误");
						}
					}else{
						//"创建帐号中");
						loginjs = this.Register("boss", "weibo","weibo", account, password);
					}
				}
				break;
			case "wechat":
				if(type.equals("member")){
					Member	member = memberMapper.selectByWechat(account);
						if(member!=null){
							if(passwordPipei(member.getMpassword(), password)){
								loginjs.put("code", 1);
								loginjs.put("info", "微信登陆验证成功");
								yonghujs.put("id", member.getMid());
								loginjs.put("data", yonghujs);
							}else{
								loginjs.put("code", -1);
								loginjs.put("info", "密码输入错误");
							}
						}else{
							//"创建帐号中");
							loginjs = this.Register("member", "wechat", "wechat",account, password);
						}
				}
				if(type.equals("boss")){
					Boss	boss = bossMapper.selectByWechat(account);
					if(boss!=null){
						if(passwordPipei(boss.getBpassword(), password)){
							loginjs.put("code", 1);
							loginjs.put("info", "微信登陆验证成功");
							yonghujs.put("id", boss.getBid());
							loginjs.put("data", yonghujs);
						}else{
							loginjs.put("code", -1);
							loginjs.put("info", "密码输入错误");
						}
					}else{
						//"创建帐号中");
						loginjs = this.Register("boss", "wechat", "wechat",account, password);
					}
				}
				break;
	
			default://"不满足类型需求");
				break;
			}
		return loginjs;
	}
	
	//判断密码是否匹配
	public static boolean  passwordPipei(String pwd,String password){
		if(pwd.equals(password)){
			return true;
		}
		return false;
	}
	/**
	 * 注册
	 * 服务对象：义工\老板\type：member\boss
	 * 注册对象：网站注册和第三方注册channel:hiyouth\qq\weibo\wechat
	 * 注意：这里只负责调用用于新增用户，不用于验证消息的判断。只有新增的作用
	 * 通过第三方登陆的密码为：000000
	 * */
	public   JSONObject Register(String type ,String channel,String option,String account,String password){
		JSONObject regisjs= new JSONObject();
		Md5 md5q=new Md5();
		String passwordjiami = md5q.getMD5(password);
		
		JSONObject yonghujs= new JSONObject();
		switch (channel) {
			case "hiyouth":
				if(type.equals("member")){
					if(option.equals("mobile")){
						Member member = memberMapper.selectByMphone(account);
						if(member!=null){
							regisjs.put("code", 0);
							regisjs.put("info", "数据库已经存在该手机号信息");
						}else{
							
							Member newmember = new Member();
							newmember.setMemname("小柚");//帐号（手机）
							newmember.setMphone(account);;//帐号（手机）
							newmember.setMpassword(passwordjiami);//密码
							newmember.setMinsettime(new Date());
							newmember.setMcancel("1");
							newmember.setMtouxiang("img/etc/member.jpg");
							memberMapper.insert(newmember);
							//在xml中 加入useGeneratedKeys="true" keyProperty="mid" 标签用于获取才放入的用户id；
							int mid = newmember.getMid();
							yonghujs.put("id", mid);
							regisjs.put("code", 1);
							regisjs.put("info", "义工通过手机号 添加成功");
							regisjs.put("data", yonghujs);
						}
					}else{
						
						Member member = memberMapper.selectByEmail(account);
						
						if(member!=null){
							regisjs.put("code", 0);
							regisjs.put("info", "数据库已经存在该邮箱信息");
						}else{
							Member newmember = new Member();
							newmember.setMemname("小柚");//帐号（手机）
							newmember.setMemail(account);//帐号（邮箱）
							newmember.setMpassword(passwordjiami);//密码
							newmember.setMcancel("0");
							newmember.setMtouxiang("img/etc/member.jpg");
							newmember.setMinsettime(new Date());
							memberMapper.insertSelective(newmember);
							//在xml中 加入useGeneratedKeys="true" keyProperty="mid" 标签用于获取才放入的用户id；
							int mid = newmember.getMid();
							yonghujs.put("id", mid);
							regisjs.put("code", 1);
							regisjs.put("info", "义工通过邮箱 添加成功");
							regisjs.put("data", yonghujs);
						}
					}
				}
				if(type.equals("boss")){
					if(option.equals("mobile")){
						Boss boss = bossMapper.selectByPhone(account);
						if(boss!=null){
							regisjs.put("code", 0);
							regisjs.put("info", "数据库已经存在该手机号信息");
						}else{
							
							Boss newboss =new Boss();
							newboss.setBusername("大柚");
							newboss.setBphone(account);;//帐号（手机）
							newboss.setBpassword(passwordjiami);//密码
							newboss.setBcancel(1);
							newboss.setBinsettime(new Date());
							newboss.setBtouxiang("img/etc/boss.jpg");
							bossMapper.insert(newboss);
							//在xml中 加入useGeneratedKeys="true" keyProperty="mid" 标签用于获取才放入的用户id；
							int bid = newboss.getBid();
							yonghujs.put("id", bid);
							regisjs.put("code", 1);
							regisjs.put("info", "boss通过手机 添加成功");
							regisjs.put("data", yonghujs);
						}
					}else{
						//"进入bosss");
						Boss boss = bossMapper.selectByEmail(account);
						
						if(boss!=null){
							regisjs.put("code", 0);
							regisjs.put("info", "数据库已经存在该邮箱信息");
						}else{
							Boss newboss =new Boss();
							newboss.setBusername("大柚");
							newboss.setBemail(account);;//帐号（手机）
							newboss.setBpassword(passwordjiami);//密码
							newboss.setBcancel(0);
							newboss.setBtouxiang("img/etc/boss.jpg");
							
							newboss.setBinsettime(new Date());
							bossMapper.insert(newboss);
							//在xml中 加入useGeneratedKeys="true" keyProperty="mid" 标签用于获取才放入的用户id；
							int bid = newboss.getBid();
							yonghujs.put("id", bid);
							regisjs.put("code", 1);
							regisjs.put("info", "boss通过邮箱 添加成功");
							regisjs.put("data", yonghujs);
						}
					}
				}
				break;
			case "qq":
				if(type.equals("member")){
					Member member = memberMapper.selectByQQ(account);
					if(member!=null){
						regisjs.put("code", 0);
						regisjs.put("info", "数据库已经存在该QQ信息");
					}else{
						Member newmember =new Member();
						newmember.setMemname("小柚");
						newmember.setMqq(account);
						newmember.setMcontact("QQ:"+account);
						newmember.setMinsettime(new Date());
						newmember.setMcancel("1");
						memberMapper.insert(newmember);
						//在xml中 加入useGeneratedKeys="true" keyProperty="mid" 标签用于获取才放入的用户id；
						int mid = newmember.getMid();
						yonghujs.put("id", mid);
						regisjs.put("code", 1);
						regisjs.put("info", "义工通过QQ添加成功");
						regisjs.put("data", yonghujs);
					}
				}
				if(type.equals("boss")){
					Boss boss = bossMapper.selectByQQ(account);
					if(boss!=null){
						regisjs.put("code", 0);
						regisjs.put("info", "数据库已经存在QQ信息");
					}else{
						Boss newboss =new Boss();
						newboss.setBusername("大柚");
						newboss.setBqq(account);//帐号（手机）
						newboss.setBcontact("QQ："+account);//常用联系方式
						newboss.setBcancel(1);
						newboss.setBinsettime(new Date());
						bossMapper.insert(newboss);
						//在xml中 加入useGeneratedKeys="true" keyProperty="mid" 标签用于获取才放入的用户id；
						int bid = newboss.getBid();
						yonghujs.put("id", bid);
						regisjs.put("code", 1);
						regisjs.put("info", "boss通过QQ 添加成功");
						regisjs.put("data", yonghujs);
					}
				}
				
				break;
			case "weibo":
				if(type.equals("member")){
					Member member = memberMapper.selectByWeiBo(account);
					if(member!=null){
						regisjs.put("code", 0);
						regisjs.put("info", "数据库已经存在该微博信息");
					}else{
						Member newmember =new Member();
						newmember.setMemname("小柚");
						newmember.setMweibo(account);;
						newmember.setMcontact("微博:"+account);
						newmember.setMinsettime(new Date());
						newmember.setMcancel("1");
						memberMapper.insert(newmember);
						//在xml中 加入useGeneratedKeys="true" keyProperty="mid" 标签用于获取才放入的用户id；
						int mid = newmember.getMid();
						yonghujs.put("id", mid);
						regisjs.put("code", 1);
						regisjs.put("info", "义工通过微博添加成功");
						regisjs.put("data", yonghujs);
					}
				}
				if(type.equals("boss")){
					Boss boss = bossMapper.selectByWeiBo(account);
					if(boss!=null){
						regisjs.put("code", 0);
						regisjs.put("info", "数据库已经存在微博信息");
					}else{
						Boss newboss =new Boss();
						newboss.setBusername("大柚");
						newboss.setBweibo(account);//帐号（手机）
						newboss.setBcontact("微博："+account);//常用联系方式
						newboss.setBcancel(1);
						newboss.setBinsettime(new Date());
						bossMapper.insert(newboss);
						//在xml中 加入useGeneratedKeys="true" keyProperty="mid" 标签用于获取才放入的用户id；
						int bid = newboss.getBid();
						yonghujs.put("id", bid);
						regisjs.put("code", 1);
						regisjs.put("info", "boss通过微博添加成功");
						regisjs.put("data", yonghujs);
					}
				}
				
				break;
			case "wechat":
				if(type.equals("member")){
					Member member = memberMapper.selectByWechat(account);
					if(member!=null){
						regisjs.put("code", 0);
						regisjs.put("info", "数据库已经存在该微信信息");
					}else{
						Member newmember =new Member();
						newmember.setMemname("小柚");
						newmember.setMwechat(account);
						newmember.setMcontact("微信:"+account);
						newmember.setMinsettime(new Date());
						newmember.setMcancel("1");
						memberMapper.insert(newmember);
						//在xml中 加入useGeneratedKeys="true" keyProperty="mid" 标签用于获取才放入的用户id；
						int mid = newmember.getMid();
						yonghujs.put("id", mid);
						regisjs.put("code", 1);
						regisjs.put("info", "义工通过微信添加成功");
						regisjs.put("data", yonghujs);
					}
				}
				if(type.equals("boss")){
					Boss boss = bossMapper.selectByWechat(account);
					if(boss!=null){
						regisjs.put("code", 0);
						regisjs.put("info", "数据库已经存在微信信息");
					}else{
						Boss newboss =new Boss();
						newboss.setBusername("大柚");
						newboss.setBwechat(account);//帐号（手机）
						newboss.setBcontact("微信："+account);//常用联系方式
						newboss.setBcancel(1);
						newboss.setBinsettime(new Date());
						bossMapper.insert(newboss);
						//在xml中 加入useGeneratedKeys="true" keyProperty="mid" 标签用于获取才放入的用户id；
						int bid = newboss.getBid();
						yonghujs.put("id", bid);
						regisjs.put("code", 1);
						regisjs.put("info", "boss通过微信添加成功");
						regisjs.put("data", yonghujs);
					}
				}
				
				break;

			default:
				//"不属于上面的任何一种");
				break;
		}
		return  regisjs;
		
	}
}
