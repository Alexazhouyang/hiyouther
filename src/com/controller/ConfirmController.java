package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.mybatis.entity.User;
import com.tool.FianlOssData;
import com.tool.GetPicForWeb;
import com.tool.OssPicAndFileOutput;
import com.tool.StringEscapeEditor;

/**
 * @author forvoid
 * 本类用作验证控制类型
 * 服务对象为，客栈、boss、义工（义工或者老板的类型从seesion中获取）
 * */
@RequestMapping("/api")
@Controller
public class ConfirmController {
	@Resource
 	com.service.GetConfirmService getconfirm;
	@Resource
 	com.service.SumConfirmService sumConfirmService;
	@Resource
 	com.service.SetConfirmService setConfirmService;
	/**
	 * 得到初始化值
	 * */
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(String.class, new StringEscapeEditor());
	}
	 @RequestMapping("/getcomfirm")
	 public void findComfir(String hotelid,HttpServletResponse response,HttpServletRequest request) throws IOException{
		 HttpSession session = getSession(request);
		 com.alibaba.fastjson.JSONObject js3 =new com.alibaba.fastjson.JSONObject();
		 User user=(User)session.getAttribute("user");
		 if(user==null){
			 js3.put("code",-1);
			 js3.put("info","未登录");
		 replyJson(response, js3);
		 }else{
			 String type = user.getType();
			 int userid =user.getId();
			 
			 if(type.equals("boss")){
				 com.alibaba.fastjson.JSONObject js1 = getconfirm.bossComfSerch(userid);
				 com.alibaba.fastjson.JSONObject js2 =new com.alibaba.fastjson.JSONObject();
				 if(hotelid!=null){
				  js2 = getconfirm.hostelConfirmSerch(Integer.parseInt(hotelid));
				 }
				 js3.put("boss", js1);
				 js3.put("hostel", js2);
				 replyJson(response, js3);
			 }else{
				 com.alibaba.fastjson.JSONObject js = getconfirm.memberComfSerch(userid);
				 replyJson(response, js);
		 }
		 }
		 
	 }
	public HttpSession getSession(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session==null)
			session=request.getSession();
		return session;
	}

	/* idval
		{funKey = xxx}
		{type = head/back/hand/all}
		<script>
			top.{funKey = xxx}(url)
		</script>

		busval
		{funKey = xxx}
		{type = head/back/hand/zhizhao/all}

		<script>
			top.{funKey = xxx}(url)
		</script>

	{
		info,
		message
	}*/
	 @RequestMapping("/subidval")
		public void subidval(String realname,String idcard_num,HttpServletResponse response,HttpServletRequest request) throws IOException{
			 HttpSession session = getSession(request);
			 User user=(User)session.getAttribute("user");
			 com.alibaba.fastjson.JSONObject js = new com.alibaba.fastjson.JSONObject();
			 if(user==null){
				 js.put("code",-1);
				 js.put("info","未登录");
				 replyJson(response, js);
			}else{
				 String userType =user.getType();
				 int userid =user.getId();
				 if(userType.equals("member")){
					 
						 js =  sumConfirmService.SubAndMemberConfir(userid, realname, idcard_num);
						 replyJson(response, js);
					
				 }else{//老板的验证方式
					
					 js =  sumConfirmService.SubAndBossConfir(userid, realname, idcard_num);
					 replyJson(response, js);
					 
				 }
			 }
			
			 
	        
		 }
	 /**
	  * 义工或者老板提交图片和信息
	  * 需要提交的内容为 身份证号、姓名、图片名称【】,【】,【】
	 * @throws IOException 
	  * */
	 @RequestMapping("/idval")
	public void submitConfir(String realname,String idcard_num,
			String funKey,String type,String hid, MultipartFile file,HttpServletResponse response,HttpServletRequest request) throws IOException{
		 HttpSession session = getSession(request);
		 User user=(User)session.getAttribute("user");
		 com.alibaba.fastjson.JSONObject js = new com.alibaba.fastjson.JSONObject();
		 if(user==null){
			 js.put("code",-1);
			 js.put("info","未登录");
			 replyJson(response, js);
		}else{
			 String userType =user.getType();
			 int userid =user.getId();
			 if(userType.equals("member")){
				 //本地上传
//					 String path=request.getRealPath("/img/"+userType+"/"+userid+"/"+"idcard");
//					 File files = new File(path);
//					 files.mkdirs();
//					 File newfile=new File(path+"/"+type+".jpg");
//					 file.transferTo(newfile);
				 //上传阿里云oss
				 String path ="img/"+userType+"/"+userid+"/"+"idcard/"+type+".jpg";
				 if(sumConfirmService.checkForUpdateOss(userType, userid,path)){
					 if(OssPicAndFileOutput.findExist(path)){
						 OssPicAndFileOutput.delFile(path);
						 OssPicAndFileOutput.updateWEB(path, file.getInputStream());
					 }else{
						 OssPicAndFileOutput.updateWEB(path, file.getInputStream());
					 }
				 }
					 //js =  sumConfirmService.picSub(userid, userType, "/img/"+userType+"/"+userid+"/"+"idcard/"+type+".jpg");
					 String html = " <script> top."+funKey+"(\""+GetPicForWeb.getPicUrlForOption(path, 60,FianlOssData.getVerpic() )+"\")</script>";
					 response.getWriter().write(html);
					 response.getWriter().flush();
					 response.getWriter().close();
			 }else{//老板的验证方式
				 //本地上传
				 String html=null;
//					 String path="/img/"+userType+"/"+userid+"/"+"idcard");
//					 File files = new File(path);
//					 files.mkdirs();
//					 File newfile=new File(path+"/"+type+".jpg");
//					 file.transferTo(newfile);
					 if(!type.equals("zhizhao")){
						 String path ="img/"+userType+"/"+userid+"/"+"idcard/"+type+".jpg";
						 //js =  sumConfirmService.picSub(userid, userType, "/imger/"+userType+"/"+userid+"/"+"idcard/"+type+".jpg");
						 if(sumConfirmService.checkForUpdateOss(userType, userid,path)){
							 if(OssPicAndFileOutput.findExist(path)){
								 OssPicAndFileOutput.delFile(path);
								 OssPicAndFileOutput.updateWEB(path, file.getInputStream());
							 }else{
								 OssPicAndFileOutput.updateWEB(path, file.getInputStream());
							 }
						 } 
						  html = " <script> top."+funKey+"(\""+GetPicForWeb.getPicUrlForOption(path, 60,FianlOssData.getVerpic() )+"\")</script>";
					 }else{
						 String path = "img/"+userType+"/"+userid+"/"+"hostel/buslic/"+type+".jpg";
						 sumConfirmService.sumHostelConfirm(Integer.parseInt(hid),path);
						 if(OssPicAndFileOutput.findExist(path)){
							 OssPicAndFileOutput.delFile(path);
							 OssPicAndFileOutput.updateWEB(path, file.getInputStream());
						 }else{
							 OssPicAndFileOutput.updateWEB(path, file.getInputStream());
						 }
						 html = " <script> top."+funKey+"(\""+GetPicForWeb.getPicUrlForOption(path, 60,FianlOssData.getVerpic())+"\")</script>";
					 }
					 response.getWriter().write(html);
					 response.getWriter().flush();
					 response.getWriter().close();
			 }
		 }
		
		 
        
	 }
//	 @RequestMapping("/submitHotelConfir")
//	 public void submitHotelConfir(String hotelid,String zhizhao,HttpServletResponse response,HttpServletRequest request) throws IOException{
//		 HttpSession session = request.getSession();
//		 com.alibaba.fastjson.JSONObject js =new com.alibaba.fastjson.JSONObject();
//		 User user=(User)session.getAttribute("user");
//		 //"---------------");
//		 if(user==null){
//			 js.put("code",-1);
//			 js.put("info","未登录");
//		 replyJson(response, js);
//		 }else{
//			 int userid = user.getId();
//			 js =  sumConfirmService.sumHostelConfirm(userid, Integer.parseInt(hotelid), zhizhao);
//		 }
//		 response.setHeader("Access-Control-Allow-Origin", "*");
//         response.setHeader("Access-Control-Allow-Methods", "GET, POST");
//         replyJson(response, js);
//	 }
	 /**
	  * 后台管理查找所有验证数据
	  * 获取所有的根据 type:boss\member\hostel 
	  * 		option:(申请通过的、申请正在进行的、申请失败的)pass\ongoing\fail
	  * */
	 @RequestMapping("/getAllConfirm")
	 public void getAllConfirm(String type,String option,HttpServletResponse response,HttpServletRequest request) throws IOException{
		 com.alibaba.fastjson.JSONObject js = setConfirmService.findAllConfirm(type, option);
			
         replyJson(response, js);
	 }
	 /**
	 * 本类用于查找单个用户或者旅店的具体信息
	 * 需要传入 id:旅店或者个人用户；type类型：boss\member\hostel用于查找用户；
	 * */
	 @RequestMapping("/findConfirmByUserid")
	 public void findConfirmByUserid(String id,String type,HttpServletResponse response,HttpServletRequest request) throws IOException{
		 com.alibaba.fastjson.JSONObject js = setConfirmService.findConfirmByUserid(id, type);
			
         replyJson(response, js);
	 }
	 /**
		 * 通过义工、老板、旅店身份验证请求
		 * 需要传入的参数有：type:类型boss\member\hostel ; id:用户id;
		 * */
	 @RequestMapping("/passConfirm")
	 public void passConfirm(String id,String type,HttpServletResponse response,HttpServletRequest request) throws IOException{
		 com.alibaba.fastjson.JSONObject js = setConfirmService.passConfirm(id, type);
			
         replyJson(response, js);
	 }
	 /**
		 * 通过义工、老板、旅店请求
		 * 需要传入的参数有：type:类型boss\member\hostel ; id:用户id;
		 * */
	 @RequestMapping("/unPassConfirm")
	 public void unPassConfirm(String id,String type,HttpServletResponse response,HttpServletRequest request) throws IOException{
		 com.alibaba.fastjson.JSONObject js = setConfirmService.unPassConfirm(id, type);
			
         replyJson(response, js);
	 }
	 
	
		 private void replyJson(HttpServletResponse response, com.alibaba.fastjson.JSONObject js1)
					throws IOException {
				response.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8"); 
				response.getWriter().write(js1.toString());System.out.println(js1.toString());
				response.getWriter().flush();
			}
			private void replyJson(HttpServletResponse response, JSONObject j)
					throws IOException {
				response.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8"); 
				response.getWriter().write(j.toString());System.out.println(j.toString());
				response.getWriter().flush();
				
			}
			
			
			
			
}
