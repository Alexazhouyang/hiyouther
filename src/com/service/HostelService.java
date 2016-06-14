package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.mybatis.entity.Area;
import com.mybatis.entity.Collect;
import com.mybatis.entity.Hostel;
import com.mybatis.entity.Picture;
import com.mybatis.entity.Recruit;
import com.mybatis.entity.RecruitWithBLOBs;
import com.mybatis.mapper.AreaMapper;
import com.mybatis.mapper.CollectMapper;
import com.mybatis.mapper.HostelMapper;
import com.mybatis.mapper.PictureMapper;
import com.mybatis.mapper.RecruitMapper;

@Service
@Transactional
public class HostelService {
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
	public JSONObject getAllHoste(String page,String mid,String pagesize,String arid,String month,String sctime) {
		JSONObject j=new JSONObject();
		JSONArray ja=new JSONArray();
		try{
		List<RecruitWithBLOBs> l=r.selectByAll(page, pagesize, arid, month, sctime, name);
		hostelApi(mid, j, ja, l);
		}catch(Exception e){
			j.put("errCode",-1);
		}
		return j;
	}
	public JSONObject getHostel(String page,String mid,String pagesize,String arid,String month,String sctime) {
		JSONObject j=new JSONObject();
		JSONArray ja=new JSONArray();
		try{
		List<RecruitWithBLOBs> l=r.selectByType(page, pagesize, arid, month, sctime, );
		hostelApi(mid, j, ja, l);
		}catch(Exception e){
			j.put("errCode",-1);
		}
		return j;
	}
	public JSONObject getTag() {
		JSONObject j=new JSONObject();
		JSONArray ja=new JSONArray();
		try{
			List<Area> l=a.selectByExample();
			for(Area ar:l){
				JSONObject j1=new JSONObject();
				j1.put("id",ar.getArid());
				j1.put("name",ar.getArname());
				j1.put("country",ar.getArcountry());
				j1.put("size",l.size());
				ja.add(j1);
			}
			j.put("content",ja);
			j.put("errCode",0);
			}catch(Exception e){
			j.put("errCode",-1);
		}
		return j;
	}
	public JSONObject collect(String hid,String mid) {
		JSONObject j=new JSONObject();
		if(co.ifCollect(hid,mid).size()!=0){
			j.put("errCode", 1);
		}
			else{
				Collect c=new Collect();
				c.setHid(Integer.parseInt(hid));c.setMid(Integer.parseInt(mid));
				if(	co.insert(c)>0)
			    j.put("errCode", 0);
				else
				j.put("errCode",-1);
			}
		return j;
	}
	public JSONObject concealcollect (int sid) {
		JSONObject j=new JSONObject();
				if(co.deleteByPrimaryKey(sid)>0)
			    j.put("errCode", 0);
				else
				j.put("errCode",-1);

		return j;
	}
	public JSONObject getcomment (int sid) {
		JSONObject j=new JSONObject();
				if(co.deleteByPrimaryKey(sid)>0)
			    j.put("errCode", 0);
				else
				j.put("errCode",-1);

		return j;
	}
	public JSONObject getInfo(int rid,int hid,String mid) {
		JSONObject j=new JSONObject();
		JSONArray ja=new JSONArray();
		JSONArray ja1=new JSONArray();
		try{
		RecruitWithBLOBs l1=r.selectByPrimaryKey(rid);
		Hostel l2=h.selectByPrimaryKey(hid);
		List<RecruitWithBLOBs> l=r.selectByhistory(hid+"");
		List<Picture> l3=p.selectByExample(l1.getHid()+"");
		for(Picture pi:l3){
			ja.add(pi.getPicaddress());
		}
		j.put("rid",ja);
		if(co.ifCollect(mid,l1.getHid()+"").size()!=0)
			j.put("ifcollect", 1);
			else
			j.put("ifcollect", 0);
		j.put("photo",ja);
		j.put("tagname",l2.getHtag());
		j.put("synopsis",l2.getHsynopsis());
		j.put("task",l1.getRtask());	
		j.put("competence",l1.getRcompetence());	
		j.put("rsynopsis",l1.getRsynopsis());
		j.put("number",l1.getRnumbers());
		j.put("month",l1.getRmonth()+"-"+l1.getRsctime());
		for(RecruitWithBLOBs re:l){
			JSONObject j1=new JSONObject();
			j1.put("rid ",re.getRid());
			j.put("month",re.getRmonth()+"-"+re.getRsctime());
			j1.put("number",re.getRnumbers());
			j1.put("task",re.getRtask());
			j1.put("content",r.countBycomment(re.getRid()+"",0));
			j1.put("answer",r.countBycomment(re.getRid()+"",1));
			j1.put("name",re.getRname());
			ja1.add(j1);
		}
		j.put("history",ja1);
		j.put("errCode",0);
		}catch(Exception e){
			j.put("errCode",-1);
		}
		return j;
	}
	public void hostelApi(String mid, JSONObject j, JSONArray ja, List<RecruitWithBLOBs> l) {
		for(Recruit re:l){
			JSONArray ja1=new JSONArray();
			List<Picture> l1=p.selectByExample(re.getHid()+"");
			for(Picture pi:l1){
				ja1.add(pi.getPicaddress());
			}
			JSONObject j1=new JSONObject();
			Hostel he=h.selectByPrimaryKey(re.getHid());
			j1.put("number", re.getRnumbers());
			j1.put("hid", re.getHid());
			j1.put("rid", re.getRid());
			j1.put("month", re.getRmonth()+"-"+re.getRsctime());
			j1.put("score",he.getHscore());
			j1.put("photo",ja1);
			if(co.ifCollect(mid,re.getHid()+"").size()!=0)
			j1.put("ifcollect", 1);
			else
			j1.put("ifcollect", 0);
			j1.put("authentic",he.getPauthentic());
			ja.add(j1);
		}
		j.put("content",ja);
		if(l.size()!=0)
		j.put("errCode",0);
		else
		j.put("errCode",1);
	}
}
