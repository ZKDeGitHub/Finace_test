package com.javasm.mapper;

import com.javasm.entity.User;

/**
 * @author:
 * @className: UserMapper
 * @description:
 * @date: 2023/6/8 16:19
 * @since: 11
 */
public interface UserMapper {

    // 根据用户名和密码查询登录用户数据
    User queryByUserNameAndUserPwd(User user);

}
