package com.exercise.common.core.api.datatable;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "返回列表数据对象")
public class ResultDTO<T> {

    private long recordsTotal;

    private long recordsFiltered;

    @ApiModelProperty(value = "列表中的实体类")
    private List<T> data;

    @ApiModelProperty(value = "其他信息")
    private Object other;

    private String error;

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ResultDTO() {}

    public ResultDTO(long draw, long recordsTotal, long recordsFiltered, List data, String error) {
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
        this.error = error;
    }

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> ResultDTO<T> restPage(List<T> list) {
        ResultDTO<T> result = new ResultDTO<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setRecordsFiltered(pageInfo.getPageNum());
        result.setRecordsTotal(pageInfo.getTotal());
        result.setData(pageInfo.getList());
        return result;
    }
}
