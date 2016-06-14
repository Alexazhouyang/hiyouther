package com.tool.timeLister;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.record.RecalcIdRecord;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.entity.Boss;
import com.mybatis.entity.Hostel;
import com.mybatis.entity.Otherpush;
import com.mybatis.entity.Recruit;

/**
 * @author forvoid
 * 第三方推送系统（boss招聘申请版）
 * > * 老板可以取消或者添加本系统，可以启用也可以不启用本平台
> * 老板可以设置开关，是否推送某个旅店或者某个招聘
> * 老板自定义推送时间（重要）
    老板可以通过平台进行时间的自定义（那一天、那一个小时、一天推送多少次、等等段时间）
 * */
public class BossOtherPushManger {
	@Resource
	com.mybatis.mapper.OtherpushMapper otherPushMapper;
	@Resource
	com.mybatis.mapper.BossMapper bossMapper;
	@Resource
	com.mybatis.mapper.HostelMapper hostelMapper;
	@Resource
	com.mybatis.mapper.RecruitMapper recruitMapper;
	/**
	 * 老板开通监听服务
	 * 添加监听(短信版)
	 * 当新增老板时调用本方法
	 * pushtime初始监听包
	 * */
	public JSONObject addLister(Integer bid,String insertpushtime){
		JSONObject returnJson = new JSONObject();
		Boss boss = bossMapper.selectByPrimaryKey(bid);
		if(boss.getBphone()!=null){
			Otherpush otherpush = otherPushMapper.selectByTypeForUserid(bid, "boss");
			if(otherpush!=null){
				returnJson.put("code", -1);
				returnJson.put("info", "用户已经存在不能再新建第三方监听");
			}else{
				Otherpush new_Otherpush = new Otherpush();
				new_Otherpush.setUsertype("boss");
				new_Otherpush.setPushtype("SMS");
				new_Otherpush.setInserttime(new Date());
				new_Otherpush.setUserid(bid);
				//new_Otherpush
				new_Otherpush.setPushcount(50);//默认推送总数；
				new_Otherpush.setPushcountcycle("**");//默认推送周期
				new_Otherpush.setPushcountnum(0);//当前周期的推送条数
				new_Otherpush.setPushstatus("yes");//不开启推送服务
				new_Otherpush.setExecutecount(0);//执行总数
				new_Otherpush.setPushtime(insertpushtime);
				new_Otherpush.setExecutetime(new Date());
				//默认监听全部的旅店和招聘
				String object = "SMS###boss###";//方式短信，服务对象老板
				List<Hostel> bossHostel = hostelMapper.selectByExample(bid, 0, 1000);//最多可以同时设置1000个旅店
				if(bossHostel!=null){
				for(Hostel hostel:bossHostel){
					//旅店开关
					object+=hostel.getHid()+":yes##";
					List<Recruit> hostelrecruit=recruitMapper.selectByHidForLister(hostel.getHid());
					if(hostelrecruit!=null){
					for(Recruit recruit:hostelrecruit){
						//招聘开关
						object+=recruit.getRid()+":yes--";
					}
					}
					object+="$$";   
				}
				}
				//加入推送对象（新建的话遍历全步招聘放上去）
				new_Otherpush.setPushobject(object);
				if(otherPushMapper.insertSelective(new_Otherpush)>0){
					returnJson.put("code", 1);
					returnJson.put("info", "短信第三方平台开通成功");
				}else{
					returnJson.put("code", -1);
					returnJson.put("info", "未知错误，请稍后再试！");
				}
			}
		}else{
			returnJson.put("code", -1);
			returnJson.put("info", "未查到您的手机号，请前往个人设置绑定手机号后再试！");
		}
		return returnJson;
		
	}
	
}
