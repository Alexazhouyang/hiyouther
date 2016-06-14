package com.service;

import java.io.IOException;
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


/**短信和邮箱模版类
 * api：操作验证
 * 方式：短信和邮箱
 * 用途：用于用户操作验证
 * */
@Service
@Transactional
public class VerificationController {
	
   @Resource
   SendPhNumService verPhNum;
   @Resource
   SendEmailService verEmail;
   @Resource
   DesUtil DES;
   @Resource
   com.mybatis.mapper.MemberMapper memberMapper;
   @Resource
   com.mybatis.mapper.BossMapper bossMapper;
	/**
	 * api：/LoginVerfication:登录验证
	 * 用途：用于异常登录或者用户验证
	 * @throws ApiException 
	 * */
	
	public void LoginVerfication(String phoneNember) throws ApiException{
		//短信验证方式
			
		
	}
	/**
	 * api：/RegisterVerfication:注册验证
	 * 用途：用于用户首次验证
	 * 模板内容:
	 *注册码：${zhuceid}。亲爱的用户，你手机号:${phone}，正在进行嗨柚旅行的注册。如果不是本人操作，请忽略本条短信。 
	 * @throws ApiException 
	 * */
	SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy月MM日dd HH:MM:SS");
	
	public int RegisterVerficationBYPhone(String phoneNember,int zhuceid) throws Exception{
		
				String SmsParamString = "{\"zhuceid\":\""+zhuceid+"\",\"phone\":\""+phoneNember+"\"}";
				String SmsTemplateCode ="SMS_7430182";
				return verPhNum.sendVerificat(SmsParamString,phoneNember,SmsTemplateCode);
	}
	/**
	 * api：
	 * 用途：用于用户邮箱验证
	 * @throws ApiException 
	 * */
	public int RegisterVerficationBYEmail(String email) throws Exception{
		String title= "嗨柚旅行邮箱验证";
		String newtime = simpleDate.format(new Date());
		String verWebAddress ="<a>" +"http://hiyouther.com/api/EmailVer/"+DesUtil.encrypt(email, "forvoid@hiyouth")+"</a>";
		String content = "     尊敬的用户欢迎你使用嗨柚旅行邮箱验证！\n"+"请点击验证网址完成验证"+verWebAddress+"。\n"+"嗨柚旅行"+newtime;
		return verEmail.sendEmail(title, content, email);
	}
	/**
	 * api：/ResetPwdVerfication:重置密码验证
	 * 用途：用于用户首次验证
	 * @throws ApiException 
	 * */
	@RequestMapping("/ResetPwdVerfication")
	public void ResetPwdVerfication(String phoneNember) throws ApiException{
		//短信验证方式
				String recNum =phoneNember;
				int zhuceid= SendPhNumService.gentRanNum();
				String SmsParamString = "{\"code\":\""+zhuceid+"\",\"product\":\""+recNum+"\"}";
				String SmsTemplateCode ="SMS_7425135";
				verPhNum.sendVerificat(SmsParamString,recNum,SmsTemplateCode);
	}
	/**
	 * api：/EnteredVerfication:报名验证验证
	 * 用途：用于用户报名验证
	 * @throws ApiException 
	 * */
	
	public void EnteredVerfication(String phoneNember) throws ApiException{
		//短信验证方式
				String recNum =phoneNember;
				int zhuceid= SendPhNumService.gentRanNum();
				String SmsParamString = "{\"code\":\""+zhuceid+"\",\"product\":\""+recNum+"\"}";
				String SmsTemplateCode ="SMS_7425135";
				verPhNum.sendVerificat(SmsParamString,recNum,SmsTemplateCode);
	}
	/**
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
			js.put("info", "义工邮箱验证成功");
			loinjs.put("id", member.getMid());
			loinjs.put("email", member.getMemail());
			js.put("data", loinjs);
			return js;
		}
		if(boss!=null){
			boss.setBcancel(1);
			bossMapper.updateByPrimaryKey(boss);
			js.put("code", 1);
			js.put("info", "老板邮箱验证成功");
			loinjs.put("id", boss.getBid());
			loinjs.put("email", boss.getBemail());
			js.put("data", loinjs);
			return js;
		}
		js.put("code", -1);
		js.put("info","无法找到该用户邮箱信息，请点击再次发送邮件验证" );
		return	js;
	}
	
}
