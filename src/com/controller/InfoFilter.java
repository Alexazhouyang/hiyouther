package com.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mybatis.entity.Hostel;
import com.mybatis.entity.Picture;
import com.mybatis.entity.RecruitWithBLOBs;
import com.mybatis.entity.User;
import com.mybatis.mapper.CollectMapper;
import com.mybatis.mapper.HostelMapper;
import com.mybatis.mapper.PictureMapper;
import com.mybatis.mapper.RecruitMapper;
import com.service.JspService;


public class InfoFilter implements Filter {



	


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
	
		int rid=Integer.parseInt(request.getParameter("id"));

		try{
			HostelMapper h=(HostelMapper) wac.getBean("hostelMapper");
			RecruitMapper r=(RecruitMapper) wac.getBean("recruitMapper");
			CollectMapper co=(CollectMapper) wac.getBean("collectMapper");
			PictureMapper p=(PictureMapper) wac.getBean("pictureMapper");
			HttpSession info_session=request.getSession(false);
			if(info_session==null)
				info_session=request.getSession();
		    RecruitWithBLOBs recruit=r.selectByPrimaryKey(rid);
		    User u=(User)request.getSession().getAttribute("user");
		 if(u==null||u.getType().equals("boss")){
			 info_session.setAttribute("ifCollect", "0");
		}else{
					if(co.ifCollect(u.getId()+"",rid+"").size()>0)
						info_session.setAttribute("ifCollect", "1");
					else
						info_session.setAttribute("ifCollect", "0");
	    }
		if(recruit!=null){
		Hostel hostel=h.selectByPrimaryKey(recruit.getHid());
		if(hostel!=null){
		info_session.setAttribute("hostel",hostel);
		info_session.setAttribute("recruit",recruit);
		List<Picture>  pi=p.selectByExample(recruit.getHid()+"");
		info_session.setAttribute("picture",pi);
		chain.doFilter(request, response);
		}else{
			response.sendRedirect("/html/index.html");
		}
		}else{
			response.sendRedirect("/html/index.html");
		}
		}catch(Exception e){
			e.printStackTrace();
		}	
		
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
