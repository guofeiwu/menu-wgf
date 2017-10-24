package com.menu.wgf.mapper;

import com.menu.wgf.model.UserSign;
import com.menu.wgf.model.UserSignCriteria.Criteria;
import com.menu.wgf.model.UserSignCriteria.Criterion;
import com.menu.wgf.model.UserSignCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserSignSqlProvider {

    public String countByExample(UserSignCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_user_sign");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(UserSignCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_user_sign");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(UserSign record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_user_sign");
        
        if (record.gettSignUserPkid() != null) {
            sql.VALUES("t_sign_user_pkid", "#{tSignUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettSignCdt() != null) {
            sql.VALUES("t_sign_cdt", "#{tSignCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettSignUdt() != null) {
            sql.VALUES("t_sign_udt", "#{tSignUdt,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(UserSignCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("t_sign_pkid");
        } else {
            sql.SELECT("t_sign_pkid");
        }
        sql.SELECT("t_sign_user_pkid");
        sql.SELECT("t_sign_cdt");
        sql.SELECT("t_sign_udt");
        sql.FROM("t_user_sign");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserSign record = (UserSign) parameter.get("record");
        UserSignCriteria example = (UserSignCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_user_sign");
        
        if (record.gettSignPkid() != null) {
            sql.SET("t_sign_pkid = #{record.tSignPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettSignUserPkid() != null) {
            sql.SET("t_sign_user_pkid = #{record.tSignUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettSignCdt() != null) {
            sql.SET("t_sign_cdt = #{record.tSignCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettSignUdt() != null) {
            sql.SET("t_sign_udt = #{record.tSignUdt,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_user_sign");
        
        sql.SET("t_sign_pkid = #{record.tSignPkid,jdbcType=INTEGER}");
        sql.SET("t_sign_user_pkid = #{record.tSignUserPkid,jdbcType=INTEGER}");
        sql.SET("t_sign_cdt = #{record.tSignCdt,jdbcType=TIMESTAMP}");
        sql.SET("t_sign_udt = #{record.tSignUdt,jdbcType=TIMESTAMP}");
        
        UserSignCriteria example = (UserSignCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserSign record) {
        SQL sql = new SQL();
        sql.UPDATE("t_user_sign");
        
        if (record.gettSignUserPkid() != null) {
            sql.SET("t_sign_user_pkid = #{tSignUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettSignCdt() != null) {
            sql.SET("t_sign_cdt = #{tSignCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettSignUdt() != null) {
            sql.SET("t_sign_udt = #{tSignUdt,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("t_sign_pkid = #{tSignPkid,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, UserSignCriteria example, boolean includeExamplePhrase) {
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