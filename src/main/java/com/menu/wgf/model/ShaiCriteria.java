package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShaiCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShaiCriteria() {
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

        public Criteria andTShaiPkidIsNull() {
            addCriterion("t_shai_Pkid is null");
            return (Criteria) this;
        }

        public Criteria andTShaiPkidIsNotNull() {
            addCriterion("t_shai_Pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTShaiPkidEqualTo(Integer value) {
            addCriterion("t_shai_Pkid =", value, "tShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiPkidNotEqualTo(Integer value) {
            addCriterion("t_shai_Pkid <>", value, "tShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiPkidGreaterThan(Integer value) {
            addCriterion("t_shai_Pkid >", value, "tShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_shai_Pkid >=", value, "tShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiPkidLessThan(Integer value) {
            addCriterion("t_shai_Pkid <", value, "tShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_shai_Pkid <=", value, "tShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiPkidIn(List<Integer> values) {
            addCriterion("t_shai_Pkid in", values, "tShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiPkidNotIn(List<Integer> values) {
            addCriterion("t_shai_Pkid not in", values, "tShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_shai_Pkid between", value1, value2, "tShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_shai_Pkid not between", value1, value2, "tShaiPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiUserPkidIsNull() {
            addCriterion("t_shai_user_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTShaiUserPkidIsNotNull() {
            addCriterion("t_shai_user_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTShaiUserPkidEqualTo(Integer value) {
            addCriterion("t_shai_user_pkid =", value, "tShaiUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiUserPkidNotEqualTo(Integer value) {
            addCriterion("t_shai_user_pkid <>", value, "tShaiUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiUserPkidGreaterThan(Integer value) {
            addCriterion("t_shai_user_pkid >", value, "tShaiUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiUserPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_shai_user_pkid >=", value, "tShaiUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiUserPkidLessThan(Integer value) {
            addCriterion("t_shai_user_pkid <", value, "tShaiUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiUserPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_shai_user_pkid <=", value, "tShaiUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiUserPkidIn(List<Integer> values) {
            addCriterion("t_shai_user_pkid in", values, "tShaiUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiUserPkidNotIn(List<Integer> values) {
            addCriterion("t_shai_user_pkid not in", values, "tShaiUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiUserPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_shai_user_pkid between", value1, value2, "tShaiUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiUserPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_shai_user_pkid not between", value1, value2, "tShaiUserPkid");
            return (Criteria) this;
        }

        public Criteria andTShaiPictureAddressIsNull() {
            addCriterion("t_shai_picture_address is null");
            return (Criteria) this;
        }

        public Criteria andTShaiPictureAddressIsNotNull() {
            addCriterion("t_shai_picture_address is not null");
            return (Criteria) this;
        }

        public Criteria andTShaiPictureAddressEqualTo(String value) {
            addCriterion("t_shai_picture_address =", value, "tShaiPictureAddress");
            return (Criteria) this;
        }

        public Criteria andTShaiPictureAddressNotEqualTo(String value) {
            addCriterion("t_shai_picture_address <>", value, "tShaiPictureAddress");
            return (Criteria) this;
        }

        public Criteria andTShaiPictureAddressGreaterThan(String value) {
            addCriterion("t_shai_picture_address >", value, "tShaiPictureAddress");
            return (Criteria) this;
        }

        public Criteria andTShaiPictureAddressGreaterThanOrEqualTo(String value) {
            addCriterion("t_shai_picture_address >=", value, "tShaiPictureAddress");
            return (Criteria) this;
        }

        public Criteria andTShaiPictureAddressLessThan(String value) {
            addCriterion("t_shai_picture_address <", value, "tShaiPictureAddress");
            return (Criteria) this;
        }

        public Criteria andTShaiPictureAddressLessThanOrEqualTo(String value) {
            addCriterion("t_shai_picture_address <=", value, "tShaiPictureAddress");
            return (Criteria) this;
        }

        public Criteria andTShaiPictureAddressLike(String value) {
            addCriterion("t_shai_picture_address like", value, "tShaiPictureAddress");
            return (Criteria) this;
        }

        public Criteria andTShaiPictureAddressNotLike(String value) {
            addCriterion("t_shai_picture_address not like", value, "tShaiPictureAddress");
            return (Criteria) this;
        }

        public Criteria andTShaiPictureAddressIn(List<String> values) {
            addCriterion("t_shai_picture_address in", values, "tShaiPictureAddress");
            return (Criteria) this;
        }

        public Criteria andTShaiPictureAddressNotIn(List<String> values) {
            addCriterion("t_shai_picture_address not in", values, "tShaiPictureAddress");
            return (Criteria) this;
        }

        public Criteria andTShaiPictureAddressBetween(String value1, String value2) {
            addCriterion("t_shai_picture_address between", value1, value2, "tShaiPictureAddress");
            return (Criteria) this;
        }

        public Criteria andTShaiPictureAddressNotBetween(String value1, String value2) {
            addCriterion("t_shai_picture_address not between", value1, value2, "tShaiPictureAddress");
            return (Criteria) this;
        }

        public Criteria andTShaiDescIsNull() {
            addCriterion("t_shai_desc is null");
            return (Criteria) this;
        }

        public Criteria andTShaiDescIsNotNull() {
            addCriterion("t_shai_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTShaiDescEqualTo(String value) {
            addCriterion("t_shai_desc =", value, "tShaiDesc");
            return (Criteria) this;
        }

        public Criteria andTShaiDescNotEqualTo(String value) {
            addCriterion("t_shai_desc <>", value, "tShaiDesc");
            return (Criteria) this;
        }

        public Criteria andTShaiDescGreaterThan(String value) {
            addCriterion("t_shai_desc >", value, "tShaiDesc");
            return (Criteria) this;
        }

        public Criteria andTShaiDescGreaterThanOrEqualTo(String value) {
            addCriterion("t_shai_desc >=", value, "tShaiDesc");
            return (Criteria) this;
        }

        public Criteria andTShaiDescLessThan(String value) {
            addCriterion("t_shai_desc <", value, "tShaiDesc");
            return (Criteria) this;
        }

        public Criteria andTShaiDescLessThanOrEqualTo(String value) {
            addCriterion("t_shai_desc <=", value, "tShaiDesc");
            return (Criteria) this;
        }

        public Criteria andTShaiDescLike(String value) {
            addCriterion("t_shai_desc like", value, "tShaiDesc");
            return (Criteria) this;
        }

        public Criteria andTShaiDescNotLike(String value) {
            addCriterion("t_shai_desc not like", value, "tShaiDesc");
            return (Criteria) this;
        }

        public Criteria andTShaiDescIn(List<String> values) {
            addCriterion("t_shai_desc in", values, "tShaiDesc");
            return (Criteria) this;
        }

        public Criteria andTShaiDescNotIn(List<String> values) {
            addCriterion("t_shai_desc not in", values, "tShaiDesc");
            return (Criteria) this;
        }

        public Criteria andTShaiDescBetween(String value1, String value2) {
            addCriterion("t_shai_desc between", value1, value2, "tShaiDesc");
            return (Criteria) this;
        }

        public Criteria andTShaiDescNotBetween(String value1, String value2) {
            addCriterion("t_shai_desc not between", value1, value2, "tShaiDesc");
            return (Criteria) this;
        }

        public Criteria andTShaiLookIsNull() {
            addCriterion("t_shai_look is null");
            return (Criteria) this;
        }

        public Criteria andTShaiLookIsNotNull() {
            addCriterion("t_shai_look is not null");
            return (Criteria) this;
        }

        public Criteria andTShaiLookEqualTo(Integer value) {
            addCriterion("t_shai_look =", value, "tShaiLook");
            return (Criteria) this;
        }

        public Criteria andTShaiLookNotEqualTo(Integer value) {
            addCriterion("t_shai_look <>", value, "tShaiLook");
            return (Criteria) this;
        }

        public Criteria andTShaiLookGreaterThan(Integer value) {
            addCriterion("t_shai_look >", value, "tShaiLook");
            return (Criteria) this;
        }

        public Criteria andTShaiLookGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_shai_look >=", value, "tShaiLook");
            return (Criteria) this;
        }

        public Criteria andTShaiLookLessThan(Integer value) {
            addCriterion("t_shai_look <", value, "tShaiLook");
            return (Criteria) this;
        }

        public Criteria andTShaiLookLessThanOrEqualTo(Integer value) {
            addCriterion("t_shai_look <=", value, "tShaiLook");
            return (Criteria) this;
        }

        public Criteria andTShaiLookIn(List<Integer> values) {
            addCriterion("t_shai_look in", values, "tShaiLook");
            return (Criteria) this;
        }

        public Criteria andTShaiLookNotIn(List<Integer> values) {
            addCriterion("t_shai_look not in", values, "tShaiLook");
            return (Criteria) this;
        }

        public Criteria andTShaiLookBetween(Integer value1, Integer value2) {
            addCriterion("t_shai_look between", value1, value2, "tShaiLook");
            return (Criteria) this;
        }

        public Criteria andTShaiLookNotBetween(Integer value1, Integer value2) {
            addCriterion("t_shai_look not between", value1, value2, "tShaiLook");
            return (Criteria) this;
        }

        public Criteria andTShaiCdtIsNull() {
            addCriterion("t_shai_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTShaiCdtIsNotNull() {
            addCriterion("t_shai_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTShaiCdtEqualTo(Date value) {
            addCriterion("t_shai_cdt =", value, "tShaiCdt");
            return (Criteria) this;
        }

        public Criteria andTShaiCdtNotEqualTo(Date value) {
            addCriterion("t_shai_cdt <>", value, "tShaiCdt");
            return (Criteria) this;
        }

        public Criteria andTShaiCdtGreaterThan(Date value) {
            addCriterion("t_shai_cdt >", value, "tShaiCdt");
            return (Criteria) this;
        }

        public Criteria andTShaiCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_shai_cdt >=", value, "tShaiCdt");
            return (Criteria) this;
        }

        public Criteria andTShaiCdtLessThan(Date value) {
            addCriterion("t_shai_cdt <", value, "tShaiCdt");
            return (Criteria) this;
        }

        public Criteria andTShaiCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_shai_cdt <=", value, "tShaiCdt");
            return (Criteria) this;
        }

        public Criteria andTShaiCdtIn(List<Date> values) {
            addCriterion("t_shai_cdt in", values, "tShaiCdt");
            return (Criteria) this;
        }

        public Criteria andTShaiCdtNotIn(List<Date> values) {
            addCriterion("t_shai_cdt not in", values, "tShaiCdt");
            return (Criteria) this;
        }

        public Criteria andTShaiCdtBetween(Date value1, Date value2) {
            addCriterion("t_shai_cdt between", value1, value2, "tShaiCdt");
            return (Criteria) this;
        }

        public Criteria andTShaiCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_shai_cdt not between", value1, value2, "tShaiCdt");
            return (Criteria) this;
        }

        public Criteria andTShaiUdtIsNull() {
            addCriterion("t_shai_udt is null");
            return (Criteria) this;
        }

        public Criteria andTShaiUdtIsNotNull() {
            addCriterion("t_shai_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTShaiUdtEqualTo(Date value) {
            addCriterion("t_shai_udt =", value, "tShaiUdt");
            return (Criteria) this;
        }

        public Criteria andTShaiUdtNotEqualTo(Date value) {
            addCriterion("t_shai_udt <>", value, "tShaiUdt");
            return (Criteria) this;
        }

        public Criteria andTShaiUdtGreaterThan(Date value) {
            addCriterion("t_shai_udt >", value, "tShaiUdt");
            return (Criteria) this;
        }

        public Criteria andTShaiUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_shai_udt >=", value, "tShaiUdt");
            return (Criteria) this;
        }

        public Criteria andTShaiUdtLessThan(Date value) {
            addCriterion("t_shai_udt <", value, "tShaiUdt");
            return (Criteria) this;
        }

        public Criteria andTShaiUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_shai_udt <=", value, "tShaiUdt");
            return (Criteria) this;
        }

        public Criteria andTShaiUdtIn(List<Date> values) {
            addCriterion("t_shai_udt in", values, "tShaiUdt");
            return (Criteria) this;
        }

        public Criteria andTShaiUdtNotIn(List<Date> values) {
            addCriterion("t_shai_udt not in", values, "tShaiUdt");
            return (Criteria) this;
        }

        public Criteria andTShaiUdtBetween(Date value1, Date value2) {
            addCriterion("t_shai_udt between", value1, value2, "tShaiUdt");
            return (Criteria) this;
        }

        public Criteria andTShaiUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_shai_udt not between", value1, value2, "tShaiUdt");
            return (Criteria) this;
        }

        public Criteria andTShaiDeleteIsNull() {
            addCriterion("t_shai_delete is null");
            return (Criteria) this;
        }

        public Criteria andTShaiDeleteIsNotNull() {
            addCriterion("t_shai_delete is not null");
            return (Criteria) this;
        }

        public Criteria andTShaiDeleteEqualTo(Integer value) {
            addCriterion("t_shai_delete =", value, "tShaiDelete");
            return (Criteria) this;
        }

        public Criteria andTShaiDeleteNotEqualTo(Integer value) {
            addCriterion("t_shai_delete <>", value, "tShaiDelete");
            return (Criteria) this;
        }

        public Criteria andTShaiDeleteGreaterThan(Integer value) {
            addCriterion("t_shai_delete >", value, "tShaiDelete");
            return (Criteria) this;
        }

        public Criteria andTShaiDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_shai_delete >=", value, "tShaiDelete");
            return (Criteria) this;
        }

        public Criteria andTShaiDeleteLessThan(Integer value) {
            addCriterion("t_shai_delete <", value, "tShaiDelete");
            return (Criteria) this;
        }

        public Criteria andTShaiDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("t_shai_delete <=", value, "tShaiDelete");
            return (Criteria) this;
        }

        public Criteria andTShaiDeleteIn(List<Integer> values) {
            addCriterion("t_shai_delete in", values, "tShaiDelete");
            return (Criteria) this;
        }

        public Criteria andTShaiDeleteNotIn(List<Integer> values) {
            addCriterion("t_shai_delete not in", values, "tShaiDelete");
            return (Criteria) this;
        }

        public Criteria andTShaiDeleteBetween(Integer value1, Integer value2) {
            addCriterion("t_shai_delete between", value1, value2, "tShaiDelete");
            return (Criteria) this;
        }

        public Criteria andTShaiDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("t_shai_delete not between", value1, value2, "tShaiDelete");
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