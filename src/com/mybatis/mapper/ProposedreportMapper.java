package com.mybatis.mapper;

import com.mybatis.entity.Proposedreport;
import com.mybatis.entity.ProposedreportExample;
import com.mybatis.entity.ProposedreportWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProposedreportMapper {
    int countByExample(ProposedreportExample example);

    int deleteByExample(ProposedreportExample example);

    int deleteByPrimaryKey(Integer prid);

    int insert(ProposedreportWithBLOBs record);

    int insertSelective(ProposedreportWithBLOBs record);
 
    List<ProposedreportWithBLOBs> selectByExampleWithBLOBs(@Param("page") int page, @Param("rows") int rows);

    List<Proposedreport> selectByExample(ProposedreportExample example);

    ProposedreportWithBLOBs selectByPrimaryKey(Integer prid);

    int updateByExampleSelective(@Param("record") ProposedreportWithBLOBs record, @Param("example") ProposedreportExample example);

    int updateByExampleWithBLOBs(@Param("record") ProposedreportWithBLOBs record, @Param("example") ProposedreportExample example);

    int updateByExample(@Param("record") Proposedreport record, @Param("example") ProposedreportExample example);

    int updateByPrimaryKeySelective(ProposedreportWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProposedreportWithBLOBs record);

    int updateByPrimaryKey(Proposedreport record);
}