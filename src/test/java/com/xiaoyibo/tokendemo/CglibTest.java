package com.xiaoyibo.tokendemo;

import com.xiaoyibo.proxy.cglib.Service1;
import com.xiaoyibo.proxy.cglib.Service3;
import com.xiaoyibo.proxy.cglib.Service4;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * created on 2020/8/28.
 * time: 14:49
 *
 * @author yibo.xiao
 */


public class CglibTest {

    @Test
    public void test1(){
        Enhancer enhancer =  new Enhancer();
        enhancer.setSuperclass(Service1.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("开始进行方法调用" + method);
                Object result = methodProxy.invokeSuper(o,objects);
                return result;
            }
        });

        Service1 proxy = (Service1)enhancer.create();

        proxy.m1();
        proxy.m2();


    }

    @Test
    public void test3(){

        Enhancer enhancer =  new Enhancer();
        enhancer.setSuperclass(Service3.class);

        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "XI YI BO ";
            }
        });
        Service3 proxy = (Service3)enhancer.create();
        System.out.println(proxy.m1());
        System.out.println(proxy.m2());
        System.out.println(proxy.toString());

    }

    @Test
    public void test4(){

        Enhancer enhancer =  new Enhancer();
        enhancer.setSuperclass(Service4.class);

        Callback[] callbacks =  {
            new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    long starTime = System.nanoTime();
                    Object result = methodProxy.invokeSuper(o, objects);
                    long endTime = System.nanoTime();
                    System.out.println(method + "，耗时(纳秒):" + (endTime - starTime));
                    return result;
                }
            },
                new FixedValue() {
                    @Override
                    public Object loadObject() throws Exception {
                        return "XIXX";
                    }
                }

        };
       /* enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                return 0;
            }
        });*/
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                String methodName = method.getName();
                return methodName.startsWith("insert") ? 0 :1;
            }
        });

        Service4 proxy = (Service4) enhancer.create();
        System.out.println("---------------");
        proxy.insert1();
        System.out.println("---------------");
        proxy.insert2();
        System.out.println("---------------");
        System.out.println(proxy.get1());
        System.out.println("---------------");
        System.out.println(proxy.get2());

    }


}
