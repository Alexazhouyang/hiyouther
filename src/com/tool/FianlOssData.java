package com.tool;
/**
 * @author forvoid
 * 本类用于保存阿里云oss系统的静态数据
 * 
 * */
public class FianlOssData {
	//endpoint与channel同名，访问域名的意思
	private static final String endpoint = "oss-cn-shanghai.aliyuncs.com";
	//endpoint与channel同名，访问域名处理图片的意思
		private static final String picendpoint = "img-cn-shanghai.aliyuncs.com";
	//本账户的用户id
	private static final String accessKeyId = "3CeympXUaiNf2p6B";
	//本账户的用户密钥
	private static final String accessKeySecret = "EfbDkUE0CZqmLQZDgHpRUpueEfqvCw";
	//本项目需要操作的数据库
	private static final String bucketName = "hiyouther";
	/**
	 * 下面的string类型的变量是指定的某一个图片处理的样式。
	 * */
	//类型：详情页面水印样式
	private static final String watermark ="@!hehehe";
	//类型：中型头像
	private static final String headpicu ="@!headpicu";
	//类型：小型头像
	private static final String headpicmini ="@!headpicmini";
	//类型：首页的图片压缩
	private static final String indexhostelpic ="@!index_hostel_pic";
	//类型：身份认证图片压缩
	private static final String verpic ="@!fajfklsXfjkas_fdkfjfdsflQejLKKJSDFIfsljiflakjfdfjlkB";
	public static String getVerpic() {
		return verpic;
	}
	public static String getIndexhostelpic() {
		return indexhostelpic;
	}
	public static String getHeadpicu() {
		return headpicu;
	}
	public static String getHeadpicmini() {
		return headpicmini;
	}
	public static String getWatermark() {
		return watermark;
	}
	public static String getBucketname() {
		return bucketName;
	}
	public static String getPicendpoint() {
		return picendpoint;
	}
	public static String getEndpoint() {
		return endpoint;
	}
	public static String getAccesskeyid() {
		return accessKeyId;
	}
	public static String getAccesskeysecret() {
		return accessKeySecret;
	}
	 
	 
}
