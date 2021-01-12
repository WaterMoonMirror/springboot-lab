package com.wondersgroup.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/1/12 11:05
 * @description:
 */
@Data
@Accessors(chain = true)
public class UserVO {
    private Integer id;
    private String username;
}
