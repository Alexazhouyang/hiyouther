package com.mybatis.mapper;

import com.mybatis.entity.Comment;
import com.mybatis.entity.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    int countByExample(@Param("mid") int mid);
    String countByAVG(@Param("rid") int rid);
    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer cid);
    int ifBoss(@Param("cid") int cid, @Param("bid") int bid);
    int insert(Comment record);
    int countByMid(@Param("mid") int mid, @Param("type") int type);
    int countByBid(@Param("bid") int bid, @Param("type") int type);
    int insertSelective(Comment record);
    int getLastId();
    List<Comment> selectByExampleWithBLOBs(CommentExample example);
    List<String> selectByschedule(@Param("mid") int mid, @Param("rid") int rid);
    int countByR(@Param("type") int type, @Param("rid") int rid);
    int countByH(@Param("type") int type, @Param("hid") int hid);
    List<Comment> selectByR(@Param("page") int page,
                            @Param("pagesize") int pagesize, @Param("type") String type,
                            @Param("rid") int rid);
    List<Comment> selectByH(@Param("page") int page,
                            @Param("pagesize") int pagesize, @Param("type") String type,
                            @Param("hid") int hid);
    List<Comment> selectByM(@Param("type") int type, @Param("mid") int mid, @Param("page") int page, @Param("rows") int rows);
    List<Comment> selectByB(@Param("type") int type, @Param("bid") int bid, @Param("page") int page, @Param("rows") int rows);
    
    Comment selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExampleWithBLOBs(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}