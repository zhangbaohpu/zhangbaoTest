package com.zhangbao.zhangbaoTest.modules.socket;

import cn.hutool.json.JSONObject;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zhangbao
 * @date 2021/2/18 11:35
 **/
public class ClientSend implements Runnable{
    private Socket socket;
    private ObjectOutputStream oos;
    public ClientSend(Socket socket,ObjectOutputStream oos) {
        this.socket = socket;
        this.oos = oos;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("Client 发送信息:");
                String nextLine = scanner.nextLine();
                JSONObject jsonObject = new JSONObject();
                jsonObject.putOpt("type","chat");
                jsonObject.putOpt("msg",nextLine);
                oos.writeObject(jsonObject);
                oos.flush();
            }
        } catch (IOException e) {
            try {
                socket.close();
                Client.connected = false;
                Client.reConnect();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
