package com.zhangbao.zhangbaoTest.modules.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author zhangbao
 * @date 2021/2/18 11:09
 **/
public class ServerListener implements Runnable{
    private Socket socket;

    public ServerListener(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            while (true){
                System.out.println(ois.readObject());

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
