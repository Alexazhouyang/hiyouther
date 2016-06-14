package com.mybatis.mapper;

import com.mybatis.entity.Member;
import com.mybatis.entity.MemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    int countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(Integer mid);

    int insert(Member record);

    int insertSelective(Member record);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(Integer mid);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
    /*forvoid*/
    List<Member> selectAllConfirm(String mcancel);
	Member selectByMphone(@Param("mphone") String mphone);

	Member selectByEmail(@Param("memail") String memail);

	Member selectByQQ(@Param("mqq") String mqq);

	Member selectByWeiBo(@Param("mweibo") String mweibo);

	Member selectByWechat(@Param("mwechat") String mwechat);
	Member selectByQQLink(@Param("mqq") String mqq);
}