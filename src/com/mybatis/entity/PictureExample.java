package com.mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PictureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PictureExample() {
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

        public Criteria andPicidIsNull() {
            addCriterion("picid is null");
            return (Criteria) this;
        }

        public Criteria andPicidIsNotNull() {
            addCriterion("picid is not null");
            return (Criteria) this;
        }

        public Criteria andPicidEqualTo(Integer value) {
            addCriterion("picid =", value, "picid");
            return (Criteria) this;
        }

        public Criteria andPicidNotEqualTo(Integer value) {
            addCriterion("picid <>", value, "picid");
            return (Criteria) this;
        }

        public Criteria andPicidGreaterThan(Integer value) {
            addCriterion("picid >", value, "picid");
            return (Criteria) this;
        }

        public Criteria andPicidGreaterThanOrEqualTo(Integer value) {
            addCriterion("picid >=", value, "picid");
            return (Criteria) this;
        }

        public Criteria andPicidLessThan(Integer value) {
            addCriterion("picid <", value, "picid");
            return (Criteria) this;
        }

        public Criteria andPicidLessThanOrEqualTo(Integer value) {
            addCriterion("picid <=", value, "picid");
            return (Criteria) this;
        }

        public Criteria andPicidIn(List<Integer> values) {
            addCriterion("picid in", values, "picid");
            return (Criteria) this;
        }

        public Criteria andPicidNotIn(List<Integer> values) {
            addCriterion("picid not in", values, "picid");
            return (Criteria) this;
        }

        public Criteria andPicidBetween(Integer value1, Integer value2) {
            addCriterion("picid between", value1, value2, "picid");
            return (Criteria) this;
        }

        public Criteria andPicidNotBetween(Integer value1, Integer value2) {
            addCriterion("picid not between", value1, value2, "picid");
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

        public Criteria andPictitleIsNull() {
            addCriterion("pictitle is null");
            return (Criteria) this;
        }

        public Criteria andPictitleIsNotNull() {
            addCriterion("pictitle is not null");
            return (Criteria) this;
        }

        public Criteria andPictitleEqualTo(String value) {
            addCriterion("pictitle =", value, "pictitle");
            return (Criteria) this;
        }

        public Criteria andPictitleNotEqualTo(String value) {
            addCriterion("pictitle <>", value, "pictitle");
            return (Criteria) this;
        }

        public Criteria andPictitleGreaterThan(String value) {
            addCriterion("pictitle >", value, "pictitle");
            return (Criteria) this;
        }

        public Criteria andPictitleGreaterThanOrEqualTo(String value) {
            addCriterion("pictitle >=", value, "pictitle");
            return (Criteria) this;
        }

        public Criteria andPictitleLessThan(String value) {
            addCriterion("pictitle <", value, "pictitle");
            return (Criteria) this;
        }

        public Criteria andPictitleLessThanOrEqualTo(String value) {
            addCriterion("pictitle <=", value, "pictitle");
            return (Criteria) this;
        }

        public Criteria andPictitleLike(String value) {
            addCriterion("pictitle like", value, "pictitle");
            return (Criteria) this;
        }

        public Criteria andPictitleNotLike(String value) {
            addCriterion("pictitle not like", value, "pictitle");
            return (Criteria) this;
        }

        public Criteria andPictitleIn(List<String> values) {
            addCriterion("pictitle in", values, "pictitle");
            return (Criteria) this;
        }

        public Criteria andPictitleNotIn(List<String> values) {
            addCriterion("pictitle not in", values, "pictitle");
            return (Criteria) this;
        }

        public Criteria andPictitleBetween(String value1, String value2) {
            addCriterion("pictitle between", value1, value2, "pictitle");
            return (Criteria) this;
        }

        public Criteria andPictitleNotBetween(String value1, String value2) {
            addCriterion("pictitle not between", value1, value2, "pictitle");
            return (Criteria) this;
        }

        public Criteria andPictimeIsNull() {
            addCriterion("pictime is null");
            return (Criteria) this;
        }

        public Criteria andPictimeIsNotNull() {
            addCriterion("pictime is not null");
            return (Criteria) this;
        }

        public Criteria andPictimeEqualTo(Date value) {
            addCriterion("pictime =", value, "pictime");
            return (Criteria) this;
        }

        public Criteria andPictimeNotEqualTo(Date value) {
            addCriterion("pictime <>", value, "pictime");
            return (Criteria) this;
        }

        public Criteria andPictimeGreaterThan(Date value) {
            addCriterion("pictime >", value, "pictime");
            return (Criteria) this;
        }

        public Criteria andPictimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pictime >=", value, "pictime");
            return (Criteria) this;
        }

        public Criteria andPictimeLessThan(Date value) {
            addCriterion("pictime <", value, "pictime");
            return (Criteria) this;
        }

        public Criteria andPictimeLessThanOrEqualTo(Date value) {
            addCriterion("pictime <=", value, "pictime");
            return (Criteria) this;
        }

        public Criteria andPictimeIn(List<Date> values) {
            addCriterion("pictime in", values, "pictime");
            return (Criteria) this;
        }

        public Criteria andPictimeNotIn(List<Date> values) {
            addCriterion("pictime not in", values, "pictime");
            return (Criteria) this;
        }

        public Criteria andPictimeBetween(Date value1, Date value2) {
            addCriterion("pictime between", value1, value2, "pictime");
            return (Criteria) this;
        }

        public Criteria andPictimeNotBetween(Date value1, Date value2) {
            addCriterion("pictime not between", value1, value2, "pictime");
            return (Criteria) this;
        }

        public Criteria andPparentIsNull() {
            addCriterion("pparent is null");
            return (Criteria) this;
        }

        public Criteria andPparentIsNotNull() {
            addCriterion("pparent is not null");
            return (Criteria) this;
        }

        public Criteria andPparentEqualTo(String value) {
            addCriterion("pparent =", value, "pparent");
            return (Criteria) this;
        }

        public Criteria andPparentNotEqualTo(String value) {
            addCriterion("pparent <>", value, "pparent");
            return (Criteria) this;
        }

        public Criteria andPparentGreaterThan(String value) {
            addCriterion("pparent >", value, "pparent");
            return (Criteria) this;
        }

        public Criteria andPparentGreaterThanOrEqualTo(String value) {
            addCriterion("pparent >=", value, "pparent");
            return (Criteria) this;
        }

        public Criteria andPparentLessThan(String value) {
            addCriterion("pparent <", value, "pparent");
            return (Criteria) this;
        }

        public Criteria andPparentLessThanOrEqualTo(String value) {
            addCriterion("pparent <=", value, "pparent");
            return (Criteria) this;
        }

        public Criteria andPparentLike(String value) {
            addCriterion("pparent like", value, "pparent");
            return (Criteria) this;
        }

        public Criteria andPparentNotLike(String value) {
            addCriterion("pparent not like", value, "pparent");
            return (Criteria) this;
        }

        public Criteria andPparentIn(List<String> values) {
            addCriterion("pparent in", values, "pparent");
            return (Criteria) this;
        }

        public Criteria andPparentNotIn(List<String> values) {
            addCriterion("pparent not in", values, "pparent");
            return (Criteria) this;
        }

        public Criteria andPparentBetween(String value1, String value2) {
            addCriterion("pparent between", value1, value2, "pparent");
            return (Criteria) this;
        }

        public Criteria andPparentNotBetween(String value1, String value2) {
            addCriterion("pparent not between", value1, value2, "pparent");
            return (Criteria) this;
        }

        public Criteria andPicaddressIsNull() {
            addCriterion("picaddress is null");
            return (Criteria) this;
        }

        public Criteria andPicaddressIsNotNull() {
            addCriterion("picaddress is not null");
            return (Criteria) this;
        }

        public Criteria andPicaddressEqualTo(String value) {
            addCriterion("picaddress =", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressNotEqualTo(String value) {
            addCriterion("picaddress <>", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressGreaterThan(String value) {
            addCriterion("picaddress >", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressGreaterThanOrEqualTo(String value) {
            addCriterion("picaddress >=", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressLessThan(String value) {
            addCriterion("picaddress <", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressLessThanOrEqualTo(String value) {
            addCriterion("picaddress <=", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressLike(String value) {
            addCriterion("picaddress like", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressNotLike(String value) {
            addCriterion("picaddress not like", value, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressIn(List<String> values) {
            addCriterion("picaddress in", values, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressNotIn(List<String> values) {
            addCriterion("picaddress not in", values, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressBetween(String value1, String value2) {
            addCriterion("picaddress between", value1, value2, "picaddress");
            return (Criteria) this;
        }

        public Criteria andPicaddressNotBetween(String value1, String value2) {
            addCriterion("picaddress not between", value1, value2, "picaddress");
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