package com.hmblogs.backend.util;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component("dynamicDataSource")
@Primary
public class DynamicDataSource extends AbstractRoutingDataSource {
    //当前线程

    public static ThreadLocal<String> dataSourceName = new ThreadLocal<>();
    @Resource
    private DataSource dataSource1;
    @Resource
    private DataSource dataSource2;

    @Override
    protected Object determineCurrentLookupKey() {
        //从当前线程中获取数据源
        return dataSourceName.get();
    }

    @Override
    public void afterPropertiesSet() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        //假设B 代表北京的数据源
        targetDataSources.put("B",dataSource1);
        // 假设X 代表厦门的数据源
        targetDataSources.put("X",dataSource2);
        // 初始化 设置所有数据源
        super.setTargetDataSources(targetDataSources);
        // 设置 默认数据源
        super.setDefaultTargetDataSource(dataSource2);
        super.afterPropertiesSet();
    }
}
