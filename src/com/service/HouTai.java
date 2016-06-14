package com.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.md5.Md5;
import com.mybatis.entity.Admin;
import com.mybatis.entity.Answer;
import com.mybatis.entity.Area;
import com.mybatis.entity.Boss;
import com.mybatis.entity.Comment;
import com.mybatis.entity.Hostel;
import com.mybatis.entity.Member;
import com.mybatis.entity.ProposedreportWithBLOBs;
import com.mybatis.entity.Push;
import com.mybatis.entity.RecruitWithBLOBs;
import com.mybatis.mapper.AdminMapper;
import com.mybatis.mapper.AnswerMapper;
import com.mybatis.mapper.AreaMapper;
import com.mybatis.mapper.BossMapper;
import com.mybatis.mapper.CommentMapper;
import com.mybatis.mapper.HostelMapper;
import com.mybatis.mapper.MemberMapper;
import com.mybatis.mapper.ProposedreportMapper;
import com.mybatis.mapper.PushMapper;
import com.mybatis.mapper.RecruitMapper;
import com.tool.GetPicForWeb;

@Service
@Transactional
/**
 * 后台管理界面的开发包
 * @author forvoid
 * 管理员登录
 * 认证管理在SetConfir中进行
 * 主要用于义工、老板、//客栈的管理；管理包括了（删除（假删除）、查询（单个或者多个）、修改个人信息接口）
 * 评论和回复：回复评论的话；管理包括（删除评论，查看（单个或者多个））；(问答和评论)
 *f//招聘信息管理:删除招聘信息；查看招聘信息（列表和单个查询）
 * 数据统计（义工总数，老板总数，招聘总数，申请总数，评论总数，回复总数）
 * 地区管理：对地区进行增删查改
 * */
public class HouTai {
	
	@Resource
	AdminMapper adminmapper;
	@Resource
	MemberMapper membermapper;
	@Resource
	BossMapper bossmapper;
	@Resource
	AdminMapper adminMapper;
	@Resource
	CommentMapper commentMapper;
	@Resource
	AnswerMapper answerMapper;
	@Resource
	AreaMapper areaMapper;
	@Resource
	RecruitMapper r;
	@Resource
	HostelMapper h;
	@Resource
	ProposedreportMapper re;
	/**
	 * 地区进行增查
	 * option：add/findall
	 * name :
	 * country:
	 * @return 
	 * */
	public JSONObject addAreaOrFindAll(String option,String name,String country){
		JSONObject js = new  JSONObject();
		if(option.equals("add")){
			
			Area add_area = new Area();
			add_area.setArname(name);
			add_area.setArcountry(country);
			if(areaMapper.insert(add_area)>0){
				js.put("code", 1);
				js.put("info", "add地区新增成功");
			}else{
				js.put("code", -1);
				js.put("info", "新增失败");
			}
		}else{
			List<Area> areaall = areaMapper.selectByExample();
			if(areaall.size()!=0){
				JSONArray ja = new JSONArray();
				for(Area a:areaall){
					JSONObject jsa = new JSONObject();
					jsa.put("id", a.getArid());
					jsa.put("name", a.getArname());
					jsa.put("country", a.getArcountry());
					ja.add(jsa);
				}
				js.put("code", 1);
				js.put("info", "获取成功");
				js.put("data", ja);
			}else{
				js.put("code", -1);
				js.put("info", "没有地区信息");
			}
			
		}
		return js;
	}
	/**
	 * 地区进行删改
	 * option：del/upd/
	 * name:
	 * contry:
	 * id:
	 * @return 
	 * */
	public JSONObject areaDelOrUpd(int id,String option,String name,String country){
		JSONObject js = new JSONObject();
		Area area = areaMapper.selectByPrimaryKey(id);
		if(null!=area){
			if(option.equals("upd")){
				area.setArname(name);
				area.setArcountry(country);
				if(areaMapper.updateByPrimaryKey(area)>0){
					js.put("code", 1);
					js.put("info", "更新地区信息成功");
				}else{
					js.put("code", -1);
					js.put("info", "更新地区信息失败");
				}
			}else{
				if(areaMapper.deleteByPrimaryKey(id)>0){
					js.put("code", 1);
					js.put("info", "删除地区信息成功");
				}else{
					js.put("code", 1);
					js.put("info", "删除地区信息失败");
				}
			}
		}else{
			js.put("code", -1);
			js.put("info", "没有地区信息");
		}
		return js;
	}
	/**
	 * 数据统计
	 * （义工总数，老板总数，招聘总数，申请总数，评论总数，回复总数）
	 * @return 
	 * */
	public JSONObject total(){
		JSONObject js = new JSONObject();
		JSONObject js1 = new JSONObject();
		js.put("answertotal", adminMapper.AnswerTotal());
		js.put("applytotal", adminMapper.ApplyTotal());
		js.put("bosstotal", adminMapper.BossTotal());
		js.put("hosteltotal", adminMapper.HostelTotal());
		js.put("membertotal", adminMapper.MemberTotal());
		js.put("commenttotal", adminMapper.CommentTotal());
		js1.put("code", 1);
		js1.put("inf", "总数统计");
		js1.put("data", js);
		return js1;
	}
	/**
	 * 用于后台管理员的登录验证。
	 * @return 
	 * */
	public JSONObject adminLogin(String adaccount,String pwd){
		JSONObject adminjs = new JSONObject();
		Admin admin = adminmapper.selectByAdaccount(adaccount);
		if(null!=admin){
			if(pwd.equals(admin.getAdpassword())){
				adminjs.put("code", 1);
				adminjs.put("info", "登录成功");
			}else{
				adminjs.put("code", -1);
				adminjs.put("info", "登录失败");
			}
		}else{
			adminjs.put("code", -1);
			adminjs.put("info", "没有该用户");
		}
		return adminjs;
	}
	/**
	 * 本类用于用户的假删除(封号)
	 * type类型是member\boss;
	 * 
	 * id ：删除的用户id
	 * @return 
	 * 
	 * */
	public JSONObject userDel(String type,String id){
		JSONObject js= new JSONObject();
		switch (type) {
		case "boss":
			Boss boss = bossmapper.selectByPrimaryKey(Integer.parseInt(id));
			if(null!=boss){
				boss.setBcancel(-1);
				bossmapper.updateByPrimaryKey(boss);
				js.put("code", 1);
				js.put("info", "删除老板用户id为"+id+"成功!");
			}else{
				js.put("code", -1);
				js.put("info", "没有该用户");
			}
			break;
		case "member":
			Member member = membermapper.selectByPrimaryKey(Integer.parseInt(id));
			if(null!=member){
				member.setMcancel("-1");
				membermapper.updateByPrimaryKey(member);
				js.put("code", 1);
				js.put("info", "删除义工用户id为"+id+"成功!");
			}else{
				js.put("code", -1);
				js.put("info", "没有该用户");
			}
			break;

		default:
			js.put("code", -1);
			js.put("info", "type输入出错");
			break;
		}
		return js;
	}
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 本类用于用户的管理查询
	 * type类型是member\boss;
	 * 
	 * id是1.不输入就是全部，输入是id查询id；
	 * @return 
	 * 
	 * */
	public JSONObject userFindManger(String type,String id){
		JSONObject js = new JSONObject();
		if(type.equals("member")){
			System.out.println(id);
			if(id==null||id.equals("null")){
				List<Member> memberList = membermapper.selectByExample(null);
				if(memberList.size()!=0){
					JSONArray memberarray =new JSONArray();
					for(Member memberOne:memberList){
						JSONObject memberjs = new JSONObject();
						memberjs.put("id", memberOne.getMid());
						memberjs.put("emname", memberOne.getMemname());
						memberjs.put("phone",memberOne.getMphone() );
						memberjs.put("email",memberOne.getMemail() );
						memberjs.put("realname",memberOne.getMrealname() );
						memberjs.put("address",memberOne.getMaddress() );
						String chancel ="未知状态";
						switch (memberOne.getMcancel()) {
						case "-1":chancel ="封号";
							
							break;
						case "1":chancel ="未实名";
						
						break;
						case "2":chancel ="已实名";
						
						break;
						case "0":chancel ="邮箱注册未认证";
						
						break;
						case "-2":chancel ="实名未通过";
						
						break;
						case "3":chancel ="实名中。。。";
						
						break;

						default:
							chancel ="未知状态";
							break;
						}
						memberjs.put("cancel",chancel );
						memberjs.put("credit",memberOne.getMcredit() );
						memberarray.add(memberjs);
						
					}
					js.put("data",memberarray );
					js.put("code", 1);
					js.put("info", "获取成功");
				}else{
					js.put("code", -1);
					js.put("info", "当前没有信息");
				}
				
			}else{
				Member member = membermapper.selectByPrimaryKey(Integer.parseInt(id));
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
					if(member.getMidcard()!=null&&member.getMidcard().equals("")&&member.getMidcard().length()!=0){
						
						System.out.println(member.getMidcard());
					String b[] = member.getMidcard().split(";");
					js1.put("idcard_num", b[0]);
					js1.put("pic_face", GetPicForWeb.getPicUrl(b[1], 60));
					js1.put("pic_back", GetPicForWeb.getPicUrl(b[2], 60));
					js1.put("pic_hand", GetPicForWeb.getPicUrl(b[3], 60));
					}
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
			}
		}else if(type.equals("boss")){
			if(id==null||id.equals("null")){
				List<Boss> bossList = adminMapper.selectAllBoss();
				
				if(bossList.size()!=0){
					JSONArray bossarray =new JSONArray();
					for(Boss bossOne:bossList){
						JSONObject bossjs = new JSONObject();
						bossjs.put("id", bossOne.getBid());
						bossjs.put("emname", bossOne.getBrealname());
						bossjs.put("phone",bossOne.getBphone() );
						bossjs.put("email",bossOne.getBemail() );
						bossjs.put("realname",bossOne.getBrealname() );
						bossjs.put("address",bossOne.getBaddress() );
						String chancel ="未知状态";
						switch (bossOne.getBcancel()) {
						case -1:chancel ="封号";
							
							break;
						case 1:chancel ="未实名";
						
						break;
						case 2:chancel ="已实名";
						
						break;
						case 0:chancel ="邮箱注册为认证";
						
						break;
						case -2:chancel ="实名未通过";
						
						break;
						case 3:chancel ="实名中。。。";
						
						break;

						default:
							chancel ="未知状态";
							break;
						}
						bossjs.put("cancel",chancel );
						bossjs.put("credit",bossOne.getBcredit() );
						bossarray.add(bossjs);
						
					}
					js.put("data",bossarray );
					js.put("code", 1);
					js.put("info", "获取成功");
				}else{
					js.put("code", -1);
					js.put("info", "当前没有信息");
				}
				
			}else{
				Boss boss = bossmapper.selectByPrimaryKey(Integer.parseInt(id));
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
					if(boss.getBidcard()!=null&&boss.getBidcard().equals("")&&boss.getBidcard().length()!=0){
					String b[] = boss.getBidcard().split(";");
					js1.put("idcard_num", b[0]);
					js1.put("pic_face", GetPicForWeb.getPicUrl(b[1], 60));
					js1.put("pic_back", GetPicForWeb.getPicUrl(b[2], 60));
					js1.put("pic_hand", GetPicForWeb.getPicUrl(b[3], 60));
					}
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
			}
			
		}else{
			js.put("code", -1);
			js.put("info", "没有指定类型");
		}
		return js;
	}
	/**
	 * 评论、问答查询管理
	 * 对评论进行管理包括（评论、评论，列表查询）
	 * 
	 * 
	 * type：0问答、1评论
	 * page:非必要页数
	 * rows：非必要个数
	 * @return 
	 * */
	public JSONObject commLook(int type,int page,int rows){
		JSONObject js = new JSONObject();
		List<Comment> comm=adminmapper.selectByAllComment(type, page, rows);
		System.out.println(comm);
		if(comm.size()!=0){
			js.put("code", 1);
			js.put("info", "获取成功");
			JSONArray jarry =new JSONArray();
			for(Comment c:comm){
				JSONObject cjs = new JSONObject();
				cjs.put("cid", c.getCid());
				cjs.put("title", c.getCtitle());
				cjs.put("mid", c.getMid());
				cjs.put("rid", c.getRid());
				cjs.put("score", c.getScore());
				cjs.put("content", c.getCcontent());
				cjs.put("time", c.getCtime());
				jarry.add(cjs);
			}
			js.put("data", jarry);
		}else{
			js.put("code", -1);
			js.put("info", "没有数据");
		}
		return js;
	}
	/**
	 * 评论问答删除
	 * @return 
	 * */
	public JSONObject delComm(int id){
		JSONObject js = new JSONObject();
		if(commentMapper.deleteByPrimaryKey(id)>0){
			js.put("code", 1);
			js.put("info", "删除成功");
		}else{
			js.put("code", -1);
			js.put("info", "删除失败");
		}
		return js;
	}
	/**
	 * 回复删除
	 * @return 
	 * */
	public JSONObject delAnswer(int id){
		JSONObject js = new JSONObject();
		if(answerMapper.deleteByPrimaryKey(id)>0){
			js.put("code", 1);
			js.put("info", "删除成功");
		}else{
			js.put("code", -1);
			js.put("info", "删除失败");
		}
		return js;
	}
	/**
	 * 回复管理
	 * 显示出所有的回复信息
	 * @return 
	 * */
	public JSONObject answerLook(int page,int rows){
		JSONObject js = new JSONObject();
		List<Answer> admin=adminmapper.selectByAllAnswer(page, rows);
		if(admin.size()!=0){

			JSONArray jarry =new JSONArray();
			for(Answer c:admin){
				JSONObject cjs = new JSONObject();
				cjs.put("anid", c.getAnid());
				cjs.put("cid", c.getCid());
				cjs.put("content", c.getCcontent());
				cjs.put("lister", c.getListener());
				cjs.put("speaker", c.getSpeaker());
				cjs.put("time", c.getAntime());
				cjs.put("type", c.getType());
				jarry.add(cjs);
			}
			js.put("code", 1);
			js.put("info", "获取成功");
			js.put("data", jarry);
		}else{
			js.put("code", -1);
			js.put("info", "没有数据");
		}
		return js;
	}
	 public String insertHotel(Hostel hotel) {
	    	JSONObject j=new JSONObject();
			if(h.insertSelective(hotel)>0){
			    j.put("code",1);
			    j.put("info","成功");
			 }
			 else{
				j.put("info","失败");
				j.put("code",-1);
			 }
			return j.toString();
		}
	    public String updateHotel(Hostel hotel) {
	    	JSONObject j=new JSONObject();
			if(h.updateByPrimaryKeyWithBLOBs(hotel)>0){
			    j.put("code",1);
			    j.put("info","成功");
			 }
			 else{
				j.put("info","失败");
				j.put("code",-1);
			 }
			return j.toString();
		}
	    public String deleteHotel(Hostel hotel) {
	    	JSONObject j=new JSONObject();
			if(h.deleteByPrimaryKey(hotel.getHid())>0){
			    j.put("code",1);
			    j.put("info","成功");
			 }
			 else{
				j.put("info","失败");
				j.put("code",-1);
			 }
			return j.toString();
		}
	    public String selectHotel(int page,int rows) {
	    	JSONObject j=new JSONObject();
	    	JSON.toJSON(h.selectByExampleWithBLOBs(page, rows));
			return JSON.toJSON(h.selectByExampleWithBLOBs(page, rows)).toString();
		}
	    public String insertRecruit(RecruitWithBLOBs record) {
	    	JSONObject j=new JSONObject();
			if(r.insertSelective(record)>0){
			    j.put("code",1);
			    j.put("info","成功");
			 }
			 else{
				j.put("info","失败");
				j.put("code",-1);
			 }
			return j.toString();
		}
	    public String updateRecruit(RecruitWithBLOBs record) {
	    	JSONObject j=new JSONObject();
			if(r.updateByPrimaryKeyWithBLOBs(record)>0){
			    j.put("code",1);
			    j.put("info","成功");
			 }
			 else{
				j.put("info","失败");
				j.put("code",-1);
			 }
			return j.toString();
		}
	    public String deleteRecruit(RecruitWithBLOBs record) {
	    	JSONObject j=new JSONObject();
			if(r.deleteByPrimaryKey(record.getHid())>0){
			    j.put("code",1);
			    j.put("info","成功");
			 }
			 else{
				j.put("info","失败");
				j.put("code",-1);
			 }
			return j.toString();
		}
	    public String insertReport(ProposedreportWithBLOBs push) {
	    	JSONObject j=new JSONObject();
			if(re.insertSelective(push)>0){
			    j.put("code",1);
			    j.put("info","成功");
			 }
			 else{
				j.put("info","失败");
				j.put("code",-1);
			 }
			return j.toString();
		}
	    public String updateReport(ProposedreportWithBLOBs push) {
	    	JSONObject j=new JSONObject();
			if(re.updateByPrimaryKeyWithBLOBs(push)>0){
			    j.put("code",1);
			    j.put("info","成功");
			 }
			 else{
				j.put("info","失败");
				j.put("code",-1);
			 }
			return j.toString();
		}
	    public String deleteReport(ProposedreportWithBLOBs push)  {
	    	JSONObject j=new JSONObject();
			if(re.deleteByPrimaryKey(push.getPrid())>0){
			    j.put("code",1);
			    j.put("info","成功");
			 }
			 else{
				j.put("info","失败");
				j.put("code",-1);
			 }
			return j.toString();
		}
	    public String selectRecruit(int page,int rows) {
			return JSON.toJSON(r.selectByAll(page, rows, null, null, null, null)).toString();
		}
		
		public String selectReport(int page,int rows) throws IOException {
			return JSON.toJSON(re.selectByExampleWithBLOBs(page, rows)).toString();

		}
}
