package com.hzl.qqclient.thread;

import com.hzl.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread implements Runnable{

    //该线程需要持有Socket
    private Socket socket;

    public ClientConnectServerThread() {
    }

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    //为了方便的获取到Socket
    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        //因为线程需要在后台和服务器一直通信，因此我们while循环
        while(true){

            try {
                System.out.println("客户端线程等待读取从服务器端发送的消息......");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送Message对象，那么线程就会阻塞在这里
                Message message = (Message)ois.readObject();


            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }

}
