package com.zhangbao.zhangbaoTest.modules.proxy;

/**
 * @author zhangbao
 * @date 2021/2/15 11:52
 **/
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("Hello zhangbao");
    }
}
