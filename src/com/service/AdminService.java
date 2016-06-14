package com.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mybatis.entity.Hostel;
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
import com.mybatis.mapper.PictureMapper;
import com.mybatis.mapper.RecruitMapper;

@Service
@Transactional
public class AdminService {
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
   
}
