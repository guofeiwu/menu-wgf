package com.menu.wgf.mapper;

import com.menu.wgf.model.Menu;
import com.menu.wgf.model.MenuCriteria;
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

public interface MenuMapper {
    @SelectProvider(type=MenuSqlProvider.class, method="countByExample")
    long countByExample(MenuCriteria example);

    @DeleteProvider(type=MenuSqlProvider.class, method="deleteByExample")
    int deleteByExample(MenuCriteria example);

    @Delete({
        "delete from t_menu",
        "where t_menu_pkid = #{tMenuPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tMenuPkid);

    @Insert({
        "insert into t_menu (t_menu_pkid, t_menu_name, ",
        "t_menu_type, t_menu_delete, ",
        "t_menu_udt, t_menu_cdt)",
        "values (#{tMenuPkid,jdbcType=INTEGER}, #{tMenuName,jdbcType=VARCHAR}, ",
        "#{tMenuType,jdbcType=INTEGER}, #{tMenuDelete,jdbcType=INTEGER}, ",
        "#{tMenuUdt,jdbcType=TIMESTAMP}, #{tMenuCdt,jdbcType=TIMESTAMP})"
    })
    int insert(Menu record);

    @InsertProvider(type=MenuSqlProvider.class, method="insertSelective")
    int insertSelective(Menu record);

    @SelectProvider(type=MenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_menu_pkid", property="tMenuPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_menu_name", property="tMenuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_menu_type", property="tMenuType", jdbcType=JdbcType.INTEGER),
        @Result(column="t_menu_delete", property="tMenuDelete", jdbcType=JdbcType.INTEGER),
        @Result(column="t_menu_udt", property="tMenuUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_menu_cdt", property="tMenuCdt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Menu> selectByExample(MenuCriteria example);

    @Select({
        "select",
        "t_menu_pkid, t_menu_name, t_menu_type, t_menu_delete, t_menu_udt, t_menu_cdt",
        "from t_menu",
        "where t_menu_pkid = #{tMenuPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_menu_pkid", property="tMenuPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_menu_name", property="tMenuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_menu_type", property="tMenuType", jdbcType=JdbcType.INTEGER),
        @Result(column="t_menu_delete", property="tMenuDelete", jdbcType=JdbcType.INTEGER),
        @Result(column="t_menu_udt", property="tMenuUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_menu_cdt", property="tMenuCdt", jdbcType=JdbcType.TIMESTAMP)
    })
    Menu selectByPrimaryKey(Integer tMenuPkid);

    @UpdateProvider(type=MenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuCriteria example);

    @UpdateProvider(type=MenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Menu record, @Param("example") MenuCriteria example);

    @UpdateProvider(type=MenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Menu record);

    @Update({
        "update t_menu",
        "set t_menu_name = #{tMenuName,jdbcType=VARCHAR},",
          "t_menu_type = #{tMenuType,jdbcType=INTEGER},",
          "t_menu_delete = #{tMenuDelete,jdbcType=INTEGER},",
          "t_menu_udt = #{tMenuUdt,jdbcType=TIMESTAMP},",
          "t_menu_cdt = #{tMenuCdt,jdbcType=TIMESTAMP}",
        "where t_menu_pkid = #{tMenuPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Menu record);
}