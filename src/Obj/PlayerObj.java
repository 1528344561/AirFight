package Obj;

import Windows.GameWindows;

import java.awt.*;
import java.awt.image.ImageObserver;

public class PlayerObj extends GameObj{


    public PlayerObj(Image Img, int x, int y, int height, int weight, double speed, GameWindows gameWindows) {

        super(Img, x, y, height, weight, speed, gameWindows);
    }

    @Override
    public void paint(Graphics g)
    {
        g.drawImage(Img,x,y,null);
    }
    public void move(int x,int y)
    {
        this.x=x-weight/2;
        this.y=y-height/2;
    }
}
