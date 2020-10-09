package test;

import com.sun.xml.internal.ws.api.server.AbstractServerAsyncTransport;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Auther: lzw
 * @Date: 2020/10/9 - 10 - 09 - 21:39
 * @Description: Test
 * @version: 1.0
 */
public class ImageTest {

    @Test
    public void test(){
        try {

            BufferedImage image = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            System.out.println(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
