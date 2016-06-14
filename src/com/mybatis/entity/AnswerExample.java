package com.mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnswerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnswerExample() {
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

        public Criteria andAnidIsNull() {
            addCriterion("anid is null");
            return (Criteria) this;
        }

        public Criteria andAnidIsNotNull() {
            addCriterion("anid is not null");
            return (Criteria) this;
        }

        public Criteria andAnidEqualTo(Integer value) {
            addCriterion("anid =", value, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidNotEqualTo(Integer value) {
            addCriterion("anid <>", value, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidGreaterThan(Integer value) {
            addCriterion("anid >", value, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidGreaterThanOrEqualTo(Integer value) {
            addCriterion("anid >=", value, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidLessThan(Integer value) {
            addCriterion("anid <", value, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidLessThanOrEqualTo(Integer value) {
            addCriterion("anid <=", value, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidIn(List<Integer> values) {
            addCriterion("anid in", values, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidNotIn(List<Integer> values) {
            addCriterion("anid not in", values, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidBetween(Integer value1, Integer value2) {
            addCriterion("anid between", value1, value2, "anid");
            return (Criteria) this;
        }

        public Criteria andAnidNotBetween(Integer value1, Integer value2) {
            addCriterion("anid not between", value1, value2, "anid");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andAntimeIsNull() {
            addCriterion("antime is null");
            return (Criteria) this;
        }

        public Criteria andAntimeIsNotNull() {
            addCriterion("antime is not null");
            return (Criteria) this;
        }

        public Criteria andAntimeEqualTo(Date value) {
            addCriterion("antime =", value, "antime");
            return (Criteria) this;
        }

        public Criteria andAntimeNotEqualTo(Date value) {
            addCriterion("antime <>", value, "antime");
            return (Criteria) this;
        }

        public Criteria andAntimeGreaterThan(Date value) {
            addCriterion("antime >", value, "antime");
            return (Criteria) this;
        }

        public Criteria andAntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("antime >=", value, "antime");
            return (Criteria) this;
        }

        public Criteria andAntimeLessThan(Date value) {
            addCriterion("antime <", value, "antime");
            return (Criteria) this;
        }

        public Criteria andAntimeLessThanOrEqualTo(Date value) {
            addCriterion("antime <=", value, "antime");
            return (Criteria) this;
        }

        public Criteria andAntimeIn(List<Date> values) {
            addCriterion("antime in", values, "antime");
            return (Criteria) this;
        }

        public Criteria andAntimeNotIn(List<Date> values) {
            addCriterion("antime not in", values, "antime");
            return (Criteria) this;
        }

        public Criteria andAntimeBetween(Date value1, Date value2) {
            addCriterion("antime between", value1, value2, "antime");
            return (Criteria) this;
        }

        public Criteria andAntimeNotBetween(Date value1, Date value2) {
            addCriterion("antime not between", value1, value2, "antime");
            return (Criteria) this;
        }

        public Criteria andListeneridIsNull() {
            addCriterion("listenerId is null");
            return (Criteria) this;
        }

        public Criteria andListeneridIsNotNull() {
            addCriterion("listenerId is not null");
            return (Criteria) this;
        }

        public Criteria andListeneridEqualTo(Integer value) {
            addCriterion("listenerId =", value, "listenerid");
            return (Criteria) this;
        }

        public Criteria andListeneridNotEqualTo(Integer value) {
            addCriterion("listenerId <>", value, "listenerid");
            return (Criteria) this;
        }

        public Criteria andListeneridGreaterThan(Integer value) {
            addCriterion("listenerId >", value, "listenerid");
            return (Criteria) this;
        }

        public Criteria andListeneridGreaterThanOrEqualTo(Integer value) {
            addCriterion("listenerId >=", value, "listenerid");
            return (Criteria) this;
        }

        public Criteria andListeneridLessThan(Integer value) {
            addCriterion("listenerId <", value, "listenerid");
            return (Criteria) this;
        }

        public Criteria andListeneridLessThanOrEqualTo(Integer value) {
            addCriterion("listenerId <=", value, "listenerid");
            return (Criteria) this;
        }

        public Criteria andListeneridIn(List<Integer> values) {
            addCriterion("listenerId in", values, "listenerid");
            return (Criteria) this;
        }

        public Criteria andListeneridNotIn(List<Integer> values) {
            addCriterion("listenerId not in", values, "listenerid");
            return (Criteria) this;
        }

        public Criteria andListeneridBetween(Integer value1, Integer value2) {
            addCriterion("listenerId between", value1, value2, "listenerid");
            return (Criteria) this;
        }

        public Criteria andListeneridNotBetween(Integer value1, Integer value2) {
            addCriterion("listenerId not between", value1, value2, "listenerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridIsNull() {
            addCriterion("speakerId is null");
            return (Criteria) this;
        }

        public Criteria andSpeakeridIsNotNull() {
            addCriterion("speakerId is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakeridEqualTo(Integer value) {
            addCriterion("speakerId =", value, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridNotEqualTo(Integer value) {
            addCriterion("speakerId <>", value, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridGreaterThan(Integer value) {
            addCriterion("speakerId >", value, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("speakerId >=", value, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridLessThan(Integer value) {
            addCriterion("speakerId <", value, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridLessThanOrEqualTo(Integer value) {
            addCriterion("speakerId <=", value, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridIn(List<Integer> values) {
            addCriterion("speakerId in", values, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridNotIn(List<Integer> values) {
            addCriterion("speakerId not in", values, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridBetween(Integer value1, Integer value2) {
            addCriterion("speakerId between", value1, value2, "speakerid");
            return (Criteria) this;
        }

        public Criteria andSpeakeridNotBetween(Integer value1, Integer value2) {
            addCriterion("speakerId not between", value1, value2, "speakerid");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andListenerIsNull() {
            addCriterion("listener is null");
            return (Criteria) this;
        }

        public Criteria andListenerIsNotNull() {
            addCriterion("listener is not null");
            return (Criteria) this;
        }

        public Criteria andListenerEqualTo(String value) {
            addCriterion("listener =", value, "listener");
            return (Criteria) this;
        }

        public Criteria andListenerNotEqualTo(String value) {
            addCriterion("listener <>", value, "listener");
            return (Criteria) this;
        }

        public Criteria andListenerGreaterThan(String value) {
            addCriterion("listener >", value, "listener");
            return (Criteria) this;
        }

        public Criteria andListenerGreaterThanOrEqualTo(String value) {
            addCriterion("listener >=", value, "listener");
            return (Criteria) this;
        }

        public Criteria andListenerLessThan(String value) {
            addCriterion("listener <", value, "listener");
            return (Criteria) this;
        }

        public Criteria andListenerLessThanOrEqualTo(String value) {
            addCriterion("listener <=", value, "listener");
            return (Criteria) this;
        }

        public Criteria andListenerLike(String value) {
            addCriterion("listener like", value, "listener");
            return (Criteria) this;
        }

        public Criteria andListenerNotLike(String value) {
            addCriterion("listener not like", value, "listener");
            return (Criteria) this;
        }

        public Criteria andListenerIn(List<String> values) {
            addCriterion("listener in", values, "listener");
            return (Criteria) this;
        }

        public Criteria andListenerNotIn(List<String> values) {
            addCriterion("listener not in", values, "listener");
            return (Criteria) this;
        }

        public Criteria andListenerBetween(String value1, String value2) {
            addCriterion("listener between", value1, value2, "listener");
            return (Criteria) this;
        }

        public Criteria andListenerNotBetween(String value1, String value2) {
            addCriterion("listener not between", value1, value2, "listener");
            return (Criteria) this;
        }

        public Criteria andSpeakerIsNull() {
            addCriterion("speaker is null");
            return (Criteria) this;
        }

        public Criteria andSpeakerIsNotNull() {
            addCriterion("speaker is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakerEqualTo(String value) {
            addCriterion("speaker =", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerNotEqualTo(String value) {
            addCriterion("speaker <>", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerGreaterThan(String value) {
            addCriterion("speaker >", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerGreaterThanOrEqualTo(String value) {
            addCriterion("speaker >=", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerLessThan(String value) {
            addCriterion("speaker <", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerLessThanOrEqualTo(String value) {
            addCriterion("speaker <=", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerLike(String value) {
            addCriterion("speaker like", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerNotLike(String value) {
            addCriterion("speaker not like", value, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerIn(List<String> values) {
            addCriterion("speaker in", values, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerNotIn(List<String> values) {
            addCriterion("speaker not in", values, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerBetween(String value1, String value2) {
            addCriterion("speaker between", value1, value2, "speaker");
            return (Criteria) this;
        }

        public Criteria andSpeakerNotBetween(String value1, String value2) {
            addCriterion("speaker not between", value1, value2, "speaker");
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