package com.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.mybatis.entity.Boss;
import com.mybatis.entity.Hostel;
import com.mybatis.entity.Member;
import com.mybatis.entity.Memberpicture;
import com.mybatis.entity.Picture;
import com.mybatis.entity.RecruitWithBLOBs;
import com.mybatis.entity.User;
import com.mybatis.mapper.AnswerMapper;
import com.mybatis.mapper.ApplyMapper;
import com.mybatis.mapper.AreaMapper;
import com.mybatis.mapper.BossMapper;
import com.mybatis.mapper.CollectMapper;
import com.mybatis.mapper.CommentMapper;
import com.mybatis.mapper.HostelMapper;
import com.mybatis.mapper.MemberMapper;
import com.mybatis.mapper.MemberpictureMapper;
import com.mybatis.mapper.PictureMapper;
import com.mybatis.mapper.RecruitMapper;


@Service
@Transactional
public class JspService {
	@Resource
	RecruitMapper r;
	
	@Resource
	HostelMapper h;
	@Resource
	AreaMapper a;
	@Resource
	PictureMapper p;
	@Resource
	CollectMapper co;
	@Resource
	CommentMapper c;
	@Resource
	MemberMapper m;
	@Resource
	ApplyMapper ap;
	@Resource
	AnswerMapper an;
	@Resource
	BossMapper b;
	@Resource
	MemberpictureMapper mp;
	public void infoJSP(int rid,HttpServletRequest request, HttpServletResponse response) {
		try{
			HttpSession info_session=request.getSession();
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
		response.sendRedirect("../html/recruitdetail.jsp?id=" + rid+"&hid="+hostel.getHid());
		}else{
			response.sendRedirect("../html/index.html");
		}
		}else{
			response.sendRedirect("../html/index.html");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void memberJSP(int mid,HttpServletRequest request) {
		try{
		Member member=m.selectByPrimaryKey(mid);
		List<Memberpicture> memberpicture=mp.selectByExample(mid);
		request.getSession().setAttribute("member",member);
		if(memberpicture.size()>0)
		request.getSession().setAttribute("Memberpicture",memberpicture.get(0));
		else
        request.getSession().setAttribute("Memberpicture",new Memberpicture());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void bossJSP(int bid,HttpServletRequest request) {

		try{
		Boss boss=b.selectByPrimaryKey(bid);
		request.getSession().setAttribute("boss",boss);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void hostelJSP(int hid,HttpServletRequest request) {
		try{
		Hostel hostel=h.selectByPrimaryKey(hid);
		request.getSession().setAttribute("hostel",hostel);
		List<Picture>  pi=p.selectByExample(hid+"");
		request.getSession().setAttribute("picture",pi);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void recruitJSP(int rid,HttpServletRequest request) {
		try{
		RecruitWithBLOBs recruit=r.selectByPrimaryKey(rid);
		request.getSession().setAttribute("recruit",recruit);	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
