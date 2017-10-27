package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThematicCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ThematicCriteria() {
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

        public Criteria andTThematicPkidIsNull() {
            addCriterion("t_thematic_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTThematicPkidIsNotNull() {
            addCriterion("t_thematic_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTThematicPkidEqualTo(Integer value) {
            addCriterion("t_thematic_pkid =", value, "tThematicPkid");
            return (Criteria) this;
        }

        public Criteria andTThematicPkidNotEqualTo(Integer value) {
            addCriterion("t_thematic_pkid <>", value, "tThematicPkid");
            return (Criteria) this;
        }

        public Criteria andTThematicPkidGreaterThan(Integer value) {
            addCriterion("t_thematic_pkid >", value, "tThematicPkid");
            return (Criteria) this;
        }

        public Criteria andTThematicPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_thematic_pkid >=", value, "tThematicPkid");
            return (Criteria) this;
        }

        public Criteria andTThematicPkidLessThan(Integer value) {
            addCriterion("t_thematic_pkid <", value, "tThematicPkid");
            return (Criteria) this;
        }

        public Criteria andTThematicPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_thematic_pkid <=", value, "tThematicPkid");
            return (Criteria) this;
        }

        public Criteria andTThematicPkidIn(List<Integer> values) {
            addCriterion("t_thematic_pkid in", values, "tThematicPkid");
            return (Criteria) this;
        }

        public Criteria andTThematicPkidNotIn(List<Integer> values) {
            addCriterion("t_thematic_pkid not in", values, "tThematicPkid");
            return (Criteria) this;
        }

        public Criteria andTThematicPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_thematic_pkid between", value1, value2, "tThematicPkid");
            return (Criteria) this;
        }

        public Criteria andTThematicPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_thematic_pkid not between", value1, value2, "tThematicPkid");
            return (Criteria) this;
        }

        public Criteria andTThematicPictureUrlIsNull() {
            addCriterion("t_thematic_picture_url is null");
            return (Criteria) this;
        }

        public Criteria andTThematicPictureUrlIsNotNull() {
            addCriterion("t_thematic_picture_url is not null");
            return (Criteria) this;
        }

        public Criteria andTThematicPictureUrlEqualTo(String value) {
            addCriterion("t_thematic_picture_url =", value, "tThematicPictureUrl");
            return (Criteria) this;
        }

        public Criteria andTThematicPictureUrlNotEqualTo(String value) {
            addCriterion("t_thematic_picture_url <>", value, "tThematicPictureUrl");
            return (Criteria) this;
        }

        public Criteria andTThematicPictureUrlGreaterThan(String value) {
            addCriterion("t_thematic_picture_url >", value, "tThematicPictureUrl");
            return (Criteria) this;
        }

        public Criteria andTThematicPictureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("t_thematic_picture_url >=", value, "tThematicPictureUrl");
            return (Criteria) this;
        }

        public Criteria andTThematicPictureUrlLessThan(String value) {
            addCriterion("t_thematic_picture_url <", value, "tThematicPictureUrl");
            return (Criteria) this;
        }

        public Criteria andTThematicPictureUrlLessThanOrEqualTo(String value) {
            addCriterion("t_thematic_picture_url <=", value, "tThematicPictureUrl");
            return (Criteria) this;
        }

        public Criteria andTThematicPictureUrlLike(String value) {
            addCriterion("t_thematic_picture_url like", value, "tThematicPictureUrl");
            return (Criteria) this;
        }

        public Criteria andTThematicPictureUrlNotLike(String value) {
            addCriterion("t_thematic_picture_url not like", value, "tThematicPictureUrl");
            return (Criteria) this;
        }

        public Criteria andTThematicPictureUrlIn(List<String> values) {
            addCriterion("t_thematic_picture_url in", values, "tThematicPictureUrl");
            return (Criteria) this;
        }

        public Criteria andTThematicPictureUrlNotIn(List<String> values) {
            addCriterion("t_thematic_picture_url not in", values, "tThematicPictureUrl");
            return (Criteria) this;
        }

        public Criteria andTThematicPictureUrlBetween(String value1, String value2) {
            addCriterion("t_thematic_picture_url between", value1, value2, "tThematicPictureUrl");
            return (Criteria) this;
        }

        public Criteria andTThematicPictureUrlNotBetween(String value1, String value2) {
            addCriterion("t_thematic_picture_url not between", value1, value2, "tThematicPictureUrl");
            return (Criteria) this;
        }

        public Criteria andTThematicNameIsNull() {
            addCriterion("t_thematic_name is null");
            return (Criteria) this;
        }

        public Criteria andTThematicNameIsNotNull() {
            addCriterion("t_thematic_name is not null");
            return (Criteria) this;
        }

        public Criteria andTThematicNameEqualTo(String value) {
            addCriterion("t_thematic_name =", value, "tThematicName");
            return (Criteria) this;
        }

        public Criteria andTThematicNameNotEqualTo(String value) {
            addCriterion("t_thematic_name <>", value, "tThematicName");
            return (Criteria) this;
        }

        public Criteria andTThematicNameGreaterThan(String value) {
            addCriterion("t_thematic_name >", value, "tThematicName");
            return (Criteria) this;
        }

        public Criteria andTThematicNameGreaterThanOrEqualTo(String value) {
            addCriterion("t_thematic_name >=", value, "tThematicName");
            return (Criteria) this;
        }

        public Criteria andTThematicNameLessThan(String value) {
            addCriterion("t_thematic_name <", value, "tThematicName");
            return (Criteria) this;
        }

        public Criteria andTThematicNameLessThanOrEqualTo(String value) {
            addCriterion("t_thematic_name <=", value, "tThematicName");
            return (Criteria) this;
        }

        public Criteria andTThematicNameLike(String value) {
            addCriterion("t_thematic_name like", value, "tThematicName");
            return (Criteria) this;
        }

        public Criteria andTThematicNameNotLike(String value) {
            addCriterion("t_thematic_name not like", value, "tThematicName");
            return (Criteria) this;
        }

        public Criteria andTThematicNameIn(List<String> values) {
            addCriterion("t_thematic_name in", values, "tThematicName");
            return (Criteria) this;
        }

        public Criteria andTThematicNameNotIn(List<String> values) {
            addCriterion("t_thematic_name not in", values, "tThematicName");
            return (Criteria) this;
        }

        public Criteria andTThematicNameBetween(String value1, String value2) {
            addCriterion("t_thematic_name between", value1, value2, "tThematicName");
            return (Criteria) this;
        }

        public Criteria andTThematicNameNotBetween(String value1, String value2) {
            addCriterion("t_thematic_name not between", value1, value2, "tThematicName");
            return (Criteria) this;
        }

        public Criteria andTThematicDeleteIsNull() {
            addCriterion("t_thematic_delete is null");
            return (Criteria) this;
        }

        public Criteria andTThematicDeleteIsNotNull() {
            addCriterion("t_thematic_delete is not null");
            return (Criteria) this;
        }

        public Criteria andTThematicDeleteEqualTo(Integer value) {
            addCriterion("t_thematic_delete =", value, "tThematicDelete");
            return (Criteria) this;
        }

        public Criteria andTThematicDeleteNotEqualTo(Integer value) {
            addCriterion("t_thematic_delete <>", value, "tThematicDelete");
            return (Criteria) this;
        }

        public Criteria andTThematicDeleteGreaterThan(Integer value) {
            addCriterion("t_thematic_delete >", value, "tThematicDelete");
            return (Criteria) this;
        }

        public Criteria andTThematicDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_thematic_delete >=", value, "tThematicDelete");
            return (Criteria) this;
        }

        public Criteria andTThematicDeleteLessThan(Integer value) {
            addCriterion("t_thematic_delete <", value, "tThematicDelete");
            return (Criteria) this;
        }

        public Criteria andTThematicDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("t_thematic_delete <=", value, "tThematicDelete");
            return (Criteria) this;
        }

        public Criteria andTThematicDeleteIn(List<Integer> values) {
            addCriterion("t_thematic_delete in", values, "tThematicDelete");
            return (Criteria) this;
        }

        public Criteria andTThematicDeleteNotIn(List<Integer> values) {
            addCriterion("t_thematic_delete not in", values, "tThematicDelete");
            return (Criteria) this;
        }

        public Criteria andTThematicDeleteBetween(Integer value1, Integer value2) {
            addCriterion("t_thematic_delete between", value1, value2, "tThematicDelete");
            return (Criteria) this;
        }

        public Criteria andTThematicDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("t_thematic_delete not between", value1, value2, "tThematicDelete");
            return (Criteria) this;
        }

        public Criteria andTThematicCdtIsNull() {
            addCriterion("t_thematic_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTThematicCdtIsNotNull() {
            addCriterion("t_thematic_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTThematicCdtEqualTo(Date value) {
            addCriterion("t_thematic_cdt =", value, "tThematicCdt");
            return (Criteria) this;
        }

        public Criteria andTThematicCdtNotEqualTo(Date value) {
            addCriterion("t_thematic_cdt <>", value, "tThematicCdt");
            return (Criteria) this;
        }

        public Criteria andTThematicCdtGreaterThan(Date value) {
            addCriterion("t_thematic_cdt >", value, "tThematicCdt");
            return (Criteria) this;
        }

        public Criteria andTThematicCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_thematic_cdt >=", value, "tThematicCdt");
            return (Criteria) this;
        }

        public Criteria andTThematicCdtLessThan(Date value) {
            addCriterion("t_thematic_cdt <", value, "tThematicCdt");
            return (Criteria) this;
        }

        public Criteria andTThematicCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_thematic_cdt <=", value, "tThematicCdt");
            return (Criteria) this;
        }

        public Criteria andTThematicCdtIn(List<Date> values) {
            addCriterion("t_thematic_cdt in", values, "tThematicCdt");
            return (Criteria) this;
        }

        public Criteria andTThematicCdtNotIn(List<Date> values) {
            addCriterion("t_thematic_cdt not in", values, "tThematicCdt");
            return (Criteria) this;
        }

        public Criteria andTThematicCdtBetween(Date value1, Date value2) {
            addCriterion("t_thematic_cdt between", value1, value2, "tThematicCdt");
            return (Criteria) this;
        }

        public Criteria andTThematicCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_thematic_cdt not between", value1, value2, "tThematicCdt");
            return (Criteria) this;
        }

        public Criteria andTThematicUdtIsNull() {
            addCriterion("t_thematic_udt is null");
            return (Criteria) this;
        }

        public Criteria andTThematicUdtIsNotNull() {
            addCriterion("t_thematic_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTThematicUdtEqualTo(Date value) {
            addCriterion("t_thematic_udt =", value, "tThematicUdt");
            return (Criteria) this;
        }

        public Criteria andTThematicUdtNotEqualTo(Date value) {
            addCriterion("t_thematic_udt <>", value, "tThematicUdt");
            return (Criteria) this;
        }

        public Criteria andTThematicUdtGreaterThan(Date value) {
            addCriterion("t_thematic_udt >", value, "tThematicUdt");
            return (Criteria) this;
        }

        public Criteria andTThematicUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_thematic_udt >=", value, "tThematicUdt");
            return (Criteria) this;
        }

        public Criteria andTThematicUdtLessThan(Date value) {
            addCriterion("t_thematic_udt <", value, "tThematicUdt");
            return (Criteria) this;
        }

        public Criteria andTThematicUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_thematic_udt <=", value, "tThematicUdt");
            return (Criteria) this;
        }

        public Criteria andTThematicUdtIn(List<Date> values) {
            addCriterion("t_thematic_udt in", values, "tThematicUdt");
            return (Criteria) this;
        }

        public Criteria andTThematicUdtNotIn(List<Date> values) {
            addCriterion("t_thematic_udt not in", values, "tThematicUdt");
            return (Criteria) this;
        }

        public Criteria andTThematicUdtBetween(Date value1, Date value2) {
            addCriterion("t_thematic_udt between", value1, value2, "tThematicUdt");
            return (Criteria) this;
        }

        public Criteria andTThematicUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_thematic_udt not between", value1, value2, "tThematicUdt");
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