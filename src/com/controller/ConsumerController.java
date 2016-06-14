package com.controller;

import java.io.IOException;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.mybatis.entity.Boss;
import com.mybatis.entity.Member;
import com.mybatis.entity.User;
import com.mybatis.mapper.AnswerMapper;
import com.mybatis.mapper.ApplyMapper;
import com.mybatis.mapper.BossMapper;
import com.mybatis.mapper.CollectMapper;
import com.mybatis.mapper.CommentMapper;
import com.mybatis.mapper.HostelMapper;
import com.mybatis.mapper.MemberMapper;
import com.mybatis.mapper.PushMapper;
import com.mybatis.mapper.RecruitMapper;
import com.service.ConsumerService;
import com.service.StaffService;
import com.tool.FianlOssData;
import com.tool.GetPicForWeb;
import com.tool.StringEscapeEditor;


/**
 * @author zy
 *
 */

@RequestMapping("/api")
@Controller
public class ConsumerController {
	@Resource
	ConsumerService c;
	@Resource
	MemberMapper m;
	@Resource
	BossMapper b;
	@Resource
	PushMapper p;
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(String.class, new StringEscapeEditor());
	}
	/**
	 * @param schedule
	 * @param page
	 * @param rows
	 * @param response
	 * @param request
	 */
	@RequestMapping("/getdata")
	public void getData(String schedule, int page, int rows, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if(schedule!=null)
		schedule=Integer.parseInt(schedule)*1000+"";
		// u.getType());
		if (u == null || u.getType().equals("boss")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = c.getData(schedule, u.getId(), page - 1, rows);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/changeMemberPicture")
	public void changeMemberPicture(@RequestParam MultipartFile photo,
			@RequestParam(required = false ) Integer pid,
			int type,String name, HttpServletResponse response, HttpServletRequest request){
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		User u = getSession(request);
		try {
			if (u == null || u.getType().equals("boss")) {
				j.put("code", -1);
				j.put("info", "未登录");
			} else {
				if (type == 0)
					j = c.insertPicture(photo, u.getId(), request, name);
				else
					j = c.updatePicture(photo, u.getId(),  request,name,pid);
			}
			replyJson(response, j);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

			
	/**
	 * @param sex
	 * @param name
	 * @param sign
	 * @param location
	 * @param tag
	 * @param response
	 * @param request
	 */
	@RequestMapping("/insertdata")
	public void insertData(String sex, String name, String sign,
			String location,@RequestParam(value = "tag[]", required = false) String[] tag, 
			HttpServletResponse response,HttpServletRequest request) {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("boss")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = c.insertData(u.getId(), sex, name, sign, location, tag);
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
	@RequestMapping("/insertHead")
	public void insertHead(String touxiang,MultipartFile file, HttpServletResponse response, HttpServletRequest request) {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("boss")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = c.upTouXiang(u.getId(), touxiang,file);
		}
			try {
				replyJson(response, j);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @param realname
	 * @param summary
	 * @param contact
	 * @param response
	 * @param request
	 */
	@RequestMapping("/insertcv")
	public void insertCV(String realname, String summary,String age, String contact, HttpServletResponse response,
			HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("boss")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = c.insertCV(u.getId(), realname, summary, contact,age);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/insertReport")
	public void insertReport(String name, String content,HttpServletResponse response,
			HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("boss")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = c.insertReport(name, content);
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
	@RequestMapping("/cancel")
	public void cancel(int id, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("boss")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = c.cancel(id,u.getId());
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
	@RequestMapping("/deleteApply")
	public void deleteApply(int id, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("boss")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = c.changeApply(id, 4,null);
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
	@RequestMapping("/getcollect")
	public void getCollect(int page, int rows, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("boss")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = c.getCollect(u.getId(), page - 1, rows);
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
	@RequestMapping("/changeApply")
	public void changeApply(int id, int schedule,String refuse, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("boss")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = c.changeApply(id, schedule,refuse);
			
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
	@RequestMapping("/getMcomment")
	public void getMComment(int type, int page, int rows, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("boss")) {
			j.put("code", -1);
			j.put("info", "未登录");
		} else {
			j = c.getMcomment(u.getId(), type, page - 1, rows);
		}
		try {
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

	/**
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/getUserInfo")
	public void getUserInfo(HttpServletResponse response, HttpServletRequest request) throws IOException {
		JSONObject js = new JSONObject();
		HttpSession session = request.getSession();
		try {

			JSONObject js1 = null;
			User user = (User) session.getAttribute("user");
			js1 = (JSONObject) session.getAttribute("userInfo");
			js.put("code", 1);
			js.put("info", "获取成功"); 
			if (user.getType().equals("member")) {
				if(js1==null||js.get("t").equals("1")){
				js1 = new JSONObject();
				Member member = m.selectByPrimaryKey(user.getId());
				js1.put("n", member.getMemname());
				if(member.getMtouxiang()!=null){
				if(member.getMtouxiang().indexOf("http")>=0){
					js1.put("h", member.getMtouxiang());
				}else{
					js1.put("h", GetPicForWeb.getPicUrlForOption(member.getMtouxiang(), 60,FianlOssData.getHeadpicmini()));
				}
				}
				js1.put("pushsize", p.countByM(member.getMid(), "true"));
				js1.put("t", "0");
				}
			} else {
				if(js1==null||js.get("t").equals("0")){
					js1 = new JSONObject();
				Boss boss = b.selectByPrimaryKey(user.getId());
				js1.put("n", boss.getBusername());
				if(boss.getBtouxiang()!=null){
				if(boss.getBtouxiang().indexOf("http")>=0){
					js1.put("h", boss.getBtouxiang());
				}else{
					js1.put("h", GetPicForWeb.getPicUrlForOption(boss.getBtouxiang(), 60,FianlOssData.getHeadpicmini()));
				}
				}
				js1.put("pushsize", p.countByB(boss.getBid(), "true"));
				js1.put("t", "1");
				}
			}

			js.put("data", js1);
			/*
			 * response.addCookie(new Cookie("n",
			 * URLEncoder.encode(member.getMemname(),"UTF-8")));
			 * response.addCookie(new Cookie("h",URLEncoder.encode(
			 * GetPicForWeb.getPicUrl(máember.getMtouxiang(), 60),"UTF-8")));
			 * response.addCookie(new Cookie("t","0"));
			 */
		} catch (Exception e) {
			js.put("code", -1);
			js.put("info", "未登录");
		}
		replyJson(response, js);
	}

	/**
	 * @param response
	 * @param request
	 */
	@RequestMapping("/cancelLogin")
	public void cancelLogin(HttpServletResponse response, HttpServletRequest request) {
		request.getSession().setAttribute("user", null);
		try {
			response.sendRedirect("../html/index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void replyJson(HttpServletResponse response, JSONArray j) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(j.toString());// j.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}

	private void replyJson(HttpServletResponse response, com.alibaba.fastjson.JSONObject j) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(j.toString());// j.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}

	private void replyJson(HttpServletResponse response, JSONObject j) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(j.toString());// j.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}
}
