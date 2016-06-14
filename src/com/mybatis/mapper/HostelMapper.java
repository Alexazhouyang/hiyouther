package com.mybatis.mapper;

import com.mybatis.entity.Hostel;
import com.mybatis.entity.HostelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HostelMapper {
    int countByExample(@Param("bid") Integer bid);

    int countByLastId();
    int deleteByExample(HostelExample example);

    int deleteByPrimaryKey(Integer hid);

    int insert(Hostel record);

    int insertSelective(Hostel record);
    int getLastId();
    List<Hostel> selectByAdmin();
    List<Hostel> selectByExampleWithBLOBs(@Param("page") int page, @Param("rows") int rows);

    List<Hostel> selectByExample(@Param("bid") Integer bid, @Param("page") int page, @Param("rows") int rows);

    Hostel selectByPrimaryKey(Integer hid);

    int updateByExampleSelective(@Param("record") Hostel record, @Param("example") HostelExample example);

    int updateByExampleWithBLOBs(@Param("record") Hostel record, @Param("example") HostelExample example);

    int updateByExample(@Param("record") Hostel record, @Param("example") HostelExample example);

    int updateByPrimaryKeySelective(Hostel record);

    int updateByPrimaryKeyWithBLOBs(Hostel record);
    /*
     * forvoid
     * */
     List<Hostel> selectByPauthentic(String pauthentic);
    int updateByPrimaryKey(Hostel record);
}