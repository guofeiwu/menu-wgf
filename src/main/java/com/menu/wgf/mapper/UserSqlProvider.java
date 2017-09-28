package com.menu.wgf.mapper;

import com.menu.wgf.model.User;
import com.menu.wgf.model.UserCriteria.Criteria;
import com.menu.wgf.model.UserCriteria.Criterion;
import com.menu.wgf.model.UserCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String countByExample(UserCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(UserCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_user");
        
        if (record.gettUserName() != null) {
            sql.VALUES("t_user_name", "#{tUserName,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserPhone() != null) {
            sql.VALUES("t_user_phone", "#{tUserPhone,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserPassword() != null) {
            sql.VALUES("t_user_password", "#{tUserPassword,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserSex() != null) {
            sql.VALUES("t_user_sex", "#{tUserSex,jdbcType=INTEGER}");
        }
        
        if (record.gettUserPoint() != null) {
            sql.VALUES("t_user_point", "#{tUserPoint,jdbcType=INTEGER}");
        }
        
        if (record.gettUserSign() != null) {
            sql.VALUES("t_user_sign", "#{tUserSign,jdbcType=INTEGER}");
        }
        
        if (record.gettUserLevel() != null) {
            sql.VALUES("t_user_level", "#{tUserLevel,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserBirthday() != null) {
            sql.VALUES("t_user_birthday", "#{tUserBirthday,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserIcon() != null) {
            sql.VALUES("t_user_icon", "#{tUserIcon,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserUdt() != null) {
            sql.VALUES("t_user_udt", "#{tUserUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettUserCdt() != null) {
            sql.VALUES("t_user_cdt", "#{tUserCdt,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(UserCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("t_user_pkid");
        } else {
            sql.SELECT("t_user_pkid");
        }
        sql.SELECT("t_user_name");
        sql.SELECT("t_user_phone");
        sql.SELECT("t_user_password");
        sql.SELECT("t_user_sex");
        sql.SELECT("t_user_point");
        sql.SELECT("t_user_sign");
        sql.SELECT("t_user_level");
        sql.SELECT("t_user_birthday");
        sql.SELECT("t_user_icon");
        sql.SELECT("t_user_udt");
        sql.SELECT("t_user_cdt");
        sql.FROM("t_user");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        User record = (User) parameter.get("record");
        UserCriteria example = (UserCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_user");
        
        if (record.gettUserPkid() != null) {
            sql.SET("t_user_pkid = #{record.tUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettUserName() != null) {
            sql.SET("t_user_name = #{record.tUserName,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserPhone() != null) {
            sql.SET("t_user_phone = #{record.tUserPhone,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserPassword() != null) {
            sql.SET("t_user_password = #{record.tUserPassword,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserSex() != null) {
            sql.SET("t_user_sex = #{record.tUserSex,jdbcType=INTEGER}");
        }
        
        if (record.gettUserPoint() != null) {
            sql.SET("t_user_point = #{record.tUserPoint,jdbcType=INTEGER}");
        }
        
        if (record.gettUserSign() != null) {
            sql.SET("t_user_sign = #{record.tUserSign,jdbcType=INTEGER}");
        }
        
        if (record.gettUserLevel() != null) {
            sql.SET("t_user_level = #{record.tUserLevel,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserBirthday() != null) {
            sql.SET("t_user_birthday = #{record.tUserBirthday,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserIcon() != null) {
            sql.SET("t_user_icon = #{record.tUserIcon,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserUdt() != null) {
            sql.SET("t_user_udt = #{record.tUserUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettUserCdt() != null) {
            sql.SET("t_user_cdt = #{record.tUserCdt,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_user");
        
        sql.SET("t_user_pkid = #{record.tUserPkid,jdbcType=INTEGER}");
        sql.SET("t_user_name = #{record.tUserName,jdbcType=VARCHAR}");
        sql.SET("t_user_phone = #{record.tUserPhone,jdbcType=VARCHAR}");
        sql.SET("t_user_password = #{record.tUserPassword,jdbcType=VARCHAR}");
        sql.SET("t_user_sex = #{record.tUserSex,jdbcType=INTEGER}");
        sql.SET("t_user_point = #{record.tUserPoint,jdbcType=INTEGER}");
        sql.SET("t_user_sign = #{record.tUserSign,jdbcType=INTEGER}");
        sql.SET("t_user_level = #{record.tUserLevel,jdbcType=VARCHAR}");
        sql.SET("t_user_birthday = #{record.tUserBirthday,jdbcType=VARCHAR}");
        sql.SET("t_user_icon = #{record.tUserIcon,jdbcType=VARCHAR}");
        sql.SET("t_user_udt = #{record.tUserUdt,jdbcType=TIMESTAMP}");
        sql.SET("t_user_cdt = #{record.tUserCdt,jdbcType=TIMESTAMP}");
        
        UserCriteria example = (UserCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("t_user");
        
        if (record.gettUserName() != null) {
            sql.SET("t_user_name = #{tUserName,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserPhone() != null) {
            sql.SET("t_user_phone = #{tUserPhone,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserPassword() != null) {
            sql.SET("t_user_password = #{tUserPassword,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserSex() != null) {
            sql.SET("t_user_sex = #{tUserSex,jdbcType=INTEGER}");
        }
        
        if (record.gettUserPoint() != null) {
            sql.SET("t_user_point = #{tUserPoint,jdbcType=INTEGER}");
        }
        
        if (record.gettUserSign() != null) {
            sql.SET("t_user_sign = #{tUserSign,jdbcType=INTEGER}");
        }
        
        if (record.gettUserLevel() != null) {
            sql.SET("t_user_level = #{tUserLevel,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserBirthday() != null) {
            sql.SET("t_user_birthday = #{tUserBirthday,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserIcon() != null) {
            sql.SET("t_user_icon = #{tUserIcon,jdbcType=VARCHAR}");
        }
        
        if (record.gettUserUdt() != null) {
            sql.SET("t_user_udt = #{tUserUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettUserCdt() != null) {
            sql.SET("t_user_cdt = #{tUserCdt,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("t_user_pkid = #{tUserPkid,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, UserCriteria example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}