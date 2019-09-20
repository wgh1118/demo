package com.wanggh.exercise.jpa;

import java.lang.annotation.*;

/**
 * @author wanggh
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Ds {
    /**
     * 默认主库
     *
     * @return
     */
    DsType name() default DsType.MASTER;
}