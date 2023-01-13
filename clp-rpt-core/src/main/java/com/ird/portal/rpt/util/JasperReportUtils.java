package com.ird.portal.rpt.util;

/**
 * @Project Name: dls-rpt-core
 * @File Name: JasperReportFill.java
 * @Date: 02/01/2018 14:44:41
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */

import com.ird.portal.util.FileUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.apache.commons.lang3.StringUtils;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * 報表工具類.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 02/01/2018 14:44:41<br/>
 * @author Deft
 * @version 1.0
 */
public class JasperReportUtils {

    public static void exportReportToPdf(InputStream inputStream, OutputStream outputStream, Map<String, Object> parameters, JRDataSource dataSource) throws Exception {
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }

    public static void exportReportToPdf(InputStream inputStream, OutputStream outputStream, Map<String, Object> parameters) throws Exception {
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }

    /**
     * 多張.jasper 報表一起打印.
     *
     * @param outputStream
     * @param parameters
     * @throws Exception
     */
    public static void exportReportToPdf(List<FillReportInfo> fillReportInfos, OutputStream outputStream, Map<String, Object> parameters) throws Exception {
        List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
        for (FillReportInfo info : fillReportInfos) {
            JasperPrint jasperPrint = JasperFillManager.fillReport(info.getInputStream(), parameters,info.getDataSource());
            jasperPrintList.add(jasperPrint);
        }
        JasperReportsContext jasperReportsContext = DefaultJasperReportsContext.getInstance();
        JRPdfExporter exporter = new JRPdfExporter(jasperReportsContext);

        exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

        exporter.exportReport();
    }

    public static void exportReportToPdf(InputStream inputStream, OutputStream outputStream, Map<String, Object> parameters, Connection connection) throws Exception {
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, connection);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }

    public static void exportReportToHtml(InputStream inputStream, OutputStream outputStream, Map<String, Object> parameters) throws Exception {
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters);

        HtmlExporter exporter = new HtmlExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(outputStream));
        exporter.exportReport();
    }

    public static void exportReportToXml(InputStream inputStream, OutputStream outputStream, Map<String, Object> parameters) throws Exception {
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }

    public static byte[] exportReortToBytes(InputStream inputStream, Map<String, Object> parameters, JRDataSource dataSource) throws Exception {
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters,dataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    public static String exportReportToXml(InputStream inputStream, Map<String, Object> parameters) throws Exception {
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters);

        return JasperExportManager.exportReportToXml(jasperPrint);
    }

    /**
     * 導出 2007以後的Word文檔,後綴名 docx.
     *
     * @param inputStream
     * @param outputStream
     * @param parameters
     * @param dataSource
     * @throws Exception
     */
    public static void exportReportToWord(InputStream inputStream, OutputStream outputStream, Map<String, Object> parameters, JRDataSource dataSource) throws Exception {
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource);
        DefaultJasperReportsContext jasperReportsContext = DefaultJasperReportsContext.getInstance();

        JRDocxExporter exporter = new JRDocxExporter(jasperReportsContext);

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

        exporter.exportReport();
    }

    public static byte[] exportReportToImageBytes(InputStream inputStream, Map<String, Object> parameters, JRDataSource dataSource, float zoom) throws Exception {
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters,dataSource);

        // 以下方法有丢失精度
        int pageNum = jasperPrint.getPages().size();
        List<BufferedImage> bufferedImageList = new ArrayList<BufferedImage>();
        for (int i= 0; i< pageNum;i++) {
            BufferedImage rendered_image = (BufferedImage)JasperPrintManager.printPageToImage(jasperPrint, i,zoom);
            bufferedImageList.add(rendered_image);
        }
        return FileUtil.combineImagesToBytes(bufferedImageList);
    }
    
    /**
     * 多張.jasper 報表一起打印.
     *
     * @param outputStream
     * @param parameters
     * @throws Exception
     */
    public static void exportReportToWord(List<FillReportInfo> fillReportInfos, OutputStream outputStream, Map<String, Object> parameters) throws Exception {
        List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
        for (FillReportInfo info : fillReportInfos) {
            JasperPrint jasperPrint = JasperFillManager.fillReport(info.getInputStream(), parameters,info.getDataSource());
            jasperPrintList.add(jasperPrint);
        }
        JasperReportsContext jasperReportsContext = DefaultJasperReportsContext.getInstance();
        //導出 2007以後的Word文檔,後綴名 docx.
        JRDocxExporter exporter = new JRDocxExporter(jasperReportsContext);

        exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

        exporter.exportReport();
    }

    public static class FillReportInfo {
        private InputStream inputStream;
        private JRDataSource dataSource;
        public InputStream getInputStream() {
            return inputStream;
        }
        public FillReportInfo setInputStream(InputStream inputStream) {
            this.inputStream = inputStream;
            return this;
        }
        public JRDataSource getDataSource() {
            return dataSource;
        }
        public FillReportInfo setDataSource(JRDataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }
    }
    public static  byte[] pdfBytesToImageBytes(byte[] bytes,float zoom)throws IOException{
        ByteArrayInputStream in = null;
        Document document = new Document();
        try {
            in = new ByteArrayInputStream(bytes);
            document.setInputStream(in, null);
            //缩放比例
            float scale = 4.5f;
            //旋转角度
            float rotation = 0f;
            List<BufferedImage> bufferedImages = new ArrayList<BufferedImage>();
            for (int i = 0; i < document.getNumberOfPages(); i++) {
                BufferedImage image = (BufferedImage)
                        document.getPageImage(i, GraphicsRenderingHints.SCREEN, Page.BOUNDARY_CROPBOX, rotation, scale);
                bufferedImages.add(image);
            }

            return  FileUtil.combineImagesToBytes(bufferedImages);
        }finally {
            if(in != null){
                in.close();
            }
            document.dispose();
        }
    }


    /**
     * 因特殊字符會導致word文件可能打不開，提供處理word報表中特殊字符的轉義
     * @param character
     * @return
     */
    public static String escapeSpecialCharacter(String character) {
        if(StringUtils.isBlank(character)){
            return character;
        }
        if(character.contains("&")){
            character = character.replace("&", "&amp;");
        }
        if(character.contains(">")){
            character = character.replace(">", "&gt;");
        }
        if(character.contains("<")){
            character = character.replace("<", "&lt;");
        }
        return character;
    }
}
