package com.ird.portal.rpt.util;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PDF處理工具類
 * @Author: kent long
 * @Date: 7/24/2018 12:12 PM
 */
public class PdfUtils {

    private Collection byteColl = new ArrayList();

    private static Logger LOG = LoggerFactory.getLogger(PdfUtils.class);

    public byte[] conbine()
            throws IOException, DocumentException {
        String methodName = "conbine";
        ByteArrayOutputStream conbined = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);

        PdfWriter pdfwriter = PdfWriter.getInstance(document, conbined);

        document.open();

        PdfContentByte pcb = pdfwriter.getDirectContent();

        PdfReader reader = null;
        PdfImportedPage page = null;

        Iterator ite = byteColl.iterator();
        while (ite.hasNext()) {
            reader = new PdfReader((byte[])ite.next());

            for (int i=0;i<reader.getNumberOfPages();i++) {
                document.newPage();
                page = pdfwriter.getImportedPage(reader,i+1);
                pcb.addTemplate(page, 0, 0);
            }
        }

        document.close();

        return conbined.toByteArray();
    }


    public byte[] conbineSide()
            throws IOException, DocumentException{
        String methodName = "conbineSide";
        ByteArrayOutputStream conbined = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter pdfwriter = PdfWriter.getInstance(document, conbined);

        document.open();

        PdfContentByte pcb = pdfwriter.getDirectContent();

        PdfReader reader = null;
        PdfImportedPage page = null;

        Iterator ite = byteColl.iterator();
        while (ite.hasNext()) {
            reader = new PdfReader((byte[])ite.next());

            for (int i=0;i<reader.getNumberOfPages();i++) {
                document.newPage();
                page = pdfwriter.getImportedPage(reader,i+1);
                pcb.addTemplate(page, 0, 0);
            }
        }

        document.close();
        return conbined.toByteArray();
    }
    public void add(byte[] byteArray) {
        byteColl.add(byteArray);
    }

    public void clear() {
        byteColl.clear();
    }

}