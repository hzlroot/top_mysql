package com.hzl.qqclient.service;


import com.hzl.qqclient.thread.ClientConnectServerThread;

import java.util.HashMap;

/**
 * 管理客户端所有连接到服务端的线程
 */
public class ManageClientConnectServiceThread {

    //我们把多个线程放入到一个hashMap集合中，key就是用户id
    private static HashMap<String , Thread> map = new HashMap<>();

    //将某个线程加入到集合中
    public static void addThread(String userId,Thread clientConnectServerThread){
        map.put(userId,clientConnectServerThread);
    }

    //通过userId,可以得到对应的线程
    public static Thread getThread(String userId){
      return   map.get(userId);
    }
}
