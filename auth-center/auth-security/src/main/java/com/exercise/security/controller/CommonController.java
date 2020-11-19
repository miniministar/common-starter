package com.exercise.security.controller;

import com.exercise.common.component.config.ProjectConfig;
import com.exercise.common.core.api.CommonResult;
import com.exercise.common.core.constant.Constants;
import com.exercise.common.core.util.StringUtils;
import com.exercise.common.core.util.file.FileUploadUtils;
import com.exercise.common.core.util.file.FileUtils;
import com.exercise.security.config.ServerConfig;
import com.exercise.security.dto.FileInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用请求处理
 */
@RestController
@RequestMapping("/common/")
@Slf4j
@Api(tags = {"系统通用接口 - "})
public class CommonController
{
    @Autowired
    private ServerConfig serverConfig;

    /**
     * 通用下载请求
     * 
     * @param fileName 文件名称
     * @param delete 是否删除
     */
    @GetMapping("download")
    @ApiOperation(value="通用下载请求",notes="fileName 文件名称， delete 是否删除")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request)
    {
        try
        {
            if (!FileUtils.isValidFilename(fileName))
            {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = ProjectConfig.getDownloadPath() + fileName;

            response.setCharacterEncoding("utf-8");
//            response.setContentType("multipart/form-data");
            //响应时在响应头里添加 Access-Control-Expose-Headers
            response.setHeader("Access-Control-Expose-Headers", "Content-disposition");
            response.setContentType("application/x-download");// 设置response内容的类型
            response.setHeader("Content-disposition",
                    "attachment;filename=" + FileUtils.setFileDownloadHeader(request, realFileName));
            response.setHeader("Set-Cookie", "fileDownload=true; path=/");
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete)
            {
                FileUtils.deleteFile(filePath);
            }
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求
     */
    @PostMapping("upload")
    @ApiOperation(value="通用上传请求",notes="")
    public CommonResult uploadFile(MultipartFile file) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = ProjectConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            FileInfo info = new FileInfo();
            info.setFileName(fileName);
            info.setUrl(url);
            CommonResult result = CommonResult.success(info);
            return result;
        }
        catch (Exception e)
        {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 本地资源通用下载
     */
    @GetMapping("download/resource")
    @ApiOperation(value="本地资源通用下载",notes="")
    public void resourceDownload(String name, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // 本地资源路径
        String localPath = ProjectConfig.getProfile();
        // 数据库资源地址
        String downloadPath = localPath + org.apache.commons.lang3.StringUtils.substringAfter(name, Constants.RESOURCE_PREFIX);
        // 下载名称
        String downloadName = org.apache.commons.lang3.StringUtils.substringAfterLast(downloadPath, "/");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Access-Control-Expose-Headers", "Content-disposition");
        response.setHeader("Content-disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
        FileUtils.writeBytes(downloadPath, response.getOutputStream());
    }
}
