package com.ehu.datasource;

import java.lang.annotation.*;

/**
　* @description:在方法上使用，用于指定使用哪个数据源
　* @author geyl
　* @date 2018-8-9 16:35
　*/
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    
    /** 数据源名称 */
    DataSourceEnum value();
}
