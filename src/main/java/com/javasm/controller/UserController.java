package com.javasm.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: zk
 * @className: Server
 * @description: ToDo
 * @date: 2023/06/28/19:56
 * @since: 11
 */
@WebServlet("/user/*")
public class UserController extends BaseController{
    /**
     * 用户查询方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了：UserController.query()方法");
    }

    /**
     * 用户新增方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了：UserController.query()方法");
    }

}
