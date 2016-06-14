package com.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.aliyun.oss.OSSClient;

/**
 *  * 阿里云oss管理
 * @author forvoid
 * 用于管理阿里云oss文件的查找是否存在和文件的删除
 * @author forvoid
 * 本类用于上传到阿里oss文件和图片
 * 
 * */
public class OssPicAndFileOutput {
	/**
	 * 上传本地文件
	 * */
	public  static void updateLocal(String address,String localAddress){
		OSSClient ossClient = new OSSClient(FianlOssData.getEndpoint(), FianlOssData.getAccesskeyid(), FianlOssData.getAccesskeysecret());

		// 上传文件
		ossClient.putObject(FianlOssData.getBucketname(), address, new File(localAddress));
		// 关闭client
		ossClient.shutdown();
	}
	/**
	 * 文件直接通过前端上传到阿里oss
	 * @throws FileNotFoundException 
	 * */
	public  static void updateWEB(String address,InputStream inputStream) throws FileNotFoundException{
		OSSClient ossClient = new OSSClient(FianlOssData.getEndpoint(), FianlOssData.getAccesskeyid(), FianlOssData.getAccesskeysecret());

		ossClient.putObject(FianlOssData.getBucketname(), address, inputStream);
		// 关闭client
		ossClient.shutdown();
	}
	/**
	 * 阿里oss查询文件是否存在
	 * @throws FileNotFoundException 
	 * */
	public  static Boolean findExist(String address) throws FileNotFoundException{
		OSSClient ossClient = new OSSClient(FianlOssData.getEndpoint(), FianlOssData.getAccesskeyid(), FianlOssData.getAccesskeysecret());

		boolean found = ossClient.doesObjectExist(FianlOssData.getBucketname(), address);
		// 关闭client
		ossClient.shutdown();
		return found;
	}
	/**
	 * 阿里oss删除文件
	 * @throws FileNotFoundException 
	 * */
	public  static void delFile(String address) throws FileNotFoundException{
		OSSClient ossClient = new OSSClient(FianlOssData.getEndpoint(), FianlOssData.getAccesskeyid(), FianlOssData.getAccesskeysecret());
		ossClient.deleteObject(FianlOssData.getBucketname(), address);
		// 关闭client
		ossClient.shutdown();
	}


}
