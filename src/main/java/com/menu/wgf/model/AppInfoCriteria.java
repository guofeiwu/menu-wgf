package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppInfoCriteria() {
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

        public Criteria andTAppPkidIsNull() {
            addCriterion("t_app_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTAppPkidIsNotNull() {
            addCriterion("t_app_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTAppPkidEqualTo(Integer value) {
            addCriterion("t_app_pkid =", value, "tAppPkid");
            return (Criteria) this;
        }

        public Criteria andTAppPkidNotEqualTo(Integer value) {
            addCriterion("t_app_pkid <>", value, "tAppPkid");
            return (Criteria) this;
        }

        public Criteria andTAppPkidGreaterThan(Integer value) {
            addCriterion("t_app_pkid >", value, "tAppPkid");
            return (Criteria) this;
        }

        public Criteria andTAppPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_app_pkid >=", value, "tAppPkid");
            return (Criteria) this;
        }

        public Criteria andTAppPkidLessThan(Integer value) {
            addCriterion("t_app_pkid <", value, "tAppPkid");
            return (Criteria) this;
        }

        public Criteria andTAppPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_app_pkid <=", value, "tAppPkid");
            return (Criteria) this;
        }

        public Criteria andTAppPkidIn(List<Integer> values) {
            addCriterion("t_app_pkid in", values, "tAppPkid");
            return (Criteria) this;
        }

        public Criteria andTAppPkidNotIn(List<Integer> values) {
            addCriterion("t_app_pkid not in", values, "tAppPkid");
            return (Criteria) this;
        }

        public Criteria andTAppPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_app_pkid between", value1, value2, "tAppPkid");
            return (Criteria) this;
        }

        public Criteria andTAppPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_app_pkid not between", value1, value2, "tAppPkid");
            return (Criteria) this;
        }

        public Criteria andTAppVerIsNull() {
            addCriterion("t_app_ver is null");
            return (Criteria) this;
        }

        public Criteria andTAppVerIsNotNull() {
            addCriterion("t_app_ver is not null");
            return (Criteria) this;
        }

        public Criteria andTAppVerEqualTo(Float value) {
            addCriterion("t_app_ver =", value, "tAppVer");
            return (Criteria) this;
        }

        public Criteria andTAppVerNotEqualTo(Float value) {
            addCriterion("t_app_ver <>", value, "tAppVer");
            return (Criteria) this;
        }

        public Criteria andTAppVerGreaterThan(Float value) {
            addCriterion("t_app_ver >", value, "tAppVer");
            return (Criteria) this;
        }

        public Criteria andTAppVerGreaterThanOrEqualTo(Float value) {
            addCriterion("t_app_ver >=", value, "tAppVer");
            return (Criteria) this;
        }

        public Criteria andTAppVerLessThan(Float value) {
            addCriterion("t_app_ver <", value, "tAppVer");
            return (Criteria) this;
        }

        public Criteria andTAppVerLessThanOrEqualTo(Float value) {
            addCriterion("t_app_ver <=", value, "tAppVer");
            return (Criteria) this;
        }

        public Criteria andTAppVerIn(List<Float> values) {
            addCriterion("t_app_ver in", values, "tAppVer");
            return (Criteria) this;
        }

        public Criteria andTAppVerNotIn(List<Float> values) {
            addCriterion("t_app_ver not in", values, "tAppVer");
            return (Criteria) this;
        }

        public Criteria andTAppVerBetween(Float value1, Float value2) {
            addCriterion("t_app_ver between", value1, value2, "tAppVer");
            return (Criteria) this;
        }

        public Criteria andTAppVerNotBetween(Float value1, Float value2) {
            addCriterion("t_app_ver not between", value1, value2, "tAppVer");
            return (Criteria) this;
        }

        public Criteria andTAppDownloadUrlIsNull() {
            addCriterion("t_app_download_url is null");
            return (Criteria) this;
        }

        public Criteria andTAppDownloadUrlIsNotNull() {
            addCriterion("t_app_download_url is not null");
            return (Criteria) this;
        }

        public Criteria andTAppDownloadUrlEqualTo(String value) {
            addCriterion("t_app_download_url =", value, "tAppDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andTAppDownloadUrlNotEqualTo(String value) {
            addCriterion("t_app_download_url <>", value, "tAppDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andTAppDownloadUrlGreaterThan(String value) {
            addCriterion("t_app_download_url >", value, "tAppDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andTAppDownloadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("t_app_download_url >=", value, "tAppDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andTAppDownloadUrlLessThan(String value) {
            addCriterion("t_app_download_url <", value, "tAppDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andTAppDownloadUrlLessThanOrEqualTo(String value) {
            addCriterion("t_app_download_url <=", value, "tAppDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andTAppDownloadUrlLike(String value) {
            addCriterion("t_app_download_url like", value, "tAppDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andTAppDownloadUrlNotLike(String value) {
            addCriterion("t_app_download_url not like", value, "tAppDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andTAppDownloadUrlIn(List<String> values) {
            addCriterion("t_app_download_url in", values, "tAppDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andTAppDownloadUrlNotIn(List<String> values) {
            addCriterion("t_app_download_url not in", values, "tAppDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andTAppDownloadUrlBetween(String value1, String value2) {
            addCriterion("t_app_download_url between", value1, value2, "tAppDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andTAppDownloadUrlNotBetween(String value1, String value2) {
            addCriterion("t_app_download_url not between", value1, value2, "tAppDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andTAppVerDescIsNull() {
            addCriterion("t_app_ver_desc is null");
            return (Criteria) this;
        }

        public Criteria andTAppVerDescIsNotNull() {
            addCriterion("t_app_ver_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTAppVerDescEqualTo(String value) {
            addCriterion("t_app_ver_desc =", value, "tAppVerDesc");
            return (Criteria) this;
        }

        public Criteria andTAppVerDescNotEqualTo(String value) {
            addCriterion("t_app_ver_desc <>", value, "tAppVerDesc");
            return (Criteria) this;
        }

        public Criteria andTAppVerDescGreaterThan(String value) {
            addCriterion("t_app_ver_desc >", value, "tAppVerDesc");
            return (Criteria) this;
        }

        public Criteria andTAppVerDescGreaterThanOrEqualTo(String value) {
            addCriterion("t_app_ver_desc >=", value, "tAppVerDesc");
            return (Criteria) this;
        }

        public Criteria andTAppVerDescLessThan(String value) {
            addCriterion("t_app_ver_desc <", value, "tAppVerDesc");
            return (Criteria) this;
        }

        public Criteria andTAppVerDescLessThanOrEqualTo(String value) {
            addCriterion("t_app_ver_desc <=", value, "tAppVerDesc");
            return (Criteria) this;
        }

        public Criteria andTAppVerDescLike(String value) {
            addCriterion("t_app_ver_desc like", value, "tAppVerDesc");
            return (Criteria) this;
        }

        public Criteria andTAppVerDescNotLike(String value) {
            addCriterion("t_app_ver_desc not like", value, "tAppVerDesc");
            return (Criteria) this;
        }

        public Criteria andTAppVerDescIn(List<String> values) {
            addCriterion("t_app_ver_desc in", values, "tAppVerDesc");
            return (Criteria) this;
        }

        public Criteria andTAppVerDescNotIn(List<String> values) {
            addCriterion("t_app_ver_desc not in", values, "tAppVerDesc");
            return (Criteria) this;
        }

        public Criteria andTAppVerDescBetween(String value1, String value2) {
            addCriterion("t_app_ver_desc between", value1, value2, "tAppVerDesc");
            return (Criteria) this;
        }

        public Criteria andTAppVerDescNotBetween(String value1, String value2) {
            addCriterion("t_app_ver_desc not between", value1, value2, "tAppVerDesc");
            return (Criteria) this;
        }

        public Criteria andTAppCdtIsNull() {
            addCriterion("t_app_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTAppCdtIsNotNull() {
            addCriterion("t_app_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTAppCdtEqualTo(Date value) {
            addCriterion("t_app_cdt =", value, "tAppCdt");
            return (Criteria) this;
        }

        public Criteria andTAppCdtNotEqualTo(Date value) {
            addCriterion("t_app_cdt <>", value, "tAppCdt");
            return (Criteria) this;
        }

        public Criteria andTAppCdtGreaterThan(Date value) {
            addCriterion("t_app_cdt >", value, "tAppCdt");
            return (Criteria) this;
        }

        public Criteria andTAppCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_app_cdt >=", value, "tAppCdt");
            return (Criteria) this;
        }

        public Criteria andTAppCdtLessThan(Date value) {
            addCriterion("t_app_cdt <", value, "tAppCdt");
            return (Criteria) this;
        }

        public Criteria andTAppCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_app_cdt <=", value, "tAppCdt");
            return (Criteria) this;
        }

        public Criteria andTAppCdtIn(List<Date> values) {
            addCriterion("t_app_cdt in", values, "tAppCdt");
            return (Criteria) this;
        }

        public Criteria andTAppCdtNotIn(List<Date> values) {
            addCriterion("t_app_cdt not in", values, "tAppCdt");
            return (Criteria) this;
        }

        public Criteria andTAppCdtBetween(Date value1, Date value2) {
            addCriterion("t_app_cdt between", value1, value2, "tAppCdt");
            return (Criteria) this;
        }

        public Criteria andTAppCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_app_cdt not between", value1, value2, "tAppCdt");
            return (Criteria) this;
        }

        public Criteria andTAppUdtIsNull() {
            addCriterion("t_app_udt is null");
            return (Criteria) this;
        }

        public Criteria andTAppUdtIsNotNull() {
            addCriterion("t_app_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTAppUdtEqualTo(Date value) {
            addCriterion("t_app_udt =", value, "tAppUdt");
            return (Criteria) this;
        }

        public Criteria andTAppUdtNotEqualTo(Date value) {
            addCriterion("t_app_udt <>", value, "tAppUdt");
            return (Criteria) this;
        }

        public Criteria andTAppUdtGreaterThan(Date value) {
            addCriterion("t_app_udt >", value, "tAppUdt");
            return (Criteria) this;
        }

        public Criteria andTAppUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_app_udt >=", value, "tAppUdt");
            return (Criteria) this;
        }

        public Criteria andTAppUdtLessThan(Date value) {
            addCriterion("t_app_udt <", value, "tAppUdt");
            return (Criteria) this;
        }

        public Criteria andTAppUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_app_udt <=", value, "tAppUdt");
            return (Criteria) this;
        }

        public Criteria andTAppUdtIn(List<Date> values) {
            addCriterion("t_app_udt in", values, "tAppUdt");
            return (Criteria) this;
        }

        public Criteria andTAppUdtNotIn(List<Date> values) {
            addCriterion("t_app_udt not in", values, "tAppUdt");
            return (Criteria) this;
        }

        public Criteria andTAppUdtBetween(Date value1, Date value2) {
            addCriterion("t_app_udt between", value1, value2, "tAppUdt");
            return (Criteria) this;
        }

        public Criteria andTAppUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_app_udt not between", value1, value2, "tAppUdt");
            return (Criteria) this;
        }

        public Criteria andTAppDeleteIsNull() {
            addCriterion("t_app_delete is null");
            return (Criteria) this;
        }

        public Criteria andTAppDeleteIsNotNull() {
            addCriterion("t_app_delete is not null");
            return (Criteria) this;
        }

        public Criteria andTAppDeleteEqualTo(Integer value) {
            addCriterion("t_app_delete =", value, "tAppDelete");
            return (Criteria) this;
        }

        public Criteria andTAppDeleteNotEqualTo(Integer value) {
            addCriterion("t_app_delete <>", value, "tAppDelete");
            return (Criteria) this;
        }

        public Criteria andTAppDeleteGreaterThan(Integer value) {
            addCriterion("t_app_delete >", value, "tAppDelete");
            return (Criteria) this;
        }

        public Criteria andTAppDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_app_delete >=", value, "tAppDelete");
            return (Criteria) this;
        }

        public Criteria andTAppDeleteLessThan(Integer value) {
            addCriterion("t_app_delete <", value, "tAppDelete");
            return (Criteria) this;
        }

        public Criteria andTAppDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("t_app_delete <=", value, "tAppDelete");
            return (Criteria) this;
        }

        public Criteria andTAppDeleteIn(List<Integer> values) {
            addCriterion("t_app_delete in", values, "tAppDelete");
            return (Criteria) this;
        }

        public Criteria andTAppDeleteNotIn(List<Integer> values) {
            addCriterion("t_app_delete not in", values, "tAppDelete");
            return (Criteria) this;
        }

        public Criteria andTAppDeleteBetween(Integer value1, Integer value2) {
            addCriterion("t_app_delete between", value1, value2, "tAppDelete");
            return (Criteria) this;
        }

        public Criteria andTAppDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("t_app_delete not between", value1, value2, "tAppDelete");
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