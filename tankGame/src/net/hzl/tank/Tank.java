package net.hzl.tank;

public class Tank {

    private int x;//横坐标
    private int y;//纵坐标
    private int direct;//方向
    private int type;//类型
    private int speed = 2;//速度

    //坦克上下左右移动，坦克的移动实际上就是更改坐标
    public void moveUP(){
        y-=speed;
    }

    public void moveDown(){
        y+=speed;
    }

    public void moveLeft(){
        x-=speed;
    }

    public void moveRight(){
        x+=speed;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
