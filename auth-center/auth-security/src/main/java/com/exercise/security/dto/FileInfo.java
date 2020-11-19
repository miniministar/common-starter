package com.exercise.security.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FileInfo {
    @ApiModelProperty(value = "文件名称")
    private String fileName;
    @ApiModelProperty(value = "地址")
    private String url;
}
