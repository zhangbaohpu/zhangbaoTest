package com.zhangbao.zhangbaoTest.modules.thread;

/**
 * 监测线程状态
 * @author zhangbao
 * @date 2020/12/27 15:04
 **/
public class TestState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("执行完毕");
        });


        Thread.State state = thread.getState();
        System.out.println("启动前："+state);//NEW
        thread.start();

        state = thread.getState();
        System.out.println("启动后："+state);//RUNNABLE

        while (state!= Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();
            System.out.println("监测中："+state);
        }

        thread.start();//死亡后的线程不能再启动
    }

}
