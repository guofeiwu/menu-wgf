package com.menu.wgf.mapper;

import com.menu.wgf.model.Thematic;
import com.menu.wgf.model.ThematicCriteria;
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

public interface ThematicMapper {
    @SelectProvider(type=ThematicSqlProvider.class, method="countByExample")
    long countByExample(ThematicCriteria example);

    @DeleteProvider(type=ThematicSqlProvider.class, method="deleteByExample")
    int deleteByExample(ThematicCriteria example);

    @Delete({
        "delete from t_thematic",
        "where t_thematic_pkid = #{tThematicPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tThematicPkid);

    @Insert({
        "insert into t_thematic (t_thematic_picture_url, t_thematic_name, ",
        "t_thematic_delete, t_thematic_cdt, ",
        "t_thematic_udt)",
        "values (#{tThematicPictureUrl,jdbcType=VARCHAR}, #{tThematicName,jdbcType=VARCHAR}, ",
        "#{tThematicDelete,jdbcType=INTEGER}, #{tThematicCdt,jdbcType=TIMESTAMP}, ",
        "#{tThematicUdt,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tThematicPkid", before=false, resultType=Integer.class)
    int insert(Thematic record);

    @InsertProvider(type=ThematicSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tThematicPkid", before=false, resultType=Integer.class)
    int insertSelective(Thematic record);

    @SelectProvider(type=ThematicSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_thematic_pkid", property="tThematicPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_thematic_picture_url", property="tThematicPictureUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_thematic_name", property="tThematicName", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_thematic_delete", property="tThematicDelete", jdbcType=JdbcType.INTEGER),
        @Result(column="t_thematic_cdt", property="tThematicCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_thematic_udt", property="tThematicUdt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Thematic> selectByExample(ThematicCriteria example);

    @Select({
        "select",
        "t_thematic_pkid, t_thematic_picture_url, t_thematic_name, t_thematic_delete, ",
        "t_thematic_cdt, t_thematic_udt",
        "from t_thematic",
        "where t_thematic_pkid = #{tThematicPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_thematic_pkid", property="tThematicPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_thematic_picture_url", property="tThematicPictureUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_thematic_name", property="tThematicName", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_thematic_delete", property="tThematicDelete", jdbcType=JdbcType.INTEGER),
        @Result(column="t_thematic_cdt", property="tThematicCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_thematic_udt", property="tThematicUdt", jdbcType=JdbcType.TIMESTAMP)
    })
    Thematic selectByPrimaryKey(Integer tThematicPkid);

    @UpdateProvider(type=ThematicSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Thematic record, @Param("example") ThematicCriteria example);

    @UpdateProvider(type=ThematicSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Thematic record, @Param("example") ThematicCriteria example);

    @UpdateProvider(type=ThematicSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Thematic record);

    @Update({
        "update t_thematic",
        "set t_thematic_picture_url = #{tThematicPictureUrl,jdbcType=VARCHAR},",
          "t_thematic_name = #{tThematicName,jdbcType=VARCHAR},",
          "t_thematic_delete = #{tThematicDelete,jdbcType=INTEGER},",
          "t_thematic_cdt = #{tThematicCdt,jdbcType=TIMESTAMP},",
          "t_thematic_udt = #{tThematicUdt,jdbcType=TIMESTAMP}",
        "where t_thematic_pkid = #{tThematicPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Thematic record);
}