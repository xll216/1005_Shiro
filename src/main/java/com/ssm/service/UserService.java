package com.ssm.service;

import com.ssm.domain.User;

import java.util.Set;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface UserService {

    User selectByUserName(String userName);

    Set<String> getRoles(String userName);

    Set<String> getPermissions(String userName);
}
