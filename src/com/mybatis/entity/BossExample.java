package com.mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BossExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BossExample() {
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

        public Criteria andBusernameIsNull() {
            addCriterion("busername is null");
            return (Criteria) this;
        }

        public Criteria andBusernameIsNotNull() {
            addCriterion("busername is not null");
            return (Criteria) this;
        }

        public Criteria andBusernameEqualTo(String value) {
            addCriterion("busername =", value, "busername");
            return (Criteria) this;
        }

        public Criteria andBusernameNotEqualTo(String value) {
            addCriterion("busername <>", value, "busername");
            return (Criteria) this;
        }

        public Criteria andBusernameGreaterThan(String value) {
            addCriterion("busername >", value, "busername");
            return (Criteria) this;
        }

        public Criteria andBusernameGreaterThanOrEqualTo(String value) {
            addCriterion("busername >=", value, "busername");
            return (Criteria) this;
        }

        public Criteria andBusernameLessThan(String value) {
            addCriterion("busername <", value, "busername");
            return (Criteria) this;
        }

        public Criteria andBusernameLessThanOrEqualTo(String value) {
            addCriterion("busername <=", value, "busername");
            return (Criteria) this;
        }

        public Criteria andBusernameLike(String value) {
            addCriterion("busername like", value, "busername");
            return (Criteria) this;
        }

        public Criteria andBusernameNotLike(String value) {
            addCriterion("busername not like", value, "busername");
            return (Criteria) this;
        }

        public Criteria andBusernameIn(List<String> values) {
            addCriterion("busername in", values, "busername");
            return (Criteria) this;
        }

        public Criteria andBusernameNotIn(List<String> values) {
            addCriterion("busername not in", values, "busername");
            return (Criteria) this;
        }

        public Criteria andBusernameBetween(String value1, String value2) {
            addCriterion("busername between", value1, value2, "busername");
            return (Criteria) this;
        }

        public Criteria andBusernameNotBetween(String value1, String value2) {
            addCriterion("busername not between", value1, value2, "busername");
            return (Criteria) this;
        }

        public Criteria andBtouxiangIsNull() {
            addCriterion("btouxiang is null");
            return (Criteria) this;
        }

        public Criteria andBtouxiangIsNotNull() {
            addCriterion("btouxiang is not null");
            return (Criteria) this;
        }

        public Criteria andBtouxiangEqualTo(String value) {
            addCriterion("btouxiang =", value, "btouxiang");
            return (Criteria) this;
        }

        public Criteria andBtouxiangNotEqualTo(String value) {
            addCriterion("btouxiang <>", value, "btouxiang");
            return (Criteria) this;
        }

        public Criteria andBtouxiangGreaterThan(String value) {
            addCriterion("btouxiang >", value, "btouxiang");
            return (Criteria) this;
        }

        public Criteria andBtouxiangGreaterThanOrEqualTo(String value) {
            addCriterion("btouxiang >=", value, "btouxiang");
            return (Criteria) this;
        }

        public Criteria andBtouxiangLessThan(String value) {
            addCriterion("btouxiang <", value, "btouxiang");
            return (Criteria) this;
        }

        public Criteria andBtouxiangLessThanOrEqualTo(String value) {
            addCriterion("btouxiang <=", value, "btouxiang");
            return (Criteria) this;
        }

        public Criteria andBtouxiangLike(String value) {
            addCriterion("btouxiang like", value, "btouxiang");
            return (Criteria) this;
        }

        public Criteria andBtouxiangNotLike(String value) {
            addCriterion("btouxiang not like", value, "btouxiang");
            return (Criteria) this;
        }

        public Criteria andBtouxiangIn(List<String> values) {
            addCriterion("btouxiang in", values, "btouxiang");
            return (Criteria) this;
        }

        public Criteria andBtouxiangNotIn(List<String> values) {
            addCriterion("btouxiang not in", values, "btouxiang");
            return (Criteria) this;
        }

        public Criteria andBtouxiangBetween(String value1, String value2) {
            addCriterion("btouxiang between", value1, value2, "btouxiang");
            return (Criteria) this;
        }

        public Criteria andBtouxiangNotBetween(String value1, String value2) {
            addCriterion("btouxiang not between", value1, value2, "btouxiang");
            return (Criteria) this;
        }

        public Criteria andBtelIsNull() {
            addCriterion("btel is null");
            return (Criteria) this;
        }

        public Criteria andBtelIsNotNull() {
            addCriterion("btel is not null");
            return (Criteria) this;
        }

        public Criteria andBtelEqualTo(String value) {
            addCriterion("btel =", value, "btel");
            return (Criteria) this;
        }

        public Criteria andBtelNotEqualTo(String value) {
            addCriterion("btel <>", value, "btel");
            return (Criteria) this;
        }

        public Criteria andBtelGreaterThan(String value) {
            addCriterion("btel >", value, "btel");
            return (Criteria) this;
        }

        public Criteria andBtelGreaterThanOrEqualTo(String value) {
            addCriterion("btel >=", value, "btel");
            return (Criteria) this;
        }

        public Criteria andBtelLessThan(String value) {
            addCriterion("btel <", value, "btel");
            return (Criteria) this;
        }

        public Criteria andBtelLessThanOrEqualTo(String value) {
            addCriterion("btel <=", value, "btel");
            return (Criteria) this;
        }

        public Criteria andBtelLike(String value) {
            addCriterion("btel like", value, "btel");
            return (Criteria) this;
        }

        public Criteria andBtelNotLike(String value) {
            addCriterion("btel not like", value, "btel");
            return (Criteria) this;
        }

        public Criteria andBtelIn(List<String> values) {
            addCriterion("btel in", values, "btel");
            return (Criteria) this;
        }

        public Criteria andBtelNotIn(List<String> values) {
            addCriterion("btel not in", values, "btel");
            return (Criteria) this;
        }

        public Criteria andBtelBetween(String value1, String value2) {
            addCriterion("btel between", value1, value2, "btel");
            return (Criteria) this;
        }

        public Criteria andBtelNotBetween(String value1, String value2) {
            addCriterion("btel not between", value1, value2, "btel");
            return (Criteria) this;
        }

        public Criteria andBphoneIsNull() {
            addCriterion("bphone is null");
            return (Criteria) this;
        }

        public Criteria andBphoneIsNotNull() {
            addCriterion("bphone is not null");
            return (Criteria) this;
        }

        public Criteria andBphoneEqualTo(String value) {
            addCriterion("bphone =", value, "bphone");
            return (Criteria) this;
        }

        public Criteria andBphoneNotEqualTo(String value) {
            addCriterion("bphone <>", value, "bphone");
            return (Criteria) this;
        }

        public Criteria andBphoneGreaterThan(String value) {
            addCriterion("bphone >", value, "bphone");
            return (Criteria) this;
        }

        public Criteria andBphoneGreaterThanOrEqualTo(String value) {
            addCriterion("bphone >=", value, "bphone");
            return (Criteria) this;
        }

        public Criteria andBphoneLessThan(String value) {
            addCriterion("bphone <", value, "bphone");
            return (Criteria) this;
        }

        public Criteria andBphoneLessThanOrEqualTo(String value) {
            addCriterion("bphone <=", value, "bphone");
            return (Criteria) this;
        }

        public Criteria andBphoneLike(String value) {
            addCriterion("bphone like", value, "bphone");
            return (Criteria) this;
        }

        public Criteria andBphoneNotLike(String value) {
            addCriterion("bphone not like", value, "bphone");
            return (Criteria) this;
        }

        public Criteria andBphoneIn(List<String> values) {
            addCriterion("bphone in", values, "bphone");
            return (Criteria) this;
        }

        public Criteria andBphoneNotIn(List<String> values) {
            addCriterion("bphone not in", values, "bphone");
            return (Criteria) this;
        }

        public Criteria andBphoneBetween(String value1, String value2) {
            addCriterion("bphone between", value1, value2, "bphone");
            return (Criteria) this;
        }

        public Criteria andBphoneNotBetween(String value1, String value2) {
            addCriterion("bphone not between", value1, value2, "bphone");
            return (Criteria) this;
        }

        public Criteria andBqqIsNull() {
            addCriterion("bqq is null");
            return (Criteria) this;
        }

        public Criteria andBqqIsNotNull() {
            addCriterion("bqq is not null");
            return (Criteria) this;
        }

        public Criteria andBqqEqualTo(String value) {
            addCriterion("bqq =", value, "bqq");
            return (Criteria) this;
        }

        public Criteria andBqqNotEqualTo(String value) {
            addCriterion("bqq <>", value, "bqq");
            return (Criteria) this;
        }

        public Criteria andBqqGreaterThan(String value) {
            addCriterion("bqq >", value, "bqq");
            return (Criteria) this;
        }

        public Criteria andBqqGreaterThanOrEqualTo(String value) {
            addCriterion("bqq >=", value, "bqq");
            return (Criteria) this;
        }

        public Criteria andBqqLessThan(String value) {
            addCriterion("bqq <", value, "bqq");
            return (Criteria) this;
        }

        public Criteria andBqqLessThanOrEqualTo(String value) {
            addCriterion("bqq <=", value, "bqq");
            return (Criteria) this;
        }

        public Criteria andBqqLike(String value) {
            addCriterion("bqq like", value, "bqq");
            return (Criteria) this;
        }

        public Criteria andBqqNotLike(String value) {
            addCriterion("bqq not like", value, "bqq");
            return (Criteria) this;
        }

        public Criteria andBqqIn(List<String> values) {
            addCriterion("bqq in", values, "bqq");
            return (Criteria) this;
        }

        public Criteria andBqqNotIn(List<String> values) {
            addCriterion("bqq not in", values, "bqq");
            return (Criteria) this;
        }

        public Criteria andBqqBetween(String value1, String value2) {
            addCriterion("bqq between", value1, value2, "bqq");
            return (Criteria) this;
        }

        public Criteria andBqqNotBetween(String value1, String value2) {
            addCriterion("bqq not between", value1, value2, "bqq");
            return (Criteria) this;
        }

        public Criteria andBemailIsNull() {
            addCriterion("bemail is null");
            return (Criteria) this;
        }

        public Criteria andBemailIsNotNull() {
            addCriterion("bemail is not null");
            return (Criteria) this;
        }

        public Criteria andBemailEqualTo(String value) {
            addCriterion("bemail =", value, "bemail");
            return (Criteria) this;
        }

        public Criteria andBemailNotEqualTo(String value) {
            addCriterion("bemail <>", value, "bemail");
            return (Criteria) this;
        }

        public Criteria andBemailGreaterThan(String value) {
            addCriterion("bemail >", value, "bemail");
            return (Criteria) this;
        }

        public Criteria andBemailGreaterThanOrEqualTo(String value) {
            addCriterion("bemail >=", value, "bemail");
            return (Criteria) this;
        }

        public Criteria andBemailLessThan(String value) {
            addCriterion("bemail <", value, "bemail");
            return (Criteria) this;
        }

        public Criteria andBemailLessThanOrEqualTo(String value) {
            addCriterion("bemail <=", value, "bemail");
            return (Criteria) this;
        }

        public Criteria andBemailLike(String value) {
            addCriterion("bemail like", value, "bemail");
            return (Criteria) this;
        }

        public Criteria andBemailNotLike(String value) {
            addCriterion("bemail not like", value, "bemail");
            return (Criteria) this;
        }

        public Criteria andBemailIn(List<String> values) {
            addCriterion("bemail in", values, "bemail");
            return (Criteria) this;
        }

        public Criteria andBemailNotIn(List<String> values) {
            addCriterion("bemail not in", values, "bemail");
            return (Criteria) this;
        }

        public Criteria andBemailBetween(String value1, String value2) {
            addCriterion("bemail between", value1, value2, "bemail");
            return (Criteria) this;
        }

        public Criteria andBemailNotBetween(String value1, String value2) {
            addCriterion("bemail not between", value1, value2, "bemail");
            return (Criteria) this;
        }

        public Criteria andBweiboIsNull() {
            addCriterion("bweibo is null");
            return (Criteria) this;
        }

        public Criteria andBweiboIsNotNull() {
            addCriterion("bweibo is not null");
            return (Criteria) this;
        }

        public Criteria andBweiboEqualTo(String value) {
            addCriterion("bweibo =", value, "bweibo");
            return (Criteria) this;
        }

        public Criteria andBweiboNotEqualTo(String value) {
            addCriterion("bweibo <>", value, "bweibo");
            return (Criteria) this;
        }

        public Criteria andBweiboGreaterThan(String value) {
            addCriterion("bweibo >", value, "bweibo");
            return (Criteria) this;
        }

        public Criteria andBweiboGreaterThanOrEqualTo(String value) {
            addCriterion("bweibo >=", value, "bweibo");
            return (Criteria) this;
        }

        public Criteria andBweiboLessThan(String value) {
            addCriterion("bweibo <", value, "bweibo");
            return (Criteria) this;
        }

        public Criteria andBweiboLessThanOrEqualTo(String value) {
            addCriterion("bweibo <=", value, "bweibo");
            return (Criteria) this;
        }

        public Criteria andBweiboLike(String value) {
            addCriterion("bweibo like", value, "bweibo");
            return (Criteria) this;
        }

        public Criteria andBweiboNotLike(String value) {
            addCriterion("bweibo not like", value, "bweibo");
            return (Criteria) this;
        }

        public Criteria andBweiboIn(List<String> values) {
            addCriterion("bweibo in", values, "bweibo");
            return (Criteria) this;
        }

        public Criteria andBweiboNotIn(List<String> values) {
            addCriterion("bweibo not in", values, "bweibo");
            return (Criteria) this;
        }

        public Criteria andBweiboBetween(String value1, String value2) {
            addCriterion("bweibo between", value1, value2, "bweibo");
            return (Criteria) this;
        }

        public Criteria andBweiboNotBetween(String value1, String value2) {
            addCriterion("bweibo not between", value1, value2, "bweibo");
            return (Criteria) this;
        }

        public Criteria andBwechatIsNull() {
            addCriterion("bwechat is null");
            return (Criteria) this;
        }

        public Criteria andBwechatIsNotNull() {
            addCriterion("bwechat is not null");
            return (Criteria) this;
        }

        public Criteria andBwechatEqualTo(String value) {
            addCriterion("bwechat =", value, "bwechat");
            return (Criteria) this;
        }

        public Criteria andBwechatNotEqualTo(String value) {
            addCriterion("bwechat <>", value, "bwechat");
            return (Criteria) this;
        }

        public Criteria andBwechatGreaterThan(String value) {
            addCriterion("bwechat >", value, "bwechat");
            return (Criteria) this;
        }

        public Criteria andBwechatGreaterThanOrEqualTo(String value) {
            addCriterion("bwechat >=", value, "bwechat");
            return (Criteria) this;
        }

        public Criteria andBwechatLessThan(String value) {
            addCriterion("bwechat <", value, "bwechat");
            return (Criteria) this;
        }

        public Criteria andBwechatLessThanOrEqualTo(String value) {
            addCriterion("bwechat <=", value, "bwechat");
            return (Criteria) this;
        }

        public Criteria andBwechatLike(String value) {
            addCriterion("bwechat like", value, "bwechat");
            return (Criteria) this;
        }

        public Criteria andBwechatNotLike(String value) {
            addCriterion("bwechat not like", value, "bwechat");
            return (Criteria) this;
        }

        public Criteria andBwechatIn(List<String> values) {
            addCriterion("bwechat in", values, "bwechat");
            return (Criteria) this;
        }

        public Criteria andBwechatNotIn(List<String> values) {
            addCriterion("bwechat not in", values, "bwechat");
            return (Criteria) this;
        }

        public Criteria andBwechatBetween(String value1, String value2) {
            addCriterion("bwechat between", value1, value2, "bwechat");
            return (Criteria) this;
        }

        public Criteria andBwechatNotBetween(String value1, String value2) {
            addCriterion("bwechat not between", value1, value2, "bwechat");
            return (Criteria) this;
        }

        public Criteria andBpasswordIsNull() {
            addCriterion("bpassword is null");
            return (Criteria) this;
        }

        public Criteria andBpasswordIsNotNull() {
            addCriterion("bpassword is not null");
            return (Criteria) this;
        }

        public Criteria andBpasswordEqualTo(String value) {
            addCriterion("bpassword =", value, "bpassword");
            return (Criteria) this;
        }

        public Criteria andBpasswordNotEqualTo(String value) {
            addCriterion("bpassword <>", value, "bpassword");
            return (Criteria) this;
        }

        public Criteria andBpasswordGreaterThan(String value) {
            addCriterion("bpassword >", value, "bpassword");
            return (Criteria) this;
        }

        public Criteria andBpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("bpassword >=", value, "bpassword");
            return (Criteria) this;
        }

        public Criteria andBpasswordLessThan(String value) {
            addCriterion("bpassword <", value, "bpassword");
            return (Criteria) this;
        }

        public Criteria andBpasswordLessThanOrEqualTo(String value) {
            addCriterion("bpassword <=", value, "bpassword");
            return (Criteria) this;
        }

        public Criteria andBpasswordLike(String value) {
            addCriterion("bpassword like", value, "bpassword");
            return (Criteria) this;
        }

        public Criteria andBpasswordNotLike(String value) {
            addCriterion("bpassword not like", value, "bpassword");
            return (Criteria) this;
        }

        public Criteria andBpasswordIn(List<String> values) {
            addCriterion("bpassword in", values, "bpassword");
            return (Criteria) this;
        }

        public Criteria andBpasswordNotIn(List<String> values) {
            addCriterion("bpassword not in", values, "bpassword");
            return (Criteria) this;
        }

        public Criteria andBpasswordBetween(String value1, String value2) {
            addCriterion("bpassword between", value1, value2, "bpassword");
            return (Criteria) this;
        }

        public Criteria andBpasswordNotBetween(String value1, String value2) {
            addCriterion("bpassword not between", value1, value2, "bpassword");
            return (Criteria) this;
        }

        public Criteria andBrealnameIsNull() {
            addCriterion("brealname is null");
            return (Criteria) this;
        }

        public Criteria andBrealnameIsNotNull() {
            addCriterion("brealname is not null");
            return (Criteria) this;
        }

        public Criteria andBrealnameEqualTo(String value) {
            addCriterion("brealname =", value, "brealname");
            return (Criteria) this;
        }

        public Criteria andBrealnameNotEqualTo(String value) {
            addCriterion("brealname <>", value, "brealname");
            return (Criteria) this;
        }

        public Criteria andBrealnameGreaterThan(String value) {
            addCriterion("brealname >", value, "brealname");
            return (Criteria) this;
        }

        public Criteria andBrealnameGreaterThanOrEqualTo(String value) {
            addCriterion("brealname >=", value, "brealname");
            return (Criteria) this;
        }

        public Criteria andBrealnameLessThan(String value) {
            addCriterion("brealname <", value, "brealname");
            return (Criteria) this;
        }

        public Criteria andBrealnameLessThanOrEqualTo(String value) {
            addCriterion("brealname <=", value, "brealname");
            return (Criteria) this;
        }

        public Criteria andBrealnameLike(String value) {
            addCriterion("brealname like", value, "brealname");
            return (Criteria) this;
        }

        public Criteria andBrealnameNotLike(String value) {
            addCriterion("brealname not like", value, "brealname");
            return (Criteria) this;
        }

        public Criteria andBrealnameIn(List<String> values) {
            addCriterion("brealname in", values, "brealname");
            return (Criteria) this;
        }

        public Criteria andBrealnameNotIn(List<String> values) {
            addCriterion("brealname not in", values, "brealname");
            return (Criteria) this;
        }

        public Criteria andBrealnameBetween(String value1, String value2) {
            addCriterion("brealname between", value1, value2, "brealname");
            return (Criteria) this;
        }

        public Criteria andBrealnameNotBetween(String value1, String value2) {
            addCriterion("brealname not between", value1, value2, "brealname");
            return (Criteria) this;
        }

        public Criteria andBidcardIsNull() {
            addCriterion("bidcard is null");
            return (Criteria) this;
        }

        public Criteria andBidcardIsNotNull() {
            addCriterion("bidcard is not null");
            return (Criteria) this;
        }

        public Criteria andBidcardEqualTo(String value) {
            addCriterion("bidcard =", value, "bidcard");
            return (Criteria) this;
        }

        public Criteria andBidcardNotEqualTo(String value) {
            addCriterion("bidcard <>", value, "bidcard");
            return (Criteria) this;
        }

        public Criteria andBidcardGreaterThan(String value) {
            addCriterion("bidcard >", value, "bidcard");
            return (Criteria) this;
        }

        public Criteria andBidcardGreaterThanOrEqualTo(String value) {
            addCriterion("bidcard >=", value, "bidcard");
            return (Criteria) this;
        }

        public Criteria andBidcardLessThan(String value) {
            addCriterion("bidcard <", value, "bidcard");
            return (Criteria) this;
        }

        public Criteria andBidcardLessThanOrEqualTo(String value) {
            addCriterion("bidcard <=", value, "bidcard");
            return (Criteria) this;
        }

        public Criteria andBidcardLike(String value) {
            addCriterion("bidcard like", value, "bidcard");
            return (Criteria) this;
        }

        public Criteria andBidcardNotLike(String value) {
            addCriterion("bidcard not like", value, "bidcard");
            return (Criteria) this;
        }

        public Criteria andBidcardIn(List<String> values) {
            addCriterion("bidcard in", values, "bidcard");
            return (Criteria) this;
        }

        public Criteria andBidcardNotIn(List<String> values) {
            addCriterion("bidcard not in", values, "bidcard");
            return (Criteria) this;
        }

        public Criteria andBidcardBetween(String value1, String value2) {
            addCriterion("bidcard between", value1, value2, "bidcard");
            return (Criteria) this;
        }

        public Criteria andBidcardNotBetween(String value1, String value2) {
            addCriterion("bidcard not between", value1, value2, "bidcard");
            return (Criteria) this;
        }

        public Criteria andBcontactIsNull() {
            addCriterion("bcontact is null");
            return (Criteria) this;
        }

        public Criteria andBcontactIsNotNull() {
            addCriterion("bcontact is not null");
            return (Criteria) this;
        }

        public Criteria andBcontactEqualTo(String value) {
            addCriterion("bcontact =", value, "bcontact");
            return (Criteria) this;
        }

        public Criteria andBcontactNotEqualTo(String value) {
            addCriterion("bcontact <>", value, "bcontact");
            return (Criteria) this;
        }

        public Criteria andBcontactGreaterThan(String value) {
            addCriterion("bcontact >", value, "bcontact");
            return (Criteria) this;
        }

        public Criteria andBcontactGreaterThanOrEqualTo(String value) {
            addCriterion("bcontact >=", value, "bcontact");
            return (Criteria) this;
        }

        public Criteria andBcontactLessThan(String value) {
            addCriterion("bcontact <", value, "bcontact");
            return (Criteria) this;
        }

        public Criteria andBcontactLessThanOrEqualTo(String value) {
            addCriterion("bcontact <=", value, "bcontact");
            return (Criteria) this;
        }

        public Criteria andBcontactLike(String value) {
            addCriterion("bcontact like", value, "bcontact");
            return (Criteria) this;
        }

        public Criteria andBcontactNotLike(String value) {
            addCriterion("bcontact not like", value, "bcontact");
            return (Criteria) this;
        }

        public Criteria andBcontactIn(List<String> values) {
            addCriterion("bcontact in", values, "bcontact");
            return (Criteria) this;
        }

        public Criteria andBcontactNotIn(List<String> values) {
            addCriterion("bcontact not in", values, "bcontact");
            return (Criteria) this;
        }

        public Criteria andBcontactBetween(String value1, String value2) {
            addCriterion("bcontact between", value1, value2, "bcontact");
            return (Criteria) this;
        }

        public Criteria andBcontactNotBetween(String value1, String value2) {
            addCriterion("bcontact not between", value1, value2, "bcontact");
            return (Criteria) this;
        }

        public Criteria andBsexIsNull() {
            addCriterion("bsex is null");
            return (Criteria) this;
        }

        public Criteria andBsexIsNotNull() {
            addCriterion("bsex is not null");
            return (Criteria) this;
        }

        public Criteria andBsexEqualTo(String value) {
            addCriterion("bsex =", value, "bsex");
            return (Criteria) this;
        }

        public Criteria andBsexNotEqualTo(String value) {
            addCriterion("bsex <>", value, "bsex");
            return (Criteria) this;
        }

        public Criteria andBsexGreaterThan(String value) {
            addCriterion("bsex >", value, "bsex");
            return (Criteria) this;
        }

        public Criteria andBsexGreaterThanOrEqualTo(String value) {
            addCriterion("bsex >=", value, "bsex");
            return (Criteria) this;
        }

        public Criteria andBsexLessThan(String value) {
            addCriterion("bsex <", value, "bsex");
            return (Criteria) this;
        }

        public Criteria andBsexLessThanOrEqualTo(String value) {
            addCriterion("bsex <=", value, "bsex");
            return (Criteria) this;
        }

        public Criteria andBsexLike(String value) {
            addCriterion("bsex like", value, "bsex");
            return (Criteria) this;
        }

        public Criteria andBsexNotLike(String value) {
            addCriterion("bsex not like", value, "bsex");
            return (Criteria) this;
        }

        public Criteria andBsexIn(List<String> values) {
            addCriterion("bsex in", values, "bsex");
            return (Criteria) this;
        }

        public Criteria andBsexNotIn(List<String> values) {
            addCriterion("bsex not in", values, "bsex");
            return (Criteria) this;
        }

        public Criteria andBsexBetween(String value1, String value2) {
            addCriterion("bsex between", value1, value2, "bsex");
            return (Criteria) this;
        }

        public Criteria andBsexNotBetween(String value1, String value2) {
            addCriterion("bsex not between", value1, value2, "bsex");
            return (Criteria) this;
        }

        public Criteria andBaddressIsNull() {
            addCriterion("baddress is null");
            return (Criteria) this;
        }

        public Criteria andBaddressIsNotNull() {
            addCriterion("baddress is not null");
            return (Criteria) this;
        }

        public Criteria andBaddressEqualTo(String value) {
            addCriterion("baddress =", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressNotEqualTo(String value) {
            addCriterion("baddress <>", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressGreaterThan(String value) {
            addCriterion("baddress >", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressGreaterThanOrEqualTo(String value) {
            addCriterion("baddress >=", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressLessThan(String value) {
            addCriterion("baddress <", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressLessThanOrEqualTo(String value) {
            addCriterion("baddress <=", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressLike(String value) {
            addCriterion("baddress like", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressNotLike(String value) {
            addCriterion("baddress not like", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressIn(List<String> values) {
            addCriterion("baddress in", values, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressNotIn(List<String> values) {
            addCriterion("baddress not in", values, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressBetween(String value1, String value2) {
            addCriterion("baddress between", value1, value2, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressNotBetween(String value1, String value2) {
            addCriterion("baddress not between", value1, value2, "baddress");
            return (Criteria) this;
        }

        public Criteria andBsignIsNull() {
            addCriterion("bsign is null");
            return (Criteria) this;
        }

        public Criteria andBsignIsNotNull() {
            addCriterion("bsign is not null");
            return (Criteria) this;
        }

        public Criteria andBsignEqualTo(String value) {
            addCriterion("bsign =", value, "bsign");
            return (Criteria) this;
        }

        public Criteria andBsignNotEqualTo(String value) {
            addCriterion("bsign <>", value, "bsign");
            return (Criteria) this;
        }

        public Criteria andBsignGreaterThan(String value) {
            addCriterion("bsign >", value, "bsign");
            return (Criteria) this;
        }

        public Criteria andBsignGreaterThanOrEqualTo(String value) {
            addCriterion("bsign >=", value, "bsign");
            return (Criteria) this;
        }

        public Criteria andBsignLessThan(String value) {
            addCriterion("bsign <", value, "bsign");
            return (Criteria) this;
        }

        public Criteria andBsignLessThanOrEqualTo(String value) {
            addCriterion("bsign <=", value, "bsign");
            return (Criteria) this;
        }

        public Criteria andBsignLike(String value) {
            addCriterion("bsign like", value, "bsign");
            return (Criteria) this;
        }

        public Criteria andBsignNotLike(String value) {
            addCriterion("bsign not like", value, "bsign");
            return (Criteria) this;
        }

        public Criteria andBsignIn(List<String> values) {
            addCriterion("bsign in", values, "bsign");
            return (Criteria) this;
        }

        public Criteria andBsignNotIn(List<String> values) {
            addCriterion("bsign not in", values, "bsign");
            return (Criteria) this;
        }

        public Criteria andBsignBetween(String value1, String value2) {
            addCriterion("bsign between", value1, value2, "bsign");
            return (Criteria) this;
        }

        public Criteria andBsignNotBetween(String value1, String value2) {
            addCriterion("bsign not between", value1, value2, "bsign");
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

        public Criteria andBcancelEqualTo(Integer value) {
            addCriterion("bcancel =", value, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelNotEqualTo(Integer value) {
            addCriterion("bcancel <>", value, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelGreaterThan(Integer value) {
            addCriterion("bcancel >", value, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelGreaterThanOrEqualTo(Integer value) {
            addCriterion("bcancel >=", value, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelLessThan(Integer value) {
            addCriterion("bcancel <", value, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelLessThanOrEqualTo(Integer value) {
            addCriterion("bcancel <=", value, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelIn(List<Integer> values) {
            addCriterion("bcancel in", values, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelNotIn(List<Integer> values) {
            addCriterion("bcancel not in", values, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelBetween(Integer value1, Integer value2) {
            addCriterion("bcancel between", value1, value2, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcancelNotBetween(Integer value1, Integer value2) {
            addCriterion("bcancel not between", value1, value2, "bcancel");
            return (Criteria) this;
        }

        public Criteria andBcreditIsNull() {
            addCriterion("bcredit is null");
            return (Criteria) this;
        }

        public Criteria andBcreditIsNotNull() {
            addCriterion("bcredit is not null");
            return (Criteria) this;
        }

        public Criteria andBcreditEqualTo(String value) {
            addCriterion("bcredit =", value, "bcredit");
            return (Criteria) this;
        }

        public Criteria andBcreditNotEqualTo(String value) {
            addCriterion("bcredit <>", value, "bcredit");
            return (Criteria) this;
        }

        public Criteria andBcreditGreaterThan(String value) {
            addCriterion("bcredit >", value, "bcredit");
            return (Criteria) this;
        }

        public Criteria andBcreditGreaterThanOrEqualTo(String value) {
            addCriterion("bcredit >=", value, "bcredit");
            return (Criteria) this;
        }

        public Criteria andBcreditLessThan(String value) {
            addCriterion("bcredit <", value, "bcredit");
            return (Criteria) this;
        }

        public Criteria andBcreditLessThanOrEqualTo(String value) {
            addCriterion("bcredit <=", value, "bcredit");
            return (Criteria) this;
        }

        public Criteria andBcreditLike(String value) {
            addCriterion("bcredit like", value, "bcredit");
            return (Criteria) this;
        }

        public Criteria andBcreditNotLike(String value) {
            addCriterion("bcredit not like", value, "bcredit");
            return (Criteria) this;
        }

        public Criteria andBcreditIn(List<String> values) {
            addCriterion("bcredit in", values, "bcredit");
            return (Criteria) this;
        }

        public Criteria andBcreditNotIn(List<String> values) {
            addCriterion("bcredit not in", values, "bcredit");
            return (Criteria) this;
        }

        public Criteria andBcreditBetween(String value1, String value2) {
            addCriterion("bcredit between", value1, value2, "bcredit");
            return (Criteria) this;
        }

        public Criteria andBcreditNotBetween(String value1, String value2) {
            addCriterion("bcredit not between", value1, value2, "bcredit");
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

        public Criteria andBinsettimeIsNull() {
            addCriterion("binsettime is null");
            return (Criteria) this;
        }

        public Criteria andBinsettimeIsNotNull() {
            addCriterion("binsettime is not null");
            return (Criteria) this;
        }

        public Criteria andBinsettimeEqualTo(Date value) {
            addCriterion("binsettime =", value, "binsettime");
            return (Criteria) this;
        }

        public Criteria andBinsettimeNotEqualTo(Date value) {
            addCriterion("binsettime <>", value, "binsettime");
            return (Criteria) this;
        }

        public Criteria andBinsettimeGreaterThan(Date value) {
            addCriterion("binsettime >", value, "binsettime");
            return (Criteria) this;
        }

        public Criteria andBinsettimeGreaterThanOrEqualTo(Date value) {
            addCriterion("binsettime >=", value, "binsettime");
            return (Criteria) this;
        }

        public Criteria andBinsettimeLessThan(Date value) {
            addCriterion("binsettime <", value, "binsettime");
            return (Criteria) this;
        }

        public Criteria andBinsettimeLessThanOrEqualTo(Date value) {
            addCriterion("binsettime <=", value, "binsettime");
            return (Criteria) this;
        }

        public Criteria andBinsettimeIn(List<Date> values) {
            addCriterion("binsettime in", values, "binsettime");
            return (Criteria) this;
        }

        public Criteria andBinsettimeNotIn(List<Date> values) {
            addCriterion("binsettime not in", values, "binsettime");
            return (Criteria) this;
        }

        public Criteria andBinsettimeBetween(Date value1, Date value2) {
            addCriterion("binsettime between", value1, value2, "binsettime");
            return (Criteria) this;
        }

        public Criteria andBinsettimeNotBetween(Date value1, Date value2) {
            addCriterion("binsettime not between", value1, value2, "binsettime");
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