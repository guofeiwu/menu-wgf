package com.menu.wgf.mapper;

import com.menu.wgf.model.Feedback;
import com.menu.wgf.model.FeedbackCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface FeedbackMapper {
    @SelectProvider(type=FeedbackSqlProvider.class, method="countByExample")
    long countByExample(FeedbackCriteria example);

    @DeleteProvider(type=FeedbackSqlProvider.class, method="deleteByExample")
    int deleteByExample(FeedbackCriteria example);

    @Delete({
        "delete from t_feedback",
        "where t_feedback_pkid = #{tFeedbackPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tFeedbackPkid);

    @Insert({
        "insert into t_feedback (t_feedback_user_pkid, t_feedback_content, ",
        "t_feedback_cdt, t_feedback_udt, ",
        "t_feedback_delete)",
        "values (#{tFeedbackUserPkid,jdbcType=INTEGER}, #{tFeedbackContent,jdbcType=VARCHAR}, ",
        "#{tFeedbackCdt,jdbcType=TIMESTAMP}, #{tFeedbackUdt,jdbcType=TIMESTAMP}, ",
        "#{tFeedbackDelete,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tFeedbackPkid", before=false, resultType=Integer.class)
    int insert(Feedback record);

    @InsertProvider(type=FeedbackSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tFeedbackPkid", before=false, resultType=Integer.class)
    int insertSelective(Feedback record);

    @SelectProvider(type=FeedbackSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_feedback_pkid", property="tFeedbackPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_feedback_user_pkid", property="tFeedbackUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_feedback_content", property="tFeedbackContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_feedback_cdt", property="tFeedbackCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_feedback_udt", property="tFeedbackUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_feedback_delete", property="tFeedbackDelete", jdbcType=JdbcType.INTEGER)
    })
    List<Feedback> selectByExample(FeedbackCriteria example);

    @Select({
        "select",
        "t_feedback_pkid, t_feedback_user_pkid, t_feedback_content, t_feedback_cdt, t_feedback_udt, ",
        "t_feedback_delete",
        "from t_feedback",
        "where t_feedback_pkid = #{tFeedbackPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_feedback_pkid", property="tFeedbackPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_feedback_user_pkid", property="tFeedbackUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_feedback_content", property="tFeedbackContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_feedback_cdt", property="tFeedbackCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_feedback_udt", property="tFeedbackUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_feedback_delete", property="tFeedbackDelete", jdbcType=JdbcType.INTEGER)
    })
    Feedback selectByPrimaryKey(Integer tFeedbackPkid);

    @UpdateProvider(type=FeedbackSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Feedback record, @Param("example") FeedbackCriteria example);

    @UpdateProvider(type=FeedbackSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Feedback record, @Param("example") FeedbackCriteria example);

    @UpdateProvider(type=FeedbackSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Feedback record);

    @Update({
        "update t_feedback",
        "set t_feedback_user_pkid = #{tFeedbackUserPkid,jdbcType=INTEGER},",
          "t_feedback_content = #{tFeedbackContent,jdbcType=VARCHAR},",
          "t_feedback_cdt = #{tFeedbackCdt,jdbcType=TIMESTAMP},",
          "t_feedback_udt = #{tFeedbackUdt,jdbcType=TIMESTAMP},",
          "t_feedback_delete = #{tFeedbackDelete,jdbcType=INTEGER}",
        "where t_feedback_pkid = #{tFeedbackPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Feedback record);
}