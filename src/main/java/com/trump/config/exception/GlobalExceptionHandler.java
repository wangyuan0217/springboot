package com.trump.config.exception;

import com.trump.domain.BaseResponse;
import com.trump.enmu.ErrorCode;
import com.trump.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest req,Exception e)throws Exception {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName(DEFAULT_ERROR_VIEW);
//        return mav;
//    }

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //请求参数非model时validate异常处理
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public String handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> set = e.getConstraintViolations();
        Iterator iterator = set.iterator();
        String msg = "";
        if (iterator.hasNext()) {
            ConstraintViolation item = (ConstraintViolation) iterator.next();
            msg = item.getMessage();
        }
        // 生成返回结果
        BaseResponse errorResult = new BaseResponse();
        errorResult.setCode(ErrorCode.SERVER_NULL_PARAM.getCode());
        errorResult.setMessage(msg);
        return GsonUtil.toJson(errorResult);
    }

    //请求参数是model接收的时候的参数validate异常处理
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public String handleBindException(BindException ex) {
        // ex.getFieldError():随机返回一个对象属性的异常信息。如果要一次性返回所有对象属性异常信息，则调用ex.getAllErrors()
        FieldError fieldError = ex.getFieldError();
        // 生成返回结果
        BaseResponse errorResult = new BaseResponse();
        errorResult.setCode(ErrorCode.SERVER_NULL_PARAM.getCode());
        errorResult.setMessage(fieldError.getDefaultMessage());
        return GsonUtil.toJson(errorResult);
    }

    //因为@RequestParam的require默认的true,这边处理漏传的情况
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public String handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        // 生成返回结果
        BaseResponse errorResult = new BaseResponse();
        errorResult.setCode(ErrorCode.SERVER_NULL_PARAM.getCode());
        errorResult.setMessage("缺少参数");
        return GsonUtil.toJson(errorResult);
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        BaseResponse mBaseResponse = new BaseResponse();
        mBaseResponse.setCode(ErrorCode.SERVER_UNNORMAL_ERROR.getCode());
        mBaseResponse.setMessage(ErrorCode.SERVER_UNNORMAL_ERROR.getMessage());
        return GsonUtil.toJson(mBaseResponse);
    }

}