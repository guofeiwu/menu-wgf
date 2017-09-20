package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LikeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LikeCriteria() {
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

        public Criteria andTLikePkidIsNull() {
            addCriterion("t_like_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTLikePkidIsNotNull() {
            addCriterion("t_like_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTLikePkidEqualTo(Integer value) {
            addCriterion("t_like_pkid =", value, "tLikePkid");
            return (Criteria) this;
        }

        public Criteria andTLikePkidNotEqualTo(Integer value) {
            addCriterion("t_like_pkid <>", value, "tLikePkid");
            return (Criteria) this;
        }

        public Criteria andTLikePkidGreaterThan(Integer value) {
            addCriterion("t_like_pkid >", value, "tLikePkid");
            return (Criteria) this;
        }

        public Criteria andTLikePkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_like_pkid >=", value, "tLikePkid");
            return (Criteria) this;
        }

        public Criteria andTLikePkidLessThan(Integer value) {
            addCriterion("t_like_pkid <", value, "tLikePkid");
            return (Criteria) this;
        }

        public Criteria andTLikePkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_like_pkid <=", value, "tLikePkid");
            return (Criteria) this;
        }

        public Criteria andTLikePkidIn(List<Integer> values) {
            addCriterion("t_like_pkid in", values, "tLikePkid");
            return (Criteria) this;
        }

        public Criteria andTLikePkidNotIn(List<Integer> values) {
            addCriterion("t_like_pkid not in", values, "tLikePkid");
            return (Criteria) this;
        }

        public Criteria andTLikePkidBetween(Integer value1, Integer value2) {
            addCriterion("t_like_pkid between", value1, value2, "tLikePkid");
            return (Criteria) this;
        }

        public Criteria andTLikePkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_like_pkid not between", value1, value2, "tLikePkid");
            return (Criteria) this;
        }

        public Criteria andTLikeUserPkidIsNull() {
            addCriterion("t_like_user_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTLikeUserPkidIsNotNull() {
            addCriterion("t_like_user_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTLikeUserPkidEqualTo(Integer value) {
            addCriterion("t_like_user_pkid =", value, "tLikeUserPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeUserPkidNotEqualTo(Integer value) {
            addCriterion("t_like_user_pkid <>", value, "tLikeUserPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeUserPkidGreaterThan(Integer value) {
            addCriterion("t_like_user_pkid >", value, "tLikeUserPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeUserPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_like_user_pkid >=", value, "tLikeUserPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeUserPkidLessThan(Integer value) {
            addCriterion("t_like_user_pkid <", value, "tLikeUserPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeUserPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_like_user_pkid <=", value, "tLikeUserPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeUserPkidIn(List<Integer> values) {
            addCriterion("t_like_user_pkid in", values, "tLikeUserPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeUserPkidNotIn(List<Integer> values) {
            addCriterion("t_like_user_pkid not in", values, "tLikeUserPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeUserPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_like_user_pkid between", value1, value2, "tLikeUserPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeUserPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_like_user_pkid not between", value1, value2, "tLikeUserPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeMenuPkidIsNull() {
            addCriterion("t_like_menu_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTLikeMenuPkidIsNotNull() {
            addCriterion("t_like_menu_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTLikeMenuPkidEqualTo(Integer value) {
            addCriterion("t_like_menu_pkid =", value, "tLikeMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeMenuPkidNotEqualTo(Integer value) {
            addCriterion("t_like_menu_pkid <>", value, "tLikeMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeMenuPkidGreaterThan(Integer value) {
            addCriterion("t_like_menu_pkid >", value, "tLikeMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeMenuPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_like_menu_pkid >=", value, "tLikeMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeMenuPkidLessThan(Integer value) {
            addCriterion("t_like_menu_pkid <", value, "tLikeMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeMenuPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_like_menu_pkid <=", value, "tLikeMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeMenuPkidIn(List<Integer> values) {
            addCriterion("t_like_menu_pkid in", values, "tLikeMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeMenuPkidNotIn(List<Integer> values) {
            addCriterion("t_like_menu_pkid not in", values, "tLikeMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeMenuPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_like_menu_pkid between", value1, value2, "tLikeMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeMenuPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_like_menu_pkid not between", value1, value2, "tLikeMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTLikeCdtIsNull() {
            addCriterion("t_like_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTLikeCdtIsNotNull() {
            addCriterion("t_like_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTLikeCdtEqualTo(Date value) {
            addCriterion("t_like_cdt =", value, "tLikeCdt");
            return (Criteria) this;
        }

        public Criteria andTLikeCdtNotEqualTo(Date value) {
            addCriterion("t_like_cdt <>", value, "tLikeCdt");
            return (Criteria) this;
        }

        public Criteria andTLikeCdtGreaterThan(Date value) {
            addCriterion("t_like_cdt >", value, "tLikeCdt");
            return (Criteria) this;
        }

        public Criteria andTLikeCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_like_cdt >=", value, "tLikeCdt");
            return (Criteria) this;
        }

        public Criteria andTLikeCdtLessThan(Date value) {
            addCriterion("t_like_cdt <", value, "tLikeCdt");
            return (Criteria) this;
        }

        public Criteria andTLikeCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_like_cdt <=", value, "tLikeCdt");
            return (Criteria) this;
        }

        public Criteria andTLikeCdtIn(List<Date> values) {
            addCriterion("t_like_cdt in", values, "tLikeCdt");
            return (Criteria) this;
        }

        public Criteria andTLikeCdtNotIn(List<Date> values) {
            addCriterion("t_like_cdt not in", values, "tLikeCdt");
            return (Criteria) this;
        }

        public Criteria andTLikeCdtBetween(Date value1, Date value2) {
            addCriterion("t_like_cdt between", value1, value2, "tLikeCdt");
            return (Criteria) this;
        }

        public Criteria andTLikeCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_like_cdt not between", value1, value2, "tLikeCdt");
            return (Criteria) this;
        }

        public Criteria andTLikeUdtIsNull() {
            addCriterion("t_like_udt is null");
            return (Criteria) this;
        }

        public Criteria andTLikeUdtIsNotNull() {
            addCriterion("t_like_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTLikeUdtEqualTo(Date value) {
            addCriterion("t_like_udt =", value, "tLikeUdt");
            return (Criteria) this;
        }

        public Criteria andTLikeUdtNotEqualTo(Date value) {
            addCriterion("t_like_udt <>", value, "tLikeUdt");
            return (Criteria) this;
        }

        public Criteria andTLikeUdtGreaterThan(Date value) {
            addCriterion("t_like_udt >", value, "tLikeUdt");
            return (Criteria) this;
        }

        public Criteria andTLikeUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_like_udt >=", value, "tLikeUdt");
            return (Criteria) this;
        }

        public Criteria andTLikeUdtLessThan(Date value) {
            addCriterion("t_like_udt <", value, "tLikeUdt");
            return (Criteria) this;
        }

        public Criteria andTLikeUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_like_udt <=", value, "tLikeUdt");
            return (Criteria) this;
        }

        public Criteria andTLikeUdtIn(List<Date> values) {
            addCriterion("t_like_udt in", values, "tLikeUdt");
            return (Criteria) this;
        }

        public Criteria andTLikeUdtNotIn(List<Date> values) {
            addCriterion("t_like_udt not in", values, "tLikeUdt");
            return (Criteria) this;
        }

        public Criteria andTLikeUdtBetween(Date value1, Date value2) {
            addCriterion("t_like_udt between", value1, value2, "tLikeUdt");
            return (Criteria) this;
        }

        public Criteria andTLikeUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_like_udt not between", value1, value2, "tLikeUdt");
            return (Criteria) this;
        }

        public Criteria andTLikeDeleteIsNull() {
            addCriterion("t_like_delete is null");
            return (Criteria) this;
        }

        public Criteria andTLikeDeleteIsNotNull() {
            addCriterion("t_like_delete is not null");
            return (Criteria) this;
        }

        public Criteria andTLikeDeleteEqualTo(Integer value) {
            addCriterion("t_like_delete =", value, "tLikeDelete");
            return (Criteria) this;
        }

        public Criteria andTLikeDeleteNotEqualTo(Integer value) {
            addCriterion("t_like_delete <>", value, "tLikeDelete");
            return (Criteria) this;
        }

        public Criteria andTLikeDeleteGreaterThan(Integer value) {
            addCriterion("t_like_delete >", value, "tLikeDelete");
            return (Criteria) this;
        }

        public Criteria andTLikeDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_like_delete >=", value, "tLikeDelete");
            return (Criteria) this;
        }

        public Criteria andTLikeDeleteLessThan(Integer value) {
            addCriterion("t_like_delete <", value, "tLikeDelete");
            return (Criteria) this;
        }

        public Criteria andTLikeDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("t_like_delete <=", value, "tLikeDelete");
            return (Criteria) this;
        }

        public Criteria andTLikeDeleteIn(List<Integer> values) {
            addCriterion("t_like_delete in", values, "tLikeDelete");
            return (Criteria) this;
        }

        public Criteria andTLikeDeleteNotIn(List<Integer> values) {
            addCriterion("t_like_delete not in", values, "tLikeDelete");
            return (Criteria) this;
        }

        public Criteria andTLikeDeleteBetween(Integer value1, Integer value2) {
            addCriterion("t_like_delete between", value1, value2, "tLikeDelete");
            return (Criteria) this;
        }

        public Criteria andTLikeDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("t_like_delete not between", value1, value2, "tLikeDelete");
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