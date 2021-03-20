package com.zhangbao.zhangbaoTest.modules.thread;

/**
 * 模拟龟兔赛跑
 * @author zhangbao
 * @date 2020/12/27 12:24
 **/
public class TestRace implements Runnable {

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //模拟兔子休息
            if(Thread.currentThread().getName().equals("兔子") && i%10==0 ){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean winner = getWinner(i);
            if(winner){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--> 跑了"+i+"步");
        }
    }

    //是否完成比赛
    public boolean getWinner(int steps){
        if(winner != null){
            return true;
        }else if(steps==100) {
            winner = Thread.currentThread().getName();
            System.out.println("winner is "+ winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TestRace race = new TestRace();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }

}
