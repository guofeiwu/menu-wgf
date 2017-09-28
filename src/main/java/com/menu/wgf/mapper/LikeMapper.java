package com.menu.wgf.mapper;

import com.menu.wgf.model.Like;
import com.menu.wgf.model.LikeCriteria;
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

public interface LikeMapper {
    @SelectProvider(type=LikeSqlProvider.class, method="countByExample")
    long countByExample(LikeCriteria example);

    @DeleteProvider(type=LikeSqlProvider.class, method="deleteByExample")
    int deleteByExample(LikeCriteria example);

    @Delete({
        "delete from t_like",
        "where t_like_pkid = #{tLikePkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tLikePkid);

    @Insert({
        "insert into t_like (t_like_user_pkid, t_like_menu_pkid, ",
        "t_like_shai_pkid, t_like_cdt, ",
        "t_like_udt, t_like_delete)",
        "values (#{tLikeUserPkid,jdbcType=INTEGER}, #{tLikeMenuPkid,jdbcType=INTEGER}, ",
        "#{tLikeShaiPkid,jdbcType=INTEGER}, #{tLikeCdt,jdbcType=TIMESTAMP}, ",
        "#{tLikeUdt,jdbcType=TIMESTAMP}, #{tLikeDelete,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tLikePkid", before=false, resultType=Integer.class)
    int insert(Like record);

    @InsertProvider(type=LikeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tLikePkid", before=false, resultType=Integer.class)
    int insertSelective(Like record);

    @SelectProvider(type=LikeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_like_pkid", property="tLikePkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_like_user_pkid", property="tLikeUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_like_menu_pkid", property="tLikeMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_like_shai_pkid", property="tLikeShaiPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_like_cdt", property="tLikeCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_like_udt", property="tLikeUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_like_delete", property="tLikeDelete", jdbcType=JdbcType.INTEGER)
    })
    List<Like> selectByExample(LikeCriteria example);

    @Select({
        "select",
        "t_like_pkid, t_like_user_pkid, t_like_menu_pkid, t_like_shai_pkid, t_like_cdt, ",
        "t_like_udt, t_like_delete",
        "from t_like",
        "where t_like_pkid = #{tLikePkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_like_pkid", property="tLikePkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_like_user_pkid", property="tLikeUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_like_menu_pkid", property="tLikeMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_like_shai_pkid", property="tLikeShaiPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_like_cdt", property="tLikeCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_like_udt", property="tLikeUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_like_delete", property="tLikeDelete", jdbcType=JdbcType.INTEGER)
    })
    Like selectByPrimaryKey(Integer tLikePkid);

    @UpdateProvider(type=LikeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Like record, @Param("example") LikeCriteria example);

    @UpdateProvider(type=LikeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Like record, @Param("example") LikeCriteria example);

    @UpdateProvider(type=LikeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Like record);

    @Update({
        "update t_like",
        "set t_like_user_pkid = #{tLikeUserPkid,jdbcType=INTEGER},",
          "t_like_menu_pkid = #{tLikeMenuPkid,jdbcType=INTEGER},",
          "t_like_shai_pkid = #{tLikeShaiPkid,jdbcType=INTEGER},",
          "t_like_cdt = #{tLikeCdt,jdbcType=TIMESTAMP},",
          "t_like_udt = #{tLikeUdt,jdbcType=TIMESTAMP},",
          "t_like_delete = #{tLikeDelete,jdbcType=INTEGER}",
        "where t_like_pkid = #{tLikePkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Like record);
}