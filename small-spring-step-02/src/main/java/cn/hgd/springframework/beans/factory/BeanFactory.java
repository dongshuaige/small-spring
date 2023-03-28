package cn.hgd.springframework.beans.factory;

import cn.hgd.springframework.beans.BeanException;

/**
 * Bean 工厂接口
 * @author hgd
 */
public interface BeanFactory {
    /**
     * 获取bean
     * @param name bean名称
     * @return bean对象
     * @throws BeanException
     */
    Object getBean(String name) throws BeanException;
}
