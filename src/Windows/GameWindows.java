package Windows;

import GameUtils.GameUtils;
import Obj.BackGroundObj;
import Obj.GameObj;
import Obj.PlayerObj;
import Obj.Shell.ShellObj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameWindows extends JFrame {
    public enum GameState{
        Waiting,Gaming;
    }
    public GameState gameState = GameState.Waiting;//游戏状态:0 未开始 , 1 游戏中
    public BackGroundObj backGround = new BackGroundObj(GameUtils.backGround,-200,-3240,1080,3840,2,this);
    public BackGroundObj backGround2 = new BackGroundObj(GameUtils.backGround,-200,-7080,1080,3840,2,this);
    public PlayerObj playerObj = new PlayerObj(GameUtils.ArmyImage,0,0,200,150,2,this);
    public ShellObj shellObj = new ShellObj(GameUtils.ShellImage,playerObj.getX()+playerObj.getHeight()/2,playerObj.getY()-15,28,28,5,this);
    public Image ImageScreen = null;

    public static ArrayList<GameObj> gameObjList= new ArrayList<GameObj>();//记录游戏中所有物体的对象
    public static ArrayList<GameObj> gameShellList= new ArrayList<GameObj>();
    int color_cnt=0;
    public Color color = Color.blue;
    public JButton choosePlayerLeft =new JButton();
    public JButton choosePlayerRight = new JButton();
    public void InitButton()
    {
        choosePlayerLeft = new JButton("上一个");
        choosePlayerRight = new JButton("下一个");
//        choosePlayerLeft.setText("上一个");
//        choosePlayerLeft.setVisible(true);
//        choosePlayerLeft.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        choosePlayerRight.setText("下一个");
//        choosePlayerRight.setVisible(true);
//
//        choosePlayerLeft.setLayout(null);
//        choosePlayerRight.setLayout(null);
//
//        choosePlayerLeft.setBounds(5,5,10,10);
//        choosePlayerRight.setBounds(10,5,10,10);
    }
    public void launch()
    {
        //JFrame MainWindow = new JFrame();
        InitButton();
        //this.setLayout(null);
        JPanel jPanel = new JPanel();
        //jPanel.setLayout(null);
        jPanel.add(choosePlayerLeft,BorderLayout.EAST);
        jPanel.add(choosePlayerRight,BorderLayout.WEST);


        this.setSize(600,600);
        //this.setLocationRelativeTo(null);//窗口位置居中
        this.setTitle("Java");
        this.setLocation(300,300);
        this.add(jPanel,BorderLayout.SOUTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jPanel.setVisible(true);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton()== 1 && gameState == GameState.Waiting)//getButton 返回1说明单击的是左键
                {
                    gameState = GameState.Gaming;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                playerObj.move(e.getX(),e.getY());
            }
        });
        while(true)
        {
            if(gameState==GameState.Gaming)createObj();
            repaint();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    @Override
    public void paint(Graphics g)
    {
        //g就相当于一根画笔,可以画Image图片,可以写字,可以画图形....
        //
        if(ImageScreen == null)//创建一块画布.双缓存
            ImageScreen = createImage(this.getHeight(),this.getWidth());

        Graphics gImage = ImageScreen.getGraphics();
        gImage.fillRect(0,0,ImageScreen.getHeight(null),ImageScreen.getWidth(null));
        //Color color =getRandomColor();

        Font font =new Font("微软雅黑",Font.BOLD,20);//新建一个字体,类型微软雅黑,加粗,大小为20
        if(gameState==GameState.Waiting)
        {

            gImage.drawImage(GameUtils.backGround,-200,-3240,null);//绘制背景图片..
            //写字
            color_cnt++;
            if(color_cnt%50==0)
            {
                color=getRandomColor();
                color_cnt=0;
            }
            gImage.setColor(color);
            gImage.drawImage(GameUtils.boosImage,210,50,null);
            gImage.setFont(font);
            gImage.drawString("开始游戏",getHeight()/2-50,getWidth()/2+110);

//            choosePlayerLeft.setVisible(true);
//            choosePlayerLeft.paint(gImage);
//            choosePlayerRight.paint(gImage);
        }
        else if(gameState==GameState.Gaming)
        {

            backGround.paint(gImage);
            backGround2.paint(gImage);
            playerObj.paint(gImage);
            //shellObj.paint(gImage);
            for(int i=0;i<gameShellList.size();i++)
            {
                if(gameShellList.get(i).getY()<0)
                {
                    gameShellList.remove(i);
                    i--;
                }
                else
                    gameShellList.get(i).paint(gImage);
            }
            gImage.setColor(Color.GREEN);
            gImage.setFont(font);
            gImage.drawString("游戏开始了.",200,300);
        }
        //把画布ImageScreen上的内容输出.
        g.drawImage(ImageScreen,0,0,null);
        //g.drawImage(GameUtils.testImage,0,0,null);
    }

    private Color getRandomColor()
    {
        int r=(int)(Math.random()*1000)%256;
        int g=(int)(Math.random()*1000)%256;
        int b=(int)(Math.random()*1000)%256;
        return new Color(r,g,b);
    }

    int shell_cnt=0;
    public void createObj()
    {
        shell_cnt++;
        if(shell_cnt%15==0)
        {
            shell_cnt=0;
            gameShellList.add(new ShellObj(GameUtils.ShellImage,playerObj.getX()+playerObj.getHeight()/2-18,playerObj.getY()+68,28,28,5,this));
        }
    }
    public static void main(String [] args)
    {
        GameWindows gameWindows = new GameWindows();
        gameWindows.launch();
    }
}
