package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollectCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollectCriteria() {
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

        public Criteria andTCollectPkidIsNull() {
            addCriterion("t_collect_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTCollectPkidIsNotNull() {
            addCriterion("t_collect_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTCollectPkidEqualTo(Integer value) {
            addCriterion("t_collect_pkid =", value, "tCollectPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectPkidNotEqualTo(Integer value) {
            addCriterion("t_collect_pkid <>", value, "tCollectPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectPkidGreaterThan(Integer value) {
            addCriterion("t_collect_pkid >", value, "tCollectPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_collect_pkid >=", value, "tCollectPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectPkidLessThan(Integer value) {
            addCriterion("t_collect_pkid <", value, "tCollectPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_collect_pkid <=", value, "tCollectPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectPkidIn(List<Integer> values) {
            addCriterion("t_collect_pkid in", values, "tCollectPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectPkidNotIn(List<Integer> values) {
            addCriterion("t_collect_pkid not in", values, "tCollectPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_collect_pkid between", value1, value2, "tCollectPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_collect_pkid not between", value1, value2, "tCollectPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectUserPkidIsNull() {
            addCriterion("t_collect_user_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTCollectUserPkidIsNotNull() {
            addCriterion("t_collect_user_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTCollectUserPkidEqualTo(Integer value) {
            addCriterion("t_collect_user_pkid =", value, "tCollectUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectUserPkidNotEqualTo(Integer value) {
            addCriterion("t_collect_user_pkid <>", value, "tCollectUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectUserPkidGreaterThan(Integer value) {
            addCriterion("t_collect_user_pkid >", value, "tCollectUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectUserPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_collect_user_pkid >=", value, "tCollectUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectUserPkidLessThan(Integer value) {
            addCriterion("t_collect_user_pkid <", value, "tCollectUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectUserPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_collect_user_pkid <=", value, "tCollectUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectUserPkidIn(List<Integer> values) {
            addCriterion("t_collect_user_pkid in", values, "tCollectUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectUserPkidNotIn(List<Integer> values) {
            addCriterion("t_collect_user_pkid not in", values, "tCollectUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectUserPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_collect_user_pkid between", value1, value2, "tCollectUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectUserPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_collect_user_pkid not between", value1, value2, "tCollectUserPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectMenuPkidIsNull() {
            addCriterion("t_collect_menu_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTCollectMenuPkidIsNotNull() {
            addCriterion("t_collect_menu_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTCollectMenuPkidEqualTo(Integer value) {
            addCriterion("t_collect_menu_pkid =", value, "tCollectMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectMenuPkidNotEqualTo(Integer value) {
            addCriterion("t_collect_menu_pkid <>", value, "tCollectMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectMenuPkidGreaterThan(Integer value) {
            addCriterion("t_collect_menu_pkid >", value, "tCollectMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectMenuPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_collect_menu_pkid >=", value, "tCollectMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectMenuPkidLessThan(Integer value) {
            addCriterion("t_collect_menu_pkid <", value, "tCollectMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectMenuPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_collect_menu_pkid <=", value, "tCollectMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectMenuPkidIn(List<Integer> values) {
            addCriterion("t_collect_menu_pkid in", values, "tCollectMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectMenuPkidNotIn(List<Integer> values) {
            addCriterion("t_collect_menu_pkid not in", values, "tCollectMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectMenuPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_collect_menu_pkid between", value1, value2, "tCollectMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectMenuPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_collect_menu_pkid not between", value1, value2, "tCollectMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTCollectCdtIsNull() {
            addCriterion("t_collect_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTCollectCdtIsNotNull() {
            addCriterion("t_collect_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTCollectCdtEqualTo(Date value) {
            addCriterion("t_collect_cdt =", value, "tCollectCdt");
            return (Criteria) this;
        }

        public Criteria andTCollectCdtNotEqualTo(Date value) {
            addCriterion("t_collect_cdt <>", value, "tCollectCdt");
            return (Criteria) this;
        }

        public Criteria andTCollectCdtGreaterThan(Date value) {
            addCriterion("t_collect_cdt >", value, "tCollectCdt");
            return (Criteria) this;
        }

        public Criteria andTCollectCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_collect_cdt >=", value, "tCollectCdt");
            return (Criteria) this;
        }

        public Criteria andTCollectCdtLessThan(Date value) {
            addCriterion("t_collect_cdt <", value, "tCollectCdt");
            return (Criteria) this;
        }

        public Criteria andTCollectCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_collect_cdt <=", value, "tCollectCdt");
            return (Criteria) this;
        }

        public Criteria andTCollectCdtIn(List<Date> values) {
            addCriterion("t_collect_cdt in", values, "tCollectCdt");
            return (Criteria) this;
        }

        public Criteria andTCollectCdtNotIn(List<Date> values) {
            addCriterion("t_collect_cdt not in", values, "tCollectCdt");
            return (Criteria) this;
        }

        public Criteria andTCollectCdtBetween(Date value1, Date value2) {
            addCriterion("t_collect_cdt between", value1, value2, "tCollectCdt");
            return (Criteria) this;
        }

        public Criteria andTCollectCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_collect_cdt not between", value1, value2, "tCollectCdt");
            return (Criteria) this;
        }

        public Criteria andTCollectUdtIsNull() {
            addCriterion("t_collect_udt is null");
            return (Criteria) this;
        }

        public Criteria andTCollectUdtIsNotNull() {
            addCriterion("t_collect_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTCollectUdtEqualTo(Date value) {
            addCriterion("t_collect_udt =", value, "tCollectUdt");
            return (Criteria) this;
        }

        public Criteria andTCollectUdtNotEqualTo(Date value) {
            addCriterion("t_collect_udt <>", value, "tCollectUdt");
            return (Criteria) this;
        }

        public Criteria andTCollectUdtGreaterThan(Date value) {
            addCriterion("t_collect_udt >", value, "tCollectUdt");
            return (Criteria) this;
        }

        public Criteria andTCollectUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_collect_udt >=", value, "tCollectUdt");
            return (Criteria) this;
        }

        public Criteria andTCollectUdtLessThan(Date value) {
            addCriterion("t_collect_udt <", value, "tCollectUdt");
            return (Criteria) this;
        }

        public Criteria andTCollectUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_collect_udt <=", value, "tCollectUdt");
            return (Criteria) this;
        }

        public Criteria andTCollectUdtIn(List<Date> values) {
            addCriterion("t_collect_udt in", values, "tCollectUdt");
            return (Criteria) this;
        }

        public Criteria andTCollectUdtNotIn(List<Date> values) {
            addCriterion("t_collect_udt not in", values, "tCollectUdt");
            return (Criteria) this;
        }

        public Criteria andTCollectUdtBetween(Date value1, Date value2) {
            addCriterion("t_collect_udt between", value1, value2, "tCollectUdt");
            return (Criteria) this;
        }

        public Criteria andTCollectUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_collect_udt not between", value1, value2, "tCollectUdt");
            return (Criteria) this;
        }

        public Criteria andTCollectCancelIsNull() {
            addCriterion("t_collect_cancel is null");
            return (Criteria) this;
        }

        public Criteria andTCollectCancelIsNotNull() {
            addCriterion("t_collect_cancel is not null");
            return (Criteria) this;
        }

        public Criteria andTCollectCancelEqualTo(Integer value) {
            addCriterion("t_collect_cancel =", value, "tCollectCancel");
            return (Criteria) this;
        }

        public Criteria andTCollectCancelNotEqualTo(Integer value) {
            addCriterion("t_collect_cancel <>", value, "tCollectCancel");
            return (Criteria) this;
        }

        public Criteria andTCollectCancelGreaterThan(Integer value) {
            addCriterion("t_collect_cancel >", value, "tCollectCancel");
            return (Criteria) this;
        }

        public Criteria andTCollectCancelGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_collect_cancel >=", value, "tCollectCancel");
            return (Criteria) this;
        }

        public Criteria andTCollectCancelLessThan(Integer value) {
            addCriterion("t_collect_cancel <", value, "tCollectCancel");
            return (Criteria) this;
        }

        public Criteria andTCollectCancelLessThanOrEqualTo(Integer value) {
            addCriterion("t_collect_cancel <=", value, "tCollectCancel");
            return (Criteria) this;
        }

        public Criteria andTCollectCancelIn(List<Integer> values) {
            addCriterion("t_collect_cancel in", values, "tCollectCancel");
            return (Criteria) this;
        }

        public Criteria andTCollectCancelNotIn(List<Integer> values) {
            addCriterion("t_collect_cancel not in", values, "tCollectCancel");
            return (Criteria) this;
        }

        public Criteria andTCollectCancelBetween(Integer value1, Integer value2) {
            addCriterion("t_collect_cancel between", value1, value2, "tCollectCancel");
            return (Criteria) this;
        }

        public Criteria andTCollectCancelNotBetween(Integer value1, Integer value2) {
            addCriterion("t_collect_cancel not between", value1, value2, "tCollectCancel");
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