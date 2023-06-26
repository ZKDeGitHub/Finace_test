package com.javasm.controller;

import com.javasm.entity.CodeAndMsg;
import com.javasm.entity.ReturnEntity;
import com.javasm.entity.User;
import com.javasm.service.UserService;
import com.javasm.service.impl.UserServiceImpl;
import com.javasm.util.CORSUtils;
import com.javasm.util.RespUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
        }else{
            entity.setReturnCode(CodeAndMsg.LOGIN_FAILURED.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.LOGIN_FAILURED.getReturnMsg());
        }

        // 写出响应数据
        RespUtils.handleResp(resp,entity);

    }

}
