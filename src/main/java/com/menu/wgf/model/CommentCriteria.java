package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTCommentPkidIsNull() {
            addCriterion("t_comment_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTCommentPkidIsNotNull() {
            addCriterion("t_comment_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTCommentPkidEqualTo(Integer value) {
            addCriterion("t_comment_pkid =", value, "tCommentPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentPkidNotEqualTo(Integer value) {
            addCriterion("t_comment_pkid <>", value, "tCommentPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentPkidGreaterThan(Integer value) {
            addCriterion("t_comment_pkid >", value, "tCommentPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_comment_pkid >=", value, "tCommentPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentPkidLessThan(Integer value) {
            addCriterion("t_comment_pkid <", value, "tCommentPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_comment_pkid <=", value, "tCommentPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentPkidIn(List<Integer> values) {
            addCriterion("t_comment_pkid in", values, "tCommentPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentPkidNotIn(List<Integer> values) {
            addCriterion("t_comment_pkid not in", values, "tCommentPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_comment_pkid between", value1, value2, "tCommentPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_comment_pkid not between", value1, value2, "tCommentPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentUserPkidIsNull() {
            addCriterion("t_comment_user_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTCommentUserPkidIsNotNull() {
            addCriterion("t_comment_user_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTCommentUserPkidEqualTo(Integer value) {
            addCriterion("t_comment_user_pkid =", value, "tCommentUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentUserPkidNotEqualTo(Integer value) {
            addCriterion("t_comment_user_pkid <>", value, "tCommentUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentUserPkidGreaterThan(Integer value) {
            addCriterion("t_comment_user_pkid >", value, "tCommentUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentUserPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_comment_user_pkid >=", value, "tCommentUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentUserPkidLessThan(Integer value) {
            addCriterion("t_comment_user_pkid <", value, "tCommentUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentUserPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_comment_user_pkid <=", value, "tCommentUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentUserPkidIn(List<Integer> values) {
            addCriterion("t_comment_user_pkid in", values, "tCommentUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentUserPkidNotIn(List<Integer> values) {
            addCriterion("t_comment_user_pkid not in", values, "tCommentUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentUserPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_comment_user_pkid between", value1, value2, "tCommentUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentUserPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_comment_user_pkid not between", value1, value2, "tCommentUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentMenuPkidIsNull() {
            addCriterion("t_comment_menu_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTCommentMenuPkidIsNotNull() {
            addCriterion("t_comment_menu_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTCommentMenuPkidEqualTo(Integer value) {
            addCriterion("t_comment_menu_pkid =", value, "tCommentMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentMenuPkidNotEqualTo(Integer value) {
            addCriterion("t_comment_menu_pkid <>", value, "tCommentMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentMenuPkidGreaterThan(Integer value) {
            addCriterion("t_comment_menu_pkid >", value, "tCommentMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentMenuPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_comment_menu_pkid >=", value, "tCommentMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentMenuPkidLessThan(Integer value) {
            addCriterion("t_comment_menu_pkid <", value, "tCommentMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentMenuPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_comment_menu_pkid <=", value, "tCommentMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentMenuPkidIn(List<Integer> values) {
            addCriterion("t_comment_menu_pkid in", values, "tCommentMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentMenuPkidNotIn(List<Integer> values) {
            addCriterion("t_comment_menu_pkid not in", values, "tCommentMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentMenuPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_comment_menu_pkid between", value1, value2, "tCommentMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentMenuPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_comment_menu_pkid not between", value1, value2, "tCommentMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentShaiPkidIsNull() {
            addCriterion("t_comment_shai_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTCommentShaiPkidIsNotNull() {
            addCriterion("t_comment_shai_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTCommentShaiPkidEqualTo(Integer value) {
            addCriterion("t_comment_shai_pkid =", value, "tCommentShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentShaiPkidNotEqualTo(Integer value) {
            addCriterion("t_comment_shai_pkid <>", value, "tCommentShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentShaiPkidGreaterThan(Integer value) {
            addCriterion("t_comment_shai_pkid >", value, "tCommentShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentShaiPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_comment_shai_pkid >=", value, "tCommentShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentShaiPkidLessThan(Integer value) {
            addCriterion("t_comment_shai_pkid <", value, "tCommentShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentShaiPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_comment_shai_pkid <=", value, "tCommentShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentShaiPkidIn(List<Integer> values) {
            addCriterion("t_comment_shai_pkid in", values, "tCommentShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentShaiPkidNotIn(List<Integer> values) {
            addCriterion("t_comment_shai_pkid not in", values, "tCommentShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentShaiPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_comment_shai_pkid between", value1, value2, "tCommentShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentShaiPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_comment_shai_pkid not between", value1, value2, "tCommentShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTCommentContentIsNull() {
            addCriterion("t_comment_content is null");
            return (Criteria) this;
        }

        public Criteria andTCommentContentIsNotNull() {
            addCriterion("t_comment_content is not null");
            return (Criteria) this;
        }

        public Criteria andTCommentContentEqualTo(String value) {
            addCriterion("t_comment_content =", value, "tCommentContent");
            return (Criteria) this;
        }

        public Criteria andTCommentContentNotEqualTo(String value) {
            addCriterion("t_comment_content <>", value, "tCommentContent");
            return (Criteria) this;
        }

        public Criteria andTCommentContentGreaterThan(String value) {
            addCriterion("t_comment_content >", value, "tCommentContent");
            return (Criteria) this;
        }

        public Criteria andTCommentContentGreaterThanOrEqualTo(String value) {
            addCriterion("t_comment_content >=", value, "tCommentContent");
            return (Criteria) this;
        }

        public Criteria andTCommentContentLessThan(String value) {
            addCriterion("t_comment_content <", value, "tCommentContent");
            return (Criteria) this;
        }

        public Criteria andTCommentContentLessThanOrEqualTo(String value) {
            addCriterion("t_comment_content <=", value, "tCommentContent");
            return (Criteria) this;
        }

        public Criteria andTCommentContentLike(String value) {
            addCriterion("t_comment_content like", value, "tCommentContent");
            return (Criteria) this;
        }

        public Criteria andTCommentContentNotLike(String value) {
            addCriterion("t_comment_content not like", value, "tCommentContent");
            return (Criteria) this;
        }

        public Criteria andTCommentContentIn(List<String> values) {
            addCriterion("t_comment_content in", values, "tCommentContent");
            return (Criteria) this;
        }

        public Criteria andTCommentContentNotIn(List<String> values) {
            addCriterion("t_comment_content not in", values, "tCommentContent");
            return (Criteria) this;
        }

        public Criteria andTCommentContentBetween(String value1, String value2) {
            addCriterion("t_comment_content between", value1, value2, "tCommentContent");
            return (Criteria) this;
        }

        public Criteria andTCommentContentNotBetween(String value1, String value2) {
            addCriterion("t_comment_content not between", value1, value2, "tCommentContent");
            return (Criteria) this;
        }

        public Criteria andTCommentCdtIsNull() {
            addCriterion("t_comment_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTCommentCdtIsNotNull() {
            addCriterion("t_comment_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTCommentCdtEqualTo(Date value) {
            addCriterion("t_comment_cdt =", value, "tCommentCdt");
            return (Criteria) this;
        }

        public Criteria andTCommentCdtNotEqualTo(Date value) {
            addCriterion("t_comment_cdt <>", value, "tCommentCdt");
            return (Criteria) this;
        }

        public Criteria andTCommentCdtGreaterThan(Date value) {
            addCriterion("t_comment_cdt >", value, "tCommentCdt");
            return (Criteria) this;
        }

        public Criteria andTCommentCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_comment_cdt >=", value, "tCommentCdt");
            return (Criteria) this;
        }

        public Criteria andTCommentCdtLessThan(Date value) {
            addCriterion("t_comment_cdt <", value, "tCommentCdt");
            return (Criteria) this;
        }

        public Criteria andTCommentCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_comment_cdt <=", value, "tCommentCdt");
            return (Criteria) this;
        }

        public Criteria andTCommentCdtIn(List<Date> values) {
            addCriterion("t_comment_cdt in", values, "tCommentCdt");
            return (Criteria) this;
        }

        public Criteria andTCommentCdtNotIn(List<Date> values) {
            addCriterion("t_comment_cdt not in", values, "tCommentCdt");
            return (Criteria) this;
        }

        public Criteria andTCommentCdtBetween(Date value1, Date value2) {
            addCriterion("t_comment_cdt between", value1, value2, "tCommentCdt");
            return (Criteria) this;
        }

        public Criteria andTCommentCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_comment_cdt not between", value1, value2, "tCommentCdt");
            return (Criteria) this;
        }

        public Criteria andTCommentUdtIsNull() {
            addCriterion("t_comment_udt is null");
            return (Criteria) this;
        }

        public Criteria andTCommentUdtIsNotNull() {
            addCriterion("t_comment_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTCommentUdtEqualTo(Date value) {
            addCriterion("t_comment_udt =", value, "tCommentUdt");
            return (Criteria) this;
        }

        public Criteria andTCommentUdtNotEqualTo(Date value) {
            addCriterion("t_comment_udt <>", value, "tCommentUdt");
            return (Criteria) this;
        }

        public Criteria andTCommentUdtGreaterThan(Date value) {
            addCriterion("t_comment_udt >", value, "tCommentUdt");
            return (Criteria) this;
        }

        public Criteria andTCommentUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_comment_udt >=", value, "tCommentUdt");
            return (Criteria) this;
        }

        public Criteria andTCommentUdtLessThan(Date value) {
            addCriterion("t_comment_udt <", value, "tCommentUdt");
            return (Criteria) this;
        }

        public Criteria andTCommentUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_comment_udt <=", value, "tCommentUdt");
            return (Criteria) this;
        }

        public Criteria andTCommentUdtIn(List<Date> values) {
            addCriterion("t_comment_udt in", values, "tCommentUdt");
            return (Criteria) this;
        }

        public Criteria andTCommentUdtNotIn(List<Date> values) {
            addCriterion("t_comment_udt not in", values, "tCommentUdt");
            return (Criteria) this;
        }

        public Criteria andTCommentUdtBetween(Date value1, Date value2) {
            addCriterion("t_comment_udt between", value1, value2, "tCommentUdt");
            return (Criteria) this;
        }

        public Criteria andTCommentUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_comment_udt not between", value1, value2, "tCommentUdt");
            return (Criteria) this;
        }

        public Criteria andTCommentDeleteIsNull() {
            addCriterion("t_comment_delete is null");
            return (Criteria) this;
        }

        public Criteria andTCommentDeleteIsNotNull() {
            addCriterion("t_comment_delete is not null");
            return (Criteria) this;
        }

        public Criteria andTCommentDeleteEqualTo(Integer value) {
            addCriterion("t_comment_delete =", value, "tCommentDelete");
            return (Criteria) this;
        }

        public Criteria andTCommentDeleteNotEqualTo(Integer value) {
            addCriterion("t_comment_delete <>", value, "tCommentDelete");
            return (Criteria) this;
        }

        public Criteria andTCommentDeleteGreaterThan(Integer value) {
            addCriterion("t_comment_delete >", value, "tCommentDelete");
            return (Criteria) this;
        }

        public Criteria andTCommentDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_comment_delete >=", value, "tCommentDelete");
            return (Criteria) this;
        }

        public Criteria andTCommentDeleteLessThan(Integer value) {
            addCriterion("t_comment_delete <", value, "tCommentDelete");
            return (Criteria) this;
        }

        public Criteria andTCommentDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("t_comment_delete <=", value, "tCommentDelete");
            return (Criteria) this;
        }

        public Criteria andTCommentDeleteIn(List<Integer> values) {
            addCriterion("t_comment_delete in", values, "tCommentDelete");
            return (Criteria) this;
        }

        public Criteria andTCommentDeleteNotIn(List<Integer> values) {
            addCriterion("t_comment_delete not in", values, "tCommentDelete");
            return (Criteria) this;
        }

        public Criteria andTCommentDeleteBetween(Integer value1, Integer value2) {
            addCriterion("t_comment_delete between", value1, value2, "tCommentDelete");
            return (Criteria) this;
        }

        public Criteria andTCommentDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("t_comment_delete not between", value1, value2, "tCommentDelete");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}