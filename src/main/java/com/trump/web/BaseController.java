package com.trump.web;

import com.trump.config.Constant;
import com.trump.domain.BaseResponse;
import com.trump.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public BaseResponse mBaseResponse;    //bean对象

    protected String getParameter(HttpServletRequest request, String key) {
        return getParameter(request, key, "");
    }

    protected String getParameter(HttpServletRequest request, String key, String defValue) {
        return request.getParameter(key) == null ? defValue : request.getParameter(key).trim();
    }

    protected String getCommonReturn(int code, String message, Object object) {
        if (mBaseResponse == null)
            mBaseResponse = new BaseResponse();
        mBaseResponse.setCode(code);
        mBaseResponse.setMessage(message);
        mBaseResponse.setData(object == null ? "" : object);
        return toJsonStr(mBaseResponse);
    }

    protected String getCommonReturn_Success(Object object) {
        return getCommonReturn(Constant.CODE.SUCCESS, "success", object);
    }

    protected String toJsonStr(Object obj) {
        return GsonUtil.toJson(obj);
    }

}
