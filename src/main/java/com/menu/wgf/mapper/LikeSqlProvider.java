package com.menu.wgf.mapper;

import com.menu.wgf.model.Like;
import com.menu.wgf.model.LikeCriteria.Criteria;
import com.menu.wgf.model.LikeCriteria.Criterion;
import com.menu.wgf.model.LikeCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class LikeSqlProvider {

    public String countByExample(LikeCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_like");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(LikeCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_like");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Like record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_like");
        
        if (record.gettLikePkid() != null) {
            sql.VALUES("t_like_pkid", "#{tLikePkid,jdbcType=INTEGER}");
        }
        
        if (record.gettLikeUserPkid() != null) {
            sql.VALUES("t_like_user_pkid", "#{tLikeUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettLikeMenuPkid() != null) {
            sql.VALUES("t_like_menu_pkid", "#{tLikeMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettLikeCdt() != null) {
            sql.VALUES("t_like_cdt", "#{tLikeCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettLikeUdt() != null) {
            sql.VALUES("t_like_udt", "#{tLikeUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettLikeDelete() != null) {
            sql.VALUES("t_like_delete", "#{tLikeDelete,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(LikeCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("t_like_pkid");
        } else {
            sql.SELECT("t_like_pkid");
        }
        sql.SELECT("t_like_user_pkid");
        sql.SELECT("t_like_menu_pkid");
        sql.SELECT("t_like_cdt");
        sql.SELECT("t_like_udt");
        sql.SELECT("t_like_delete");
        sql.FROM("t_like");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Like record = (Like) parameter.get("record");
        LikeCriteria example = (LikeCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_like");
        
        if (record.gettLikePkid() != null) {
            sql.SET("t_like_pkid = #{record.tLikePkid,jdbcType=INTEGER}");
        }
        
        if (record.gettLikeUserPkid() != null) {
            sql.SET("t_like_user_pkid = #{record.tLikeUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettLikeMenuPkid() != null) {
            sql.SET("t_like_menu_pkid = #{record.tLikeMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettLikeCdt() != null) {
            sql.SET("t_like_cdt = #{record.tLikeCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettLikeUdt() != null) {
            sql.SET("t_like_udt = #{record.tLikeUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettLikeDelete() != null) {
            sql.SET("t_like_delete = #{record.tLikeDelete,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_like");
        
        sql.SET("t_like_pkid = #{record.tLikePkid,jdbcType=INTEGER}");
        sql.SET("t_like_user_pkid = #{record.tLikeUserPkid,jdbcType=INTEGER}");
        sql.SET("t_like_menu_pkid = #{record.tLikeMenuPkid,jdbcType=INTEGER}");
        sql.SET("t_like_cdt = #{record.tLikeCdt,jdbcType=TIMESTAMP}");
        sql.SET("t_like_udt = #{record.tLikeUdt,jdbcType=TIMESTAMP}");
        sql.SET("t_like_delete = #{record.tLikeDelete,jdbcType=INTEGER}");
        
        LikeCriteria example = (LikeCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Like record) {
        SQL sql = new SQL();
        sql.UPDATE("t_like");
        
        if (record.gettLikeUserPkid() != null) {
            sql.SET("t_like_user_pkid = #{tLikeUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettLikeMenuPkid() != null) {
            sql.SET("t_like_menu_pkid = #{tLikeMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettLikeCdt() != null) {
            sql.SET("t_like_cdt = #{tLikeCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettLikeUdt() != null) {
            sql.SET("t_like_udt = #{tLikeUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettLikeDelete() != null) {
            sql.SET("t_like_delete = #{tLikeDelete,jdbcType=INTEGER}");
        }
        
        sql.WHERE("t_like_pkid = #{tLikePkid,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, LikeCriteria example, boolean includeExamplePhrase) {
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