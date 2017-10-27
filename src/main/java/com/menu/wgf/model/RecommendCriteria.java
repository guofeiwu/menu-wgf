package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecommendCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecommendCriteria() {
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

        public Criteria andTRecommendPkidIsNull() {
            addCriterion("t_recommend_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTRecommendPkidIsNotNull() {
            addCriterion("t_recommend_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTRecommendPkidEqualTo(Integer value) {
            addCriterion("t_recommend_pkid =", value, "tRecommendPkid");
            return (Criteria) this;
        }

        public Criteria andTRecommendPkidNotEqualTo(Integer value) {
            addCriterion("t_recommend_pkid <>", value, "tRecommendPkid");
            return (Criteria) this;
        }

        public Criteria andTRecommendPkidGreaterThan(Integer value) {
            addCriterion("t_recommend_pkid >", value, "tRecommendPkid");
            return (Criteria) this;
        }

        public Criteria andTRecommendPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_recommend_pkid >=", value, "tRecommendPkid");
            return (Criteria) this;
        }

        public Criteria andTRecommendPkidLessThan(Integer value) {
            addCriterion("t_recommend_pkid <", value, "tRecommendPkid");
            return (Criteria) this;
        }

        public Criteria andTRecommendPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_recommend_pkid <=", value, "tRecommendPkid");
            return (Criteria) this;
        }

        public Criteria andTRecommendPkidIn(List<Integer> values) {
            addCriterion("t_recommend_pkid in", values, "tRecommendPkid");
            return (Criteria) this;
        }

        public Criteria andTRecommendPkidNotIn(List<Integer> values) {
            addCriterion("t_recommend_pkid not in", values, "tRecommendPkid");
            return (Criteria) this;
        }

        public Criteria andTRecommendPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_recommend_pkid between", value1, value2, "tRecommendPkid");
            return (Criteria) this;
        }

        public Criteria andTRecommendPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_recommend_pkid not between", value1, value2, "tRecommendPkid");
            return (Criteria) this;
        }

        public Criteria andTRecommendNameIsNull() {
            addCriterion("t_recommend_name is null");
            return (Criteria) this;
        }

        public Criteria andTRecommendNameIsNotNull() {
            addCriterion("t_recommend_name is not null");
            return (Criteria) this;
        }

        public Criteria andTRecommendNameEqualTo(String value) {
            addCriterion("t_recommend_name =", value, "tRecommendName");
            return (Criteria) this;
        }

        public Criteria andTRecommendNameNotEqualTo(String value) {
            addCriterion("t_recommend_name <>", value, "tRecommendName");
            return (Criteria) this;
        }

        public Criteria andTRecommendNameGreaterThan(String value) {
            addCriterion("t_recommend_name >", value, "tRecommendName");
            return (Criteria) this;
        }

        public Criteria andTRecommendNameGreaterThanOrEqualTo(String value) {
            addCriterion("t_recommend_name >=", value, "tRecommendName");
            return (Criteria) this;
        }

        public Criteria andTRecommendNameLessThan(String value) {
            addCriterion("t_recommend_name <", value, "tRecommendName");
            return (Criteria) this;
        }

        public Criteria andTRecommendNameLessThanOrEqualTo(String value) {
            addCriterion("t_recommend_name <=", value, "tRecommendName");
            return (Criteria) this;
        }

        public Criteria andTRecommendNameLike(String value) {
            addCriterion("t_recommend_name like", value, "tRecommendName");
            return (Criteria) this;
        }

        public Criteria andTRecommendNameNotLike(String value) {
            addCriterion("t_recommend_name not like", value, "tRecommendName");
            return (Criteria) this;
        }

        public Criteria andTRecommendNameIn(List<String> values) {
            addCriterion("t_recommend_name in", values, "tRecommendName");
            return (Criteria) this;
        }

        public Criteria andTRecommendNameNotIn(List<String> values) {
            addCriterion("t_recommend_name not in", values, "tRecommendName");
            return (Criteria) this;
        }

        public Criteria andTRecommendNameBetween(String value1, String value2) {
            addCriterion("t_recommend_name between", value1, value2, "tRecommendName");
            return (Criteria) this;
        }

        public Criteria andTRecommendNameNotBetween(String value1, String value2) {
            addCriterion("t_recommend_name not between", value1, value2, "tRecommendName");
            return (Criteria) this;
        }

        public Criteria andTRecommendTypeIsNull() {
            addCriterion("t_recommend_type is null");
            return (Criteria) this;
        }

        public Criteria andTRecommendTypeIsNotNull() {
            addCriterion("t_recommend_type is not null");
            return (Criteria) this;
        }

        public Criteria andTRecommendTypeEqualTo(Integer value) {
            addCriterion("t_recommend_type =", value, "tRecommendType");
            return (Criteria) this;
        }

        public Criteria andTRecommendTypeNotEqualTo(Integer value) {
            addCriterion("t_recommend_type <>", value, "tRecommendType");
            return (Criteria) this;
        }

        public Criteria andTRecommendTypeGreaterThan(Integer value) {
            addCriterion("t_recommend_type >", value, "tRecommendType");
            return (Criteria) this;
        }

        public Criteria andTRecommendTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_recommend_type >=", value, "tRecommendType");
            return (Criteria) this;
        }

        public Criteria andTRecommendTypeLessThan(Integer value) {
            addCriterion("t_recommend_type <", value, "tRecommendType");
            return (Criteria) this;
        }

        public Criteria andTRecommendTypeLessThanOrEqualTo(Integer value) {
            addCriterion("t_recommend_type <=", value, "tRecommendType");
            return (Criteria) this;
        }

        public Criteria andTRecommendTypeIn(List<Integer> values) {
            addCriterion("t_recommend_type in", values, "tRecommendType");
            return (Criteria) this;
        }

        public Criteria andTRecommendTypeNotIn(List<Integer> values) {
            addCriterion("t_recommend_type not in", values, "tRecommendType");
            return (Criteria) this;
        }

        public Criteria andTRecommendTypeBetween(Integer value1, Integer value2) {
            addCriterion("t_recommend_type between", value1, value2, "tRecommendType");
            return (Criteria) this;
        }

        public Criteria andTRecommendTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("t_recommend_type not between", value1, value2, "tRecommendType");
            return (Criteria) this;
        }

        public Criteria andTRecommendCdtIsNull() {
            addCriterion("t_recommend_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTRecommendCdtIsNotNull() {
            addCriterion("t_recommend_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTRecommendCdtEqualTo(Date value) {
            addCriterion("t_recommend_cdt =", value, "tRecommendCdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendCdtNotEqualTo(Date value) {
            addCriterion("t_recommend_cdt <>", value, "tRecommendCdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendCdtGreaterThan(Date value) {
            addCriterion("t_recommend_cdt >", value, "tRecommendCdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_recommend_cdt >=", value, "tRecommendCdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendCdtLessThan(Date value) {
            addCriterion("t_recommend_cdt <", value, "tRecommendCdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_recommend_cdt <=", value, "tRecommendCdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendCdtIn(List<Date> values) {
            addCriterion("t_recommend_cdt in", values, "tRecommendCdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendCdtNotIn(List<Date> values) {
            addCriterion("t_recommend_cdt not in", values, "tRecommendCdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendCdtBetween(Date value1, Date value2) {
            addCriterion("t_recommend_cdt between", value1, value2, "tRecommendCdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_recommend_cdt not between", value1, value2, "tRecommendCdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendUdtIsNull() {
            addCriterion("t_recommend_udt is null");
            return (Criteria) this;
        }

        public Criteria andTRecommendUdtIsNotNull() {
            addCriterion("t_recommend_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTRecommendUdtEqualTo(Date value) {
            addCriterion("t_recommend_udt =", value, "tRecommendUdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendUdtNotEqualTo(Date value) {
            addCriterion("t_recommend_udt <>", value, "tRecommendUdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendUdtGreaterThan(Date value) {
            addCriterion("t_recommend_udt >", value, "tRecommendUdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_recommend_udt >=", value, "tRecommendUdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendUdtLessThan(Date value) {
            addCriterion("t_recommend_udt <", value, "tRecommendUdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_recommend_udt <=", value, "tRecommendUdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendUdtIn(List<Date> values) {
            addCriterion("t_recommend_udt in", values, "tRecommendUdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendUdtNotIn(List<Date> values) {
            addCriterion("t_recommend_udt not in", values, "tRecommendUdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendUdtBetween(Date value1, Date value2) {
            addCriterion("t_recommend_udt between", value1, value2, "tRecommendUdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_recommend_udt not between", value1, value2, "tRecommendUdt");
            return (Criteria) this;
        }

        public Criteria andTRecommendDeleteIsNull() {
            addCriterion("t_recommend_delete is null");
            return (Criteria) this;
        }

        public Criteria andTRecommendDeleteIsNotNull() {
            addCriterion("t_recommend_delete is not null");
            return (Criteria) this;
        }

        public Criteria andTRecommendDeleteEqualTo(Integer value) {
            addCriterion("t_recommend_delete =", value, "tRecommendDelete");
            return (Criteria) this;
        }

        public Criteria andTRecommendDeleteNotEqualTo(Integer value) {
            addCriterion("t_recommend_delete <>", value, "tRecommendDelete");
            return (Criteria) this;
        }

        public Criteria andTRecommendDeleteGreaterThan(Integer value) {
            addCriterion("t_recommend_delete >", value, "tRecommendDelete");
            return (Criteria) this;
        }

        public Criteria andTRecommendDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_recommend_delete >=", value, "tRecommendDelete");
            return (Criteria) this;
        }

        public Criteria andTRecommendDeleteLessThan(Integer value) {
            addCriterion("t_recommend_delete <", value, "tRecommendDelete");
            return (Criteria) this;
        }

        public Criteria andTRecommendDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("t_recommend_delete <=", value, "tRecommendDelete");
            return (Criteria) this;
        }

        public Criteria andTRecommendDeleteIn(List<Integer> values) {
            addCriterion("t_recommend_delete in", values, "tRecommendDelete");
            return (Criteria) this;
        }

        public Criteria andTRecommendDeleteNotIn(List<Integer> values) {
            addCriterion("t_recommend_delete not in", values, "tRecommendDelete");
            return (Criteria) this;
        }

        public Criteria andTRecommendDeleteBetween(Integer value1, Integer value2) {
            addCriterion("t_recommend_delete between", value1, value2, "tRecommendDelete");
            return (Criteria) this;
        }

        public Criteria andTRecommendDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("t_recommend_delete not between", value1, value2, "tRecommendDelete");
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