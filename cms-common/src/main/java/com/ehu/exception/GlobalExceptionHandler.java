package com.ehu.exception;

import com.ehu.bean.ResultCode;
import com.ehu.bean.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        log.error(e.getMessage());
        mav.addObject("exception", e.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("common/error");
        return mav;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Result<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        Result<String> r = new Result<>();
        log.error(e.getMessage());
        r.setMsg(e.getMessage());
        r.setCode(ResultCode.FAIL.code);
        r.setData("Some Data");
        return r;
    }

}

