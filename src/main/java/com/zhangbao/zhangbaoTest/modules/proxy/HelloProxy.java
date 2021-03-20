package com.zhangbao.zhangbaoTest.modules.proxy;

/**
 * 静态代理
 * @author zhangbao
 * @date 2021/2/15 11:53
 **/
public class HelloProxy implements HelloService {
    HelloService hello = new HelloServiceImpl();
    @Override
    public void sayHello() {
        System.out.println("Before invoke ");
        hello.sayHello();
        System.out.println("After invoke ");
    }

    public static void main(String[] args) {
        HelloProxy helloProxy = new HelloProxy();
        helloProxy.sayHello();
    }

}
