package com.menu.wgf.mapper;

import com.menu.wgf.model.Shai;
import com.menu.wgf.model.ShaiCriteria.Criteria;
import com.menu.wgf.model.ShaiCriteria.Criterion;
import com.menu.wgf.model.ShaiCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ShaiSqlProvider {

    public String countByExample(ShaiCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_shai");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ShaiCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_shai");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Shai record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_shai");
        
        if (record.gettShaiUserPkid() != null) {
            sql.VALUES("t_shai_user_pkid", "#{tShaiUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettShaiPictureAddress() != null) {
            sql.VALUES("t_shai_picture_address", "#{tShaiPictureAddress,jdbcType=VARCHAR}");
        }
        
        if (record.gettShaiDesc() != null) {
            sql.VALUES("t_shai_desc", "#{tShaiDesc,jdbcType=VARCHAR}");
        }
        
        if (record.gettShaiCdt() != null) {
            sql.VALUES("t_shai_cdt", "#{tShaiCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettShaiUdt() != null) {
            sql.VALUES("t_shai_udt", "#{tShaiUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettShaiDelete() != null) {
            sql.VALUES("t_shai_delete", "#{tShaiDelete,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ShaiCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("t_shai_Pkid");
        } else {
            sql.SELECT("t_shai_Pkid");
        }
        sql.SELECT("t_shai_user_pkid");
        sql.SELECT("t_shai_picture_address");
        sql.SELECT("t_shai_desc");
        sql.SELECT("t_shai_cdt");
        sql.SELECT("t_shai_udt");
        sql.SELECT("t_shai_delete");
        sql.FROM("t_shai");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Shai record = (Shai) parameter.get("record");
        ShaiCriteria example = (ShaiCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_shai");
        
        if (record.gettShaiPkid() != null) {
            sql.SET("t_shai_Pkid = #{record.tShaiPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettShaiUserPkid() != null) {
            sql.SET("t_shai_user_pkid = #{record.tShaiUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettShaiPictureAddress() != null) {
            sql.SET("t_shai_picture_address = #{record.tShaiPictureAddress,jdbcType=VARCHAR}");
        }
        
        if (record.gettShaiDesc() != null) {
            sql.SET("t_shai_desc = #{record.tShaiDesc,jdbcType=VARCHAR}");
        }
        
        if (record.gettShaiCdt() != null) {
            sql.SET("t_shai_cdt = #{record.tShaiCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettShaiUdt() != null) {
            sql.SET("t_shai_udt = #{record.tShaiUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettShaiDelete() != null) {
            sql.SET("t_shai_delete = #{record.tShaiDelete,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_shai");
        
        sql.SET("t_shai_Pkid = #{record.tShaiPkid,jdbcType=INTEGER}");
        sql.SET("t_shai_user_pkid = #{record.tShaiUserPkid,jdbcType=INTEGER}");
        sql.SET("t_shai_picture_address = #{record.tShaiPictureAddress,jdbcType=VARCHAR}");
        sql.SET("t_shai_desc = #{record.tShaiDesc,jdbcType=VARCHAR}");
        sql.SET("t_shai_cdt = #{record.tShaiCdt,jdbcType=TIMESTAMP}");
        sql.SET("t_shai_udt = #{record.tShaiUdt,jdbcType=TIMESTAMP}");
        sql.SET("t_shai_delete = #{record.tShaiDelete,jdbcType=INTEGER}");
        
        ShaiCriteria example = (ShaiCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Shai record) {
        SQL sql = new SQL();
        sql.UPDATE("t_shai");
        
        if (record.gettShaiUserPkid() != null) {
            sql.SET("t_shai_user_pkid = #{tShaiUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettShaiPictureAddress() != null) {
            sql.SET("t_shai_picture_address = #{tShaiPictureAddress,jdbcType=VARCHAR}");
        }
        
        if (record.gettShaiDesc() != null) {
            sql.SET("t_shai_desc = #{tShaiDesc,jdbcType=VARCHAR}");
        }
        
        if (record.gettShaiCdt() != null) {
            sql.SET("t_shai_cdt = #{tShaiCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettShaiUdt() != null) {
            sql.SET("t_shai_udt = #{tShaiUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettShaiDelete() != null) {
            sql.SET("t_shai_delete = #{tShaiDelete,jdbcType=INTEGER}");
        }
        
        sql.WHERE("t_shai_Pkid = #{tShaiPkid,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ShaiCriteria example, boolean includeExamplePhrase) {
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