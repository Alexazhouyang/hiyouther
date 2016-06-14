package com.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybatis.entity.User;
import com.mybatis.mapper.CommentMapper;
import com.service.StaffService;
import com.tool.StringEscapeEditor;

/**
 * @author zy
 *
 */
@RequestMapping("/api")
@Controller
public class StuffController {
	@Resource
	StaffService h;
	@Resource
	CommentMapper c;
@InitBinder
public void initBinder(WebDataBinder binder) {

	binder.registerCustomEditor(String.class, new StringEscapeEditor());
}
	/**
	 * 得到全国旅店
	 **/
	/**
	 * @param page
	 * @param rows
	 * @param id
	 * @param startdate
	 * @param enddate
	 * @param name
	 * @param response
	 * @param request
	 */
	
	@RequestMapping("/getAllHotel")
	public void getAllHotel(int page, int rows, String id, String startdate, String enddate, String name,
			HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("boss")) {
			j = h.getAllHostel(page - 1, "-1", rows, id, enddate, startdate, name);
		} else {
			j = h.getAllHostel(page - 1, u.getId() + "", rows, id, enddate, startdate, name);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 得到地区旅店
	 **/
	/**
	 * @param name
	 * @param page
	 * @param rows
	 * @param id
	 * @param startdate
	 * @param enddate
	 * @param response
	 * @param request
	 */
	@RequestMapping("/getHotel")
	public void getHotel(String name, int page, int rows, String id, String startdate, String enddate,
			HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("boss")) {
			j = h.getHostel(page - 1, "-1", rows, id, enddate, startdate, name);
		} else {
			j = h.getHostel(page - 1, u.getId() + "", rows, id, enddate, startdate, name);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 得到所有标签
	 **/
	/**
	 * @param response
	 * @param request
	 */
	@RequestMapping("/getTag")
	public void getTag(HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = null;
		j = h.getTag();
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 得到招聘详情
	 **/
	/**
	 * @param id
	 * @param page
	 * @param rows
	 * @param response
	 * @param request
	 */
	@RequestMapping("/getInfo")
	public void getInfo(int id, int page, int rows, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = null;
		j = h.getInfo(id, page - 1, rows);
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 * @param page
	 * @param rows
	 * @param response
	 * @param request
	 */
	@RequestMapping("/getContent")
	public void getContent(int id, int page, int rows, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = null;
		j = h.getContent(id, page - 1, rows);
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 收藏
	 **/
	/**
	 * @param id
	 * @param response
	 * @param request
	 */
	@RequestMapping("/collect")
	public void collect(int id, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null) {
			j.put("info", "收藏失败");
			j.put("code", -1);
		} else {
			j = h.collect(id + "", u.getId() + "");
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 取消收藏
	 **/
	/**
	 * @param id
	 * @param response
	 * @param request
	 */
	@RequestMapping("/cancelcollect ")
	public void cancelCollect(int id, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null) {
			j.put("code", -1);
			j.put("info", "取消收藏失败");
		} else {
			j = h.cancelcollect(id);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public User getSession(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session==null)
			session=request.getSession();
		User u = (User) session.getAttribute("user");
		return u;
	}

	/**
	 * 得到旅店评论
	 **/
	/**
	 * @param id
	 * @param type
	 * @param page
	 * @param rows
	 * @param response
	 * @param request
	 */
	@RequestMapping("/getHcomment")
	public void getHcomment(int id, int type, int page, int rows, HttpServletResponse response,
			HttpServletRequest request) {
		JSONObject j = new JSONObject();
		j = h.getHcomment(id, type, page - 1, rows);
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/getAnswer")
	public void getAnswer(int cid,int page,int rows, HttpServletResponse response,
			HttpServletRequest request) {
		JSONObject j = new JSONObject();
		j = h.getAnswer(cid, page-1, rows);
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 得到单个招聘评论
	 **/
	/**
	 * @param id
	 * @param page
	 * @param rows
	 * @param response
	 * @param request
	 */
	@RequestMapping("/getRcomment")
	public void getRcomment(int id, int page, int rows, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		j = h.getRcomment(id, 1, page - 1, rows);
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 * @param page
	 * @param rows
	 * @param response
	 * @param request
	 */
	@RequestMapping("/getRQuestion")
	public void getRQuestion(int id, int page, int rows, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		j = h.getRcomment(id, 0, page - 1, rows);
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 插入评论
	 **/
	/**
	 * @param id
	 * @param type
	 * @param comment
	 * @param score
	 * @param response
	 * @param request
	 */
	@RequestMapping("/insertcomment")
	public void insertComment(int id, int type, String comment, String score, HttpServletResponse response,
			HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("boss")) {
			j.put("code", -1);
			j.put("info", "未登录");
			if (u == null)
				j.put("info", "未登录");
				else
				j.put("info", "老板无法报名");
		} else {
			j = h.insertComment(id, type, u.getId(), comment, score);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 插入回复
	 **/
	/**
	 * @param cid
	 * @param lid
	 * @param answer
	 * @param response
	 * @param request
	 */
	@RequestMapping("/insertanswer")
	public void insertAnswer(int cid, int lid, String answer, HttpServletResponse response,
			HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null ) {
			j.put("code", -1);
			j.put("info", "未登录");
			
		} else {
			if (u.getType().equals("member"))
				j = h.insertAnswer(cid, lid, u.getId(), u.getName(), answer, "member");
			else{
				if(c.ifBoss(cid, u.getId())>0)
				j = h.insertAnswer(cid, lid, u.getId(), u.getName(), answer, "boss");
			}
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/getApplyDetail")
	public void getApplyDetail(int aid, String answer, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		j = h.getApplyDetail(aid);
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// @RequestMapping("/updateScore")
	// public void updateScore(int id,String score,HttpServletResponse
	// response,HttpServletRequest request){
	// JSONObject j=new JSONObject();
	// User u=(User)request.getServletContext().getAttribute("user");
	// if(u==null){
	// j.put("code",-1);
	// j.put("info","未登录");
	// }else{
	// j=h.updateScore(id, score);
	// }
	// try {
	// replyJson(response, j);
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	/**
	 * 插入申请
	 **/

	/**
	 * @param id
	 * @param time
	 * @param response
	 * @param request
	 */
	@RequestMapping("/insertapply")
	public void insertApply(int id, String time, HttpServletResponse response, HttpServletRequest request) {
		JSONObject j = new JSONObject();
		User u = getSession(request);
		if (u == null || u.getType().equals("boss")) {
			
			j.put("code", -1);
			if (u == null)
			j.put("info", "未登录");
			else
			j.put("info", "老板无法报名");
		} else {
			j = h.insertApply(id, u.getId(), time);
		}
		try {
			replyJson(response, j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void replyJson(HttpServletResponse response, JSONArray j) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(j.toString());// j.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}

	private void replyJson(HttpServletResponse response, JSONObject j) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(j.toString());// j.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}
}
