package com.mybatis.mapper;

import com.mybatis.entity.Recruit;
import com.mybatis.entity.RecruitExample;
import com.mybatis.entity.RecruitWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecruitMapper {
    int countByExample(RecruitExample example);

    int deleteByExample(@Param("hid") int hid);

    int deleteByPrimaryKey(Integer rid);

    int insert(RecruitWithBLOBs record);
    int selectLast();
    int insertSelective(RecruitWithBLOBs record);
  //查询全国
    List<RecruitWithBLOBs> selectByAll(@Param("page") int page, @Param("pagesize") int pagesize,
                                       @Param("arid") String arid, @Param("month") String month,
                                       @Param("sctime") String sctime, @Param("name") String name);
    //查询地区
    List<RecruitWithBLOBs> selectByType(@Param("page") int page, @Param("pagesize") int pagesize,
                                        @Param("arid") String arid, @Param("month") String month,
                                        @Param("sctime") String sctime, @Param("name") String name);
    //查询历史
    List<RecruitWithBLOBs>selectByhistory(@Param("hid") String hid, @Param("page") int page, @Param("rows") int rows);
    List<Integer>selectByHid(@Param("hid") int hid);
    int countByhistory(@Param("hid") int hid);
    int countByAll(@Param("month") String month, @Param("sctime") String sctime, @Param("arid") String arid, @Param("name") String name);
    int countByType(@Param("month") String month, @Param("sctime") String sctime, @Param("arid") String arid, @Param("name") String name);
    int countBycomment(@Param("rid") String rid, @Param("type") int type);
    RecruitWithBLOBs selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") RecruitWithBLOBs record, @Param("example") RecruitExample example);

    int updateByExampleWithBLOBs(@Param("record") RecruitWithBLOBs record, @Param("example") RecruitExample example);

    int updateByExample(@Param("record") Recruit record, @Param("example") RecruitExample example);

    int updateByPrimaryKeySelective(RecruitWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RecruitWithBLOBs record);

    int updateByPrimaryKey(Recruit record);
    List<Recruit>selectByHidForLister(@Param("hid") int hid);
}