package com.javasm.service.impl;

import com.javasm.entity.User;
import com.javasm.mapper.UserMapper;
import com.javasm.service.UserService;
import com.javasm.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {

    @Override
    public User queryByUserNameAndUserPwd(User user) {
            SqlSession sqlSession = SqlSessionUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User loginUser = userMapper.queryByUserNameAndUserPwd(user);
            SqlSessionUtils.closeSqlSession(sqlSession);
            return loginUser;
    }
}

