package com.mybatis.mapper;

import com.mybatis.entity.Admin;
import com.mybatis.entity.AdminExample;
import com.mybatis.entity.Answer;
import com.mybatis.entity.Boss;
import com.mybatis.entity.Comment;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer adid);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer adid);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
	Admin selectByAdaccount(@Param("adaccount") String adaccount);
	List<Answer> selectByAllAnswer(@Param("page") int page, @Param("rows") int rows);
	
	List<Comment> selectByAllComment(@Param("type") int type, @Param("page") int page, @Param("rows") int rows);
	int BossTotal();
	int MemberTotal();
	int AnswerTotal();
	int CommentTotal();
	int ApplyTotal();
	int HostelTotal();
	List<Boss> selectAllBoss();
	
}