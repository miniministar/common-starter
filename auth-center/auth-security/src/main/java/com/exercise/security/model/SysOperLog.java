package com.exercise.security.model;

import com.exercise.common.core.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysOperLog implements Serializable {
    //=============== 关联查询字段 start =============================

    @ApiModelProperty(value = "关联查询 - 开始日期")
    private String startDay;
    @ApiModelProperty(value = "关联查询 - 结束日期")
    private String endDay;

    //=============== 关联查询字段 end  =============================
    @Excel(name = "日志序号", cellType = Excel.ColumnType.NUMERIC, prompt = "日志编号")
    @ApiModelProperty(value = "日志主键")
    private Long id;

    @Excel(name = "模块标题")
    @ApiModelProperty(value = "模块标题")
    private String title;

    @Excel(name = "业务类型", readConverterExp = "0=其它,1=新增,2=修改,3=删除,4=授权,5=导出")
    @ApiModelProperty(value = "业务类型（0其它 1新增 2修改 3删除 4授权 5导出）")
    private Integer businessType;

    @Excel(name = "方法名称")
    @ApiModelProperty(value = "方法名称")
    private String methodName;

    @Excel(name = "请求方式")
    @ApiModelProperty(value = "请求方式")
    private String requestMethod;

    @Excel(name = "操作类别", readConverterExp = "0=其它,1=后台用户")
    @ApiModelProperty(value = "操作类别（0其它 1后台用户）")
    private Integer operatorType;

    @Excel(name = "操作账号")
    @ApiModelProperty(value = "操作账号")
    private String username;

    @Excel(name = "操作人姓名")
    @ApiModelProperty(value = "操作人姓名")
    private String userRealName;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @Excel(name = "请求URL")
    @ApiModelProperty(value = "请求URL")
    private String operUrl;

    @Excel(name = "主机地址")
    @ApiModelProperty(value = "主机地址")
    private String operIp;

    @Excel(name = "操作地点")
    @ApiModelProperty(value = "操作地点")
    private String operLocation;

    @ApiModelProperty(value = "请求参数")
    private String operParam;

    @ApiModelProperty(value = "返回参数")
    private String jsonResult;

    @Excel(name = "操作状态", readConverterExp = "0=正常,1=异常")
    @ApiModelProperty(value = "操作状态（0正常 1异常）")
    private Integer status;

    @Excel(name = "错误消息")
    @ApiModelProperty(value = "错误消息")
    private String errorMsg;

    @Excel(name = "操作时间", dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
    @ApiModelProperty(value = "操作时间")
    private Date operTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOperUrl() {
        return operUrl;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
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

    public String getOperParam() {
        return operParam;
    }

    public void setOperParam(String operParam) {
        this.operParam = operParam;
    }

    public String getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", businessType=").append(businessType);
        sb.append(", methodName=").append(methodName);
        sb.append(", requestMethod=").append(requestMethod);
        sb.append(", operatorType=").append(operatorType);
        sb.append(", username=").append(username);
        sb.append(", userRealName=").append(userRealName);
        sb.append(", deptName=").append(deptName);
        sb.append(", operUrl=").append(operUrl);
        sb.append(", operIp=").append(operIp);
        sb.append(", operLocation=").append(operLocation);
        sb.append(", operParam=").append(operParam);
        sb.append(", jsonResult=").append(jsonResult);
        sb.append(", status=").append(status);
        sb.append(", errorMsg=").append(errorMsg);
        sb.append(", operTime=").append(operTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}