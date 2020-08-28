package com.xiaoyibo.tokendemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created on 2020/8/3.
 * time: 11:21
 *
 * @author yibo.xiao
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppInfo {

    private String appId;

    private String key;
}
