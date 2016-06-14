package com.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.md5.DesUtil;
import com.mybatis.entity.Boss;
import com.mybatis.entity.Member;
import com.mybatis.entity.User;
import com.taobao.api.ApiException;
import com.tool.EMAILtool.SendEmailTool;
import com.tool.SMS.SendSMStool;


/**短信和邮箱模版类
 * api：操作验证
 * 方式：短信和邮箱
 * 用途：用于用户操作验证
 * */
@Service
@Transactional
public class OtherPushByHiyoutherService {
	
   @Resource
   SendSMStool verPhNum;
   SendEmailTool verEmail;
   @Resource
   DesUtil DES;
   @Resource
   com.mybatis.mapper.MemberMapper memberMapper;
   @Resource
   com.mybatis.mapper.BossMapper bossMapper;
   //时间转换器
	SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy月MM日dd HH时MM分ss秒");
   	/*短信推送平台v1.1*/
	/**
	 * api：/RegisterVerfication:注册验证（老板）
	 * 用途：
	 * 模板内容:
	 *验证码为${zhuceid}，亲爱的老板，您的手机号${phone}正在注册嗨柚，嗨柚旅行轻轻松松帮您找义工~~，非本人操作，请忽略本短信 。 
	 * @throws ApiException 
	 * */
	public int RegisterBYPhoneForBoss(String phoneNember,int zhuceid) throws Exception{
		
				String SmsParamString = "{\"zhuceid\":\""+zhuceid+"\",\"phone\":\""+phoneNember+"\"}";
				String SmsTemplateCode ="SMS_10140426";
				return verPhNum.sendVerificat(SmsParamString,phoneNember,SmsTemplateCode);
	}
	/**
	 * api：/RegisterVerfication:注册验证(义工)
	 * 用途：
	 * 模板内容:
	 *验证码是${zhuceid}。青春短暂，嗨柚作伴~！你的手机正在嗨柚进行验证~义工旅行当然要认准嗨柚~非本人操作，请无视本条短信！ 
	 * @throws ApiException 
	 * */
	public int RegisterBYPhoneForMember(String phoneNember,int zhuceid) throws Exception{
		
				String SmsParamString = "{\"zhuceid\":\""+zhuceid+"\"}";
				String SmsTemplateCode ="SMS_10160309";
				return verPhNum.sendVerificat(SmsParamString,phoneNember,SmsTemplateCode);
	}
	/**
	 * api：/findPwdBYPhone:用于用户通过手机号找回密码
	 * 用途：用于
	 * 模板内容:
	 *验证码：${yanzheng}，亲~您的手机号${phone}正在进行嗨柚旅行的密码修改，非本人操作，请忽略本短信吧~~  
	 * @throws ApiException 
	 * */
	public int findPwdBYPhone(String phoneNember,int yanzheng) throws Exception{
		
				String SmsParamString = "{\"yanzheng\":\""+yanzheng+"\",\"phone\":\""+phoneNember+"\"}";
				String SmsTemplateCode ="SMS_10150770";
				return verPhNum.sendVerificat(SmsParamString,phoneNember,SmsTemplateCode);
	}
	/**
	 * api：/alppyBossPush:用于每条都通知老板义工申请
	 * 用途：用于
	 * 模板内容:
	 *亲爱的${bossname}，小义工已经等你等疯啦，你还不来看看吗？我们是嗨柚，为您服务！(www.hiyouther.com) 
	 * @throws ApiException 
	 * */
	public int alppyBossPush(String phoneNember,String bossname) throws Exception{
		
				String SmsParamString = "{\"bossname\":\""+bossname+"\"}";
				String SmsTemplateCode ="SMS_10180196";
				return verPhNum.sendVerificat(SmsParamString,phoneNember,SmsTemplateCode);
	}
	/**
	 * 未启用
	 * 用途：用于用户绑定或者换绑手机号接收短信
	 * 模板内容:
	 *亲爱的${bossname}，小义工已经等你等疯啦，你还不来看看吗？我们是嗨柚，为您服务！(www.hiyouther.com) 
	 * @throws ApiException 
	 * */
	public int bandingPhone(String phoneNember,String yanzheng) throws Exception{
		
		String SmsParamString = "{\"yanzheng\":\""+yanzheng+"\"}";
		String SmsTemplateCode ="SMS_10180196";
		return verPhNum.sendVerificat(SmsParamString,phoneNember,SmsTemplateCode);
	}
	/**
	 * 用途：用于通知义工你的简历已经通过了老板的审核
	 * 模板内容:
	 *恭喜恭喜~~您被${hostel}录取啦！赶快打点行装，准备出发吧~！青春短暂，嗨柚作伴~！(www.hiyouther.com)
	 * @throws ApiException 
	 * */
	public int pushByMemberForPass(String phoneNember,String hostel) throws Exception{
		
		String SmsParamString = "{\"hostel\":\""+hostel+"\"}";
		String SmsTemplateCode ="SMS_10295375";
		return verPhNum.sendVerificat(SmsParamString,phoneNember,SmsTemplateCode);
	}
   	/*短信推送平台完毕*/
	/*邮件推送平台*/ 
	/**
	 * api：
	 * 用途：用于用户邮箱验证首次发送邮件
	 * @throws Exception 
	 * @throws ApiException 
	 * */
	public int RegisterVerficationBYEmail(String email) throws Exception{
		int i=0;
		try{
			System.out.println(email);
			SendEmailTool ss =new SendEmailTool();
		String title= "嗨柚旅行注册邮箱验证";
		String newtime = simpleDate.format(new Date());
		String verWebAddress ="<a href='" +"http://hiyouther.com/api/EmailVer?option=ver&emailname="+URLEncoder.encode(email,"utf-8")+"'>"+"验证hiyouther账号"+"</a>";
		String content = "     尊敬的用户欢迎你使用嗨柚旅行邮箱验证！\n"+"请点击验证，完成验证"+verWebAddress+"。\n"+"嗨柚旅行"+newtime;
		i= ss.sendEmail(title, content, email);
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return i;
	}
	/**
	 * v1.0
	 * api：/emailver:邮箱验证
	 * 用途：用于用户邮箱的验证
	 * @throws ApiException 
	 * */
	public JSONObject emailVer(String email) throws ApiException{
		JSONObject js =new JSONObject();
		JSONObject loinjs =new JSONObject();
		Member member = memberMapper.selectByEmail(email);
		Boss boss = bossMapper.selectByEmail(email);
		if(member!=null){
			member.setMcancel("1");
			memberMapper.updateByPrimaryKey(member);
			js.put("code", 1);
			js.put("info", "义工邮箱验证成功");
			loinjs.put("id", member.getMid());
			loinjs.put("email", member.getMemail());
			js.put("data", loinjs);
			
		}
		if(boss!=null){
			boss.setBcancel(1);
			bossMapper.updateByPrimaryKey(boss);
			js.put("code", 1);
			js.put("info", "老板邮箱验证成功");
			loinjs.put("id", boss.getBid());
			loinjs.put("email", boss.getBemail());
			js.put("data", loinjs);
			
		}
		return	js;
	}
	/**
	 * api：
	 * 用途：用于用户通过邮件找回密码
	 * @throws Exception 
	 * @throws ApiException 
	 * */
	public int findPwdBYEmail(String email,int verid) throws Exception{
		int i=0;
		try{
			System.out.println(email);
			SendEmailTool ss =new SendEmailTool();
		String title= "嗨柚旅行邮箱找回密码验证码";
		String newtime = simpleDate.format(new Date());
		String content = "     尊敬的用户欢迎你使用嗨柚旅行邮箱验证找回密码服务！\n"+"你的验证码是："+verid+"请进入网站输入验证码后，修改您的密码。\n"+"嗨柚旅行"+newtime;
		i= ss.sendEmail(title, content, email);
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return i;
	}
	/**
	 * api：
	 * 用途：用于用户通过邮件绑定
	 * @throws Exception 
	 * @throws ApiException 
	 * */
	public int bindingEmail(String email,int verid) throws Exception{
		int i=0;
		try{
			System.out.println(email);
			SendEmailTool ss =new SendEmailTool();
		String title= "嗨柚旅行邮箱验证码";
		String newtime = simpleDate.format(new Date());
		String content = "     尊敬的用户欢迎你使用嗨柚旅行邮箱验证绑定邮件服务！\n"+"你的验证码是："+verid+"请进入网站输入验证码后，绑定您的邮箱。\n"+"嗨柚旅行"+newtime;
		i= ss.sendEmail(title, content, email);
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return i;
	}
	/*邮件推送平台完毕*/ 
	
	/**
	 * api：
	 * 用途：通知用户您收到了一封新的简历。
	 * @throws Exception 
	 * @throws ApiException 
	 * */
	public int pushForBossByApply(String email) throws Exception{
		int i=0;
		try{
			System.out.println(email);
			SendEmailTool ss =new SendEmailTool();
		String title= "嗨柚旅行简历提示";
		String newtime = simpleDate.format(new Date());
		String content = "     尊敬的用户，您收到了一封简历，快去网站看看吧（www.hiyouther.com）。\n"+"嗨柚旅行"+newtime;
		i= ss.sendEmail(title, content, email);
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return i;
	}
	/**
	 * api：
	 * 用途：用于用户通过招聘提示
	 * @throws Exception 
	 * @throws ApiException 
	 * */
	public int pushMemberForApply(String email,String hostel) throws Exception{
		int i=0;
		try{
			System.out.println(email);
			SendEmailTool ss =new SendEmailTool();
		String title= "嗨柚旅行邮箱验证码";
		String newtime = simpleDate.format(new Date());
		String content = "     尊敬的用户,您的简历已经被"+hostel+"通过了,快去看看吧（www.hiyouther.com）。\n"+"嗨柚旅行"+newtime;
		i= ss.sendEmail(title, content, email);
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return i;
	}

}
