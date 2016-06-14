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

import com.alibaba.fastjson.JSON;
import com.mybatis.entity.User;
import com.service.BossService;
import com.service.PushService;
import com.tool.StringEscapeEditor;

/**
 * @author forvoid
 * @version 1.0 用途：网站管理者和网站使用者 如果义工发出申请，老板将收到短信和邮箱通知 ； 如果老板确认招聘，义工将收到短信和邮箱；
 *          如果义工在某处发言，收到回复将会得到邮箱回复 如果老板在某处发言，收到回复将会得到邮箱回复
 *          如果网站管理者发布活动推送，老板和义工将收到邮箱推送信息。
 * 
 *          说明：通过短信和邮箱的形式发送推送消息 推送的格式和文字
 */

@RequestMapping("/api")
@Controller
public class PushMessageController {
	/**
	 * 1、邮箱留言、评论回复提示模块
	 */
	/**
	 * 1、邮箱招聘申请进度回复提示模块
	 */
	/**
	 * 1、短信招聘进度回复提示模块
	 */
	/**
	 * 1、后台推送活动邮箱模块模块
	 */
	@Resource
	PushService p;
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(String.class, new StringEscapeEditor());
	}
	@RequestMapping("/getPush")
	public void getPush(int page, int rows, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u != null && u.getType().equals("member")) {
		j = p.getPush(u.getId(),3, page - 1, rows);
		}else if( u.getType().equals("boss")){
		j = p.getPush(u.getId(),1, page - 1, rows);	
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/isLooked")
	public void isLooked(@RequestParam(value = "id[]", required = false)int[] id, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u== null) {
			j.put("code", -1);
			j.put("info", "未登录");
		}else{
			j = p.isLooked(id);
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
	@RequestMapping("/deletePush")
	public void deletePush(int id, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		if (id == -1) {
			j = p.deletePush(1, 1);

		} else {
			j = p.deletePush(id);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/deleteAllPush")
	public void deleteAllPush(@RequestParam(value = "id[]", required = false)int[] id, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
			j = p.deleteAllPush(id);
		try {
			replyJson(response, j);
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

	private void replyJson(HttpServletResponse response, JSONObject j) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(j.toString());

		response.getWriter().flush();
		response.getWriter().close();
	}
}
