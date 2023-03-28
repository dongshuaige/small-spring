package cn.hgd.springframework.beans.factory.support;

import cn.hgd.springframework.beans.BeansException;
import cn.hgd.springframework.beans.factory.BeanFactory;
import cn.hgd.springframework.beans.factory.config.BeanDefinition;

/**
 * @author hgd
 * BeanDefinition 注册表接口
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @SuppressWarnings("unchecked")
    protected <T> T doGetBean(final String name, final Object[] args) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    /**
     * 获取bean定义
     *
     * @param beanName bean名称
     * @return bean定义
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 实例化bean
     *
     * @param beanName       bean名称
     * @param beanDefinition bean名称
     * @param args           构造参数
     * @return bean对象
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

}
