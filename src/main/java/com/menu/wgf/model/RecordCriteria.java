package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecordCriteria() {
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

        public Criteria andTRecordPkidIsNull() {
            addCriterion("t_record_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTRecordPkidIsNotNull() {
            addCriterion("t_record_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTRecordPkidEqualTo(Integer value) {
            addCriterion("t_record_pkid =", value, "tRecordPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordPkidNotEqualTo(Integer value) {
            addCriterion("t_record_pkid <>", value, "tRecordPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordPkidGreaterThan(Integer value) {
            addCriterion("t_record_pkid >", value, "tRecordPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_record_pkid >=", value, "tRecordPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordPkidLessThan(Integer value) {
            addCriterion("t_record_pkid <", value, "tRecordPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_record_pkid <=", value, "tRecordPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordPkidIn(List<Integer> values) {
            addCriterion("t_record_pkid in", values, "tRecordPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordPkidNotIn(List<Integer> values) {
            addCriterion("t_record_pkid not in", values, "tRecordPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_record_pkid between", value1, value2, "tRecordPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_record_pkid not between", value1, value2, "tRecordPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordUserPkidIsNull() {
            addCriterion("t_record_user_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTRecordUserPkidIsNotNull() {
            addCriterion("t_record_user_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTRecordUserPkidEqualTo(Integer value) {
            addCriterion("t_record_user_pkid =", value, "tRecordUserPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordUserPkidNotEqualTo(Integer value) {
            addCriterion("t_record_user_pkid <>", value, "tRecordUserPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordUserPkidGreaterThan(Integer value) {
            addCriterion("t_record_user_pkid >", value, "tRecordUserPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordUserPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_record_user_pkid >=", value, "tRecordUserPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordUserPkidLessThan(Integer value) {
            addCriterion("t_record_user_pkid <", value, "tRecordUserPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordUserPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_record_user_pkid <=", value, "tRecordUserPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordUserPkidIn(List<Integer> values) {
            addCriterion("t_record_user_pkid in", values, "tRecordUserPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordUserPkidNotIn(List<Integer> values) {
            addCriterion("t_record_user_pkid not in", values, "tRecordUserPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordUserPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_record_user_pkid between", value1, value2, "tRecordUserPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordUserPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_record_user_pkid not between", value1, value2, "tRecordUserPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordMenuPkidIsNull() {
            addCriterion("t_record_menu_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTRecordMenuPkidIsNotNull() {
            addCriterion("t_record_menu_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTRecordMenuPkidEqualTo(Integer value) {
            addCriterion("t_record_menu_pkid =", value, "tRecordMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordMenuPkidNotEqualTo(Integer value) {
            addCriterion("t_record_menu_pkid <>", value, "tRecordMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordMenuPkidGreaterThan(Integer value) {
            addCriterion("t_record_menu_pkid >", value, "tRecordMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordMenuPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_record_menu_pkid >=", value, "tRecordMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordMenuPkidLessThan(Integer value) {
            addCriterion("t_record_menu_pkid <", value, "tRecordMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordMenuPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_record_menu_pkid <=", value, "tRecordMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordMenuPkidIn(List<Integer> values) {
            addCriterion("t_record_menu_pkid in", values, "tRecordMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordMenuPkidNotIn(List<Integer> values) {
            addCriterion("t_record_menu_pkid not in", values, "tRecordMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordMenuPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_record_menu_pkid between", value1, value2, "tRecordMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordMenuPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_record_menu_pkid not between", value1, value2, "tRecordMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTRecordCdtIsNull() {
            addCriterion("t_record_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTRecordCdtIsNotNull() {
            addCriterion("t_record_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTRecordCdtEqualTo(Date value) {
            addCriterion("t_record_cdt =", value, "tRecordCdt");
            return (Criteria) this;
        }

        public Criteria andTRecordCdtNotEqualTo(Date value) {
            addCriterion("t_record_cdt <>", value, "tRecordCdt");
            return (Criteria) this;
        }

        public Criteria andTRecordCdtGreaterThan(Date value) {
            addCriterion("t_record_cdt >", value, "tRecordCdt");
            return (Criteria) this;
        }

        public Criteria andTRecordCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_record_cdt >=", value, "tRecordCdt");
            return (Criteria) this;
        }

        public Criteria andTRecordCdtLessThan(Date value) {
            addCriterion("t_record_cdt <", value, "tRecordCdt");
            return (Criteria) this;
        }

        public Criteria andTRecordCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_record_cdt <=", value, "tRecordCdt");
            return (Criteria) this;
        }

        public Criteria andTRecordCdtIn(List<Date> values) {
            addCriterion("t_record_cdt in", values, "tRecordCdt");
            return (Criteria) this;
        }

        public Criteria andTRecordCdtNotIn(List<Date> values) {
            addCriterion("t_record_cdt not in", values, "tRecordCdt");
            return (Criteria) this;
        }

        public Criteria andTRecordCdtBetween(Date value1, Date value2) {
            addCriterion("t_record_cdt between", value1, value2, "tRecordCdt");
            return (Criteria) this;
        }

        public Criteria andTRecordCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_record_cdt not between", value1, value2, "tRecordCdt");
            return (Criteria) this;
        }

        public Criteria andTRecordUdtIsNull() {
            addCriterion("t_record_udt is null");
            return (Criteria) this;
        }

        public Criteria andTRecordUdtIsNotNull() {
            addCriterion("t_record_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTRecordUdtEqualTo(Date value) {
            addCriterion("t_record_udt =", value, "tRecordUdt");
            return (Criteria) this;
        }

        public Criteria andTRecordUdtNotEqualTo(Date value) {
            addCriterion("t_record_udt <>", value, "tRecordUdt");
            return (Criteria) this;
        }

        public Criteria andTRecordUdtGreaterThan(Date value) {
            addCriterion("t_record_udt >", value, "tRecordUdt");
            return (Criteria) this;
        }

        public Criteria andTRecordUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_record_udt >=", value, "tRecordUdt");
            return (Criteria) this;
        }

        public Criteria andTRecordUdtLessThan(Date value) {
            addCriterion("t_record_udt <", value, "tRecordUdt");
            return (Criteria) this;
        }

        public Criteria andTRecordUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_record_udt <=", value, "tRecordUdt");
            return (Criteria) this;
        }

        public Criteria andTRecordUdtIn(List<Date> values) {
            addCriterion("t_record_udt in", values, "tRecordUdt");
            return (Criteria) this;
        }

        public Criteria andTRecordUdtNotIn(List<Date> values) {
            addCriterion("t_record_udt not in", values, "tRecordUdt");
            return (Criteria) this;
        }

        public Criteria andTRecordUdtBetween(Date value1, Date value2) {
            addCriterion("t_record_udt between", value1, value2, "tRecordUdt");
            return (Criteria) this;
        }

        public Criteria andTRecordUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_record_udt not between", value1, value2, "tRecordUdt");
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