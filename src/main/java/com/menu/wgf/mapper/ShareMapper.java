package com.menu.wgf.mapper;

import com.menu.wgf.model.Share;
import com.menu.wgf.model.ShareCriteria;
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

public interface ShareMapper {
    @SelectProvider(type=ShareSqlProvider.class, method="countByExample")
    long countByExample(ShareCriteria example);

    @DeleteProvider(type=ShareSqlProvider.class, method="deleteByExample")
    int deleteByExample(ShareCriteria example);

    @Delete({
        "delete from t_share",
        "where t_share_pkid = #{tSharePkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tSharePkid);

    @Insert({
        "insert into t_share (t_share_user_pkid, t_share_menu_pkid, ",
        "t_share_cdt, t_share_udt)",
        "values (#{tShareUserPkid,jdbcType=INTEGER}, #{tShareMenuPkid,jdbcType=INTEGER}, ",
        "#{tShareCdt,jdbcType=TIMESTAMP}, #{tShareUdt,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tSharePkid", before=false, resultType=Integer.class)
    int insert(Share record);

    @InsertProvider(type=ShareSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tSharePkid", before=false, resultType=Integer.class)
    int insertSelective(Share record);

    @SelectProvider(type=ShareSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_share_pkid", property="tSharePkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_share_user_pkid", property="tShareUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_share_menu_pkid", property="tShareMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_share_cdt", property="tShareCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_share_udt", property="tShareUdt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Share> selectByExample(ShareCriteria example);

    @Select({
        "select",
        "t_share_pkid, t_share_user_pkid, t_share_menu_pkid, t_share_cdt, t_share_udt",
        "from t_share",
        "where t_share_pkid = #{tSharePkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_share_pkid", property="tSharePkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_share_user_pkid", property="tShareUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_share_menu_pkid", property="tShareMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_share_cdt", property="tShareCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_share_udt", property="tShareUdt", jdbcType=JdbcType.TIMESTAMP)
    })
    Share selectByPrimaryKey(Integer tSharePkid);

    @UpdateProvider(type=ShareSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Share record, @Param("example") ShareCriteria example);

    @UpdateProvider(type=ShareSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Share record, @Param("example") ShareCriteria example);

    @UpdateProvider(type=ShareSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Share record);

    @Update({
        "update t_share",
        "set t_share_user_pkid = #{tShareUserPkid,jdbcType=INTEGER},",
          "t_share_menu_pkid = #{tShareMenuPkid,jdbcType=INTEGER},",
          "t_share_cdt = #{tShareCdt,jdbcType=TIMESTAMP},",
          "t_share_udt = #{tShareUdt,jdbcType=TIMESTAMP}",
        "where t_share_pkid = #{tSharePkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Share record);
}