package com.javasm.controller;

import com.javasm.entity.CodeAndMsg;
import com.javasm.entity.Menu;
import com.javasm.entity.ReturnEntity;
import com.javasm.service.MenuService;
import com.javasm.service.impl.MenuServiceImpl;
import com.javasm.util.CORSUtils;
import com.javasm.util.RespUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author:
 * @className: MenuController
 * @description: 处理菜单请求
 * @date: 2023/6/15 14:53
 * @since: 11
 */
@WebServlet("/menu/query")
public class MenuController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理跨域
        CORSUtils.handleCors(resp);
        //测试提交
        // 接收请求数据
        req.setCharacterEncoding("utf-8");
        // 当前页
        String pageString = req.getParameter("page");
        Integer page = 1;
        if(pageString != null && !"".equals(pageString)){
            page = Integer.valueOf(pageString);
        }
        // 每页显示条数
        String pageSizeString = req.getParameter("pageSize");
        Integer pageSize = 5;
        if(pageSizeString != null && !"".equals(pageSizeString)){
            pageSize = Integer.valueOf(pageSizeString);
        }

        // 调用业务层方法
        MenuService menuService = new MenuServiceImpl();
        List<Menu> menuList = menuService.queryAllMenuList(page,pageSize);

        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        if(menuList !=null && menuList.size() > 0){
            entity.setReturnMsg(CodeAndMsg.SUCCESS_QUERY.getReturnMsg());
            entity.setReturnCode(CodeAndMsg.SUCCESS_QUERY.getReturnCode());
            entity.setReturnData(menuList);
        } else{
            entity.setReturnMsg(CodeAndMsg.FAILURED_QUERY.getReturnMsg());
            entity.setReturnCode(CodeAndMsg.FAILURED_QUERY.getReturnCode());
        }

        // 写出响应数据
        RespUtils.handleResp(resp,entity);
    }
}
