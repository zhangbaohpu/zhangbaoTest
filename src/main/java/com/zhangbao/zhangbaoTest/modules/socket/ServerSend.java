package com.zhangbao.zhangbaoTest.modules.socket;

import cn.hutool.json.JSONObject;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zhangbao
 * @date 2021/2/18 11:13
 **/
public class ServerSend implements Runnable{
    private Socket socket;

    public ServerSend(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("请输入要发送的信息：");
                String nextLine = scanner.nextLine();
                JSONObject jsonObject = new JSONObject();
                jsonObject.putOpt("type","chat");
                jsonObject.putOpt("msg",nextLine);
                oos.writeObject(jsonObject);
                oos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
