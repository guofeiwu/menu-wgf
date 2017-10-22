package com.menu.wgf.mapper;

import com.menu.wgf.model.Record;
import com.menu.wgf.model.RecordCriteria;
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

public interface RecordMapper {
    @SelectProvider(type=RecordSqlProvider.class, method="countByExample")
    long countByExample(RecordCriteria example);

    @DeleteProvider(type=RecordSqlProvider.class, method="deleteByExample")
    int deleteByExample(RecordCriteria example);

    @Delete({
        "delete from t_record",
        "where t_record_pkid = #{tRecordPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tRecordPkid);

    @Insert({
        "insert into t_record (t_record_user_pkid, t_record_menu_pkid, ",
        "t_record_cdt, t_record_udt, ",
        "t_record_delete)",
        "values (#{tRecordUserPkid,jdbcType=INTEGER}, #{tRecordMenuPkid,jdbcType=INTEGER}, ",
        "#{tRecordCdt,jdbcType=TIMESTAMP}, #{tRecordUdt,jdbcType=TIMESTAMP}, ",
        "#{tRecordDelete,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tRecordPkid", before=false, resultType=Integer.class)
    int insert(Record record);

    @InsertProvider(type=RecordSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tRecordPkid", before=false, resultType=Integer.class)
    int insertSelective(Record record);

    @SelectProvider(type=RecordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_record_pkid", property="tRecordPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_record_user_pkid", property="tRecordUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_record_menu_pkid", property="tRecordMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_record_cdt", property="tRecordCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_record_udt", property="tRecordUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_record_delete", property="tRecordDelete", jdbcType=JdbcType.INTEGER)
    })
    List<Record> selectByExample(RecordCriteria example);

    @Select({
        "select",
        "t_record_pkid, t_record_user_pkid, t_record_menu_pkid, t_record_cdt, t_record_udt, ",
        "t_record_delete",
        "from t_record",
        "where t_record_pkid = #{tRecordPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_record_pkid", property="tRecordPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_record_user_pkid", property="tRecordUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_record_menu_pkid", property="tRecordMenuPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_record_cdt", property="tRecordCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_record_udt", property="tRecordUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_record_delete", property="tRecordDelete", jdbcType=JdbcType.INTEGER)
    })
    Record selectByPrimaryKey(Integer tRecordPkid);

    @UpdateProvider(type=RecordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Record record, @Param("example") RecordCriteria example);

    @UpdateProvider(type=RecordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Record record, @Param("example") RecordCriteria example);

    @UpdateProvider(type=RecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Record record);

    @Update({
        "update t_record",
        "set t_record_user_pkid = #{tRecordUserPkid,jdbcType=INTEGER},",
          "t_record_menu_pkid = #{tRecordMenuPkid,jdbcType=INTEGER},",
          "t_record_cdt = #{tRecordCdt,jdbcType=TIMESTAMP},",
          "t_record_udt = #{tRecordUdt,jdbcType=TIMESTAMP},",
          "t_record_delete = #{tRecordDelete,jdbcType=INTEGER}",
        "where t_record_pkid = #{tRecordPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Record record);
}