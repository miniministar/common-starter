package com.exercise.common.component.exception;

import com.exercise.common.core.api.CommonResult;
import com.exercise.common.core.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public CommonResult handle(ApiException e) {
        log.error("自定义异常：", e);
        if (e.getErrorCode() != null) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }

    // 参数校验异常处理 ===========================================================================
    // MethodArgumentNotValidException是springBoot中进行绑定参数校验时的异常,需要在springBoot中处理,其他需要处理ConstraintViolationException异常进行处理.

    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult handleMethodArgumentNotValidException( MethodArgumentNotValidException e ) {
        log.error( "方法参数校验: " + e.getMessage(), e );
        FieldError fieldError = e.getBindingResult().getFieldError();
        return CommonResult.failed( fieldError.getDefaultMessage() );
    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public CommonResult handleValidationException(ValidationException e) {
        log.error( "ValidationException:", e );
        return CommonResult.failed( e.getCause().getMessage() );
    }

    /**
     * ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public CommonResult handleConstraintViolationException(ConstraintViolationException e) {
        log.error( "ValidationException:" + e.getMessage(), e );
        return CommonResult.failed( e.getMessage() );
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public CommonResult handlerNoFoundException(Exception e) {
        return CommonResult.failed( "路径不存在，请检查路径是否正确" );
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public CommonResult handleDuplicateKeyException(DuplicateKeyException e) {
        return CommonResult.failed( "数据重复，请检查后提交" );
    }




    //    ===============================================

    @ExceptionHandler(RuntimeException.class)
    public CommonResult handleRuntimeException(RuntimeException e) {
        log.error("系统异常: ", e);
        e.printStackTrace();
        return CommonResult.failed("系统异常，操作失败");
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public CommonResult nullPointerExceptionHandler(NullPointerException ex) {
        log.error("空指针异常:", ex);
        return CommonResult.failed("空指针异常!");
    }

    /**
     * 类型转换异常
     */
    @ExceptionHandler(ClassCastException.class)
    public CommonResult classCastExceptionHandler(ClassCastException ex) {
        log.error("类型转换异常:", ex);
        return CommonResult.failed("类型转换异常!");
    }

    /**
     * 数组越界异常
     */
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public CommonResult ArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex) {
        log.error("数组越界异常:", ex);
        return CommonResult.failed("数组越界异常!");
    }

    /**
     * 其他错误
     */
    @ExceptionHandler({Exception.class})
    public CommonResult exception(Exception ex) {
        log.error("其他错误:", ex);
        return CommonResult.failed(  ex.getMessage() );
    }
}
