package cn.hgd.springframework.factory.support;

import cn.hgd.springframework.factory.config.BeanDefinition;

/**
 * Bean注册表
 * @author hgd
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册beanDefinition
     * @param beanName bean名称
     * @param beanDefinition bean定义对象
     */
    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
