package com.ehu.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
　* @description:动态数据源
　* @author geyl
　* @date 2018-8-9 16:34 
　*/
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }

}
