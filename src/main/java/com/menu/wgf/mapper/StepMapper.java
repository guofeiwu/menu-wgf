package com.menu.wgf.mapper;

import com.menu.wgf.model.Step;
import com.menu.wgf.model.StepCriteria;
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

public interface StepMapper {
    @SelectProvider(type=StepSqlProvider.class, method="countByExample")
    long countByExample(StepCriteria example);

    @DeleteProvider(type=StepSqlProvider.class, method="deleteByExample")
    int deleteByExample(StepCriteria example);

    @Delete({
        "delete from t_step",
        "where t_step_pkid = #{tStepPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tStepPkid);

    @Insert({
        "insert into t_step (t_step_menu_pkid, t_step_pic_address, ",
        "t_step_description, t_step_udt, ",
        "t_step_cdt, t_step_delete)",
        "values (#{tStepMenuPkid,jdbcType=INTEGER}, #{tStepPicAddress,jdbcType=VARCHAR}, ",
        "#{tStepDescription,jdbcType=VARCHAR}, #{tStepUdt,jdbcType=TIMESTAMP}, ",
        "#{tStepCdt,jdbcType=TIMESTAMP}, #{tStepDelete,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tStepPkid", before=false, resultType=Integer.class)
    int insert(Step record);

    @InsertProvider(type=StepSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tStepPkid", before=false, resultType=Integer.class)
    int insertSelective(Step record);

    @SelectProvider(type=StepSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_step_pkid", property="tStepPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_step_menu_pkid", property="tStepMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_step_pic_address", property="tStepPicAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_step_description", property="tStepDescription", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_step_udt", property="tStepUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_step_cdt", property="tStepCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_step_delete", property="tStepDelete", jdbcType=JdbcType.INTEGER)
    })
    List<Step> selectByExample(StepCriteria example);

    @Select({
        "select",
        "t_step_pkid, t_step_menu_pkid, t_step_pic_address, t_step_description, t_step_udt, ",
        "t_step_cdt, t_step_delete",
        "from t_step",
        "where t_step_pkid = #{tStepPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_step_pkid", property="tStepPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_step_menu_pkid", property="tStepMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_step_pic_address", property="tStepPicAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_step_description", property="tStepDescription", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_step_udt", property="tStepUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_step_cdt", property="tStepCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_step_delete", property="tStepDelete", jdbcType=JdbcType.INTEGER)
    })
    Step selectByPrimaryKey(Integer tStepPkid);

    @UpdateProvider(type=StepSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Step record, @Param("example") StepCriteria example);

    @UpdateProvider(type=StepSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Step record, @Param("example") StepCriteria example);

    @UpdateProvider(type=StepSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Step record);

    @Update({
        "update t_step",
        "set t_step_menu_pkid = #{tStepMenuPkid,jdbcType=INTEGER},",
          "t_step_pic_address = #{tStepPicAddress,jdbcType=VARCHAR},",
          "t_step_description = #{tStepDescription,jdbcType=VARCHAR},",
          "t_step_udt = #{tStepUdt,jdbcType=TIMESTAMP},",
          "t_step_cdt = #{tStepCdt,jdbcType=TIMESTAMP},",
          "t_step_delete = #{tStepDelete,jdbcType=INTEGER}",
        "where t_step_pkid = #{tStepPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Step record);
}