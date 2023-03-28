package cn.hgd.springframework.test;

import cn.hgd.springframework.factory.config.BeanDefinition;
import cn.hgd.springframework.factory.support.DefaultListableBeanFactory;
import org.junit.Test;
import cn.hgd.springframework.test.bean.UserService;

public class ApiTest {
    
    @Test
    public void test_beanFactory() {
        // 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 注册Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registryBeanDefinition("userService",beanDefinition);
        // 第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 第二次获取bean bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }
}
