package com.wanggh.demo.jpa;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {

    private static ThreadLocal<DsType> handlerThreadLocal = new ThreadLocal<>();

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }

    public static void setDataSource(DsType dataSource) {
        handlerThreadLocal.set(dataSource);
    }

    public static DsType getDataSource() {
        return handlerThreadLocal.get();
    }

    public static void clearDataSource() {
        handlerThreadLocal.remove();
    }
}