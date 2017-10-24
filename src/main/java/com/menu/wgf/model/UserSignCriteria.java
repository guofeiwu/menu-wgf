package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserSignCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserSignCriteria() {
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

        public Criteria andTSignPkidIsNull() {
            addCriterion("t_sign_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTSignPkidIsNotNull() {
            addCriterion("t_sign_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTSignPkidEqualTo(Integer value) {
            addCriterion("t_sign_pkid =", value, "tSignPkid");
            return (Criteria) this;
        }

        public Criteria andTSignPkidNotEqualTo(Integer value) {
            addCriterion("t_sign_pkid <>", value, "tSignPkid");
            return (Criteria) this;
        }

        public Criteria andTSignPkidGreaterThan(Integer value) {
            addCriterion("t_sign_pkid >", value, "tSignPkid");
            return (Criteria) this;
        }

        public Criteria andTSignPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_sign_pkid >=", value, "tSignPkid");
            return (Criteria) this;
        }

        public Criteria andTSignPkidLessThan(Integer value) {
            addCriterion("t_sign_pkid <", value, "tSignPkid");
            return (Criteria) this;
        }

        public Criteria andTSignPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_sign_pkid <=", value, "tSignPkid");
            return (Criteria) this;
        }

        public Criteria andTSignPkidIn(List<Integer> values) {
            addCriterion("t_sign_pkid in", values, "tSignPkid");
            return (Criteria) this;
        }

        public Criteria andTSignPkidNotIn(List<Integer> values) {
            addCriterion("t_sign_pkid not in", values, "tSignPkid");
            return (Criteria) this;
        }

        public Criteria andTSignPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_sign_pkid between", value1, value2, "tSignPkid");
            return (Criteria) this;
        }

        public Criteria andTSignPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_sign_pkid not between", value1, value2, "tSignPkid");
            return (Criteria) this;
        }

        public Criteria andTSignUserPkidIsNull() {
            addCriterion("t_sign_user_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTSignUserPkidIsNotNull() {
            addCriterion("t_sign_user_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTSignUserPkidEqualTo(Integer value) {
            addCriterion("t_sign_user_pkid =", value, "tSignUserPkid");
            return (Criteria) this;
        }

        public Criteria andTSignUserPkidNotEqualTo(Integer value) {
            addCriterion("t_sign_user_pkid <>", value, "tSignUserPkid");
            return (Criteria) this;
        }

        public Criteria andTSignUserPkidGreaterThan(Integer value) {
            addCriterion("t_sign_user_pkid >", value, "tSignUserPkid");
            return (Criteria) this;
        }

        public Criteria andTSignUserPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_sign_user_pkid >=", value, "tSignUserPkid");
            return (Criteria) this;
        }

        public Criteria andTSignUserPkidLessThan(Integer value) {
            addCriterion("t_sign_user_pkid <", value, "tSignUserPkid");
            return (Criteria) this;
        }

        public Criteria andTSignUserPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_sign_user_pkid <=", value, "tSignUserPkid");
            return (Criteria) this;
        }

        public Criteria andTSignUserPkidIn(List<Integer> values) {
            addCriterion("t_sign_user_pkid in", values, "tSignUserPkid");
            return (Criteria) this;
        }

        public Criteria andTSignUserPkidNotIn(List<Integer> values) {
            addCriterion("t_sign_user_pkid not in", values, "tSignUserPkid");
            return (Criteria) this;
        }

        public Criteria andTSignUserPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_sign_user_pkid between", value1, value2, "tSignUserPkid");
            return (Criteria) this;
        }

        public Criteria andTSignUserPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_sign_user_pkid not between", value1, value2, "tSignUserPkid");
            return (Criteria) this;
        }

        public Criteria andTSignCdtIsNull() {
            addCriterion("t_sign_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTSignCdtIsNotNull() {
            addCriterion("t_sign_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTSignCdtEqualTo(Date value) {
            addCriterion("t_sign_cdt =", value, "tSignCdt");
            return (Criteria) this;
        }

        public Criteria andTSignCdtNotEqualTo(Date value) {
            addCriterion("t_sign_cdt <>", value, "tSignCdt");
            return (Criteria) this;
        }

        public Criteria andTSignCdtGreaterThan(Date value) {
            addCriterion("t_sign_cdt >", value, "tSignCdt");
            return (Criteria) this;
        }

        public Criteria andTSignCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_sign_cdt >=", value, "tSignCdt");
            return (Criteria) this;
        }

        public Criteria andTSignCdtLessThan(Date value) {
            addCriterion("t_sign_cdt <", value, "tSignCdt");
            return (Criteria) this;
        }

        public Criteria andTSignCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_sign_cdt <=", value, "tSignCdt");
            return (Criteria) this;
        }

        public Criteria andTSignCdtIn(List<Date> values) {
            addCriterion("t_sign_cdt in", values, "tSignCdt");
            return (Criteria) this;
        }

        public Criteria andTSignCdtNotIn(List<Date> values) {
            addCriterion("t_sign_cdt not in", values, "tSignCdt");
            return (Criteria) this;
        }

        public Criteria andTSignCdtBetween(Date value1, Date value2) {
            addCriterion("t_sign_cdt between", value1, value2, "tSignCdt");
            return (Criteria) this;
        }

        public Criteria andTSignCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_sign_cdt not between", value1, value2, "tSignCdt");
            return (Criteria) this;
        }

        public Criteria andTSignUdtIsNull() {
            addCriterion("t_sign_udt is null");
            return (Criteria) this;
        }

        public Criteria andTSignUdtIsNotNull() {
            addCriterion("t_sign_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTSignUdtEqualTo(Date value) {
            addCriterion("t_sign_udt =", value, "tSignUdt");
            return (Criteria) this;
        }

        public Criteria andTSignUdtNotEqualTo(Date value) {
            addCriterion("t_sign_udt <>", value, "tSignUdt");
            return (Criteria) this;
        }

        public Criteria andTSignUdtGreaterThan(Date value) {
            addCriterion("t_sign_udt >", value, "tSignUdt");
            return (Criteria) this;
        }

        public Criteria andTSignUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_sign_udt >=", value, "tSignUdt");
            return (Criteria) this;
        }

        public Criteria andTSignUdtLessThan(Date value) {
            addCriterion("t_sign_udt <", value, "tSignUdt");
            return (Criteria) this;
        }

        public Criteria andTSignUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_sign_udt <=", value, "tSignUdt");
            return (Criteria) this;
        }

        public Criteria andTSignUdtIn(List<Date> values) {
            addCriterion("t_sign_udt in", values, "tSignUdt");
            return (Criteria) this;
        }

        public Criteria andTSignUdtNotIn(List<Date> values) {
            addCriterion("t_sign_udt not in", values, "tSignUdt");
            return (Criteria) this;
        }

        public Criteria andTSignUdtBetween(Date value1, Date value2) {
            addCriterion("t_sign_udt between", value1, value2, "tSignUdt");
            return (Criteria) this;
        }

        public Criteria andTSignUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_sign_udt not between", value1, value2, "tSignUdt");
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