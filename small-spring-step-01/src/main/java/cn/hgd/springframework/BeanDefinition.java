package cn.hgd.springframework;

/**
 * Bean定义
 * @author hgd
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
