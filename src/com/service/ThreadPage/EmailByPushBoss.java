package com.service.ThreadPage;

import com.service.OtherPushByHiyoutherService;

public class EmailByPushBoss  implements Runnable{
	private String email;
	private int verid;
	public EmailByPushBoss(String email){
		this.email = email;
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
			i = verControll.pushForBossByApply(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
