package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mybatis.entity.*;
import com.tool.GetPicForWeb;
@Service
@Transactional
/**
 * @author forvoid
 * 验证服务类
 * */

public class GetConfirmService {
	@Resource
	   com.mybatis.mapper.MemberMapper memberMapper;
	@Resource
	   com.mybatis.mapper.BossMapper bossMapper;
	@Resource
	   com.mybatis.mapper.HostelMapper hostelMapper;
	
	/**
	 * 义工验证信息查询
	 * 需要传入义工的id
	 * 传出信息有照片url和身份证号、姓名
	 * */
	public JSONObject memberComfSerch(int mid){
		JSONObject js = new JSONObject();
		JSONObject js2 = new JSONObject();
		JSONObject js3 = new JSONObject();
		Member member = memberMapper.selectByPrimaryKey(mid);
		js.put("type", "member");
		JSONArray ja= new JSONArray();
		if(member!=null){
			switch (member.getMcancel()) {
				case "0":
					js.put("code", -2);
					js.put("info", "该用户为非法用户，请注意");
					break;
				case "1":
					js.put("code", 1);
					js.put("info", "该用户没有进行过验证信息，可以初次提交");
					break;
				case "2":
					js.put("code", 2);
					js.put("info", "该用户用户已经验证过，并且通过验证！不能再传入了");
					 
					
					break;
				case "3":
					js.put("code", 0);
					js.put("info", "该用户验证正在进行中");
					break;
				case "-2":
					js.put("code", -1);
					js.put("info", "该用户验证未通过希望前端提供再次提交接口");
					break;

				default:
					js.put("code", -2);
					js.put("info", "出现异常错误");
					break;
			}
		}else{
			js.put("code", -2);
			js.put("info", "没有该用户存在");
		}
		return js;
	}
	/**
	 * 老板验证信息查询
	 * 需要传入老板的id
	 * 传出信息有照片url和身份证号、姓名
	 * */
	public JSONObject bossComfSerch(int bid){
		
		JSONObject js = new JSONObject();
		Boss boss = bossMapper.selectByPrimaryKey(bid);
		js.put("type", "boss");
		JSONArray ja= new JSONArray();
		JSONObject js3 = new JSONObject();
		JSONObject js2 = new JSONObject();
		if(boss!=null){
			switch (boss.getBcancel()) {
				case 0:
					js.put("code", -2);
					
					js.put("info", "该用户为非法用户，请注意");
					break;
				case 1:
					js.put("code", 1);
					js.put("info", "该用户没有进行过验证信息，可以初次提交");
					break;
				case 2:
					js.put("code", 2);
					js.put("info", "该用户用户已经验证过，并且通过验证！不能再传入了");
					break;
				case 3:
					js.put("code", 0);
					js.put("info", "该用户验证正在进行中");
					break;
				case -2:
					js.put("code", -1);
					js.put("info", "该用户验证未通过希望前端提供再次提交接口");
					break;

				default:
					js.put("code", -2);
					js.put("info", "出现异常错误");
					break;
			}
		}else{
			js.put("code", -2);
			js.put("info", "没有该用户存在");
		}
		return js;
	}
	/**
	 * 分离boss已存在的验证身份证信息
	 * */
	public static JSONObject getIdcard(Boss boss){
		JSONObject js2 =new JSONObject();
		String[] b = boss.getBidcard().split(";");
		//b.toString());
		if(b.length>0){
			js2.put("idcard_num", b[0]);
		}
		if(b.length>1){
			int ba1 = b[1].indexOf("face");
			int ba2 = b[1].indexOf("back");
			int ba3 = b[1].indexOf("hand");
			if(ba1>3){
				js2.put("face", GetPicForWeb.getPicUrl(b[1],60));
			}
			if(ba2>3){
				js2.put("back", GetPicForWeb.getPicUrl(b[1],60));
			}
			if(ba3>3){
				js2.put("hand", GetPicForWeb.getPicUrl(b[1],60));
			}
		}
		if(b.length>2){
			int ba1 = b[2].indexOf("face");
			int ba2 = b[2].indexOf("back");
			int ba3 = b[2].indexOf("hand");
			if(ba1>3){
				js2.put("face", GetPicForWeb.getPicUrl(b[2],60));
			}
			if(ba2>3){
				js2.put("back", GetPicForWeb.getPicUrl(b[2],60));
			}
			if(ba3>3){
				js2.put("hand", GetPicForWeb.getPicUrl(b[2],60));
			}
		}
		if(b.length>3){
			int ba1 = b[3].indexOf("face");
			int ba2 = b[3].indexOf("back");
			int ba3 = b[3].indexOf("hand");
			if(ba1>3){
				js2.put("face", GetPicForWeb.getPicUrl(b[3],60));
			}
			if(ba2>3){
				js2.put("back", GetPicForWeb.getPicUrl(b[3],60));
			}
			if(ba3>3){
				js2.put("hand", GetPicForWeb.getPicUrl(b[3],60));
			}
		}
		
		
		return js2;
		
	}
	/**
	 * 分离member已存在的验证身份证信息
	 * */
	public static JSONObject getIdcard(Member member){
		JSONObject js2 =new JSONObject();
		String[] b = member.getMidcard().split(";");
		if(b.length>0){
			js2.put("idcard_num", b[0]);
			}
			if(b.length>1){
				int ba1 = b[1].indexOf("face");
				int ba2 = b[1].indexOf("back");
				int ba3 = b[1].indexOf("hand");
				if(ba1>3){
					js2.put("face", GetPicForWeb.getPicUrl(b[1],60));
				}
				if(ba2>3){
					js2.put("back", GetPicForWeb.getPicUrl(b[1],60));
				}
				if(ba3>3){
					js2.put("hand", GetPicForWeb.getPicUrl(b[1],60));
				}
			}
			if(b.length>2){
				int ba1 = b[2].indexOf("face");
				int ba2 = b[2].indexOf("back");
				int ba3 = b[2].indexOf("hand");
				if(ba1>3){
					js2.put("face", GetPicForWeb.getPicUrl(b[2],60));
				}
				if(ba2>3){
					js2.put("back", GetPicForWeb.getPicUrl(b[2],60));
				}
				if(ba3>3){
					js2.put("hand", GetPicForWeb.getPicUrl(b[2],60));
				}
			}
			if(b.length>3){
				int ba1 = b[3].indexOf("face");
				int ba2 = b[3].indexOf("back");
				int ba3 = b[3].indexOf("hand");
				if(ba1>3){
					js2.put("face", GetPicForWeb.getPicUrl(b[3],60));
				}
				if(ba2>3){
					js2.put("back", GetPicForWeb.getPicUrl(b[3],60));
				}
				if(ba3>3){
					js2.put("hand", GetPicForWeb.getPicUrl(b[3],60));
				}
			}
			
		return js2;
		
	}
	/**
	 * 旅店验证信息查询
	 * 需要传入旅店的id
	 * 传出信息有照片url
	 * */
	public JSONObject hostelConfirmSerch(int hid){
		
		JSONObject js =new JSONObject();
		Hostel hostel = hostelMapper.selectByPrimaryKey(hid);
		js.put("type", "hostel");
		JSONObject js2=new JSONObject();
		JSONArray ja = new JSONArray();
		if(null!=hostel){
			if(hostel.getPauthentic().equals("1")){
				js.put("code", 2);
				js.put("info", "该旅店已经验证过，并且通过验证！不能再传入了");
			}else if(hostel.getPauthentic().equals("0")){
				js.put("code", 1);
				js.put("info", "该旅店没有认证可以认证了");
			}else if(hostel.getPauthentic().equals("2")){
				js.put("code", -1);
				js.put("info", "该旅店认证未通过");
			}else if(hostel.getPauthentic().equals("3")){
				js.put("code", 0);
				js.put("info", "该旅店认证正在进行中");
			}else{
				js.put("code", -2);
				js.put("info", "后台傻逼，创建时没有初始化是否认证字段");
			}
		}
		return js;
		
	}
}
