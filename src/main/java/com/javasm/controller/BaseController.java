package com.javasm.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author:
 * @className: BaseController
 * @description: 父类
 * @date: 2023/6/16 9:52
 * @since: 11
 */
public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. 获取到http://localhost:8080/Finace_test_war_exploded/menu/query
        //获取到父级的路径：/menu
        System.out.println(req.getServletPath());
        //获取到拼接子方法的路径： /Finace_test_war_exploded/menu/query
        // 想获取到合并后的servlet的具体方法，用此方法获取
        System.out.println(req.getRequestURI());
        //获取到全路径： http://localhost:8080/Finace_test_war_exploded/menu/query
        System.out.println(req.getRequestURL());

        // 2. 获取方法名(query,add等)
        //substring() 方法返回字符串的子字符串
        String methodName = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/") + 1);
        System.out.println(methodName);

        try {
            // 3. 通过反射获取方法对象
            Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            // 4. 通过反射调用方法执行
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
