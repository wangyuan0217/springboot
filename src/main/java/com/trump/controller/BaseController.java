package com.trump.controller;

import com.trump.domain.BaseResponse;
import com.trump.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public BaseResponse mBaseResponse;    //bean对象

    /**
     * 获取提交参数，取不到就以空字符串代之
     *
     * @param key
     * @return
     */
    protected String getParameter(HttpServletRequest request, String key) {
        return getParameter(request, key, "");
    }

    /**
     * 获取提交参数，取不到就报参数以定义字符串代替
     *
     * @param key
     * @return
     */
    protected String getParameter(HttpServletRequest request, String key, String defValue) {
        return request.getParameter(key) == null ? defValue : request.getParameter(key).trim();
    }


    /**
     * 由code message data 构造一个标准的json返回数据
     *
     * @param code
     * @param message
     * @param object
     * @return
     */
    public String getCommonReturn(int code, String message, Object object) {
        if (mBaseResponse == null)
            mBaseResponse = new BaseResponse();
        mBaseResponse.setCode(code);
        mBaseResponse.setMessage(message);
        mBaseResponse.setData(object != null ? object : new Object());
        return toJsonStr(mBaseResponse);
    }

    /**
     * 将Object对象转换成为标准的json字符串
     *
     * @param obj
     * @return
     */
    protected String toJsonStr(Object obj) {
        return GsonUtil.toJson(obj);
    }

}
