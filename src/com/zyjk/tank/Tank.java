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
    private static final int SPEED = 10;

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x,y,50,50);
        switch (dir){
            case LEFT:
                x-=10;
                break;
            case UP:
                y-=10;
                break;
            case RIGHT:
                x+=10;
                break;
            case DOWN:
                y+=10;
                break;
        }

    }
}
