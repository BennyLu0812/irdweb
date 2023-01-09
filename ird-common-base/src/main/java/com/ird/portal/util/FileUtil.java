package com.ird.portal.util;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件相關處理工具類
 * @Author: kent long
 * @Date: 7/24/2018 12:12 PM
 */
public class FileUtil {
    // 黰认
    public static final int SCALE_DPI = 72;
    public static final int DPI300 = 300;
    public static final float ZOOM_UNIT = 1F;
    private static Logger LOG = LoggerFactory.getLogger(FileUtil.class);
    /**
     * @param inputStream
     */
    public static void write(OutputStream outputStream, InputStream inputStream) throws IOException {
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(b)) != -1) {
            outputStream.write(b, 0, len);
        }
    }

    public static boolean isFileExist(String fileName) {
        return new File(fileName).isFile();
    }

    public static byte[] inputStreamToBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        write(bos, inputStream);
        return bos.toByteArray();
    }


    /**
     * 将宽度相同的图片，竖向追加在一起 ##注意：宽度必须相同
     *
     * @param piclist
     *            文件流数组
     *            输出路径
     */
    public static byte[] combineImagesToBytes(List<BufferedImage> piclist) {// 纵向处理图片
        if (piclist == null || piclist.size() <= 0) {
            LOG.debug("需要合併的图片数组为空!");
            return null;
        }
        try {
            int height = 0; // 总高度
            int width = 0;// 总宽度
            int _height = 0; // 临时的高度 , 或保存偏移高度
            int __height = 0; // 临时的高度，主要保存每个高度
            int picNum = piclist.size();// 图片的数量
            int[] heightArray = new int[picNum]; // 保存每个文件的高度
            BufferedImage buffer = null; // 保存图片流
            List<int[]> imgRGB = new ArrayList<int[]>(); // 保存所有的图片的RGB
            int[] _imgRGB; // 保存一张图片中的RGB数据
            for (int i = 0; i < picNum; i++) {
                buffer = piclist.get(i);
                heightArray[i] = _height = buffer.getHeight();// 图片高度
                if (i == 0) {
                    width = buffer.getWidth();// 图片宽度
                }
                height += _height; // 获取总高度
                _imgRGB = new int[width * _height];// 从图片中读取RGB
                _imgRGB = buffer.getRGB(0, 0, width, _height, _imgRGB, 0, width);
                imgRGB.add(_imgRGB);
            }
            _height = 0; // 设置偏移高度为0
            // 生成新图片
            BufferedImage imageResult = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < picNum; i++) {
                __height = heightArray[i];
                if (i != 0) _height += __height; // 计算偏移高度
                imageResult.setRGB(0, _height, width, __height, imgRGB.get(i), 0, width); // 写入流中
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(imageResult,"jpg",baos);
            return baos.toByteArray();
//            File outFile = new File(outPath);
//            ImageIO.write(imageResult, "jpg", outFile);// 写图片
        } catch (Exception e) {
            LOG.error("combineImagesToBytes方法異常", e);
        }finally {

        }
        return null;
    }


}