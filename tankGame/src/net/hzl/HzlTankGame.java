package net.hzl;

import javax.swing.*;
@SuppressWarnings({"all"})
public class HzlTankGame extends JFrame {

    MyPanel myPanel = null;//定义面板

    public  HzlTankGame(){
        myPanel = new MyPanel();
        this.add(myPanel);//将面板放入面框中
        this.addKeyListener(myPanel);//将事件监听器放入面框
        this.setSize(1000,750);//设置面框大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//设置可视化
    }


    public static void main(String[] args) {
        HzlTankGame hzlTankGame = new HzlTankGame();
    }
}
