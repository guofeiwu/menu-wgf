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
        "where \"t_feedback _pkid\" = #{tFeedbackPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tFeedbackPkid);

    @Insert({
        "insert into t_feedback (\"t_feedback _pkid\", \"t_feedback _user_pkid\", ",
        "\"t_feedback _content\", \"t_feedback _cdt\", ",
        "\"t_feedback _udt\", \"t_feedback _delete\")",
        "values (#{tFeedbackPkid,jdbcType=INTEGER}, #{tFeedbackUserPkid,jdbcType=INTEGER}, ",
        "#{tFeedbackContent,jdbcType=VARCHAR}, #{tFeedbackCdt,jdbcType=TIMESTAMP}, ",
        "#{tFeedbackUdt,jdbcType=TIMESTAMP}, #{tFeedbackDelete,jdbcType=INTEGER})"
    })
    int insert(Feedback record);

    @InsertProvider(type=FeedbackSqlProvider.class, method="insertSelective")
    int insertSelective(Feedback record);

    @SelectProvider(type=FeedbackSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_feedback _pkid", property="tFeedbackPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_feedback _user_pkid", property="tFeedbackUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_feedback _content", property="tFeedbackContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_feedback _cdt", property="tFeedbackCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_feedback _udt", property="tFeedbackUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_feedback _delete", property="tFeedbackDelete", jdbcType=JdbcType.INTEGER)
    })
    List<Feedback> selectByExample(FeedbackCriteria example);

    @Select({
        "select",
        "\"t_feedback _pkid\", \"t_feedback _user_pkid\", \"t_feedback _content\", \"t_feedback _cdt\", ",
        "\"t_feedback _udt\", \"t_feedback _delete\"",
        "from t_feedback",
        "where \"t_feedback _pkid\" = #{tFeedbackPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_feedback _pkid", property="tFeedbackPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_feedback _user_pkid", property="tFeedbackUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_feedback _content", property="tFeedbackContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_feedback _cdt", property="tFeedbackCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_feedback _udt", property="tFeedbackUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_feedback _delete", property="tFeedbackDelete", jdbcType=JdbcType.INTEGER)
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
        "set \"t_feedback _user_pkid\" = #{tFeedbackUserPkid,jdbcType=INTEGER},",
          "\"t_feedback _content\" = #{tFeedbackContent,jdbcType=VARCHAR},",
          "\"t_feedback _cdt\" = #{tFeedbackCdt,jdbcType=TIMESTAMP},",
          "\"t_feedback _udt\" = #{tFeedbackUdt,jdbcType=TIMESTAMP},",
          "\"t_feedback _delete\" = #{tFeedbackDelete,jdbcType=INTEGER}",
        "where \"t_feedback _pkid\" = #{tFeedbackPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Feedback record);
}