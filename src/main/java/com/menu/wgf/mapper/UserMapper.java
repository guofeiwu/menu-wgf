package com.menu.wgf.mapper;

import com.menu.wgf.model.User;
import com.menu.wgf.model.UserCriteria;
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

public interface UserMapper {
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    long countByExample(UserCriteria example);

    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserCriteria example);

    @Delete({
        "delete from t_user",
        "where t_user_pkid = #{tUserPkid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tUserPkid);

    @Insert({
        "insert into t_user (t_user_pkid, t_user_name, ",
        "t_user_sex, t_user_birthday, ",
        "t_user_icon, t_user_udt, ",
        "t_user_cdt)",
        "values (#{tUserPkid,jdbcType=INTEGER}, #{tUserName,jdbcType=VARCHAR}, ",
        "#{tUserSex,jdbcType=INTEGER}, #{tUserBirthday,jdbcType=VARCHAR}, ",
        "#{tUserIcon,jdbcType=VARCHAR}, #{tUserUdt,jdbcType=TIMESTAMP}, ",
        "#{tUserCdt,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="t_user_pkid", property="tUserPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_user_name", property="tUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_user_sex", property="tUserSex", jdbcType=JdbcType.INTEGER),
        @Result(column="t_user_birthday", property="tUserBirthday", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_user_icon", property="tUserIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_user_udt", property="tUserUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_user_cdt", property="tUserCdt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<User> selectByExample(UserCriteria example);

    @Select({
        "select",
        "t_user_pkid, t_user_name, t_user_sex, t_user_birthday, t_user_icon, t_user_udt, ",
        "t_user_cdt",
        "from t_user",
        "where t_user_pkid = #{tUserPkid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="t_user_pkid", property="tUserPkid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="t_user_name", property="tUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_user_sex", property="tUserSex", jdbcType=JdbcType.INTEGER),
        @Result(column="t_user_birthday", property="tUserBirthday", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_user_icon", property="tUserIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="t_user_udt", property="tUserUdt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="t_user_cdt", property="tUserCdt", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(Integer tUserPkid);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserCriteria example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserCriteria example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update t_user",
        "set t_user_name = #{tUserName,jdbcType=VARCHAR},",
          "t_user_sex = #{tUserSex,jdbcType=INTEGER},",
          "t_user_birthday = #{tUserBirthday,jdbcType=VARCHAR},",
          "t_user_icon = #{tUserIcon,jdbcType=VARCHAR},",
          "t_user_udt = #{tUserUdt,jdbcType=TIMESTAMP},",
          "t_user_cdt = #{tUserCdt,jdbcType=TIMESTAMP}",
        "where t_user_pkid = #{tUserPkid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}