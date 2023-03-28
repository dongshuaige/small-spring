package cn.hgd.springframework.beans.factory.support;

import cn.hgd.springframework.beans.BeanException;
import cn.hgd.springframework.beans.factory.BeanFactory;
import cn.hgd.springframework.beans.factory.config.BeanDefinition;

/**
 * @author hgd
 * BeanDefinition 注册表接口
 */
public abstract class AbstractBeanFactory extends  DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeanException {
        Object bean = getSingleton(name);
        if(bean!=null){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition);
    }

    /**
     * 获取bean定义
     * @param beanName bean名称
     * @return bean定义
     * @throws BeanException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    /**
     * 实例化bean
     * @param beanName bean名称
     * @param beanDefinition bean名称
     * @return bean对象
     * @throws BeanException
     */
    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition) throws BeanException;
    
}
