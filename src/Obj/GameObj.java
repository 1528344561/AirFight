package Obj;

import Windows.GameWindows;

import java.awt.*;

public class GameObj {
    protected Image Img;
    protected int x,y;
    protected int height,weight;
    protected double speed;
    protected GameWindows gameWindows;
    public GameObj(Image Img,int x,int y,int height,int weight,double speed,GameWindows gameWindows)
    {
        this.Img=Img;
        this.x=x;
        this.y=y;
        this.height=height;
        this.weight=weight;
        this.speed=speed;
        this.gameWindows=gameWindows;
    }
    public Image getImg()
    {
        return Img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public double getSpeed() {
        return speed;
    }

    public void paint(Graphics g)//绘制物品自身
    {
        g.drawImage(Img,getX(),getY(),null);
    }
    public Rectangle getRectangle()//获取物品的矩形,用于碰撞检测等功能
    {
        return new Rectangle(getX(),getY(),getHeight(),getWeight());
    }

}
