package com.service.ThreadPage;

import com.service.OtherPushByHiyoutherService;

public class EmailBYFindPwdThread extends Thread{
	private String email;
	private int verid;
	public EmailBYFindPwdThread(String email,int verid){
		this.email = email;
		this.verid = verid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getVerid() {
		return verid;
	}
	public void setVerid(int verid) {
		this.verid = verid;
	}public void run() {
		int i = 0;
		try {
			
			OtherPushByHiyoutherService verControll=new OtherPushByHiyoutherService();
			i = verControll.findPwdBYEmail(email, verid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
