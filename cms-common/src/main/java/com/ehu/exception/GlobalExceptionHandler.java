package com.ehu.exception;

import com.alibaba.druid.support.json.JSONUtils;
import com.ehu.bean.Result;
import com.ehu.bean.ResultCode;
import com.ehu.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "common/error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView businessExceptionHandler(HttpServletRequest req, HttpServletResponse res, Exception e) throws IOException {
        String accept = req.getHeader("Accept");
        String requestType = req.getHeader("X-Requested-With");
        boolean ajax = (requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")) ? true : false;
        if(ajax || accept.contains("json")) {     //ajax请求或者请求端接受json数据
            Result<String> r = new Result<>();
            log.error(e.getMessage());
            r.setMsg(e.getMessage());
            r.setCode(ResultCode.FAIL.code);
            PrintWriter writer = res.getWriter();
            writer.write(JsonUtil.class2JsonString(r));
            writer.flush();
            writer.close();
            return null;
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", req.getRequestURL());
            mav.setViewName(DEFAULT_ERROR_VIEW);
            return mav;
        }
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Result<String> jsonErrorHandler(HttpServletRequest req, MyException e){
        Result<String> r = new Result<>();
        log.error(e.getMessage());
        r.setMsg(e.getMessage());
        r.setCode(ResultCode.FAIL.code);
        return r;
    }

}

