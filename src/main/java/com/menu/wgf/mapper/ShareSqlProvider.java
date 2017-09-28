package com.menu.wgf.mapper;

import com.menu.wgf.model.Share;
import com.menu.wgf.model.ShareCriteria.Criteria;
import com.menu.wgf.model.ShareCriteria.Criterion;
import com.menu.wgf.model.ShareCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ShareSqlProvider {

    public String countByExample(ShareCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_share");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ShareCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_share");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Share record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_share");
        
        if (record.gettShareUserPkid() != null) {
            sql.VALUES("t_share_user_pkid", "#{tShareUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettShareMenuPkid() != null) {
            sql.VALUES("t_share_menu_pkid", "#{tShareMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettShareCdt() != null) {
            sql.VALUES("t_share_cdt", "#{tShareCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettShareUdt() != null) {
            sql.VALUES("t_share_udt", "#{tShareUdt,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ShareCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("t_share_pkid");
        } else {
            sql.SELECT("t_share_pkid");
        }
        sql.SELECT("t_share_user_pkid");
        sql.SELECT("t_share_menu_pkid");
        sql.SELECT("t_share_cdt");
        sql.SELECT("t_share_udt");
        sql.FROM("t_share");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Share record = (Share) parameter.get("record");
        ShareCriteria example = (ShareCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_share");
        
        if (record.gettSharePkid() != null) {
            sql.SET("t_share_pkid = #{record.tSharePkid,jdbcType=INTEGER}");
        }
        
        if (record.gettShareUserPkid() != null) {
            sql.SET("t_share_user_pkid = #{record.tShareUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettShareMenuPkid() != null) {
            sql.SET("t_share_menu_pkid = #{record.tShareMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettShareCdt() != null) {
            sql.SET("t_share_cdt = #{record.tShareCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettShareUdt() != null) {
            sql.SET("t_share_udt = #{record.tShareUdt,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_share");
        
        sql.SET("t_share_pkid = #{record.tSharePkid,jdbcType=INTEGER}");
        sql.SET("t_share_user_pkid = #{record.tShareUserPkid,jdbcType=INTEGER}");
        sql.SET("t_share_menu_pkid = #{record.tShareMenuPkid,jdbcType=INTEGER}");
        sql.SET("t_share_cdt = #{record.tShareCdt,jdbcType=TIMESTAMP}");
        sql.SET("t_share_udt = #{record.tShareUdt,jdbcType=TIMESTAMP}");
        
        ShareCriteria example = (ShareCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Share record) {
        SQL sql = new SQL();
        sql.UPDATE("t_share");
        
        if (record.gettShareUserPkid() != null) {
            sql.SET("t_share_user_pkid = #{tShareUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettShareMenuPkid() != null) {
            sql.SET("t_share_menu_pkid = #{tShareMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettShareCdt() != null) {
            sql.SET("t_share_cdt = #{tShareCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettShareUdt() != null) {
            sql.SET("t_share_udt = #{tShareUdt,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("t_share_pkid = #{tSharePkid,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ShareCriteria example, boolean includeExamplePhrase) {
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