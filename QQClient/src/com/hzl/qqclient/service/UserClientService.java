package com.hzl.qqclient.service;

import com.hzl.qqclient.thread.ClientConnectServerThread;
import com.hzl.qqcommon.Message;
import com.hzl.qqcommon.MessageType;
import com.hzl.qqcommon.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 用户登录验证和用户注册等
 */
public class UserClientService {

    //因为可能在其他地方使用user信息，因此做成成员属性
    private User u  = new User();

    //因为可能在其他地方使用user信息，因此做成成员属性
    private Socket socket;


    //验证user对象是否合法
    public boolean checkUser(String userId,String pwd){

        boolean flag = false;
        //创建user对象
        u.setUserId(userId);
        u.setPassword(pwd);

        try {
            //连接到服务端，发送user对象
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);
            //得到ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);//发送user对象

            //读取服务端返回的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message)ois.readObject();
            if(message.getMsgType().equals(MessageType.MESSAGE_LOGIN_SUCCESS)){//登录成功



                //创建一个和服务端保持通信的线程
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                Thread thread = new Thread(clientConnectServerThread);
                //启动客户端的线程
                thread.start();
                //为了更好的管理客户端的所有线程，创建一个集合综合管理
                ManageClientConnectServiceThread.addThread(userId,thread);
                flag = true;

            }
            if(message.getMsgType().equals(MessageType.MESSAGE_LOGIN_FAIL)){//登录失败
                //如果登录失败，那么就无法创建客户端连接到服务端的线程，关闭socket
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
}