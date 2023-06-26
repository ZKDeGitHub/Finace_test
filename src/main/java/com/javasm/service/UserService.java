package com.javasm.service;

import com.javasm.entity.User;

public interface UserService {

    // 根据用户名和密码查询登录用户数据
    User queryByUserNameAndUserPwd(User user);
}
