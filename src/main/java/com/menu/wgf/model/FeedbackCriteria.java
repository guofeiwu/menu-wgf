package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeedbackCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeedbackCriteria() {
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

        public Criteria andTFeedbackPkidIsNull() {
            addCriterion("t_feedback_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTFeedbackPkidIsNotNull() {
            addCriterion("t_feedback_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTFeedbackPkidEqualTo(Integer value) {
            addCriterion("t_feedback_pkid =", value, "tFeedbackPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackPkidNotEqualTo(Integer value) {
            addCriterion("t_feedback_pkid <>", value, "tFeedbackPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackPkidGreaterThan(Integer value) {
            addCriterion("t_feedback_pkid >", value, "tFeedbackPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_feedback_pkid >=", value, "tFeedbackPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackPkidLessThan(Integer value) {
            addCriterion("t_feedback_pkid <", value, "tFeedbackPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_feedback_pkid <=", value, "tFeedbackPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackPkidIn(List<Integer> values) {
            addCriterion("t_feedback_pkid in", values, "tFeedbackPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackPkidNotIn(List<Integer> values) {
            addCriterion("t_feedback_pkid not in", values, "tFeedbackPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_feedback_pkid between", value1, value2, "tFeedbackPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_feedback_pkid not between", value1, value2, "tFeedbackPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUserPkidIsNull() {
            addCriterion("t_feedback_user_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUserPkidIsNotNull() {
            addCriterion("t_feedback_user_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUserPkidEqualTo(Integer value) {
            addCriterion("t_feedback_user_pkid =", value, "tFeedbackUserPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUserPkidNotEqualTo(Integer value) {
            addCriterion("t_feedback_user_pkid <>", value, "tFeedbackUserPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUserPkidGreaterThan(Integer value) {
            addCriterion("t_feedback_user_pkid >", value, "tFeedbackUserPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUserPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_feedback_user_pkid >=", value, "tFeedbackUserPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUserPkidLessThan(Integer value) {
            addCriterion("t_feedback_user_pkid <", value, "tFeedbackUserPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUserPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_feedback_user_pkid <=", value, "tFeedbackUserPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUserPkidIn(List<Integer> values) {
            addCriterion("t_feedback_user_pkid in", values, "tFeedbackUserPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUserPkidNotIn(List<Integer> values) {
            addCriterion("t_feedback_user_pkid not in", values, "tFeedbackUserPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUserPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_feedback_user_pkid between", value1, value2, "tFeedbackUserPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUserPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_feedback_user_pkid not between", value1, value2, "tFeedbackUserPkid");
            return (Criteria) this;
        }

        public Criteria andTFeedbackContentIsNull() {
            addCriterion("t_feedback_content is null");
            return (Criteria) this;
        }

        public Criteria andTFeedbackContentIsNotNull() {
            addCriterion("t_feedback_content is not null");
            return (Criteria) this;
        }

        public Criteria andTFeedbackContentEqualTo(String value) {
            addCriterion("t_feedback_content =", value, "tFeedbackContent");
            return (Criteria) this;
        }

        public Criteria andTFeedbackContentNotEqualTo(String value) {
            addCriterion("t_feedback_content <>", value, "tFeedbackContent");
            return (Criteria) this;
        }

        public Criteria andTFeedbackContentGreaterThan(String value) {
            addCriterion("t_feedback_content >", value, "tFeedbackContent");
            return (Criteria) this;
        }

        public Criteria andTFeedbackContentGreaterThanOrEqualTo(String value) {
            addCriterion("t_feedback_content >=", value, "tFeedbackContent");
            return (Criteria) this;
        }

        public Criteria andTFeedbackContentLessThan(String value) {
            addCriterion("t_feedback_content <", value, "tFeedbackContent");
            return (Criteria) this;
        }

        public Criteria andTFeedbackContentLessThanOrEqualTo(String value) {
            addCriterion("t_feedback_content <=", value, "tFeedbackContent");
            return (Criteria) this;
        }

        public Criteria andTFeedbackContentLike(String value) {
            addCriterion("t_feedback_content like", value, "tFeedbackContent");
            return (Criteria) this;
        }

        public Criteria andTFeedbackContentNotLike(String value) {
            addCriterion("t_feedback_content not like", value, "tFeedbackContent");
            return (Criteria) this;
        }

        public Criteria andTFeedbackContentIn(List<String> values) {
            addCriterion("t_feedback_content in", values, "tFeedbackContent");
            return (Criteria) this;
        }

        public Criteria andTFeedbackContentNotIn(List<String> values) {
            addCriterion("t_feedback_content not in", values, "tFeedbackContent");
            return (Criteria) this;
        }

        public Criteria andTFeedbackContentBetween(String value1, String value2) {
            addCriterion("t_feedback_content between", value1, value2, "tFeedbackContent");
            return (Criteria) this;
        }

        public Criteria andTFeedbackContentNotBetween(String value1, String value2) {
            addCriterion("t_feedback_content not between", value1, value2, "tFeedbackContent");
            return (Criteria) this;
        }

        public Criteria andTFeedbackCdtIsNull() {
            addCriterion("t_feedback_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTFeedbackCdtIsNotNull() {
            addCriterion("t_feedback_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTFeedbackCdtEqualTo(Date value) {
            addCriterion("t_feedback_cdt =", value, "tFeedbackCdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackCdtNotEqualTo(Date value) {
            addCriterion("t_feedback_cdt <>", value, "tFeedbackCdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackCdtGreaterThan(Date value) {
            addCriterion("t_feedback_cdt >", value, "tFeedbackCdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_feedback_cdt >=", value, "tFeedbackCdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackCdtLessThan(Date value) {
            addCriterion("t_feedback_cdt <", value, "tFeedbackCdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_feedback_cdt <=", value, "tFeedbackCdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackCdtIn(List<Date> values) {
            addCriterion("t_feedback_cdt in", values, "tFeedbackCdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackCdtNotIn(List<Date> values) {
            addCriterion("t_feedback_cdt not in", values, "tFeedbackCdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackCdtBetween(Date value1, Date value2) {
            addCriterion("t_feedback_cdt between", value1, value2, "tFeedbackCdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_feedback_cdt not between", value1, value2, "tFeedbackCdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUdtIsNull() {
            addCriterion("t_feedback_udt is null");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUdtIsNotNull() {
            addCriterion("t_feedback_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUdtEqualTo(Date value) {
            addCriterion("t_feedback_udt =", value, "tFeedbackUdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUdtNotEqualTo(Date value) {
            addCriterion("t_feedback_udt <>", value, "tFeedbackUdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUdtGreaterThan(Date value) {
            addCriterion("t_feedback_udt >", value, "tFeedbackUdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_feedback_udt >=", value, "tFeedbackUdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUdtLessThan(Date value) {
            addCriterion("t_feedback_udt <", value, "tFeedbackUdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_feedback_udt <=", value, "tFeedbackUdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUdtIn(List<Date> values) {
            addCriterion("t_feedback_udt in", values, "tFeedbackUdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUdtNotIn(List<Date> values) {
            addCriterion("t_feedback_udt not in", values, "tFeedbackUdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUdtBetween(Date value1, Date value2) {
            addCriterion("t_feedback_udt between", value1, value2, "tFeedbackUdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_feedback_udt not between", value1, value2, "tFeedbackUdt");
            return (Criteria) this;
        }

        public Criteria andTFeedbackDeleteIsNull() {
            addCriterion("t_feedback_delete is null");
            return (Criteria) this;
        }

        public Criteria andTFeedbackDeleteIsNotNull() {
            addCriterion("t_feedback_delete is not null");
            return (Criteria) this;
        }

        public Criteria andTFeedbackDeleteEqualTo(Integer value) {
            addCriterion("t_feedback_delete =", value, "tFeedbackDelete");
            return (Criteria) this;
        }

        public Criteria andTFeedbackDeleteNotEqualTo(Integer value) {
            addCriterion("t_feedback_delete <>", value, "tFeedbackDelete");
            return (Criteria) this;
        }

        public Criteria andTFeedbackDeleteGreaterThan(Integer value) {
            addCriterion("t_feedback_delete >", value, "tFeedbackDelete");
            return (Criteria) this;
        }

        public Criteria andTFeedbackDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_feedback_delete >=", value, "tFeedbackDelete");
            return (Criteria) this;
        }

        public Criteria andTFeedbackDeleteLessThan(Integer value) {
            addCriterion("t_feedback_delete <", value, "tFeedbackDelete");
            return (Criteria) this;
        }

        public Criteria andTFeedbackDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("t_feedback_delete <=", value, "tFeedbackDelete");
            return (Criteria) this;
        }

        public Criteria andTFeedbackDeleteIn(List<Integer> values) {
            addCriterion("t_feedback_delete in", values, "tFeedbackDelete");
            return (Criteria) this;
        }

        public Criteria andTFeedbackDeleteNotIn(List<Integer> values) {
            addCriterion("t_feedback_delete not in", values, "tFeedbackDelete");
            return (Criteria) this;
        }

        public Criteria andTFeedbackDeleteBetween(Integer value1, Integer value2) {
            addCriterion("t_feedback_delete between", value1, value2, "tFeedbackDelete");
            return (Criteria) this;
        }

        public Criteria andTFeedbackDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("t_feedback_delete not between", value1, value2, "tFeedbackDelete");
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