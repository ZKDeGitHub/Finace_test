package com.javasm;

import com.javasm.entity.Menu;
import com.javasm.service.MenuService;
import com.javasm.service.impl.MenuServiceImpl;
import org.junit.Test;

import java.util.List;

public class TestMenuService {
    @Test
    public void queryLoginMenuList(){
        MenuService menuService = new MenuServiceImpl();
        List<Menu> menuList = menuService.queryLoginMenuList(2);
        System.out.println(menuList);
        System.out.println("======");
        menuList.forEach(menu -> System.out.println(menu));
    }


}
