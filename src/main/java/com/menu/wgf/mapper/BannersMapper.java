package com.menu.wgf.mapper;

import com.menu.wgf.model.Banners;
import com.menu.wgf.model.BannersCriteria;
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

public interface BannersMapper {
    @SelectProvider(type=BannersSqlProvider.class, method="countByExample")
    long countByExample(BannersCriteria example);

    @DeleteProvider(type=BannersSqlProvider.class, method="deleteByExample")
    int deleteByExample(BannersCriteria example);

    @Delete({
        "delete from t_banner",
        "where t_banner_pkid = #{tBannerPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tBannerPkid);

    @Insert({
        "insert into t_banner (t_banner_menu_pkid, t_banner_menu_desc, ",
        "t_banner_cdt, t_banner_udt, ",
        "t_banner_delete)",
        "values (#{tBannerMenuPkid,jdbcType=INTEGER}, #{tBannerMenuDesc,jdbcType=VARCHAR}, ",
        "#{tBannerCdt,jdbcType=TIMESTAMP}, #{tBannerUdt,jdbcType=TIMESTAMP}, ",
        "#{tBannerDelete,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tBannerPkid", before=false, resultType=Integer.class)
    int insert(Banners record);

    @InsertProvider(type=BannersSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tBannerPkid", before=false, resultType=Integer.class)
    int insertSelective(Banners record);

    @SelectProvider(type=BannersSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_banner_pkid", property="tBannerPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_banner_menu_pkid", property="tBannerMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_banner_menu_desc", property="tBannerMenuDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_banner_cdt", property="tBannerCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_banner_udt", property="tBannerUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_banner_delete", property="tBannerDelete", jdbcType=JdbcType.INTEGER)
    })
    List<Banners> selectByExample(BannersCriteria example);

    @Select({
        "select",
        "t_banner_pkid, t_banner_menu_pkid, t_banner_menu_desc, t_banner_cdt, t_banner_udt, ",
        "t_banner_delete",
        "from t_banner",
        "where t_banner_pkid = #{tBannerPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_banner_pkid", property="tBannerPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_banner_menu_pkid", property="tBannerMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_banner_menu_desc", property="tBannerMenuDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_banner_cdt", property="tBannerCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_banner_udt", property="tBannerUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_banner_delete", property="tBannerDelete", jdbcType=JdbcType.INTEGER)
    })
    Banners selectByPrimaryKey(Integer tBannerPkid);

    @UpdateProvider(type=BannersSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Banners record, @Param("example") BannersCriteria example);

    @UpdateProvider(type=BannersSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Banners record, @Param("example") BannersCriteria example);

    @UpdateProvider(type=BannersSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Banners record);

    @Update({
        "update t_banner",
        "set t_banner_menu_pkid = #{tBannerMenuPkid,jdbcType=INTEGER},",
          "t_banner_menu_desc = #{tBannerMenuDesc,jdbcType=VARCHAR},",
          "t_banner_cdt = #{tBannerCdt,jdbcType=TIMESTAMP},",
          "t_banner_udt = #{tBannerUdt,jdbcType=TIMESTAMP},",
          "t_banner_delete = #{tBannerDelete,jdbcType=INTEGER}",
        "where t_banner_pkid = #{tBannerPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Banners record);
}