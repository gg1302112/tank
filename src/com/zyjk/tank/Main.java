package com.zyjk.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: lzw
 * @Date: 20/10/6 - 10 - 06 - 14:27
 * @Description: com.zyjk.tank
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
        for(int i = 0; i<initTankCount ; i++){
            tf.tanks.add(new Tank(50 + i*80,200, Dir.DOWN,Group.BAD,tf));
        }

        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
