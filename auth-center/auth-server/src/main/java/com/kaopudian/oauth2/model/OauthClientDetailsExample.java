package com.exercise.oauth2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OauthClientDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OauthClientDetailsExample() {
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

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(String value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(String value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(String value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(String value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(String value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(String value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLike(String value) {
            addCriterion("client_id like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotLike(String value) {
            addCriterion("client_id not like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<String> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<String> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(String value1, String value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(String value1, String value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNull() {
            addCriterion("client_name is null");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNotNull() {
            addCriterion("client_name is not null");
            return (Criteria) this;
        }

        public Criteria andClientNameEqualTo(String value) {
            addCriterion("client_name =", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotEqualTo(String value) {
            addCriterion("client_name <>", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThan(String value) {
            addCriterion("client_name >", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThanOrEqualTo(String value) {
            addCriterion("client_name >=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThan(String value) {
            addCriterion("client_name <", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThanOrEqualTo(String value) {
            addCriterion("client_name <=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLike(String value) {
            addCriterion("client_name like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotLike(String value) {
            addCriterion("client_name not like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameIn(List<String> values) {
            addCriterion("client_name in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotIn(List<String> values) {
            addCriterion("client_name not in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameBetween(String value1, String value2) {
            addCriterion("client_name between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotBetween(String value1, String value2) {
            addCriterion("client_name not between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andResourceIdsIsNull() {
            addCriterion("resource_ids is null");
            return (Criteria) this;
        }

        public Criteria andResourceIdsIsNotNull() {
            addCriterion("resource_ids is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIdsEqualTo(String value) {
            addCriterion("resource_ids =", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsNotEqualTo(String value) {
            addCriterion("resource_ids <>", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsGreaterThan(String value) {
            addCriterion("resource_ids >", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsGreaterThanOrEqualTo(String value) {
            addCriterion("resource_ids >=", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsLessThan(String value) {
            addCriterion("resource_ids <", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsLessThanOrEqualTo(String value) {
            addCriterion("resource_ids <=", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsLike(String value) {
            addCriterion("resource_ids like", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsNotLike(String value) {
            addCriterion("resource_ids not like", value, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsIn(List<String> values) {
            addCriterion("resource_ids in", values, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsNotIn(List<String> values) {
            addCriterion("resource_ids not in", values, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsBetween(String value1, String value2) {
            addCriterion("resource_ids between", value1, value2, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andResourceIdsNotBetween(String value1, String value2) {
            addCriterion("resource_ids not between", value1, value2, "resourceIds");
            return (Criteria) this;
        }

        public Criteria andClientSecretIsNull() {
            addCriterion("client_secret is null");
            return (Criteria) this;
        }

        public Criteria andClientSecretIsNotNull() {
            addCriterion("client_secret is not null");
            return (Criteria) this;
        }

        public Criteria andClientSecretEqualTo(String value) {
            addCriterion("client_secret =", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotEqualTo(String value) {
            addCriterion("client_secret <>", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretGreaterThan(String value) {
            addCriterion("client_secret >", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretGreaterThanOrEqualTo(String value) {
            addCriterion("client_secret >=", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretLessThan(String value) {
            addCriterion("client_secret <", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretLessThanOrEqualTo(String value) {
            addCriterion("client_secret <=", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretLike(String value) {
            addCriterion("client_secret like", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotLike(String value) {
            addCriterion("client_secret not like", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretIn(List<String> values) {
            addCriterion("client_secret in", values, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotIn(List<String> values) {
            addCriterion("client_secret not in", values, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretBetween(String value1, String value2) {
            addCriterion("client_secret between", value1, value2, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotBetween(String value1, String value2) {
            addCriterion("client_secret not between", value1, value2, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretStrIsNull() {
            addCriterion("client_secret_str is null");
            return (Criteria) this;
        }

        public Criteria andClientSecretStrIsNotNull() {
            addCriterion("client_secret_str is not null");
            return (Criteria) this;
        }

        public Criteria andClientSecretStrEqualTo(String value) {
            addCriterion("client_secret_str =", value, "clientSecretStr");
            return (Criteria) this;
        }

        public Criteria andClientSecretStrNotEqualTo(String value) {
            addCriterion("client_secret_str <>", value, "clientSecretStr");
            return (Criteria) this;
        }

        public Criteria andClientSecretStrGreaterThan(String value) {
            addCriterion("client_secret_str >", value, "clientSecretStr");
            return (Criteria) this;
        }

        public Criteria andClientSecretStrGreaterThanOrEqualTo(String value) {
            addCriterion("client_secret_str >=", value, "clientSecretStr");
            return (Criteria) this;
        }

        public Criteria andClientSecretStrLessThan(String value) {
            addCriterion("client_secret_str <", value, "clientSecretStr");
            return (Criteria) this;
        }

        public Criteria andClientSecretStrLessThanOrEqualTo(String value) {
            addCriterion("client_secret_str <=", value, "clientSecretStr");
            return (Criteria) this;
        }

        public Criteria andClientSecretStrLike(String value) {
            addCriterion("client_secret_str like", value, "clientSecretStr");
            return (Criteria) this;
        }

        public Criteria andClientSecretStrNotLike(String value) {
            addCriterion("client_secret_str not like", value, "clientSecretStr");
            return (Criteria) this;
        }

        public Criteria andClientSecretStrIn(List<String> values) {
            addCriterion("client_secret_str in", values, "clientSecretStr");
            return (Criteria) this;
        }

        public Criteria andClientSecretStrNotIn(List<String> values) {
            addCriterion("client_secret_str not in", values, "clientSecretStr");
            return (Criteria) this;
        }

        public Criteria andClientSecretStrBetween(String value1, String value2) {
            addCriterion("client_secret_str between", value1, value2, "clientSecretStr");
            return (Criteria) this;
        }

        public Criteria andClientSecretStrNotBetween(String value1, String value2) {
            addCriterion("client_secret_str not between", value1, value2, "clientSecretStr");
            return (Criteria) this;
        }

        public Criteria andScopeIsNull() {
            addCriterion("scope is null");
            return (Criteria) this;
        }

        public Criteria andScopeIsNotNull() {
            addCriterion("scope is not null");
            return (Criteria) this;
        }

        public Criteria andScopeEqualTo(String value) {
            addCriterion("scope =", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotEqualTo(String value) {
            addCriterion("scope <>", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThan(String value) {
            addCriterion("scope >", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThanOrEqualTo(String value) {
            addCriterion("scope >=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThan(String value) {
            addCriterion("scope <", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThanOrEqualTo(String value) {
            addCriterion("scope <=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLike(String value) {
            addCriterion("scope like", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotLike(String value) {
            addCriterion("scope not like", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeIn(List<String> values) {
            addCriterion("scope in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotIn(List<String> values) {
            addCriterion("scope not in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeBetween(String value1, String value2) {
            addCriterion("scope between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotBetween(String value1, String value2) {
            addCriterion("scope not between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesIsNull() {
            addCriterion("authorized_grant_types is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesIsNotNull() {
            addCriterion("authorized_grant_types is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesEqualTo(String value) {
            addCriterion("authorized_grant_types =", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesNotEqualTo(String value) {
            addCriterion("authorized_grant_types <>", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesGreaterThan(String value) {
            addCriterion("authorized_grant_types >", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesGreaterThanOrEqualTo(String value) {
            addCriterion("authorized_grant_types >=", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesLessThan(String value) {
            addCriterion("authorized_grant_types <", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesLessThanOrEqualTo(String value) {
            addCriterion("authorized_grant_types <=", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesLike(String value) {
            addCriterion("authorized_grant_types like", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesNotLike(String value) {
            addCriterion("authorized_grant_types not like", value, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesIn(List<String> values) {
            addCriterion("authorized_grant_types in", values, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesNotIn(List<String> values) {
            addCriterion("authorized_grant_types not in", values, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesBetween(String value1, String value2) {
            addCriterion("authorized_grant_types between", value1, value2, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andAuthorizedGrantTypesNotBetween(String value1, String value2) {
            addCriterion("authorized_grant_types not between", value1, value2, "authorizedGrantTypes");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriIsNull() {
            addCriterion("web_server_redirect_uri is null");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriIsNotNull() {
            addCriterion("web_server_redirect_uri is not null");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriEqualTo(String value) {
            addCriterion("web_server_redirect_uri =", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriNotEqualTo(String value) {
            addCriterion("web_server_redirect_uri <>", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriGreaterThan(String value) {
            addCriterion("web_server_redirect_uri >", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriGreaterThanOrEqualTo(String value) {
            addCriterion("web_server_redirect_uri >=", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriLessThan(String value) {
            addCriterion("web_server_redirect_uri <", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriLessThanOrEqualTo(String value) {
            addCriterion("web_server_redirect_uri <=", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriLike(String value) {
            addCriterion("web_server_redirect_uri like", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriNotLike(String value) {
            addCriterion("web_server_redirect_uri not like", value, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriIn(List<String> values) {
            addCriterion("web_server_redirect_uri in", values, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriNotIn(List<String> values) {
            addCriterion("web_server_redirect_uri not in", values, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriBetween(String value1, String value2) {
            addCriterion("web_server_redirect_uri between", value1, value2, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andWebServerRedirectUriNotBetween(String value1, String value2) {
            addCriterion("web_server_redirect_uri not between", value1, value2, "webServerRedirectUri");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesIsNull() {
            addCriterion("authorities is null");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesIsNotNull() {
            addCriterion("authorities is not null");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesEqualTo(String value) {
            addCriterion("authorities =", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesNotEqualTo(String value) {
            addCriterion("authorities <>", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesGreaterThan(String value) {
            addCriterion("authorities >", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesGreaterThanOrEqualTo(String value) {
            addCriterion("authorities >=", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesLessThan(String value) {
            addCriterion("authorities <", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesLessThanOrEqualTo(String value) {
            addCriterion("authorities <=", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesLike(String value) {
            addCriterion("authorities like", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesNotLike(String value) {
            addCriterion("authorities not like", value, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesIn(List<String> values) {
            addCriterion("authorities in", values, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesNotIn(List<String> values) {
            addCriterion("authorities not in", values, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesBetween(String value1, String value2) {
            addCriterion("authorities between", value1, value2, "authorities");
            return (Criteria) this;
        }

        public Criteria andAuthoritiesNotBetween(String value1, String value2) {
            addCriterion("authorities not between", value1, value2, "authorities");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityIsNull() {
            addCriterion("access_token_validity is null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityIsNotNull() {
            addCriterion("access_token_validity is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityEqualTo(Integer value) {
            addCriterion("access_token_validity =", value, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityNotEqualTo(Integer value) {
            addCriterion("access_token_validity <>", value, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityGreaterThan(Integer value) {
            addCriterion("access_token_validity >", value, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityGreaterThanOrEqualTo(Integer value) {
            addCriterion("access_token_validity >=", value, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityLessThan(Integer value) {
            addCriterion("access_token_validity <", value, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityLessThanOrEqualTo(Integer value) {
            addCriterion("access_token_validity <=", value, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityIn(List<Integer> values) {
            addCriterion("access_token_validity in", values, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityNotIn(List<Integer> values) {
            addCriterion("access_token_validity not in", values, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityBetween(Integer value1, Integer value2) {
            addCriterion("access_token_validity between", value1, value2, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAccessTokenValidityNotBetween(Integer value1, Integer value2) {
            addCriterion("access_token_validity not between", value1, value2, "accessTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityIsNull() {
            addCriterion("refresh_token_validity is null");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityIsNotNull() {
            addCriterion("refresh_token_validity is not null");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityEqualTo(Integer value) {
            addCriterion("refresh_token_validity =", value, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityNotEqualTo(Integer value) {
            addCriterion("refresh_token_validity <>", value, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityGreaterThan(Integer value) {
            addCriterion("refresh_token_validity >", value, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityGreaterThanOrEqualTo(Integer value) {
            addCriterion("refresh_token_validity >=", value, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityLessThan(Integer value) {
            addCriterion("refresh_token_validity <", value, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityLessThanOrEqualTo(Integer value) {
            addCriterion("refresh_token_validity <=", value, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityIn(List<Integer> values) {
            addCriterion("refresh_token_validity in", values, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityNotIn(List<Integer> values) {
            addCriterion("refresh_token_validity not in", values, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityBetween(Integer value1, Integer value2) {
            addCriterion("refresh_token_validity between", value1, value2, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenValidityNotBetween(Integer value1, Integer value2) {
            addCriterion("refresh_token_validity not between", value1, value2, "refreshTokenValidity");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationIsNull() {
            addCriterion("additional_information is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationIsNotNull() {
            addCriterion("additional_information is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationEqualTo(String value) {
            addCriterion("additional_information =", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationNotEqualTo(String value) {
            addCriterion("additional_information <>", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationGreaterThan(String value) {
            addCriterion("additional_information >", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationGreaterThanOrEqualTo(String value) {
            addCriterion("additional_information >=", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationLessThan(String value) {
            addCriterion("additional_information <", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationLessThanOrEqualTo(String value) {
            addCriterion("additional_information <=", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationLike(String value) {
            addCriterion("additional_information like", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationNotLike(String value) {
            addCriterion("additional_information not like", value, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationIn(List<String> values) {
            addCriterion("additional_information in", values, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationNotIn(List<String> values) {
            addCriterion("additional_information not in", values, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationBetween(String value1, String value2) {
            addCriterion("additional_information between", value1, value2, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionalInformationNotBetween(String value1, String value2) {
            addCriterion("additional_information not between", value1, value2, "additionalInformation");
            return (Criteria) this;
        }

        public Criteria andAutoapproveIsNull() {
            addCriterion("autoapprove is null");
            return (Criteria) this;
        }

        public Criteria andAutoapproveIsNotNull() {
            addCriterion("autoapprove is not null");
            return (Criteria) this;
        }

        public Criteria andAutoapproveEqualTo(String value) {
            addCriterion("autoapprove =", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveNotEqualTo(String value) {
            addCriterion("autoapprove <>", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveGreaterThan(String value) {
            addCriterion("autoapprove >", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveGreaterThanOrEqualTo(String value) {
            addCriterion("autoapprove >=", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveLessThan(String value) {
            addCriterion("autoapprove <", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveLessThanOrEqualTo(String value) {
            addCriterion("autoapprove <=", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveLike(String value) {
            addCriterion("autoapprove like", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveNotLike(String value) {
            addCriterion("autoapprove not like", value, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveIn(List<String> values) {
            addCriterion("autoapprove in", values, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveNotIn(List<String> values) {
            addCriterion("autoapprove not in", values, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveBetween(String value1, String value2) {
            addCriterion("autoapprove between", value1, value2, "autoapprove");
            return (Criteria) this;
        }

        public Criteria andAutoapproveNotBetween(String value1, String value2) {
            addCriterion("autoapprove not between", value1, value2, "autoapprove");
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

        public Criteria andIfLimitIsNull() {
            addCriterion("if_limit is null");
            return (Criteria) this;
        }

        public Criteria andIfLimitIsNotNull() {
            addCriterion("if_limit is not null");
            return (Criteria) this;
        }

        public Criteria andIfLimitEqualTo(Integer value) {
            addCriterion("if_limit =", value, "ifLimit");
            return (Criteria) this;
        }

        public Criteria andIfLimitNotEqualTo(Integer value) {
            addCriterion("if_limit <>", value, "ifLimit");
            return (Criteria) this;
        }

        public Criteria andIfLimitGreaterThan(Integer value) {
            addCriterion("if_limit >", value, "ifLimit");
            return (Criteria) this;
        }

        public Criteria andIfLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("if_limit >=", value, "ifLimit");
            return (Criteria) this;
        }

        public Criteria andIfLimitLessThan(Integer value) {
            addCriterion("if_limit <", value, "ifLimit");
            return (Criteria) this;
        }

        public Criteria andIfLimitLessThanOrEqualTo(Integer value) {
            addCriterion("if_limit <=", value, "ifLimit");
            return (Criteria) this;
        }

        public Criteria andIfLimitIn(List<Integer> values) {
            addCriterion("if_limit in", values, "ifLimit");
            return (Criteria) this;
        }

        public Criteria andIfLimitNotIn(List<Integer> values) {
            addCriterion("if_limit not in", values, "ifLimit");
            return (Criteria) this;
        }

        public Criteria andIfLimitBetween(Integer value1, Integer value2) {
            addCriterion("if_limit between", value1, value2, "ifLimit");
            return (Criteria) this;
        }

        public Criteria andIfLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("if_limit not between", value1, value2, "ifLimit");
            return (Criteria) this;
        }

        public Criteria andLimitCountIsNull() {
            addCriterion("limit_count is null");
            return (Criteria) this;
        }

        public Criteria andLimitCountIsNotNull() {
            addCriterion("limit_count is not null");
            return (Criteria) this;
        }

        public Criteria andLimitCountEqualTo(Integer value) {
            addCriterion("limit_count =", value, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountNotEqualTo(Integer value) {
            addCriterion("limit_count <>", value, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountGreaterThan(Integer value) {
            addCriterion("limit_count >", value, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_count >=", value, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountLessThan(Integer value) {
            addCriterion("limit_count <", value, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountLessThanOrEqualTo(Integer value) {
            addCriterion("limit_count <=", value, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountIn(List<Integer> values) {
            addCriterion("limit_count in", values, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountNotIn(List<Integer> values) {
            addCriterion("limit_count not in", values, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountBetween(Integer value1, Integer value2) {
            addCriterion("limit_count between", value1, value2, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_count not between", value1, value2, "limitCount");
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