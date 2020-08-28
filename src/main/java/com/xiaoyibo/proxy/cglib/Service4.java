package com.xiaoyibo.proxy.cglib;

/**
 * created on 2020/8/28.
 * time: 14:50
 *
 * @author yibo.xiao
 */


public class Service4 {
    public void insert1(){
        System.out.println("我是insert1");
    }

    public void insert2(){
        System.out.println("我是insert2");
    }


    public String get1(){
        System.out.println("我是get1方法");
        return "get1";
    }
    public String get2(){
        System.out.println("我是get2方法");
        return "get2";
    }

}
