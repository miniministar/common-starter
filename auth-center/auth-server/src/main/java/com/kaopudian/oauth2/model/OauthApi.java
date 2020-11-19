package com.exercise.oauth2.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class OauthApi implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "应用标识")
    private Long clientCode;

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

    @ApiModelProperty(value = "接口描述")
    private String desc;

    @ApiModelProperty(value = "请求参数")
    private String requestParameters;

    @ApiModelProperty(value = "响应状态")
    private String responseCode;

    @ApiModelProperty(value = "响应参数")
    private String responseParameters;

    @ApiModelProperty(value = "响应示例")
    private String responseExample;

    @ApiModelProperty(value = "状态(1启用 0停用)")
    private Integer status;

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

    public Long getClientCode() {
        return clientCode;
    }

    public void setClientCode(Long clientCode) {
        this.clientCode = clientCode;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getResponseParameters() {
        return responseParameters;
    }

    public void setResponseParameters(String responseParameters) {
        this.responseParameters = responseParameters;
    }

    public String getResponseExample() {
        return responseExample;
    }

    public void setResponseExample(String responseExample) {
        this.responseExample = responseExample;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", clientCode=").append(clientCode);
        sb.append(", dataName=").append(dataName);
        sb.append(", apiName=").append(apiName);
        sb.append(", apiType=").append(apiType);
        sb.append(", url=").append(url);
        sb.append(", method=").append(method);
        sb.append(", desc=").append(desc);
        sb.append(", requestParameters=").append(requestParameters);
        sb.append(", responseCode=").append(responseCode);
        sb.append(", responseParameters=").append(responseParameters);
        sb.append(", responseExample=").append(responseExample);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}