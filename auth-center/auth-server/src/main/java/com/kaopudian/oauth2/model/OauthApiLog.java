package com.exercise.oauth2.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class OauthApiLog implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "应用标识")
    private Long clientCode;

    @ApiModelProperty(value = "应用名称")
    private String clientName;

    @ApiModelProperty(value = "接口id")
    private Long apiId;

    @ApiModelProperty(value = "专用数据集名称")
    private String dataName;

    @ApiModelProperty(value = "接口名称")
    private String apiName;

    @ApiModelProperty(value = "接口类型(专用数据、共享数据)")
    private String apiType;

    @ApiModelProperty(value = "接口地址")
    private String url;

    @ApiModelProperty(value = "请求方式")
    private String method;

    @ApiModelProperty(value = "请求参数")
    private String requestParameters;

    @ApiModelProperty(value = "响应状态")
    private String responseCode;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "调用ip")
    private String ip;

    @ApiModelProperty(value = "用户姓名")
    private Date startTime;

    @ApiModelProperty(value = "用户姓名")
    private Date endTime;

    @ApiModelProperty(value = "描述")
    private String desc;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(value = "响应参数")
    private String responseParameters;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientCode() {
        return clientCode;
    }

    public void setClientCode(Long clientCode) {
        this.clientCode = clientCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiType() {
        return apiType;
    }

    public void setApiType(String apiType) {
        this.apiType = apiType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(String requestParameters) {
        this.requestParameters = requestParameters;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getResponseParameters() {
        return responseParameters;
    }

    public void setResponseParameters(String responseParameters) {
        this.responseParameters = responseParameters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", clientCode=").append(clientCode);
        sb.append(", clientName=").append(clientName);
        sb.append(", apiId=").append(apiId);
        sb.append(", dataName=").append(dataName);
        sb.append(", apiName=").append(apiName);
        sb.append(", apiType=").append(apiType);
        sb.append(", url=").append(url);
        sb.append(", method=").append(method);
        sb.append(", requestParameters=").append(requestParameters);
        sb.append(", responseCode=").append(responseCode);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", ip=").append(ip);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", desc=").append(desc);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", responseParameters=").append(responseParameters);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}