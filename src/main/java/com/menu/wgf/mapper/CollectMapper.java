package com.menu.wgf.mapper;

import com.menu.wgf.model.Collect;
import com.menu.wgf.model.CollectCriteria;
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

public interface CollectMapper {
    @SelectProvider(type=CollectSqlProvider.class, method="countByExample")
    long countByExample(CollectCriteria example);

    @DeleteProvider(type=CollectSqlProvider.class, method="deleteByExample")
    int deleteByExample(CollectCriteria example);

    @Delete({
        "delete from t_collect",
        "where t_collect_pkid = #{tCollectPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tCollectPkid);

    @Insert({
        "insert into t_collect (t_collect_user_pkid, t_collect_menu_pkid, ",
        "t_collect_cdt, t_collect_udt, ",
        "t_collect_cancel)",
        "values (#{tCollectUserPkid,jdbcType=INTEGER}, #{tCollectMenuPkid,jdbcType=INTEGER}, ",
        "#{tCollectCdt,jdbcType=TIMESTAMP}, #{tCollectUdt,jdbcType=TIMESTAMP}, ",
        "#{tCollectCancel,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tCollectPkid", before=false, resultType=Integer.class)
    int insert(Collect record);

    @InsertProvider(type=CollectSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tCollectPkid", before=false, resultType=Integer.class)
    int insertSelective(Collect record);

    @SelectProvider(type=CollectSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_collect_pkid", property="tCollectPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_collect_user_pkid", property="tCollectUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_collect_menu_pkid", property="tCollectMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_collect_cdt", property="tCollectCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_collect_udt", property="tCollectUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_collect_cancel", property="tCollectCancel", jdbcType=JdbcType.INTEGER)
    })
    List<Collect> selectByExample(CollectCriteria example);

    @Select({
        "select",
        "t_collect_pkid, t_collect_user_pkid, t_collect_menu_pkid, t_collect_cdt, t_collect_udt, ",
        "t_collect_cancel",
        "from t_collect",
        "where t_collect_pkid = #{tCollectPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_collect_pkid", property="tCollectPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_collect_user_pkid", property="tCollectUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_collect_menu_pkid", property="tCollectMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_collect_cdt", property="tCollectCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_collect_udt", property="tCollectUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_collect_cancel", property="tCollectCancel", jdbcType=JdbcType.INTEGER)
    })
    Collect selectByPrimaryKey(Integer tCollectPkid);

    @UpdateProvider(type=CollectSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectCriteria example);

    @UpdateProvider(type=CollectSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Collect record, @Param("example") CollectCriteria example);

    @UpdateProvider(type=CollectSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Collect record);

    @Update({
        "update t_collect",
        "set t_collect_user_pkid = #{tCollectUserPkid,jdbcType=INTEGER},",
          "t_collect_menu_pkid = #{tCollectMenuPkid,jdbcType=INTEGER},",
          "t_collect_cdt = #{tCollectCdt,jdbcType=TIMESTAMP},",
          "t_collect_udt = #{tCollectUdt,jdbcType=TIMESTAMP},",
          "t_collect_cancel = #{tCollectCancel,jdbcType=INTEGER}",
        "where t_collect_pkid = #{tCollectPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Collect record);
}