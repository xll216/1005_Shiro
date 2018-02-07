package com.ssm.test;

import com.ssm.domain.User;
import org.junit.Test;

import java.util.Set;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class UserTest extends BaseTest {

    @Test
    public void testDao() {

        String userName = "张三";

        User user = userDao.selectByUserName(userName);

        System.out.println(user);

        Set<String> roles = userDao.getRoles(userName);

        System.out.println(roles);

        Set<String> permissions = userDao.getPermissions(userName);

        System.out.println(permissions);
    }


    @Test
    public void testService() {

        String userName = "二狗子";

        User user = userService.selectByUserName(userName);

        System.out.println(user);

        Set<String> roles = userService.getRoles(userName);

        System.out.println(roles);

        Set<String> permissions = userService.getPermissions(userName);

        System.out.println(permissions);
    }
}
