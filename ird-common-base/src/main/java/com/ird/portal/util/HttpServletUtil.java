package com.ird.portal.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * The type Http servlet util.
 * @author AugusChen
 */
public final class HttpServletUtil {

    private final static Logger logger = LoggerFactory.getLogger(HttpServletUtil.class);

    /**
     * 為瀏覽器下載用.
     *
     * @param response res
     * @param request  req
     * @param fileName fileName
     * @return OutPutStream output stream
     */
    public static OutputStream getOutputStreamByExcel(HttpServletResponse response, HttpServletRequest request, String fileName) {
        String fileName1 = fileName + ".xlsx";
        return getDownloadOutputStream(response, request, fileName1, "application/vnd.ms-excel");
    }

    /**
     * word
     * @param response res
     * @param request  req
     * @param fileName fileName
     * @return OutPutStream output stream
     */
    public static OutputStream getOutputStreamByWord(HttpServletResponse response, HttpServletRequest request, String fileName) {
        String fileName1 = fileName + ".docx";
        return getDownloadOutputStream(response, request, fileName1, "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
    }



    /**
     * pdf
     * @param response res
     * @param request  req
     * @param fileName fileName
     * @return OutPutStream output stream
     */
    public static OutputStream getOutputStreamByPdf(HttpServletResponse response, HttpServletRequest request, String fileName) {
        String fileName1 = fileName + ".pdf";
        return getDownloadOutputStream(response, request, fileName1, "application/pdf");
    }



    /**
     * Gets output stream by file.
     *
     * @param response the response
     * @param request  the request
     * @param fileName the file name
     * @return the output stream by file
     */
    public static OutputStream getOutputStreamByFile(HttpServletResponse response, HttpServletRequest request, String fileName) {
        return getDownloadOutputStream(response, request, fileName, "application/octet-stream");
    }

    /**
     * Gets output stream by file.
     *
     * @param response the response
     * @param fileName the file name
     * @return the output stream by file
     */
    public static OutputStream getOutputStreamByFile(HttpServletResponse response, String fileName) {
        return getDownloadOutputStream(response, null, fileName, "application/octet-stream");
    }

    /**
     * Gets download output stream.
     *
     * @param response the response
     * @param request  the request
     * @param fileName the file name
     * @param fileType the file type
     * @return the download output stream
     */
    public static OutputStream getDownloadOutputStream(HttpServletResponse response, HttpServletRequest request, String fileName, String fileType) {
        try {
            //ID和其他瀏覽器中文亂碼問題，判斷是否是ie
            String userAgent = request == null ? "" : request.getHeader("user-agent").toLowerCase();
            if (userAgent.contains("msie") || userAgent.contains("like gecko")) {
                // win10 ie edge 浏览器 和其他系统的ie
                fileName = URLEncoder.encode(fileName, "UTF-8");
            } else {
                // fe
                fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            }
            response.addHeader("fileName", fileName);
            response.setHeader("Access-Control-Expose-Headers", "fileName");
            response.setHeader("Content-Disposition", String.format("inline;filename=%s", fileName));
            response.setHeader("Content-Type", String.format("%s;charset=UTF-8", fileType));

            return response.getOutputStream();
        } catch (UnsupportedEncodingException e) {
            logger.error("url encoder error: {}", e.toString());
        } catch (IOException e) {
            logger.error("url encoder error: {}", e.toString());
        }
        return null;
    }

    /**
     * Gets output stream by excel.
     *
     * @param response the response
     * @param fileName the file name
     * @return the output stream by excel
     */
    public static OutputStream getOutputStreamByExcel(HttpServletResponse response, String fileName) {
       return getOutputStreamByExcel(response, null, fileName);
    }

}
