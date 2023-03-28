package cn.hgd.springframework.beans.factory.config;

/**
 * 单例注册表
 * @author hgd
 */
public interface SingletonBeanRegistry {
    /**
     * 获取单例bean
     * @param beanName bean名称
     * @return 单例bean对象
     */
    Object getSingleton(String beanName);
}
