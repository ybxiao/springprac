package com.xiaoyibo.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * created on 2020/8/28.
 * time: 11:17
 *
 * @author yibo.xiao
 */


public class CostTimeInvocationHandler implements InvocationHandler {

    private Object target;

    public CostTimeInvocationHandler(Object target){
        this.target =  target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime =  System.nanoTime();
        Object o = method.invoke(this.target,args);
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + method.getName() +"cost time :"+ (endTime - startTime));
        return o;
    }

    public static <T> T createProxy(Object target, Class<T> targetInterfaces)  {
        if (!targetInterfaces.isInterface()){
            throw new IllegalStateException("");
        }else if (!targetInterfaces.isAssignableFrom(target.getClass())){
            throw new IllegalStateException("target必须是targetInterface接口的实现类!");
        }
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new CostTimeInvocationHandler(target));

    }


}
