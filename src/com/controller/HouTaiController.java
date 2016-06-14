package com.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.entity.Hostel;
import com.mybatis.entity.ProposedreportWithBLOBs;
import com.mybatis.entity.Push;
import com.mybatis.entity.RecruitWithBLOBs;
import com.mybatis.mapper.AdminMapper;
import com.service.AdminService;
import com.service.HouTai;
import com.service.SetConfirmService;
import com.tool.StringEscapeEditor;

@RequestMapping("/api")
@Controller
/**
 * @author forvoid 后台管理
 */
/**
 * 后台管理界面的开发包
 * 
 * @author forvoid 管理员登录 认证管理在SetConfir中进行
 *         主要用于义工、老板、//客栈的管理；管理包括了（删除（假删除）、查询（单个或者多个）、修改个人信息接口）
 *         评论和回复：回复评论的话；管理包括（删除评论，查看（单个或者多个））；(问答和评论)
 *         f//招聘信息管理:删除招聘信息；查看招聘信息（列表和单个查询） 数据统计（义工总数，老板总数，招聘总数，申请总数，评论总数，回复总数）
 *         地区管理：对地区进行增删查改
 */
public class HouTaiController {
	@Resource
	HouTai houtai;
	@Resource
	SetConfirmService setconfir;
	@Resource
	AdminService adminService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(String.class, new StringEscapeEditor());
	}
	/**
	 * 身份验证管理 通过，不通过验证信息。 option:pass/fail通过不通过 type:hostel\boss\member id:用户id
	 */
	@RequestMapping("/shenfenYanzheng")
	public void shenfenYanzheng(String option, String type, String id, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		JSONObject js = new JSONObject();
		if (option.equals("pass")) {
			js = setconfir.passConfirm(id, type);
		} else {
			js = setconfir.unPassConfirm(id, type);
		}
		replyJson(response, js);
	}

	/**
	 * 身份验证列表 需要提供：type（旅店、老板、义工）hostel\boss\member
	 * option:(申请通过的、申请正在进行的、申请失败的)pass\ongoing\fail
	 */
	@RequestMapping("/shenfenYanzhenglist")
	public void shenfenyanzhenglist(String type, String option, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		JSONObject js = new JSONObject();
		js = setconfir.findAllConfirm(type, option);
		replyJson(response, js);
	}
	@RequestMapping("/selectHotel")
	public void selectHotel(int page,int rows, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		String js = null;
		js = houtai.selectHotel(page, rows);
		replyJson(response, js);
	}
	@RequestMapping("/selectRecruit")
	public void selectRecruit(int page,int rows, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		String js = null;
		js = houtai.selectRecruit(page, rows);
		replyJson(response, js);
	}
	@RequestMapping("/selectReport")
	public void selectReport(int page,int rows, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		String js = null;
		js = houtai.selectReport(page, rows);
		replyJson(response, js);
	}
	@RequestMapping("/optionHostel")
	public void optionHostel(Hostel hotel, String option, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		String js=null;
		if (option.equals("insert"))
		js = houtai.insertHotel(hotel);
		if (option.equals("update"))
		js = houtai.updateHotel(hotel);
		if (option.equals("delete"))
		js = houtai.deleteHotel(hotel);
		if (option.equals("select"))
			js = houtai.deleteHotel(hotel);
		replyJson(response, js);
	}

	/**
	 * 管理员登录
	 */
	@RequestMapping("/adminLogin")
	public void adminLogin(String name, String pwd, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		JSONObject js = new JSONObject();
		js = houtai.adminLogin(name, pwd);
		replyJson(response, js);
	}

	/**
	 * 用户管理 type:y义工，老板 boss \ member id：有的时候就是查某个id没有就是查全部 option:del \find
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/userManger")
	public void userManger(String type, String id, String option, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		JSONObject js = new JSONObject();
		if (option.equals("del")) {
			js = houtai.userDel(type, id);
		} else {
			js = houtai.userFindManger(type, id);
		}
		replyJson(response, js);
	}

	/**
	 * 评论问答管理 option look\del type 0问答1评论 page 页面 rows 个数 id
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/commManger")
	public void commManger(String option, String type, String page, String rows, String id,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		JSONObject js = new JSONObject();
		if (option.equals("del")) {
			js = houtai.delComm(Integer.parseInt(id));
		} else {
			js = houtai.commLook(Integer.parseInt(type), Integer.parseInt(page) - 1, Integer.parseInt(rows));
		}
		replyJson(response, js);
	}
	@RequestMapping("/optionRecruit")
	public void insertHotel(RecruitWithBLOBs record,String option, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		String js=null;
		if (option.equals("insert"))
			js = houtai.insertRecruit(record);
			if (option.equals("update"))
			js = houtai.updateRecruit(record);
			if (option.equals("delete"))
			js = houtai.deleteRecruit(record);
		replyJson(response, js);
	}
	/**
	 * 回复管理
	 * 
	 * @return option look\del String id page rows
	 * @throws IOException
	 */
	@RequestMapping("/answerManger")
	public void answerManger(String option, String id, String page, String rows, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		JSONObject js = new JSONObject();
		if (option.equals("del")) {
			js = houtai.delAnswer(Integer.parseInt(id));
		} else {
			js = houtai.answerLook(Integer.parseInt(page) - 1, Integer.parseInt(rows));
		}
		replyJson(response, js);
	}

	/**
	 * 统计管理 获取统计信息
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/totalManger")
	public void totalManger(HttpServletResponse response, HttpServletRequest request) throws IOException {
		JSONObject js = houtai.total();
		replyJson(response, js);
	}

	/**
	 * 地区管理 option del upd add findall name country id
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/areaManger")
	public void areaManger(String option, String id, String name, String country, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		JSONObject js = new JSONObject();
		if (option.equals("del") || option.equals("upd")) {
			js = houtai.areaDelOrUpd(Integer.parseInt(id), option, name, country);
		} else if (option.equals("add")) {
			js = houtai.addAreaOrFindAll(option, name, country);
		} else {
			js = houtai.addAreaOrFindAll(option, "aa", "aa");
		}
		replyJson(response, js);
	}
	@RequestMapping("/ReportManger")
	public void ReportManger(String option,ProposedreportWithBLOBs report, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		String js = null;
		if (option.equals("update"))
		js = houtai.updateReport(report);
		if (option.equals("delete"))
		js = houtai.deleteReport(report);
		if (option.equals("delete"))
			js = houtai.deleteReport(report);
		replyJson(response, js);
	}
	private void replyJson(HttpServletResponse response, JSONArray j) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(j.toString());// j.toString());
		response.getWriter().flush();
	}

	private void replyJson(HttpServletResponse response, JSONObject j) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(j.toString());// j.toString());
		response.getWriter().flush();
	}

	private void replyJson(HttpServletResponse response, String j) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(j);// j.toString());
		response.getWriter().flush();
	}
}
