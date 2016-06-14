package com.tool;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Date;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;

/**
 * @author forvoid
 * @see 本类用于向阿里云oss系统请求资源url访问
 * 给予前端保存在oss系统中的图片
 * */
public class GetPicForWeb {
	/**
	 * 获取单个资源的url访问权限
	 * 返回url
	 * address:访问文件的地址（jfdslfja/fjlsjfal.jpg）
	 * aged:授权时效，单位：秒。一般控制在6000s以内。
	 * http://hiyouther.img-cn-shanghai.aliyuncs.com/img/boss/87/hotel/1463582963194.jpeg%40!index_hostel_pic
	 * */
	public static String getPicUrl(String address,int aged){
		
		//这是需要权限的部分，由于网站需要2016、5、20封闭
//		 OSSClient client = new OSSClient(FianlOssData.getEndpoint(), FianlOssData.getAccesskeyid(),FianlOssData.getAccesskeysecret());
//		Date expires = new Date (new Date().getTime() + 1000 * aged); // 1 minute to expire
//        GeneratePresignedUrlRequest generatePresignedUrlRequest =
//        new GeneratePresignedUrlRequest(FianlOssData.getBucketname(), address);
//        generatePresignedUrlRequest.setExpiration(expires);
//        URL url = client.generatePresignedUrl(generatePresignedUrlRequest);
//        String returnurl = url.toString();
//        client.shutdown();
		String returnurl="http://hiyouther.oss-cn-shanghai.aliyuncs.com/"+address;
		System.out.println(returnurl);
		return returnurl;
	}
	/**
	 * 获取单个图片的处理样式的访问权限url访问权限
	 * 返回url
	 * address:访问文件的地址和文件访问操作（jfdslfja/fjlsjfal.jpg@！text）
	 * 
	 * aged:授权时效，单位：秒。一般控制在6000s以内。
	 * 
	 * */
	public static String getPicUrlForOption(String address,int aged,String style) {
		if(address==null)
			address="img/etc/init.jpg";
		String returnurl="";
		try {
			if(!OssPicAndFileOutput.findExist(address)){
				returnurl="http://hiyouther.img-cn-shanghai.aliyuncs.com/"+"img/test.jpg"+style;
			}else{
			//这是需要权限的部分，由于网站需要2016、5、20封闭
//		 OSSClient client = new OSSClient(FianlOssData.getPicendpoint(), FianlOssData.getAccesskeyid(),FianlOssData.getAccesskeysecret());
//		Date expires = new Date (new Date().getTime() + 1000 * aged); // 1 minute to expire
//        GeneratePresignedUrlRequest generatePresignedUrlRequest =
//        new GeneratePresignedUrlRequest(FianlOssData.getBucketname(), address+style);
//        generatePresignedUrlRequest.setExpiration(expires);
//        URL url = client.generatePresignedUrl(generatePresignedUrlRequest);
//        String returnurl = url.toString();
//        client.shutdown();
			 returnurl="http://hiyouther.img-cn-shanghai.aliyuncs.com/"+address+style;
			System.out.println(returnurl);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnurl;
	}
}
