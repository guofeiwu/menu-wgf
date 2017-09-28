package com.menu.wgf.mapper;

import com.menu.wgf.model.Menu;
import com.menu.wgf.model.MenuCriteria.Criteria;
import com.menu.wgf.model.MenuCriteria.Criterion;
import com.menu.wgf.model.MenuCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class MenuSqlProvider {

    public String countByExample(MenuCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_menu");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(MenuCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_menu");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Menu record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_menu");
        
        if (record.gettMenuName() != null) {
            sql.VALUES("t_menu_name", "#{tMenuName,jdbcType=VARCHAR}");
        }
        
        if (record.gettMenuDescription() != null) {
            sql.VALUES("t_menu_description", "#{tMenuDescription,jdbcType=VARCHAR}");
        }
        
        if (record.gettMenuUserPkid() != null) {
            sql.VALUES("t_menu_user_pkid", "#{tMenuUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettMenuType() != null) {
            sql.VALUES("t_menu_type", "#{tMenuType,jdbcType=INTEGER}");
        }
        
        if (record.gettMenuDelete() != null) {
            sql.VALUES("t_menu_delete", "#{tMenuDelete,jdbcType=INTEGER}");
        }
        
        if (record.gettMenuUdt() != null) {
            sql.VALUES("t_menu_udt", "#{tMenuUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettMenuCdt() != null) {
            sql.VALUES("t_menu_cdt", "#{tMenuCdt,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(MenuCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("t_menu_pkid");
        } else {
            sql.SELECT("t_menu_pkid");
        }
        sql.SELECT("t_menu_name");
        sql.SELECT("t_menu_description");
        sql.SELECT("t_menu_user_pkid");
        sql.SELECT("t_menu_type");
        sql.SELECT("t_menu_delete");
        sql.SELECT("t_menu_udt");
        sql.SELECT("t_menu_cdt");
        sql.FROM("t_menu");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Menu record = (Menu) parameter.get("record");
        MenuCriteria example = (MenuCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_menu");
        
        if (record.gettMenuPkid() != null) {
            sql.SET("t_menu_pkid = #{record.tMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettMenuName() != null) {
            sql.SET("t_menu_name = #{record.tMenuName,jdbcType=VARCHAR}");
        }
        
        if (record.gettMenuDescription() != null) {
            sql.SET("t_menu_description = #{record.tMenuDescription,jdbcType=VARCHAR}");
        }
        
        if (record.gettMenuUserPkid() != null) {
            sql.SET("t_menu_user_pkid = #{record.tMenuUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettMenuType() != null) {
            sql.SET("t_menu_type = #{record.tMenuType,jdbcType=INTEGER}");
        }
        
        if (record.gettMenuDelete() != null) {
            sql.SET("t_menu_delete = #{record.tMenuDelete,jdbcType=INTEGER}");
        }
        
        if (record.gettMenuUdt() != null) {
            sql.SET("t_menu_udt = #{record.tMenuUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettMenuCdt() != null) {
            sql.SET("t_menu_cdt = #{record.tMenuCdt,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_menu");
        
        sql.SET("t_menu_pkid = #{record.tMenuPkid,jdbcType=INTEGER}");
        sql.SET("t_menu_name = #{record.tMenuName,jdbcType=VARCHAR}");
        sql.SET("t_menu_description = #{record.tMenuDescription,jdbcType=VARCHAR}");
        sql.SET("t_menu_user_pkid = #{record.tMenuUserPkid,jdbcType=INTEGER}");
        sql.SET("t_menu_type = #{record.tMenuType,jdbcType=INTEGER}");
        sql.SET("t_menu_delete = #{record.tMenuDelete,jdbcType=INTEGER}");
        sql.SET("t_menu_udt = #{record.tMenuUdt,jdbcType=TIMESTAMP}");
        sql.SET("t_menu_cdt = #{record.tMenuCdt,jdbcType=TIMESTAMP}");
        
        MenuCriteria example = (MenuCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Menu record) {
        SQL sql = new SQL();
        sql.UPDATE("t_menu");
        
        if (record.gettMenuName() != null) {
            sql.SET("t_menu_name = #{tMenuName,jdbcType=VARCHAR}");
        }
        
        if (record.gettMenuDescription() != null) {
            sql.SET("t_menu_description = #{tMenuDescription,jdbcType=VARCHAR}");
        }
        
        if (record.gettMenuUserPkid() != null) {
            sql.SET("t_menu_user_pkid = #{tMenuUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettMenuType() != null) {
            sql.SET("t_menu_type = #{tMenuType,jdbcType=INTEGER}");
        }
        
        if (record.gettMenuDelete() != null) {
            sql.SET("t_menu_delete = #{tMenuDelete,jdbcType=INTEGER}");
        }
        
        if (record.gettMenuUdt() != null) {
            sql.SET("t_menu_udt = #{tMenuUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettMenuCdt() != null) {
            sql.SET("t_menu_cdt = #{tMenuCdt,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("t_menu_pkid = #{tMenuPkid,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, MenuCriteria example, boolean includeExamplePhrase) {
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