package main.mini_spring.beans.factory.impl;

import io.netty.util.internal.StringUtil;
import main.mini_spring.beans.annotation.ZjjMiniBean;
import main.mini_spring.beans.factory.BeansFactory;

import javax.annotation.Resource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BeansFactoryImpl
 * @Author zhongjunjie
 * @Date 2023/3/24 4:10 PM
 * @Version 1.0
 */
public class ZjjBeansFactory implements BeansFactory {

    private static Map<String, Object> beanMap;

    @Override
    public Object createBean(Class<?> clazz, String name) {
        try {
            // 将clazz实例化
            Object object = clazz.newInstance();
            if (StringUtil.isNullOrEmpty(name)) {
                name = clazz.getName();
            }
            // 先将其放入beanMap中
            registerBean(name, object);
            // 获取object中的属性
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                // 将属性进行默认初始化
                field.setAccessible(true);
                // 获取属性上的注解, 判断是否有Resource注解
                Resource annotation = field.getAnnotation(Resource.class);
                if (annotation != null) {
                    // 说明其要被注入，需要获取其注入的bean
                    Class<?> fieldClass = field.getType();
                    String fieldClassName = annotation.name();
                    if (StringUtil.isNullOrEmpty(fieldClassName)) {
                        fieldClassName = fieldClass.getName();
                    }
                    if (beanMap.get(fieldClassName) == null) {
                        createBean(fieldClass, fieldClassName);
                        // 再将其注入
                        field.set(object, beanMap.get(fieldClassName));
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object getBean(String beanName) {
        return beanMap.get(beanName);
    }

    @Override
    public Boolean destroyBean(String beanName) {
        if (beanMap.get(beanName) != null) {
            beanMap.remove(beanName);
            return true;
        }
        return false;
    }

    @Override
    public Boolean registerBean(String name, Object bean) {
        if (beanMap.get(name) == null) {
            beanMap.put(name, bean);
            return true;
        }
        return false;
    }

    public ZjjBeansFactory() {
        beanMap = new HashMap<>();
    }
}
