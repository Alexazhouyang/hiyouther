package com.mybatis.entity;

import java.util.ArrayList;
import java.util.List;

public class AreaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AreaExample() {
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

        public Criteria andAridIsNull() {
            addCriterion("arid is null");
            return (Criteria) this;
        }

        public Criteria andAridIsNotNull() {
            addCriterion("arid is not null");
            return (Criteria) this;
        }

        public Criteria andAridEqualTo(Integer value) {
            addCriterion("arid =", value, "arid");
            return (Criteria) this;
        }

        public Criteria andAridNotEqualTo(Integer value) {
            addCriterion("arid <>", value, "arid");
            return (Criteria) this;
        }

        public Criteria andAridGreaterThan(Integer value) {
            addCriterion("arid >", value, "arid");
            return (Criteria) this;
        }

        public Criteria andAridGreaterThanOrEqualTo(Integer value) {
            addCriterion("arid >=", value, "arid");
            return (Criteria) this;
        }

        public Criteria andAridLessThan(Integer value) {
            addCriterion("arid <", value, "arid");
            return (Criteria) this;
        }

        public Criteria andAridLessThanOrEqualTo(Integer value) {
            addCriterion("arid <=", value, "arid");
            return (Criteria) this;
        }

        public Criteria andAridIn(List<Integer> values) {
            addCriterion("arid in", values, "arid");
            return (Criteria) this;
        }

        public Criteria andAridNotIn(List<Integer> values) {
            addCriterion("arid not in", values, "arid");
            return (Criteria) this;
        }

        public Criteria andAridBetween(Integer value1, Integer value2) {
            addCriterion("arid between", value1, value2, "arid");
            return (Criteria) this;
        }

        public Criteria andAridNotBetween(Integer value1, Integer value2) {
            addCriterion("arid not between", value1, value2, "arid");
            return (Criteria) this;
        }

        public Criteria andArnameIsNull() {
            addCriterion("arname is null");
            return (Criteria) this;
        }

        public Criteria andArnameIsNotNull() {
            addCriterion("arname is not null");
            return (Criteria) this;
        }

        public Criteria andArnameEqualTo(String value) {
            addCriterion("arname =", value, "arname");
            return (Criteria) this;
        }

        public Criteria andArnameNotEqualTo(String value) {
            addCriterion("arname <>", value, "arname");
            return (Criteria) this;
        }

        public Criteria andArnameGreaterThan(String value) {
            addCriterion("arname >", value, "arname");
            return (Criteria) this;
        }

        public Criteria andArnameGreaterThanOrEqualTo(String value) {
            addCriterion("arname >=", value, "arname");
            return (Criteria) this;
        }

        public Criteria andArnameLessThan(String value) {
            addCriterion("arname <", value, "arname");
            return (Criteria) this;
        }

        public Criteria andArnameLessThanOrEqualTo(String value) {
            addCriterion("arname <=", value, "arname");
            return (Criteria) this;
        }

        public Criteria andArnameLike(String value) {
            addCriterion("arname like", value, "arname");
            return (Criteria) this;
        }

        public Criteria andArnameNotLike(String value) {
            addCriterion("arname not like", value, "arname");
            return (Criteria) this;
        }

        public Criteria andArnameIn(List<String> values) {
            addCriterion("arname in", values, "arname");
            return (Criteria) this;
        }

        public Criteria andArnameNotIn(List<String> values) {
            addCriterion("arname not in", values, "arname");
            return (Criteria) this;
        }

        public Criteria andArnameBetween(String value1, String value2) {
            addCriterion("arname between", value1, value2, "arname");
            return (Criteria) this;
        }

        public Criteria andArnameNotBetween(String value1, String value2) {
            addCriterion("arname not between", value1, value2, "arname");
            return (Criteria) this;
        }

        public Criteria andArcountryIsNull() {
            addCriterion("arcountry is null");
            return (Criteria) this;
        }

        public Criteria andArcountryIsNotNull() {
            addCriterion("arcountry is not null");
            return (Criteria) this;
        }

        public Criteria andArcountryEqualTo(String value) {
            addCriterion("arcountry =", value, "arcountry");
            return (Criteria) this;
        }

        public Criteria andArcountryNotEqualTo(String value) {
            addCriterion("arcountry <>", value, "arcountry");
            return (Criteria) this;
        }

        public Criteria andArcountryGreaterThan(String value) {
            addCriterion("arcountry >", value, "arcountry");
            return (Criteria) this;
        }

        public Criteria andArcountryGreaterThanOrEqualTo(String value) {
            addCriterion("arcountry >=", value, "arcountry");
            return (Criteria) this;
        }

        public Criteria andArcountryLessThan(String value) {
            addCriterion("arcountry <", value, "arcountry");
            return (Criteria) this;
        }

        public Criteria andArcountryLessThanOrEqualTo(String value) {
            addCriterion("arcountry <=", value, "arcountry");
            return (Criteria) this;
        }

        public Criteria andArcountryLike(String value) {
            addCriterion("arcountry like", value, "arcountry");
            return (Criteria) this;
        }

        public Criteria andArcountryNotLike(String value) {
            addCriterion("arcountry not like", value, "arcountry");
            return (Criteria) this;
        }

        public Criteria andArcountryIn(List<String> values) {
            addCriterion("arcountry in", values, "arcountry");
            return (Criteria) this;
        }

        public Criteria andArcountryNotIn(List<String> values) {
            addCriterion("arcountry not in", values, "arcountry");
            return (Criteria) this;
        }

        public Criteria andArcountryBetween(String value1, String value2) {
            addCriterion("arcountry between", value1, value2, "arcountry");
            return (Criteria) this;
        }

        public Criteria andArcountryNotBetween(String value1, String value2) {
            addCriterion("arcountry not between", value1, value2, "arcountry");
            return (Criteria) this;
        }

        public Criteria andArtypeIsNull() {
            addCriterion("artype is null");
            return (Criteria) this;
        }

        public Criteria andArtypeIsNotNull() {
            addCriterion("artype is not null");
            return (Criteria) this;
        }

        public Criteria andArtypeEqualTo(String value) {
            addCriterion("artype =", value, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeNotEqualTo(String value) {
            addCriterion("artype <>", value, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeGreaterThan(String value) {
            addCriterion("artype >", value, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeGreaterThanOrEqualTo(String value) {
            addCriterion("artype >=", value, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeLessThan(String value) {
            addCriterion("artype <", value, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeLessThanOrEqualTo(String value) {
            addCriterion("artype <=", value, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeLike(String value) {
            addCriterion("artype like", value, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeNotLike(String value) {
            addCriterion("artype not like", value, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeIn(List<String> values) {
            addCriterion("artype in", values, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeNotIn(List<String> values) {
            addCriterion("artype not in", values, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeBetween(String value1, String value2) {
            addCriterion("artype between", value1, value2, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeNotBetween(String value1, String value2) {
            addCriterion("artype not between", value1, value2, "artype");
            return (Criteria) this;
        }

        public Criteria andArtagIsNull() {
            addCriterion("artag is null");
            return (Criteria) this;
        }

        public Criteria andArtagIsNotNull() {
            addCriterion("artag is not null");
            return (Criteria) this;
        }

        public Criteria andArtagEqualTo(String value) {
            addCriterion("artag =", value, "artag");
            return (Criteria) this;
        }

        public Criteria andArtagNotEqualTo(String value) {
            addCriterion("artag <>", value, "artag");
            return (Criteria) this;
        }

        public Criteria andArtagGreaterThan(String value) {
            addCriterion("artag >", value, "artag");
            return (Criteria) this;
        }

        public Criteria andArtagGreaterThanOrEqualTo(String value) {
            addCriterion("artag >=", value, "artag");
            return (Criteria) this;
        }

        public Criteria andArtagLessThan(String value) {
            addCriterion("artag <", value, "artag");
            return (Criteria) this;
        }

        public Criteria andArtagLessThanOrEqualTo(String value) {
            addCriterion("artag <=", value, "artag");
            return (Criteria) this;
        }

        public Criteria andArtagLike(String value) {
            addCriterion("artag like", value, "artag");
            return (Criteria) this;
        }

        public Criteria andArtagNotLike(String value) {
            addCriterion("artag not like", value, "artag");
            return (Criteria) this;
        }

        public Criteria andArtagIn(List<String> values) {
            addCriterion("artag in", values, "artag");
            return (Criteria) this;
        }

        public Criteria andArtagNotIn(List<String> values) {
            addCriterion("artag not in", values, "artag");
            return (Criteria) this;
        }

        public Criteria andArtagBetween(String value1, String value2) {
            addCriterion("artag between", value1, value2, "artag");
            return (Criteria) this;
        }

        public Criteria andArtagNotBetween(String value1, String value2) {
            addCriterion("artag not between", value1, value2, "artag");
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