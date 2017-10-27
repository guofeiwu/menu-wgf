package com.menu.wgf.mapper;

import com.menu.wgf.model.Recommend;
import com.menu.wgf.model.RecommendCriteria.Criteria;
import com.menu.wgf.model.RecommendCriteria.Criterion;
import com.menu.wgf.model.RecommendCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class RecommendSqlProvider {

    public String countByExample(RecommendCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_recommend");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(RecommendCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_recommend");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Recommend record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_recommend");
        
        if (record.gettRecommendName() != null) {
            sql.VALUES("t_recommend_name", "#{tRecommendName,jdbcType=VARCHAR}");
        }
        
        if (record.gettRecommendType() != null) {
            sql.VALUES("t_recommend_type", "#{tRecommendType,jdbcType=INTEGER}");
        }
        
        if (record.gettRecommendCdt() != null) {
            sql.VALUES("t_recommend_cdt", "#{tRecommendCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettRecommendUdt() != null) {
            sql.VALUES("t_recommend_udt", "#{tRecommendUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettRecommendDelete() != null) {
            sql.VALUES("t_recommend_delete", "#{tRecommendDelete,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(RecommendCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("t_recommend_pkid");
        } else {
            sql.SELECT("t_recommend_pkid");
        }
        sql.SELECT("t_recommend_name");
        sql.SELECT("t_recommend_type");
        sql.SELECT("t_recommend_cdt");
        sql.SELECT("t_recommend_udt");
        sql.SELECT("t_recommend_delete");
        sql.FROM("t_recommend");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Recommend record = (Recommend) parameter.get("record");
        RecommendCriteria example = (RecommendCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_recommend");
        
        if (record.gettRecommendPkid() != null) {
            sql.SET("t_recommend_pkid = #{record.tRecommendPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettRecommendName() != null) {
            sql.SET("t_recommend_name = #{record.tRecommendName,jdbcType=VARCHAR}");
        }
        
        if (record.gettRecommendType() != null) {
            sql.SET("t_recommend_type = #{record.tRecommendType,jdbcType=INTEGER}");
        }
        
        if (record.gettRecommendCdt() != null) {
            sql.SET("t_recommend_cdt = #{record.tRecommendCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettRecommendUdt() != null) {
            sql.SET("t_recommend_udt = #{record.tRecommendUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettRecommendDelete() != null) {
            sql.SET("t_recommend_delete = #{record.tRecommendDelete,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_recommend");
        
        sql.SET("t_recommend_pkid = #{record.tRecommendPkid,jdbcType=INTEGER}");
        sql.SET("t_recommend_name = #{record.tRecommendName,jdbcType=VARCHAR}");
        sql.SET("t_recommend_type = #{record.tRecommendType,jdbcType=INTEGER}");
        sql.SET("t_recommend_cdt = #{record.tRecommendCdt,jdbcType=TIMESTAMP}");
        sql.SET("t_recommend_udt = #{record.tRecommendUdt,jdbcType=TIMESTAMP}");
        sql.SET("t_recommend_delete = #{record.tRecommendDelete,jdbcType=INTEGER}");
        
        RecommendCriteria example = (RecommendCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Recommend record) {
        SQL sql = new SQL();
        sql.UPDATE("t_recommend");
        
        if (record.gettRecommendName() != null) {
            sql.SET("t_recommend_name = #{tRecommendName,jdbcType=VARCHAR}");
        }
        
        if (record.gettRecommendType() != null) {
            sql.SET("t_recommend_type = #{tRecommendType,jdbcType=INTEGER}");
        }
        
        if (record.gettRecommendCdt() != null) {
            sql.SET("t_recommend_cdt = #{tRecommendCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettRecommendUdt() != null) {
            sql.SET("t_recommend_udt = #{tRecommendUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettRecommendDelete() != null) {
            sql.SET("t_recommend_delete = #{tRecommendDelete,jdbcType=INTEGER}");
        }
        
        sql.WHERE("t_recommend_pkid = #{tRecommendPkid,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, RecommendCriteria example, boolean includeExamplePhrase) {
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