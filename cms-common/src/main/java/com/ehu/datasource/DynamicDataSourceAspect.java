package com.ehu.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
　* @description:切换数据源Advice
　* @author geyl
　* @date 2018-8-9 16:35 
　*/
@Order(-1) // 保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(ds)")
    public void changeDataSource(JoinPoint point, TargetDataSource ds) {
        String dsId = ds.value().getKey();
        if (!DynamicDataSourceContextHolder.containsDataSource(dsId)) {
            logger.error("数据源[{}]不存在，使用默认数据源 > {}", ds.value().getKey(), point.getSignature());
        } else {
            logger.debug("Use DataSource : {} > {}", ds.value().getKey(), point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceType(ds.value().getKey());
        }
    }

    @After("@annotation(ds)")
    public void restoreDataSource(JoinPoint point, TargetDataSource ds) {
        logger.debug("Revert DataSource : {} > {}", ds.value().getKey(), point.getSignature());
        DynamicDataSourceContextHolder.clearDataSourceType();
    }

}
