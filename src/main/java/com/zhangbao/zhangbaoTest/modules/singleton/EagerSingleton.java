package com.zhangbao.zhangbaoTest.modules.singleton;




/**
 * 饿汉式
 * 不管你用不用，我都给你提前准备好
 * @author zhangbao
 * @date 2021/2/15 18:58
 **/
public class EagerSingleton {

    private static EagerSingleton instance = new EagerSingleton();

    public EagerSingleton() {
    }
    public EagerSingleton getInstance(){
        return instance;
    }
}
