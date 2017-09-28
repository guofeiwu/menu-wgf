package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShareCriteria() {
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

        public Criteria andTSharePkidIsNull() {
            addCriterion("t_share_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTSharePkidIsNotNull() {
            addCriterion("t_share_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTSharePkidEqualTo(Integer value) {
            addCriterion("t_share_pkid =", value, "tSharePkid");
            return (Criteria) this;
        }

        public Criteria andTSharePkidNotEqualTo(Integer value) {
            addCriterion("t_share_pkid <>", value, "tSharePkid");
            return (Criteria) this;
        }

        public Criteria andTSharePkidGreaterThan(Integer value) {
            addCriterion("t_share_pkid >", value, "tSharePkid");
            return (Criteria) this;
        }

        public Criteria andTSharePkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_share_pkid >=", value, "tSharePkid");
            return (Criteria) this;
        }

        public Criteria andTSharePkidLessThan(Integer value) {
            addCriterion("t_share_pkid <", value, "tSharePkid");
            return (Criteria) this;
        }

        public Criteria andTSharePkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_share_pkid <=", value, "tSharePkid");
            return (Criteria) this;
        }

        public Criteria andTSharePkidIn(List<Integer> values) {
            addCriterion("t_share_pkid in", values, "tSharePkid");
            return (Criteria) this;
        }

        public Criteria andTSharePkidNotIn(List<Integer> values) {
            addCriterion("t_share_pkid not in", values, "tSharePkid");
            return (Criteria) this;
        }

        public Criteria andTSharePkidBetween(Integer value1, Integer value2) {
            addCriterion("t_share_pkid between", value1, value2, "tSharePkid");
            return (Criteria) this;
        }

        public Criteria andTSharePkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_share_pkid not between", value1, value2, "tSharePkid");
            return (Criteria) this;
        }

        public Criteria andTShareUserPkidIsNull() {
            addCriterion("t_share_user_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTShareUserPkidIsNotNull() {
            addCriterion("t_share_user_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTShareUserPkidEqualTo(Integer value) {
            addCriterion("t_share_user_pkid =", value, "tShareUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShareUserPkidNotEqualTo(Integer value) {
            addCriterion("t_share_user_pkid <>", value, "tShareUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShareUserPkidGreaterThan(Integer value) {
            addCriterion("t_share_user_pkid >", value, "tShareUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShareUserPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_share_user_pkid >=", value, "tShareUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShareUserPkidLessThan(Integer value) {
            addCriterion("t_share_user_pkid <", value, "tShareUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShareUserPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_share_user_pkid <=", value, "tShareUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShareUserPkidIn(List<Integer> values) {
            addCriterion("t_share_user_pkid in", values, "tShareUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShareUserPkidNotIn(List<Integer> values) {
            addCriterion("t_share_user_pkid not in", values, "tShareUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShareUserPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_share_user_pkid between", value1, value2, "tShareUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShareUserPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_share_user_pkid not between", value1, value2, "tShareUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShareMenuPkidIsNull() {
            addCriterion("t_share_menu_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTShareMenuPkidIsNotNull() {
            addCriterion("t_share_menu_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTShareMenuPkidEqualTo(Integer value) {
            addCriterion("t_share_menu_pkid =", value, "tShareMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTShareMenuPkidNotEqualTo(Integer value) {
            addCriterion("t_share_menu_pkid <>", value, "tShareMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTShareMenuPkidGreaterThan(Integer value) {
            addCriterion("t_share_menu_pkid >", value, "tShareMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTShareMenuPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_share_menu_pkid >=", value, "tShareMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTShareMenuPkidLessThan(Integer value) {
            addCriterion("t_share_menu_pkid <", value, "tShareMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTShareMenuPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_share_menu_pkid <=", value, "tShareMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTShareMenuPkidIn(List<Integer> values) {
            addCriterion("t_share_menu_pkid in", values, "tShareMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTShareMenuPkidNotIn(List<Integer> values) {
            addCriterion("t_share_menu_pkid not in", values, "tShareMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTShareMenuPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_share_menu_pkid between", value1, value2, "tShareMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTShareMenuPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_share_menu_pkid not between", value1, value2, "tShareMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTShareCdtIsNull() {
            addCriterion("t_share_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTShareCdtIsNotNull() {
            addCriterion("t_share_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTShareCdtEqualTo(Date value) {
            addCriterion("t_share_cdt =", value, "tShareCdt");
            return (Criteria) this;
        }

        public Criteria andTShareCdtNotEqualTo(Date value) {
            addCriterion("t_share_cdt <>", value, "tShareCdt");
            return (Criteria) this;
        }

        public Criteria andTShareCdtGreaterThan(Date value) {
            addCriterion("t_share_cdt >", value, "tShareCdt");
            return (Criteria) this;
        }

        public Criteria andTShareCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_share_cdt >=", value, "tShareCdt");
            return (Criteria) this;
        }

        public Criteria andTShareCdtLessThan(Date value) {
            addCriterion("t_share_cdt <", value, "tShareCdt");
            return (Criteria) this;
        }

        public Criteria andTShareCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_share_cdt <=", value, "tShareCdt");
            return (Criteria) this;
        }

        public Criteria andTShareCdtIn(List<Date> values) {
            addCriterion("t_share_cdt in", values, "tShareCdt");
            return (Criteria) this;
        }

        public Criteria andTShareCdtNotIn(List<Date> values) {
            addCriterion("t_share_cdt not in", values, "tShareCdt");
            return (Criteria) this;
        }

        public Criteria andTShareCdtBetween(Date value1, Date value2) {
            addCriterion("t_share_cdt between", value1, value2, "tShareCdt");
            return (Criteria) this;
        }

        public Criteria andTShareCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_share_cdt not between", value1, value2, "tShareCdt");
            return (Criteria) this;
        }

        public Criteria andTShareUdtIsNull() {
            addCriterion("t_share_udt is null");
            return (Criteria) this;
        }

        public Criteria andTShareUdtIsNotNull() {
            addCriterion("t_share_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTShareUdtEqualTo(Date value) {
            addCriterion("t_share_udt =", value, "tShareUdt");
            return (Criteria) this;
        }

        public Criteria andTShareUdtNotEqualTo(Date value) {
            addCriterion("t_share_udt <>", value, "tShareUdt");
            return (Criteria) this;
        }

        public Criteria andTShareUdtGreaterThan(Date value) {
            addCriterion("t_share_udt >", value, "tShareUdt");
            return (Criteria) this;
        }

        public Criteria andTShareUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_share_udt >=", value, "tShareUdt");
            return (Criteria) this;
        }

        public Criteria andTShareUdtLessThan(Date value) {
            addCriterion("t_share_udt <", value, "tShareUdt");
            return (Criteria) this;
        }

        public Criteria andTShareUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_share_udt <=", value, "tShareUdt");
            return (Criteria) this;
        }

        public Criteria andTShareUdtIn(List<Date> values) {
            addCriterion("t_share_udt in", values, "tShareUdt");
            return (Criteria) this;
        }

        public Criteria andTShareUdtNotIn(List<Date> values) {
            addCriterion("t_share_udt not in", values, "tShareUdt");
            return (Criteria) this;
        }

        public Criteria andTShareUdtBetween(Date value1, Date value2) {
            addCriterion("t_share_udt between", value1, value2, "tShareUdt");
            return (Criteria) this;
        }

        public Criteria andTShareUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_share_udt not between", value1, value2, "tShareUdt");
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