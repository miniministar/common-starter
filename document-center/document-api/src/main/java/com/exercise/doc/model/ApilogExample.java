package com.exercise.doc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApilogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApilogExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andApiIdIsNull() {
            addCriterion("api_id is null");
            return (Criteria) this;
        }

        public Criteria andApiIdIsNotNull() {
            addCriterion("api_id is not null");
            return (Criteria) this;
        }

        public Criteria andApiIdEqualTo(Long value) {
            addCriterion("api_id =", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdNotEqualTo(Long value) {
            addCriterion("api_id <>", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdGreaterThan(Long value) {
            addCriterion("api_id >", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdGreaterThanOrEqualTo(Long value) {
            addCriterion("api_id >=", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdLessThan(Long value) {
            addCriterion("api_id <", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdLessThanOrEqualTo(Long value) {
            addCriterion("api_id <=", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdIn(List<Long> values) {
            addCriterion("api_id in", values, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdNotIn(List<Long> values) {
            addCriterion("api_id not in", values, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdBetween(Long value1, Long value2) {
            addCriterion("api_id between", value1, value2, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdNotBetween(Long value1, Long value2) {
            addCriterion("api_id not between", value1, value2, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNull() {
            addCriterion("api_name is null");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNotNull() {
            addCriterion("api_name is not null");
            return (Criteria) this;
        }

        public Criteria andApiNameEqualTo(String value) {
            addCriterion("api_name =", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotEqualTo(String value) {
            addCriterion("api_name <>", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThan(String value) {
            addCriterion("api_name >", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThanOrEqualTo(String value) {
            addCriterion("api_name >=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThan(String value) {
            addCriterion("api_name <", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThanOrEqualTo(String value) {
            addCriterion("api_name <=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLike(String value) {
            addCriterion("api_name like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotLike(String value) {
            addCriterion("api_name not like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameIn(List<String> values) {
            addCriterion("api_name in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotIn(List<String> values) {
            addCriterion("api_name not in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameBetween(String value1, String value2) {
            addCriterion("api_name between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotBetween(String value1, String value2) {
            addCriterion("api_name not between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andRequestHeardersIsNull() {
            addCriterion("request_hearders is null");
            return (Criteria) this;
        }

        public Criteria andRequestHeardersIsNotNull() {
            addCriterion("request_hearders is not null");
            return (Criteria) this;
        }

        public Criteria andRequestHeardersEqualTo(String value) {
            addCriterion("request_hearders =", value, "requestHearders");
            return (Criteria) this;
        }

        public Criteria andRequestHeardersNotEqualTo(String value) {
            addCriterion("request_hearders <>", value, "requestHearders");
            return (Criteria) this;
        }

        public Criteria andRequestHeardersGreaterThan(String value) {
            addCriterion("request_hearders >", value, "requestHearders");
            return (Criteria) this;
        }

        public Criteria andRequestHeardersGreaterThanOrEqualTo(String value) {
            addCriterion("request_hearders >=", value, "requestHearders");
            return (Criteria) this;
        }

        public Criteria andRequestHeardersLessThan(String value) {
            addCriterion("request_hearders <", value, "requestHearders");
            return (Criteria) this;
        }

        public Criteria andRequestHeardersLessThanOrEqualTo(String value) {
            addCriterion("request_hearders <=", value, "requestHearders");
            return (Criteria) this;
        }

        public Criteria andRequestHeardersLike(String value) {
            addCriterion("request_hearders like", value, "requestHearders");
            return (Criteria) this;
        }

        public Criteria andRequestHeardersNotLike(String value) {
            addCriterion("request_hearders not like", value, "requestHearders");
            return (Criteria) this;
        }

        public Criteria andRequestHeardersIn(List<String> values) {
            addCriterion("request_hearders in", values, "requestHearders");
            return (Criteria) this;
        }

        public Criteria andRequestHeardersNotIn(List<String> values) {
            addCriterion("request_hearders not in", values, "requestHearders");
            return (Criteria) this;
        }

        public Criteria andRequestHeardersBetween(String value1, String value2) {
            addCriterion("request_hearders between", value1, value2, "requestHearders");
            return (Criteria) this;
        }

        public Criteria andRequestHeardersNotBetween(String value1, String value2) {
            addCriterion("request_hearders not between", value1, value2, "requestHearders");
            return (Criteria) this;
        }

        public Criteria andRequestParametersIsNull() {
            addCriterion("request_parameters is null");
            return (Criteria) this;
        }

        public Criteria andRequestParametersIsNotNull() {
            addCriterion("request_parameters is not null");
            return (Criteria) this;
        }

        public Criteria andRequestParametersEqualTo(String value) {
            addCriterion("request_parameters =", value, "requestParameters");
            return (Criteria) this;
        }

        public Criteria andRequestParametersNotEqualTo(String value) {
            addCriterion("request_parameters <>", value, "requestParameters");
            return (Criteria) this;
        }

        public Criteria andRequestParametersGreaterThan(String value) {
            addCriterion("request_parameters >", value, "requestParameters");
            return (Criteria) this;
        }

        public Criteria andRequestParametersGreaterThanOrEqualTo(String value) {
            addCriterion("request_parameters >=", value, "requestParameters");
            return (Criteria) this;
        }

        public Criteria andRequestParametersLessThan(String value) {
            addCriterion("request_parameters <", value, "requestParameters");
            return (Criteria) this;
        }

        public Criteria andRequestParametersLessThanOrEqualTo(String value) {
            addCriterion("request_parameters <=", value, "requestParameters");
            return (Criteria) this;
        }

        public Criteria andRequestParametersLike(String value) {
            addCriterion("request_parameters like", value, "requestParameters");
            return (Criteria) this;
        }

        public Criteria andRequestParametersNotLike(String value) {
            addCriterion("request_parameters not like", value, "requestParameters");
            return (Criteria) this;
        }

        public Criteria andRequestParametersIn(List<String> values) {
            addCriterion("request_parameters in", values, "requestParameters");
            return (Criteria) this;
        }

        public Criteria andRequestParametersNotIn(List<String> values) {
            addCriterion("request_parameters not in", values, "requestParameters");
            return (Criteria) this;
        }

        public Criteria andRequestParametersBetween(String value1, String value2) {
            addCriterion("request_parameters between", value1, value2, "requestParameters");
            return (Criteria) this;
        }

        public Criteria andRequestParametersNotBetween(String value1, String value2) {
            addCriterion("request_parameters not between", value1, value2, "requestParameters");
            return (Criteria) this;
        }

        public Criteria andResponseCodeIsNull() {
            addCriterion("response_code is null");
            return (Criteria) this;
        }

        public Criteria andResponseCodeIsNotNull() {
            addCriterion("response_code is not null");
            return (Criteria) this;
        }

        public Criteria andResponseCodeEqualTo(String value) {
            addCriterion("response_code =", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotEqualTo(String value) {
            addCriterion("response_code <>", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeGreaterThan(String value) {
            addCriterion("response_code >", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("response_code >=", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeLessThan(String value) {
            addCriterion("response_code <", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeLessThanOrEqualTo(String value) {
            addCriterion("response_code <=", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeLike(String value) {
            addCriterion("response_code like", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotLike(String value) {
            addCriterion("response_code not like", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeIn(List<String> values) {
            addCriterion("response_code in", values, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotIn(List<String> values) {
            addCriterion("response_code not in", values, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeBetween(String value1, String value2) {
            addCriterion("response_code between", value1, value2, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotBetween(String value1, String value2) {
            addCriterion("response_code not between", value1, value2, "responseCode");
            return (Criteria) this;
        }

        public Criteria andOperUserIdIsNull() {
            addCriterion("oper_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOperUserIdIsNotNull() {
            addCriterion("oper_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperUserIdEqualTo(Long value) {
            addCriterion("oper_user_id =", value, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdNotEqualTo(Long value) {
            addCriterion("oper_user_id <>", value, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdGreaterThan(Long value) {
            addCriterion("oper_user_id >", value, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("oper_user_id >=", value, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdLessThan(Long value) {
            addCriterion("oper_user_id <", value, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdLessThanOrEqualTo(Long value) {
            addCriterion("oper_user_id <=", value, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdIn(List<Long> values) {
            addCriterion("oper_user_id in", values, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdNotIn(List<Long> values) {
            addCriterion("oper_user_id not in", values, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdBetween(Long value1, Long value2) {
            addCriterion("oper_user_id between", value1, value2, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdNotBetween(Long value1, Long value2) {
            addCriterion("oper_user_id not between", value1, value2, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserNameIsNull() {
            addCriterion("oper_user_name is null");
            return (Criteria) this;
        }

        public Criteria andOperUserNameIsNotNull() {
            addCriterion("oper_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperUserNameEqualTo(String value) {
            addCriterion("oper_user_name =", value, "operUserName");
            return (Criteria) this;
        }

        public Criteria andOperUserNameNotEqualTo(String value) {
            addCriterion("oper_user_name <>", value, "operUserName");
            return (Criteria) this;
        }

        public Criteria andOperUserNameGreaterThan(String value) {
            addCriterion("oper_user_name >", value, "operUserName");
            return (Criteria) this;
        }

        public Criteria andOperUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("oper_user_name >=", value, "operUserName");
            return (Criteria) this;
        }

        public Criteria andOperUserNameLessThan(String value) {
            addCriterion("oper_user_name <", value, "operUserName");
            return (Criteria) this;
        }

        public Criteria andOperUserNameLessThanOrEqualTo(String value) {
            addCriterion("oper_user_name <=", value, "operUserName");
            return (Criteria) this;
        }

        public Criteria andOperUserNameLike(String value) {
            addCriterion("oper_user_name like", value, "operUserName");
            return (Criteria) this;
        }

        public Criteria andOperUserNameNotLike(String value) {
            addCriterion("oper_user_name not like", value, "operUserName");
            return (Criteria) this;
        }

        public Criteria andOperUserNameIn(List<String> values) {
            addCriterion("oper_user_name in", values, "operUserName");
            return (Criteria) this;
        }

        public Criteria andOperUserNameNotIn(List<String> values) {
            addCriterion("oper_user_name not in", values, "operUserName");
            return (Criteria) this;
        }

        public Criteria andOperUserNameBetween(String value1, String value2) {
            addCriterion("oper_user_name between", value1, value2, "operUserName");
            return (Criteria) this;
        }

        public Criteria andOperUserNameNotBetween(String value1, String value2) {
            addCriterion("oper_user_name not between", value1, value2, "operUserName");
            return (Criteria) this;
        }

        public Criteria andOperIpIsNull() {
            addCriterion("oper_ip is null");
            return (Criteria) this;
        }

        public Criteria andOperIpIsNotNull() {
            addCriterion("oper_ip is not null");
            return (Criteria) this;
        }

        public Criteria andOperIpEqualTo(String value) {
            addCriterion("oper_ip =", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpNotEqualTo(String value) {
            addCriterion("oper_ip <>", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpGreaterThan(String value) {
            addCriterion("oper_ip >", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpGreaterThanOrEqualTo(String value) {
            addCriterion("oper_ip >=", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpLessThan(String value) {
            addCriterion("oper_ip <", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpLessThanOrEqualTo(String value) {
            addCriterion("oper_ip <=", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpLike(String value) {
            addCriterion("oper_ip like", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpNotLike(String value) {
            addCriterion("oper_ip not like", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpIn(List<String> values) {
            addCriterion("oper_ip in", values, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpNotIn(List<String> values) {
            addCriterion("oper_ip not in", values, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpBetween(String value1, String value2) {
            addCriterion("oper_ip between", value1, value2, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpNotBetween(String value1, String value2) {
            addCriterion("oper_ip not between", value1, value2, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperLocationIsNull() {
            addCriterion("oper_location is null");
            return (Criteria) this;
        }

        public Criteria andOperLocationIsNotNull() {
            addCriterion("oper_location is not null");
            return (Criteria) this;
        }

        public Criteria andOperLocationEqualTo(String value) {
            addCriterion("oper_location =", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationNotEqualTo(String value) {
            addCriterion("oper_location <>", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationGreaterThan(String value) {
            addCriterion("oper_location >", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationGreaterThanOrEqualTo(String value) {
            addCriterion("oper_location >=", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationLessThan(String value) {
            addCriterion("oper_location <", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationLessThanOrEqualTo(String value) {
            addCriterion("oper_location <=", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationLike(String value) {
            addCriterion("oper_location like", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationNotLike(String value) {
            addCriterion("oper_location not like", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationIn(List<String> values) {
            addCriterion("oper_location in", values, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationNotIn(List<String> values) {
            addCriterion("oper_location not in", values, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationBetween(String value1, String value2) {
            addCriterion("oper_location between", value1, value2, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationNotBetween(String value1, String value2) {
            addCriterion("oper_location not between", value1, value2, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperBrowserIsNull() {
            addCriterion("oper_browser is null");
            return (Criteria) this;
        }

        public Criteria andOperBrowserIsNotNull() {
            addCriterion("oper_browser is not null");
            return (Criteria) this;
        }

        public Criteria andOperBrowserEqualTo(String value) {
            addCriterion("oper_browser =", value, "operBrowser");
            return (Criteria) this;
        }

        public Criteria andOperBrowserNotEqualTo(String value) {
            addCriterion("oper_browser <>", value, "operBrowser");
            return (Criteria) this;
        }

        public Criteria andOperBrowserGreaterThan(String value) {
            addCriterion("oper_browser >", value, "operBrowser");
            return (Criteria) this;
        }

        public Criteria andOperBrowserGreaterThanOrEqualTo(String value) {
            addCriterion("oper_browser >=", value, "operBrowser");
            return (Criteria) this;
        }

        public Criteria andOperBrowserLessThan(String value) {
            addCriterion("oper_browser <", value, "operBrowser");
            return (Criteria) this;
        }

        public Criteria andOperBrowserLessThanOrEqualTo(String value) {
            addCriterion("oper_browser <=", value, "operBrowser");
            return (Criteria) this;
        }

        public Criteria andOperBrowserLike(String value) {
            addCriterion("oper_browser like", value, "operBrowser");
            return (Criteria) this;
        }

        public Criteria andOperBrowserNotLike(String value) {
            addCriterion("oper_browser not like", value, "operBrowser");
            return (Criteria) this;
        }

        public Criteria andOperBrowserIn(List<String> values) {
            addCriterion("oper_browser in", values, "operBrowser");
            return (Criteria) this;
        }

        public Criteria andOperBrowserNotIn(List<String> values) {
            addCriterion("oper_browser not in", values, "operBrowser");
            return (Criteria) this;
        }

        public Criteria andOperBrowserBetween(String value1, String value2) {
            addCriterion("oper_browser between", value1, value2, "operBrowser");
            return (Criteria) this;
        }

        public Criteria andOperBrowserNotBetween(String value1, String value2) {
            addCriterion("oper_browser not between", value1, value2, "operBrowser");
            return (Criteria) this;
        }

        public Criteria andOperOsIsNull() {
            addCriterion("oper_os is null");
            return (Criteria) this;
        }

        public Criteria andOperOsIsNotNull() {
            addCriterion("oper_os is not null");
            return (Criteria) this;
        }

        public Criteria andOperOsEqualTo(String value) {
            addCriterion("oper_os =", value, "operOs");
            return (Criteria) this;
        }

        public Criteria andOperOsNotEqualTo(String value) {
            addCriterion("oper_os <>", value, "operOs");
            return (Criteria) this;
        }

        public Criteria andOperOsGreaterThan(String value) {
            addCriterion("oper_os >", value, "operOs");
            return (Criteria) this;
        }

        public Criteria andOperOsGreaterThanOrEqualTo(String value) {
            addCriterion("oper_os >=", value, "operOs");
            return (Criteria) this;
        }

        public Criteria andOperOsLessThan(String value) {
            addCriterion("oper_os <", value, "operOs");
            return (Criteria) this;
        }

        public Criteria andOperOsLessThanOrEqualTo(String value) {
            addCriterion("oper_os <=", value, "operOs");
            return (Criteria) this;
        }

        public Criteria andOperOsLike(String value) {
            addCriterion("oper_os like", value, "operOs");
            return (Criteria) this;
        }

        public Criteria andOperOsNotLike(String value) {
            addCriterion("oper_os not like", value, "operOs");
            return (Criteria) this;
        }

        public Criteria andOperOsIn(List<String> values) {
            addCriterion("oper_os in", values, "operOs");
            return (Criteria) this;
        }

        public Criteria andOperOsNotIn(List<String> values) {
            addCriterion("oper_os not in", values, "operOs");
            return (Criteria) this;
        }

        public Criteria andOperOsBetween(String value1, String value2) {
            addCriterion("oper_os between", value1, value2, "operOs");
            return (Criteria) this;
        }

        public Criteria andOperOsNotBetween(String value1, String value2) {
            addCriterion("oper_os not between", value1, value2, "operOs");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
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