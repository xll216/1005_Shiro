package com.ssm.test;

import com.ssm.dao.UserDao;
import com.ssm.service.UserService;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class BaseTest {

    private ApplicationContext context;
    protected UserDao userDao;
    protected UserService userService;


    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext(
                "classpath*:spring-*.xml");

        userDao = context.getBean(UserDao.class);

        userService = context.getBean(UserService.class);
    }
}
