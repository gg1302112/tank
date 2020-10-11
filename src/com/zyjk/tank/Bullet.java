package com.zyjk.tank;

import org.w3c.dom.css.Rect;

import javax.annotation.Resource;
import java.awt.*;

/**
 * @Auther: lzw
 * @Date: 20/10/7 - 10 - 07 - 17:00
 * @Description: com.zyjk.tank
 * @version: 1.0
 */
public class Bullet {
    private int x,y;
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private Group group = Group.BAD;
    private Dir dir;
    private static final int SPEED = 10;
    private boolean living = true;
    TankFrame tf = null;
    Rectangle rect = new Rectangle();



    public Bullet(int x, int y, Dir dir,Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = x;
        rect.y = y;
        rect.height=HEIGHT;
        rect.width= WIDTH;
    }

    public void paint(Graphics g){
        if(!living) tf.bullets.remove(this);
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            default:
                break;
        }
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
        rect.x = x;
        rect.y = y;
        if (x<0 || x>tf.getGameWidth() || y<0 || y>tf.getGameHeight()) living=false;


    }


    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()){ return;}
//        Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
//        Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),tank.WIDTH,tank.HEIGHT);

        if (this.rect.intersects(tank.rect)){
            tank.die();
            this.die();
            int eX = tank.getX() + tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + tank.HEIGHT/2 - Explode.HEIGHT/2;
            tf.explodes.add(new Explode(eX,eY,tf));
        }

    }

    private void die() {
        this.living = false;
    }
}
