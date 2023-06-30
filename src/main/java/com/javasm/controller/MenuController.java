package com.javasm.controller;

import com.javasm.entity.CodeAndMsg;
import com.javasm.entity.Menu;
import com.javasm.entity.PageInfo;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:
 * @className: MenuController
 * @description: 处理菜单请求
 * @date: 2023/6/15 14:53
 * @since: 11
 */
@WebServlet("/menu/*")
public class MenuController extends BaseController {

    /**
     * 处理菜单查询请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("执行MenuController.query()");
        // 处理跨域
        CORSUtils.handleCors(resp);

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
        // 菜单名称
        String menuName = req.getParameter("menuName");
        // 上级菜单id
        Integer parentId = 0;
        String parentIdString = req.getParameter("parentId");
        if(parentIdString != null && !"".equals(parentIdString)){
            parentId = Integer.valueOf(parentIdString);
        }
        // 把菜单名称和上级菜单id放入Menu对象中，用于条件查询
        Menu menu = new Menu(menuName,parentId);

        // 调用业务层方法
        MenuService menuService = new MenuServiceImpl();
        List<Menu> menuList = menuService.queryAllMenuList(menu,page,pageSize);

        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        if(menuList !=null && menuList.size() > 0){
            entity.setReturnMsg(CodeAndMsg.SUCCESS_QUERY.getReturnMsg());
            entity.setReturnCode(CodeAndMsg.SUCCESS_QUERY.getReturnCode());
            Map<String,Object> returnMap = new HashMap<>();
            returnMap.put("menuList",menuList);
            Integer total = menuService.queryTotalNum(menu);
            PageInfo pageInfo = new PageInfo(page,pageSize,total);
            returnMap.put("pageInfo",pageInfo);
            entity.setReturnData(returnMap);
        } else{
            entity.setReturnMsg(CodeAndMsg.FAILURED_QUERY.getReturnMsg());
            entity.setReturnCode(CodeAndMsg.FAILURED_QUERY.getReturnCode());
            // 当根据查询条件查询的数据为空时，给一个默认的数据（总条数为0，在第一页，每页显示5条）
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.put("pageInfo", new PageInfo(1,5,0));
            entity.setReturnData(returnMap);
        }

        // 写出响应数据
        RespUtils.handleResp(resp,entity);
    }

    /**
     * 获取一级菜单数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryOneMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    /**
     * 处理菜单新增请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行MenuController.add()方法");
    }
}
