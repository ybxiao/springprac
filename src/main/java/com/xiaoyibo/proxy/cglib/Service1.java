package com.xiaoyibo.proxy.cglib;

/**
 * created on 2020/8/28.
 * time: 14:50
 *
 * @author yibo.xiao
 */


public class Service1 {
    public void m1(){
        System.out.println("我是m1方法");
        this.m2();
    }
    public void m2(){
        System.out.println("我是m2方法");
    }

}
