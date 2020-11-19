package com.exercise.oauth2.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class OauthClientDetails implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "应用标识")
    private String clientId;

    @ApiModelProperty(value = "应用名称")
    private String clientName;

    @ApiModelProperty(value = "资源限定串(逗号分割)")
    private String resourceIds;

    @ApiModelProperty(value = "应用密钥(bcyt) 加密")
    private String clientSecret;

    @ApiModelProperty(value = "应用密钥(明文)")
    private String clientSecretStr;

    @ApiModelProperty(value = "范围")
    private String scope;

    @ApiModelProperty(value = "oauth授权方式")
    private String authorizedGrantTypes;

    @ApiModelProperty(value = "回调地址")
    private String webServerRedirectUri;

    @ApiModelProperty(value = "权限")
    private String authorities;

    @ApiModelProperty(value = "access_token有效期(秒)")
    private Integer accessTokenValidity;

    @ApiModelProperty(value = "refresh_token有效期(秒)")
    private Integer refreshTokenValidity;

    @ApiModelProperty(value = "{}")
    private String additionalInformation;

    @ApiModelProperty(value = "是否自动授权 是-true")
    private String autoapprove;

    @ApiModelProperty(value = "状态(1正常 0锁定)")
    private Integer status;

    @ApiModelProperty(value = "是否应用限流(1是 0否)")
    private Integer ifLimit;

    @ApiModelProperty(value = "限流阈值")
    private Integer limitCount;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientSecretStr() {
        return clientSecretStr;
    }

    public void setClientSecretStr(String clientSecretStr) {
        this.clientSecretStr = clientSecretStr;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIfLimit() {
        return ifLimit;
    }

    public void setIfLimit(Integer ifLimit) {
        this.ifLimit = ifLimit;
    }

    public Integer getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(Integer limitCount) {
        this.limitCount = limitCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", clientId=").append(clientId);
        sb.append(", clientName=").append(clientName);
        sb.append(", resourceIds=").append(resourceIds);
        sb.append(", clientSecret=").append(clientSecret);
        sb.append(", clientSecretStr=").append(clientSecretStr);
        sb.append(", scope=").append(scope);
        sb.append(", authorizedGrantTypes=").append(authorizedGrantTypes);
        sb.append(", webServerRedirectUri=").append(webServerRedirectUri);
        sb.append(", authorities=").append(authorities);
        sb.append(", accessTokenValidity=").append(accessTokenValidity);
        sb.append(", refreshTokenValidity=").append(refreshTokenValidity);
        sb.append(", additionalInformation=").append(additionalInformation);
        sb.append(", autoapprove=").append(autoapprove);
        sb.append(", status=").append(status);
        sb.append(", ifLimit=").append(ifLimit);
        sb.append(", limitCount=").append(limitCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}