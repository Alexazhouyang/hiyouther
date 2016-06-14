package com.mybatis.entity;

import java.util.ArrayList;
import java.util.List;

public class HostelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HostelExample() {
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

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Integer value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Integer value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Integer value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Integer value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Integer value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Integer> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Integer> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Integer value1, Integer value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Integer value1, Integer value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
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

        public Criteria andHnameIsNull() {
            addCriterion("hname is null");
            return (Criteria) this;
        }

        public Criteria andHnameIsNotNull() {
            addCriterion("hname is not null");
            return (Criteria) this;
        }

        public Criteria andHnameEqualTo(String value) {
            addCriterion("hname =", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameNotEqualTo(String value) {
            addCriterion("hname <>", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameGreaterThan(String value) {
            addCriterion("hname >", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameGreaterThanOrEqualTo(String value) {
            addCriterion("hname >=", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameLessThan(String value) {
            addCriterion("hname <", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameLessThanOrEqualTo(String value) {
            addCriterion("hname <=", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameLike(String value) {
            addCriterion("hname like", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameNotLike(String value) {
            addCriterion("hname not like", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameIn(List<String> values) {
            addCriterion("hname in", values, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameNotIn(List<String> values) {
            addCriterion("hname not in", values, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameBetween(String value1, String value2) {
            addCriterion("hname between", value1, value2, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameNotBetween(String value1, String value2) {
            addCriterion("hname not between", value1, value2, "hname");
            return (Criteria) this;
        }

        public Criteria andHaddressIsNull() {
            addCriterion("haddress is null");
            return (Criteria) this;
        }

        public Criteria andHaddressIsNotNull() {
            addCriterion("haddress is not null");
            return (Criteria) this;
        }

        public Criteria andHaddressEqualTo(String value) {
            addCriterion("haddress =", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressNotEqualTo(String value) {
            addCriterion("haddress <>", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressGreaterThan(String value) {
            addCriterion("haddress >", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressGreaterThanOrEqualTo(String value) {
            addCriterion("haddress >=", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressLessThan(String value) {
            addCriterion("haddress <", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressLessThanOrEqualTo(String value) {
            addCriterion("haddress <=", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressLike(String value) {
            addCriterion("haddress like", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressNotLike(String value) {
            addCriterion("haddress not like", value, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressIn(List<String> values) {
            addCriterion("haddress in", values, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressNotIn(List<String> values) {
            addCriterion("haddress not in", values, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressBetween(String value1, String value2) {
            addCriterion("haddress between", value1, value2, "haddress");
            return (Criteria) this;
        }

        public Criteria andHaddressNotBetween(String value1, String value2) {
            addCriterion("haddress not between", value1, value2, "haddress");
            return (Criteria) this;
        }

        public Criteria andHphoneIsNull() {
            addCriterion("hphone is null");
            return (Criteria) this;
        }

        public Criteria andHphoneIsNotNull() {
            addCriterion("hphone is not null");
            return (Criteria) this;
        }

        public Criteria andHphoneEqualTo(String value) {
            addCriterion("hphone =", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneNotEqualTo(String value) {
            addCriterion("hphone <>", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneGreaterThan(String value) {
            addCriterion("hphone >", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneGreaterThanOrEqualTo(String value) {
            addCriterion("hphone >=", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneLessThan(String value) {
            addCriterion("hphone <", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneLessThanOrEqualTo(String value) {
            addCriterion("hphone <=", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneLike(String value) {
            addCriterion("hphone like", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneNotLike(String value) {
            addCriterion("hphone not like", value, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneIn(List<String> values) {
            addCriterion("hphone in", values, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneNotIn(List<String> values) {
            addCriterion("hphone not in", values, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneBetween(String value1, String value2) {
            addCriterion("hphone between", value1, value2, "hphone");
            return (Criteria) this;
        }

        public Criteria andHphoneNotBetween(String value1, String value2) {
            addCriterion("hphone not between", value1, value2, "hphone");
            return (Criteria) this;
        }

        public Criteria andHtelIsNull() {
            addCriterion("htel is null");
            return (Criteria) this;
        }

        public Criteria andHtelIsNotNull() {
            addCriterion("htel is not null");
            return (Criteria) this;
        }

        public Criteria andHtelEqualTo(String value) {
            addCriterion("htel =", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelNotEqualTo(String value) {
            addCriterion("htel <>", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelGreaterThan(String value) {
            addCriterion("htel >", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelGreaterThanOrEqualTo(String value) {
            addCriterion("htel >=", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelLessThan(String value) {
            addCriterion("htel <", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelLessThanOrEqualTo(String value) {
            addCriterion("htel <=", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelLike(String value) {
            addCriterion("htel like", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelNotLike(String value) {
            addCriterion("htel not like", value, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelIn(List<String> values) {
            addCriterion("htel in", values, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelNotIn(List<String> values) {
            addCriterion("htel not in", values, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelBetween(String value1, String value2) {
            addCriterion("htel between", value1, value2, "htel");
            return (Criteria) this;
        }

        public Criteria andHtelNotBetween(String value1, String value2) {
            addCriterion("htel not between", value1, value2, "htel");
            return (Criteria) this;
        }

        public Criteria andHtagIsNull() {
            addCriterion("htag is null");
            return (Criteria) this;
        }

        public Criteria andHtagIsNotNull() {
            addCriterion("htag is not null");
            return (Criteria) this;
        }

        public Criteria andHtagEqualTo(String value) {
            addCriterion("htag =", value, "htag");
            return (Criteria) this;
        }

        public Criteria andHtagNotEqualTo(String value) {
            addCriterion("htag <>", value, "htag");
            return (Criteria) this;
        }

        public Criteria andHtagGreaterThan(String value) {
            addCriterion("htag >", value, "htag");
            return (Criteria) this;
        }

        public Criteria andHtagGreaterThanOrEqualTo(String value) {
            addCriterion("htag >=", value, "htag");
            return (Criteria) this;
        }

        public Criteria andHtagLessThan(String value) {
            addCriterion("htag <", value, "htag");
            return (Criteria) this;
        }

        public Criteria andHtagLessThanOrEqualTo(String value) {
            addCriterion("htag <=", value, "htag");
            return (Criteria) this;
        }

        public Criteria andHtagLike(String value) {
            addCriterion("htag like", value, "htag");
            return (Criteria) this;
        }

        public Criteria andHtagNotLike(String value) {
            addCriterion("htag not like", value, "htag");
            return (Criteria) this;
        }

        public Criteria andHtagIn(List<String> values) {
            addCriterion("htag in", values, "htag");
            return (Criteria) this;
        }

        public Criteria andHtagNotIn(List<String> values) {
            addCriterion("htag not in", values, "htag");
            return (Criteria) this;
        }

        public Criteria andHtagBetween(String value1, String value2) {
            addCriterion("htag between", value1, value2, "htag");
            return (Criteria) this;
        }

        public Criteria andHtagNotBetween(String value1, String value2) {
            addCriterion("htag not between", value1, value2, "htag");
            return (Criteria) this;
        }

        public Criteria andHscoreIsNull() {
            addCriterion("hscore is null");
            return (Criteria) this;
        }

        public Criteria andHscoreIsNotNull() {
            addCriterion("hscore is not null");
            return (Criteria) this;
        }

        public Criteria andHscoreEqualTo(String value) {
            addCriterion("hscore =", value, "hscore");
            return (Criteria) this;
        }

        public Criteria andHscoreNotEqualTo(String value) {
            addCriterion("hscore <>", value, "hscore");
            return (Criteria) this;
        }

        public Criteria andHscoreGreaterThan(String value) {
            addCriterion("hscore >", value, "hscore");
            return (Criteria) this;
        }

        public Criteria andHscoreGreaterThanOrEqualTo(String value) {
            addCriterion("hscore >=", value, "hscore");
            return (Criteria) this;
        }

        public Criteria andHscoreLessThan(String value) {
            addCriterion("hscore <", value, "hscore");
            return (Criteria) this;
        }

        public Criteria andHscoreLessThanOrEqualTo(String value) {
            addCriterion("hscore <=", value, "hscore");
            return (Criteria) this;
        }

        public Criteria andHscoreLike(String value) {
            addCriterion("hscore like", value, "hscore");
            return (Criteria) this;
        }

        public Criteria andHscoreNotLike(String value) {
            addCriterion("hscore not like", value, "hscore");
            return (Criteria) this;
        }

        public Criteria andHscoreIn(List<String> values) {
            addCriterion("hscore in", values, "hscore");
            return (Criteria) this;
        }

        public Criteria andHscoreNotIn(List<String> values) {
            addCriterion("hscore not in", values, "hscore");
            return (Criteria) this;
        }

        public Criteria andHscoreBetween(String value1, String value2) {
            addCriterion("hscore between", value1, value2, "hscore");
            return (Criteria) this;
        }

        public Criteria andHscoreNotBetween(String value1, String value2) {
            addCriterion("hscore not between", value1, value2, "hscore");
            return (Criteria) this;
        }

        public Criteria andPauthenticIsNull() {
            addCriterion("pauthentic is null");
            return (Criteria) this;
        }

        public Criteria andPauthenticIsNotNull() {
            addCriterion("pauthentic is not null");
            return (Criteria) this;
        }

        public Criteria andPauthenticEqualTo(String value) {
            addCriterion("pauthentic =", value, "pauthentic");
            return (Criteria) this;
        }

        public Criteria andPauthenticNotEqualTo(String value) {
            addCriterion("pauthentic <>", value, "pauthentic");
            return (Criteria) this;
        }

        public Criteria andPauthenticGreaterThan(String value) {
            addCriterion("pauthentic >", value, "pauthentic");
            return (Criteria) this;
        }

        public Criteria andPauthenticGreaterThanOrEqualTo(String value) {
            addCriterion("pauthentic >=", value, "pauthentic");
            return (Criteria) this;
        }

        public Criteria andPauthenticLessThan(String value) {
            addCriterion("pauthentic <", value, "pauthentic");
            return (Criteria) this;
        }

        public Criteria andPauthenticLessThanOrEqualTo(String value) {
            addCriterion("pauthentic <=", value, "pauthentic");
            return (Criteria) this;
        }

        public Criteria andPauthenticLike(String value) {
            addCriterion("pauthentic like", value, "pauthentic");
            return (Criteria) this;
        }

        public Criteria andPauthenticNotLike(String value) {
            addCriterion("pauthentic not like", value, "pauthentic");
            return (Criteria) this;
        }

        public Criteria andPauthenticIn(List<String> values) {
            addCriterion("pauthentic in", values, "pauthentic");
            return (Criteria) this;
        }

        public Criteria andPauthenticNotIn(List<String> values) {
            addCriterion("pauthentic not in", values, "pauthentic");
            return (Criteria) this;
        }

        public Criteria andPauthenticBetween(String value1, String value2) {
            addCriterion("pauthentic between", value1, value2, "pauthentic");
            return (Criteria) this;
        }

        public Criteria andPauthenticNotBetween(String value1, String value2) {
            addCriterion("pauthentic not between", value1, value2, "pauthentic");
            return (Criteria) this;
        }

        public Criteria andPbuscardIsNull() {
            addCriterion("Pbuscard is null");
            return (Criteria) this;
        }

        public Criteria andPbuscardIsNotNull() {
            addCriterion("Pbuscard is not null");
            return (Criteria) this;
        }

        public Criteria andPbuscardEqualTo(String value) {
            addCriterion("Pbuscard =", value, "pbuscard");
            return (Criteria) this;
        }

        public Criteria andPbuscardNotEqualTo(String value) {
            addCriterion("Pbuscard <>", value, "pbuscard");
            return (Criteria) this;
        }

        public Criteria andPbuscardGreaterThan(String value) {
            addCriterion("Pbuscard >", value, "pbuscard");
            return (Criteria) this;
        }

        public Criteria andPbuscardGreaterThanOrEqualTo(String value) {
            addCriterion("Pbuscard >=", value, "pbuscard");
            return (Criteria) this;
        }

        public Criteria andPbuscardLessThan(String value) {
            addCriterion("Pbuscard <", value, "pbuscard");
            return (Criteria) this;
        }

        public Criteria andPbuscardLessThanOrEqualTo(String value) {
            addCriterion("Pbuscard <=", value, "pbuscard");
            return (Criteria) this;
        }

        public Criteria andPbuscardLike(String value) {
            addCriterion("Pbuscard like", value, "pbuscard");
            return (Criteria) this;
        }

        public Criteria andPbuscardNotLike(String value) {
            addCriterion("Pbuscard not like", value, "pbuscard");
            return (Criteria) this;
        }

        public Criteria andPbuscardIn(List<String> values) {
            addCriterion("Pbuscard in", values, "pbuscard");
            return (Criteria) this;
        }

        public Criteria andPbuscardNotIn(List<String> values) {
            addCriterion("Pbuscard not in", values, "pbuscard");
            return (Criteria) this;
        }

        public Criteria andPbuscardBetween(String value1, String value2) {
            addCriterion("Pbuscard between", value1, value2, "pbuscard");
            return (Criteria) this;
        }

        public Criteria andPbuscardNotBetween(String value1, String value2) {
            addCriterion("Pbuscard not between", value1, value2, "pbuscard");
            return (Criteria) this;
        }

        public Criteria andBcancelIsNull() {
            addCriterion("bcancel is null");
            return (Criteria) this;
        }

        public Criteria andBcancelIsNotNull() {
            addCriterion("bcancel is not null");
            return (Criteria) this;
        }

        public Criteria andBcancelEqualTo(String value) {
            addCriterion("bcancel =", value, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelNotEqualTo(String value) {
            addCriterion("bcancel <>", value, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelGreaterThan(String value) {
            addCriterion("bcancel >", value, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelGreaterThanOrEqualTo(String value) {
            addCriterion("bcancel >=", value, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelLessThan(String value) {
            addCriterion("bcancel <", value, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelLessThanOrEqualTo(String value) {
            addCriterion("bcancel <=", value, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelLike(String value) {
            addCriterion("bcancel like", value, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelNotLike(String value) {
            addCriterion("bcancel not like", value, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelIn(List<String> values) {
            addCriterion("bcancel in", values, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelNotIn(List<String> values) {
            addCriterion("bcancel not in", values, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelBetween(String value1, String value2) {
            addCriterion("bcancel between", value1, value2, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelNotBetween(String value1, String value2) {
            addCriterion("bcancel not between", value1, value2, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBreportIsNull() {
            addCriterion("breport is null");
            return (Criteria) this;
        }

        public Criteria andBreportIsNotNull() {
            addCriterion("breport is not null");
            return (Criteria) this;
        }

        public Criteria andBreportEqualTo(String value) {
            addCriterion("breport =", value, "breport");
            return (Criteria) this;
        }

        public Criteria andBreportNotEqualTo(String value) {
            addCriterion("breport <>", value, "breport");
            return (Criteria) this;
        }

        public Criteria andBreportGreaterThan(String value) {
            addCriterion("breport >", value, "breport");
            return (Criteria) this;
        }

        public Criteria andBreportGreaterThanOrEqualTo(String value) {
            addCriterion("breport >=", value, "breport");
            return (Criteria) this;
        }

        public Criteria andBreportLessThan(String value) {
            addCriterion("breport <", value, "breport");
            return (Criteria) this;
        }

        public Criteria andBreportLessThanOrEqualTo(String value) {
            addCriterion("breport <=", value, "breport");
            return (Criteria) this;
        }

        public Criteria andBreportLike(String value) {
            addCriterion("breport like", value, "breport");
            return (Criteria) this;
        }

        public Criteria andBreportNotLike(String value) {
            addCriterion("breport not like", value, "breport");
            return (Criteria) this;
        }

        public Criteria andBreportIn(List<String> values) {
            addCriterion("breport in", values, "breport");
            return (Criteria) this;
        }

        public Criteria andBreportNotIn(List<String> values) {
            addCriterion("breport not in", values, "breport");
            return (Criteria) this;
        }

        public Criteria andBreportBetween(String value1, String value2) {
            addCriterion("breport between", value1, value2, "breport");
            return (Criteria) this;
        }

        public Criteria andBreportNotBetween(String value1, String value2) {
            addCriterion("breport not between", value1, value2, "breport");
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