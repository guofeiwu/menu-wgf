package com.menu.wgf.mapper;

import com.menu.wgf.model.AppInfo;
import com.menu.wgf.model.AppInfoCriteria;
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

public interface AppInfoMapper {
    @SelectProvider(type=AppInfoSqlProvider.class, method="countByExample")
    long countByExample(AppInfoCriteria example);

    @DeleteProvider(type=AppInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(AppInfoCriteria example);

    @Delete({
        "delete from t_app",
        "where t_app_pkid = #{tAppPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tAppPkid);

    @Insert({
        "insert into t_app (t_app_ver, t_app_download_url, ",
        "t_app_ver_desc, t_app_cdt, ",
        "t_app_udt, t_app_delete)",
        "values (#{tAppVer,jdbcType=REAL}, #{tAppDownloadUrl,jdbcType=VARCHAR}, ",
        "#{tAppVerDesc,jdbcType=VARCHAR}, #{tAppCdt,jdbcType=TIMESTAMP}, ",
        "#{tAppUdt,jdbcType=TIMESTAMP}, #{tAppDelete,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tAppPkid", before=false, resultType=Integer.class)
    int insert(AppInfo record);

    @InsertProvider(type=AppInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tAppPkid", before=false, resultType=Integer.class)
    int insertSelective(AppInfo record);

    @SelectProvider(type=AppInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_app_pkid", property="tAppPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_app_ver", property="tAppVer", jdbcType=JdbcType.REAL),
        @Result(column="t_app_download_url", property="tAppDownloadUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_app_ver_desc", property="tAppVerDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_app_cdt", property="tAppCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_app_udt", property="tAppUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_app_delete", property="tAppDelete", jdbcType=JdbcType.INTEGER)
    })
    List<AppInfo> selectByExample(AppInfoCriteria example);

    @Select({
        "select",
        "t_app_pkid, t_app_ver, t_app_download_url, t_app_ver_desc, t_app_cdt, t_app_udt, ",
        "t_app_delete",
        "from t_app",
        "where t_app_pkid = #{tAppPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_app_pkid", property="tAppPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_app_ver", property="tAppVer", jdbcType=JdbcType.REAL),
        @Result(column="t_app_download_url", property="tAppDownloadUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_app_ver_desc", property="tAppVerDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_app_cdt", property="tAppCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_app_udt", property="tAppUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_app_delete", property="tAppDelete", jdbcType=JdbcType.INTEGER)
    })
    AppInfo selectByPrimaryKey(Integer tAppPkid);

    @UpdateProvider(type=AppInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AppInfo record, @Param("example") AppInfoCriteria example);

    @UpdateProvider(type=AppInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AppInfo record, @Param("example") AppInfoCriteria example);

    @UpdateProvider(type=AppInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AppInfo record);

    @Update({
        "update t_app",
        "set t_app_ver = #{tAppVer,jdbcType=REAL},",
          "t_app_download_url = #{tAppDownloadUrl,jdbcType=VARCHAR},",
          "t_app_ver_desc = #{tAppVerDesc,jdbcType=VARCHAR},",
          "t_app_cdt = #{tAppCdt,jdbcType=TIMESTAMP},",
          "t_app_udt = #{tAppUdt,jdbcType=TIMESTAMP},",
          "t_app_delete = #{tAppDelete,jdbcType=INTEGER}",
        "where t_app_pkid = #{tAppPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AppInfo record);
}