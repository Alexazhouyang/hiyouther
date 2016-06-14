package com.mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OtherpushExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OtherpushExample() {
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

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Integer value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Integer value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Integer value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Integer value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Integer value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Integer value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Integer> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Integer> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Integer value1, Integer value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Integer value1, Integer value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andPushtimeIsNull() {
            addCriterion("pushtime is null");
            return (Criteria) this;
        }

        public Criteria andPushtimeIsNotNull() {
            addCriterion("pushtime is not null");
            return (Criteria) this;
        }

        public Criteria andPushtimeEqualTo(String value) {
            addCriterion("pushtime =", value, "pushtime");
            return (Criteria) this;
        }

        public Criteria andPushtimeNotEqualTo(String value) {
            addCriterion("pushtime <>", value, "pushtime");
            return (Criteria) this;
        }

        public Criteria andPushtimeGreaterThan(String value) {
            addCriterion("pushtime >", value, "pushtime");
            return (Criteria) this;
        }

        public Criteria andPushtimeGreaterThanOrEqualTo(String value) {
            addCriterion("pushtime >=", value, "pushtime");
            return (Criteria) this;
        }

        public Criteria andPushtimeLessThan(String value) {
            addCriterion("pushtime <", value, "pushtime");
            return (Criteria) this;
        }

        public Criteria andPushtimeLessThanOrEqualTo(String value) {
            addCriterion("pushtime <=", value, "pushtime");
            return (Criteria) this;
        }

        public Criteria andPushtimeLike(String value) {
            addCriterion("pushtime like", value, "pushtime");
            return (Criteria) this;
        }

        public Criteria andPushtimeNotLike(String value) {
            addCriterion("pushtime not like", value, "pushtime");
            return (Criteria) this;
        }

        public Criteria andPushtimeIn(List<String> values) {
            addCriterion("pushtime in", values, "pushtime");
            return (Criteria) this;
        }

        public Criteria andPushtimeNotIn(List<String> values) {
            addCriterion("pushtime not in", values, "pushtime");
            return (Criteria) this;
        }

        public Criteria andPushtimeBetween(String value1, String value2) {
            addCriterion("pushtime between", value1, value2, "pushtime");
            return (Criteria) this;
        }

        public Criteria andPushtimeNotBetween(String value1, String value2) {
            addCriterion("pushtime not between", value1, value2, "pushtime");
            return (Criteria) this;
        }

        public Criteria andPushcountcycleIsNull() {
            addCriterion("pushcountcycle is null");
            return (Criteria) this;
        }

        public Criteria andPushcountcycleIsNotNull() {
            addCriterion("pushcountcycle is not null");
            return (Criteria) this;
        }

        public Criteria andPushcountcycleEqualTo(String value) {
            addCriterion("pushcountcycle =", value, "pushcountcycle");
            return (Criteria) this;
        }

        public Criteria andPushcountcycleNotEqualTo(String value) {
            addCriterion("pushcountcycle <>", value, "pushcountcycle");
            return (Criteria) this;
        }

        public Criteria andPushcountcycleGreaterThan(String value) {
            addCriterion("pushcountcycle >", value, "pushcountcycle");
            return (Criteria) this;
        }

        public Criteria andPushcountcycleGreaterThanOrEqualTo(String value) {
            addCriterion("pushcountcycle >=", value, "pushcountcycle");
            return (Criteria) this;
        }

        public Criteria andPushcountcycleLessThan(String value) {
            addCriterion("pushcountcycle <", value, "pushcountcycle");
            return (Criteria) this;
        }

        public Criteria andPushcountcycleLessThanOrEqualTo(String value) {
            addCriterion("pushcountcycle <=", value, "pushcountcycle");
            return (Criteria) this;
        }

        public Criteria andPushcountcycleLike(String value) {
            addCriterion("pushcountcycle like", value, "pushcountcycle");
            return (Criteria) this;
        }

        public Criteria andPushcountcycleNotLike(String value) {
            addCriterion("pushcountcycle not like", value, "pushcountcycle");
            return (Criteria) this;
        }

        public Criteria andPushcountcycleIn(List<String> values) {
            addCriterion("pushcountcycle in", values, "pushcountcycle");
            return (Criteria) this;
        }

        public Criteria andPushcountcycleNotIn(List<String> values) {
            addCriterion("pushcountcycle not in", values, "pushcountcycle");
            return (Criteria) this;
        }

        public Criteria andPushcountcycleBetween(String value1, String value2) {
            addCriterion("pushcountcycle between", value1, value2, "pushcountcycle");
            return (Criteria) this;
        }

        public Criteria andPushcountcycleNotBetween(String value1, String value2) {
            addCriterion("pushcountcycle not between", value1, value2, "pushcountcycle");
            return (Criteria) this;
        }

        public Criteria andPushcountIsNull() {
            addCriterion("pushcount is null");
            return (Criteria) this;
        }

        public Criteria andPushcountIsNotNull() {
            addCriterion("pushcount is not null");
            return (Criteria) this;
        }

        public Criteria andPushcountEqualTo(Integer value) {
            addCriterion("pushcount =", value, "pushcount");
            return (Criteria) this;
        }

        public Criteria andPushcountNotEqualTo(Integer value) {
            addCriterion("pushcount <>", value, "pushcount");
            return (Criteria) this;
        }

        public Criteria andPushcountGreaterThan(Integer value) {
            addCriterion("pushcount >", value, "pushcount");
            return (Criteria) this;
        }

        public Criteria andPushcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("pushcount >=", value, "pushcount");
            return (Criteria) this;
        }

        public Criteria andPushcountLessThan(Integer value) {
            addCriterion("pushcount <", value, "pushcount");
            return (Criteria) this;
        }

        public Criteria andPushcountLessThanOrEqualTo(Integer value) {
            addCriterion("pushcount <=", value, "pushcount");
            return (Criteria) this;
        }

        public Criteria andPushcountIn(List<Integer> values) {
            addCriterion("pushcount in", values, "pushcount");
            return (Criteria) this;
        }

        public Criteria andPushcountNotIn(List<Integer> values) {
            addCriterion("pushcount not in", values, "pushcount");
            return (Criteria) this;
        }

        public Criteria andPushcountBetween(Integer value1, Integer value2) {
            addCriterion("pushcount between", value1, value2, "pushcount");
            return (Criteria) this;
        }

        public Criteria andPushcountNotBetween(Integer value1, Integer value2) {
            addCriterion("pushcount not between", value1, value2, "pushcount");
            return (Criteria) this;
        }

        public Criteria andPushcountnumIsNull() {
            addCriterion("pushcountnum is null");
            return (Criteria) this;
        }

        public Criteria andPushcountnumIsNotNull() {
            addCriterion("pushcountnum is not null");
            return (Criteria) this;
        }

        public Criteria andPushcountnumEqualTo(Integer value) {
            addCriterion("pushcountnum =", value, "pushcountnum");
            return (Criteria) this;
        }

        public Criteria andPushcountnumNotEqualTo(Integer value) {
            addCriterion("pushcountnum <>", value, "pushcountnum");
            return (Criteria) this;
        }

        public Criteria andPushcountnumGreaterThan(Integer value) {
            addCriterion("pushcountnum >", value, "pushcountnum");
            return (Criteria) this;
        }

        public Criteria andPushcountnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pushcountnum >=", value, "pushcountnum");
            return (Criteria) this;
        }

        public Criteria andPushcountnumLessThan(Integer value) {
            addCriterion("pushcountnum <", value, "pushcountnum");
            return (Criteria) this;
        }

        public Criteria andPushcountnumLessThanOrEqualTo(Integer value) {
            addCriterion("pushcountnum <=", value, "pushcountnum");
            return (Criteria) this;
        }

        public Criteria andPushcountnumIn(List<Integer> values) {
            addCriterion("pushcountnum in", values, "pushcountnum");
            return (Criteria) this;
        }

        public Criteria andPushcountnumNotIn(List<Integer> values) {
            addCriterion("pushcountnum not in", values, "pushcountnum");
            return (Criteria) this;
        }

        public Criteria andPushcountnumBetween(Integer value1, Integer value2) {
            addCriterion("pushcountnum between", value1, value2, "pushcountnum");
            return (Criteria) this;
        }

        public Criteria andPushcountnumNotBetween(Integer value1, Integer value2) {
            addCriterion("pushcountnum not between", value1, value2, "pushcountnum");
            return (Criteria) this;
        }

        public Criteria andPushobjectIsNull() {
            addCriterion("pushobject is null");
            return (Criteria) this;
        }

        public Criteria andPushobjectIsNotNull() {
            addCriterion("pushobject is not null");
            return (Criteria) this;
        }

        public Criteria andPushobjectEqualTo(String value) {
            addCriterion("pushobject =", value, "pushobject");
            return (Criteria) this;
        }

        public Criteria andPushobjectNotEqualTo(String value) {
            addCriterion("pushobject <>", value, "pushobject");
            return (Criteria) this;
        }

        public Criteria andPushobjectGreaterThan(String value) {
            addCriterion("pushobject >", value, "pushobject");
            return (Criteria) this;
        }

        public Criteria andPushobjectGreaterThanOrEqualTo(String value) {
            addCriterion("pushobject >=", value, "pushobject");
            return (Criteria) this;
        }

        public Criteria andPushobjectLessThan(String value) {
            addCriterion("pushobject <", value, "pushobject");
            return (Criteria) this;
        }

        public Criteria andPushobjectLessThanOrEqualTo(String value) {
            addCriterion("pushobject <=", value, "pushobject");
            return (Criteria) this;
        }

        public Criteria andPushobjectLike(String value) {
            addCriterion("pushobject like", value, "pushobject");
            return (Criteria) this;
        }

        public Criteria andPushobjectNotLike(String value) {
            addCriterion("pushobject not like", value, "pushobject");
            return (Criteria) this;
        }

        public Criteria andPushobjectIn(List<String> values) {
            addCriterion("pushobject in", values, "pushobject");
            return (Criteria) this;
        }

        public Criteria andPushobjectNotIn(List<String> values) {
            addCriterion("pushobject not in", values, "pushobject");
            return (Criteria) this;
        }

        public Criteria andPushobjectBetween(String value1, String value2) {
            addCriterion("pushobject between", value1, value2, "pushobject");
            return (Criteria) this;
        }

        public Criteria andPushobjectNotBetween(String value1, String value2) {
            addCriterion("pushobject not between", value1, value2, "pushobject");
            return (Criteria) this;
        }

        public Criteria andPushstatusIsNull() {
            addCriterion("pushstatus is null");
            return (Criteria) this;
        }

        public Criteria andPushstatusIsNotNull() {
            addCriterion("pushstatus is not null");
            return (Criteria) this;
        }

        public Criteria andPushstatusEqualTo(String value) {
            addCriterion("pushstatus =", value, "pushstatus");
            return (Criteria) this;
        }

        public Criteria andPushstatusNotEqualTo(String value) {
            addCriterion("pushstatus <>", value, "pushstatus");
            return (Criteria) this;
        }

        public Criteria andPushstatusGreaterThan(String value) {
            addCriterion("pushstatus >", value, "pushstatus");
            return (Criteria) this;
        }

        public Criteria andPushstatusGreaterThanOrEqualTo(String value) {
            addCriterion("pushstatus >=", value, "pushstatus");
            return (Criteria) this;
        }

        public Criteria andPushstatusLessThan(String value) {
            addCriterion("pushstatus <", value, "pushstatus");
            return (Criteria) this;
        }

        public Criteria andPushstatusLessThanOrEqualTo(String value) {
            addCriterion("pushstatus <=", value, "pushstatus");
            return (Criteria) this;
        }

        public Criteria andPushstatusLike(String value) {
            addCriterion("pushstatus like", value, "pushstatus");
            return (Criteria) this;
        }

        public Criteria andPushstatusNotLike(String value) {
            addCriterion("pushstatus not like", value, "pushstatus");
            return (Criteria) this;
        }

        public Criteria andPushstatusIn(List<String> values) {
            addCriterion("pushstatus in", values, "pushstatus");
            return (Criteria) this;
        }

        public Criteria andPushstatusNotIn(List<String> values) {
            addCriterion("pushstatus not in", values, "pushstatus");
            return (Criteria) this;
        }

        public Criteria andPushstatusBetween(String value1, String value2) {
            addCriterion("pushstatus between", value1, value2, "pushstatus");
            return (Criteria) this;
        }

        public Criteria andPushstatusNotBetween(String value1, String value2) {
            addCriterion("pushstatus not between", value1, value2, "pushstatus");
            return (Criteria) this;
        }

        public Criteria andExecutetimeIsNull() {
            addCriterion("executetime is null");
            return (Criteria) this;
        }

        public Criteria andExecutetimeIsNotNull() {
            addCriterion("executetime is not null");
            return (Criteria) this;
        }

        public Criteria andExecutetimeEqualTo(Date value) {
            addCriterion("executetime =", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotEqualTo(Date value) {
            addCriterion("executetime <>", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeGreaterThan(Date value) {
            addCriterion("executetime >", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("executetime >=", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeLessThan(Date value) {
            addCriterion("executetime <", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeLessThanOrEqualTo(Date value) {
            addCriterion("executetime <=", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeIn(List<Date> values) {
            addCriterion("executetime in", values, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotIn(List<Date> values) {
            addCriterion("executetime not in", values, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeBetween(Date value1, Date value2) {
            addCriterion("executetime between", value1, value2, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotBetween(Date value1, Date value2) {
            addCriterion("executetime not between", value1, value2, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutecountIsNull() {
            addCriterion("executecount is null");
            return (Criteria) this;
        }

        public Criteria andExecutecountIsNotNull() {
            addCriterion("executecount is not null");
            return (Criteria) this;
        }

        public Criteria andExecutecountEqualTo(Integer value) {
            addCriterion("executecount =", value, "executecount");
            return (Criteria) this;
        }

        public Criteria andExecutecountNotEqualTo(Integer value) {
            addCriterion("executecount <>", value, "executecount");
            return (Criteria) this;
        }

        public Criteria andExecutecountGreaterThan(Integer value) {
            addCriterion("executecount >", value, "executecount");
            return (Criteria) this;
        }

        public Criteria andExecutecountGreaterThanOrEqualTo(Integer value) {
            addCriterion("executecount >=", value, "executecount");
            return (Criteria) this;
        }

        public Criteria andExecutecountLessThan(Integer value) {
            addCriterion("executecount <", value, "executecount");
            return (Criteria) this;
        }

        public Criteria andExecutecountLessThanOrEqualTo(Integer value) {
            addCriterion("executecount <=", value, "executecount");
            return (Criteria) this;
        }

        public Criteria andExecutecountIn(List<Integer> values) {
            addCriterion("executecount in", values, "executecount");
            return (Criteria) this;
        }

        public Criteria andExecutecountNotIn(List<Integer> values) {
            addCriterion("executecount not in", values, "executecount");
            return (Criteria) this;
        }

        public Criteria andExecutecountBetween(Integer value1, Integer value2) {
            addCriterion("executecount between", value1, value2, "executecount");
            return (Criteria) this;
        }

        public Criteria andExecutecountNotBetween(Integer value1, Integer value2) {
            addCriterion("executecount not between", value1, value2, "executecount");
            return (Criteria) this;
        }

        public Criteria andInserttimeIsNull() {
            addCriterion("inserttime is null");
            return (Criteria) this;
        }

        public Criteria andInserttimeIsNotNull() {
            addCriterion("inserttime is not null");
            return (Criteria) this;
        }

        public Criteria andInserttimeEqualTo(Date value) {
            addCriterion("inserttime =", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotEqualTo(Date value) {
            addCriterion("inserttime <>", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThan(Date value) {
            addCriterion("inserttime >", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("inserttime >=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThan(Date value) {
            addCriterion("inserttime <", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThanOrEqualTo(Date value) {
            addCriterion("inserttime <=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeIn(List<Date> values) {
            addCriterion("inserttime in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotIn(List<Date> values) {
            addCriterion("inserttime not in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeBetween(Date value1, Date value2) {
            addCriterion("inserttime between", value1, value2, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotBetween(Date value1, Date value2) {
            addCriterion("inserttime not between", value1, value2, "inserttime");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNull() {
            addCriterion("usertype is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("usertype is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(String value) {
            addCriterion("usertype =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(String value) {
            addCriterion("usertype <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(String value) {
            addCriterion("usertype >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(String value) {
            addCriterion("usertype >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(String value) {
            addCriterion("usertype <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(String value) {
            addCriterion("usertype <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLike(String value) {
            addCriterion("usertype like", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotLike(String value) {
            addCriterion("usertype not like", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<String> values) {
            addCriterion("usertype in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<String> values) {
            addCriterion("usertype not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(String value1, String value2) {
            addCriterion("usertype between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(String value1, String value2) {
            addCriterion("usertype not between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andPushtypeIsNull() {
            addCriterion("pushtype is null");
            return (Criteria) this;
        }

        public Criteria andPushtypeIsNotNull() {
            addCriterion("pushtype is not null");
            return (Criteria) this;
        }

        public Criteria andPushtypeEqualTo(String value) {
            addCriterion("pushtype =", value, "pushtype");
            return (Criteria) this;
        }

        public Criteria andPushtypeNotEqualTo(String value) {
            addCriterion("pushtype <>", value, "pushtype");
            return (Criteria) this;
        }

        public Criteria andPushtypeGreaterThan(String value) {
            addCriterion("pushtype >", value, "pushtype");
            return (Criteria) this;
        }

        public Criteria andPushtypeGreaterThanOrEqualTo(String value) {
            addCriterion("pushtype >=", value, "pushtype");
            return (Criteria) this;
        }

        public Criteria andPushtypeLessThan(String value) {
            addCriterion("pushtype <", value, "pushtype");
            return (Criteria) this;
        }

        public Criteria andPushtypeLessThanOrEqualTo(String value) {
            addCriterion("pushtype <=", value, "pushtype");
            return (Criteria) this;
        }

        public Criteria andPushtypeLike(String value) {
            addCriterion("pushtype like", value, "pushtype");
            return (Criteria) this;
        }

        public Criteria andPushtypeNotLike(String value) {
            addCriterion("pushtype not like", value, "pushtype");
            return (Criteria) this;
        }

        public Criteria andPushtypeIn(List<String> values) {
            addCriterion("pushtype in", values, "pushtype");
            return (Criteria) this;
        }

        public Criteria andPushtypeNotIn(List<String> values) {
            addCriterion("pushtype not in", values, "pushtype");
            return (Criteria) this;
        }

        public Criteria andPushtypeBetween(String value1, String value2) {
            addCriterion("pushtype between", value1, value2, "pushtype");
            return (Criteria) this;
        }

        public Criteria andPushtypeNotBetween(String value1, String value2) {
            addCriterion("pushtype not between", value1, value2, "pushtype");
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