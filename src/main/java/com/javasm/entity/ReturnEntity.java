package com.javasm.entity;

import lombok.*;

/**
 * @author:
 * @className: ReturnEntity
 * @description: 响应数据(状态码、描述信息、核心数据)
 * @date: 2023/6/8 14:50
 * @since: 11
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ReturnEntity {
    // 状态码
    private Integer returnCode;
    // 描述信息
    private String returnMsg;
    // 核心数据
    private Object returnData;

}
