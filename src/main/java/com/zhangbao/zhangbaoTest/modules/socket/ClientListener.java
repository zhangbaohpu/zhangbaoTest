package com.zhangbao.zhangbaoTest.modules.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author zhangbao
 * @date 2021/2/18 11:32
 **/
public class ClientListener implements Runnable {
    private Socket socket;
    private ObjectInputStream ois;
    public ClientListener(Socket socket,ObjectInputStream ois) {
        this.socket = socket;
        this.ois = ois;
    }

    @Override
    public void run() {
        try {
            while (true){
                Object obj = ois.readObject();
                System.out.println(obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
