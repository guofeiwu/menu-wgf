package com.menu.wgf.mapper;

import com.menu.wgf.model.Material;
import com.menu.wgf.model.MaterialCriteria.Criteria;
import com.menu.wgf.model.MaterialCriteria.Criterion;
import com.menu.wgf.model.MaterialCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class MaterialSqlProvider {

    public String countByExample(MaterialCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_material");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(MaterialCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_material");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Material record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_material");
        
        if (record.gettMaterialPkid() != null) {
            sql.VALUES("t_material_pkid", "#{tMaterialPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettMaterialName() != null) {
            sql.VALUES("t_material_name", "#{tMaterialName,jdbcType=INTEGER}");
        }
        
        if (record.gettMaterialMenuPkid() != null) {
            sql.VALUES("t_material_menu_pkid", "#{tMaterialMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettMaterialCdt() != null) {
            sql.VALUES("t_material_cdt", "#{tMaterialCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettMaterialUdt() != null) {
            sql.VALUES("t_material_udt", "#{tMaterialUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettMaterialDelete() != null) {
            sql.VALUES("t_material_delete", "#{tMaterialDelete,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(MaterialCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("t_material_pkid");
        } else {
            sql.SELECT("t_material_pkid");
        }
        sql.SELECT("t_material_name");
        sql.SELECT("t_material_menu_pkid");
        sql.SELECT("t_material_cdt");
        sql.SELECT("t_material_udt");
        sql.SELECT("t_material_delete");
        sql.FROM("t_material");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Material record = (Material) parameter.get("record");
        MaterialCriteria example = (MaterialCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_material");
        
        if (record.gettMaterialPkid() != null) {
            sql.SET("t_material_pkid = #{record.tMaterialPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettMaterialName() != null) {
            sql.SET("t_material_name = #{record.tMaterialName,jdbcType=INTEGER}");
        }
        
        if (record.gettMaterialMenuPkid() != null) {
            sql.SET("t_material_menu_pkid = #{record.tMaterialMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettMaterialCdt() != null) {
            sql.SET("t_material_cdt = #{record.tMaterialCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettMaterialUdt() != null) {
            sql.SET("t_material_udt = #{record.tMaterialUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettMaterialDelete() != null) {
            sql.SET("t_material_delete = #{record.tMaterialDelete,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_material");
        
        sql.SET("t_material_pkid = #{record.tMaterialPkid,jdbcType=INTEGER}");
        sql.SET("t_material_name = #{record.tMaterialName,jdbcType=INTEGER}");
        sql.SET("t_material_menu_pkid = #{record.tMaterialMenuPkid,jdbcType=INTEGER}");
        sql.SET("t_material_cdt = #{record.tMaterialCdt,jdbcType=TIMESTAMP}");
        sql.SET("t_material_udt = #{record.tMaterialUdt,jdbcType=TIMESTAMP}");
        sql.SET("t_material_delete = #{record.tMaterialDelete,jdbcType=INTEGER}");
        
        MaterialCriteria example = (MaterialCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Material record) {
        SQL sql = new SQL();
        sql.UPDATE("t_material");
        
        if (record.gettMaterialName() != null) {
            sql.SET("t_material_name = #{tMaterialName,jdbcType=INTEGER}");
        }
        
        if (record.gettMaterialMenuPkid() != null) {
            sql.SET("t_material_menu_pkid = #{tMaterialMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettMaterialCdt() != null) {
            sql.SET("t_material_cdt = #{tMaterialCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettMaterialUdt() != null) {
            sql.SET("t_material_udt = #{tMaterialUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettMaterialDelete() != null) {
            sql.SET("t_material_delete = #{tMaterialDelete,jdbcType=INTEGER}");
        }
        
        sql.WHERE("t_material_pkid = #{tMaterialPkid,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, MaterialCriteria example, boolean includeExamplePhrase) {
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