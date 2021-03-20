package com.zhangbao.zhangbaoTest.modules.singleton;

/**
 * 懒汉式（线程安全，高效率，双重验证）
 *
 * volatile：可见性。指在一个线程中对该变量的修改会马上由工作内存（Work Memory）写回主内存（Main Memory），所以会马上反应在其它线程的读取操作中。
 * 禁止指令重排
 * @author zhangbao
 * @date 2021/2/15 19:11
 **/
public class LazySingletonThread {
    private static volatile LazySingletonThread instance = null;

    public LazySingletonThread() {
    }
    public LazySingletonThread getInstance(){
        if(instance == null){
            synchronized (LazySingletonThread.class){
                if(instance == null){
                    instance = new LazySingletonThread();
                }
            }
        }
        return instance;
    }
}
