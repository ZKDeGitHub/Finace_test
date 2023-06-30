package com.javasm.service;

import com.javasm.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService {

    // 根据用户编号和权限等级查询登录用户的菜单数据
    List<Menu> queryLoginMenuList(Integer userId);

    // 查询所有的菜单数据
    List<Menu> queryAllMenuList(Menu menu,Integer page, Integer pageSize);

    //查询菜单的总条数
    Integer queryTotalNum(Menu menu);

    // 查询一级菜单
    List<Menu> queryOneMenuList();
}
