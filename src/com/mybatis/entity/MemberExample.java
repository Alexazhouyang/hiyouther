package com.mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberExample() {
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

        public Criteria andMidIsNull() {
            addCriterion("mid is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mid is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(Integer value) {
            addCriterion("mid =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(Integer value) {
            addCriterion("mid <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(Integer value) {
            addCriterion("mid >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mid >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(Integer value) {
            addCriterion("mid <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(Integer value) {
            addCriterion("mid <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<Integer> values) {
            addCriterion("mid in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<Integer> values) {
            addCriterion("mid not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(Integer value1, Integer value2) {
            addCriterion("mid between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(Integer value1, Integer value2) {
            addCriterion("mid not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMemnameIsNull() {
            addCriterion("memname is null");
            return (Criteria) this;
        }

        public Criteria andMemnameIsNotNull() {
            addCriterion("memname is not null");
            return (Criteria) this;
        }

        public Criteria andMemnameEqualTo(String value) {
            addCriterion("memname =", value, "memname");
            return (Criteria) this;
        }

        public Criteria andMemnameNotEqualTo(String value) {
            addCriterion("memname <>", value, "memname");
            return (Criteria) this;
        }

        public Criteria andMemnameGreaterThan(String value) {
            addCriterion("memname >", value, "memname");
            return (Criteria) this;
        }

        public Criteria andMemnameGreaterThanOrEqualTo(String value) {
            addCriterion("memname >=", value, "memname");
            return (Criteria) this;
        }

        public Criteria andMemnameLessThan(String value) {
            addCriterion("memname <", value, "memname");
            return (Criteria) this;
        }

        public Criteria andMemnameLessThanOrEqualTo(String value) {
            addCriterion("memname <=", value, "memname");
            return (Criteria) this;
        }

        public Criteria andMemnameLike(String value) {
            addCriterion("memname like", value, "memname");
            return (Criteria) this;
        }

        public Criteria andMemnameNotLike(String value) {
            addCriterion("memname not like", value, "memname");
            return (Criteria) this;
        }

        public Criteria andMemnameIn(List<String> values) {
            addCriterion("memname in", values, "memname");
            return (Criteria) this;
        }

        public Criteria andMemnameNotIn(List<String> values) {
            addCriterion("memname not in", values, "memname");
            return (Criteria) this;
        }

        public Criteria andMemnameBetween(String value1, String value2) {
            addCriterion("memname between", value1, value2, "memname");
            return (Criteria) this;
        }

        public Criteria andMemnameNotBetween(String value1, String value2) {
            addCriterion("memname not between", value1, value2, "memname");
            return (Criteria) this;
        }

        public Criteria andMtouxiangIsNull() {
            addCriterion("mtouxiang is null");
            return (Criteria) this;
        }

        public Criteria andMtouxiangIsNotNull() {
            addCriterion("mtouxiang is not null");
            return (Criteria) this;
        }

        public Criteria andMtouxiangEqualTo(String value) {
            addCriterion("mtouxiang =", value, "mtouxiang");
            return (Criteria) this;
        }

        public Criteria andMtouxiangNotEqualTo(String value) {
            addCriterion("mtouxiang <>", value, "mtouxiang");
            return (Criteria) this;
        }

        public Criteria andMtouxiangGreaterThan(String value) {
            addCriterion("mtouxiang >", value, "mtouxiang");
            return (Criteria) this;
        }

        public Criteria andMtouxiangGreaterThanOrEqualTo(String value) {
            addCriterion("mtouxiang >=", value, "mtouxiang");
            return (Criteria) this;
        }

        public Criteria andMtouxiangLessThan(String value) {
            addCriterion("mtouxiang <", value, "mtouxiang");
            return (Criteria) this;
        }

        public Criteria andMtouxiangLessThanOrEqualTo(String value) {
            addCriterion("mtouxiang <=", value, "mtouxiang");
            return (Criteria) this;
        }

        public Criteria andMtouxiangLike(String value) {
            addCriterion("mtouxiang like", value, "mtouxiang");
            return (Criteria) this;
        }

        public Criteria andMtouxiangNotLike(String value) {
            addCriterion("mtouxiang not like", value, "mtouxiang");
            return (Criteria) this;
        }

        public Criteria andMtouxiangIn(List<String> values) {
            addCriterion("mtouxiang in", values, "mtouxiang");
            return (Criteria) this;
        }

        public Criteria andMtouxiangNotIn(List<String> values) {
            addCriterion("mtouxiang not in", values, "mtouxiang");
            return (Criteria) this;
        }

        public Criteria andMtouxiangBetween(String value1, String value2) {
            addCriterion("mtouxiang between", value1, value2, "mtouxiang");
            return (Criteria) this;
        }

        public Criteria andMtouxiangNotBetween(String value1, String value2) {
            addCriterion("mtouxiang not between", value1, value2, "mtouxiang");
            return (Criteria) this;
        }

        public Criteria andMtelIsNull() {
            addCriterion("mtel is null");
            return (Criteria) this;
        }

        public Criteria andMtelIsNotNull() {
            addCriterion("mtel is not null");
            return (Criteria) this;
        }

        public Criteria andMtelEqualTo(String value) {
            addCriterion("mtel =", value, "mtel");
            return (Criteria) this;
        }

        public Criteria andMtelNotEqualTo(String value) {
            addCriterion("mtel <>", value, "mtel");
            return (Criteria) this;
        }

        public Criteria andMtelGreaterThan(String value) {
            addCriterion("mtel >", value, "mtel");
            return (Criteria) this;
        }

        public Criteria andMtelGreaterThanOrEqualTo(String value) {
            addCriterion("mtel >=", value, "mtel");
            return (Criteria) this;
        }

        public Criteria andMtelLessThan(String value) {
            addCriterion("mtel <", value, "mtel");
            return (Criteria) this;
        }

        public Criteria andMtelLessThanOrEqualTo(String value) {
            addCriterion("mtel <=", value, "mtel");
            return (Criteria) this;
        }

        public Criteria andMtelLike(String value) {
            addCriterion("mtel like", value, "mtel");
            return (Criteria) this;
        }

        public Criteria andMtelNotLike(String value) {
            addCriterion("mtel not like", value, "mtel");
            return (Criteria) this;
        }

        public Criteria andMtelIn(List<String> values) {
            addCriterion("mtel in", values, "mtel");
            return (Criteria) this;
        }

        public Criteria andMtelNotIn(List<String> values) {
            addCriterion("mtel not in", values, "mtel");
            return (Criteria) this;
        }

        public Criteria andMtelBetween(String value1, String value2) {
            addCriterion("mtel between", value1, value2, "mtel");
            return (Criteria) this;
        }

        public Criteria andMtelNotBetween(String value1, String value2) {
            addCriterion("mtel not between", value1, value2, "mtel");
            return (Criteria) this;
        }

        public Criteria andMphoneIsNull() {
            addCriterion("mphone is null");
            return (Criteria) this;
        }

        public Criteria andMphoneIsNotNull() {
            addCriterion("mphone is not null");
            return (Criteria) this;
        }

        public Criteria andMphoneEqualTo(String value) {
            addCriterion("mphone =", value, "mphone");
            return (Criteria) this;
        }

        public Criteria andMphoneNotEqualTo(String value) {
            addCriterion("mphone <>", value, "mphone");
            return (Criteria) this;
        }

        public Criteria andMphoneGreaterThan(String value) {
            addCriterion("mphone >", value, "mphone");
            return (Criteria) this;
        }

        public Criteria andMphoneGreaterThanOrEqualTo(String value) {
            addCriterion("mphone >=", value, "mphone");
            return (Criteria) this;
        }

        public Criteria andMphoneLessThan(String value) {
            addCriterion("mphone <", value, "mphone");
            return (Criteria) this;
        }

        public Criteria andMphoneLessThanOrEqualTo(String value) {
            addCriterion("mphone <=", value, "mphone");
            return (Criteria) this;
        }

        public Criteria andMphoneLike(String value) {
            addCriterion("mphone like", value, "mphone");
            return (Criteria) this;
        }

        public Criteria andMphoneNotLike(String value) {
            addCriterion("mphone not like", value, "mphone");
            return (Criteria) this;
        }

        public Criteria andMphoneIn(List<String> values) {
            addCriterion("mphone in", values, "mphone");
            return (Criteria) this;
        }

        public Criteria andMphoneNotIn(List<String> values) {
            addCriterion("mphone not in", values, "mphone");
            return (Criteria) this;
        }

        public Criteria andMphoneBetween(String value1, String value2) {
            addCriterion("mphone between", value1, value2, "mphone");
            return (Criteria) this;
        }

        public Criteria andMphoneNotBetween(String value1, String value2) {
            addCriterion("mphone not between", value1, value2, "mphone");
            return (Criteria) this;
        }

        public Criteria andMqqIsNull() {
            addCriterion("mqq is null");
            return (Criteria) this;
        }

        public Criteria andMqqIsNotNull() {
            addCriterion("mqq is not null");
            return (Criteria) this;
        }

        public Criteria andMqqEqualTo(String value) {
            addCriterion("mqq =", value, "mqq");
            return (Criteria) this;
        }

        public Criteria andMqqNotEqualTo(String value) {
            addCriterion("mqq <>", value, "mqq");
            return (Criteria) this;
        }

        public Criteria andMqqGreaterThan(String value) {
            addCriterion("mqq >", value, "mqq");
            return (Criteria) this;
        }

        public Criteria andMqqGreaterThanOrEqualTo(String value) {
            addCriterion("mqq >=", value, "mqq");
            return (Criteria) this;
        }

        public Criteria andMqqLessThan(String value) {
            addCriterion("mqq <", value, "mqq");
            return (Criteria) this;
        }

        public Criteria andMqqLessThanOrEqualTo(String value) {
            addCriterion("mqq <=", value, "mqq");
            return (Criteria) this;
        }

        public Criteria andMqqLike(String value) {
            addCriterion("mqq like", value, "mqq");
            return (Criteria) this;
        }

        public Criteria andMqqNotLike(String value) {
            addCriterion("mqq not like", value, "mqq");
            return (Criteria) this;
        }

        public Criteria andMqqIn(List<String> values) {
            addCriterion("mqq in", values, "mqq");
            return (Criteria) this;
        }

        public Criteria andMqqNotIn(List<String> values) {
            addCriterion("mqq not in", values, "mqq");
            return (Criteria) this;
        }

        public Criteria andMqqBetween(String value1, String value2) {
            addCriterion("mqq between", value1, value2, "mqq");
            return (Criteria) this;
        }

        public Criteria andMqqNotBetween(String value1, String value2) {
            addCriterion("mqq not between", value1, value2, "mqq");
            return (Criteria) this;
        }

        public Criteria andMemailIsNull() {
            addCriterion("memail is null");
            return (Criteria) this;
        }

        public Criteria andMemailIsNotNull() {
            addCriterion("memail is not null");
            return (Criteria) this;
        }

        public Criteria andMemailEqualTo(String value) {
            addCriterion("memail =", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailNotEqualTo(String value) {
            addCriterion("memail <>", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailGreaterThan(String value) {
            addCriterion("memail >", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailGreaterThanOrEqualTo(String value) {
            addCriterion("memail >=", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailLessThan(String value) {
            addCriterion("memail <", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailLessThanOrEqualTo(String value) {
            addCriterion("memail <=", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailLike(String value) {
            addCriterion("memail like", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailNotLike(String value) {
            addCriterion("memail not like", value, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailIn(List<String> values) {
            addCriterion("memail in", values, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailNotIn(List<String> values) {
            addCriterion("memail not in", values, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailBetween(String value1, String value2) {
            addCriterion("memail between", value1, value2, "memail");
            return (Criteria) this;
        }

        public Criteria andMemailNotBetween(String value1, String value2) {
            addCriterion("memail not between", value1, value2, "memail");
            return (Criteria) this;
        }

        public Criteria andMweiboIsNull() {
            addCriterion("mweibo is null");
            return (Criteria) this;
        }

        public Criteria andMweiboIsNotNull() {
            addCriterion("mweibo is not null");
            return (Criteria) this;
        }

        public Criteria andMweiboEqualTo(String value) {
            addCriterion("mweibo =", value, "mweibo");
            return (Criteria) this;
        }

        public Criteria andMweiboNotEqualTo(String value) {
            addCriterion("mweibo <>", value, "mweibo");
            return (Criteria) this;
        }

        public Criteria andMweiboGreaterThan(String value) {
            addCriterion("mweibo >", value, "mweibo");
            return (Criteria) this;
        }

        public Criteria andMweiboGreaterThanOrEqualTo(String value) {
            addCriterion("mweibo >=", value, "mweibo");
            return (Criteria) this;
        }

        public Criteria andMweiboLessThan(String value) {
            addCriterion("mweibo <", value, "mweibo");
            return (Criteria) this;
        }

        public Criteria andMweiboLessThanOrEqualTo(String value) {
            addCriterion("mweibo <=", value, "mweibo");
            return (Criteria) this;
        }

        public Criteria andMweiboLike(String value) {
            addCriterion("mweibo like", value, "mweibo");
            return (Criteria) this;
        }

        public Criteria andMweiboNotLike(String value) {
            addCriterion("mweibo not like", value, "mweibo");
            return (Criteria) this;
        }

        public Criteria andMweiboIn(List<String> values) {
            addCriterion("mweibo in", values, "mweibo");
            return (Criteria) this;
        }

        public Criteria andMweiboNotIn(List<String> values) {
            addCriterion("mweibo not in", values, "mweibo");
            return (Criteria) this;
        }

        public Criteria andMweiboBetween(String value1, String value2) {
            addCriterion("mweibo between", value1, value2, "mweibo");
            return (Criteria) this;
        }

        public Criteria andMweiboNotBetween(String value1, String value2) {
            addCriterion("mweibo not between", value1, value2, "mweibo");
            return (Criteria) this;
        }

        public Criteria andMwechatIsNull() {
            addCriterion("mwechat is null");
            return (Criteria) this;
        }

        public Criteria andMwechatIsNotNull() {
            addCriterion("mwechat is not null");
            return (Criteria) this;
        }

        public Criteria andMwechatEqualTo(String value) {
            addCriterion("mwechat =", value, "mwechat");
            return (Criteria) this;
        }

        public Criteria andMwechatNotEqualTo(String value) {
            addCriterion("mwechat <>", value, "mwechat");
            return (Criteria) this;
        }

        public Criteria andMwechatGreaterThan(String value) {
            addCriterion("mwechat >", value, "mwechat");
            return (Criteria) this;
        }

        public Criteria andMwechatGreaterThanOrEqualTo(String value) {
            addCriterion("mwechat >=", value, "mwechat");
            return (Criteria) this;
        }

        public Criteria andMwechatLessThan(String value) {
            addCriterion("mwechat <", value, "mwechat");
            return (Criteria) this;
        }

        public Criteria andMwechatLessThanOrEqualTo(String value) {
            addCriterion("mwechat <=", value, "mwechat");
            return (Criteria) this;
        }

        public Criteria andMwechatLike(String value) {
            addCriterion("mwechat like", value, "mwechat");
            return (Criteria) this;
        }

        public Criteria andMwechatNotLike(String value) {
            addCriterion("mwechat not like", value, "mwechat");
            return (Criteria) this;
        }

        public Criteria andMwechatIn(List<String> values) {
            addCriterion("mwechat in", values, "mwechat");
            return (Criteria) this;
        }

        public Criteria andMwechatNotIn(List<String> values) {
            addCriterion("mwechat not in", values, "mwechat");
            return (Criteria) this;
        }

        public Criteria andMwechatBetween(String value1, String value2) {
            addCriterion("mwechat between", value1, value2, "mwechat");
            return (Criteria) this;
        }

        public Criteria andMwechatNotBetween(String value1, String value2) {
            addCriterion("mwechat not between", value1, value2, "mwechat");
            return (Criteria) this;
        }

        public Criteria andMpasswordIsNull() {
            addCriterion("mpassword is null");
            return (Criteria) this;
        }

        public Criteria andMpasswordIsNotNull() {
            addCriterion("mpassword is not null");
            return (Criteria) this;
        }

        public Criteria andMpasswordEqualTo(String value) {
            addCriterion("mpassword =", value, "mpassword");
            return (Criteria) this;
        }

        public Criteria andMpasswordNotEqualTo(String value) {
            addCriterion("mpassword <>", value, "mpassword");
            return (Criteria) this;
        }

        public Criteria andMpasswordGreaterThan(String value) {
            addCriterion("mpassword >", value, "mpassword");
            return (Criteria) this;
        }

        public Criteria andMpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("mpassword >=", value, "mpassword");
            return (Criteria) this;
        }

        public Criteria andMpasswordLessThan(String value) {
            addCriterion("mpassword <", value, "mpassword");
            return (Criteria) this;
        }

        public Criteria andMpasswordLessThanOrEqualTo(String value) {
            addCriterion("mpassword <=", value, "mpassword");
            return (Criteria) this;
        }

        public Criteria andMpasswordLike(String value) {
            addCriterion("mpassword like", value, "mpassword");
            return (Criteria) this;
        }

        public Criteria andMpasswordNotLike(String value) {
            addCriterion("mpassword not like", value, "mpassword");
            return (Criteria) this;
        }

        public Criteria andMpasswordIn(List<String> values) {
            addCriterion("mpassword in", values, "mpassword");
            return (Criteria) this;
        }

        public Criteria andMpasswordNotIn(List<String> values) {
            addCriterion("mpassword not in", values, "mpassword");
            return (Criteria) this;
        }

        public Criteria andMpasswordBetween(String value1, String value2) {
            addCriterion("mpassword between", value1, value2, "mpassword");
            return (Criteria) this;
        }

        public Criteria andMpasswordNotBetween(String value1, String value2) {
            addCriterion("mpassword not between", value1, value2, "mpassword");
            return (Criteria) this;
        }

        public Criteria andMrealnameIsNull() {
            addCriterion("mrealname is null");
            return (Criteria) this;
        }

        public Criteria andMrealnameIsNotNull() {
            addCriterion("mrealname is not null");
            return (Criteria) this;
        }

        public Criteria andMrealnameEqualTo(String value) {
            addCriterion("mrealname =", value, "mrealname");
            return (Criteria) this;
        }

        public Criteria andMrealnameNotEqualTo(String value) {
            addCriterion("mrealname <>", value, "mrealname");
            return (Criteria) this;
        }

        public Criteria andMrealnameGreaterThan(String value) {
            addCriterion("mrealname >", value, "mrealname");
            return (Criteria) this;
        }

        public Criteria andMrealnameGreaterThanOrEqualTo(String value) {
            addCriterion("mrealname >=", value, "mrealname");
            return (Criteria) this;
        }

        public Criteria andMrealnameLessThan(String value) {
            addCriterion("mrealname <", value, "mrealname");
            return (Criteria) this;
        }

        public Criteria andMrealnameLessThanOrEqualTo(String value) {
            addCriterion("mrealname <=", value, "mrealname");
            return (Criteria) this;
        }

        public Criteria andMrealnameLike(String value) {
            addCriterion("mrealname like", value, "mrealname");
            return (Criteria) this;
        }

        public Criteria andMrealnameNotLike(String value) {
            addCriterion("mrealname not like", value, "mrealname");
            return (Criteria) this;
        }

        public Criteria andMrealnameIn(List<String> values) {
            addCriterion("mrealname in", values, "mrealname");
            return (Criteria) this;
        }

        public Criteria andMrealnameNotIn(List<String> values) {
            addCriterion("mrealname not in", values, "mrealname");
            return (Criteria) this;
        }

        public Criteria andMrealnameBetween(String value1, String value2) {
            addCriterion("mrealname between", value1, value2, "mrealname");
            return (Criteria) this;
        }

        public Criteria andMrealnameNotBetween(String value1, String value2) {
            addCriterion("mrealname not between", value1, value2, "mrealname");
            return (Criteria) this;
        }

        public Criteria andMidcardIsNull() {
            addCriterion("midcard is null");
            return (Criteria) this;
        }

        public Criteria andMidcardIsNotNull() {
            addCriterion("midcard is not null");
            return (Criteria) this;
        }

        public Criteria andMidcardEqualTo(String value) {
            addCriterion("midcard =", value, "midcard");
            return (Criteria) this;
        }

        public Criteria andMidcardNotEqualTo(String value) {
            addCriterion("midcard <>", value, "midcard");
            return (Criteria) this;
        }

        public Criteria andMidcardGreaterThan(String value) {
            addCriterion("midcard >", value, "midcard");
            return (Criteria) this;
        }

        public Criteria andMidcardGreaterThanOrEqualTo(String value) {
            addCriterion("midcard >=", value, "midcard");
            return (Criteria) this;
        }

        public Criteria andMidcardLessThan(String value) {
            addCriterion("midcard <", value, "midcard");
            return (Criteria) this;
        }

        public Criteria andMidcardLessThanOrEqualTo(String value) {
            addCriterion("midcard <=", value, "midcard");
            return (Criteria) this;
        }

        public Criteria andMidcardLike(String value) {
            addCriterion("midcard like", value, "midcard");
            return (Criteria) this;
        }

        public Criteria andMidcardNotLike(String value) {
            addCriterion("midcard not like", value, "midcard");
            return (Criteria) this;
        }

        public Criteria andMidcardIn(List<String> values) {
            addCriterion("midcard in", values, "midcard");
            return (Criteria) this;
        }

        public Criteria andMidcardNotIn(List<String> values) {
            addCriterion("midcard not in", values, "midcard");
            return (Criteria) this;
        }

        public Criteria andMidcardBetween(String value1, String value2) {
            addCriterion("midcard between", value1, value2, "midcard");
            return (Criteria) this;
        }

        public Criteria andMidcardNotBetween(String value1, String value2) {
            addCriterion("midcard not between", value1, value2, "midcard");
            return (Criteria) this;
        }

        public Criteria andMcontactIsNull() {
            addCriterion("mcontact is null");
            return (Criteria) this;
        }

        public Criteria andMcontactIsNotNull() {
            addCriterion("mcontact is not null");
            return (Criteria) this;
        }

        public Criteria andMcontactEqualTo(String value) {
            addCriterion("mcontact =", value, "mcontact");
            return (Criteria) this;
        }

        public Criteria andMcontactNotEqualTo(String value) {
            addCriterion("mcontact <>", value, "mcontact");
            return (Criteria) this;
        }

        public Criteria andMcontactGreaterThan(String value) {
            addCriterion("mcontact >", value, "mcontact");
            return (Criteria) this;
        }

        public Criteria andMcontactGreaterThanOrEqualTo(String value) {
            addCriterion("mcontact >=", value, "mcontact");
            return (Criteria) this;
        }

        public Criteria andMcontactLessThan(String value) {
            addCriterion("mcontact <", value, "mcontact");
            return (Criteria) this;
        }

        public Criteria andMcontactLessThanOrEqualTo(String value) {
            addCriterion("mcontact <=", value, "mcontact");
            return (Criteria) this;
        }

        public Criteria andMcontactLike(String value) {
            addCriterion("mcontact like", value, "mcontact");
            return (Criteria) this;
        }

        public Criteria andMcontactNotLike(String value) {
            addCriterion("mcontact not like", value, "mcontact");
            return (Criteria) this;
        }

        public Criteria andMcontactIn(List<String> values) {
            addCriterion("mcontact in", values, "mcontact");
            return (Criteria) this;
        }

        public Criteria andMcontactNotIn(List<String> values) {
            addCriterion("mcontact not in", values, "mcontact");
            return (Criteria) this;
        }

        public Criteria andMcontactBetween(String value1, String value2) {
            addCriterion("mcontact between", value1, value2, "mcontact");
            return (Criteria) this;
        }

        public Criteria andMcontactNotBetween(String value1, String value2) {
            addCriterion("mcontact not between", value1, value2, "mcontact");
            return (Criteria) this;
        }

        public Criteria andMsexIsNull() {
            addCriterion("msex is null");
            return (Criteria) this;
        }

        public Criteria andMsexIsNotNull() {
            addCriterion("msex is not null");
            return (Criteria) this;
        }

        public Criteria andMsexEqualTo(String value) {
            addCriterion("msex =", value, "msex");
            return (Criteria) this;
        }

        public Criteria andMsexNotEqualTo(String value) {
            addCriterion("msex <>", value, "msex");
            return (Criteria) this;
        }

        public Criteria andMsexGreaterThan(String value) {
            addCriterion("msex >", value, "msex");
            return (Criteria) this;
        }

        public Criteria andMsexGreaterThanOrEqualTo(String value) {
            addCriterion("msex >=", value, "msex");
            return (Criteria) this;
        }

        public Criteria andMsexLessThan(String value) {
            addCriterion("msex <", value, "msex");
            return (Criteria) this;
        }

        public Criteria andMsexLessThanOrEqualTo(String value) {
            addCriterion("msex <=", value, "msex");
            return (Criteria) this;
        }

        public Criteria andMsexLike(String value) {
            addCriterion("msex like", value, "msex");
            return (Criteria) this;
        }

        public Criteria andMsexNotLike(String value) {
            addCriterion("msex not like", value, "msex");
            return (Criteria) this;
        }

        public Criteria andMsexIn(List<String> values) {
            addCriterion("msex in", values, "msex");
            return (Criteria) this;
        }

        public Criteria andMsexNotIn(List<String> values) {
            addCriterion("msex not in", values, "msex");
            return (Criteria) this;
        }

        public Criteria andMsexBetween(String value1, String value2) {
            addCriterion("msex between", value1, value2, "msex");
            return (Criteria) this;
        }

        public Criteria andMsexNotBetween(String value1, String value2) {
            addCriterion("msex not between", value1, value2, "msex");
            return (Criteria) this;
        }

        public Criteria andMaddressIsNull() {
            addCriterion("maddress is null");
            return (Criteria) this;
        }

        public Criteria andMaddressIsNotNull() {
            addCriterion("maddress is not null");
            return (Criteria) this;
        }

        public Criteria andMaddressEqualTo(String value) {
            addCriterion("maddress =", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressNotEqualTo(String value) {
            addCriterion("maddress <>", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressGreaterThan(String value) {
            addCriterion("maddress >", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressGreaterThanOrEqualTo(String value) {
            addCriterion("maddress >=", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressLessThan(String value) {
            addCriterion("maddress <", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressLessThanOrEqualTo(String value) {
            addCriterion("maddress <=", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressLike(String value) {
            addCriterion("maddress like", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressNotLike(String value) {
            addCriterion("maddress not like", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressIn(List<String> values) {
            addCriterion("maddress in", values, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressNotIn(List<String> values) {
            addCriterion("maddress not in", values, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressBetween(String value1, String value2) {
            addCriterion("maddress between", value1, value2, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressNotBetween(String value1, String value2) {
            addCriterion("maddress not between", value1, value2, "maddress");
            return (Criteria) this;
        }

        public Criteria andMsignIsNull() {
            addCriterion("msign is null");
            return (Criteria) this;
        }

        public Criteria andMsignIsNotNull() {
            addCriterion("msign is not null");
            return (Criteria) this;
        }

        public Criteria andMsignEqualTo(String value) {
            addCriterion("msign =", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignNotEqualTo(String value) {
            addCriterion("msign <>", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignGreaterThan(String value) {
            addCriterion("msign >", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignGreaterThanOrEqualTo(String value) {
            addCriterion("msign >=", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignLessThan(String value) {
            addCriterion("msign <", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignLessThanOrEqualTo(String value) {
            addCriterion("msign <=", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignLike(String value) {
            addCriterion("msign like", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignNotLike(String value) {
            addCriterion("msign not like", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignIn(List<String> values) {
            addCriterion("msign in", values, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignNotIn(List<String> values) {
            addCriterion("msign not in", values, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignBetween(String value1, String value2) {
            addCriterion("msign between", value1, value2, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignNotBetween(String value1, String value2) {
            addCriterion("msign not between", value1, value2, "msign");
            return (Criteria) this;
        }

        public Criteria andMcancelIsNull() {
            addCriterion("mcancel is null");
            return (Criteria) this;
        }

        public Criteria andMcancelIsNotNull() {
            addCriterion("mcancel is not null");
            return (Criteria) this;
        }

        public Criteria andMcancelEqualTo(String value) {
            addCriterion("mcancel =", value, "mcancel");
            return (Criteria) this;
        }

        public Criteria andMcancelNotEqualTo(String value) {
            addCriterion("mcancel <>", value, "mcancel");
            return (Criteria) this;
        }

        public Criteria andMcancelGreaterThan(String value) {
            addCriterion("mcancel >", value, "mcancel");
            return (Criteria) this;
        }

        public Criteria andMcancelGreaterThanOrEqualTo(String value) {
            addCriterion("mcancel >=", value, "mcancel");
            return (Criteria) this;
        }

        public Criteria andMcancelLessThan(String value) {
            addCriterion("mcancel <", value, "mcancel");
            return (Criteria) this;
        }

        public Criteria andMcancelLessThanOrEqualTo(String value) {
            addCriterion("mcancel <=", value, "mcancel");
            return (Criteria) this;
        }

        public Criteria andMcancelLike(String value) {
            addCriterion("mcancel like", value, "mcancel");
            return (Criteria) this;
        }

        public Criteria andMcancelNotLike(String value) {
            addCriterion("mcancel not like", value, "mcancel");
            return (Criteria) this;
        }

        public Criteria andMcancelIn(List<String> values) {
            addCriterion("mcancel in", values, "mcancel");
            return (Criteria) this;
        }

        public Criteria andMcancelNotIn(List<String> values) {
            addCriterion("mcancel not in", values, "mcancel");
            return (Criteria) this;
        }

        public Criteria andMcancelBetween(String value1, String value2) {
            addCriterion("mcancel between", value1, value2, "mcancel");
            return (Criteria) this;
        }

        public Criteria andMcancelNotBetween(String value1, String value2) {
            addCriterion("mcancel not between", value1, value2, "mcancel");
            return (Criteria) this;
        }

        public Criteria andMcreditIsNull() {
            addCriterion("mcredit is null");
            return (Criteria) this;
        }

        public Criteria andMcreditIsNotNull() {
            addCriterion("mcredit is not null");
            return (Criteria) this;
        }

        public Criteria andMcreditEqualTo(String value) {
            addCriterion("mcredit =", value, "mcredit");
            return (Criteria) this;
        }

        public Criteria andMcreditNotEqualTo(String value) {
            addCriterion("mcredit <>", value, "mcredit");
            return (Criteria) this;
        }

        public Criteria andMcreditGreaterThan(String value) {
            addCriterion("mcredit >", value, "mcredit");
            return (Criteria) this;
        }

        public Criteria andMcreditGreaterThanOrEqualTo(String value) {
            addCriterion("mcredit >=", value, "mcredit");
            return (Criteria) this;
        }

        public Criteria andMcreditLessThan(String value) {
            addCriterion("mcredit <", value, "mcredit");
            return (Criteria) this;
        }

        public Criteria andMcreditLessThanOrEqualTo(String value) {
            addCriterion("mcredit <=", value, "mcredit");
            return (Criteria) this;
        }

        public Criteria andMcreditLike(String value) {
            addCriterion("mcredit like", value, "mcredit");
            return (Criteria) this;
        }

        public Criteria andMcreditNotLike(String value) {
            addCriterion("mcredit not like", value, "mcredit");
            return (Criteria) this;
        }

        public Criteria andMcreditIn(List<String> values) {
            addCriterion("mcredit in", values, "mcredit");
            return (Criteria) this;
        }

        public Criteria andMcreditNotIn(List<String> values) {
            addCriterion("mcredit not in", values, "mcredit");
            return (Criteria) this;
        }

        public Criteria andMcreditBetween(String value1, String value2) {
            addCriterion("mcredit between", value1, value2, "mcredit");
            return (Criteria) this;
        }

        public Criteria andMcreditNotBetween(String value1, String value2) {
            addCriterion("mcredit not between", value1, value2, "mcredit");
            return (Criteria) this;
        }

        public Criteria andMreportIsNull() {
            addCriterion("mreport is null");
            return (Criteria) this;
        }

        public Criteria andMreportIsNotNull() {
            addCriterion("mreport is not null");
            return (Criteria) this;
        }

        public Criteria andMreportEqualTo(String value) {
            addCriterion("mreport =", value, "mreport");
            return (Criteria) this;
        }

        public Criteria andMreportNotEqualTo(String value) {
            addCriterion("mreport <>", value, "mreport");
            return (Criteria) this;
        }

        public Criteria andMreportGreaterThan(String value) {
            addCriterion("mreport >", value, "mreport");
            return (Criteria) this;
        }

        public Criteria andMreportGreaterThanOrEqualTo(String value) {
            addCriterion("mreport >=", value, "mreport");
            return (Criteria) this;
        }

        public Criteria andMreportLessThan(String value) {
            addCriterion("mreport <", value, "mreport");
            return (Criteria) this;
        }

        public Criteria andMreportLessThanOrEqualTo(String value) {
            addCriterion("mreport <=", value, "mreport");
            return (Criteria) this;
        }

        public Criteria andMreportLike(String value) {
            addCriterion("mreport like", value, "mreport");
            return (Criteria) this;
        }

        public Criteria andMreportNotLike(String value) {
            addCriterion("mreport not like", value, "mreport");
            return (Criteria) this;
        }

        public Criteria andMreportIn(List<String> values) {
            addCriterion("mreport in", values, "mreport");
            return (Criteria) this;
        }

        public Criteria andMreportNotIn(List<String> values) {
            addCriterion("mreport not in", values, "mreport");
            return (Criteria) this;
        }

        public Criteria andMreportBetween(String value1, String value2) {
            addCriterion("mreport between", value1, value2, "mreport");
            return (Criteria) this;
        }

        public Criteria andMreportNotBetween(String value1, String value2) {
            addCriterion("mreport not between", value1, value2, "mreport");
            return (Criteria) this;
        }

        public Criteria andMresumeIsNull() {
            addCriterion("mresume is null");
            return (Criteria) this;
        }

        public Criteria andMresumeIsNotNull() {
            addCriterion("mresume is not null");
            return (Criteria) this;
        }

        public Criteria andMresumeEqualTo(String value) {
            addCriterion("mresume =", value, "mresume");
            return (Criteria) this;
        }

        public Criteria andMresumeNotEqualTo(String value) {
            addCriterion("mresume <>", value, "mresume");
            return (Criteria) this;
        }

        public Criteria andMresumeGreaterThan(String value) {
            addCriterion("mresume >", value, "mresume");
            return (Criteria) this;
        }

        public Criteria andMresumeGreaterThanOrEqualTo(String value) {
            addCriterion("mresume >=", value, "mresume");
            return (Criteria) this;
        }

        public Criteria andMresumeLessThan(String value) {
            addCriterion("mresume <", value, "mresume");
            return (Criteria) this;
        }

        public Criteria andMresumeLessThanOrEqualTo(String value) {
            addCriterion("mresume <=", value, "mresume");
            return (Criteria) this;
        }

        public Criteria andMresumeLike(String value) {
            addCriterion("mresume like", value, "mresume");
            return (Criteria) this;
        }

        public Criteria andMresumeNotLike(String value) {
            addCriterion("mresume not like", value, "mresume");
            return (Criteria) this;
        }

        public Criteria andMresumeIn(List<String> values) {
            addCriterion("mresume in", values, "mresume");
            return (Criteria) this;
        }

        public Criteria andMresumeNotIn(List<String> values) {
            addCriterion("mresume not in", values, "mresume");
            return (Criteria) this;
        }

        public Criteria andMresumeBetween(String value1, String value2) {
            addCriterion("mresume between", value1, value2, "mresume");
            return (Criteria) this;
        }

        public Criteria andMresumeNotBetween(String value1, String value2) {
            addCriterion("mresume not between", value1, value2, "mresume");
            return (Criteria) this;
        }

        public Criteria andMinsettimeIsNull() {
            addCriterion("minsettime is null");
            return (Criteria) this;
        }

        public Criteria andMinsettimeIsNotNull() {
            addCriterion("minsettime is not null");
            return (Criteria) this;
        }

        public Criteria andMinsettimeEqualTo(Date value) {
            addCriterion("minsettime =", value, "minsettime");
            return (Criteria) this;
        }

        public Criteria andMinsettimeNotEqualTo(Date value) {
            addCriterion("minsettime <>", value, "minsettime");
            return (Criteria) this;
        }

        public Criteria andMinsettimeGreaterThan(Date value) {
            addCriterion("minsettime >", value, "minsettime");
            return (Criteria) this;
        }

        public Criteria andMinsettimeGreaterThanOrEqualTo(Date value) {
            addCriterion("minsettime >=", value, "minsettime");
            return (Criteria) this;
        }

        public Criteria andMinsettimeLessThan(Date value) {
            addCriterion("minsettime <", value, "minsettime");
            return (Criteria) this;
        }

        public Criteria andMinsettimeLessThanOrEqualTo(Date value) {
            addCriterion("minsettime <=", value, "minsettime");
            return (Criteria) this;
        }

        public Criteria andMinsettimeIn(List<Date> values) {
            addCriterion("minsettime in", values, "minsettime");
            return (Criteria) this;
        }

        public Criteria andMinsettimeNotIn(List<Date> values) {
            addCriterion("minsettime not in", values, "minsettime");
            return (Criteria) this;
        }

        public Criteria andMinsettimeBetween(Date value1, Date value2) {
            addCriterion("minsettime between", value1, value2, "minsettime");
            return (Criteria) this;
        }

        public Criteria andMinsettimeNotBetween(Date value1, Date value2) {
            addCriterion("minsettime not between", value1, value2, "minsettime");
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