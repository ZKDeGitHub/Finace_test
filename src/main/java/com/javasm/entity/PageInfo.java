package com.javasm.entity;

import lombok.*;

/**
 * @author:
 * @className: PageInfo
 * @description:
 * @date: 2023/6/15 15:58
 * @since: 11
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PageInfo {
    private Integer page;
    private Integer pageSize;
    private Integer total;
}
