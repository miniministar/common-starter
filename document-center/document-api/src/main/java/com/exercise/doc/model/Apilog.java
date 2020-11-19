package com.exercise.doc.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Apilog implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "接口id")
    private Long apiId;

    @ApiModelProperty(value = "接口名称")
    private String apiName;

    @ApiModelProperty(value = "接口地址")
    private String url;

    @ApiModelProperty(value = "请求方式")
    private String method;

    @ApiModelProperty(value = "请求参数头")
    private String requestHearders;

    @ApiModelProperty(value = "请求参数")
    private String requestParameters;

    @ApiModelProperty(value = "响应状态")
    private String responseCode;

    @ApiModelProperty(value = "用户id")
    private Long operUserId;

    @ApiModelProperty(value = "用户姓名")
    private String operUserName;

    @ApiModelProperty(value = "调用ip")
    private String operIp;

    @ApiModelProperty(value = "操作地点")
    private String operLocation;

    @ApiModelProperty(value = "浏览器类型")
    private String operBrowser;

    @ApiModelProperty(value = "操作系统")
    private String operOs;

    @ApiModelProperty(value = "用户姓名")
    private Date startTime;

    @ApiModelProperty(value = "用户姓名")
    private Date endTime;

    @ApiModelProperty(value = "描述")
    private String remark;

    @ApiModelProperty(value = "状态(1成功 0失败)")
    private Integer status;

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

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
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

    public String getRequestHearders() {
        return requestHearders;
    }

    public void setRequestHearders(String requestHearders) {
        this.requestHearders = requestHearders;
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

    public Long getOperUserId() {
        return operUserId;
    }

    public void setOperUserId(Long operUserId) {
        this.operUserId = operUserId;
    }

    public String getOperUserName() {
        return operUserName;
    }

    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName;
    }

    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getOperLocation() {
        return operLocation;
    }

    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation;
    }

    public String getOperBrowser() {
        return operBrowser;
    }

    public void setOperBrowser(String operBrowser) {
        this.operBrowser = operBrowser;
    }

    public String getOperOs() {
        return operOs;
    }

    public void setOperOs(String operOs) {
        this.operOs = operOs;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        sb.append(", apiId=").append(apiId);
        sb.append(", apiName=").append(apiName);
        sb.append(", url=").append(url);
        sb.append(", method=").append(method);
        sb.append(", requestHearders=").append(requestHearders);
        sb.append(", requestParameters=").append(requestParameters);
        sb.append(", responseCode=").append(responseCode);
        sb.append(", operUserId=").append(operUserId);
        sb.append(", operUserName=").append(operUserName);
        sb.append(", operIp=").append(operIp);
        sb.append(", operLocation=").append(operLocation);
        sb.append(", operBrowser=").append(operBrowser);
        sb.append(", operOs=").append(operOs);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", responseParameters=").append(responseParameters);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}