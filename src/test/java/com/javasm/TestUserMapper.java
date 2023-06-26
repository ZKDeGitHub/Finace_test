package com.javasm;

import com.javasm.entity.User;
import com.javasm.mapper.UserMapper;
import com.javasm.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestUserMapper {

    @Test
    public void queryByUserNameAndUserPwd(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.queryByUserNameAndUserPwd(new User("root", "1234")));
        SqlSessionUtils.closeSqlSession(sqlSession);
    }
}
