package com.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.entity.Boss;
import com.mybatis.entity.Hostel;
import com.mybatis.entity.Member;
import com.tool.GetUpPowForWEB;

import javafx.print.JobSettings;

@Service
@Transactional
/**
 * @author forvoid
 * 本类用于提交身份认证信息
 * 服务于 ：boss\member\hostel
 * */
public class SumConfirmService {
	@Resource
	   com.mybatis.mapper.MemberMapper memberMapper;
	@Resource
	   com.mybatis.mapper.BossMapper bossMapper;
	@Resource
	   com.mybatis.mapper.HostelMapper hostelMapper;
	/**
	 * 上传图片审查并且改变数据库原有的数据放入数据库
	 * 用于图片上传时的审查（包括审查是否有重名的情况，防止某个图片数据库保存的情况）
	 * 
	 * */

	public  Boolean  checkForUpdateOss(String type,int userid,String keyName){
		String idcard=null;
		Boolean sign =true;
		if(type.equals("member")){
			Member  member =  memberMapper.selectByPrimaryKey(userid);
			if(member.getMidcard()!=null){
				String[] b = member.getMidcard().split(";");
				for(String a:b){
					if(a.equals(keyName)){
						sign = false;
					}
				}
				if(sign){
					idcard=member.getMidcard()+";"+keyName;
					member.setMidcard(idcard);
					memberMapper.updateByPrimaryKey(member);
				}
			}else{
				member.setMidcard(keyName);
				memberMapper.updateByPrimaryKey(member);
			}
			
		}else if(type.equals("boss")){
			Boss boss =bossMapper.selectByPrimaryKey(userid);
			if(boss.getBidcard()!=null){
				String[] b = boss.getBidcard().split(";");
			for(String a:b){
					if(a.equals(keyName)){
					sign = false;
					}
			}
			if(sign){
				idcard=boss.getBidcard()+";"+keyName;
				boss.setBidcard(idcard);
				bossMapper.updateByPrimaryKey(boss);
			}
			}else{
				boss.setBidcard(keyName);
				bossMapper.updateByPrimaryKey(boss);
			}
		}else{
			sign = false;
		}
		return true;
	}
	/**
	 * 老板信息提交
	 * */
	public JSONObject SubBossConfir(int id,String realname,String idcard_num,String idcar_pic ){
		JSONObject js = new JSONObject();
		JSONObject js1 = new JSONObject();
		try{
		
		Boss boss = bossMapper.selectByPrimaryKey(id);
		if(null!=boss){
			//"----");
			//boss.getBidcard());
			boss.setBrealname(realname);
			boss.setBcancel(3);
			String idcard = "";
			if(!boss.getBidcard().equals("")){
				idcard = boss.getBidcard()+";"+"img/boss/"+boss.getBid()+"/idcard/"+idcar_pic;
			
				
			}else{
				idcard =idcard_num+";"+"img/boss/"+boss.getBid()+"/idcard/"+idcar_pic;
			}		
			boss.setBidcard(idcard);
			bossMapper.updateByPrimaryKey(boss);
			js.put("name", idcar_pic);
			js1 = GetUpPowForWEB.getUpPicPow("img/boss/"+boss.getBid()+"/idcard/", 120);
			js.put("alioss", js1);
		}else{
			js.put("cord", 1);
			js.put("info", "没有该老板");
		}
		}
		catch(Exception e){
			js.put("error", e.toString());
	
		}
		return js;
	}
	/**
	 * 老板信息提交
	 * 本地版v2.0
	 * */
	public JSONObject SubAndBossConfir(int id,String realname,String idcard_num){
		JSONObject js = new JSONObject();
		Boss boss = bossMapper.selectByPrimaryKey(id);
		if(null!=boss){
			//审查前面的数据是否正常,
			if(boss.getBidcard()!=null&&!boss.getBidcard().equals("")){
				String[] b = boss.getBidcard().split(";");
				if(b.length>=3){
					boss.setBcancel(3);
					boss.setBidcard(idcard_num+";"+boss.getBidcard());
					boss.setBrealname(realname);
					if(bossMapper.updateByPrimaryKey(boss)>0){
						js.put("code", 1);
						js.put("info", "提交成功");
						js.put("api", "boss");
					}else{
						js.put("code", -1);
						js.put("info", "未知错误，更新失败");
					}
				}else{
					js.put("code", -1);
					js.put("info", "个人上传图片不满三个");
				}
			}else{
				js.put("code", -1);
				js.put("info", "没有上传过任何图片信息");
			}
		}

		return js;
	}
	/**
	 * 义工信息提交
	 * */
	public JSONObject SubMemberConfir(int id,String realname,String idcard_num,String idcar_pic ){
		JSONObject js = new JSONObject();
		JSONObject js1 = new JSONObject();
		Member member = memberMapper.selectByPrimaryKey(id);
		if(null!=member){
			member.setMrealname(realname);
			member.setMcancel("3");
			String idcard = "";
			if(member.getMidcard()!=null&&!member.getMidcard().equals("")){
				idcard = member.getMidcard()+";"+"img/boss/"+member.getMid()+"/idcard/"+idcar_pic;
			
				
			}else{
				idcard =idcard_num+";"+"img/boss/"+member.getMid()+"/idcard/"+idcar_pic;
			}	
			member.setMidcard(idcard);
			memberMapper.updateByPrimaryKey(member);
			js.put("name", idcar_pic);
			js1 = GetUpPowForWEB.getUpPicPow("img/member/"+member.getMid()+"/idcard/", 120);
			js.put("alioss", js1);
			
		}else{
			js.put("cord", 1);
			js.put("info", "没有该义工");
		}
		return js;
	}
	/**
	 * 信息提交及审查
	 * v2.0本地版
	 * */
	public JSONObject SubAndMemberConfir(int id,String realname,String idcard_num){
		JSONObject js = new JSONObject();
		Member member = memberMapper.selectByPrimaryKey(id);
		if(null!=member){
			//审查前面的数据是否正常,
			if(member.getMidcard()!=null&&!member.getMidcard().equals("")){
				String[] b = member.getMidcard().split(";");
				if(b.length>=3){
					member.setMcancel("3");
					member.setMidcard(idcard_num+";"+member.getMidcard());
					member.setMrealname(realname);
					if(memberMapper.updateByPrimaryKey(member)>0){
						js.put("code", 1);
						js.put("info", "提交成功");
						js.put("api", "member");
					}else{
						js.put("code", -1);
						js.put("info", "未知错误，更新失败");
					}
				}else{
					js.put("code", -1);
					js.put("info", "个人上传图片不满三个");
				}
			}else{
				js.put("code", -1);
				js.put("info", "没有上传过任何图片信息");
			}
		}

		return js;
	}
	/**
	 * 义工及用户的图片提交
	 * v2.0本地版
	 * */
	public JSONObject picSub(int id,String type,String fileName){
		JSONObject js = new JSONObject();
		if(type.equals("member")){
			Member member = memberMapper.selectByPrimaryKey(id);
			if(member.getMidcard()=="null"||member.getMidcard()==null||member.getMidcard()==""){
				member.setMidcard(fileName);
			}else{
				member.setMidcard(member.getMidcard()+";"+fileName);
			}
			if(memberMapper.updateByPrimaryKey(member)>0){
				js.put("code", 1);
				js.put("info", "上传成功");
				js.put("src", fileName);
			}else{
				js.put("code", -1);
				js.put("info", "上传失败");
				
			}
		}else{
			Boss boss = bossMapper.selectByPrimaryKey(id);
			if(boss.getBidcard()=="null"||boss.getBidcard()==null||boss.getBidcard()==""){
				boss.setBidcard(fileName);
			}else{
				boss.setBidcard(boss.getBidcard()+";"+fileName);
			}
			if(bossMapper.updateByPrimaryKey(boss)>0){
				js.put("code", 1);
				js.put("info", "上传成功");
				js.put("src", fileName);
			}else{
				js.put("code", -1);
				js.put("info", "上传失败");
				
			}
		}
		
		return js;
		
	}
	/**
	 * 客栈图片信息上传
	 * */
	public void sumHostelConfirm(int hid,String zhizhao){
		JSONObject js = new JSONObject();
		
		Hostel hostel = hostelMapper.selectByPrimaryKey(hid);
		if(null!=hostel){
			hostel.setPauthentic("3");
			
			hostel.setPbuscard(zhizhao);
			if(hostelMapper.updateByPrimaryKey(hostel)>0){
				js.put("cord", 1);
				js.put("info", "成功放入");
				js.put("src", zhizhao);
			}else{
				js.put("cord", -1);
				js.put("info", "未知错误");
			}
			
		}else{
			js.put("cord", -1);
			js.put("info", "没有该旅店");
		}
		
	}
}
