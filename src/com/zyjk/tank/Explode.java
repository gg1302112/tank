package com.zyjk.tank;

import javax.annotation.Resource;
import java.awt.*;

/**
 * @Auther: lzw
 * @Date: 20/10/7 - 10 - 07 - 17:00
 * @Description: com.zyjk.tank
 * @version: 1.0
 */
public class Explode {
    private int x,y;
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private boolean living = true;
    TankFrame tf = null;
    private int step = 0;



    public Explode(int x, int y,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if (step==16) step=0;
    }


}
