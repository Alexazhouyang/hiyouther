package com.mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StatsdateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatsdateExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andSdidIsNull() {
            addCriterion("sdid is null");
            return (Criteria) this;
        }

        public Criteria andSdidIsNotNull() {
            addCriterion("sdid is not null");
            return (Criteria) this;
        }

        public Criteria andSdidEqualTo(Integer value) {
            addCriterion("sdid =", value, "sdid");
            return (Criteria) this;
        }

        public Criteria andSdidNotEqualTo(Integer value) {
            addCriterion("sdid <>", value, "sdid");
            return (Criteria) this;
        }

        public Criteria andSdidGreaterThan(Integer value) {
            addCriterion("sdid >", value, "sdid");
            return (Criteria) this;
        }

        public Criteria andSdidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sdid >=", value, "sdid");
            return (Criteria) this;
        }

        public Criteria andSdidLessThan(Integer value) {
            addCriterion("sdid <", value, "sdid");
            return (Criteria) this;
        }

        public Criteria andSdidLessThanOrEqualTo(Integer value) {
            addCriterion("sdid <=", value, "sdid");
            return (Criteria) this;
        }

        public Criteria andSdidIn(List<Integer> values) {
            addCriterion("sdid in", values, "sdid");
            return (Criteria) this;
        }

        public Criteria andSdidNotIn(List<Integer> values) {
            addCriterion("sdid not in", values, "sdid");
            return (Criteria) this;
        }

        public Criteria andSdidBetween(Integer value1, Integer value2) {
            addCriterion("sdid between", value1, value2, "sdid");
            return (Criteria) this;
        }

        public Criteria andSdidNotBetween(Integer value1, Integer value2) {
            addCriterion("sdid not between", value1, value2, "sdid");
            return (Criteria) this;
        }

        public Criteria andSdtotalIsNull() {
            addCriterion("sdtotal is null");
            return (Criteria) this;
        }

        public Criteria andSdtotalIsNotNull() {
            addCriterion("sdtotal is not null");
            return (Criteria) this;
        }

        public Criteria andSdtotalEqualTo(Integer value) {
            addCriterion("sdtotal =", value, "sdtotal");
            return (Criteria) this;
        }

        public Criteria andSdtotalNotEqualTo(Integer value) {
            addCriterion("sdtotal <>", value, "sdtotal");
            return (Criteria) this;
        }

        public Criteria andSdtotalGreaterThan(Integer value) {
            addCriterion("sdtotal >", value, "sdtotal");
            return (Criteria) this;
        }

        public Criteria andSdtotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("sdtotal >=", value, "sdtotal");
            return (Criteria) this;
        }

        public Criteria andSdtotalLessThan(Integer value) {
            addCriterion("sdtotal <", value, "sdtotal");
            return (Criteria) this;
        }

        public Criteria andSdtotalLessThanOrEqualTo(Integer value) {
            addCriterion("sdtotal <=", value, "sdtotal");
            return (Criteria) this;
        }

        public Criteria andSdtotalIn(List<Integer> values) {
            addCriterion("sdtotal in", values, "sdtotal");
            return (Criteria) this;
        }

        public Criteria andSdtotalNotIn(List<Integer> values) {
            addCriterion("sdtotal not in", values, "sdtotal");
            return (Criteria) this;
        }

        public Criteria andSdtotalBetween(Integer value1, Integer value2) {
            addCriterion("sdtotal between", value1, value2, "sdtotal");
            return (Criteria) this;
        }

        public Criteria andSdtotalNotBetween(Integer value1, Integer value2) {
            addCriterion("sdtotal not between", value1, value2, "sdtotal");
            return (Criteria) this;
        }

        public Criteria andSdsettimeIsNull() {
            addCriterion("sdsettime is null");
            return (Criteria) this;
        }

        public Criteria andSdsettimeIsNotNull() {
            addCriterion("sdsettime is not null");
            return (Criteria) this;
        }

        public Criteria andSdsettimeEqualTo(Date value) {
            addCriterionForJDBCTime("sdsettime =", value, "sdsettime");
            return (Criteria) this;
        }

        public Criteria andSdsettimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("sdsettime <>", value, "sdsettime");
            return (Criteria) this;
        }

        public Criteria andSdsettimeGreaterThan(Date value) {
            addCriterionForJDBCTime("sdsettime >", value, "sdsettime");
            return (Criteria) this;
        }

        public Criteria andSdsettimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("sdsettime >=", value, "sdsettime");
            return (Criteria) this;
        }

        public Criteria andSdsettimeLessThan(Date value) {
            addCriterionForJDBCTime("sdsettime <", value, "sdsettime");
            return (Criteria) this;
        }

        public Criteria andSdsettimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("sdsettime <=", value, "sdsettime");
            return (Criteria) this;
        }

        public Criteria andSdsettimeIn(List<Date> values) {
            addCriterionForJDBCTime("sdsettime in", values, "sdsettime");
            return (Criteria) this;
        }

        public Criteria andSdsettimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("sdsettime not in", values, "sdsettime");
            return (Criteria) this;
        }

        public Criteria andSdsettimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("sdsettime between", value1, value2, "sdsettime");
            return (Criteria) this;
        }

        public Criteria andSdsettimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("sdsettime not between", value1, value2, "sdsettime");
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