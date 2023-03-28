package cn.hgd.springframework.beans.factory.config;

/**
 * Bean定义
 *
 * @author hgd
 */
@SuppressWarnings({"rawtypes"})
public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
