package com.menu.wgf.mapper;

import com.menu.wgf.model.Material;
import com.menu.wgf.model.MaterialCriteria;
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

public interface MaterialMapper {
    @SelectProvider(type=MaterialSqlProvider.class, method="countByExample")
    long countByExample(MaterialCriteria example);

    @DeleteProvider(type=MaterialSqlProvider.class, method="deleteByExample")
    int deleteByExample(MaterialCriteria example);

    @Delete({
        "delete from t_material",
        "where t_material_pkid = #{tMaterialPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tMaterialPkid);

    @Insert({
        "insert into t_material (t_material_name, t_material_menu_pkid, ",
        "t_material_cdt, t_material_udt, ",
        "t_material_delete)",
        "values (#{tMaterialName,jdbcType=VARCHAR}, #{tMaterialMenuPkid,jdbcType=INTEGER}, ",
        "#{tMaterialCdt,jdbcType=TIMESTAMP}, #{tMaterialUdt,jdbcType=TIMESTAMP}, ",
        "#{tMaterialDelete,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tMaterialPkid", before=false, resultType=Integer.class)
    int insert(Material record);

    @InsertProvider(type=MaterialSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tMaterialPkid", before=false, resultType=Integer.class)
    int insertSelective(Material record);

    @SelectProvider(type=MaterialSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_material_pkid", property="tMaterialPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_material_name", property="tMaterialName", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_material_menu_pkid", property="tMaterialMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_material_cdt", property="tMaterialCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_material_udt", property="tMaterialUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_material_delete", property="tMaterialDelete", jdbcType=JdbcType.INTEGER)
    })
    List<Material> selectByExample(MaterialCriteria example);

    @Select({
        "select",
        "t_material_pkid, t_material_name, t_material_menu_pkid, t_material_cdt, t_material_udt, ",
        "t_material_delete",
        "from t_material",
        "where t_material_pkid = #{tMaterialPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_material_pkid", property="tMaterialPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_material_name", property="tMaterialName", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_material_menu_pkid", property="tMaterialMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_material_cdt", property="tMaterialCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_material_udt", property="tMaterialUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_material_delete", property="tMaterialDelete", jdbcType=JdbcType.INTEGER)
    })
    Material selectByPrimaryKey(Integer tMaterialPkid);

    @UpdateProvider(type=MaterialSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialCriteria example);

    @UpdateProvider(type=MaterialSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Material record, @Param("example") MaterialCriteria example);

    @UpdateProvider(type=MaterialSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Material record);

    @Update({
        "update t_material",
        "set t_material_name = #{tMaterialName,jdbcType=VARCHAR},",
          "t_material_menu_pkid = #{tMaterialMenuPkid,jdbcType=INTEGER},",
          "t_material_cdt = #{tMaterialCdt,jdbcType=TIMESTAMP},",
          "t_material_udt = #{tMaterialUdt,jdbcType=TIMESTAMP},",
          "t_material_delete = #{tMaterialDelete,jdbcType=INTEGER}",
        "where t_material_pkid = #{tMaterialPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Material record);
}