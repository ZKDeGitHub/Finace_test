package com.javasm.mapper;

import com.javasm.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {

    // 根据用户编号和权限等级查询登录用户的菜单数据
    List<Menu> queryLoginMenuList(@Param("userId") Integer userId, @Param("level") Integer level);

    // 查询所有的菜单数据
    List<Menu> queryAllMenuList(@Param("startIndex") Integer startIndex,@Param("pageSize") Integer pageSize);

}
