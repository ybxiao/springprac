package com.xiaoyibo.tokendemo.entity;

import lombok.Data;

/**
 * created on 2020/8/3.
 * time: 11:22
 *
 * @author yibo.xiao
 */

@Data
public class TokenInfo {

    private Integer tokenType;

    private AppInfo appInfo;

    private UserInfo userInfo;
}
