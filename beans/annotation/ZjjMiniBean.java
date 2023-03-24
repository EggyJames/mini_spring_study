package main.mini_spring.beans.annotation;


import main.mini_spring.enums.BeanModeType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName ZjjMiniBean
 * @Author zhongjunjie
 * @Date 2023/3/24 3:29 PM
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ZjjMiniBean {

    // @Retention(RetentionPolicy.RUNTIME)注解的作用是什么？
    // 指定注解的生命周期，RUNTIME表示注解的生命周期是运行时，可以通过反射获取注解的信息

    // @Target(ElementType.TYPE)注解的作用是什么？
    // 指定注解的作用范围，TYPE表示注解只能作用于类上

    String name() default "";

    String type() default "";

    BeanModeType mode() default BeanModeType.SINGLETON;


}
