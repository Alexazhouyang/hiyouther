package com.service.ThreadPage;

import java.util.Date;

import javax.annotation.Resource;

import org.json.JSONObject;

import com.mybatis.entity.Member;
import com.mybatis.entity.User;
import com.service.LoginRegisterService;
import com.service.OtherPushByHiyoutherService;

public class EmailThreadForRegister extends Thread{
	private String  account;
	private String  type;	
	private String  pwd;	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public  EmailThreadForRegister(String account,String type,String pwd) {
		this.account = account;
		this.type=type;
		this.pwd= pwd;

	}
	@Resource
	   com.service.LoginRegisterService loginRegisterService;
	@Resource
	   com.mybatis.mapper.MemberMapper memberMapper ;
	@Override
	public void run() {
		int i = 0;
		try {
			
			OtherPushByHiyoutherService verControll=new OtherPushByHiyoutherService();
			System.out.println(account);
			i = verControll.RegisterVerficationBYEmail(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
