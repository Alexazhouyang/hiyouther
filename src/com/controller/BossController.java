package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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

import com.alibaba.fastjson.JSON;
import com.mybatis.entity.Boss;
import com.mybatis.entity.Hostel;
import com.mybatis.entity.Member;
import com.mybatis.entity.Picture;
import com.mybatis.entity.User;
import com.mybatis.mapper.BossMapper;
import com.mybatis.mapper.HostelMapper;
import com.mybatis.mapper.MemberMapper;
import com.mybatis.mapper.PictureMapper;
import com.service.BossService;
import com.service.StaffService;
import com.sun.corba.se.impl.util.Utility;
import com.sun.webkit.Utilities;
import com.tool.ImageCompress;
import com.tool.StringEscapeEditor;


/**
 * @author zy
 *
 */
@RequestMapping("/api")
@Controller
public class BossController {
	@Resource
	BossService b;
	@Resource
	PictureMapper p;
	@Resource
	BossMapper bo;
	@Resource
	HostelMapper h;
	@Resource
	PictureMapper pi;
	@Resource
	com.md5.Md5 md5;
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(String.class, new StringEscapeEditor());
	}
//	@RequestMapping("/fileTool")
//	public void fileTool(HttpServletResponse response, HttpServletRequest request) {
//		List<Picture>  list= p.selectByAll();
//		String path = request.getServletContext().getRealPath("/");
//		JSONObject j = new JSONObject();
//		ImageCompress img=new ImageCompress();
//		img.setProportion(false);
//		j.put("code","chengong");
//		try {
//		for(Picture p:list){
//			long lons=System.currentTimeMillis()+1;
//			File file = new File(request.getServletContext().getRealPath("/"+p.getPicaddress()));
//			File newfile=new File(request.getServletContext().getRealPath("/"+p.getPicaddress().substring(0,p.getPicaddress().lastIndexOf("/")+1)+lons+"."+p.getPicaddress().split("\\.")[1]));
//			file.renameTo(newfile);
//            p.setPicaddress(p.getPicaddress().substring(0,p.getPicaddress().lastIndexOf("/")+1)+lons+"."+p.getPicaddress().split("\\.")[1]);
//            pi.updateByPrimaryKeySelective(p);
//		}
//	
//			replyJson(response, j);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@RequestMapping("/fileTool")
//	public void fileTool(HttpServletResponse response, HttpServletRequest request) {
//		List<Picture>  list= p.selectByFile();
//		String path = request.getServletContext().getRealPath("/");
//		JSONObject j = new JSONObject();
//		ImageCompress img=new ImageCompress();
//		img.setProportion(false);
//		j.put("code","chengong");
//		for(Picture p:list){
//			File file = new File(path+p.getPicaddress());
//			FileInputStream fis;
//
//			String name=p.getPicaddress();
//			FileOutputStream os;
//			
//			if(name!=null&&name.split("\\.").length>1){
//				try {
//					fis = new FileInputStream(file);
//					
//					img.compressPic(fis, path, name.split("\\.")[0]+".min."+name.split("\\.")[1]);
//				
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					j.put("code",e.toString());
//				}
//			}
//		}
//		try {
//			replyJson(response, j);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@RequestMapping("/insertBossByadmin")
	public void insertBossByadmin(String username,String password, HttpServletResponse response, HttpServletRequest request) {
		Boss boss = bo.selectByPhone(username);
		JSONObject j = new JSONObject();
		if (boss != null) {
			j.put("code", 0);
			j.put("info", "数据库已经存在该手机号信息");
		} else{
		boss=new Boss();

		boss.setBcancel(1);
		boss.setBphone(username);
		boss.setBinsettime(new Date());
		boss.setBtouxiang("img/etc/init.jpg");
		boss.setBusername("大柚");
		boss.setBpassword(md5.getMD5(password));
		bo.insertSelective(boss);
		try {
			
			j.put("code", "成功");
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
//	@RequestMapping("/change")
//	public void change(HttpServletResponse response, HttpServletRequest request) {
//		List<Hostel> boss = h.selectByAdmin();
//		JSONObject j = new JSONObject();
//		try {
//			for(Hostel hostel:boss){
//				String tel=hostel.getHphone();
//                com.alibaba.fastjson.JSONObject json=JSON.parseObject(tel);
//                json.put("sjs", true);json.put("wxs", true);json.put("qqs", true);
//				hostel.setHphone(json.toString());
//				h.updateByPrimaryKeySelective(hostel);
//			}
//			j.put("code", "成功");
//			replyJson(response, j);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			j.put("code", "hh");
//			e.printStackTrace();
//		}
//		
//	}
	@RequestMapping("/deleteAllApply")
	public void deleteAllApply(@RequestParam(value = "id[]", required = false)int []id, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("boss")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = b.changeApply(id, 4);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param page
	 * @param rows
	 * @param response
	 * @param request
	 */
	@RequestMapping("/getBossData")
	public void getBossData(int page, int rows, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("member")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = b.getBossData(u.getId(), page - 1, rows);
		}

		try {

			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 * @param name
	 * @param competence
	 * @param rsynopsis
	 * @param task
	 * @param rsctime
	 * @param rmonth
	 * @param number
	 * @param response
	 * @param request
	 */
	@RequestMapping("/insertRecruit")
	public void insertRecruit(int id, String name, String competence, String rsynopsis, String task, String rsctime,
			String rmonth, String number, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("member")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = b.insertRecruit(id, name, competence, rsynopsis, task, rsctime, rmonth, number);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param rid
	 * @param name
	 * @param competence
	 * @param rsynopsis
	 * @param task
	 * @param rsctime
	 * @param rmonth
	 * @param number
	 * @param cancel
	 * @param response
	 * @param request
	 */
	@RequestMapping("/updateRecruit")
	public void updateRecruit(int rid, String name, String competence, String rsynopsis, String task, String rsctime,
			String rmonth, String number, int cancel, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("member")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = b.updateRecruit(rid, name, competence, rsynopsis, task, rsctime, rmonth, number, cancel);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 * @param page
	 * @param rows
	 * @param response
	 * @param request
	 */
	@RequestMapping("/getRecruit")
	public void getRecruit(int id, int page, int rows, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("member")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = b.getRecruit(id, page - 1, rows);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 * @param score
	 * @param response
	 * @param request
	 */
	@RequestMapping("/makeScore")
	public void makeScore(int id, String score, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("member")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = b.makeScore(id, score);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param id
	 * @param schedule
	 * @param response
	 * @param request
	 */
	@RequestMapping("/allRefuse")
	public void allRefuse(@RequestParam(value = "id[]", required = false)int[] id,
			String refuse, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("member")) {
			j.put("code", -1);
			j.put("info", "未登录");
			
		} else {
			j = b.allRefuse(id, refuse);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 * @param schedule
	 * @param response
	 * @param request
	 */
	@RequestMapping("/changeApplyByBoss")
	public void changeApplyByBoss(int id,String refuse, int schedule, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("member")) {
			j.put("code", -1);
			j.put("info", "未登录");
			
		} else {
			j = b.changeApplyByBoss(id, schedule,refuse);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param name
	 * @param address
	 * @param synopsis
	 * @param tag
	 * @param response
	 * @param request
	 */
	@RequestMapping("/insertHotel")
	public void insertHotel(String story,String phone,String name, String address, String synopsis,
			@RequestParam(value = "tag[]", required = false) String[] tag, HttpServletResponse response,
			HttpServletRequest request) {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("member")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = b.insertHotel(story,phone,name, u.getId(), address, synopsis, tag);
		}
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "GET, POST");
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/deleteHotelPicture")
	public void deleteHotelPicture(int pid,HttpServletResponse response, HttpServletRequest request) {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		User u = getSession(request);
	
		try {
			if (u == null || u.getType().equals("member")) {
				j.put("code", -1);
				j.put("info", "未登录");
			} else {
				j = b.deletePicture(pid);
			}
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param photo
	 * @param type
	 * @param id
	 * @param response
	 * @param request
	 */
	@RequestMapping("/changeHotelPicture")
	public void changeHotelPicture(@RequestParam MultipartFile photo, int type, 
			@RequestParam(required = false ) Integer pid,String number,String name,
			@RequestParam(required = false)Integer hid,
			HttpServletResponse response, HttpServletRequest request) {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		User u = getSession(request);
		try {
			if (number==null&&u == null || u.getType().equals("member")) {
				j.put("code", -1);
				j.put("info", "未登录");
			} else {
				if (type == 0)
					j = b.insertPicture(hid,photo, u.getId(), request,number,name);
				else
					j = b.updatePicture(photo, u.getId(), pid, request,number,name);
			}
			replyJson(response, j);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param name
	 * @param address
	 * @param synopsis
	 * @param pauthentic
	 * @param tag
	 * @param id
	 * @param response
	 * @param request
	 */
	@RequestMapping("/updateHotel")
	public void updateHotel(String story,String phone,String name, String address,
			String synopsis, String pauthentic,
			@RequestParam(value = "tag[]", required = false) String[] tag, 
			int id, HttpServletResponse response,
			HttpServletRequest request) {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("member")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = b.updateHotel(story,phone,pauthentic, name, address, synopsis, tag, id);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 * @param response
	 * @param request
	 */
	@RequestMapping("/deleteHotel")
	public void deleteHotel(int id, HttpServletResponse response, HttpServletRequest request) {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("member")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = b.deleteHotel(id);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 * @param page
	 * @param rows
	 * @param schedule
	 * @param response
	 * @param request
	 */
	@RequestMapping("/getApply")
	public void getApply(int id, int page, int rows, String schedule, HttpServletResponse response,
			HttpServletRequest request) {
		JSONObject j = new JSONObject();
		if(schedule!=null)
		schedule=Integer.parseInt(schedule)*1000+"";
		User u = getSession(request);
		if (u == null || u.getType().equals("member")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = b.getApply(id, page - 1, rows, schedule);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param name
	 * @param sex
	 * @param address
	 * @param sign
	 * @param response
	 * @param request
	 */
	@RequestMapping("/updateBossData")
	public void updateBossData(String name, String sex, String address, String sign, HttpServletResponse response,
			HttpServletRequest request) {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("member")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = b.updateBossData(u.getId(), name, sex, address, sign);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param type
	 * @param page
	 * @param rows
	 * @param response
	 * @param request
	 */
	@RequestMapping("/getBcomment")
	public void getBComment(int type, int page, int rows, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("member")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = b.getBcomment(u.getId(), type, page - 1, rows);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param touxiang
	 * @param response
	 * @param request
	 */
	@RequestMapping("/updateTouxiang")
	public void updateTouxiang(String touxiang,MultipartFile file, HttpServletResponse response, HttpServletRequest request) {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("member")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = b.upTouXiang(u.getId(), touxiang,file);
		}
		try {
//			response.setHeader("Access-Control-Allow-Origin", "*");
//			response.setHeader("Access-Control-Allow-Methods", "GET, POST");
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User getSession(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session==null)
			session=request.getSession();
		User u = (User) session.getAttribute("user");
		return u;
	}

	private void replyJson(HttpServletResponse response, JSONArray j) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(j.toString());// j.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}

	private void replyJson(HttpServletResponse response, JSONObject j) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(j.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}

	private void replyJson(HttpServletResponse response, com.alibaba.fastjson.JSONObject j) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(j.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}
}
