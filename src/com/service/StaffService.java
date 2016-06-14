package com.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.HttpClient;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.mybatis.entity.Answer;
import com.mybatis.entity.Apply;
import com.mybatis.entity.Area;
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
import com.mybatis.mapper.AreaMapper;
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
import com.service.ThreadPage.EmailByMemberPass;
import com.service.ThreadPage.EmailByPushBoss;
import com.tool.FianlOssData;
import com.tool.GetPicForWeb;

@Service
@Transactional
public class StaffService {
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
	OtherPushByHiyoutherService v;
	@Resource
	ProposedreportMapper report;
	@Resource
	MemberpictureMapper mp;
	@Resource
	PushMapper pu;
	SimpleDateFormat date_form = new SimpleDateFormat("yyyy-MM-dd");

	public JSONObject getAllHostel(int page, String mid, int pagesize, String arid, String month, String sctime,
			String name) {
		JSONObject j = new JSONObject();
		JSONArray ja = new JSONArray();
		try {
			List<RecruitWithBLOBs> l = r.selectByAll(page, pagesize, arid, month, sctime, name);
			hostelAPI(mid, j, ja, l);
			j.put("size", r.countByAll(month, sctime, arid, name));
		} catch (Exception e) {
			e.printStackTrace();
			j.put("info", "获取失败");
			j.put("code", -1);
		}
		return j;
	}

	public JSONObject getHostel(int page, String mid, int pagesize, String arid, String month, String sctime,
			String name) {
		JSONObject j = new JSONObject();
		JSONArray ja = new JSONArray();
		try {
			List<RecruitWithBLOBs> l = r.selectByType(page, pagesize, arid, month, sctime, name);
			if(r.countByType(month, sctime, arid, name)>17)
			j.put("size",18);
			else
			j.put("size", r.countByType(month, sctime, arid, name));
			hostelAPI(mid, j, ja, l);
		} catch (Exception e) {
			e.printStackTrace();
			j.put("info", "获取失败");
			j.put("code", -1);
		}
		return j;
	}

	public JSONObject getTag() {
		JSONObject tag_json = new JSONObject();
		JSONArray tag_json_array = new JSONArray();
		try {
			List<Area> l = a.selectByExample();
			for (Area ar : l) {
				JSONObject j1 = new JSONObject();
				j1.put("id", ar.getArid());
				j1.put("name", ar.getArname());
				j1.put("country", ar.getArcountry());
				j1.put("size", l.size());
				tag_json_array.add(j1);
			}
			tag_json.put("data", tag_json_array);
			if (l.size() != 0) {
				tag_json.put("info", "获取成功");
				tag_json.put("code", 1);
			} else {
				tag_json.put("info", "无数据");
				tag_json.put("code", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			tag_json.put("info", "获取失败");
			tag_json.put("code", -1);
		}
		return tag_json;
	}

	public JSONObject collect(String hid, String mid) {
		JSONObject j = new JSONObject();
		if (co.ifCollect(hid, mid).size() != 0) {
			j.put("info", "重复收藏");
			j.put("code", 0);
		} else {
			Collect c = new Collect();
			c.setHid(Integer.parseInt(hid));
			c.setMid(Integer.parseInt(mid));
			if (co.insertSelective(c) > 0) {
				j.put("code", 1);
				j.put("info", "收藏成功");
			} else {
				j.put("info", "收藏失败");
				j.put("code", -1);
			}
		}
		return j;
	}

	public JSONObject cancelcollect(int hid) {
		JSONObject j = new JSONObject();
		if (co.deleteByHotel(hid) > 0) {
			j.put("info", "取消收藏成功");
			j.put("code", 1);
		} else {
			j.put("code", -1);
			j.put("info", "取消收藏失败");
		}

		return j;
	}

	public JSONObject getHcomment(int hid, int type, int page, int pagesize) {
		JSONObject j = new JSONObject();
		JSONArray ja = new JSONArray();
		List<Comment> Comment_l = c.selectByH(page, pagesize, type + "", hid);

		j.put("size", c.countByH(type, hid));
		try {
			commentAPI(j, ja, Comment_l);
		} catch (Exception e) {
			e.printStackTrace();
			j.put("info", "获取失败");
			j.put("code", -1);
		}
		return j;
	}
	public JSONObject getApplyDetail(int aid) {
		JSONObject j = new JSONObject();
		JSONArray ja = new JSONArray();
	
		try {
			Apply apply=ap.selectByPrimaryKey(aid);
			if(apply!=null){
			Member member=m.selectByPrimaryKey(apply.getMid());
			if(member!=null){
				JSONObject json = new JSONObject();
				json.put("name", member.getMrealname());
				json.put("content", member.getMresume());
				json.put("contact", member.getMcontact());
				String sign = member.getMsign();
				JSONArray ja1 = new JSONArray();
				if (sign != null && sign.split(";").length > 1)
					for (String tag : sign.split(";"))
						ja1.add(tag);
				json.put("tag", ja1);
				json.put("age", member.getMtel());
				 List<Memberpicture> list=mp.selectByExample(member.getMid());
				 if(list.size()>0)
				json.put("picture",GetPicForWeb.getPicUrl(list.get(0).getMpaddress(),60));
				json.put("address", member.getMaddress());
				json.put("idcard", member.getMcancel());
				json.put("score", member.getMreport());
				json.put("sign", member.getMcredit());
				j.put("data",json);
				j.put("info", "成功");
				j.put("code", 1);
				}else{
					j.put("info", "没有用户");
					j.put("code", -1);
				}
			}else{
				j.put("info", "没有申请表");
				j.put("code", -1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.put("info", "获取失败");
			j.put("code", -1);
		}
		return j;
	}
	public JSONObject getRcomment(int rid, int type, int page, int pagesize) {
		JSONObject j = new JSONObject();
		JSONArray ja = new JSONArray();
		List<Comment> Comment_l = c.selectByR(page, pagesize, type + "", rid);
		String score = c.countByAVG(rid);
		score = score == null ? "3" : score;
		j.put("score", score);
		j.put("size", c.countByR(type, rid));
		try {
			commentAPI(j, ja, Comment_l);
		} catch (Exception e) {
			e.printStackTrace();
			j.put("info", "获取失败");
			j.put("code", -1);
		}
		return j;
	}

	public JSONObject insertComment(int rid, int type, int mid, String comment, String score) {
		JSONObject j = new JSONObject();
		JSONObject j1 = new JSONObject();
		Comment com = new Comment();
		com.setMid(mid);
		com.setRid(rid);
		com.setCtype(type + "");
		com.setCtime(new Date());
		com.setCcontent(comment);
		com.setScore(score);
		com.setCancel(0);
		List<String> schedule = c.selectByschedule(mid, rid);
		for (String sch : schedule) {
			if (sch != null && type == 1 && sch.equals("0") || sch.equals("-1")) {
				j.put("code", -1);
				j.put("info", "旅店还未通过申请");
				return j;
			}
		}
		if (c.insertSelective(com) > 0) {
			Member member = m.selectByPrimaryKey(mid);
			j.put("img", GetPicForWeb.getPicUrl(member.getMtouxiang(), 60));
			j.put("name", member.getMemname());
			j.put("type", "member");
			j1.put("cid", c.getLastId());
			j1.put("aid", mid);
			j.put("data", j1);
			j.put("code", 1);
			j.put("info", "成功");
		} else {
			j.put("code", -1);
			j.put("info", "失败");
		}
		return j;
	}

	public JSONObject insertAnswer(int cid, int lid, int mid, String mname, String answer, String type) {
		JSONObject j = new JSONObject();
		Answer ans = new Answer();
		ans.setAntime(new Date());
		ans.setCcontent(answer);
		ans.setCid(cid);
		ans.setSpeakerid(mid);
		ans.setSpeaker(mname);
		ans.setType(type);
		ans.setListenerid(lid);
		if (an.insertSelective(ans) > 0) {
			j.put("code", 1);
			j.put("info", "成功");

		} else {
			j.put("code", -1);
			j.put("info", "失败");
		}
		if (type.equals("member")) {
			Member member = m.selectByPrimaryKey(mid);
			j.put("img", GetPicForWeb.getPicUrl(member.getMtouxiang(), 60));
			j.put("name", member.getMemname());
			j.put("type", "member");
			if (member.getMcancel() != null && member.getMcancel().equals("2"))
				j.put("vercard", 1);
			else
				j.put("vercard", 0);
		} else {
			Boss boss = b.selectByPrimaryKey(mid);
			j.put("img", GetPicForWeb.getPicUrl(boss.getBtouxiang(), 60));
			j.put("name", boss.getBusername());
			j.put("type", "boss");
			if (boss.getBcancel() != null && boss.getBcancel().equals("2"))
				j.put("vercard", 1);
			else
				j.put("vercard", 0);
		}
		j.put("cid",cid);
		j.put("aid",mid);
		return j;
	}

	// public JSONObject updateScore (int cid,String score) {
	// JSONObject j=new JSONObject();
	// Hostel hostel=new Hostel();
	// hostel.setHid(cid);hostel.setHscore(score);
	// if(h.updateByPrimaryKeySelective(hostel)>0){
	// j.put("code",1);
	// j.put("info","成功");
	// }
	// else{
	// j.put("code",-1);
	// j.put("info","失败");
	// }
	// return j;
	// }
	public JSONObject insertApply(int rid, int mid, String time) {
		JSONObject j = new JSONObject();
		Member me = m.selectByPrimaryKey(mid);
		List apply_list = ap.ifApply(mid + "", rid + "");
		if (apply_list.size() == 0 && me.getMresume() != null && me.getMcontact() != null
				&& me.getMrealname() != null) {
			Apply record = new Apply();
			record.setAschedule("1000");
			record.setAinsertime(new Date());
			try {
				
				record.setAtime(date_form.parse(time));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			record.setMid(mid);
			record.setRid(rid);
		
			Recruit recruit=r.selectByPrimaryKey(rid);
			Hostel hostel=null;
			if(recruit!=null){
				hostel=h.selectByPrimaryKey(recruit.getHid());
				if(hostel!=null){
					Push push=new Push();
					 push.setIflook("0");
					 push.setPtime(new Date());
					 push.setPcontent("您的招聘"+recruit.getRname()+"有一份新简历<a href=\"requests.html?id="+hostel.getHid()+"&name="+hostel.getHname()+"\">点击查看</a>"
						);
					 push.setPname("");push.setType(1);push.setUid(hostel.getBid());					
				     pu.insertSelective(push);
				}
					
			}
			if(ap.insertSelective(record)>0){
			j.put("info", "成功申请");
			j.put("code", 1);
			if(hostel!=null){
				Boss boss=b.selectByPrimaryKey(hostel.getBid());
				if(boss.getBphone()!=null){
					try {
						v.alppyBossPush(boss.getBphone(), boss.getBusername());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(boss!=null&&boss.getBemail()!=null){
					Thread thread=new Thread(new EmailByPushBoss(boss.getBemail()));
					thread.start();
				}
			}
			}else{
				j.put("info", "申请失败");
				j.put("code", -1);
			}
		} else if (apply_list.size() != 0) {
			j.put("info", "重复申请");
			j.put("code", 0);
		} else {
			j.put("info", "申请失败您还有未完善的简历信息");
			j.put("code", -1);
		}
		return j;
	}

	public JSONObject getContent(int hid, int page, int rows) {
		JSONObject j1 = new JSONObject();
		JSONArray ja1 = new JSONArray();
		List<RecruitWithBLOBs> Recruit_l = r.selectByhistory(hid + "", page, rows);
		for (RecruitWithBLOBs recruit : Recruit_l) {
			JSONObject j = new JSONObject();
			j.put("task", recruit.getRtask());
			j.put("competence", recruit.getRcompetence());
			j.put("rsynopsis", recruit.getRsynopsis());
			j.put("number", recruit.getRnumbers());
			j.put("month", date_form.format(recruit.getRmonth()) + ";" + date_form.format(recruit.getRsctime()));
			ja1.add(j);
		}
		j1.put("data", ja1);
		j1.put("info", "无数据");
		j1.put("code", 1);

		return j1;
	}

	public JSONObject getInfo(int hid, int page, int rows) {
		JSONObject j = new JSONObject();
		JSONArray ja1 = new JSONArray();
		try {
			List<RecruitWithBLOBs> Recruit_l = r.selectByhistory(hid + "", page, rows);
			// RecruitWithBLOBs recruit=r.selectByPrimaryKey(rid);
			// Hostel hostel=h.selectByPrimaryKey(hid);
			// if(recruit!=null&&hostel!=null){
			// List<Picture> Pictur_l=p.selectByExample(recruit.getHid()+"");
			// for(Picture pi:Pictur_l){
			// ja.add(GetPicForWeb.getPicUrl(pi.getPicaddress(),60));
			// }
			// j.put("rid",recruit.getRid());
			// j.put("hid",recruit.getHid());
			// if(co.ifCollect(mid,recruit.getHid()+"").size()!=0)
			// j.put("ifcollect", 1);
			// else
			// j.put("ifcollect",0);
			// j.put("photo",ja);
			// j.put("tagname",hostel.getHtag());
			// j.put("synopsis",hostel.getHsynopsis());
			// j.put("task",recruit.getRtask());
			// j.put("competence",recruit.getRcompetence());
			// j.put("rsynopsis",recruit.getRsynopsis());
			// j.put("number",recruit.getRnumbers());
			// j.put("month",d.format(recruit.getRmonth())+";"+d.format(recruit.getRsctime()));
			for (RecruitWithBLOBs re : Recruit_l) {
				JSONObject j1 = new JSONObject();
				j1.put("id", re.getRid());
				j1.put("time", date_form.format(re.getRsctime())+"到"+ date_form.format(re.getRmonth()));
				j1.put("number",ap.countByRid(re.getRid()));
				j1.put("state", re.getRcancel());
				j1.put("content", r.countBycomment(re.getRid() + "", 0));
				j1.put("answer", r.countBycomment(re.getRid() + "", 1));
				j1.put("name", re.getRname());
				ja1.add(j1);
			}
			j.put("data", ja1);
			j.put("size", r.countByhistory(hid));
			j.put("info", "成功");
			j.put("code", 1);
			// }else{
			if (Recruit_l.size() == 0) {
				j.put("info", "无数据");
				j.put("code", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.put("info", "失败");
			j.put("code", -1);
		}
		return j;
	}
	public JSONObject insertReport(String content) {
		JSONObject j = new JSONObject();
		ProposedreportWithBLOBs propose=new ProposedreportWithBLOBs();
		propose.setPcontent(content);
		if(report.insertSelective(propose)>0){
			j.put("code", 1);
			j.put("info","成功");
		}else{
			j.put("code", -1);
			j.put("info","失败");
		}
		return j;
	}

	public void commentAPI(JSONObject j, JSONArray ja, List<Comment> Comment_l) throws Exception {

		for (Comment comment : Comment_l) {
			JSONObject j1 = new JSONObject();
			JSONObject j2 = new JSONObject();
			j1.put("id", comment.getCid());
			j1.put("time", date_form.format(comment.getCtime()));
			j1.put("content", comment.getCcontent());
			Member member = m.selectByPrimaryKey(comment.getMid());
			if (member != null) {
				j2.put("name", member.getMemname());
				j2.put("type", "member");
				if(member.getMtouxiang()!=null&&member.getMtouxiang().indexOf("http")>=0){
					j2.put("headpic", member.getMtouxiang());
				}else{
					j2.put("headpic", GetPicForWeb.getPicUrlForOption(member.getMtouxiang(), 60,FianlOssData.getHeadpicu()));
				}
				j2.put("id", comment.getMid());
				if (member.getMcancel() != null && member.getMcancel().equals("2"))
					j2.put("vercard", 1);
				else
					j2.put("vercard", 0);
			}
			j1.put("user", j2);
            int i=an.countByExample(comment.getCid());
		    if(i==0)
		    j1.put("ifanswer", "no");
		    else
		    j1.put("ifanswer", "yes");	
			ja.add(j1);
		}
		if (Comment_l.size() != 0) {
			j.put("info", "成功");
			j.put("code", 1);
			j.put("data", ja);
		} else {
			j.put("info", "没数据");
			j.put("code", 1);
		}
	}
public JSONObject getAnswer(int cid,int page,int rows){
	Comment comment=c.selectByPrimaryKey(cid);
	List<Answer> l1 = an.selectByCid(cid, page, rows);
	JSONObject j1 = new JSONObject();
	JSONArray ja1=new JSONArray();
	for (Answer answer : l1) {
		Recruit recruit = r.selectByPrimaryKey(comment.getRid());
		if(recruit!=null){
		JSONObject j3 = new JSONObject();
		JSONObject j4 = new JSONObject();
		j3.put("id", answer.getAnid());
		j3.put("time", date_form.format(answer.getAntime()));
		j3.put("content", answer.getCcontent());
	
		j3.put("title", recruit.getRname());
		j3.put("rid", recruit.getRid());
		if (answer.getType() != null && answer.getType().equals("boss")) {
			Boss boss = b.selectByPrimaryKey(answer.getSpeakerid());
			if (boss != null) {
				j4.put("name", boss.getBusername());
				j4.put("type", answer.getType());
				if(boss.getBtouxiang()!=null&&boss.getBtouxiang().indexOf("http")>=0){
					j4.put("headpic", boss.getBtouxiang());
				}else{
					j4.put("headpic", GetPicForWeb.getPicUrlForOption(boss.getBtouxiang(), 60,FianlOssData.getHeadpicu()));
				}
				j4.put("id", boss.getBid());
				j4.put("listenerId", answer.getListenerid());
				j4.put("listener", answer.getListener());
				if (boss.getBcancel() != null && boss.getBcancel().equals("2"))
					j4.put("vercard", 1);
				else
					j4.put("vercard", 0);
			}
			j3.put("user", j4);
		} else {
			Member answer_member = m.selectByPrimaryKey(answer.getSpeakerid());
			if (answer_member != null) {
				j4.put("name", answer_member.getMemname());
				j4.put("type", answer.getType());
					if(answer_member.getMtouxiang()!=null&&answer_member.getMtouxiang().indexOf("http")>=0){
						j4.put("headpic", answer_member.getMtouxiang());
					}else{
						j4.put("headpic", GetPicForWeb.getPicUrlForOption(answer_member.getMtouxiang(), 60,FianlOssData.getHeadpicu()));
					}
				j4.put("id", answer_member.getMid());
				j4.put("listenerId", answer.getListenerid());
				j4.put("listener", answer.getListener());
				if (answer_member.getMcancel() != null && answer_member.getMcancel().equals("2"))
					j4.put("vercard", 1);
				else
					j4.put("vercard", 0);
			}
			j3.put("user", j4);
		}
		ja1.add(j3);
		}
	}
	j1.put("size", an.countByExample(cid));
	if (l1.size() != 0) {
		j1.put("info", "成功");
		j1.put("code", 1);
		j1.put("data", ja1);
	} else {
		j1.put("info", "没数据");
		j1.put("data", ja1);
		j1.put("code", 1);
	}
	return j1;
	}
	public void hostelAPI(String mid, JSONObject hostel_json, JSONArray hostel_json_array,
			List<RecruitWithBLOBs> Recruit_list) throws Exception {
		for (RecruitWithBLOBs re : Recruit_list) {
			if(re.getRsctime()!=null){
			JSONArray json_array = new JSONArray();
			List<Picture> picture_list = p.selectByExample(re.getHid() + "");
			for (Picture pi : picture_list) {
				json_array.add(GetPicForWeb.getPicUrlForOption(pi.getPicaddress(), 60, FianlOssData.getIndexhostelpic()));
				break;
			}
			JSONObject json = new JSONObject();
			Hostel he = h.selectByPrimaryKey(re.getHid());
			json.put("number", re.getRnumbers());
			json.put("hname", he.getHname());
			json.put("time", re.getRworktime());
			json.put("name", re.getRname());
			json.put("content", re.getRtask());
			json.put("hid", re.getHid());
			json.put("rid", re.getRid());
            Boss boss=b.selectByPrimaryKey(he.getBid());
			int start = re.getRsctime().getMonth() + 1;
			int end = re.getRmonth().getMonth() + 1;
			json.put("month", start + "月到" + end + "月");
			json.put("score", he.getHscore());
			json.put("photo", json_array);
			if (co.ifCollect(mid, re.getRid() + "").size() != 0)
				json.put("ifcollect", 1);
			else
				json.put("ifcollect", 0);
			json.put("authentic", he.getPauthentic());
			if(boss.getBcancel()==2&& he.getPauthentic().equals("0"))
				json.put("authentic","2");
			if(boss.getBcancel()!=2&& he.getPauthentic().equals("1"))
				json.put("authentic","1");
			if(boss.getBcancel()==2&& he.getPauthentic().equals("1"))
				json.put("authentic", "4");
			hostel_json_array.add(json);
		}
		}
		hostel_json.put("data", hostel_json_array);
		if (Recruit_list.size() != 0) {

			hostel_json.put("code", 1);
			hostel_json.put("info", "成功");
		} else {
			hostel_json.put("code", 1);
			hostel_json.put("info", "没数据");
		}
	}
}
