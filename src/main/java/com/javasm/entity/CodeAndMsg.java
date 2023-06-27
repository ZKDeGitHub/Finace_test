package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author:
 * @className: CodeAndMsg
 * @description: 状态码和描述信息建立绑定关系
 * @date: 2023/6/8 15:19
 * @since: 11
 */
@AllArgsConstructor
@Getter
public enum CodeAndMsg {
    LOGIN_SUCCESS(2000, "登录成功"),
    LOGIN_FAILURED(4000, "登录失败"),
    SUCCESS_QUERY(2001, "成功查询到数据"),
    FAILURED_QUERY(4001, "没有查询到数据"),
    NO_LOGIN(4005, "没有登录");

    private Integer returnCode;
    private String returnMsg;


}
