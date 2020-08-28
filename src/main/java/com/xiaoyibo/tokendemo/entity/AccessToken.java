package com.xiaoyibo.tokendemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * created on 2020/8/3.
 * time: 11:23
 *
 * @author yibo.xiao
 */

@Data
@AllArgsConstructor
public class AccessToken {
    /** token */
    private String token;

    /** 失效时间 */
    private Date expireTime;
}
