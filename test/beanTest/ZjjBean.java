package main.mini_spring.test.beanTest;

import lombok.Data;
import lombok.ToString;
import main.mini_spring.beans.annotation.ZjjMiniBean;

import javax.annotation.Resource;

/**
 * @ClassName ZjjBean
 * @Author zhongjunjie
 * @Date 2023/3/24 5:11 PM
 * @Version 1.0
 */
@ZjjMiniBean
@Data
@ToString
public class ZjjBean {

    @Resource(name = "zjjBeanInject")
    private ZjjBeanInject zjjBeanInject;

    private String name;

    private String age;


}
