package com.zyjk.tank;

import java.awt.*;

/**
 * @Auther: lzw
 * @Date: 20/10/7 - 10 - 07 - 17:00
 * @Description: com.zyjk.tank
 * @version: 1.0
 */
public class Bullet {
    private int x,y;
    private Dir dir;
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private static final int SPEED = 10;
    private boolean living = true;
    TankFrame tf = null;



    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g){
        if(!living) tf.bullets.remove(this);
        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(color);
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        if (x<0 || x>tf.getGameWidth() || y<0 || y>tf.getGameHeight()) living=false;
    }


}
