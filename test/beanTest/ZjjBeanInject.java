package main.mini_spring.test.beanTest;

import lombok.Data;
import lombok.ToString;
import main.mini_spring.beans.annotation.ZjjMiniBean;

/**
 * @ClassName ZjjBeanInject
 * @Author zhongjunjie
 * @Date 2023/3/24 5:16 PM
 * @Version 1.0
 */
@Data
@ZjjMiniBean(name = "zjjBeanInject")
@ToString
public class ZjjBeanInject {

    private String nameInject;

    private String ageInject;

}
