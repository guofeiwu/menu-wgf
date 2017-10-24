package com.menu.wgf.mapper;

import com.menu.wgf.model.UserSign;
import com.menu.wgf.model.UserSignCriteria;
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

public interface UserSignMapper {
    @SelectProvider(type=UserSignSqlProvider.class, method="countByExample")
    long countByExample(UserSignCriteria example);

    @DeleteProvider(type=UserSignSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserSignCriteria example);

    @Delete({
        "delete from t_user_sign",
        "where t_sign_pkid = #{tSignPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tSignPkid);

    @Insert({
        "insert into t_user_sign (t_sign_user_pkid, t_sign_cdt, ",
        "t_sign_udt)",
        "values (#{tSignUserPkid,jdbcType=INTEGER}, #{tSignCdt,jdbcType=TIMESTAMP}, ",
        "#{tSignUdt,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tSignPkid", before=false, resultType=Integer.class)
    int insert(UserSign record);

    @InsertProvider(type=UserSignSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="tSignPkid", before=false, resultType=Integer.class)
    int insertSelective(UserSign record);

    @SelectProvider(type=UserSignSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_sign_pkid", property="tSignPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_sign_user_pkid", property="tSignUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_sign_cdt", property="tSignCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_sign_udt", property="tSignUdt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserSign> selectByExample(UserSignCriteria example);

    @Select({
        "select",
        "t_sign_pkid, t_sign_user_pkid, t_sign_cdt, t_sign_udt",
        "from t_user_sign",
        "where t_sign_pkid = #{tSignPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_sign_pkid", property="tSignPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_sign_user_pkid", property="tSignUserPkid", jdbcType=JdbcType.INTEGER),
        @Result(column="t_sign_cdt", property="tSignCdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_sign_udt", property="tSignUdt", jdbcType=JdbcType.TIMESTAMP)
    })
    UserSign selectByPrimaryKey(Integer tSignPkid);

    @UpdateProvider(type=UserSignSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserSign record, @Param("example") UserSignCriteria example);

    @UpdateProvider(type=UserSignSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserSign record, @Param("example") UserSignCriteria example);

    @UpdateProvider(type=UserSignSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserSign record);

    @Update({
        "update t_user_sign",
        "set t_sign_user_pkid = #{tSignUserPkid,jdbcType=INTEGER},",
          "t_sign_cdt = #{tSignCdt,jdbcType=TIMESTAMP},",
          "t_sign_udt = #{tSignUdt,jdbcType=TIMESTAMP}",
        "where t_sign_pkid = #{tSignPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserSign record);
}