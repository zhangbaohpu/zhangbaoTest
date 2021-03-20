package com.zhangbao.zhangbaoTest.modules.multiThread;

import java.util.concurrent.*;

/**
 * @author zhangbao
 * @date 2021/2/7 15:55
 **/
public class Test2 {
    public static void main(String[] args) {
        //1.线程锁计数器
         CountDownLatch countLatch = new CountDownLatch(100);
        //2.创建线程池存放线程
        ThreadPoolExecutor executors = new ThreadPoolExecutor(50,150,
                60000, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        for (int i = 0; i < 100; i++) {
            TaskThread thread = new TaskThread(countLatch, i);
//            Thread thread1 = new Thread(new TaskThread(countLatch,i));
            //3.将任务添加到线程池
            executors.execute(thread);
        }
        //4.为了让所有任务(100个)执行完，在执行最后的总任务，所以需要让主线程等待子线程执行完之后再执行await
        try {
            countLatch.await();
            System.out.println("所有任务执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //5.关闭线程池
        executors.shutdown();
        //6.所有子任务执行完后的总任务
        System.out.println("需要子任务的总任务...");
    }
}

class TaskThread implements Runnable{
    private CountDownLatch downLatch;
    private int count;

    public TaskThread(CountDownLatch downLatch,int count) {
        this.downLatch = downLatch;
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println("我在干活了"+ count);
        //每执行完一个线程，数量减1
        downLatch.countDown();
    }
}