package com.zhangbao.zhangbaoTest.modules.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 通过Proxy类的静态方法newProxyInstance返回一个接口的代理实例。
 * 针对不同的代理类，传入相应的代理程序控制器InvocationHandler。
 * 被代理类必须至少实现一个接口
 * @author zhangbao
 * @date 2021/2/15 12:01
 **/
public class ProxyHandler implements InvocationHandler {
    private Object object;
    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "  + method.getName());
        method.invoke(object, args);
        System.out.println("After invoke " + method.getName());
        return null;
    }

    public static void main(String[] args) {
        //保存生成的代理类class文件，默认false不保存。
        // 将JDK动态代理生成的class文件保存到本地
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HelloService hello = new HelloServiceImpl();

        InvocationHandler handler = new ProxyHandler(hello);

        HelloService helloService = (HelloService) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
        helloService.sayHello();
    }

}
