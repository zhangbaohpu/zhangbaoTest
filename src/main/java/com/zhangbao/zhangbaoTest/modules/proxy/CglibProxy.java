package com.zhangbao.zhangbaoTest.modules.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 动态代理
 * 代理类不能是最终类，不能被final修饰
 * 被代理类可以不用实现接口
 * @author zhangbao
 * @date 2021/2/15 17:00
 **/
public class CglibProxy implements MethodInterceptor {

    public Object createProxyObject(Object obj){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);

        Object proxyObj = enhancer.create();
        return proxyObj;

    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("++++++before " + methodProxy.getSuperName() + "++++++");
        System.out.println(method.getName());
        Object o1 = methodProxy.invokeSuper(o, args);
        System.out.println("++++++before " + methodProxy.getSuperName() + "++++++");
        return o1;
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();

        HelloService helloService = (HelloService) cglibProxy.createProxyObject(new HelloServiceImpl());
        helloService.sayHello();

    }

}
