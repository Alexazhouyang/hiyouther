package com.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONPObject;
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
import com.mybatis.mapper.PushMapper;
import com.mybatis.mapper.RecruitMapper;
import com.service.ThreadPage.EmailByMemberPass;
import com.tool.FianlOssData;
import com.tool.GetPicForWeb;
import com.tool.GetUpPowForWEB;
import com.tool.ImageCompress;
import com.tool.OssPicAndFileOutput;

@Service
@Transactional
public class BossService {
	@Resource
	RecruitMapper r;
	@Resource
	AnswerMapper an;
	@Resource
	OtherPushByHiyoutherService op;
	@Resource
	MemberMapper m;
	@Resource
	CommentMapper c;
	@Resource
	HostelMapper h;
	@Resource
	BossMapper b;
	@Resource
	ApplyMapper a;
	@Resource
	AreaMapper ar;
	@Resource
	PictureMapper p;
	@Resource
	CollectMapper co;
	@Resource
	PushMapper pu;
	@Resource
	MemberpictureMapper mp;
	public JSONObject getBcomment(int bid, int type, int page, int rows) {
		JSONObject j = new JSONObject();
		try {
			JSONArray ja = new JSONArray();
			List<Comment> list_Comment = c.selectByB(type, bid, page, rows);
			for (Comment comment : list_Comment) {
				JSONObject j1 = new JSONObject();
				JSONObject j2 = new JSONObject();
				JSONArray ja1 = new JSONArray();
				j1.put("id", comment.getCid());
				Recruit recruit = r.selectByPrimaryKey(comment.getRid());
				j1.put("title", recruit.getRname());
				j1.put("rid", recruit.getRid());
				j1.put("time", d.format(comment.getCtime()));
				j1.put("content", comment.getCcontent());

				Member member = m.selectByPrimaryKey(comment.getMid());
				if (member != null) {
					j2.put("name", member.getMemname());
					j2.put("type", "member");
					j2.put("headpic", GetPicForWeb.getPicUrl(member.getMtouxiang(), 60));
					j2.put("id", comment.getMid());
					if (member.getMcancel() != null && member.getMcancel().equals("2"))
						j2.put("vercard", 1);
					else
						j2.put("vercard", 0);
				}
				j1.put("user", j2);

				List<Answer> l1 = an.selectByExample(comment.getCid());
				for (Answer answer : l1) {
					JSONObject j3 = new JSONObject();
					JSONObject j4 = new JSONObject();
					j3.put("id ", answer.getAnid());
					j3.put("time", d.format(answer.getAntime()));
					j3.put("content", answer.getCcontent());
					if (answer.getType() != null && answer.getType().equals("boss")) {
						Boss boss = b.selectByPrimaryKey(answer.getSpeakerid());
						if (boss != null) {
							j4.put("id", boss.getBid());
							if (bid == boss.getBid())
								j4.put("self", 1);
							else
								j4.put("self", 0);
							j4.put("name", boss.getBusername());
							j4.put("type", answer.getType());
							j4.put("headpic", GetPicForWeb.getPicUrl(boss.getBtouxiang(), 60));
							answer.getSpeakerid();
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
							j4.put("self", 0);
							j4.put("type", answer.getType());
							j4.put("headpic", GetPicForWeb.getPicUrl(answer_member.getMtouxiang(), 60));
							j4.put("id", answer.getSpeakerid());
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
				j1.put("answer", ja1);
				ja.add(j1);
			}
			if (list_Comment.size() != 0) {
				j.put("size", c.countByBid(bid, type));
				j.put("info", "成功");
				j.put("code", 1);
				j.put("data", ja);
			} else {
				j.put("info", "没数据");
				j.put("code", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.put("info", "获取失败");
			j.put("code", -1);
		}
		return j;
	}
	public JSONObject changeApply(int[] Aid,int schedule){
		 JSONObject j=new JSONObject();
			try{
				for(int aid:Aid){
				Apply apply=new Apply();
				apply.setAid(aid);apply.setAschedule(schedule+"");
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
				}
			}catch(Exception e){
				e.printStackTrace();
				j.put("info","改变申请表失败");
				j.put("code",-1);
			}
			return j;
	 }
	public JSONObject getBossData(int bid, int page, int rows) {
		JSONObject j = new JSONObject();
		try {
			// Boss boss=b.selectByPrimaryKey(bid);
			// j.put("touxiang", boss.getBtouxiang());j.put("sex",
			// boss.getBsex());
			// j.put("name",
			// boss.getBusername());j.put("location",boss.getBaddress());
			// j.put("sign", boss.getBsign());

			JSONArray ja = new JSONArray();
			List<Hostel> list_Hostel = h.selectByExample(bid, page, rows);
			for (Hostel hostel : list_Hostel) {
				JSONObject j1 = new JSONObject();
				j1.put("hid", hostel.getHid());
				j1.put("score", hostel.getHscore());
				List<Picture> list = p.selectByExample(hostel.getHid() + "");
				if (list.size() > 0)
					j1.put("img",GetPicForWeb.getPicUrlForOption(list.get(0).getPicaddress(),60,FianlOssData.getIndexhostelpic()));
				j1.put("authentic", hostel.getPauthentic());
		           Boss boss=b.selectByPrimaryKey(hostel.getBid());
				if(boss.getBcancel()==2&& hostel.getPauthentic().equals("0"))
					j1.put("authentic","2");
				if(boss.getBcancel()!=2&& hostel.getPauthentic().equals("1"))
					j1.put("authentic","1");
				if(boss.getBcancel()==2&& hostel.getPauthentic().equals("1"))
					j1.put("authentic", "4");
				j1.put("name", hostel.getHname());
				if( hostel.getHaddress()!=null&&hostel.getHaddress().indexOf("-")!=-1)
				j1.put("address", hostel.getHaddress().substring(0, hostel.getHaddress().lastIndexOf("-")));
				j1.put("hid", hostel.getHid());
				ja.add(j1);
			}
			j.put("data", ja);
			j.put("size", h.countByExample(bid));
			j.put("info", "获取成功");
			j.put("code", 1);
		} catch (Exception e) {
			e.printStackTrace();
			j.put("info", "获取失败");
			j.put("code", -1);
		}
		return j;
	}

	public com.alibaba.fastjson.JSONObject upTouXiang(int bid, String touxiang,MultipartFile file) {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		com.alibaba.fastjson.JSONObject j1 = new com.alibaba.fastjson.JSONObject();
		Boss boss = b.selectByPrimaryKey(bid);
		String path = "img/boss/" + bid + "/headpic/" + touxiang;
		boss.setBtouxiang(path);
		if (b.updateByPrimaryKeySelective(boss) > 0) {
			try {
				OssPicAndFileOutput.updateWEB(path, file.getInputStream());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j.put("code", 1);
			j.put("img", j.put("img", GetPicForWeb.getPicUrlForOption(path,1,FianlOssData.getHeadpicu())));
		} else {
			j.put("info", "获取失败");
			j.put("code", -1);
		}
		return j;
	}

	public com.alibaba.fastjson.JSONObject updateBossData(int bid, String name, String sex, String address,
			String sign) {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		Boss boss = new Boss();
		try {
			boss.setBusername(name);
			boss.setBsex(sex);
			boss.setBaddress(address);
			boss.setBsign(sign);
			boss.setBid(bid);
			if (b.updateByPrimaryKeySelective(boss) > 0) {
				j.put("info", "获取成功");
				j.put("code", 1);
			} else {
				j.put("info", "获取失败");
				j.put("code", -1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.put("info", "获取失败");
			j.put("code", -1);
		}
		return j;
	}

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public JSONObject insertRecruit(int hid, String name, String competence, String rsynopsis, String task,
			String rsctime, String rmonth, String number) {
		JSONObject j = new JSONObject();
		try {
			RecruitWithBLOBs recruit = new RecruitWithBLOBs();
			recruit.setHid(hid);
			recruit.setRname(name);
			recruit.setRcompetence(competence);
			recruit.setRsynopsis(rsynopsis);
			recruit.setRtask(task);
			recruit.setRnumbers(number);
			recruit.setRmonth(format.parse(rmonth));
			recruit.setRsctime(format.parse(rsctime));
			recruit.setRworktime(format1.format(new Date()));
			recruit.setRcancel(0);
			if (r.insertSelective(recruit) > 0) {
				j.put("code", 1);
				j.put("rid", r.selectLast());
				j.put("info", "插入招聘表成功");
				
			} else {
				j.put("info", "插入招聘表失败");
				j.put("code", -1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			j.put("info", "插入招聘表失败");
			j.put("code", -1);
		}
		return j;
	}

	public JSONObject updateRecruit(int rid, String name, String competence, String rsynopsis, String task,
			String rsctime, String rmonth, String number, int cancel) {
		JSONObject j = new JSONObject();
		try {
			RecruitWithBLOBs recruit = new RecruitWithBLOBs();
			recruit.setRname(name);
			recruit.setRcompetence(competence);
			recruit.setRsynopsis(rsynopsis);
			recruit.setRtask(task);
			recruit.setRnumbers(number);
			recruit.setRnumbers(number);
			recruit.setRworktime(format1.format(new Date()));
			if (rmonth != null && rsctime != null) {
				recruit.setRmonth(format.parse(rmonth));
				recruit.setRsctime(format.parse(rsctime));
			}
			recruit.setRcancel(cancel);
			recruit.setRid(rid);
			if (r.updateByPrimaryKeySelective(recruit) > 0) {
				j.put("code", 1);
				j.put("info", "更改招聘表成功");
			} else {
				j.put("info", "更改招聘表失败");
				j.put("code", -1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			j.put("info", "更改招聘表失败");
			j.put("code", -1);
		}
		return j;
	}

	SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");

	public JSONObject makeScore(int id, String score) {
		JSONObject j = new JSONObject();
		Member member = m.selectByPrimaryKey(id);
		if (member != null) {
			String mscore = member.getMreport() == null ? "3" : member.getMreport();
			member.setMid(id);
			int average = (Integer.parseInt(score) + Integer.parseInt(mscore)) / 2;
			member.setMreport(average + "");
			if (m.updateByPrimaryKeySelective(member) > 0) {
				j.put("info", "成功评分");
				j.put("code", 1);
			} else {
				j.put("info", "无数据");
				j.put("code", -1);
			}
		} else {
			j.put("info", "无该成员");
			j.put("code", 1);
		}
		return j;
	}

	public JSONObject getRecruit(int hid, int page, int rows) {
		JSONObject j = new JSONObject();
		try {
			List<RecruitWithBLOBs> recruit_list = r.selectByhistory(hid + "", page, rows);
			JSONArray ja = new JSONArray();
			for (RecruitWithBLOBs recruit : recruit_list) {
				JSONObject j1 = new JSONObject();

				j1.put("task", recruit.getRtask());
				j1.put("name", recruit.getRname());
				Picture picture = p.selectByRid(recruit.getRid());
				if (picture != null)
					j1.put("img",GetPicForWeb.getPicUrlForOption(picture.getPicaddress(),60,FianlOssData.getIndexhostelpic()) );
				else
					j1.put("img", "img/logo.jpg");
				String score = c.countByAVG(recruit.getRid());
				score = score == null ? "5" : score;
				j1.put("score", score);
				j1.put("rid", recruit.getRid());
				j1.put("time", d.format(recruit.getRsctime()) + "到" + d.format(recruit.getRmonth()));
				j1.put("state", recruit.getRcancel());
				j1.put("applysize", a.countByRid(recruit.getRid()));
				ja.add(j1);
			}
			j.put("data", ja);
			j.put("size", r.countByhistory(hid));
			if (recruit_list.size() != 0) {
				j.put("info", "获取成功");
				j.put("code", 1);
			} else {
				j.put("info", "无数据");
				j.put("code", -1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.put("info", e.toString());
			j.put("code", -1);
		}
		return j;
	}
	public JSONObject allRefuse(int[] id,String refuse) {
		JSONObject j = new JSONObject();
		try {
			
			Apply apply = new Apply();
			for(int aid:id){
			apply.setAid(aid);
			apply.setAschedule("1001");
			apply.setArefuse(refuse);;
			if (a.updateByPrimaryKeySelective(apply) > 0) {
				j.put("code", 1);
				j.put("info", "批量改变申请表成功");
			}
			else{
				j.put("info", "批量改变申请表失败");
				j.put("code", -1);
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.put("info", "改变申请表失败");
			j.put("code", -1);
		}
		return j;
	}
	public JSONObject changeApplyByBoss(int aid, int schedule,String refuse) {
		JSONObject j = new JSONObject();
		try {
			Apply apply = new Apply();
			apply.setAid(aid);
			apply.setAschedule(schedule + "");
			apply.setArefuse(refuse);
			if (schedule == 1100)
				apply.setRid(-1);
			if (a.updateByPrimaryKeySelective(apply) > 0) {
				j.put("code", 1);
				j.put("info", "改变申请表成功");
				Push push = new Push();
				Apply ap = a.selectByPrimaryKey(aid);
				Member member=m.selectByPrimaryKey(ap.getMid());
				Recruit recruit = r.selectByPrimaryKey(ap.getRid());
				push.setIflook("0");
				switch (schedule) {
				case 1001:
					push.setPcontent("您向招聘<a href=\"../../api/infoJSP?id=" + ap.getRid() + "\">" + recruit.getRname()
							+ "</a>" + "投递的简历被老板拒绝了,因为"+refuse);
					break;
				case 2000:
					push.setPcontent("您向招聘<a href=\"../../api/infoJSP?id=" + ap.getRid() + "\">" + recruit.getRname()
							+ "</a>" + "投递的简历已通过");
					 Hostel hostel=h.selectByPrimaryKey(recruit.getHid());
					if(member!=null&&member.getMphone()!=null){
					op.pushByMemberForPass(member.getMphone(), hostel.getHname());
					}
					if(member!=null&&member.getMemail()!=null){
						Thread thread=new Thread(new EmailByMemberPass(member.getMemail(), hostel.getHname()));
						thread.start();
					}
					break;
				case 3000:
					push.setPcontent("您向招聘<a href=\"../../api/infoJSP?id=" + ap.getRid() + "\">" + recruit.getRname()
							+ "</a>" + "投递的简历已到店");
					break;
				case 4000:
					push.setPcontent("您向招聘<a href=\"../../api/infoJSP?id=" + ap.getRid() + "\">" + recruit.getRname()
							+ "</a>" + "投递的简历老板已对您评价");
				}
				push.setPname("简历信息");
				push.setType(3);
				push.setUid(ap.getMid());
				push.setPtime(new Date());
				pu.insertSelective(push);

			}

			else {
				j.put("info", "改变申请表成功");
				j.put("code", -1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.put("info", "改变申请表失败");
			j.put("code", -1);
		}
		return j;

	}
	public com.alibaba.fastjson.JSONObject updatePicture(MultipartFile photo, int bid, int pid,
			HttpServletRequest request, String number, String name) throws IllegalStateException, IOException {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		Picture picture = new Picture();
		OssPicAndFileOutput ossp = new OssPicAndFileOutput();
		if (photo != null) {
			name=System.currentTimeMillis()+"";
			picture.setPicaddress("img/boss/" + bid + "/hotel/" + name);
			picture.setPparent(number);
			picture.setPicid(pid);
			if (p.updateByPrimaryKeySelective(picture) > 0) {
				String path = request.getServletContext().getRealPath("img/boss/" + bid + "/hotel/");
				if (photo.getSize() >= 1048576) {
					ImageCompress img = new ImageCompress();
					InputStream input=img.compressPic(photo.getInputStream(), path, name);
					ossp.updateWEB("img/boss/" + bid + "/hotel/" + name, input);
				} else {
					ossp.updateWEB("img/boss/" + bid + "/hotel/" + name, photo.getInputStream());
				}
				j.put("img", GetPicForWeb.getPicUrl("img/boss/" + bid + "/hotel/" + name,60));
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
	public com.alibaba.fastjson.JSONObject insertPicture(int hid, MultipartFile photo, int bid,
			HttpServletRequest request, String number, String name) throws IllegalStateException, IOException {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		Picture picture = new Picture();
		if (photo != null) {
			OssPicAndFileOutput ossp = new OssPicAndFileOutput();
			name=System.currentTimeMillis()+"";
			picture.setPicaddress("img/boss/" + bid + "/hotel/" + name);
			picture.setPparent(number);
			picture.setPictime(new Date());
			picture.setHid(hid);
			if (p.insertSelective(picture) > 0) {
				String path = request.getServletContext().getRealPath("img/boss/" + bid + "/hotel/");
				if (photo.getSize() >= 1048576) {
					ImageCompress img = new ImageCompress();
					InputStream input=img.compressPic(photo.getInputStream(), path, name);
					ossp.updateWEB("img/boss/" + bid + "/hotel/" + name, input);
				} else {
					ossp.updateWEB("img/boss/" + bid + "/hotel/" + name, photo.getInputStream());
				}
				j.put("img", GetPicForWeb.getPicUrl("img/boss/" + bid + "/hotel/" + name,60));
			    j.put("pid", p.countByExample());
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
	public com.alibaba.fastjson.JSONObject deletePicture(int pid) throws IllegalStateException, IOException {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		if (p.deleteByPrimaryKey(pid) > 0) {
			j.put("code", 1);
			j.put("info", "成功");
		} else {
			j.put("code", -1);
			j.put("info", "失败");
		}
		return j;
	}

	

	public com.alibaba.fastjson.JSONObject insertHotel(String story, String phone, String name, int bid, String address,
			String synopsis, String[] tag) {
		Hostel hostel = new Hostel();
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		hostel.setHname(name);
		hostel.setHaddress(address);
		hostel.setHsynopsis(synopsis);
		hostel.setPauthentic("0");
		hostel.setBid(bid);
		hostel.setHphone(phone);
		hostel.setHscore("3");
		hostel.setHtel(story);
		Area area = null;
		if (address != null && address.split("-").length > 0) {
			area = ar.selectByAddress(address.split("-")[0]);
		} else {
			area = ar.selectByAddress(address);
		}
		if (area != null)
			hostel.setArid(area.getArid());
		else
			hostel.setArid(1);
		String tagInfo = "";
		if (tag != null && tag.length > 0)
			for (String Tag : tag)
				tagInfo += Tag + ";";
		hostel.setHtag(tagInfo);
		if (h.insertSelective(hostel) > 0) {
			j.put("id", h.countByLastId());
			j.put("code", 1);
			j.put("info", "成功");
		} else {
			j.put("code", -1);
			j.put("info", "失败");
		}
		return j;
	}

	public com.alibaba.fastjson.JSONObject updateHotel(String story, String phone, String pauthentic, String name,
			String address, String synopsis, String[] tag, int hid) {
		Hostel hostel = new Hostel();
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		hostel.setHname(name);
		hostel.setHaddress(address);
		hostel.setHsynopsis(synopsis);
		hostel.setHid(hid);
		hostel.setHtel(story);
		hostel.setPauthentic(pauthentic);
		hostel.setHphone(phone);
		String tagInfo = "";
		if (tag != null && tag.length > 0)
			for (String Tag : tag)
				tagInfo += Tag + ";";
		hostel.setHtag(tagInfo);
		if (h.updateByPrimaryKeySelective(hostel) > 0) {
			j.put("code", 1);
			j.put("info", "成功");
		} else {
			j.put("code", -1);
			j.put("info", "失败");
		}
		return j;
	}

	public com.alibaba.fastjson.JSONObject deleteHotel(int hid) {
		com.alibaba.fastjson.JSONObject j = new com.alibaba.fastjson.JSONObject();
		if (h.deleteByPrimaryKey(hid) > 0) {
			r.deleteByExample(hid);
			j.put("code", 1);
			j.put("info", "成功");
		} else {
			j.put("code", -1);
			j.put("info", "失败");
		}
		return j;
	}

	public JSONObject getApply(int hid, int page, int rows, String schedule) {
		JSONObject j = new JSONObject();
		try {
			int index = 1;
			List<Integer> rid_list = r.selectByHid(hid);
			JSONArray ja = new JSONArray();
			for (int rid : rid_list) {
				List<Apply> Apply_list = a.selectByRid(rid, schedule);
				for (Apply apply : Apply_list) {
					if (index >page * rows) {
						if(apply.getAtime()!=null){
						JSONObject j1 = new JSONObject();
						Member member = m.selectByPrimaryKey(apply.getMid());
						j1.put("time", d.format(apply.getAtime()));
						j1.put("schedule", apply.getAschedule());
						j1.put("aid", apply.getAid());
						j1.put("mid", apply.getMid());
						j1.put("rid", apply.getRid());
						if (member != null) {
							j1.put("sex", member.getMsex());
							j1.put("name", member.getMemname());
							 List<Memberpicture> list=mp.selectByExample(apply.getMid());
							if(list.size()>0 )
							j1.put("picture", GetPicForWeb.getPicUrlForOption(list.get(0).getMpaddress(), 60, FianlOssData.getIndexhostelpic()));
                            j1.put("age", member.getMtel());
                            if(member.getMtouxiang()!=null){
                            	if(member.getMtouxiang().indexOf("http:")>=0){
                            		j1.put("img", member.getMtouxiang());
                            	}else{
                            	j1.put("img", GetPicForWeb.getPicUrl(member.getMtouxiang(), 60));
                            	}
                            }
						}
						ja.add(j1);
					}
					}
					index++;
					if (index > page * rows + rows)
						break;
				}
			}
			j.put("size", a.countByHid(hid, schedule));
			j.put("data", ja);
			if (ja.size() != 0) {
				j.put("info", "获取成功");
				j.put("code", 1);
			} else {
				j.put("info", "无数据");
				j.put("code", -1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.put("info", "获取失败");
			j.put("code", -1);
		}
		return j;
	}
}
