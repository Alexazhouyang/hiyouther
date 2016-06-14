package com.service.ThreadPage;

import com.service.OtherPushByHiyoutherService;

public class EmailByMemberPass implements Runnable{
	private String email;
	private String hostel;
	public EmailByMemberPass(String email,String hostel){
		this.email = email;
		this.hostel = hostel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVerid() {
		return hostel;
	}
	public void setVerid(String hostel) {
		this.hostel = hostel;
	}
	public void run() {
		int i = 0;
		try {
			
			OtherPushByHiyoutherService verControll=new OtherPushByHiyoutherService();
			i = verControll.pushMemberForApply(email, hostel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
