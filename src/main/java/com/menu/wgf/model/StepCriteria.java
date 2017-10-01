package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StepCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StepCriteria() {
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

        public Criteria andTStepPkidIsNull() {
            addCriterion("t_step_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTStepPkidIsNotNull() {
            addCriterion("t_step_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTStepPkidEqualTo(Integer value) {
            addCriterion("t_step_pkid =", value, "tStepPkid");
            return (Criteria) this;
        }

        public Criteria andTStepPkidNotEqualTo(Integer value) {
            addCriterion("t_step_pkid <>", value, "tStepPkid");
            return (Criteria) this;
        }

        public Criteria andTStepPkidGreaterThan(Integer value) {
            addCriterion("t_step_pkid >", value, "tStepPkid");
            return (Criteria) this;
        }

        public Criteria andTStepPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_step_pkid >=", value, "tStepPkid");
            return (Criteria) this;
        }

        public Criteria andTStepPkidLessThan(Integer value) {
            addCriterion("t_step_pkid <", value, "tStepPkid");
            return (Criteria) this;
        }

        public Criteria andTStepPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_step_pkid <=", value, "tStepPkid");
            return (Criteria) this;
        }

        public Criteria andTStepPkidIn(List<Integer> values) {
            addCriterion("t_step_pkid in", values, "tStepPkid");
            return (Criteria) this;
        }

        public Criteria andTStepPkidNotIn(List<Integer> values) {
            addCriterion("t_step_pkid not in", values, "tStepPkid");
            return (Criteria) this;
        }

        public Criteria andTStepPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_step_pkid between", value1, value2, "tStepPkid");
            return (Criteria) this;
        }

        public Criteria andTStepPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_step_pkid not between", value1, value2, "tStepPkid");
            return (Criteria) this;
        }

        public Criteria andTStepMenuPkidIsNull() {
            addCriterion("t_step_menu_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTStepMenuPkidIsNotNull() {
            addCriterion("t_step_menu_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTStepMenuPkidEqualTo(Integer value) {
            addCriterion("t_step_menu_pkid =", value, "tStepMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTStepMenuPkidNotEqualTo(Integer value) {
            addCriterion("t_step_menu_pkid <>", value, "tStepMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTStepMenuPkidGreaterThan(Integer value) {
            addCriterion("t_step_menu_pkid >", value, "tStepMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTStepMenuPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_step_menu_pkid >=", value, "tStepMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTStepMenuPkidLessThan(Integer value) {
            addCriterion("t_step_menu_pkid <", value, "tStepMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTStepMenuPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_step_menu_pkid <=", value, "tStepMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTStepMenuPkidIn(List<Integer> values) {
            addCriterion("t_step_menu_pkid in", values, "tStepMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTStepMenuPkidNotIn(List<Integer> values) {
            addCriterion("t_step_menu_pkid not in", values, "tStepMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTStepMenuPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_step_menu_pkid between", value1, value2, "tStepMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTStepMenuPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_step_menu_pkid not between", value1, value2, "tStepMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTStepPicAddressIsNull() {
            addCriterion("t_step_pic_address is null");
            return (Criteria) this;
        }

        public Criteria andTStepPicAddressIsNotNull() {
            addCriterion("t_step_pic_address is not null");
            return (Criteria) this;
        }

        public Criteria andTStepPicAddressEqualTo(String value) {
            addCriterion("t_step_pic_address =", value, "tStepPicAddress");
            return (Criteria) this;
        }

        public Criteria andTStepPicAddressNotEqualTo(String value) {
            addCriterion("t_step_pic_address <>", value, "tStepPicAddress");
            return (Criteria) this;
        }

        public Criteria andTStepPicAddressGreaterThan(String value) {
            addCriterion("t_step_pic_address >", value, "tStepPicAddress");
            return (Criteria) this;
        }

        public Criteria andTStepPicAddressGreaterThanOrEqualTo(String value) {
            addCriterion("t_step_pic_address >=", value, "tStepPicAddress");
            return (Criteria) this;
        }

        public Criteria andTStepPicAddressLessThan(String value) {
            addCriterion("t_step_pic_address <", value, "tStepPicAddress");
            return (Criteria) this;
        }

        public Criteria andTStepPicAddressLessThanOrEqualTo(String value) {
            addCriterion("t_step_pic_address <=", value, "tStepPicAddress");
            return (Criteria) this;
        }

        public Criteria andTStepPicAddressLike(String value) {
            addCriterion("t_step_pic_address like", value, "tStepPicAddress");
            return (Criteria) this;
        }

        public Criteria andTStepPicAddressNotLike(String value) {
            addCriterion("t_step_pic_address not like", value, "tStepPicAddress");
            return (Criteria) this;
        }

        public Criteria andTStepPicAddressIn(List<String> values) {
            addCriterion("t_step_pic_address in", values, "tStepPicAddress");
            return (Criteria) this;
        }

        public Criteria andTStepPicAddressNotIn(List<String> values) {
            addCriterion("t_step_pic_address not in", values, "tStepPicAddress");
            return (Criteria) this;
        }

        public Criteria andTStepPicAddressBetween(String value1, String value2) {
            addCriterion("t_step_pic_address between", value1, value2, "tStepPicAddress");
            return (Criteria) this;
        }

        public Criteria andTStepPicAddressNotBetween(String value1, String value2) {
            addCriterion("t_step_pic_address not between", value1, value2, "tStepPicAddress");
            return (Criteria) this;
        }

        public Criteria andTStepDescriptionIsNull() {
            addCriterion("t_step_description is null");
            return (Criteria) this;
        }

        public Criteria andTStepDescriptionIsNotNull() {
            addCriterion("t_step_description is not null");
            return (Criteria) this;
        }

        public Criteria andTStepDescriptionEqualTo(String value) {
            addCriterion("t_step_description =", value, "tStepDescription");
            return (Criteria) this;
        }

        public Criteria andTStepDescriptionNotEqualTo(String value) {
            addCriterion("t_step_description <>", value, "tStepDescription");
            return (Criteria) this;
        }

        public Criteria andTStepDescriptionGreaterThan(String value) {
            addCriterion("t_step_description >", value, "tStepDescription");
            return (Criteria) this;
        }

        public Criteria andTStepDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("t_step_description >=", value, "tStepDescription");
            return (Criteria) this;
        }

        public Criteria andTStepDescriptionLessThan(String value) {
            addCriterion("t_step_description <", value, "tStepDescription");
            return (Criteria) this;
        }

        public Criteria andTStepDescriptionLessThanOrEqualTo(String value) {
            addCriterion("t_step_description <=", value, "tStepDescription");
            return (Criteria) this;
        }

        public Criteria andTStepDescriptionLike(String value) {
            addCriterion("t_step_description like", value, "tStepDescription");
            return (Criteria) this;
        }

        public Criteria andTStepDescriptionNotLike(String value) {
            addCriterion("t_step_description not like", value, "tStepDescription");
            return (Criteria) this;
        }

        public Criteria andTStepDescriptionIn(List<String> values) {
            addCriterion("t_step_description in", values, "tStepDescription");
            return (Criteria) this;
        }

        public Criteria andTStepDescriptionNotIn(List<String> values) {
            addCriterion("t_step_description not in", values, "tStepDescription");
            return (Criteria) this;
        }

        public Criteria andTStepDescriptionBetween(String value1, String value2) {
            addCriterion("t_step_description between", value1, value2, "tStepDescription");
            return (Criteria) this;
        }

        public Criteria andTStepDescriptionNotBetween(String value1, String value2) {
            addCriterion("t_step_description not between", value1, value2, "tStepDescription");
            return (Criteria) this;
        }

        public Criteria andTStepCdtIsNull() {
            addCriterion("t_step_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTStepCdtIsNotNull() {
            addCriterion("t_step_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTStepCdtEqualTo(Date value) {
            addCriterion("t_step_cdt =", value, "tStepCdt");
            return (Criteria) this;
        }

        public Criteria andTStepCdtNotEqualTo(Date value) {
            addCriterion("t_step_cdt <>", value, "tStepCdt");
            return (Criteria) this;
        }

        public Criteria andTStepCdtGreaterThan(Date value) {
            addCriterion("t_step_cdt >", value, "tStepCdt");
            return (Criteria) this;
        }

        public Criteria andTStepCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_step_cdt >=", value, "tStepCdt");
            return (Criteria) this;
        }

        public Criteria andTStepCdtLessThan(Date value) {
            addCriterion("t_step_cdt <", value, "tStepCdt");
            return (Criteria) this;
        }

        public Criteria andTStepCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_step_cdt <=", value, "tStepCdt");
            return (Criteria) this;
        }

        public Criteria andTStepCdtIn(List<Date> values) {
            addCriterion("t_step_cdt in", values, "tStepCdt");
            return (Criteria) this;
        }

        public Criteria andTStepCdtNotIn(List<Date> values) {
            addCriterion("t_step_cdt not in", values, "tStepCdt");
            return (Criteria) this;
        }

        public Criteria andTStepCdtBetween(Date value1, Date value2) {
            addCriterion("t_step_cdt between", value1, value2, "tStepCdt");
            return (Criteria) this;
        }

        public Criteria andTStepCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_step_cdt not between", value1, value2, "tStepCdt");
            return (Criteria) this;
        }

        public Criteria andTStepUdtIsNull() {
            addCriterion("t_step_udt is null");
            return (Criteria) this;
        }

        public Criteria andTStepUdtIsNotNull() {
            addCriterion("t_step_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTStepUdtEqualTo(Date value) {
            addCriterion("t_step_udt =", value, "tStepUdt");
            return (Criteria) this;
        }

        public Criteria andTStepUdtNotEqualTo(Date value) {
            addCriterion("t_step_udt <>", value, "tStepUdt");
            return (Criteria) this;
        }

        public Criteria andTStepUdtGreaterThan(Date value) {
            addCriterion("t_step_udt >", value, "tStepUdt");
            return (Criteria) this;
        }

        public Criteria andTStepUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_step_udt >=", value, "tStepUdt");
            return (Criteria) this;
        }

        public Criteria andTStepUdtLessThan(Date value) {
            addCriterion("t_step_udt <", value, "tStepUdt");
            return (Criteria) this;
        }

        public Criteria andTStepUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_step_udt <=", value, "tStepUdt");
            return (Criteria) this;
        }

        public Criteria andTStepUdtIn(List<Date> values) {
            addCriterion("t_step_udt in", values, "tStepUdt");
            return (Criteria) this;
        }

        public Criteria andTStepUdtNotIn(List<Date> values) {
            addCriterion("t_step_udt not in", values, "tStepUdt");
            return (Criteria) this;
        }

        public Criteria andTStepUdtBetween(Date value1, Date value2) {
            addCriterion("t_step_udt between", value1, value2, "tStepUdt");
            return (Criteria) this;
        }

        public Criteria andTStepUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_step_udt not between", value1, value2, "tStepUdt");
            return (Criteria) this;
        }

        public Criteria andTStepDeleteIsNull() {
            addCriterion("t_step_delete is null");
            return (Criteria) this;
        }

        public Criteria andTStepDeleteIsNotNull() {
            addCriterion("t_step_delete is not null");
            return (Criteria) this;
        }

        public Criteria andTStepDeleteEqualTo(Integer value) {
            addCriterion("t_step_delete =", value, "tStepDelete");
            return (Criteria) this;
        }

        public Criteria andTStepDeleteNotEqualTo(Integer value) {
            addCriterion("t_step_delete <>", value, "tStepDelete");
            return (Criteria) this;
        }

        public Criteria andTStepDeleteGreaterThan(Integer value) {
            addCriterion("t_step_delete >", value, "tStepDelete");
            return (Criteria) this;
        }

        public Criteria andTStepDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_step_delete >=", value, "tStepDelete");
            return (Criteria) this;
        }

        public Criteria andTStepDeleteLessThan(Integer value) {
            addCriterion("t_step_delete <", value, "tStepDelete");
            return (Criteria) this;
        }

        public Criteria andTStepDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("t_step_delete <=", value, "tStepDelete");
            return (Criteria) this;
        }

        public Criteria andTStepDeleteIn(List<Integer> values) {
            addCriterion("t_step_delete in", values, "tStepDelete");
            return (Criteria) this;
        }

        public Criteria andTStepDeleteNotIn(List<Integer> values) {
            addCriterion("t_step_delete not in", values, "tStepDelete");
            return (Criteria) this;
        }

        public Criteria andTStepDeleteBetween(Integer value1, Integer value2) {
            addCriterion("t_step_delete between", value1, value2, "tStepDelete");
            return (Criteria) this;
        }

        public Criteria andTStepDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("t_step_delete not between", value1, value2, "tStepDelete");
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