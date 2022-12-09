package Obj;

import Windows.GameWindows;

import java.awt.*;

public class BackGroundObj extends GameObj{

    public BackGroundObj(Image Img, int x, int y, int height, int weight, double speed, GameWindows gameWindows) {
        super(Img, x, y, height, weight, speed, gameWindows);
    }

    public void paint(Graphics g)
    {
        //super.paint(g);
        y+=speed;
        if(y>=gameWindows.getHeight())
        {
            //speed=-speed;
            y= gameWindows.getHeight()-getWeight()*2;
        }
        g.drawImage(Img,x,y,null);
    }

}
