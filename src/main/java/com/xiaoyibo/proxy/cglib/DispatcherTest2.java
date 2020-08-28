package com.xiaoyibo.proxy.cglib;

import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;

/**
 * created on 2020/8/28.
 * time: 16:00
 *
 * @author yibo.xiao
 */


public class DispatcherTest2 {


    public static class User{

        private String name;

        public User(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        /*User aClass = (User) User.class.newInstance();
        System.out.println(aClass);*/

        Objenesis objenesis = new ObjenesisStd();
        User user = objenesis.newInstance(User.class);
        System.out.println(user);
    }

}
