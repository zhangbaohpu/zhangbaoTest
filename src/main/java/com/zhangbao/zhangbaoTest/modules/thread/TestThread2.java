package com.zhangbao.zhangbaoTest.modules.thread;

/**
 * @author zhangbao
 * @date 2020/12/27 11:57
 **/
public class TestThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("我再看代码--"+i);
        }
    }


    public static void main(String[] args) {

        TestThread2 t1 = new TestThread2();

        new Thread(t1).start();


        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程--"+i);
        }
    }
}
