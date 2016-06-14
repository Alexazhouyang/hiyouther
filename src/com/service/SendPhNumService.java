package com.service;

import java.util.Random;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.regexp.internal.recompile;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
@Service
@Transactional
public class SendPhNumService {
	



	/**
	 * 生成随机数
	 * 生成4位随机数，并且不能超过两个随机数相同
	 * @throws ApiException 
	 * */
	public static int gentRanNum(){
		
		Random random =new Random();
		int RanNum =0000;
		for(int i = 0;i<10000000;i++){
			RanNum =random.nextInt(10000);
			System.out.println(RanNum);
				if(RanNum>999){
					System.out.println(RanNum);
				break;
			}
		}
		
		return RanNum;
	}
	
	public static void main(String[] args) {
		gentRanNum();
	}
	
	
	/**
	 * 验证码发送
	 * @throws ApiException 
	 * */
	public  int sendVerificat(String smsParamString,
			String recNum,String smsTemplateCode) throws ApiException{
		//我的阿里apk帐号和密钥
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "23341845", "ef251d93d61d429d3df9824a1481a7cd");
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		//req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("注册验证");
		req.setSmsParamString(smsParamString);
		req.setRecNum(recNum);
		req.setSmsTemplateCode(smsTemplateCode);
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		JSONObject j=new  JSONObject(rsp.getBody());
		try{
		JSONObject j1=(JSONObject)(j.get("alibaba_aliqin_fc_sms_num_send_response"));
		JSONObject j2=(JSONObject)j1.get("result");
		String j3=(String)j2.get("err_code");
		return 1;}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
}
