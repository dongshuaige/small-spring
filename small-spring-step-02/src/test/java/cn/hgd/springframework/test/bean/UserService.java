package cn.hgd.springframework.test.bean;

/**
 * 定义UserService对象,方便后期对Spring容器测试
 */
public class UserService {

    public void queryUserInfo() {
        System.out.println("查询用户信息");
    }
}
