package Obj.Shell;

import Obj.GameObj;
import Windows.GameWindows;

import java.awt.*;

public class ShellObj extends GameObj {//子弹类

    public ShellObj(Image Img, int x, int y, int height, int weight, double speed, GameWindows gameWindows) {
        super(Img, x, y, height, weight, speed, gameWindows);
    }
    @Override
    public void paint(Graphics g)
    {
        g.drawImage(Img,x,y,null);
        y-=speed;
    }
}
