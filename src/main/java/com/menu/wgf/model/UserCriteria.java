package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserCriteria() {
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

        public Criteria andTUserPkidIsNull() {
            addCriterion("t_user_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTUserPkidIsNotNull() {
            addCriterion("t_user_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTUserPkidEqualTo(Integer value) {
            addCriterion("t_user_pkid =", value, "tUserPkid");
            return (Criteria) this;
        }

        public Criteria andTUserPkidNotEqualTo(Integer value) {
            addCriterion("t_user_pkid <>", value, "tUserPkid");
            return (Criteria) this;
        }

        public Criteria andTUserPkidGreaterThan(Integer value) {
            addCriterion("t_user_pkid >", value, "tUserPkid");
            return (Criteria) this;
        }

        public Criteria andTUserPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_user_pkid >=", value, "tUserPkid");
            return (Criteria) this;
        }

        public Criteria andTUserPkidLessThan(Integer value) {
            addCriterion("t_user_pkid <", value, "tUserPkid");
            return (Criteria) this;
        }

        public Criteria andTUserPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_user_pkid <=", value, "tUserPkid");
            return (Criteria) this;
        }

        public Criteria andTUserPkidIn(List<Integer> values) {
            addCriterion("t_user_pkid in", values, "tUserPkid");
            return (Criteria) this;
        }

        public Criteria andTUserPkidNotIn(List<Integer> values) {
            addCriterion("t_user_pkid not in", values, "tUserPkid");
            return (Criteria) this;
        }

        public Criteria andTUserPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_user_pkid between", value1, value2, "tUserPkid");
            return (Criteria) this;
        }

        public Criteria andTUserPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_user_pkid not between", value1, value2, "tUserPkid");
            return (Criteria) this;
        }

        public Criteria andTUserNameIsNull() {
            addCriterion("t_user_name is null");
            return (Criteria) this;
        }

        public Criteria andTUserNameIsNotNull() {
            addCriterion("t_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andTUserNameEqualTo(String value) {
            addCriterion("t_user_name =", value, "tUserName");
            return (Criteria) this;
        }

        public Criteria andTUserNameNotEqualTo(String value) {
            addCriterion("t_user_name <>", value, "tUserName");
            return (Criteria) this;
        }

        public Criteria andTUserNameGreaterThan(String value) {
            addCriterion("t_user_name >", value, "tUserName");
            return (Criteria) this;
        }

        public Criteria andTUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("t_user_name >=", value, "tUserName");
            return (Criteria) this;
        }

        public Criteria andTUserNameLessThan(String value) {
            addCriterion("t_user_name <", value, "tUserName");
            return (Criteria) this;
        }

        public Criteria andTUserNameLessThanOrEqualTo(String value) {
            addCriterion("t_user_name <=", value, "tUserName");
            return (Criteria) this;
        }

        public Criteria andTUserNameLike(String value) {
            addCriterion("t_user_name like", value, "tUserName");
            return (Criteria) this;
        }

        public Criteria andTUserNameNotLike(String value) {
            addCriterion("t_user_name not like", value, "tUserName");
            return (Criteria) this;
        }

        public Criteria andTUserNameIn(List<String> values) {
            addCriterion("t_user_name in", values, "tUserName");
            return (Criteria) this;
        }

        public Criteria andTUserNameNotIn(List<String> values) {
            addCriterion("t_user_name not in", values, "tUserName");
            return (Criteria) this;
        }

        public Criteria andTUserNameBetween(String value1, String value2) {
            addCriterion("t_user_name between", value1, value2, "tUserName");
            return (Criteria) this;
        }

        public Criteria andTUserNameNotBetween(String value1, String value2) {
            addCriterion("t_user_name not between", value1, value2, "tUserName");
            return (Criteria) this;
        }

        public Criteria andTUserSexIsNull() {
            addCriterion("t_user_sex is null");
            return (Criteria) this;
        }

        public Criteria andTUserSexIsNotNull() {
            addCriterion("t_user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andTUserSexEqualTo(Integer value) {
            addCriterion("t_user_sex =", value, "tUserSex");
            return (Criteria) this;
        }

        public Criteria andTUserSexNotEqualTo(Integer value) {
            addCriterion("t_user_sex <>", value, "tUserSex");
            return (Criteria) this;
        }

        public Criteria andTUserSexGreaterThan(Integer value) {
            addCriterion("t_user_sex >", value, "tUserSex");
            return (Criteria) this;
        }

        public Criteria andTUserSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_user_sex >=", value, "tUserSex");
            return (Criteria) this;
        }

        public Criteria andTUserSexLessThan(Integer value) {
            addCriterion("t_user_sex <", value, "tUserSex");
            return (Criteria) this;
        }

        public Criteria andTUserSexLessThanOrEqualTo(Integer value) {
            addCriterion("t_user_sex <=", value, "tUserSex");
            return (Criteria) this;
        }

        public Criteria andTUserSexIn(List<Integer> values) {
            addCriterion("t_user_sex in", values, "tUserSex");
            return (Criteria) this;
        }

        public Criteria andTUserSexNotIn(List<Integer> values) {
            addCriterion("t_user_sex not in", values, "tUserSex");
            return (Criteria) this;
        }

        public Criteria andTUserSexBetween(Integer value1, Integer value2) {
            addCriterion("t_user_sex between", value1, value2, "tUserSex");
            return (Criteria) this;
        }

        public Criteria andTUserSexNotBetween(Integer value1, Integer value2) {
            addCriterion("t_user_sex not between", value1, value2, "tUserSex");
            return (Criteria) this;
        }

        public Criteria andTUserBirthdayIsNull() {
            addCriterion("t_user_birthday is null");
            return (Criteria) this;
        }

        public Criteria andTUserBirthdayIsNotNull() {
            addCriterion("t_user_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andTUserBirthdayEqualTo(String value) {
            addCriterion("t_user_birthday =", value, "tUserBirthday");
            return (Criteria) this;
        }

        public Criteria andTUserBirthdayNotEqualTo(String value) {
            addCriterion("t_user_birthday <>", value, "tUserBirthday");
            return (Criteria) this;
        }

        public Criteria andTUserBirthdayGreaterThan(String value) {
            addCriterion("t_user_birthday >", value, "tUserBirthday");
            return (Criteria) this;
        }

        public Criteria andTUserBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("t_user_birthday >=", value, "tUserBirthday");
            return (Criteria) this;
        }

        public Criteria andTUserBirthdayLessThan(String value) {
            addCriterion("t_user_birthday <", value, "tUserBirthday");
            return (Criteria) this;
        }

        public Criteria andTUserBirthdayLessThanOrEqualTo(String value) {
            addCriterion("t_user_birthday <=", value, "tUserBirthday");
            return (Criteria) this;
        }

        public Criteria andTUserBirthdayLike(String value) {
            addCriterion("t_user_birthday like", value, "tUserBirthday");
            return (Criteria) this;
        }

        public Criteria andTUserBirthdayNotLike(String value) {
            addCriterion("t_user_birthday not like", value, "tUserBirthday");
            return (Criteria) this;
        }

        public Criteria andTUserBirthdayIn(List<String> values) {
            addCriterion("t_user_birthday in", values, "tUserBirthday");
            return (Criteria) this;
        }

        public Criteria andTUserBirthdayNotIn(List<String> values) {
            addCriterion("t_user_birthday not in", values, "tUserBirthday");
            return (Criteria) this;
        }

        public Criteria andTUserBirthdayBetween(String value1, String value2) {
            addCriterion("t_user_birthday between", value1, value2, "tUserBirthday");
            return (Criteria) this;
        }

        public Criteria andTUserBirthdayNotBetween(String value1, String value2) {
            addCriterion("t_user_birthday not between", value1, value2, "tUserBirthday");
            return (Criteria) this;
        }

        public Criteria andTUserIconIsNull() {
            addCriterion("t_user_icon is null");
            return (Criteria) this;
        }

        public Criteria andTUserIconIsNotNull() {
            addCriterion("t_user_icon is not null");
            return (Criteria) this;
        }

        public Criteria andTUserIconEqualTo(String value) {
            addCriterion("t_user_icon =", value, "tUserIcon");
            return (Criteria) this;
        }

        public Criteria andTUserIconNotEqualTo(String value) {
            addCriterion("t_user_icon <>", value, "tUserIcon");
            return (Criteria) this;
        }

        public Criteria andTUserIconGreaterThan(String value) {
            addCriterion("t_user_icon >", value, "tUserIcon");
            return (Criteria) this;
        }

        public Criteria andTUserIconGreaterThanOrEqualTo(String value) {
            addCriterion("t_user_icon >=", value, "tUserIcon");
            return (Criteria) this;
        }

        public Criteria andTUserIconLessThan(String value) {
            addCriterion("t_user_icon <", value, "tUserIcon");
            return (Criteria) this;
        }

        public Criteria andTUserIconLessThanOrEqualTo(String value) {
            addCriterion("t_user_icon <=", value, "tUserIcon");
            return (Criteria) this;
        }

        public Criteria andTUserIconLike(String value) {
            addCriterion("t_user_icon like", value, "tUserIcon");
            return (Criteria) this;
        }

        public Criteria andTUserIconNotLike(String value) {
            addCriterion("t_user_icon not like", value, "tUserIcon");
            return (Criteria) this;
        }

        public Criteria andTUserIconIn(List<String> values) {
            addCriterion("t_user_icon in", values, "tUserIcon");
            return (Criteria) this;
        }

        public Criteria andTUserIconNotIn(List<String> values) {
            addCriterion("t_user_icon not in", values, "tUserIcon");
            return (Criteria) this;
        }

        public Criteria andTUserIconBetween(String value1, String value2) {
            addCriterion("t_user_icon between", value1, value2, "tUserIcon");
            return (Criteria) this;
        }

        public Criteria andTUserIconNotBetween(String value1, String value2) {
            addCriterion("t_user_icon not between", value1, value2, "tUserIcon");
            return (Criteria) this;
        }

        public Criteria andTUserUdtIsNull() {
            addCriterion("t_user_udt is null");
            return (Criteria) this;
        }

        public Criteria andTUserUdtIsNotNull() {
            addCriterion("t_user_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTUserUdtEqualTo(Date value) {
            addCriterion("t_user_udt =", value, "tUserUdt");
            return (Criteria) this;
        }

        public Criteria andTUserUdtNotEqualTo(Date value) {
            addCriterion("t_user_udt <>", value, "tUserUdt");
            return (Criteria) this;
        }

        public Criteria andTUserUdtGreaterThan(Date value) {
            addCriterion("t_user_udt >", value, "tUserUdt");
            return (Criteria) this;
        }

        public Criteria andTUserUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_user_udt >=", value, "tUserUdt");
            return (Criteria) this;
        }

        public Criteria andTUserUdtLessThan(Date value) {
            addCriterion("t_user_udt <", value, "tUserUdt");
            return (Criteria) this;
        }

        public Criteria andTUserUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_user_udt <=", value, "tUserUdt");
            return (Criteria) this;
        }

        public Criteria andTUserUdtIn(List<Date> values) {
            addCriterion("t_user_udt in", values, "tUserUdt");
            return (Criteria) this;
        }

        public Criteria andTUserUdtNotIn(List<Date> values) {
            addCriterion("t_user_udt not in", values, "tUserUdt");
            return (Criteria) this;
        }

        public Criteria andTUserUdtBetween(Date value1, Date value2) {
            addCriterion("t_user_udt between", value1, value2, "tUserUdt");
            return (Criteria) this;
        }

        public Criteria andTUserUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_user_udt not between", value1, value2, "tUserUdt");
            return (Criteria) this;
        }

        public Criteria andTUserCdtIsNull() {
            addCriterion("t_user_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTUserCdtIsNotNull() {
            addCriterion("t_user_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTUserCdtEqualTo(Date value) {
            addCriterion("t_user_cdt =", value, "tUserCdt");
            return (Criteria) this;
        }

        public Criteria andTUserCdtNotEqualTo(Date value) {
            addCriterion("t_user_cdt <>", value, "tUserCdt");
            return (Criteria) this;
        }

        public Criteria andTUserCdtGreaterThan(Date value) {
            addCriterion("t_user_cdt >", value, "tUserCdt");
            return (Criteria) this;
        }

        public Criteria andTUserCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_user_cdt >=", value, "tUserCdt");
            return (Criteria) this;
        }

        public Criteria andTUserCdtLessThan(Date value) {
            addCriterion("t_user_cdt <", value, "tUserCdt");
            return (Criteria) this;
        }

        public Criteria andTUserCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_user_cdt <=", value, "tUserCdt");
            return (Criteria) this;
        }

        public Criteria andTUserCdtIn(List<Date> values) {
            addCriterion("t_user_cdt in", values, "tUserCdt");
            return (Criteria) this;
        }

        public Criteria andTUserCdtNotIn(List<Date> values) {
            addCriterion("t_user_cdt not in", values, "tUserCdt");
            return (Criteria) this;
        }

        public Criteria andTUserCdtBetween(Date value1, Date value2) {
            addCriterion("t_user_cdt between", value1, value2, "tUserCdt");
            return (Criteria) this;
        }

        public Criteria andTUserCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_user_cdt not between", value1, value2, "tUserCdt");
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