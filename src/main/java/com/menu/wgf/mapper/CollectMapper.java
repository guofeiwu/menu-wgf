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
        "where \"t_collect _pkid\" = #{tCollectPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tCollectPkid);

    @Insert({
        "insert into t_collect (\"t_collect _pkid\", \"t_collect_user _pkid\", ",
        "\"t_ collect _menu_pkid\", \"t_collect _cdt\", ",
        "\"t_collect _udt\", \"t_collect _cancel\")",
        "values (#{tCollectPkid,jdbcType=INTEGER}, #{tCollectUserPkid,jdbcType=INTEGER}, ",
        "#{tCollectMenuPkid,jdbcType=INTEGER}, #{tCollectCdt,jdbcType=TIMESTAMP}, ",
        "#{tCollectUdt,jdbcType=TIMESTAMP}, #{tCollectCancel,jdbcType=INTEGER})"
    })
    int insert(Collect record);

    @InsertProvider(type=CollectSqlProvider.class, method="insertSelective")
    int insertSelective(Collect record);

    @SelectProvider(type=CollectSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_collect _pkid", property="tCollectPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_collect_user _pkid", property="tCollectUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_ collect _menu_pkid", property="tCollectMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_collect _cdt", property="tCollectCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_collect _udt", property="tCollectUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_collect _cancel", property="tCollectCancel", jdbcType=JdbcType.INTEGER)
    })
    List<Collect> selectByExample(CollectCriteria example);

    @Select({
        "select",
        "\"t_collect _pkid\", \"t_collect_user _pkid\", \"t_ collect _menu_pkid\", \"t_collect _cdt\", ",
        "\"t_collect _udt\", \"t_collect _cancel\"",
        "from t_collect",
        "where \"t_collect _pkid\" = #{tCollectPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_collect _pkid", property="tCollectPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_collect_user _pkid", property="tCollectUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_ collect _menu_pkid", property="tCollectMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_collect _cdt", property="tCollectCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_collect _udt", property="tCollectUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_collect _cancel", property="tCollectCancel", jdbcType=JdbcType.INTEGER)
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
        "set \"t_collect_user _pkid\" = #{tCollectUserPkid,jdbcType=INTEGER},",
          "\"t_ collect _menu_pkid\" = #{tCollectMenuPkid,jdbcType=INTEGER},",
          "\"t_collect _cdt\" = #{tCollectCdt,jdbcType=TIMESTAMP},",
          "\"t_collect _udt\" = #{tCollectUdt,jdbcType=TIMESTAMP},",
          "\"t_collect _cancel\" = #{tCollectCancel,jdbcType=INTEGER}",
        "where \"t_collect _pkid\" = #{tCollectPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Collect record);
}