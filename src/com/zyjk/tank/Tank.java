package com.zyjk.tank;

import java.awt.*;

/**
 * @Auther: lzw
 * @Date: 20/10/7 - 10 - 07 - 15:54
 * @Description: com.zyjk.tank
 * @version: 1.0
 */
public class Tank {
    private int x,y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    private boolean moving = false;
    TankFrame tf = null;

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x,y,50,50);
        g.setColor(color);
        move();

        }

    private void move() {
        if (!moving){
            return;
        }
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
    }

    public void fire() {
        tf.bullets.add(new Bullet(x,y,dir,tf));
    }
}
