package com.xiaoyibo.proxy.jdkproxy;

/**
 * created on 2020/8/28.
 * time: 12:00
 *
 * @author yibo.xiao
 */


public class UserService implements IUserService {

    @Override
    public void insert(String name) {
        System.out.println("1212");
    }
}
