package com.zhangbao.zhangbaoTest.modules.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhangbao
 * @date 2021/2/18 11:06
 **/
public class Server {
    public static void main(String[] args) {

        try {
            System.out.println("Socket服务器开始运行...");
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true){
                Socket accept = serverSocket.accept();
                new Thread(new ServerListener(accept)).start();
                new Thread(new ServerSend(accept)).start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
