package com.javasm.service.impl;

import com.javasm.entity.Menu;
import com.javasm.mapper.MenuMapper;
import com.javasm.mapper.UserMapper;
import com.javasm.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class MenuServiceImpl implements com.javasm.service.MenuService {
    @Override
    public List<Menu> queryLoginMenuList(Integer userId) {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        // 一级菜单数据
        List<Menu> menuList = menuMapper.queryLoginMenuList(userId,1);
        System.out.println("1级菜单" + menuList);

        // 二级菜单数据
        List<Menu> subMenuList = menuMapper.queryLoginMenuList(userId,2);
        System.out.println("2级菜单" + subMenuList);

        // 循环遍历，把二级菜单添加到对应的一级菜单下
        for (Menu menu : menuList) {
            for (Menu subMenu : subMenuList) {

                // 一级菜单编号和二级上级菜单编号
                if (menu.getMenuId().equals(subMenu.getParentId())) {
                    if (menu.getSubMenu() == null) {
                        menu.setSubMenu(new ArrayList<>());
                    }
                    menu.getSubMenu().add(subMenu);

                }
            }
        }
        return menuList;
    }

    @Override
    public List<Menu> queryAllMenuList(Integer page,Integer pageSize) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<Menu> menuList = menuMapper.queryAllMenuList((page-1)*pageSize,pageSize);
        SqlSessionUtils.closeSqlSession(sqlSession);
        return menuList;
    }
}
