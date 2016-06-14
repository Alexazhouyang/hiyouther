package com.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybatis.entity.User;
import com.mybatis.mapper.CollectMapper;
import com.service.BossService;
import com.service.JspService;
import com.tool.StringEscapeEditor;

import net.sf.cglib.proxy.Dispatcher;

/**
 * @author zy
 *
 */
@RequestMapping("/api")
@Controller
public class JspController {
	@Resource
	JspService j;
	@Resource
	CollectMapper co;
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(String.class, new StringEscapeEditor());
	}
	/**
	 * @param id
	 * @param response
	 * @param request
	 */
	@RequestMapping("/infoJSP")
	public void infoJSP(int id,HttpServletResponse response, HttpServletRequest request) {

			j.infoJSP(id, request,response);

	}

	/**
	 * @param response
	 * @param request
	 */
	@RequestMapping("/memberJSP")
	public void memberJSP(HttpServletResponse response, HttpServletRequest request) {
		try {
			
			User u = getSession(request);
			if (u != null && !u.getType().equals("boss")) {
				j.memberJSP(u.getId(), request);
				response.sendRedirect("../html/me/index.jsp");
			} else {
				response.sendRedirect("../html/index.html");
			}
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
	 */
	@RequestMapping("/bossJSP")
	public void bossJSP(HttpServletResponse response, HttpServletRequest request) {
		try {
			User u = getSession(request);

			if (u != null && !u.getType().equals("member")) {
				j.bossJSP(u.getId(), request);
				response.sendRedirect("../html/host/index.jsp");
			} else {
				response.sendRedirect("../html/index.html");
			}
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
	@RequestMapping("/hostelJSP")
	public void hostelJSP(int id, HttpServletResponse response, HttpServletRequest request) {
		try {
			j.hostelJSP(id, request);
			response.sendRedirect("../html/host/profile.jsp?id=" + id);
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
	@RequestMapping("/recruitJSP")
	public void recruitJSP(int id, HttpServletResponse response, HttpServletRequest request) {
		try {
			j.recruitJSP(id, request);
			response.sendRedirect("../html/host/recruit.jsp?id=" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
