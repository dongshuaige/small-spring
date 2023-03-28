package cn.hgd.springframework.beans.factory.support;

import cn.hgd.springframework.beans.BeansException;
import cn.hgd.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author hgd
 * JDK自带的DeclaredConstructor 进行实例化
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException {
        // 通过beanDefinition获取Class信息,这个class信息是Bean定义的时候传递进来的
        Class<?> clazz = beanDefinition.getBeanClass();
        try {
            // 判断ctor是否为空,如果为空则无参构造函数实例化,否则需要有参构造函数的实例化
            if (null != ctor) {
                // 把入参信息传递给newInstance 进行实例化
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                // 实例化无参构造
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
