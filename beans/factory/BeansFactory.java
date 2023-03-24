package main.mini_spring.beans.factory;

/**
 * @ClassName BeansFactory
 * @Author zhongjunjie
 * @Date 2023/3/24 3:33 PM
 * @Version 1.0
 * @Description bean工厂，主要用来实例化bean
 */
public interface BeansFactory {

    // 创建bean
    Object createBean(Class<?> clazz, String name);

    // 获取bean
    Object getBean(String beanName);

    // 销毁bean
    Boolean destroyBean(String beanName);

    // 注册bean
    Boolean registerBean(String name, Object bean);

}
