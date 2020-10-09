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

        for(int i = 0; i<5 ; i++){
            tf.tanks.add(new Tank(50 + i*80,200, Dir.DOWN,tf));
        }

        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
