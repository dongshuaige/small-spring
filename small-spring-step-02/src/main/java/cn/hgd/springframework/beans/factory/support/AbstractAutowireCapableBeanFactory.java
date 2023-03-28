package cn.hgd.springframework.beans.factory.support;

import cn.hgd.springframework.beans.BeanException;
import cn.hgd.springframework.beans.factory.config.BeanDefinition;

/**
 * @author hgd
 * 抽象的带自动装配能力的Bean工厂
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException {
        Object bean = null;
        try {
            // 实例化bean
            // TODO 思考:有构造函数入参的对象怎么处理?
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeanException("Instantiation of bean failed",e);
        }
        // 存放到单例对象中的缓存中去
        addSingleton(beanName,bean);
        return bean;
    }
}
