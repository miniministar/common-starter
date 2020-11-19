package com.exercise.common.core.api.datatable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@ApiModel(description="请求参数对象")
@Data
@ToString
public class RequestDTO <T>{

    /**
     * datatable
     */
    private int draw = 0;
    /**
     * 第一条数据的起始位置，第一条为0
     */
    private int start = 0;

    /**
     * 第几页
     */
    private int pageNum = 1;

    /**
     * 每页长度
     */
    @ApiModelProperty(value = "每页长度")
    private int length = 10;

    /**
     * 自定义搜索参数
     */
    @ApiModelProperty(value = "自定义搜索参数")
    private T  Filter;

    public int getCurrentPageNum() {
        this.pageNum = (this.getStart() + this.getLength()) / this.getLength();
        return this.pageNum;
    }
}
