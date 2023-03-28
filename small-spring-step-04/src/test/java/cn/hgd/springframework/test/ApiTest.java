package cn.hgd.springframework.test;

import cn.hgd.springframework.PropertyValue;
import cn.hgd.springframework.PropertyValues;
import cn.hgd.springframework.factory.config.BeanDefinition;
import cn.hgd.springframework.factory.config.BeanReference;
import cn.hgd.springframework.factory.support.DefaultListableBeanFactory;
import cn.hgd.springframework.test.bean.UserDao;
import cn.hgd.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * 测试用例
 */
public class ApiTest {
    @Test
    public void test_BeanFactory() {
        // 1.初始化BeanFactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        // 2.UserDao注册
        factory.registryBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3.UserService 设置属性[uId、userDao]
        PropertyValues properties = new PropertyValues();
        properties.addPropertyValue(new PropertyValue("uId", "10003"));
        properties.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4.UserService 注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, properties);
        factory.registryBeanDefinition("userService", beanDefinition);

        // 5.UserService 获取Bean
        UserService userService = (UserService) factory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }
}
