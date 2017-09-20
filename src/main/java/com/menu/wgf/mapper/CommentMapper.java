package com.menu.wgf.mapper;

import com.menu.wgf.model.Comment;
import com.menu.wgf.model.CommentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CommentMapper {
    @SelectProvider(type=CommentSqlProvider.class, method="countByExample")
    long countByExample(CommentCriteria example);

    @DeleteProvider(type=CommentSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommentCriteria example);

    @Delete({
        "delete from t_comment",
        "where t_comment_pkid = #{tCommentPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tCommentPkid);

    @Insert({
        "insert into t_comment (t_comment_pkid, t_comment_user_pkid, ",
        "t_comment_menu_pkid, t_comment_content, ",
        "t_comment_cdt, t_comment_udt, ",
        "t_comment_delete)",
        "values (#{tCommentPkid,jdbcType=INTEGER}, #{tCommentUserPkid,jdbcType=INTEGER}, ",
        "#{tCommentMenuPkid,jdbcType=INTEGER}, #{tCommentContent,jdbcType=VARCHAR}, ",
        "#{tCommentCdt,jdbcType=TIMESTAMP}, #{tCommentUdt,jdbcType=TIMESTAMP}, ",
        "#{tCommentDelete,jdbcType=INTEGER})"
    })
    int insert(Comment record);

    @InsertProvider(type=CommentSqlProvider.class, method="insertSelective")
    int insertSelective(Comment record);

    @SelectProvider(type=CommentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_comment_pkid", property="tCommentPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_comment_user_pkid", property="tCommentUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_comment_menu_pkid", property="tCommentMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_comment_content", property="tCommentContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_comment_cdt", property="tCommentCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_comment_udt", property="tCommentUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_comment_delete", property="tCommentDelete", jdbcType=JdbcType.INTEGER)
    })
    List<Comment> selectByExample(CommentCriteria example);

    @Select({
        "select",
        "t_comment_pkid, t_comment_user_pkid, t_comment_menu_pkid, t_comment_content, ",
        "t_comment_cdt, t_comment_udt, t_comment_delete",
        "from t_comment",
        "where t_comment_pkid = #{tCommentPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_comment_pkid", property="tCommentPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_comment_user_pkid", property="tCommentUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_comment_menu_pkid", property="tCommentMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_comment_content", property="tCommentContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_comment_cdt", property="tCommentCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_comment_udt", property="tCommentUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_comment_delete", property="tCommentDelete", jdbcType=JdbcType.INTEGER)
    })
    Comment selectByPrimaryKey(Integer tCommentPkid);

    @UpdateProvider(type=CommentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentCriteria example);

    @UpdateProvider(type=CommentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Comment record, @Param("example") CommentCriteria example);

    @UpdateProvider(type=CommentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Comment record);

    @Update({
        "update t_comment",
        "set t_comment_user_pkid = #{tCommentUserPkid,jdbcType=INTEGER},",
          "t_comment_menu_pkid = #{tCommentMenuPkid,jdbcType=INTEGER},",
          "t_comment_content = #{tCommentContent,jdbcType=VARCHAR},",
          "t_comment_cdt = #{tCommentCdt,jdbcType=TIMESTAMP},",
          "t_comment_udt = #{tCommentUdt,jdbcType=TIMESTAMP},",
          "t_comment_delete = #{tCommentDelete,jdbcType=INTEGER}",
        "where t_comment_pkid = #{tCommentPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Comment record);
}