package Obj;

import Windows.GameWindows;

import java.awt.*;

public class ArmyObj extends GameObj{


    public ArmyObj(Image Img, int x, int y, int height, int weight, double speed, GameWindows gameWindows) {
        super(Img, x, y, height, weight, speed, gameWindows);
    }
    public void paint(Graphics g)
    {
        g.drawImage(Img,x,y,null);
        y+=speed;
    }
}
