package com.menu.wgf.mapper;

import com.menu.wgf.model.Record;
import com.menu.wgf.model.RecordCriteria.Criteria;
import com.menu.wgf.model.RecordCriteria.Criterion;
import com.menu.wgf.model.RecordCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class RecordSqlProvider {

    public String countByExample(RecordCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_record");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(RecordCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_record");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Record record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_record");
        
        if (record.gettRecordPkid() != null) {
            sql.VALUES("t_record_pkid", "#{tRecordPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettRecordUserPkid() != null) {
            sql.VALUES("t_record_user_pkid", "#{tRecordUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettRecordMenuPkid() != null) {
            sql.VALUES("t_record_menu_pkid", "#{tRecordMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettRecordCdt() != null) {
            sql.VALUES("t_record_cdt", "#{tRecordCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettRecordUdt() != null) {
            sql.VALUES("t_record_udt", "#{tRecordUdt,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(RecordCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("t_record_pkid");
        } else {
            sql.SELECT("t_record_pkid");
        }
        sql.SELECT("t_record_user_pkid");
        sql.SELECT("t_record_menu_pkid");
        sql.SELECT("t_record_cdt");
        sql.SELECT("t_record_udt");
        sql.FROM("t_record");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Record record = (Record) parameter.get("record");
        RecordCriteria example = (RecordCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_record");
        
        if (record.gettRecordPkid() != null) {
            sql.SET("t_record_pkid = #{record.tRecordPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettRecordUserPkid() != null) {
            sql.SET("t_record_user_pkid = #{record.tRecordUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettRecordMenuPkid() != null) {
            sql.SET("t_record_menu_pkid = #{record.tRecordMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettRecordCdt() != null) {
            sql.SET("t_record_cdt = #{record.tRecordCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettRecordUdt() != null) {
            sql.SET("t_record_udt = #{record.tRecordUdt,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_record");
        
        sql.SET("t_record_pkid = #{record.tRecordPkid,jdbcType=INTEGER}");
        sql.SET("t_record_user_pkid = #{record.tRecordUserPkid,jdbcType=INTEGER}");
        sql.SET("t_record_menu_pkid = #{record.tRecordMenuPkid,jdbcType=INTEGER}");
        sql.SET("t_record_cdt = #{record.tRecordCdt,jdbcType=TIMESTAMP}");
        sql.SET("t_record_udt = #{record.tRecordUdt,jdbcType=TIMESTAMP}");
        
        RecordCriteria example = (RecordCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Record record) {
        SQL sql = new SQL();
        sql.UPDATE("t_record");
        
        if (record.gettRecordUserPkid() != null) {
            sql.SET("t_record_user_pkid = #{tRecordUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettRecordMenuPkid() != null) {
            sql.SET("t_record_menu_pkid = #{tRecordMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettRecordCdt() != null) {
            sql.SET("t_record_cdt = #{tRecordCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettRecordUdt() != null) {
            sql.SET("t_record_udt = #{tRecordUdt,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("t_record_pkid = #{tRecordPkid,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, RecordCriteria example, boolean includeExamplePhrase) {
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