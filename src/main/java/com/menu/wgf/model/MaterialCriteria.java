package com.menu.wgf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaterialCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaterialCriteria() {
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

        public Criteria andTMaterialPkidIsNull() {
            addCriterion("t_material_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTMaterialPkidIsNotNull() {
            addCriterion("t_material_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTMaterialPkidEqualTo(Integer value) {
            addCriterion("t_material_pkid =", value, "tMaterialPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialPkidNotEqualTo(Integer value) {
            addCriterion("t_material_pkid <>", value, "tMaterialPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialPkidGreaterThan(Integer value) {
            addCriterion("t_material_pkid >", value, "tMaterialPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_material_pkid >=", value, "tMaterialPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialPkidLessThan(Integer value) {
            addCriterion("t_material_pkid <", value, "tMaterialPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_material_pkid <=", value, "tMaterialPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialPkidIn(List<Integer> values) {
            addCriterion("t_material_pkid in", values, "tMaterialPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialPkidNotIn(List<Integer> values) {
            addCriterion("t_material_pkid not in", values, "tMaterialPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_material_pkid between", value1, value2, "tMaterialPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_material_pkid not between", value1, value2, "tMaterialPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialNameIsNull() {
            addCriterion("t_material_name is null");
            return (Criteria) this;
        }

        public Criteria andTMaterialNameIsNotNull() {
            addCriterion("t_material_name is not null");
            return (Criteria) this;
        }

        public Criteria andTMaterialNameEqualTo(Integer value) {
            addCriterion("t_material_name =", value, "tMaterialName");
            return (Criteria) this;
        }

        public Criteria andTMaterialNameNotEqualTo(Integer value) {
            addCriterion("t_material_name <>", value, "tMaterialName");
            return (Criteria) this;
        }

        public Criteria andTMaterialNameGreaterThan(Integer value) {
            addCriterion("t_material_name >", value, "tMaterialName");
            return (Criteria) this;
        }

        public Criteria andTMaterialNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_material_name >=", value, "tMaterialName");
            return (Criteria) this;
        }

        public Criteria andTMaterialNameLessThan(Integer value) {
            addCriterion("t_material_name <", value, "tMaterialName");
            return (Criteria) this;
        }

        public Criteria andTMaterialNameLessThanOrEqualTo(Integer value) {
            addCriterion("t_material_name <=", value, "tMaterialName");
            return (Criteria) this;
        }

        public Criteria andTMaterialNameIn(List<Integer> values) {
            addCriterion("t_material_name in", values, "tMaterialName");
            return (Criteria) this;
        }

        public Criteria andTMaterialNameNotIn(List<Integer> values) {
            addCriterion("t_material_name not in", values, "tMaterialName");
            return (Criteria) this;
        }

        public Criteria andTMaterialNameBetween(Integer value1, Integer value2) {
            addCriterion("t_material_name between", value1, value2, "tMaterialName");
            return (Criteria) this;
        }

        public Criteria andTMaterialNameNotBetween(Integer value1, Integer value2) {
            addCriterion("t_material_name not between", value1, value2, "tMaterialName");
            return (Criteria) this;
        }

        public Criteria andTMaterialMenuPkidIsNull() {
            addCriterion("t_material_menu_pkid is null");
            return (Criteria) this;
        }

        public Criteria andTMaterialMenuPkidIsNotNull() {
            addCriterion("t_material_menu_pkid is not null");
            return (Criteria) this;
        }

        public Criteria andTMaterialMenuPkidEqualTo(Integer value) {
            addCriterion("t_material_menu_pkid =", value, "tMaterialMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialMenuPkidNotEqualTo(Integer value) {
            addCriterion("t_material_menu_pkid <>", value, "tMaterialMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialMenuPkidGreaterThan(Integer value) {
            addCriterion("t_material_menu_pkid >", value, "tMaterialMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialMenuPkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_material_menu_pkid >=", value, "tMaterialMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialMenuPkidLessThan(Integer value) {
            addCriterion("t_material_menu_pkid <", value, "tMaterialMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialMenuPkidLessThanOrEqualTo(Integer value) {
            addCriterion("t_material_menu_pkid <=", value, "tMaterialMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialMenuPkidIn(List<Integer> values) {
            addCriterion("t_material_menu_pkid in", values, "tMaterialMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialMenuPkidNotIn(List<Integer> values) {
            addCriterion("t_material_menu_pkid not in", values, "tMaterialMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialMenuPkidBetween(Integer value1, Integer value2) {
            addCriterion("t_material_menu_pkid between", value1, value2, "tMaterialMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialMenuPkidNotBetween(Integer value1, Integer value2) {
            addCriterion("t_material_menu_pkid not between", value1, value2, "tMaterialMenuPkid");
            return (Criteria) this;
        }

        public Criteria andTMaterialCdtIsNull() {
            addCriterion("t_material_cdt is null");
            return (Criteria) this;
        }

        public Criteria andTMaterialCdtIsNotNull() {
            addCriterion("t_material_cdt is not null");
            return (Criteria) this;
        }

        public Criteria andTMaterialCdtEqualTo(Date value) {
            addCriterion("t_material_cdt =", value, "tMaterialCdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialCdtNotEqualTo(Date value) {
            addCriterion("t_material_cdt <>", value, "tMaterialCdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialCdtGreaterThan(Date value) {
            addCriterion("t_material_cdt >", value, "tMaterialCdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialCdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_material_cdt >=", value, "tMaterialCdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialCdtLessThan(Date value) {
            addCriterion("t_material_cdt <", value, "tMaterialCdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialCdtLessThanOrEqualTo(Date value) {
            addCriterion("t_material_cdt <=", value, "tMaterialCdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialCdtIn(List<Date> values) {
            addCriterion("t_material_cdt in", values, "tMaterialCdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialCdtNotIn(List<Date> values) {
            addCriterion("t_material_cdt not in", values, "tMaterialCdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialCdtBetween(Date value1, Date value2) {
            addCriterion("t_material_cdt between", value1, value2, "tMaterialCdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialCdtNotBetween(Date value1, Date value2) {
            addCriterion("t_material_cdt not between", value1, value2, "tMaterialCdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialUdtIsNull() {
            addCriterion("t_material_udt is null");
            return (Criteria) this;
        }

        public Criteria andTMaterialUdtIsNotNull() {
            addCriterion("t_material_udt is not null");
            return (Criteria) this;
        }

        public Criteria andTMaterialUdtEqualTo(Date value) {
            addCriterion("t_material_udt =", value, "tMaterialUdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialUdtNotEqualTo(Date value) {
            addCriterion("t_material_udt <>", value, "tMaterialUdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialUdtGreaterThan(Date value) {
            addCriterion("t_material_udt >", value, "tMaterialUdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("t_material_udt >=", value, "tMaterialUdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialUdtLessThan(Date value) {
            addCriterion("t_material_udt <", value, "tMaterialUdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialUdtLessThanOrEqualTo(Date value) {
            addCriterion("t_material_udt <=", value, "tMaterialUdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialUdtIn(List<Date> values) {
            addCriterion("t_material_udt in", values, "tMaterialUdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialUdtNotIn(List<Date> values) {
            addCriterion("t_material_udt not in", values, "tMaterialUdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialUdtBetween(Date value1, Date value2) {
            addCriterion("t_material_udt between", value1, value2, "tMaterialUdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialUdtNotBetween(Date value1, Date value2) {
            addCriterion("t_material_udt not between", value1, value2, "tMaterialUdt");
            return (Criteria) this;
        }

        public Criteria andTMaterialDeleteIsNull() {
            addCriterion("t_material_delete is null");
            return (Criteria) this;
        }

        public Criteria andTMaterialDeleteIsNotNull() {
            addCriterion("t_material_delete is not null");
            return (Criteria) this;
        }

        public Criteria andTMaterialDeleteEqualTo(Integer value) {
            addCriterion("t_material_delete =", value, "tMaterialDelete");
            return (Criteria) this;
        }

        public Criteria andTMaterialDeleteNotEqualTo(Integer value) {
            addCriterion("t_material_delete <>", value, "tMaterialDelete");
            return (Criteria) this;
        }

        public Criteria andTMaterialDeleteGreaterThan(Integer value) {
            addCriterion("t_material_delete >", value, "tMaterialDelete");
            return (Criteria) this;
        }

        public Criteria andTMaterialDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_material_delete >=", value, "tMaterialDelete");
            return (Criteria) this;
        }

        public Criteria andTMaterialDeleteLessThan(Integer value) {
            addCriterion("t_material_delete <", value, "tMaterialDelete");
            return (Criteria) this;
        }

        public Criteria andTMaterialDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("t_material_delete <=", value, "tMaterialDelete");
            return (Criteria) this;
        }

        public Criteria andTMaterialDeleteIn(List<Integer> values) {
            addCriterion("t_material_delete in", values, "tMaterialDelete");
            return (Criteria) this;
        }

        public Criteria andTMaterialDeleteNotIn(List<Integer> values) {
            addCriterion("t_material_delete not in", values, "tMaterialDelete");
            return (Criteria) this;
        }

        public Criteria andTMaterialDeleteBetween(Integer value1, Integer value2) {
            addCriterion("t_material_delete between", value1, value2, "tMaterialDelete");
            return (Criteria) this;
        }

        public Criteria andTMaterialDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("t_material_delete not between", value1, value2, "tMaterialDelete");
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