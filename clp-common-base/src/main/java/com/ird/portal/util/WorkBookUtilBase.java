package com.ird.portal.util;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.*;

/**
 * 列印Base Util.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 25/07/2018 09:15:24<br/>
 * @author Amse
 * @version 1.0
 */
@SuppressWarnings("AccessStaticViaInstance")
public abstract class WorkBookUtilBase<T> {
    private static final int SHEET_DEFAULT_FONT_SIZE = 12;

    private static final Logger logger = LoggerFactory.getLogger(WorkBookUtilBase.class);

    private HSSFWorkbook workBook;

    public WorkBookUtilBase() {
        this.workBook = new HSSFWorkbook();
    }

    public HSSFWorkbook getWorkBook() {
        return this.workBook;
    }

    public void setWorkBook(HSSFWorkbook wb) {
        this.workBook = wb;
    }

    private Map<String, CellStyle> styleMap = new HashMap<String, CellStyle>();

    private Map<String, List<CellStyle>> cellStylesMap = new HashMap<>();

    /**
     * 创建sheet.
     *
     * @param sheetName sheet名字
     * @return 初始化后的Sheet
     */
    public Sheet createSheet(String sheetName) {
        HSSFSheet sheet = this.getWorkBook().createSheet(sheetName);
        initSheet(sheet);
        return sheet;
    }

    /**
     * 初始化sheet.
     *
     * @param sheet sheet
     */
    public abstract void initSheet(Sheet sheet);

    /**
     * 構建sheet數據
     */
    public abstract void buildContent(Sheet sheet, T dto) throws Exception;

    /**
     * 获取样式style.
     *
     * @return CellStyle
     */
    public CellStyle getStyle() {
        return workBook.createCellStyle();
    }

    /**
     * 获取字体样式.
     *
     * @return Font
     */
    public Font getFont() {
        return workBook.createFont();
    }

    /**
     * 设置默认字体样式.
     *
     * @param font 字体对象
     */
    public void setDefaulfFont(HSSFFont font) {
        font.setCharSet(HSSFFont.DEFAULT_CHARSET);
        //更改默认字体大小
        font.setFontHeightInPoints((short) SHEET_DEFAULT_FONT_SIZE);
        //设置默认字体
        font.setFontName("細明體");
        font.setFontName("Times New Roman");
    }


    /**
     * 边框.
     * @param style style
     * @return style
     */
    public CellStyle setBorderFill(CellStyle style) {
        //加边框
        style.setBorderBottom(style.getBorderBottomEnum().THIN);
        style.setBorderTop(style.getBorderBottomEnum().THIN);
        style.setBorderLeft(style.getBorderBottomEnum().THIN);
        style.setBorderRight(style.getBorderBottomEnum().THIN);
        return style;
    }

    /**
     * 根据条件设置边框.
     *
     * @param top    上边框
     * @param right  右边框
     * @param bottom 下边框
     * @param left   左边框
     * @return CellStyle
     */
    public CellStyle setBorderSelectAdd(boolean top, boolean right, boolean bottom, boolean left) {
        CellStyle style = this.getStyle();
        if (top) {
            style.setBorderTop(style.getBorderBottomEnum().THIN);
        }
        if (right) {
            style.setBorderRight(style.getBorderBottomEnum().THIN);
        }
        if (bottom) {
            style.setBorderBottom(style.getBorderBottomEnum().THIN);
        }
        if (left) {
            style.setBorderLeft(style.getBorderBottomEnum().THIN);
        }
        return style;
    }

    /**
     * 设置边框返回style.
     *
     * @return CellStyle
     */
    public CellStyle setBorderFill() {
        CellStyle style = this.getStyle();
        style.setBorderBottom(style.getBorderBottomEnum().THIN);
        style.setBorderTop(style.getBorderBottomEnum().THIN);
        style.setBorderLeft(style.getBorderBottomEnum().THIN);
        style.setBorderRight(style.getBorderBottomEnum().THIN);

        return style;
    }

    /**
     * 设置垂直水平居中.
     *
     * @return CellStyle
     */
    public CellStyle setAlign() {
        CellStyle style = this.getStyle();
        //水平居中
        style.setAlignment(style.getAlignmentEnum().CENTER);
        //设置垂直居中
        style.setVerticalAlignment(style.getVerticalAlignmentEnum().CENTER);
        return style;
    }

    /**
     * 设置垂直水平居中.
     *
     * @return CellStyle
     */
    public CellStyle setAlign(CellStyle cellStyle) {
        //水平居中
        cellStyle.setAlignment(cellStyle.getAlignmentEnum().CENTER);
        //设置垂直居中
        cellStyle.setVerticalAlignment(cellStyle.getVerticalAlignmentEnum().CENTER);
        return cellStyle;
    }


    /**
     * 合并以后设置所有边框.
     * @param border 线条类型对象
     * @param region 合并对象
     * @param sheet sheet对象
     */
    public void setBorderRegionStyle(BorderStyle border, CellRangeAddress region, Sheet sheet){
        RegionUtil.setBorderBottom(border, region, sheet );  //下边框
        RegionUtil.setBorderLeft(border, region, sheet);     //左边框
        RegionUtil.setBorderRight(border, region, sheet);    //右边框
        RegionUtil.setBorderTop(border, region, sheet);      //上边框
    }

    /**
     * 设置是否垂直，水平居中.
     *
     * @param level    水平
     * @param vertical 垂直
     * @return CellStyle
     */
    public CellStyle setAlign(boolean level, boolean vertical) {
        CellStyle style = this.getStyle();
        if (level) {
            style.setAlignment(style.getAlignmentEnum().CENTER);
        }
        if (vertical) {
            style.setVerticalAlignment(style.getVerticalAlignmentEnum().CENTER);
        }
        return style;
    }

    /**
     * 设置是否垂直，水平居中.
     *
     * @param level    水平
     * @param vertical 垂直
     * @return CellStyle
     */
    public CellStyle setAlign(boolean level, boolean vertical, CellStyle cellStyle) {
        if (level) {
            cellStyle.setAlignment(cellStyle.getAlignmentEnum().CENTER);
        }
        if (vertical) {
            cellStyle.setVerticalAlignment(cellStyle.getVerticalAlignmentEnum().CENTER);
        }
        return cellStyle;
    }

    /**
     * 合并单元格，使用如b1:b2的方式.
     *
     * @param sheet 工作sheet
     * @param ref   合并的行列
     * @return CellRangeAddress
     */
    public CellRangeAddress addMergedRegion(Sheet sheet, String ref) {
        CellRangeAddress cellRangeAddress = CellRangeAddress.valueOf(ref);
        sheet.addMergedRegion(CellRangeAddress.valueOf(ref));
        return cellRangeAddress;
    }

    /**
     * 设置字体.
     *
     * @param bold     是否加粗
     * @param fontSize 字体大小
     * @return Font
     */
    public Font setFont(boolean bold, int fontSize) {
        //字体
        Font font = getWorkBook().createFont();
        //加粗
        font.setBold(bold);
        //字体大小
        font.setFontHeightInPoints((short) fontSize);
        font.setFontName("Times New Roman");
        return font;
    }

    /**
     * 设置间隔.
     *
     * @param interval 间隔大小
     * @return String
     */
    public static String setInterval(int interval) {
        StringBuffer sb;
        sb = new StringBuffer();
        for (int x = 0; x < interval; x++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * 构建行里的列内容.
     *
     * @param row        行
     * @param value      数据，数组
     * @param cellStyles 样式表，每一列对应，如数据列多于样式列，最后使用最后一个样式
     */
    public void buildRowCell(Row row, String[] value, List<CellStyle> cellStyles) {
        for (int x = 0; x < value.length; x++) {
            Cell cell = row.createCell(x, CellType.STRING);
            CellStyle style = null;
            try {
                style = cellStyles.get(x);
            } catch (IndexOutOfBoundsException e) {
                style = cellStyles.get(cellStyles.size() - 1);
            }
            cell.setCellStyle(style);
            cell.setCellValue(value[x]);
        }
    }

    public void buildRowCell(Row row, String[] value, CellStyle cellStyle) {
        for (int x = 0; x < value.length; x++) {
            Cell cell = row.createCell(x, CellType.STRING);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(value[x]);
        }
    }

    public void buildRowCell(Row row, String value, CellStyle cellStyle) {
        buildRowCell(0, row, value, cellStyle);
    }

    /**
     * 构建行里的列内容.
     *
     * @param row        行
     * @param value      数据，数组
     * @param cellStyles 样式表，每一列对应，如数据列多于样式列，最后使用最后一个样式
     * @param cellType 單元格格式
     */
    public void buildRowCell(Row row, String[] value, List<CellStyle> cellStyles, CellType cellType) {
        for (int x = 0; x < value.length; x++) {
            Cell cell = row.createCell(x, cellType);
            CellStyle style = null;
            try {
                style = cellStyles.get(x);
            } catch (IndexOutOfBoundsException e) {
                style = cellStyles.get(cellStyles.size() - 1);
            }
            cell.setCellStyle(style);
            cell.setCellValue(value[x]);
        }
    }

    /**
     * 构建行里的列内容.
     *
     * @param row        行
     * @param startCell  开始列
     * @param value      数据，数组
     * @param cellStyles 样式表，每一列对应，如数据列多于样式列，最后使用最后一个样式
     */
    public void buildRowCell(int startCell, Row row, String[] value, List<CellStyle> cellStyles) {
        for (int x = startCell, y = 0; x < value.length + startCell; x++, y++) {
            Cell cell = row.createCell(x, CellType.STRING);
            CellStyle style = null;
            try {
                style = cellStyles.get(y);
            } catch (IndexOutOfBoundsException e) {
                style = cellStyles.get(cellStyles.size() - 1);
            }
            cell.setCellStyle(style);
            cell.setCellValue(value[y]);
        }
    }

    /**
     * 构建行里的列内容.
     *
     * @param row        行
     * @param startCell  开始列
     * @param value      数据，数组
     * @param cellStyles 样式表，每一列对应，如数据列多于样式列，最后使用最后一个样式
     */
    public void buildRowCell(int startCell, Row row, String[] value, CellStyle cellStyles, CellType cellType) {
        for (int x = startCell, y = 0; x < value.length + startCell; x++, y++) {
            Cell cell = row.createCell(x, cellType);
            cell.setCellStyle(cellStyles);
            cell.setCellValue(value[y]);
        }
    }

    public void buildRowCell(int startCell, Row row, long[] value, CellStyle cellStyles, CellType cellType) {
        for (int x = startCell, y = 0; x < value.length + startCell; x++, y++) {
            Cell cell = row.createCell(x, cellType);
            cell.setCellStyle(cellStyles);
            cell.setCellValue(value[y]);
        }
    }


    /**
     * 构建列内容.
     *
     * @param cellLoc   列位置
     * @param row       行
     * @param value     內容
     * @param cellStyle 单个样式
     */
    public void buildRowCell(int cellLoc, Row row, String value, CellStyle cellStyle) {
        Cell cell = row.createCell(cellLoc, CellType.STRING);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(value);
    }

    /**
     * 行內容
     *
     * @param cellLoc 定位列
     * @param row     行
     * @param value   內容
     */
    public void buildRowCell(int cellLoc, Row row, String value) {
        Cell cell = row.createCell(cellLoc, CellType.STRING);
        cell.setCellValue(value);
    }

    /**
     * 表格标题样式.
     *
     * @return List<CellStyle>
     */
    public List<CellStyle> getExamineeTableTitleCellStyles() {
        if (this.cellStylesMap.containsKey("examineeTableTitleCellStyles")) {
            return this.cellStylesMap.get("examineeTableTitleCellStyles");
        }
        List<CellStyle> titlesCellStyles = new ArrayList<CellStyle>();
        //第一列样式
        CellStyle examineeTableTitleRowStyleOne = setBoldAndWrap();
        examineeTableTitleRowStyleOne.setAlignment(examineeTableTitleRowStyleOne.getAlignmentEnum().CENTER);
        examineeTableTitleRowStyleOne.setVerticalAlignment(examineeTableTitleRowStyleOne.getVerticalAlignmentEnum().CENTER);
        examineeTableTitleRowStyleOne.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        examineeTableTitleRowStyleOne.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titlesCellStyles.add(examineeTableTitleRowStyleOne);

        this.cellStylesMap.put("examineeTableTitleCellStyles", titlesCellStyles);

        return titlesCellStyles;
    }

    public Row interleaveColor(Row row) {
        if (row.getRowNum() % 2 == 0) {
            for (int x = 0; x < row.getLastCellNum(); x++) {
                Cell cell = row.getCell(x);
                CellStyle style = cell.getCellStyle();
                interleaveColor(style);
            }
        }
        return row;
    }

    public CellStyle interleaveColor(CellStyle style) {
        style = setBorderFill(style);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
    }

    /**
     * 设置加粗字体和换行.
     *
     * @return CellStyle.
     */
    public CellStyle setBoldAndWrap() {
        CellStyle style = setBorderFill();
        //強制換行
        style.setWrapText(true);
        //加粗大小
        Font examineeUunFont = setFont(true, 12);
        style.setFont(examineeUunFont);
        return style;
    }


    /**
     *
     * @param sheet 工作空間
     * @param titles 表頭，標題
     * @param dataset 表格數據
     * @param map 字段需要替換值如：{sex:{1:'男',0:'女'}}字段sex為1則替換成'男'顯示
     * @param startRow  表格開始行數
     * @param filterFieldSet    指定表格獲取的DTO字段
     * @throws Exception 异常
     */
    @SuppressWarnings("static-access")
    public void buildDataTable(Sheet sheet, String[] titles, Collection<T> dataset, Map<String, Map<String, String>> map,
                               Integer startRow, Set<String> filterFieldSet) throws Exception {
        //创建表头head
        Row tableHead = sheet.createRow(startRow);

        //样式
        CellStyle style = this.getStyle();
        //获取字体
        Font cellFont = this.getFont();
        //加粗
        cellFont.setBold(true);

        //从新设置默认字体
        setDefaulfFont((HSSFFont) cellFont);

        style.setFont(cellFont);

        //加邊框
        this.setBorderFill(style);
        style.setWrapText(true);

        //垂直居中
        style.setVerticalAlignment(style.getVerticalAlignmentEnum().CENTER);

        for (int c = 0; c < titles.length; c++) {
            Cell cell = tableHead.createCell(c);
            //設置樣式
            cell.setCellStyle(style);
            //设置值
            cell.setCellValue(titles[c]);

        }
        this.buildTbody(sheet, dataset, map, startRow, filterFieldSet);
    }

    /**
     * 构建表格数据.
     * @param sheet 工作空間
     * @param dataset 表格数据
     * @param map   字段替换数据
     * @param startRow 表格开始行
     * @param fieldSet 字段过滤
     * @throws Exception 异常
     */
    public void buildTbody(Sheet sheet, Collection<T> dataset, Map<String, Map<String, String>> map, Integer startRow, Set<String> fieldSet)throws Exception {
        //创建表格内容tbody
        Iterator<T> it = dataset.iterator();
        int index = startRow;
        //加邊框
        CellStyle cellStyle = this.setBorderFill();
        cellStyle.setWrapText(true);
        while (it.hasNext()) {
            index++;
            // 创建一行数据行
            Row row = sheet.createRow(index);
            T t = it.next();

            int cellInext = 0;
            for (String fieldName : fieldSet) {
                // 得到getXxx()方法的字符串
                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                Method method;
                try {
                    method = t.getClass().getMethod(getMethodName);
                } catch (NoSuchMethodException e) {
                    continue;
                }

                Cell cell = row.createCell(cellInext);
                cellInext++;

                cell.setCellStyle(cellStyle);

                Object value = method.invoke(t);

                if (map != null && map.size() > 0) {
                    if (map.containsKey(fieldName)) {
                        if (map.get(fieldName) != null && map.size() > 0) {
                            if (value != null) {
                                if (map.get(fieldName).containsKey(value.toString())) {
                                    //{sex:{1:'男':0:'女'}}字段sex如果为1单元格设置值为'男'
                                    cell.setCellValue(map.get(fieldName).get(value.toString()));
                                }
                            }
                        }
                    } else {
                        if (value != null) {
                            cell.setCellValue(value.toString());
                        } else {
                            cell.setCellValue("");
                        }

                    }
                } else {
                    if (value != null) {
                        cell.setCellValue(value.toString());
                    } else {
                        cell.setCellValue("");
                    }
                }
            }
        }
    }


    /**
     * 导出excel.
     *
     * @param outputStream 传入输入流
     */
    public void exportExcel(OutputStream outputStream) {
        try {
            workBook.write(outputStream);
            outputStream.flush();
            workBook.close();
        } catch (IOException e) {
            logger.error("outputStream is error",e);
        }
    }

    /**
     * 為瀏覽器下載用.
     * @param response res
     * @param request req
     * @param fileName filaName
     * @return OutPutStream
     * @throws IOException ioE
     */
    public OutputStream getOutputStream(HttpServletResponse response, HttpServletRequest request, String fileName) throws IOException {
        //ID和其他瀏覽器中文亂碼問題，判斷是否是ie
        String userAgent = request.getHeader("user-agent").toLowerCase();
        if (userAgent.contains("msie") || userAgent.contains("like gecko")) {
            // win10 ie edge 浏览器 和其他系统的ie
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } else {
            // fe
            fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        }
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xls");
        //獲取response outputStream
        return response.getOutputStream();
    }





}
