package com.ird.portal.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 图片工具类
 */
public class ImageUtil {

    /**
     * 壓縮圖片
     * @param imgByte 文件流
     * @param scale 壓縮比例
     */
    public static byte[] compressImage(byte[] imgByte, float scale){
        try {
            ByteArrayInputStream byteInput = new ByteArrayInputStream(imgByte);
            BufferedImage templateImage = ImageIO.read(byteInput);


            //原始图片的长度和宽度
            int height = templateImage.getHeight();
            int width = templateImage.getWidth();

            //通过比例压缩

            //通过固定长度压缩
            /*int doWithHeight = 100;
            int dowithWidth = 300;*/

            //压缩之后的长度和宽度
            int doWithHeight = (int) (scale * height);
            int dowithWidth = (int) (scale * width);

            BufferedImage finalImage = new BufferedImage(dowithWidth, doWithHeight, BufferedImage.TYPE_INT_RGB);

            finalImage.getGraphics().drawImage(templateImage.getScaledInstance(dowithWidth, doWithHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);

            //图片输出路径，以及图片名
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(finalImage, "jpg", out);
            return out.toByteArray();

            /*
            FileOutputStream  fileOutputStream = new FileOutputStream(filePath);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fileOutputStream);
            encoder.encode(finalImage);
            fileOutputStream.close();
            */
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}