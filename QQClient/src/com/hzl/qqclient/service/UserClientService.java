package com.hzl.qqclient.service;

import com.hzl.qqcommon.Message;
import com.hzl.qqcommon.MessageType;
import com.hzl.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 用户登录验证和用户注册等
 */
public class UserClientService {

    //因为可能在其他地方使用user信息，因此做成成员属性
    private User u  = new User();

    //因为可能在其他地方使用Socket信息，因此做成成员属性
    private Socket socket;

    //验证user对象是否合法
    public boolean checkUser(String userId,String pwd){
        //创建user对象
        u.setUserId(userId);
        u.setPassword(pwd);

        try {
            //连接到服务端，发送u对象
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            //得到ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);//发送user对象

            //读取从服务端返回的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message)ois.readObject();
            if(message.getMsgType().equals(MessageType.MESSAGE_LOGIN_SUCCESS)){


            }

            if(message.getMsgType().equals(MessageType.MESSAGE_LOGIN_FAIL)){


            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
