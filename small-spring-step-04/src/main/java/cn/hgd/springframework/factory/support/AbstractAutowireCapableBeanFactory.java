package cn.hgd.springframework.factory.support;

import cn.hgd.springframework.BeansException;
import cn.hgd.springframework.bean.PropertyValue;
import cn.hgd.springframework.bean.PropertyValues;
import cn.hgd.springframework.factory.config.BeanDefinition;
import cn.hgd.springframework.factory.config.BeanReference;
import cn.hutool.core.bean.BeanUtil;

import java.lang.reflect.Constructor;

/**
 * @author hgd
 * 抽象的带自动装配能力的Bean工厂
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean;
        try {
            // 实例化bean
            bean = createBeanInstance(beanName, beanDefinition, args);
            // 给Bean填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 存放到单例对象中的缓存中去
        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * 有参构造 的Bean实例化
     *
     * @param beanName       bean名称
     * @param beanDefinition bean名称
     * @param args           构造参数
     * @return 实例化后的bean
     */
    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Constructor<?> constructorToUse = null;
        // 获取class
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 获取类中所有声明的构造器
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        // 遍历构造器
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * Bean属性填充
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    // A依赖B,获取B的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }

        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
