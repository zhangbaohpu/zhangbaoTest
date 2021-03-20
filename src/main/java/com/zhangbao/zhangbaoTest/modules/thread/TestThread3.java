package com.zhangbao.zhangbaoTest.modules.thread;

/**
 * 模拟抢票
 * 多个资源访问一个资源
 *
 * 多线程问题：多个线程操作一个资源，线程不安全，数据紊乱
 * @author zhangbao
 * @date 2020/12/27 12:09
 **/
public class TestThread3 implements Runnable {
    private volatile int ticketNums = 10;
    @Override
    public void run() {
        while (true){
            if(ticketNums <=0){
                break;
            }
            try {
                //模拟延时
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+"-->抢到了第 " + ticketNums--+ "票");
        }
    }

    public static void main(String[] args) {
        TestThread3 ticket = new TestThread3();

        new Thread(ticket,"张三").start();
        new Thread(ticket,"李四").start();
        new Thread(ticket,"黄牛").start();
    }

}
