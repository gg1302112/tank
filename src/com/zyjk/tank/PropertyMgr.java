package com.zyjk.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: lzw
 * @Date: 2020/10/11 - 10 - 11 - 14:17
 * @Description: com.zyjk.tank
 * @version: 1.0
 */
public class PropertyMgr {
    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
        if (props==null){
            return null;
        }
        return props.get(key);
    }
}
