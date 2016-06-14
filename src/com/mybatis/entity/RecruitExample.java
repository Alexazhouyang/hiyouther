package com.mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RecruitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecruitExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andHidIsNull() {
            addCriterion("hid is null");
            return (Criteria) this;
        }

        public Criteria andHidIsNotNull() {
            addCriterion("hid is not null");
            return (Criteria) this;
        }

        public Criteria andHidEqualTo(Integer value) {
            addCriterion("hid =", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotEqualTo(Integer value) {
            addCriterion("hid <>", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidGreaterThan(Integer value) {
            addCriterion("hid >", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hid >=", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidLessThan(Integer value) {
            addCriterion("hid <", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidLessThanOrEqualTo(Integer value) {
            addCriterion("hid <=", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidIn(List<Integer> values) {
            addCriterion("hid in", values, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotIn(List<Integer> values) {
            addCriterion("hid not in", values, "hid");
            return (Criteria) this;
        }

        public Criteria andHidBetween(Integer value1, Integer value2) {
            addCriterion("hid between", value1, value2, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotBetween(Integer value1, Integer value2) {
            addCriterion("hid not between", value1, value2, "hid");
            return (Criteria) this;
        }

        public Criteria andRcompetenceIsNull() {
            addCriterion("rcompetence is null");
            return (Criteria) this;
        }

        public Criteria andRcompetenceIsNotNull() {
            addCriterion("rcompetence is not null");
            return (Criteria) this;
        }

        public Criteria andRcompetenceEqualTo(String value) {
            addCriterion("rcompetence =", value, "rcompetence");
            return (Criteria) this;
        }

        public Criteria andRcompetenceNotEqualTo(String value) {
            addCriterion("rcompetence <>", value, "rcompetence");
            return (Criteria) this;
        }

        public Criteria andRcompetenceGreaterThan(String value) {
            addCriterion("rcompetence >", value, "rcompetence");
            return (Criteria) this;
        }

        public Criteria andRcompetenceGreaterThanOrEqualTo(String value) {
            addCriterion("rcompetence >=", value, "rcompetence");
            return (Criteria) this;
        }

        public Criteria andRcompetenceLessThan(String value) {
            addCriterion("rcompetence <", value, "rcompetence");
            return (Criteria) this;
        }

        public Criteria andRcompetenceLessThanOrEqualTo(String value) {
            addCriterion("rcompetence <=", value, "rcompetence");
            return (Criteria) this;
        }

        public Criteria andRcompetenceLike(String value) {
            addCriterion("rcompetence like", value, "rcompetence");
            return (Criteria) this;
        }

        public Criteria andRcompetenceNotLike(String value) {
            addCriterion("rcompetence not like", value, "rcompetence");
            return (Criteria) this;
        }

        public Criteria andRcompetenceIn(List<String> values) {
            addCriterion("rcompetence in", values, "rcompetence");
            return (Criteria) this;
        }

        public Criteria andRcompetenceNotIn(List<String> values) {
            addCriterion("rcompetence not in", values, "rcompetence");
            return (Criteria) this;
        }

        public Criteria andRcompetenceBetween(String value1, String value2) {
            addCriterion("rcompetence between", value1, value2, "rcompetence");
            return (Criteria) this;
        }

        public Criteria andRcompetenceNotBetween(String value1, String value2) {
            addCriterion("rcompetence not between", value1, value2, "rcompetence");
            return (Criteria) this;
        }

        public Criteria andRworktimeIsNull() {
            addCriterion("rworktime is null");
            return (Criteria) this;
        }

        public Criteria andRworktimeIsNotNull() {
            addCriterion("rworktime is not null");
            return (Criteria) this;
        }

        public Criteria andRworktimeEqualTo(String value) {
            addCriterion("rworktime =", value, "rworktime");
            return (Criteria) this;
        }

        public Criteria andRworktimeNotEqualTo(String value) {
            addCriterion("rworktime <>", value, "rworktime");
            return (Criteria) this;
        }

        public Criteria andRworktimeGreaterThan(String value) {
            addCriterion("rworktime >", value, "rworktime");
            return (Criteria) this;
        }

        public Criteria andRworktimeGreaterThanOrEqualTo(String value) {
            addCriterion("rworktime >=", value, "rworktime");
            return (Criteria) this;
        }

        public Criteria andRworktimeLessThan(String value) {
            addCriterion("rworktime <", value, "rworktime");
            return (Criteria) this;
        }

        public Criteria andRworktimeLessThanOrEqualTo(String value) {
            addCriterion("rworktime <=", value, "rworktime");
            return (Criteria) this;
        }

        public Criteria andRworktimeLike(String value) {
            addCriterion("rworktime like", value, "rworktime");
            return (Criteria) this;
        }

        public Criteria andRworktimeNotLike(String value) {
            addCriterion("rworktime not like", value, "rworktime");
            return (Criteria) this;
        }

        public Criteria andRworktimeIn(List<String> values) {
            addCriterion("rworktime in", values, "rworktime");
            return (Criteria) this;
        }

        public Criteria andRworktimeNotIn(List<String> values) {
            addCriterion("rworktime not in", values, "rworktime");
            return (Criteria) this;
        }

        public Criteria andRworktimeBetween(String value1, String value2) {
            addCriterion("rworktime between", value1, value2, "rworktime");
            return (Criteria) this;
        }

        public Criteria andRworktimeNotBetween(String value1, String value2) {
            addCriterion("rworktime not between", value1, value2, "rworktime");
            return (Criteria) this;
        }

        public Criteria andRsctimeIsNull() {
            addCriterion("rsctime is null");
            return (Criteria) this;
        }

        public Criteria andRsctimeIsNotNull() {
            addCriterion("rsctime is not null");
            return (Criteria) this;
        }

        public Criteria andRsctimeEqualTo(Date value) {
            addCriterionForJDBCDate("rsctime =", value, "rsctime");
            return (Criteria) this;
        }

        public Criteria andRsctimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("rsctime <>", value, "rsctime");
            return (Criteria) this;
        }

        public Criteria andRsctimeGreaterThan(Date value) {
            addCriterionForJDBCDate("rsctime >", value, "rsctime");
            return (Criteria) this;
        }

        public Criteria andRsctimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rsctime >=", value, "rsctime");
            return (Criteria) this;
        }

        public Criteria andRsctimeLessThan(Date value) {
            addCriterionForJDBCDate("rsctime <", value, "rsctime");
            return (Criteria) this;
        }

        public Criteria andRsctimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rsctime <=", value, "rsctime");
            return (Criteria) this;
        }

        public Criteria andRsctimeIn(List<Date> values) {
            addCriterionForJDBCDate("rsctime in", values, "rsctime");
            return (Criteria) this;
        }

        public Criteria andRsctimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("rsctime not in", values, "rsctime");
            return (Criteria) this;
        }

        public Criteria andRsctimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rsctime between", value1, value2, "rsctime");
            return (Criteria) this;
        }

        public Criteria andRsctimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rsctime not between", value1, value2, "rsctime");
            return (Criteria) this;
        }

        public Criteria andRmonthIsNull() {
            addCriterion("rmonth is null");
            return (Criteria) this;
        }

        public Criteria andRmonthIsNotNull() {
            addCriterion("rmonth is not null");
            return (Criteria) this;
        }

        public Criteria andRmonthEqualTo(Date value) {
            addCriterionForJDBCDate("rmonth =", value, "rmonth");
            return (Criteria) this;
        }

        public Criteria andRmonthNotEqualTo(Date value) {
            addCriterionForJDBCDate("rmonth <>", value, "rmonth");
            return (Criteria) this;
        }

        public Criteria andRmonthGreaterThan(Date value) {
            addCriterionForJDBCDate("rmonth >", value, "rmonth");
            return (Criteria) this;
        }

        public Criteria andRmonthGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rmonth >=", value, "rmonth");
            return (Criteria) this;
        }

        public Criteria andRmonthLessThan(Date value) {
            addCriterionForJDBCDate("rmonth <", value, "rmonth");
            return (Criteria) this;
        }

        public Criteria andRmonthLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rmonth <=", value, "rmonth");
            return (Criteria) this;
        }

        public Criteria andRmonthIn(List<Date> values) {
            addCriterionForJDBCDate("rmonth in", values, "rmonth");
            return (Criteria) this;
        }

        public Criteria andRmonthNotIn(List<Date> values) {
            addCriterionForJDBCDate("rmonth not in", values, "rmonth");
            return (Criteria) this;
        }

        public Criteria andRmonthBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rmonth between", value1, value2, "rmonth");
            return (Criteria) this;
        }

        public Criteria andRmonthNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rmonth not between", value1, value2, "rmonth");
            return (Criteria) this;
        }

        public Criteria andRnumbersIsNull() {
            addCriterion("rnumbers is null");
            return (Criteria) this;
        }

        public Criteria andRnumbersIsNotNull() {
            addCriterion("rnumbers is not null");
            return (Criteria) this;
        }

        public Criteria andRnumbersEqualTo(String value) {
            addCriterion("rnumbers =", value, "rnumbers");
            return (Criteria) this;
        }

        public Criteria andRnumbersNotEqualTo(String value) {
            addCriterion("rnumbers <>", value, "rnumbers");
            return (Criteria) this;
        }

        public Criteria andRnumbersGreaterThan(String value) {
            addCriterion("rnumbers >", value, "rnumbers");
            return (Criteria) this;
        }

        public Criteria andRnumbersGreaterThanOrEqualTo(String value) {
            addCriterion("rnumbers >=", value, "rnumbers");
            return (Criteria) this;
        }

        public Criteria andRnumbersLessThan(String value) {
            addCriterion("rnumbers <", value, "rnumbers");
            return (Criteria) this;
        }

        public Criteria andRnumbersLessThanOrEqualTo(String value) {
            addCriterion("rnumbers <=", value, "rnumbers");
            return (Criteria) this;
        }

        public Criteria andRnumbersLike(String value) {
            addCriterion("rnumbers like", value, "rnumbers");
            return (Criteria) this;
        }

        public Criteria andRnumbersNotLike(String value) {
            addCriterion("rnumbers not like", value, "rnumbers");
            return (Criteria) this;
        }

        public Criteria andRnumbersIn(List<String> values) {
            addCriterion("rnumbers in", values, "rnumbers");
            return (Criteria) this;
        }

        public Criteria andRnumbersNotIn(List<String> values) {
            addCriterion("rnumbers not in", values, "rnumbers");
            return (Criteria) this;
        }

        public Criteria andRnumbersBetween(String value1, String value2) {
            addCriterion("rnumbers between", value1, value2, "rnumbers");
            return (Criteria) this;
        }

        public Criteria andRnumbersNotBetween(String value1, String value2) {
            addCriterion("rnumbers not between", value1, value2, "rnumbers");
            return (Criteria) this;
        }

        public Criteria andRcancelIsNull() {
            addCriterion("rcancel is null");
            return (Criteria) this;
        }

        public Criteria andRcancelIsNotNull() {
            addCriterion("rcancel is not null");
            return (Criteria) this;
        }

        public Criteria andRcancelEqualTo(Integer value) {
            addCriterion("rcancel =", value, "rcancel");
            return (Criteria) this;
        }

        public Criteria andRcancelNotEqualTo(Integer value) {
            addCriterion("rcancel <>", value, "rcancel");
            return (Criteria) this;
        }

        public Criteria andRcancelGreaterThan(Integer value) {
            addCriterion("rcancel >", value, "rcancel");
            return (Criteria) this;
        }

        public Criteria andRcancelGreaterThanOrEqualTo(Integer value) {
            addCriterion("rcancel >=", value, "rcancel");
            return (Criteria) this;
        }

        public Criteria andRcancelLessThan(Integer value) {
            addCriterion("rcancel <", value, "rcancel");
            return (Criteria) this;
        }

        public Criteria andRcancelLessThanOrEqualTo(Integer value) {
            addCriterion("rcancel <=", value, "rcancel");
            return (Criteria) this;
        }

        public Criteria andRcancelIn(List<Integer> values) {
            addCriterion("rcancel in", values, "rcancel");
            return (Criteria) this;
        }

        public Criteria andRcancelNotIn(List<Integer> values) {
            addCriterion("rcancel not in", values, "rcancel");
            return (Criteria) this;
        }

        public Criteria andRcancelBetween(Integer value1, Integer value2) {
            addCriterion("rcancel between", value1, value2, "rcancel");
            return (Criteria) this;
        }

        public Criteria andRcancelNotBetween(Integer value1, Integer value2) {
            addCriterion("rcancel not between", value1, value2, "rcancel");
            return (Criteria) this;
        }

        public Criteria andRnameIsNull() {
            addCriterion("rname is null");
            return (Criteria) this;
        }

        public Criteria andRnameIsNotNull() {
            addCriterion("rname is not null");
            return (Criteria) this;
        }

        public Criteria andRnameEqualTo(String value) {
            addCriterion("rname =", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotEqualTo(String value) {
            addCriterion("rname <>", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThan(String value) {
            addCriterion("rname >", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThanOrEqualTo(String value) {
            addCriterion("rname >=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThan(String value) {
            addCriterion("rname <", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThanOrEqualTo(String value) {
            addCriterion("rname <=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLike(String value) {
            addCriterion("rname like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotLike(String value) {
            addCriterion("rname not like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameIn(List<String> values) {
            addCriterion("rname in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotIn(List<String> values) {
            addCriterion("rname not in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameBetween(String value1, String value2) {
            addCriterion("rname between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotBetween(String value1, String value2) {
            addCriterion("rname not between", value1, value2, "rname");
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