package com.menu.wgf.mapper;

import com.menu.wgf.model.Comment;
import com.menu.wgf.model.CommentCriteria.Criteria;
import com.menu.wgf.model.CommentCriteria.Criterion;
import com.menu.wgf.model.CommentCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CommentSqlProvider {

    public String countByExample(CommentCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_comment");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CommentCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_comment");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Comment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_comment");
        
        if (record.gettCommentPkid() != null) {
            sql.VALUES("t_comment_pkid", "#{tCommentPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCommentUserPkid() != null) {
            sql.VALUES("t_comment_user_pkid", "#{tCommentUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCommentMenuPkid() != null) {
            sql.VALUES("t_comment_menu_pkid", "#{tCommentMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCommentContent() != null) {
            sql.VALUES("t_comment_content", "#{tCommentContent,jdbcType=VARCHAR}");
        }
        
        if (record.gettCommentCdt() != null) {
            sql.VALUES("t_comment_cdt", "#{tCommentCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettCommentUdt() != null) {
            sql.VALUES("t_comment_udt", "#{tCommentUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettCommentDelete() != null) {
            sql.VALUES("t_comment_delete", "#{tCommentDelete,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CommentCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("t_comment_pkid");
        } else {
            sql.SELECT("t_comment_pkid");
        }
        sql.SELECT("t_comment_user_pkid");
        sql.SELECT("t_comment_menu_pkid");
        sql.SELECT("t_comment_content");
        sql.SELECT("t_comment_cdt");
        sql.SELECT("t_comment_udt");
        sql.SELECT("t_comment_delete");
        sql.FROM("t_comment");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Comment record = (Comment) parameter.get("record");
        CommentCriteria example = (CommentCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_comment");
        
        if (record.gettCommentPkid() != null) {
            sql.SET("t_comment_pkid = #{record.tCommentPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCommentUserPkid() != null) {
            sql.SET("t_comment_user_pkid = #{record.tCommentUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCommentMenuPkid() != null) {
            sql.SET("t_comment_menu_pkid = #{record.tCommentMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCommentContent() != null) {
            sql.SET("t_comment_content = #{record.tCommentContent,jdbcType=VARCHAR}");
        }
        
        if (record.gettCommentCdt() != null) {
            sql.SET("t_comment_cdt = #{record.tCommentCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettCommentUdt() != null) {
            sql.SET("t_comment_udt = #{record.tCommentUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettCommentDelete() != null) {
            sql.SET("t_comment_delete = #{record.tCommentDelete,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_comment");
        
        sql.SET("t_comment_pkid = #{record.tCommentPkid,jdbcType=INTEGER}");
        sql.SET("t_comment_user_pkid = #{record.tCommentUserPkid,jdbcType=INTEGER}");
        sql.SET("t_comment_menu_pkid = #{record.tCommentMenuPkid,jdbcType=INTEGER}");
        sql.SET("t_comment_content = #{record.tCommentContent,jdbcType=VARCHAR}");
        sql.SET("t_comment_cdt = #{record.tCommentCdt,jdbcType=TIMESTAMP}");
        sql.SET("t_comment_udt = #{record.tCommentUdt,jdbcType=TIMESTAMP}");
        sql.SET("t_comment_delete = #{record.tCommentDelete,jdbcType=INTEGER}");
        
        CommentCriteria example = (CommentCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Comment record) {
        SQL sql = new SQL();
        sql.UPDATE("t_comment");
        
        if (record.gettCommentUserPkid() != null) {
            sql.SET("t_comment_user_pkid = #{tCommentUserPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCommentMenuPkid() != null) {
            sql.SET("t_comment_menu_pkid = #{tCommentMenuPkid,jdbcType=INTEGER}");
        }
        
        if (record.gettCommentContent() != null) {
            sql.SET("t_comment_content = #{tCommentContent,jdbcType=VARCHAR}");
        }
        
        if (record.gettCommentCdt() != null) {
            sql.SET("t_comment_cdt = #{tCommentCdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettCommentUdt() != null) {
            sql.SET("t_comment_udt = #{tCommentUdt,jdbcType=TIMESTAMP}");
        }
        
        if (record.gettCommentDelete() != null) {
            sql.SET("t_comment_delete = #{tCommentDelete,jdbcType=INTEGER}");
        }
        
        sql.WHERE("t_comment_pkid = #{tCommentPkid,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CommentCriteria example, boolean includeExamplePhrase) {
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