package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

public class Enter {
	@RequestMapping("/enter")
	public void enter(HttpServletResponse response, HttpServletRequest request) {
		try {
			request.getRequestDispatcher("html/index.html")
			.forward(request, response);
		} 
		catch (ServletException | IOException e) {
		};
	}
}
