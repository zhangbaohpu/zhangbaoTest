package com.zhangbao.zhangbaoTest.modules.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author zhangbao
 * @date 2021/2/18 11:27
 **/
public class Client {
    private static Socket socket;
    public static boolean connected = false;
    public static void main(String[] args) {
        while (!connected){
            connect();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void connect(){
        try {
            socket = new Socket("localhost",9999);
            connected = true;
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //监听接收信息线程
            new Thread(new ClientListener(socket,ois)).start();
            //发送信息线程
            new Thread(new ClientSend(socket,oos)).start();
            //心跳线程
            new Thread(new ClientHeart(socket,oos)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reConnect(){
        try {
            while (!connected){
                System.out.println("正在尝试重新连接...");
                connect();
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
