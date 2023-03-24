package main.mini_spring;

import main.mini_spring.beans.factory.BeansFactory;
import main.mini_spring.beans.factory.impl.ZjjBeansFactory;
import main.mini_spring.test.beanTest.ZjjBean;
import main.mini_spring.test.beanTest.ZjjBeanInject;

/**
 * @ClassName Main
 * @Author zhongjunjie
 * @Date 2023/3/24 3:27 PM
 * @Version 1.0
 * @Description mini spring启动器
 */

public class Main {
    public static void main(String[] args) {
        // 1.读取配置文件
        // 2.扫描指定包下的类
        // 3.实例化扫描到的类
        // 4.依赖注入
        // 5.执行main方法
        BeansFactory zjjBeansFactory = new ZjjBeansFactory();
        zjjBeansFactory.createBean(ZjjBean.class, "zjjBean");
        ZjjBean zjjBean = (ZjjBean) zjjBeansFactory.getBean("zjjBean");
        ZjjBeanInject zjjBeanInject = (ZjjBeanInject) zjjBeansFactory.getBean("zjjBeanInject");
        System.out.println(zjjBean);
        System.out.println(zjjBeanInject);
    }
}
