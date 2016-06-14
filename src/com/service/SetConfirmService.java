package com.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mybatis.entity.Boss;
import com.mybatis.entity.Hostel;
import com.mybatis.entity.Member;
import com.mybatis.entity.Push;
import com.mybatis.mapper.MemberMapper;
import com.tool.GetPicForWeb;



@Service
@Transactional
/**
 * @author forvoid
 * 本类用于后台管理人员的对申请验证的
 * 需要管理的进程有：
 * 1、获取当前全部正在申请验证的所有列表
 * 2、获取某一个申请的具体数据：
 * 3、通过某身份验证申请
 * 4、不通过身份认证申请
 * */
public class SetConfirmService {
	@Resource
	   MemberMapper memberMapper;
	@Resource
	   com.mybatis.mapper.BossMapper bossMapper;
	@Resource
	   com.mybatis.mapper.HostelMapper hostelMapper;
	@Resource
	   com.mybatis.mapper.PushMapper pushMapper;
	/**
	 * 获取指定的全部申请认证的信息
	 * 需要提供：type（旅店、老板、义工）hostel\boss\member
	 * 			option:(申请通过的、申请正在进行的、申请失败的)pass\ongoing\fail
	 * */
	public JSONObject findAllConfirm(String type,String option){
		JSONObject js = new JSONObject();
		switch (type) {
			case "boss":
				
				if(option.equals("pass")){
					List<Boss> bossOption =bossMapper.selectAllConfirm(2);
					if(bossOption.size()!=0){
						JSONArray ja = new JSONArray();
						for(Boss boss:bossOption){
							JSONObject js1 =new JSONObject();
							js1.put("id",boss.getBid() );
							js1.put("usename", boss.getBusername());
							js1.put("realname", boss.getBrealname());
							js1.put("idcard", boss.getBid());
							js1.put("address", boss.getBaddress());
							ja.add(js1);
						}
						js.put("data", ja);
						js.put("code", 1);
						js.put("info", "查询通过老板成功");
					}else{
						js.put("code", -1);
						js.put("info", "当前没有通过验证的老板");
					}
				}else if(option.equals("ongoing")){
					List<Boss> bossOption =bossMapper.selectAllConfirm(3);
					if(bossOption.size()!=0){
						JSONArray ja = new JSONArray();
						for(Boss boss:bossOption){
							JSONObject js1 =new JSONObject();
							js1.put("id",boss.getBid() );
							js1.put("usename", boss.getBusername());
							js1.put("realname", boss.getBrealname());
							js1.put("idcard", boss.getBid());
							js1.put("address", boss.getBaddress());
							ja.add(js1);
						}
						js.put("data", ja);
						js.put("code", 1);
						js.put("info", "查询需要验证老板成功");
					}else{
						js.put("code", -1);
						js.put("info", "当前没有需要验证的老板");
					}
				}else if(option.equals("fail")){
					List<Boss> bossOption =bossMapper.selectAllConfirm(-2);
					if(bossOption.size()!=0){
						JSONArray ja = new JSONArray();
						for(Boss boss:bossOption){
							JSONObject js1 =new JSONObject();
							js1.put("id",boss.getBid() );
							js1.put("usename", boss.getBusername());
							js1.put("realname", boss.getBrealname());
							js1.put("idcard", boss.getBid());
							js1.put("address", boss.getBaddress());
							ja.add(js1);
						}
						js.put("data", ja);
						js.put("code", 1);
						js.put("info", "查询未通过老板成功");
					}else{
						js.put("code", -1);
						js.put("info", "当前没有未通过验证的老板");
					}
				}else{
					js.put("code", -2);
					js.put("info", "输入参数报错");
				}
				break;
			case "member":
				if(option.equals("pass")){
					List<Member> memberOption =memberMapper.selectAllConfirm("2");
					if(memberOption.size()!=0){
						JSONArray ja = new JSONArray();
						for(Member member:memberOption){
							JSONObject js1 =new JSONObject();
							js1.put("id",member.getMid() );
							js1.put("usename", member.getMemname());
							js1.put("realname", member.getMemname());
							js1.put("idcard", member.getMid());
							js1.put("address", member.getMaddress());
							ja.add(js1);
						}
						js.put("data", ja);
						js.put("code", 1);
						js.put("info", "查询通过义工成功");
					}else{
						js.put("code", -1);
						js.put("info", "当前没有通过验证的义工");
					}
				}else if(option.equals("ongoing")){
					List<Member> memberOption =memberMapper.selectAllConfirm("3");
					if(memberOption.size()!=0){
						JSONArray ja = new JSONArray();
						for(Member member:memberOption){
							JSONObject js1 =new JSONObject();
							js1.put("id",member.getMid() );
							js1.put("usename", member.getMemname());
							js1.put("realname", member.getMemname());
							js1.put("idcard", member.getMid());
							js1.put("address", member.getMaddress());
							ja.add(js1);
						}
						js.put("data", ja);
						js.put("code", 1);
						js.put("info", "查询正在申请义工成功");
					}else{
						js.put("code", -1);
						js.put("info", "当前没有正在申请验证的义工");
					}
				}else if(option.equals("fail")){
					List<Member> memberOption =memberMapper.selectAllConfirm("-2");
					if(memberOption.size()!=0){
						JSONArray ja = new JSONArray();
						for(Member member:memberOption){
							JSONObject js1 =new JSONObject();
							js1.put("id",member.getMid() );
							js1.put("usename", member.getMemname());
							js1.put("realname", member.getMemname());
							js1.put("idcard", member.getMid());
							js1.put("address", member.getMaddress());
							ja.add(js1);
						}
						js.put("data", ja);
						js.put("code", 1);
						js.put("info", "查询未通过义工成功");
					}else{
						js.put("code", -1);
						js.put("info", "当前没有未通过验证的义工");
					}
				}else{
					js.put("code", -2);
					js.put("info", "输入参数报错");
				}
				break;
			case "hostel":
				if(option.equals("pass")){
					List<Hostel> hostelOption =hostelMapper.selectByPauthentic("1");
					if(hostelOption.size()!=0){
						JSONArray ja = new JSONArray();
						for(Hostel hostel:hostelOption){
							JSONObject js1 =new JSONObject();
							js1.put("id",hostel.getHid() );
							js1.put("name", hostel.getHname());
							Boss boss = bossMapper.selectByPrimaryKey(hostel.getBid());
							js1.put("bossrealname", boss.getBrealname());
							js1.put("address", hostel.getHaddress());
							ja.add(js1);
						}
						js.put("data", ja);
						js.put("code", 1);
						js.put("info", "查询通过旅店成功");
					}else{
						js.put("code", -1);
						js.put("info", "当前没有通过验证的旅店");
					}
				}else if(option.equals("ongoing")){
					List<Hostel> hostelOption =hostelMapper.selectByPauthentic("3");					
					if(hostelOption.size()!=0){
						JSONArray ja = new JSONArray();
						for(Hostel hostel:hostelOption){
							JSONObject js1 =new JSONObject();
							js1.put("id",hostel.getHid() );
							js1.put("name", hostel.getHname());
							Boss boss = bossMapper.selectByPrimaryKey(hostel.getBid());
							js1.put("bossrealname", boss.getBrealname());
							js1.put("address", hostel.getHaddress());
							ja.add(js1);
						}
						js.put("data", ja);
						js.put("code", 1);
						js.put("info", "查询正在申请验证旅店成功");
					}else{
						js.put("code", -1);
						js.put("info", "当前没有申请验证的旅店");
					}
				}else if(option.equals("fail")){
					List<Hostel> hostelOption =hostelMapper.selectByPauthentic("2");					
					if(hostelOption.size()!=0){
						JSONArray ja = new JSONArray();
						for(Hostel hostel:hostelOption){
							JSONObject js1 =new JSONObject();
							js1.put("id",hostel.getHid() );
							js1.put("name", hostel.getHname());
							Boss boss = bossMapper.selectByPrimaryKey(hostel.getBid());
							js1.put("bossrealname", boss.getBrealname());
							js1.put("address", hostel.getHaddress());
							ja.add(js1);
						}
						js.put("data", ja);
						js.put("code", 1);
						js.put("info", "查询未通过旅店成功");
					}else{
						js.put("code", -1);
						js.put("info", "当前没有验证失败的旅店");
					}
				}else{
					
				}
				break;

		default:js.put("code", -2);
		js.put("info", "type类型出错，没有该对应值");
			break;
		}
		return js;
	}
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 本类用于查找单个用户或者旅店的具体信息
	 * 需要传入 id:旅店或者个人用户；type类型：boss\member\hostel用于查找用户；
	 * */
	public JSONObject findConfirmByUserid(String id ,String type){
		JSONObject js = new JSONObject();
		System.out.println("进入个人查询");
		switch (type){
			case "boss":
					int i = Integer.parseInt(id);
					System.out.println(i);
					Boss boss = bossMapper.selectByPrimaryKey(i);
					if(null!=boss){
						JSONObject js1 =new JSONObject();
						js1.put("id", id);
						String account = "该用户为第三方注册";
						if(boss.getBphone().equals(null)){
							account = boss.getBphone();
						}else if(boss.getBemail().equals(null)){
							account = boss.getBemail();
						}
						js1.put("account", account);
						js1.put("realname", boss.getBrealname());
						js1.put("sex", boss.getBsex());
						js1.put("address", boss.getBaddress());
						String b[] = boss.getBidcard().split(";");
						js1.put("idcard_num", b[0]);
						js1.put("pic_face", GetPicForWeb.getPicUrl(b[1], 60));
						js1.put("pic_back", GetPicForWeb.getPicUrl(b[2], 60));
						js1.put("pic_hand", GetPicForWeb.getPicUrl(b[3], 60));
						if(boss.getBcancel()==0){
						js1.put("status", 0);
						}else if(boss.getBcancel()==1){
							js1.put("status", 1);
						}else if(boss.getBcancel()==2){
							js1.put("status", 2);
						}else if(boss.getBcancel()==3){
							js1.put("status", 3);
						}else if(boss.getBcancel()==-2){
							js1.put("status", -2);
						}
						js1.put("settime", sdf.format(boss.getBinsettime()));
						js.put("data", js1);
						js.put("code", 1);
						js.put("info", "老板个人详情获取成功");
					}else{
						js.put("code", -1);
						js.put("info", "没有该用户");
						
					}
				break;
			case "member":
				Member member = memberMapper.selectByPrimaryKey(Integer.parseInt(id));
				System.out.println(member);
				if(null!=member){
					JSONObject js1 =new JSONObject();
					js1.put("id", id);
					String account = "该用户为第三方注册";
					if(member.getMphone().equals(null)){
						account = member.getMphone();
					}else if(member.getMemail().equals(null)){
						account = member.getMemail();
					}
					js1.put("account", account);
					js1.put("realname", member.getMemname());
					js1.put("sex", member.getMsex());
					js1.put("address", member.getMaddress());
					String b[] = member.getMidcard().split(";");
					js1.put("idcard_num", b[0]);
					js1.put("pic_face", GetPicForWeb.getPicUrl(b[1], 60));
					js1.put("pic_back", GetPicForWeb.getPicUrl(b[2], 60));
					js1.put("pic_hand", GetPicForWeb.getPicUrl(b[3], 60));
					if(member.getMcancel().equals("0")){
					js1.put("status", 0);
					}else if(member.getMcancel().equals("1")){
						js1.put("status", 1);
					}else if(member.getMcancel().equals("2")){
						js1.put("status", 2);
					}else if(member.getMcancel().equals("3")){
						js1.put("status", 3);
					}else if(member.getMcancel().equals("-2")){
						js1.put("status", -2);
					}
					js1.put("settime", sdf.format(member.getMinsettime()));
					js1.put("jianli", member.getMresume());
					js.put("data", js1);
					js.put("code", 1);
					js.put("info", "义工个人详情获取成功");
				}else{
					System.out.println("没有该用户");
					js.put("code", -1);
					js.put("info", "没有该用户");
					
				}
				break;
			case "hostel":
			
				Hostel hostel = hostelMapper.selectByPrimaryKey(Integer.parseInt(id));
				if(null!=hostel){
					JSONObject js1 = new JSONObject();
					js1.put("id", id);
					js1.put("address", hostel.getHaddress());
					js1.put("name", hostel.getHname());
					js1.put("jianjie", hostel.getHsynopsis());
					js1.put("phone",hostel.getHphone());
					js1.put("tel",hostel.getHtel());
					js1.put("tag", hostel.getHtag());
					js1.put("score", hostel.getHscore());
					js1.put("status", hostel.getPauthentic());
					if(hostel.getPbuscard().length()>0){
						js1.put("yanzhengtupian", GetPicForWeb.getPicUrl(hostel.getPbuscard(), 60));
					}
					Boss boss1 = bossMapper.selectByPrimaryKey(hostel.getBid());
					js1.put("bossid", boss1.getBid());
					js1.put("bossrealname", boss1.getBrealname());
					js1.put("touxiang", boss1.getBtouxiang());
					js1.put("bossadress", boss1.getBaddress());
					js.put("code", 1);
					js.put("info", "旅店信息查找成功");
				}else{
					js.put("code", -1);
					js.put("info", "该旅店不存在");
				}
				
				break;
			default:
				js.put("code", -2);
				js.put("info", "type操作错误");
				break;
		}
		return js;
	}
	/**
	 * 通过义工、老板、旅店身份验证请求
	 * 需要传入的参数有：type:类型boss\member\hostel ; id:用户id;
	 * */
	public JSONObject passConfirm(String id,String type){
		JSONObject js = new JSONObject();
		switch(type){
			case "boss":
				Boss boss = bossMapper.selectByPrimaryKey(Integer.parseInt(id));
				if(null!=boss){
					boss.setBcancel(2);
					bossMapper.updateByPrimaryKey(boss);
					Push push = new Push();
					push.setIflook("0");
					push.setPcontent("img/test.jpg;;;;您好！您的老板身份认证已经通过，系统将会为您点亮认证徽章。嗨柚，谢谢你的配合！");
					push.setPname("嗨柚老板个人身份认证通知");
					push.setPtime(new Date());
					push.setType(1);
					push.setUid(Integer.parseInt(id));
					pushMapper.insert(push);
					js.put("code", 1);
					js.put("info", "老板用户申请验证通过，前端刷新获取更新");
				}else{
					js.put("code", -1);
					js.put("info", "没有该用户");
				}
				break;
			case "member":
				Member member = memberMapper.selectByPrimaryKey(Integer.parseInt(id));
				if(null!=member){
					member.setMcancel("2");
					memberMapper.updateByPrimaryKey(member);
					Push push = new Push();
					push.setIflook("0");
					push.setPcontent("img/test.jpg;;;;您好！您的义工身份认证已经通过，系统将会为您点亮认证徽章。嗨柚，谢谢你的配合！");
					push.setPname("嗨柚义工个人身份认证通知");
					push.setPtime(new Date());
					push.setType(3);
					push.setUid(Integer.parseInt(id));
					pushMapper.insert(push);
					js.put("code", 1);
					js.put("info", "义工用户申请验证通过，前端刷新获取更新");
				}else{
					js.put("code", -1);
					js.put("info", "没有该用户");
				}
				break;
			case "hostel":
				Hostel hostel = hostelMapper.selectByPrimaryKey(Integer.parseInt(id));
				if(null!=hostel){
					hostel.setPauthentic("1");
					hostelMapper.updateByPrimaryKey(hostel);
					Push push = new Push();
					push.setIflook("0");
					push.setPcontent("img/test.jpg;;;;您好！您的旅店认证已经通过，系统将会为您的旅店“"+hostel.getHname()+"”点亮认证徽章。嗨柚谢谢你的配合！");
					push.setPname("嗨柚旅店认证通知");
					push.setPtime(new Date());
					push.setType(1);
					push.setUid(hostel.getBid());
					pushMapper.insert(push);
					js.put("code", 1);
					js.put("info", "旅店用户申请验证通过，前端刷新获取更新");
				}else{
					js.put("code", -1);
					js.put("info", "没有该旅店");
				}
				break;
			default:
				js.put("code", -2);
				js.put("info", "type操作错误");
				break;
		}
		return js;
	
	}
	/**
	 * 不通过义工、老板、旅店请求
	 * 需要传入的参数有：type:类型boss\member\hostel ; id:用户id;
	 * */
	public JSONObject unPassConfirm(String id,String type){
		JSONObject js = new JSONObject();
		switch(type){
			case "boss":
				Boss boss = bossMapper.selectByPrimaryKey(Integer.parseInt(id));
				if(null!=boss){
					boss.setBidcard(null);
					boss.setBrealname(null);
					boss.setBcancel(-2);
					bossMapper.updateByPrimaryKey(boss);
					Push push = new Push();
					push.setIflook("0");
					push.setPcontent("img/test.jpg;;;;您好！您的老板身份认证由于照片不清晰，没有通过！请继续前往认证。嗨柚，谢谢你的配合！");
					push.setPname("嗨柚老板个人身份认证通知");
					push.setPtime(new Date());
					push.setType(1);
					push.setUid(Integer.parseInt(id));
					pushMapper.insert(push);
					js.put("code", 1);
					js.put("info", "老板用户申请验证失败通过，前端刷新获取更新");
				}else{
					js.put("code", -1);
					js.put("info", "没有该用户");
				}
				break;
			case "member":
				Member member = memberMapper.selectByPrimaryKey(Integer.parseInt(id));
				if(null!=member){
					member.setMidcard(null);
					member.setMemname(null);
					member.setMcancel("-2");
					memberMapper.updateByPrimaryKey(member);
					Push push = new Push();
					push.setIflook("0");
					push.setPcontent("img/test.jpg;;;;您好！您的义工身份认证由于照片不清晰，没有通过！请继续前往认证。嗨柚，谢谢你的配合！");
					push.setPname("嗨柚义工个人身份认证通知");
					push.setPtime(new Date());
					push.setType(3);
					push.setUid(Integer.parseInt(id));
					pushMapper.insert(push);
					js.put("code", 1);
					js.put("info", "义工用户申请验证失败通过，前端刷新获取更新");
				}else{
					js.put("code", -1);
					js.put("info", "没有该用户");
				}
				break;
			case "hostel":
				Hostel hostel = hostelMapper.selectByPrimaryKey(Integer.parseInt(id));
				if(null!=hostel){
					hostel.setPauthentic("2");
					hostelMapper.updateByPrimaryKey(hostel);
					Push push = new Push();
					push.setIflook("0");
					push.setPcontent("img/test.jpg;;;;您好！您的旅店“"+hostel.getHname()+"”照片不清晰，未能通过验证，请继续前往验证平台进行验证操作。嗨柚谢谢你的配合！");
					push.setPname("嗨柚旅店认证通知");
					push.setPtime(new Date());
					push.setType(1);
					push.setUid(hostel.getBid());
					pushMapper.insert(push);
					js.put("code", 1);
					js.put("info", "旅店用户申请验证失败通过，前端刷新获取更新");
				}else{
					js.put("code", -1);
					js.put("info", "没有该旅店");
				}
				break;
			default:
				js.put("code", -2);
				js.put("info", "type操作错误");
				break;
		}
		return js;
	}
}
