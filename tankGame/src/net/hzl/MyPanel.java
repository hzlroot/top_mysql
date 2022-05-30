package net.hzl;

import net.hzl.tank.EnemyTank;
import net.hzl.tank.MyTank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener {

    MyTank myTank = null;

    //敌人坦克的集合
    Vector<EnemyTank> enemyTanks =  new Vector<EnemyTank>();

    //初始化敌人坦克的数量
    int enemyTankSize = 8;

    public MyPanel(){

        //初始化我的坦克
         myTank = new MyTank(100, 100);

        //初始化敌人的坦克
        for(int i = 0; i < enemyTankSize; i++){
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }

    }



    //绘图
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//绘制填充矩形，默认是黑色

        //绘制我的坦克
        drawTank(myTank.getX(),myTank.getY(),g,0,myTank.getDirect());

        //绘制敌人的坦克
        for(int i = 0; i < enemyTanks.size(); i++){
            //取出敌人坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,1,enemyTank.getDirect());
        }
    }



    //绘制坦克
    public void drawTank(int x,int y,Graphics g,int type,int direct){

        //根据坦克的类型，设置坦克的颜色
        switch (type){
            case 0://我的坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌人的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克的方向绘制坦克
        switch (direct){
            case 0: //向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1://向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case 2://向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case 3://向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;

        }
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    //java事件机制
    @Override
    public void keyPressed(KeyEvent keyEvent) {

        if(keyEvent.getKeyCode() == KeyEvent.VK_UP){
            //向上
            myTank.setDirect(0);
            myTank.moveUP();
        }else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT){
            //向右
            myTank.setDirect(1);
            myTank.moveRight();
        }else if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN){
            //向下
            myTank.setDirect(2);
            myTank.moveDown();
        }else {
            //向左
            myTank.setDirect(3);
            myTank.moveLeft();
        }

        //面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }


}
