package com.tool;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;

/**
 * @author forvoid
 * 获取上传文件或者图片的权限
 * */
public class GetUpPowForWEB {
	/**
	 * 获得上传图片的权利
	 * dir:把图片放在dir目录下
	 * aged:授权时效，单位：秒。一般控制在6000s以内
	 * */
	public static JSONObject getUpPicPow(String dir,int aged){
		
	        
	        String host = "http://" + FianlOssData.getBucketname() + "." + FianlOssData.getEndpoint();
	        System.out.println("erewrew");
	        OSSClient client = new OSSClient(FianlOssData.getEndpoint(), FianlOssData.getAccesskeyid(), FianlOssData.getAccesskeysecret());
	        try { 	
	        	long expireEndTime = System.currentTimeMillis() + aged * 1000;
	            Date expiration = new Date(expireEndTime);
	            PolicyConditions policyConds = new PolicyConditions();
	            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
	            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

	            String postPolicy = client.generatePostPolicy(expiration, policyConds);
	            byte[] binaryData = postPolicy.getBytes("utf-8");
	            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
	            String postSignature = client.calculatePostSignature(postPolicy);
	            
	            JSONObject respMap = new JSONObject();
	            respMap.put("accessid", FianlOssData.getAccesskeyid());
	            respMap.put("policy", encodedPolicy);
	            respMap.put("signature", postSignature);
	            //respMap.put("expire", formatISO8601Date(expiration));
	            respMap.put("dir", dir);
	            respMap.put("host", host);
	            respMap.put("expire", String.valueOf(expireEndTime / 1000));
	            
	           client.shutdown();
	            System.out.println(respMap.toString());
	            //注意返回跨域条件
	            /*response.setHeader("Access-Control-Allow-Origin", "*");
	            response.setHeader("Access-Control-Allow-Methods", "GET, POST");
	            response(request, response, respMap.toString());*/
	            return respMap;
	        }catch(Exception e){
	        	 e.printStackTrace();
	        }
			return null;
	}
	
}
