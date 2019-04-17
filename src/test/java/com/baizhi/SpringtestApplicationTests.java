package com.baizhi;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringtestApplicationTests {

    @Test
    public void contextLoads() {
        //获取安全管理器工厂
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //获取安全管理器
        SecurityManager securityManager = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //获取token 相当于用户的令牌 包含用户的信息和凭证
        UsernamePasswordToken token = new UsernamePasswordToken("rxx","123321");

        try {
            subject.login(token);
            System.out.println("验证成功");
        } catch (AuthenticationException e) {
            System.out.println("验证失败");
            e.printStackTrace();
        }
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);

    }

}
