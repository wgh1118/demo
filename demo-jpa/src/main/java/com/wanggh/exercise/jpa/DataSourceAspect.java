package com.wanggh.exercise.jpa;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
@Order(-1) //保证在事务之前执行
public class DataSourceAspect implements Ordered {

    @Pointcut("@annotation(com.wanggh.exercise.jpa.Ds)")
    public void dsPoint() {

    }

    @Around("dsPoint()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Ds ds = method.getAnnotation(Ds.class);
        if (ds == null) {
            DynamicDataSource.setDataSource(DsType.MASTER);
            log.info("set datasource is master");
        } else {
            DynamicDataSource.setDataSource(ds.name());
            log.info("set datasource is " + ds.name());
        }
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            log.info("clean datasource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}