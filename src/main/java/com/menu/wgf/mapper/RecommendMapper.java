package com.menu.wgf.mapper;

import com.menu.wgf.model.Recommend;
import com.menu.wgf.model.RecommendCriteria;
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

public interface RecommendMapper {
    @SelectProvider(type=RecommendSqlProvider.class, method="countByExample")
    long countByExample(RecommendCriteria example);

    @DeleteProvider(type=RecommendSqlProvider.class, method="deleteByExample")
    int deleteByExample(RecommendCriteria example);

    @Delete({
        "delete from t_recommend",
        "where t_recommend_pkid = #{tRecommendPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tRecommendPkid);

    @Insert({
        "insert into t_recommend (t_recommend_name, t_recommend_type, ",
        "t_recommend_cdt, t_recommend_udt, ",
        "t_recommend_delete)",
        "values (#{tRecommendName,jdbcType=VARCHAR}, #{tRecommendType,jdbcType=INTEGER}, ",
        "#{tRecommendCdt,jdbcType=TIMESTAMP}, #{tRecommendUdt,jdbcType=TIMESTAMP}, ",
        "#{tRecommendDelete,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tRecommendPkid", before=false, resultType=Integer.class)
    int insert(Recommend record);

    @InsertProvider(type=RecommendSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tRecommendPkid", before=false, resultType=Integer.class)
    int insertSelective(Recommend record);

    @SelectProvider(type=RecommendSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_recommend_pkid", property="tRecommendPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_recommend_name", property="tRecommendName", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_recommend_type", property="tRecommendType", jdbcType=JdbcType.INTEGER),
        @Result(column="t_recommend_cdt", property="tRecommendCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_recommend_udt", property="tRecommendUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_recommend_delete", property="tRecommendDelete", jdbcType=JdbcType.INTEGER)
    })
    List<Recommend> selectByExample(RecommendCriteria example);

    @Select({
        "select",
        "t_recommend_pkid, t_recommend_name, t_recommend_type, t_recommend_cdt, t_recommend_udt, ",
        "t_recommend_delete",
        "from t_recommend",
        "where t_recommend_pkid = #{tRecommendPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_recommend_pkid", property="tRecommendPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_recommend_name", property="tRecommendName", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_recommend_type", property="tRecommendType", jdbcType=JdbcType.INTEGER),
        @Result(column="t_recommend_cdt", property="tRecommendCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_recommend_udt", property="tRecommendUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_recommend_delete", property="tRecommendDelete", jdbcType=JdbcType.INTEGER)
    })
    Recommend selectByPrimaryKey(Integer tRecommendPkid);

    @UpdateProvider(type=RecommendSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Recommend record, @Param("example") RecommendCriteria example);

    @UpdateProvider(type=RecommendSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Recommend record, @Param("example") RecommendCriteria example);

    @UpdateProvider(type=RecommendSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Recommend record);

    @Update({
        "update t_recommend",
        "set t_recommend_name = #{tRecommendName,jdbcType=VARCHAR},",
          "t_recommend_type = #{tRecommendType,jdbcType=INTEGER},",
          "t_recommend_cdt = #{tRecommendCdt,jdbcType=TIMESTAMP},",
          "t_recommend_udt = #{tRecommendUdt,jdbcType=TIMESTAMP},",
          "t_recommend_delete = #{tRecommendDelete,jdbcType=INTEGER}",
        "where t_recommend_pkid = #{tRecommendPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Recommend record);
}