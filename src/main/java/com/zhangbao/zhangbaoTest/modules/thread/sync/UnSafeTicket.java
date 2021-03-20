package com.zhangbao.zhangbaoTest.modules.thread.sync;

/**
 * @author zhangbao
 * @date 2020/12/27 15:40
 **/
public class UnSafeTicket {
    public static void main(String[] args) {
        BuyTicket ticket = new BuyTicket();

        new Thread(ticket,"张三").start();
        new Thread(ticket,"李四").start();
        new Thread(ticket,"黄牛").start();
    }
}

class BuyTicket implements Runnable{
    private int ticketNums = 10;
    private Boolean flag = true;

    @Override
    public void run() {
        while (flag){
            buy();
        }
    }

    private void buy() {
        if(this.ticketNums<=0){
            flag = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"买到了"+ticketNums--);
    }


}
