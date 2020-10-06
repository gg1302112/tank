package com.zyjk.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: lzw
 * @Date: 20/10/6 - 10 - 06 - 14:42
 * @Description: com.zyjk.tank
 * @version: 1.0
 */
public class TankFrame extends Frame {
    int x = 200;
    int y = 200;

    public TankFrame(){
        setSize(800,600);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(x,y,50,50);
//        x+=10;
//        y+=10;

    }

    class MyKeyListener extends KeyAdapter{
        boolean bL = false;
        boolean bU = false;
        boolean bD = false;
        boolean bR = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:bL=true;break;
                case KeyEvent.VK_UP:bU=true;break;
                case KeyEvent.VK_DOWN:bD=true;break;
                case KeyEvent.VK_RIGHT:bR=true;break;
                default:break;
            }
//            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:bL=false;break;
                case KeyEvent.VK_UP:bU=false;break;
                case KeyEvent.VK_DOWN:bD=false;break;
                case KeyEvent.VK_RIGHT:bR=false;break;
                default:break;
            }
        }
    }
}
