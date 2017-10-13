package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BannersCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BannersCriteria() {
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

        public Criteria andTBannerPkidIsNull() {
            addCriterion("t_banner_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTBannerPkidIsNotNull() {
            addCriterion("t_banner_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTBannerPkidEqualTo(Integer value) {
            addCriterion("t_banner_pkid =", value, "tBannerPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerPkidNotEqualTo(Integer value) {
            addCriterion("t_banner_pkid <>", value, "tBannerPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerPkidGreaterThan(Integer value) {
            addCriterion("t_banner_pkid >", value, "tBannerPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_banner_pkid >=", value, "tBannerPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerPkidLessThan(Integer value) {
            addCriterion("t_banner_pkid <", value, "tBannerPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_banner_pkid <=", value, "tBannerPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerPkidIn(List<Integer> values) {
            addCriterion("t_banner_pkid in", values, "tBannerPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerPkidNotIn(List<Integer> values) {
            addCriterion("t_banner_pkid not in", values, "tBannerPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_banner_pkid between", value1, value2, "tBannerPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_banner_pkid not between", value1, value2, "tBannerPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuPkidIsNull() {
            addCriterion("t_banner_menu_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuPkidIsNotNull() {
            addCriterion("t_banner_menu_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuPkidEqualTo(Integer value) {
            addCriterion("t_banner_menu_pkid =", value, "tBannerMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuPkidNotEqualTo(Integer value) {
            addCriterion("t_banner_menu_pkid <>", value, "tBannerMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuPkidGreaterThan(Integer value) {
            addCriterion("t_banner_menu_pkid >", value, "tBannerMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_banner_menu_pkid >=", value, "tBannerMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuPkidLessThan(Integer value) {
            addCriterion("t_banner_menu_pkid <", value, "tBannerMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_banner_menu_pkid <=", value, "tBannerMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuPkidIn(List<Integer> values) {
            addCriterion("t_banner_menu_pkid in", values, "tBannerMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuPkidNotIn(List<Integer> values) {
            addCriterion("t_banner_menu_pkid not in", values, "tBannerMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_banner_menu_pkid between", value1, value2, "tBannerMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_banner_menu_pkid not between", value1, value2, "tBannerMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuDescIsNull() {
            addCriterion("t_banner_menu_desc is null");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuDescIsNotNull() {
            addCriterion("t_banner_menu_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuDescEqualTo(String value) {
            addCriterion("t_banner_menu_desc =", value, "tBannerMenuDesc");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuDescNotEqualTo(String value) {
            addCriterion("t_banner_menu_desc <>", value, "tBannerMenuDesc");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuDescGreaterThan(String value) {
            addCriterion("t_banner_menu_desc >", value, "tBannerMenuDesc");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuDescGreaterThanOrEqualTo(String value) {
            addCriterion("t_banner_menu_desc >=", value, "tBannerMenuDesc");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuDescLessThan(String value) {
            addCriterion("t_banner_menu_desc <", value, "tBannerMenuDesc");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuDescLessThanOrEqualTo(String value) {
            addCriterion("t_banner_menu_desc <=", value, "tBannerMenuDesc");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuDescLike(String value) {
            addCriterion("t_banner_menu_desc like", value, "tBannerMenuDesc");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuDescNotLike(String value) {
            addCriterion("t_banner_menu_desc not like", value, "tBannerMenuDesc");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuDescIn(List<String> values) {
            addCriterion("t_banner_menu_desc in", values, "tBannerMenuDesc");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuDescNotIn(List<String> values) {
            addCriterion("t_banner_menu_desc not in", values, "tBannerMenuDesc");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuDescBetween(String value1, String value2) {
            addCriterion("t_banner_menu_desc between", value1, value2, "tBannerMenuDesc");
            return (Criteria) this;
        }

        public Criteria andTBannerMenuDescNotBetween(String value1, String value2) {
            addCriterion("t_banner_menu_desc not between", value1, value2, "tBannerMenuDesc");
            return (Criteria) this;
        }

        public Criteria andTBannerCdtIsNull() {
            addCriterion("t_banner_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTBannerCdtIsNotNull() {
            addCriterion("t_banner_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTBannerCdtEqualTo(Date value) {
            addCriterion("t_banner_cdt =", value, "tBannerCdt");
            return (Criteria) this;
        }

        public Criteria andTBannerCdtNotEqualTo(Date value) {
            addCriterion("t_banner_cdt <>", value, "tBannerCdt");
            return (Criteria) this;
        }

        public Criteria andTBannerCdtGreaterThan(Date value) {
            addCriterion("t_banner_cdt >", value, "tBannerCdt");
            return (Criteria) this;
        }

        public Criteria andTBannerCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_banner_cdt >=", value, "tBannerCdt");
            return (Criteria) this;
        }

        public Criteria andTBannerCdtLessThan(Date value) {
            addCriterion("t_banner_cdt <", value, "tBannerCdt");
            return (Criteria) this;
        }

        public Criteria andTBannerCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_banner_cdt <=", value, "tBannerCdt");
            return (Criteria) this;
        }

        public Criteria andTBannerCdtIn(List<Date> values) {
            addCriterion("t_banner_cdt in", values, "tBannerCdt");
            return (Criteria) this;
        }

        public Criteria andTBannerCdtNotIn(List<Date> values) {
            addCriterion("t_banner_cdt not in", values, "tBannerCdt");
            return (Criteria) this;
        }

        public Criteria andTBannerCdtBetween(Date value1, Date value2) {
            addCriterion("t_banner_cdt between", value1, value2, "tBannerCdt");
            return (Criteria) this;
        }

        public Criteria andTBannerCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_banner_cdt not between", value1, value2, "tBannerCdt");
            return (Criteria) this;
        }

        public Criteria andTBannerUdtIsNull() {
            addCriterion("t_banner_udt is null");
            return (Criteria) this;
        }

        public Criteria andTBannerUdtIsNotNull() {
            addCriterion("t_banner_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTBannerUdtEqualTo(Date value) {
            addCriterion("t_banner_udt =", value, "tBannerUdt");
            return (Criteria) this;
        }

        public Criteria andTBannerUdtNotEqualTo(Date value) {
            addCriterion("t_banner_udt <>", value, "tBannerUdt");
            return (Criteria) this;
        }

        public Criteria andTBannerUdtGreaterThan(Date value) {
            addCriterion("t_banner_udt >", value, "tBannerUdt");
            return (Criteria) this;
        }

        public Criteria andTBannerUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_banner_udt >=", value, "tBannerUdt");
            return (Criteria) this;
        }

        public Criteria andTBannerUdtLessThan(Date value) {
            addCriterion("t_banner_udt <", value, "tBannerUdt");
            return (Criteria) this;
        }

        public Criteria andTBannerUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_banner_udt <=", value, "tBannerUdt");
            return (Criteria) this;
        }

        public Criteria andTBannerUdtIn(List<Date> values) {
            addCriterion("t_banner_udt in", values, "tBannerUdt");
            return (Criteria) this;
        }

        public Criteria andTBannerUdtNotIn(List<Date> values) {
            addCriterion("t_banner_udt not in", values, "tBannerUdt");
            return (Criteria) this;
        }

        public Criteria andTBannerUdtBetween(Date value1, Date value2) {
            addCriterion("t_banner_udt between", value1, value2, "tBannerUdt");
            return (Criteria) this;
        }

        public Criteria andTBannerUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_banner_udt not between", value1, value2, "tBannerUdt");
            return (Criteria) this;
        }

        public Criteria andTBannerDeleteIsNull() {
            addCriterion("t_banner_delete is null");
            return (Criteria) this;
        }

        public Criteria andTBannerDeleteIsNotNull() {
            addCriterion("t_banner_delete is not null");
            return (Criteria) this;
        }

        public Criteria andTBannerDeleteEqualTo(Integer value) {
            addCriterion("t_banner_delete =", value, "tBannerDelete");
            return (Criteria) this;
        }

        public Criteria andTBannerDeleteNotEqualTo(Integer value) {
            addCriterion("t_banner_delete <>", value, "tBannerDelete");
            return (Criteria) this;
        }

        public Criteria andTBannerDeleteGreaterThan(Integer value) {
            addCriterion("t_banner_delete >", value, "tBannerDelete");
            return (Criteria) this;
        }

        public Criteria andTBannerDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_banner_delete >=", value, "tBannerDelete");
            return (Criteria) this;
        }

        public Criteria andTBannerDeleteLessThan(Integer value) {
            addCriterion("t_banner_delete <", value, "tBannerDelete");
            return (Criteria) this;
        }

        public Criteria andTBannerDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("t_banner_delete <=", value, "tBannerDelete");
            return (Criteria) this;
        }

        public Criteria andTBannerDeleteIn(List<Integer> values) {
            addCriterion("t_banner_delete in", values, "tBannerDelete");
            return (Criteria) this;
        }

        public Criteria andTBannerDeleteNotIn(List<Integer> values) {
            addCriterion("t_banner_delete not in", values, "tBannerDelete");
            return (Criteria) this;
        }

        public Criteria andTBannerDeleteBetween(Integer value1, Integer value2) {
            addCriterion("t_banner_delete between", value1, value2, "tBannerDelete");
            return (Criteria) this;
        }

        public Criteria andTBannerDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("t_banner_delete not between", value1, value2, "tBannerDelete");
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