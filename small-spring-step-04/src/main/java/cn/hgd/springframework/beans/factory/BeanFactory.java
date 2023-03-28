package cn.hgd.springframework.beans.factory;

import cn.hgd.springframework.beans.BeansException;

/**
 * Bean 工厂接口
 * @author hgd
 */
public interface BeanFactory {
    /**
     * 获取bean
     * @param name bean名称
     * @return bean对象
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 获取带有构造函数的入参信息的bean
     * @param name bean名称
     * @param args 构造参数
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;
}
