package com.xiaoyibo.tokendemo;

import com.xiaoyibo.proxy.jdkproxy.CostTimeInvocationHandler;
import com.xiaoyibo.proxy.jdkproxy.IServcie;
import com.xiaoyibo.proxy.jdkproxy.IUserService;
import com.xiaoyibo.proxy.jdkproxy.UserService;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * created on 2020/8/28.
 * time: 11:07
 *
 * @author yibo.xiao
 */

@SpringJUnitConfig
public class Test {

    @org.junit.jupiter.api.Test
    public void m1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> proxyClass = Proxy.getProxyClass(IServcie.class.getClassLoader(), IServcie.class);
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("我是invocationHandler 被调用的方法是:" + method.getName());
                return null;
            }
        };
        Object o = proxyClass.getConstructor(InvocationHandler.class).newInstance(invocationHandler);

    }


    @org.junit.jupiter.api.Test
    public void m2(){
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("我是invocationHandler 被调用的方法是:" + method.getName());
                return null;
            }
        };
        IServcie servcie = (IServcie) Proxy.newProxyInstance(IServcie.class.getClassLoader(), new Class[]{IServcie.class}, invocationHandler);
        servcie.m1();
        servcie.m2();
        servcie.m3();

    }

    @org.junit.jupiter.api.Test
    public void userService(){
        IUserService proxy = CostTimeInvocationHandler.createProxy(new UserService(), IUserService.class);
        proxy.insert("11");
    }
}
