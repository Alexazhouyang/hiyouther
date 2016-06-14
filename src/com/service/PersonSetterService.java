package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.entity.Boss;
import com.mybatis.entity.Member;

/**
 * @author forvoid
 * 个人资料管理
 * */
@Service
@Transactional
public class PersonSetterService {
	@Resource
	com.mybatis.mapper.MemberMapper memberMapper;
	@Resource
	com.mybatis.mapper.BossMapper bossMapper;
	
	/**
	 * 根据type和id查找个人资料
	 * */
	public JSONObject getPersonManage(Integer id,String type){
		JSONObject returnjson=new JSONObject();
		if(type.equals("member")){
			Member member = memberMapper.selectByPrimaryKey(id);
			if(member!=null){
				returnjson.put("code", "1");
				returnjson.put("info", "获取成功!");
				JSONObject memberdateJson = new JSONObject();
				memberdateJson.put("account", member.getMpassword()==null||member.getMpassword()==""||member.getMpassword().length()==0?-2:(member.getMphone()==null||member.getMphone()==""||member.getMphone().length()==0?(member.getMemail()==null||member.getMemail()==""||member.getMemail().length()==0?-1:member.getMemail()):member.getMphone()));
				memberdateJson.put("phone", member.getMphone()==null||member.getMphone()==""||member.getMphone().length()==0?-1:member.getMphone());
				memberdateJson.put("email", member.getMemail()==null||member.getMemail()==""||member.getMemail().length()==0?-1:member.getMemail());
				
				returnjson.put("data", memberdateJson);
			}else{
				returnjson.put("code", -1);
				returnjson.put("info", "未查询到该用户");
			}
		}else if(type.equals("boss")){
			Boss boss = bossMapper.selectByPrimaryKey(id);
			if(boss!=null){
				returnjson.put("code", "1");
				returnjson.put("info", "获取成功!");
				JSONObject bossdateJson = new JSONObject();
				//有几种情况需要注意，第三方登录没有密码时需要提示第三方登录，有密码时提示帐号绑定了第三方
				bossdateJson.put("account",  boss.getBpassword()==null||boss.getBpassword()==""||boss.getBpassword().length()==0?-2:(boss.getBphone()==null||boss.getBphone()==""||boss.getBphone().length()==0?(boss.getBemail()==null||boss.getBemail()==""||boss.getBemail().length()==0?-1:boss.getBemail()):boss.getBphone()));
				bossdateJson.put("phone", boss.getBphone()==null||boss.getBphone()==""||boss.getBphone().length()==0?-1:boss.getBphone());
				bossdateJson.put("email", boss.getBemail()==null||boss.getBemail()==""||boss.getBemail().length()==0?-1:boss.getBemail());
				
				returnjson.put("data", bossdateJson);
			}else{
				returnjson.put("code", -1);
				returnjson.put("info", "未查询到该用户");
			}
		}else{
			returnjson.put("code", -1);
			returnjson.put("info", "用户类型出错！");
		}
		return returnjson;
	}
	
}
