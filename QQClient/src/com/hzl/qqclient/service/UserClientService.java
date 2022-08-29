package com.hzl.qqclient.service;

import com.hzl.qqcommon.User;

/**
 * 用户登录验证和用户注册等
 */
public class UserClientService {

    //因为可能在其他地方使用user信息，因此做成成员属性
    private User u  = new User();

    //验证user对象是否合法
    public boolean checkUser(String userId,String pwd){
        //创建user对象
        u.setUserId(userId);
        u.setPassword(pwd);
        //连接到服务端，发送u对象



    }
}