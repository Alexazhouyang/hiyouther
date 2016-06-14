package com.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mybatis.entity.Answer;
import com.mybatis.entity.Apply;
import com.mybatis.entity.Boss;
import com.mybatis.entity.Collect;
import com.mybatis.entity.Comment;
import com.mybatis.entity.Hostel;
import com.mybatis.entity.Member;
import com.mybatis.entity.Memberpicture;
import com.mybatis.entity.Picture;
import com.mybatis.entity.Proposedreport;
import com.mybatis.entity.ProposedreportWithBLOBs;
import com.mybatis.entity.Push;
import com.mybatis.entity.Recruit;
import com.mybatis.entity.RecruitWithBLOBs;
import com.mybatis.mapper.AnswerMapper;
import com.mybatis.mapper.ApplyMapper;
import com.mybatis.mapper.BossMapper;
import com.mybatis.mapper.CollectMapper;
import com.mybatis.mapper.CommentMapper;
import com.mybatis.mapper.HostelMapper;
import com.mybatis.mapper.MemberMapper;
import com.mybatis.mapper.MemberpictureMapper;
import com.mybatis.mapper.PictureMapper;
import com.mybatis.mapper.ProposedreportMapper;
import com.mybatis.mapper.PushMapper;
import com.mybatis.mapper.RecruitMapper;
import com.tool.FianlOssData;
import com.tool.GetPicForWeb;
import com.tool.GetUpPowForWEB;
import com.tool.ImageCompress;
import com.tool.OssPicAndFileOutput;

@Service
@Transactional
public class ConsumerService {
	@Resource
	MemberMapper m;
	@Resource
	ApplyMapper a;
	@Resource
	RecruitMapper r;
	@Resource
	HostelMapper h;
	@Resource
	CollectMapper c;
	@Resource
	CommentMapper com;
	@Resource
	AnswerMapper an;
	@Resource
	BossMapper b;
	@Resource
	PushMapper pu;
	@Resource
	PictureMapper pi;
	@Resource
	MemberpictureMapper mp;
	@Resource
	ProposedreportMapper rp;
	public com.alibaba.fastjson.JSONObject updatePicture(MultipartFile photo, int mid,
			HttpServletRequest request,String name,int pid) throws IllegalStateException, IOException {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		Memberpicture picture = new Memberpicture();
		if (photo != null) {
			OssPicAndFileOutput ossp = new OssPicAndFileOutput();
			picture.setMpaddress("img/member/" + mid + "/picture/" + name);
			picture.setMid(mid);picture.setMpid(pid);
			if (mp.updateByPrimaryKeySelective(picture) > 0) {
				String path = request.getServletContext().getRealPath("img/member/" + mid + "/picture/");
				if (photo.getSize() >= 1048576) {
					ImageCompress img = new ImageCompress();
					InputStream input=img.compressPic(photo.getInputStream(), path, name);
					ossp.updateWEB("img/member/" + mid + "/picture/" + name, input);
				} else {
					ossp.updateWEB("img/member/" + mid + "/picture/" + name, photo.getInputStream());
				}
				j.put("img", GetPicForWeb.getPicUrl("img/member/" + mid + "/picture/" + name,60));
				j.put("code", 1);
				j.put("info", "成功");

			} else {
				j.put("code", -1);
				j.put("info", "失败");
			}
		} else {
			j.put("code", -1);
			j.put("info", "失败");
		}
		return j;
	}
	public com.alibaba.fastjson.JSONObject insertPicture(MultipartFile photo, int mid,
			HttpServletRequest request,String name) throws IllegalStateException, IOException {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		Memberpicture picture = new Memberpicture();
			if (photo != null) {
			try{
			OssPicAndFileOutput ossp = new OssPicAndFileOutput();
			picture.setMpaddress("img/member/" + mid + "/picture/" + name);
			picture.setMid(mid);
			if (mp.insertSelective(picture) > 0) {
				String path = request.getServletContext().getRealPath("img/member/" + mid + "/picture/");
				if (photo.getSize() >= 1048576) {
					ImageCompress img = new ImageCompress();
					InputStream input=img.compressPic(photo.getInputStream(), path, name);
					ossp.updateWEB("img/member/" + mid + "/picture/" + name, input);
				} else {
					ossp.updateWEB("img/member/" + mid + "/picture/" + name, photo.getInputStream());
				}
				j.put("img", GetPicForWeb.getPicUrl("img/member/" + mid + "/picture/" + name,60));
			    j.put("pid", mp.countByExample());
				j.put("code", 1);
				j.put("info", "成功");

			} else {
				j.put("code", -1);
				j.put("info", "失败");
			}
			}catch(Exception e){
				j.put("code", -1);
				j.put("info", "失败请重试");
			}
		} else {
			j.put("code", -1);
			j.put("info", "失败");
		}
		return j;
	}
	public JSONObject getData(String state,int mid,int page, int rows) {
		JSONObject json=new JSONObject();
		try{
//			Member member=m.selectByPrimaryKey(mid);
//              j.put("touxiang", member.getMtouxiang());j.put("sex", member.getMsex());
//              j.put("name", member.getMemname());j.put("location", member.getMaddress());
//              j.put("sign", member.getMcredit());j.put("realname", member.getMrealname());
//              j.put("describe", member.getMresume());j.put("contact", member.getMcontact());
//              String sign=member.getMsign();
//      		JSONArray ja=new JSONArray();
//              if(sign!=null&&sign.split(";").length>1)
//            	  for(String tag:sign.split(";"))
//            		  ja.add(tag);
//              j.put("tag",ja);
              JSONArray json_array=new JSONArray();
              List<Apply> list_apply= a.selectByExample(state,mid,page,rows);
              for(Apply apply:list_apply){
            	  JSONObject apply_json=new JSONObject();
            	  apply_json.put("rid", apply.getRid());apply_json.put("aid", apply.getAid()); 
            	  apply_json.put("refuse", apply.getArefuse()); 
            	  Recruit recruit=r.selectByPrimaryKey(apply.getRid());
            	  if(recruit!=null){
            	Hostel hostel=h.selectByPrimaryKey(recruit.getHid());
            	  if(hostel!=null){
            	  apply_json.put("hid",recruit.getHid());
            	  if(hostel.getHphone()==null||hostel.getHphone().equals(""))
            	   apply_json.put("phone",JSON.parseObject("{\"sj\":\"null\",\"sjs\":false,\"wx\":\"null\",\"wxs\":false,\"qq\":\"null\",\"qqs\":false}"));	  
            	  else
                	apply_json.put("phone",JSON.parseObject(hostel.getHphone()));    	 
            		  Picture picture=pi.selectByRid(recruit.getRid());
            	  if(picture!=null&&!picture.getPicaddress().equals(""))
            	  apply_json.put("img",GetPicForWeb.getPicUrl(picture.getPicaddress(),60)); 
            	  else
            	  apply_json.put("img",GetPicForWeb.getPicUrl(null,60));   
            	  apply_json.put("time", d.format(apply.getAtime())); 
            	  apply_json.put("schedule", apply.getAschedule());
            	  apply_json.put("name",recruit.getRname());  apply_json.put("contact", hostel.getHtel());
            	  json_array.add(apply_json);
            	  }
            	  }
              }
              json.put("data",json_array);
              json.put("size",a.countByapply(mid,state));
  			  json.put("info","获取成功");
  			  json.put("code",1);
		}catch(Exception e){
			e.printStackTrace();
			json.put("info","获取失败");
			json.put("code",-1);
		}
		return json;
	}
	public com.alibaba.fastjson.JSONObject upTouXiang(int mid,String touxiang,MultipartFile file){
		com.alibaba.fastjson.JSONObject j=new com.alibaba.fastjson.JSONObject();
		com.alibaba.fastjson.JSONObject j1=new com.alibaba.fastjson.JSONObject();
		Member member=m.selectByPrimaryKey(mid);
		member.setMtouxiang("img/member/"+mid+"/headpic/"+touxiang);
		if(m.updateByPrimaryKeySelective(member)>0){
			String path = "img/member/"+mid+"/headpic/"+touxiang;
			try {
				OssPicAndFileOutput.updateWEB(path, file.getInputStream());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j.put("code",1);
			j.put("img", GetPicForWeb.getPicUrlForOption(path,1,FianlOssData.getHeadpicu()));
		}
		else{
			j.put("info","插入失败");
			j.put("code",-1);
	    }
		return j;
	}
	public com.alibaba.fastjson.JSONObject insertData(int mid,String sex,String name,String sign,String location,String[]tag) {
		com.alibaba.fastjson.JSONObject json=new com.alibaba.fastjson.JSONObject();
		Member member=new Member();;
		try{
			member.setMid(mid);
			member.setMsex(sex);

			member.setMemname(name);member.setMcredit(sign);member.setMaddress(location);
			String msign="";
			if(tag!=null)
			for(String t:tag){
				System.out.println(t);
			msign+=t+";";
			}
			member.setMsign(msign);
			if(m.updateByPrimaryKeySelective(member)>0){	
				json.put("info","插入成功");
				json.put("code",1);
			}
			else{
				json.put("info","插入失败");
				json.put("code",-1);
		    }
		}catch(Exception e){
			e.printStackTrace();
			json.put("info","获取失败");
			json.put("code",-1);
		}
		return json;
	}
	public JSONObject insertCV(int mid,String realname,String describe,String contact,String age) {
		JSONObject json=new JSONObject();
		Member member=new Member();;
		try{
			member.setMid(mid);member.setMrealname(realname);member.setMresume(describe);;
			member.setMcontact(contact);			member.setMtel(age);
			if(m.updateByPrimaryKeySelective(member)>0){
			    json.put("code",1);
			    json.put("info","插入成功");
				}
			else{
				json.put("info","插入失败");
				json.put("code",-1);
		    }
		}catch(Exception e){
			e.printStackTrace();
			json.put("info","获取失败");
			json.put("code",-1);
		}
		return json;
	}
	public JSONObject insertReport(String name, String content) {
		JSONObject json=new JSONObject();
		ProposedreportWithBLOBs report=new ProposedreportWithBLOBs();
		try{
			report.setPtype(name);report.setPcontent(content);
			if(rp.updateByPrimaryKeySelective(report)>0){
			    json.put("code",1);
			    json.put("info","插入成功");
				}
			else{
				json.put("info","插入失败");
				json.put("code",-1);
		    }
		}catch(Exception e){
			e.printStackTrace();
			json.put("info","获取失败");
			json.put("code",-1);
		}
		return json;
	}
	public JSONObject deleteApply(int aid) {
		JSONObject json=new JSONObject();
		Apply apply=new Apply();
		try{
			apply.setAschedule("");
			if(a.deleteByPrimaryKey(aid)>0){
			    json.put("code",1);
			    json.put("info","取消投递成功");
				}
			else{
				json.put("info","取消投递失败");
				json.put("code",-1);
		    }
		}catch(Exception e){
			e.printStackTrace();
			json.put("info","获取失败");
			json.put("code",-1);
		}
		return json;
	}
	public JSONObject cancel(int aid,int bid) {
		JSONObject json=new JSONObject();
		try{
		     Apply ap = a.selectByPrimaryKey(aid);
			if(a.deleteByPrimaryKey(aid)>0){
			    json.put("code",1);
			    json.put("info","取消投递成功");
			     Member member=m.selectByPrimaryKey(ap.getMid());
				 Recruit recruit = r.selectByPrimaryKey(ap.getRid());
				 Push push=new Push();
				 push.setIflook("0");
				 push.setPtime(new Date());
				 push.setPcontent("向您的招聘"+recruit.getRname()+"报名的义工"+member.getMemname()+"取消出发");
				 push.setPname("招聘信息");push.setType(1);push.setUid(bid);					
			     pu.insertSelective(push);
			}
			else{
				json.put("info","取消投递失败");
				json.put("code",-1);
		    }
		}catch(Exception e){
			e.printStackTrace();
			json.put("info","获取失败");
			json.put("code",-1);
		}
		return json;
	}
	public JSONObject getCollect (int mid,int page,int rows) {
		JSONObject json=new JSONObject();
		try{
              JSONArray json_array=new JSONArray();
      	    List<Collect> list_Collect=c.selectByExample(mid, page, rows);
              for(Collect collect:list_Collect){
            	  JSONObject collect_json=new JSONObject();
            	  RecruitWithBLOBs recruit=r.selectByPrimaryKey(collect.getHid());
            	  if(recruit!=null){
            	  collect_json.put("rid",recruit.getRid());  collect_json.put("hid",recruit.getHid());
            	  collect_json.put("sid",collect.getId()); collect_json.put("task",recruit.getRtask());
            	  collect_json.put("name",recruit.getRname()); collect_json.put("time",d.format(recruit.getRmonth())+"-"+d.format(recruit.getRsctime()));
          		  Picture picture=pi.selectByRid(recruit.getRid());
            	  if(picture!=null&&!picture.getPicaddress().equals(""))
            		  collect_json.put("img",GetPicForWeb.getPicUrl(picture.getPicaddress(),60)); 
            	  else
            		  collect_json.put("img",GetPicForWeb.getPicUrl(null,60));   
            	  json_array.add(collect_json);
            	  }
              }
            json.put("data",json_array);
            json.put("size",c.countByMid(mid));
            if(list_Collect.size()!=0){
  			json.put("info","获取成功");
  			json.put("code",1);
            }
  			else{
  	  			json.put("info","无数据");
  	  			json.put("code",1);
  			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("info","获取失败");
			json.put("code",-1);
		}
		return json;
	}
	SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd");
	
	 public JSONObject changeApply(int aid,int schedule,String refuse){
		 JSONObject j=new JSONObject();
			try{
				Apply apply=new Apply();
				apply.setAid(aid);apply.setAschedule(schedule+"");
				apply.setArefuse(refuse);
				if(a.updateByPrimaryKeySelective(apply)>0){
				    j.put("code",1);
				    j.put("info","改变申请表成功");
				    Push push = new Push();
					Apply ap = a.selectByPrimaryKey(aid);
					Recruit recruit = r.selectByPrimaryKey(ap.getRid());
					push.setIflook("0");
					switch (schedule) {
					case 3010:
						push.setPcontent("您的招聘<a href=\"../../api/infoJSP?id=" + ap.getRid() + "\">" + recruit.getRname()
								+ "</a>" + "有一名义工已评价");
						break;
					}
					push.setPname("");
					push.setType(1);
					push.setUid(ap.getMid());
					push.setPtime(new Date());
					pu.insertSelective(push);
					}
				else{
					j.put("info","改变申请表成功");
					j.put("code",-1);
			    }
			}catch(Exception e){
				e.printStackTrace();
				j.put("info","改变申请表失败");
				j.put("code",-1);
			}
			return j;
	 }
	 
	public JSONObject getMcomment (int mid,int type, int page, int rows) {
		JSONObject j=new JSONObject();
		try{
              JSONArray json_array=new JSONArray();
              List<Comment> list_Comment= com.selectByM(type, mid,page,rows);
              for(Comment comment:list_Comment){
      			JSONObject json=new JSONObject();
      			JSONObject json_minor=new JSONObject();
      			JSONArray answer_json_array=new JSONArray();
      			Recruit recruit=r.selectByPrimaryKey(comment.getRid());
      			if(recruit!=null){
      			json.put("id",comment.getCid());
      			json.put("title",recruit.getRname());
      			json.put("rid",recruit.getRid());
      			json.put("time",d.format(comment.getCtime()));json.put("content",comment.getCcontent());
      		
      				Member member=m.selectByPrimaryKey(comment.getMid());
      				if(member!=null){
      				json_minor.put("name",member.getMemname());json_minor.put("type","member");
      				json_minor.put("headpic",GetPicForWeb.getPicUrl(member.getMtouxiang(),60));json_minor.put("id",comment.getMid());
      				if(member.getMcancel()!=null&&member.getMcancel().equals("2"))
      				json_minor.put("vercard",1);
      				else
      				json_minor.put("vercard",0);
      				}
      				json.put("user",json_minor);
      			
      			List<Answer> l1=an.selectByExample(comment.getCid());
      			for(Answer answer:l1){
      				JSONObject answer_json=new JSONObject();
      				answer_json.put("id ", answer.getAnid());	answer_json.put("time", d.format(answer.getAntime()));
      				answer_json.put("content", answer.getCcontent());
      				if(answer.getType()!=null&&answer.getType().equals("boss")){
      					JSONObject answer_json_minor=new JSONObject();
      					Boss boss=b.selectByPrimaryKey(answer.getSpeakerid());
      					if(boss!=null){
      						answer_json_minor.put("name",boss.getBusername());answer_json_minor.put("type",answer.getType());
      						answer_json_minor.put("headpic",GetPicForWeb.getPicUrl(boss.getBtouxiang(),60));
      						answer_json_minor.put("id",answer.getSpeakerid());answer_json_minor.put("listener",answer.getListener());
      					if(boss.getBcancel()!=null&&boss.getBcancel().equals("2"))
      						answer_json_minor.put("vercard",1);
      						else
      						answer_json_minor.put("vercard",0);
      					}
      					answer_json.put("user",answer_json_minor);
      				}else{
      					JSONObject answer_json_minor=new JSONObject();
      					Member answer_member=m.selectByPrimaryKey(answer.getSpeakerid());
      					if(answer_member!=null){
      						answer_json_minor.put("name",answer_member.getMemname());answer_json_minor.put("type",answer.getType());
      						answer_json_minor.put("headpic",GetPicForWeb.getPicUrl(answer_member.getMtouxiang(),60));
      						answer_json_minor.put("id",answer.getSpeakerid());
      						answer_json_minor.put("name",answer.getListener());
      					if(answer_member.getMcancel()!=null&&answer_member.getMcancel().equals("2"))
      						answer_json_minor.put("vercard",1);
      					else
      						answer_json_minor.put("vercard",0);
      					}
      					answer_json.put("user",answer_json_minor);
      					
      				}
      				answer_json_array.add(answer_json);
      			}
      			json.put("answer", answer_json_array);
      			json_array.add(json);
      			}
      		}
      		if(list_Comment.size()!=0){
      		j.put("size", com.countByMid(mid,type));
      		j.put("info","成功");
      		j.put("code",1);
      		j.put("data", json_array);
      		}else{
      			j.put("info","没数据");
      			j.put("code",1);
      		}
		}catch(Exception e){
			e.printStackTrace();
			j.put("info","获取失败");
			j.put("code",-1);
		}
		return j;
	}
}
