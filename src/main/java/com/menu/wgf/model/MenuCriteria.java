package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuCriteria() {
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

        public Criteria andTMenuPkidIsNull() {
            addCriterion("t_menu_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTMenuPkidIsNotNull() {
            addCriterion("t_menu_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTMenuPkidEqualTo(Integer value) {
            addCriterion("t_menu_pkid =", value, "tMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMenuPkidNotEqualTo(Integer value) {
            addCriterion("t_menu_pkid <>", value, "tMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMenuPkidGreaterThan(Integer value) {
            addCriterion("t_menu_pkid >", value, "tMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMenuPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_menu_pkid >=", value, "tMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMenuPkidLessThan(Integer value) {
            addCriterion("t_menu_pkid <", value, "tMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMenuPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_menu_pkid <=", value, "tMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMenuPkidIn(List<Integer> values) {
            addCriterion("t_menu_pkid in", values, "tMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMenuPkidNotIn(List<Integer> values) {
            addCriterion("t_menu_pkid not in", values, "tMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMenuPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_menu_pkid between", value1, value2, "tMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMenuPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_menu_pkid not between", value1, value2, "tMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMenuNameIsNull() {
            addCriterion("t_menu_name is null");
            return (Criteria) this;
        }

        public Criteria andTMenuNameIsNotNull() {
            addCriterion("t_menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andTMenuNameEqualTo(String value) {
            addCriterion("t_menu_name =", value, "tMenuName");
            return (Criteria) this;
        }

        public Criteria andTMenuNameNotEqualTo(String value) {
            addCriterion("t_menu_name <>", value, "tMenuName");
            return (Criteria) this;
        }

        public Criteria andTMenuNameGreaterThan(String value) {
            addCriterion("t_menu_name >", value, "tMenuName");
            return (Criteria) this;
        }

        public Criteria andTMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("t_menu_name >=", value, "tMenuName");
            return (Criteria) this;
        }

        public Criteria andTMenuNameLessThan(String value) {
            addCriterion("t_menu_name <", value, "tMenuName");
            return (Criteria) this;
        }

        public Criteria andTMenuNameLessThanOrEqualTo(String value) {
            addCriterion("t_menu_name <=", value, "tMenuName");
            return (Criteria) this;
        }

        public Criteria andTMenuNameLike(String value) {
            addCriterion("t_menu_name like", value, "tMenuName");
            return (Criteria) this;
        }

        public Criteria andTMenuNameNotLike(String value) {
            addCriterion("t_menu_name not like", value, "tMenuName");
            return (Criteria) this;
        }

        public Criteria andTMenuNameIn(List<String> values) {
            addCriterion("t_menu_name in", values, "tMenuName");
            return (Criteria) this;
        }

        public Criteria andTMenuNameNotIn(List<String> values) {
            addCriterion("t_menu_name not in", values, "tMenuName");
            return (Criteria) this;
        }

        public Criteria andTMenuNameBetween(String value1, String value2) {
            addCriterion("t_menu_name between", value1, value2, "tMenuName");
            return (Criteria) this;
        }

        public Criteria andTMenuNameNotBetween(String value1, String value2) {
            addCriterion("t_menu_name not between", value1, value2, "tMenuName");
            return (Criteria) this;
        }

        public Criteria andTMenuTypeIsNull() {
            addCriterion("t_menu_type is null");
            return (Criteria) this;
        }

        public Criteria andTMenuTypeIsNotNull() {
            addCriterion("t_menu_type is not null");
            return (Criteria) this;
        }

        public Criteria andTMenuTypeEqualTo(Integer value) {
            addCriterion("t_menu_type =", value, "tMenuType");
            return (Criteria) this;
        }

        public Criteria andTMenuTypeNotEqualTo(Integer value) {
            addCriterion("t_menu_type <>", value, "tMenuType");
            return (Criteria) this;
        }

        public Criteria andTMenuTypeGreaterThan(Integer value) {
            addCriterion("t_menu_type >", value, "tMenuType");
            return (Criteria) this;
        }

        public Criteria andTMenuTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_menu_type >=", value, "tMenuType");
            return (Criteria) this;
        }

        public Criteria andTMenuTypeLessThan(Integer value) {
            addCriterion("t_menu_type <", value, "tMenuType");
            return (Criteria) this;
        }

        public Criteria andTMenuTypeLessThanOrEqualTo(Integer value) {
            addCriterion("t_menu_type <=", value, "tMenuType");
            return (Criteria) this;
        }

        public Criteria andTMenuTypeIn(List<Integer> values) {
            addCriterion("t_menu_type in", values, "tMenuType");
            return (Criteria) this;
        }

        public Criteria andTMenuTypeNotIn(List<Integer> values) {
            addCriterion("t_menu_type not in", values, "tMenuType");
            return (Criteria) this;
        }

        public Criteria andTMenuTypeBetween(Integer value1, Integer value2) {
            addCriterion("t_menu_type between", value1, value2, "tMenuType");
            return (Criteria) this;
        }

        public Criteria andTMenuTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("t_menu_type not between", value1, value2, "tMenuType");
            return (Criteria) this;
        }

        public Criteria andTMenuDeleteIsNull() {
            addCriterion("t_menu_delete is null");
            return (Criteria) this;
        }

        public Criteria andTMenuDeleteIsNotNull() {
            addCriterion("t_menu_delete is not null");
            return (Criteria) this;
        }

        public Criteria andTMenuDeleteEqualTo(Integer value) {
            addCriterion("t_menu_delete =", value, "tMenuDelete");
            return (Criteria) this;
        }

        public Criteria andTMenuDeleteNotEqualTo(Integer value) {
            addCriterion("t_menu_delete <>", value, "tMenuDelete");
            return (Criteria) this;
        }

        public Criteria andTMenuDeleteGreaterThan(Integer value) {
            addCriterion("t_menu_delete >", value, "tMenuDelete");
            return (Criteria) this;
        }

        public Criteria andTMenuDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_menu_delete >=", value, "tMenuDelete");
            return (Criteria) this;
        }

        public Criteria andTMenuDeleteLessThan(Integer value) {
            addCriterion("t_menu_delete <", value, "tMenuDelete");
            return (Criteria) this;
        }

        public Criteria andTMenuDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("t_menu_delete <=", value, "tMenuDelete");
            return (Criteria) this;
        }

        public Criteria andTMenuDeleteIn(List<Integer> values) {
            addCriterion("t_menu_delete in", values, "tMenuDelete");
            return (Criteria) this;
        }

        public Criteria andTMenuDeleteNotIn(List<Integer> values) {
            addCriterion("t_menu_delete not in", values, "tMenuDelete");
            return (Criteria) this;
        }

        public Criteria andTMenuDeleteBetween(Integer value1, Integer value2) {
            addCriterion("t_menu_delete between", value1, value2, "tMenuDelete");
            return (Criteria) this;
        }

        public Criteria andTMenuDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("t_menu_delete not between", value1, value2, "tMenuDelete");
            return (Criteria) this;
        }

        public Criteria andTMenuUdtIsNull() {
            addCriterion("t_menu_udt is null");
            return (Criteria) this;
        }

        public Criteria andTMenuUdtIsNotNull() {
            addCriterion("t_menu_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTMenuUdtEqualTo(Date value) {
            addCriterion("t_menu_udt =", value, "tMenuUdt");
            return (Criteria) this;
        }

        public Criteria andTMenuUdtNotEqualTo(Date value) {
            addCriterion("t_menu_udt <>", value, "tMenuUdt");
            return (Criteria) this;
        }

        public Criteria andTMenuUdtGreaterThan(Date value) {
            addCriterion("t_menu_udt >", value, "tMenuUdt");
            return (Criteria) this;
        }

        public Criteria andTMenuUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_menu_udt >=", value, "tMenuUdt");
            return (Criteria) this;
        }

        public Criteria andTMenuUdtLessThan(Date value) {
            addCriterion("t_menu_udt <", value, "tMenuUdt");
            return (Criteria) this;
        }

        public Criteria andTMenuUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_menu_udt <=", value, "tMenuUdt");
            return (Criteria) this;
        }

        public Criteria andTMenuUdtIn(List<Date> values) {
            addCriterion("t_menu_udt in", values, "tMenuUdt");
            return (Criteria) this;
        }

        public Criteria andTMenuUdtNotIn(List<Date> values) {
            addCriterion("t_menu_udt not in", values, "tMenuUdt");
            return (Criteria) this;
        }

        public Criteria andTMenuUdtBetween(Date value1, Date value2) {
            addCriterion("t_menu_udt between", value1, value2, "tMenuUdt");
            return (Criteria) this;
        }

        public Criteria andTMenuUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_menu_udt not between", value1, value2, "tMenuUdt");
            return (Criteria) this;
        }

        public Criteria andTMenuCdtIsNull() {
            addCriterion("t_menu_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTMenuCdtIsNotNull() {
            addCriterion("t_menu_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTMenuCdtEqualTo(Date value) {
            addCriterion("t_menu_cdt =", value, "tMenuCdt");
            return (Criteria) this;
        }

        public Criteria andTMenuCdtNotEqualTo(Date value) {
            addCriterion("t_menu_cdt <>", value, "tMenuCdt");
            return (Criteria) this;
        }

        public Criteria andTMenuCdtGreaterThan(Date value) {
            addCriterion("t_menu_cdt >", value, "tMenuCdt");
            return (Criteria) this;
        }

        public Criteria andTMenuCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_menu_cdt >=", value, "tMenuCdt");
            return (Criteria) this;
        }

        public Criteria andTMenuCdtLessThan(Date value) {
            addCriterion("t_menu_cdt <", value, "tMenuCdt");
            return (Criteria) this;
        }

        public Criteria andTMenuCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_menu_cdt <=", value, "tMenuCdt");
            return (Criteria) this;
        }

        public Criteria andTMenuCdtIn(List<Date> values) {
            addCriterion("t_menu_cdt in", values, "tMenuCdt");
            return (Criteria) this;
        }

        public Criteria andTMenuCdtNotIn(List<Date> values) {
            addCriterion("t_menu_cdt not in", values, "tMenuCdt");
            return (Criteria) this;
        }

        public Criteria andTMenuCdtBetween(Date value1, Date value2) {
            addCriterion("t_menu_cdt between", value1, value2, "tMenuCdt");
            return (Criteria) this;
        }

        public Criteria andTMenuCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_menu_cdt not between", value1, value2, "tMenuCdt");
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