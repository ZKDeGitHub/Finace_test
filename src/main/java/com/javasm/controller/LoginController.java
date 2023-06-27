package com.javasm.controller;

import com.javasm.entity.CodeAndMsg;
import com.javasm.entity.Menu;
import com.javasm.entity.ReturnEntity;
import com.javasm.entity.User;
import com.javasm.service.MenuService;
import com.javasm.service.UserService;
import com.javasm.service.impl.MenuServiceImpl;
import com.javasm.service.impl.UserServiceImpl;
import com.javasm.util.CORSUtils;
import com.javasm.util.RespUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 处理跨域
        CORSUtils.handleCors(resp);

        // 接收请求数据
        req.setCharacterEncoding("utf-8");
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");

        // 调用业务层方法
        UserService userService = new UserServiceImpl();
        User loginUser = userService.queryByUserNameAndUserPwd(new User(userName, userPwd));

        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        if(loginUser != null){
            entity.setReturnCode(CodeAndMsg.LOGIN_SUCCESS.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.LOGIN_SUCCESS.getReturnMsg());

            // 向session对象上绑定登录用户的权限菜单数据(便于主界面侧栏数据呈现)
            MenuService menuService = new MenuServiceImpl();
            List<Menu> menuList = menuService.queryLoginMenuList(loginUser.getUserId());
            HttpSession session = req.getSession();
            System.out.println("LoginController.sessionId=" + session.getId());
            session.setAttribute("menuList",menuList);
        }else{
            entity.setReturnCode(CodeAndMsg.LOGIN_FAILURED.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.LOGIN_FAILURED.getReturnMsg());
        }

        // 写出响应数据
        RespUtils.handleResp(resp,entity);

    }

}
