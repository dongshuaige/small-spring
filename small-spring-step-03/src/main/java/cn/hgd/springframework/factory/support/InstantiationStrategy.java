package cn.hgd.springframework.factory.support;

import cn.hgd.springframework.BeansException;
import cn.hgd.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author hgd
 * Bean实例化策略
 */
public interface InstantiationStrategy {

    /**
     * 带有入参的构造函数实例化方法
     * @param beanDefinition bean定义
     * @param beanName bean名称
     * @param ctor 包含必要类的信息 拿到符合入参信息相对应的构造函数
     * @param args 入参信息
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException;
}
