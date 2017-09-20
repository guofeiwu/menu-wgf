package com.menu.wgf.mapper;

import com.menu.wgf.model.Collect;
import com.menu.wgf.model.CollectCriteria.Criteria;
import com.menu.wgf.model.CollectCriteria.Criterion;
import com.menu.wgf.model.CollectCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CollectSqlProvider {

    public String countByExample(CollectCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_collect");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CollectCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_collect");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Collect record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_collect");
        
        if (record.gettCollectPkid() != null) {
            sql.VALUES("\"t_collect _pkid\"", "#{tCollectPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCollectUserPkid() != null) {
            sql.VALUES("\"t_collect_user _pkid\"", "#{tCollectUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCollectMenuPkid() != null) {
            sql.VALUES("\"t_ collect _menu_pkid\"", "#{tCollectMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCollectCdt() != null) {
            sql.VALUES("\"t_collect _cdt\"", "#{tCollectCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettCollectUdt() != null) {
            sql.VALUES("\"t_collect _udt\"", "#{tCollectUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettCollectCancel() != null) {
            sql.VALUES("\"t_collect _cancel\"", "#{tCollectCancel,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CollectCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("\"t_collect _pkid\"");
        } else {
            sql.SELECT("\"t_collect _pkid\"");
        }
        sql.SELECT("\"t_collect_user _pkid\"");
        sql.SELECT("\"t_ collect _menu_pkid\"");
        sql.SELECT("\"t_collect _cdt\"");
        sql.SELECT("\"t_collect _udt\"");
        sql.SELECT("\"t_collect _cancel\"");
        sql.FROM("t_collect");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Collect record = (Collect) parameter.get("record");
        CollectCriteria example = (CollectCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_collect");
        
        if (record.gettCollectPkid() != null) {
            sql.SET("\"t_collect _pkid\" = #{record.tCollectPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCollectUserPkid() != null) {
            sql.SET("\"t_collect_user _pkid\" = #{record.tCollectUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCollectMenuPkid() != null) {
            sql.SET("\"t_ collect _menu_pkid\" = #{record.tCollectMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCollectCdt() != null) {
            sql.SET("\"t_collect _cdt\" = #{record.tCollectCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettCollectUdt() != null) {
            sql.SET("\"t_collect _udt\" = #{record.tCollectUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettCollectCancel() != null) {
            sql.SET("\"t_collect _cancel\" = #{record.tCollectCancel,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_collect");
        
        sql.SET("\"t_collect _pkid\" = #{record.tCollectPkid,jdbcType=INTEGER}");
        sql.SET("\"t_collect_user _pkid\" = #{record.tCollectUserPkid,jdbcType=INTEGER}");
        sql.SET("\"t_ collect _menu_pkid\" = #{record.tCollectMenuPkid,jdbcType=INTEGER}");
        sql.SET("\"t_collect _cdt\" = #{record.tCollectCdt,jdbcType=TIMESTAMP}");
        sql.SET("\"t_collect _udt\" = #{record.tCollectUdt,jdbcType=TIMESTAMP}");
        sql.SET("\"t_collect _cancel\" = #{record.tCollectCancel,jdbcType=INTEGER}");
        
        CollectCriteria example = (CollectCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Collect record) {
        SQL sql = new SQL();
        sql.UPDATE("t_collect");
        
        if (record.gettCollectUserPkid() != null) {
            sql.SET("\"t_collect_user _pkid\" = #{tCollectUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCollectMenuPkid() != null) {
            sql.SET("\"t_ collect _menu_pkid\" = #{tCollectMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCollectCdt() != null) {
            sql.SET("\"t_collect _cdt\" = #{tCollectCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettCollectUdt() != null) {
            sql.SET("\"t_collect _udt\" = #{tCollectUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettCollectCancel() != null) {
            sql.SET("\"t_collect _cancel\" = #{tCollectCancel,jdbcType=INTEGER}");
        }
        
        sql.WHERE("\"t_collect _pkid\" = #{tCollectPkid,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CollectCriteria example, boolean includeExamplePhrase) {
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