package com.zhangbao.zhangbaoTest.modules.socket;

import cn.hutool.json.JSONObject;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author zhangbao
 * @date 2021/2/18 14:02
 **/
public class ClientHeart implements Runnable{
    private Socket socket;
    private ObjectOutputStream oos;
    public ClientHeart(Socket socket,ObjectOutputStream oos) {
        this.socket = socket;
        this.oos = oos;
    }

    @Override
    public void run() {
        try {
            System.out.println("心跳包线程开始...");
            while (true){
                Thread.sleep(5000);
                JSONObject jsonObject = new JSONObject();
                jsonObject.putOpt("type","heart");
                jsonObject.putOpt("msg","心跳包");
                oos.writeObject(jsonObject);
                oos.flush();
            }
        } catch (Exception e) {
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
