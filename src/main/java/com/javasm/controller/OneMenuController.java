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
 * @description: 获取下拉框的一级菜单数据
 * @date: 2023/6/15 14:53
 * @since: 11
 */
@WebServlet("/query/oneMenu")
public class OneMenuController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理跨域
        // 接收请求数据
        // 调用业务层方法
        // 设置响应数据
        // 写出响应数据
        CORSUtils.handleCors(resp);
        req.setCharacterEncoding("utf-8");
        MenuService menuService = new MenuServiceImpl();
        List<Menu> oneMenuList = menuService.queryOneMenuList();
        ReturnEntity entity = new ReturnEntity();
        if (oneMenuList != null && oneMenuList.size() > 0) {
            entity.setReturnCode(CodeAndMsg.SUCCESS_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.SUCCESS_QUERY.getReturnMsg());
            entity.setReturnData(oneMenuList);
        } else {
            entity.setReturnCode(CodeAndMsg.FAILURED_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.FAILURED_QUERY.getReturnMsg());
        }
        RespUtils.handleResp(resp, entity);

    }

}
