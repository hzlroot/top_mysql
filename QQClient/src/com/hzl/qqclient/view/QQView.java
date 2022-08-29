package com.hzl.qqclient.view;

import com.hzl.qqclient.utils.Utility;

/**
 * 模拟客户端菜单页面
 */

public class QQView {

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("客户端退出登录.....");
    }


    private boolean flag = true;//控制是否显示菜单
    private String key = "";//接收用户的键盘输入

    //显示主菜单
    public void mainMenu(){

        while (flag){
            System.out.println("====================欢迎登录网络通讯系统=========================");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择： ");

            key = Utility.readString(1);

            //根据用户的输入来处理不同的逻辑
            switch (key){
                case "1":
                    System.out.print("请输入用户号： ");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密 码：  ");
                    String pwd = Utility.readString(50);
                    //需要去服务端验证该用户是否合法
                    if(true){
                        System.out.println("========================欢迎用户 " +(userId) +"==================================");
                        //进入到二级菜单
                        while (flag){
                            System.out.println("\n=====================================网络通讯系统二级菜单"+(userId) +"========================================");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择： ");

                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    System.out.println("显示在线用户列表");
                                    break;
                                case "2":
                                    System.out.println("群发消息");
                                    break;
                                case "3":
                                    System.out.println("私聊消息");
                                    break;
                                case "4":
                                    System.out.println("发送文件");
                                    break;
                                case "9":
                                    flag = false;
                                    break;
                            }

                        }
                    }else{
                        System.out.println("====================登录失败，请输入正确的用户名或者密码======================");
                    }
                    break;
                case "9":
                    flag = false;
                    break;
            }
        }
    }


}
