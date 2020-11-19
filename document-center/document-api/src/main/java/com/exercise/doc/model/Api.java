package com.exercise.doc.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Api implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "接口名称")
    private String apiName;

    @ApiModelProperty(value = "分组id")
    private Long apiTypeId;

    @ApiModelProperty(value = "分组名称")
    private String apiTypeName;

    @ApiModelProperty(value = "描述")
    private String remark;

    @ApiModelProperty(value = "接口地址")
    private String url;

    @ApiModelProperty(value = "请求方式")
    private String method;

    @ApiModelProperty(value = "协议")
    private String protocol;

    @ApiModelProperty(value = "请求参数头")
    private String requestHearders;

    @ApiModelProperty(value = "响应状态")
    private String responseCode;

    @ApiModelProperty(value = "状态(1启用 0停用)")
    private Integer status;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(value = "请求参数")
    private String requestParameters;

    @ApiModelProperty(value = "响应参数")
    private String responseParameters;

    @ApiModelProperty(value = "响应示例")
    private String responseExample;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public Long getApiTypeId() {
        return apiTypeId;
    }

    public void setApiTypeId(Long apiTypeId) {
        this.apiTypeId = apiTypeId;
    }

    public String getApiTypeName() {
        return apiTypeName;
    }

    public void setApiTypeName(String apiTypeName) {
        this.apiTypeName = apiTypeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getRequestHearders() {
        return requestHearders;
    }

    public void setRequestHearders(String requestHearders) {
        this.requestHearders = requestHearders;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public String getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(String requestParameters) {
        this.requestParameters = requestParameters;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", apiName=").append(apiName);
        sb.append(", apiTypeId=").append(apiTypeId);
        sb.append(", apiTypeName=").append(apiTypeName);
        sb.append(", remark=").append(remark);
        sb.append(", url=").append(url);
        sb.append(", method=").append(method);
        sb.append(", protocol=").append(protocol);
        sb.append(", requestHearders=").append(requestHearders);
        sb.append(", responseCode=").append(responseCode);
        sb.append(", status=").append(status);
        sb.append(", sort=").append(sort);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", requestParameters=").append(requestParameters);
        sb.append(", responseParameters=").append(responseParameters);
        sb.append(", responseExample=").append(responseExample);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}