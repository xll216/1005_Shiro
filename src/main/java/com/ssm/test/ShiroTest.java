package com.ssm.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class ShiroTest {

    /**
     * 1，简单的身份认证
     * 使用shiro.ini配置文件进行用户的初始化
     **/
    @Test
    public void testLogin() {
        /*1,创建一个SecurityManager工厂对象*/
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory(
                        "classpath:shiro.ini");

        /*2,获取SecurityManager对象*/
        SecurityManager securityManager = factory.getInstance();

        /*3,将SecurityManager设置给shiro工具类中*/
        SecurityUtils.setSecurityManager(securityManager);

        /*4,获得Subject用户对象*/
        Subject currentUser = SecurityUtils.getSubject();

        /*5,创建用户名/密码令牌token*/
        UsernamePasswordToken token =
                new UsernamePasswordToken(
                        "d",
                        "1");
        //token中设置的用户名和密码是前端用户输入的用户名、密码

        /*6,通过login方法进行用户身份认证*/
        try {
            currentUser.login(token);
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
        } catch (UnknownAccountException e) {
            System.out.println("未知账号");
        } catch (LockedAccountException e) {
            System.out.println("账号锁定");
        } catch (AuthenticationException e) {
            System.out.println("身份认证异常");
        }


    }

    /**
     * 2,简单的角色授权
     * 使用shiro.ini配置文件进行用户的初始化
     **/
    @Test
    public void testRole() {
        /*1,获取工厂对象*/
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory(
                        "classpath:shiro.ini");

        /*2,获取SecurityManager对象*/
        SecurityManager securityManager = factory
                .getInstance();

        /*3,将SecurityManager设置到shiro的工具对象中*/
        SecurityUtils.setSecurityManager(securityManager);

        /*4,获取Subject用户对象*/
        Subject currentUser = SecurityUtils.getSubject();

        /*5,认证*/
        UsernamePasswordToken token = new
                UsernamePasswordToken(
                "lishi", "111");

        currentUser.login(token);//先走认证 然后再走授权


        System.out.println("检查是否拥有某个角色：" +
                currentUser.hasRole("部门经理"));

        /*hasRole判断是否拥有某个角色，返回一个boolean值
        * 而checkRole检查某个角色，如果没有该角色会抛出异常*/

        System.out.println("检查是否拥有某个权限：" +
                currentUser.isPermitted("student:*"));

    }
}
