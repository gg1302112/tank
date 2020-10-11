package com.zyjk.tank;

import java.awt.*;
import java.util.Random;

/**
 * @Auther: lzw
 * @Date: 20/10/7 - 10 - 07 - 15:54
 * @Description: com.zyjk.tank
 * @version: 1.0
 */
public class Tank {
    private int x,y;
    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();
    private Dir dir = Dir.DOWN;
    private Group group = Group.BAD;
    private Random random = new Random();
    private static final int SPEED = 5;
    private boolean moving = true;
    private boolean living = true;
    TankFrame tf = null;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir,Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!living) tf.tanks.remove(this);
        switch (dir){
            case DOWN:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankD:ResourceMgr.badTankD,x,y,null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankU:ResourceMgr.badTankU,x,y,null);
                break;
            case LEFT:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankL:ResourceMgr.badTankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankR:ResourceMgr.badTankR,x,y,null);
            default:
                break;
        }

        if (this.group == Group.BAD && random.nextInt(10)>8){
            fire();
        }
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
        if (this.group==Group.BAD&&random.nextInt(100)>95){
            randomDir();
        }
        boundsCheck();

    }

    private void boundsCheck() {
        if (x<0){
            x=2;
        }
        if (x>TankFrame.getGameWidth()- Tank.WIDTH-2){
            x = TankFrame.getGameWidth() - Tank.WIDTH-2;
        }
        if (y<28){
            y=28;
        }
        if (y>TankFrame.getGameHeight() - Tank.HEIGHT-2){
            y = TankFrame.getGameHeight()-Tank.HEIGHT-2;
        }
    }

    private void randomDir() {
        dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        int bX = x + this.WIDTH/2 - Bullet.WIDTH/2;
        int bY = y + this.HEIGHT/2 - Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bX,bY,dir,this.group,tf));
    }

    public void die() {
        this.living = false;
    }
}
