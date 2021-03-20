package com.zhangbao.zhangbaoTest.modules.singleton;

/**
 * 懒汉式（单线程）
 * 当你需要的时候在实例化
 * @author zhangbao
 * @date 2021/2/15 19:04
 **/
public class LazySingleton {

    private static LazySingleton instance = null;

    public LazySingleton() {
    }
    public static LazySingleton getInstance() {
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
