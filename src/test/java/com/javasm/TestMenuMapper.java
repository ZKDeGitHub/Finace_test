package com.javasm;

import com.javasm.entity.Menu;
import com.javasm.mapper.MenuMapper;
import com.javasm.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMenuMapper {
    @Test
    public void queryLoginMenuList() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<Menu> menuList = menuMapper.queryLoginMenuList(2,1);
        menuList.forEach(menu -> System.out.println(menu));
        SqlSessionUtils.closeSqlSession(sqlSession);
    }
}
