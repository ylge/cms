package com.ehu.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
　* @description:记录操作数据库的日志
　* @author geyl
　* @date 2018-5-23 14:27
　*/
@Aspect
@Component
public class LogAspect {

    public void update(){

    }
//    @Pointcut("execution(* com.common.system.service.impl.*.*(..))")
    public void select(){
        System.out.println("...........................................................");
    }
//    @AfterReturning(value = "select()")
    public void select1(){
        System.out.println("...........................................................");
    }
}
