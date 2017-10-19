package com.menu.wgf.mapper;

import com.menu.wgf.model.AppInfo;
import com.menu.wgf.model.AppInfoCriteria.Criteria;
import com.menu.wgf.model.AppInfoCriteria.Criterion;
import com.menu.wgf.model.AppInfoCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class AppInfoSqlProvider {

    public String countByExample(AppInfoCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_app");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(AppInfoCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_app");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(AppInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_app");
        
        if (record.gettAppVer() != null) {
            sql.VALUES("t_app_ver", "#{tAppVer,jdbcType=REAL}");
        }
        
        if (record.gettAppDownloadUrl() != null) {
            sql.VALUES("t_app_download_url", "#{tAppDownloadUrl,jdbcType=VARCHAR}");
        }
        
        if (record.gettAppVerDesc() != null) {
            sql.VALUES("t_app_ver_desc", "#{tAppVerDesc,jdbcType=VARCHAR}");
        }
        
        if (record.gettAppCdt() != null) {
            sql.VALUES("t_app_cdt", "#{tAppCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettAppUdt() != null) {
            sql.VALUES("t_app_udt", "#{tAppUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettAppDelete() != null) {
            sql.VALUES("t_app_delete", "#{tAppDelete,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(AppInfoCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("t_app_pkid");
        } else {
            sql.SELECT("t_app_pkid");
        }
        sql.SELECT("t_app_ver");
        sql.SELECT("t_app_download_url");
        sql.SELECT("t_app_ver_desc");
        sql.SELECT("t_app_cdt");
        sql.SELECT("t_app_udt");
        sql.SELECT("t_app_delete");
        sql.FROM("t_app");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        AppInfo record = (AppInfo) parameter.get("record");
        AppInfoCriteria example = (AppInfoCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_app");
        
        if (record.gettAppPkid() != null) {
            sql.SET("t_app_pkid = #{record.tAppPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettAppVer() != null) {
            sql.SET("t_app_ver = #{record.tAppVer,jdbcType=REAL}");
        }
        
        if (record.gettAppDownloadUrl() != null) {
            sql.SET("t_app_download_url = #{record.tAppDownloadUrl,jdbcType=VARCHAR}");
        }
        
        if (record.gettAppVerDesc() != null) {
            sql.SET("t_app_ver_desc = #{record.tAppVerDesc,jdbcType=VARCHAR}");
        }
        
        if (record.gettAppCdt() != null) {
            sql.SET("t_app_cdt = #{record.tAppCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettAppUdt() != null) {
            sql.SET("t_app_udt = #{record.tAppUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettAppDelete() != null) {
            sql.SET("t_app_delete = #{record.tAppDelete,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_app");
        
        sql.SET("t_app_pkid = #{record.tAppPkid,jdbcType=INTEGER}");
        sql.SET("t_app_ver = #{record.tAppVer,jdbcType=REAL}");
        sql.SET("t_app_download_url = #{record.tAppDownloadUrl,jdbcType=VARCHAR}");
        sql.SET("t_app_ver_desc = #{record.tAppVerDesc,jdbcType=VARCHAR}");
        sql.SET("t_app_cdt = #{record.tAppCdt,jdbcType=TIMESTAMP}");
        sql.SET("t_app_udt = #{record.tAppUdt,jdbcType=TIMESTAMP}");
        sql.SET("t_app_delete = #{record.tAppDelete,jdbcType=INTEGER}");
        
        AppInfoCriteria example = (AppInfoCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AppInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("t_app");
        
        if (record.gettAppVer() != null) {
            sql.SET("t_app_ver = #{tAppVer,jdbcType=REAL}");
        }
        
        if (record.gettAppDownloadUrl() != null) {
            sql.SET("t_app_download_url = #{tAppDownloadUrl,jdbcType=VARCHAR}");
        }
        
        if (record.gettAppVerDesc() != null) {
            sql.SET("t_app_ver_desc = #{tAppVerDesc,jdbcType=VARCHAR}");
        }
        
        if (record.gettAppCdt() != null) {
            sql.SET("t_app_cdt = #{tAppCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettAppUdt() != null) {
            sql.SET("t_app_udt = #{tAppUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettAppDelete() != null) {
            sql.SET("t_app_delete = #{tAppDelete,jdbcType=INTEGER}");
        }
        
        sql.WHERE("t_app_pkid = #{tAppPkid,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, AppInfoCriteria example, boolean includeExamplePhrase) {
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