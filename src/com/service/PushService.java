package com.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.mybatis.entity.Push;

import com.mybatis.mapper.PushMapper;
import com.mybatis.mapper.RecruitMapper;
import com.tool.GetPicForWeb;

@Service
@Transactional
public class PushService {
	@Resource
	PushMapper p;
	SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd");
	public JSONObject isLooked(int[] id) {
		JSONObject j=new JSONObject();
		Push push=new Push();
		try {
		for(int i:id){
			push.setIflook("1");push.setPuid(i);
			p.updateByPrimaryKeySelective(push);
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			j.put("code",-1);
			j.put("info","失败");
		}
		j.put("code",1);
		j.put("info","成功");
		return j;
	}
	public JSONObject getPush(int uid,int type,int page, int rows) {
		JSONObject j=new JSONObject();
		List<Push> list=new ArrayList<>();
		if(type==1){
		  list = p.selectByB(uid,page,rows);
		  JSONArray ja=new JSONArray();
		  for(Push push:list){
			  JSONObject j1=new JSONObject();

			  j1.put("content",push.getPcontent());
			  j1.put("iflook",push.getIflook());
			  j1.put("img",GetPicForWeb.getPicUrl("img/etc/init.jpg",60));
			  j1.put("time",d.format( push.getPtime()));
			  j1.put("id", push.getPuid());
			  ja.put(j1);
		  }
		j.put("data", ja);
		j.put("index", p.countByB(uid, "true"));
		j.put("size", p.countByB(uid, null));
		}
		else{
		  list=p.selectByM(uid,page,rows);	
		  JSONArray ja=new JSONArray();
		  for(Push push:list){
			  JSONObject j1=new JSONObject();

			  j1.put("iflook",push.getIflook());
			  j1.put("content",push.getPcontent());
			  j1.put("img",GetPicForWeb.getPicUrl("img/etc/init.jpg",60));
			  j1.put("time",d.format( push.getPtime()));
			  j1.put("id", push.getPuid());
			  ja.put(j1);
		  }
		j.put("data", ja);
		j.put("index", p.countByM(uid, "true"));
		j.put("size", p.countByM(uid, null));
		}
		if(list!=null&&list.size()>0){
			j.put("code",1);
			j.put("info","成功");
		}
		else{
			j.put("code",-1);
			j.put("info","无数据");
		}
		return j;
	}
	public JSONObject deletePush(int uid,int type) {
		JSONObject j=new JSONObject();
		if(type==0){
		if(p.deleteByB(uid)>0){
			j.put("code",1);
			j.put("info","成功");
		}
		else{
			j.put("code",-1);
			j.put("info","失败");
		}
		}
		else{
			if(p.deleteByM(uid)>0){
				j.put("code",1);
				j.put("info","成功");
			}
			else{
				j.put("code",-1);
				j.put("info","失败");
			}
		}
		return j;
	}
	public JSONObject deletePush(int pid) {
		JSONObject j=new JSONObject();
		if(p.deleteByPrimaryKey(pid)>0){
			j.put("code",1);
			j.put("info","成功");
		}
		else{
			j.put("code",-1);
			j.put("info","失败");
		}

		return j;
	}
	public JSONObject deleteAllPush(int[] Pid) {
		JSONObject j=new JSONObject();
		for(int pid:Pid){
		if(p.deleteByPrimaryKey(pid)>0){
			j.put("code",1);
			j.put("info","成功");
		}
		else{
			j.put("code",-1);
			j.put("info","失败");
		}
		}
		return j;
	}
}


