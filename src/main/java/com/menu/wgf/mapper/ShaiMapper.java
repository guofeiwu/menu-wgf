package com.menu.wgf.mapper;

import com.menu.wgf.model.Shai;
import com.menu.wgf.model.ShaiCriteria;
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

public interface ShaiMapper {
    @SelectProvider(type=ShaiSqlProvider.class, method="countByExample")
    long countByExample(ShaiCriteria example);

    @DeleteProvider(type=ShaiSqlProvider.class, method="deleteByExample")
    int deleteByExample(ShaiCriteria example);

    @Delete({
        "delete from t_shai",
        "where t_shai_Pkid = #{tShaiPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tShaiPkid);

    @Insert({
        "insert into t_shai (t_shai_user_pkid, t_shai_picture_address, ",
        "t_shai_cdt, t_shai_udt, ",
        "t_shai_delete)",
        "values (#{tShaiUserPkid,jdbcType=INTEGER}, #{tShaiPictureAddress,jdbcType=VARCHAR}, ",
        "#{tShaiCdt,jdbcType=TIMESTAMP}, #{tShaiUdt,jdbcType=TIMESTAMP}, ",
        "#{tShaiDelete,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tShaiPkid", before=false, resultType=Integer.class)
    int insert(Shai record);

    @InsertProvider(type=ShaiSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tShaiPkid", before=false, resultType=Integer.class)
    int insertSelective(Shai record);

    @SelectProvider(type=ShaiSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_shai_Pkid", property="tShaiPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_shai_user_pkid", property="tShaiUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_shai_picture_address", property="tShaiPictureAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_shai_cdt", property="tShaiCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_shai_udt", property="tShaiUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_shai_delete", property="tShaiDelete", jdbcType=JdbcType.INTEGER)
    })
    List<Shai> selectByExample(ShaiCriteria example);

    @Select({
        "select",
        "t_shai_Pkid, t_shai_user_pkid, t_shai_picture_address, t_shai_cdt, t_shai_udt, ",
        "t_shai_delete",
        "from t_shai",
        "where t_shai_Pkid = #{tShaiPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_shai_Pkid", property="tShaiPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_shai_user_pkid", property="tShaiUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_shai_picture_address", property="tShaiPictureAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_shai_cdt", property="tShaiCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_shai_udt", property="tShaiUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_shai_delete", property="tShaiDelete", jdbcType=JdbcType.INTEGER)
    })
    Shai selectByPrimaryKey(Integer tShaiPkid);

    @UpdateProvider(type=ShaiSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Shai record, @Param("example") ShaiCriteria example);

    @UpdateProvider(type=ShaiSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Shai record, @Param("example") ShaiCriteria example);

    @UpdateProvider(type=ShaiSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Shai record);

    @Update({
        "update t_shai",
        "set t_shai_user_pkid = #{tShaiUserPkid,jdbcType=INTEGER},",
          "t_shai_picture_address = #{tShaiPictureAddress,jdbcType=VARCHAR},",
          "t_shai_cdt = #{tShaiCdt,jdbcType=TIMESTAMP},",
          "t_shai_udt = #{tShaiUdt,jdbcType=TIMESTAMP},",
          "t_shai_delete = #{tShaiDelete,jdbcType=INTEGER}",
        "where t_shai_Pkid = #{tShaiPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Shai record);
}