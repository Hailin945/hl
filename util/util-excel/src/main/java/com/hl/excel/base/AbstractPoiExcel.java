package com.hl.excel.base;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.OutputStream;
import java.util.*;

/**
 * @author Hailin
 */
public abstract class AbstractPoiExcel<T> implements PoiInterface<T> {
    /**
     * Excel 03版
     */
    public static final int EXCEL_VERSION_03 = 0;
    /**
     * Excel 07版
     */
    public static final int EXCEL_VERSION_07 = 1;
    /**
     * 导出EXCEL文件（无分页）（普通JavaBean）
     */
    public static final int EXPORT_SIMPLE_EXCEL = -1;
    /**
     * 分页导出默认文件
     */
    public static final int EXPORT_PAGE_EXCEL = -2;
    /**
     * 导出默认样式EXCEL文件（Map结构）
     */
    public static final int EXPORT_MAP_EXCEL = -5;

    // 表头--标题栏
    protected Map<Integer, String> getHeadersNameMap(List<String> headersName) {
        Map<Integer, String> headersNameMap = new HashMap();
        int key = 0;
        for (int i = 0; i < headersName.size(); i++) {
            if (!headersName.get(i).equals(null)) {
                headersNameMap.put(key, headersName.get(i));
                key++;
            }
        }
        return headersNameMap;
    }

    // 字段---标题的字段
    protected Map<Integer, String> getTitleFieldMap(List<String> headersId) {
        Map<Integer, String> titleFieldMap = new HashMap();
        int value = 0;
        for (int i = 0; i < headersId.size(); i++) {
            if (!headersId.get(i).equals(null)) {
                titleFieldMap.put(value, headersId.get(i));
                value++;
            }
        }
        return titleFieldMap;
    }

    // 获得默认样式
    protected CellStyle getHeaderCellStyle(Workbook wb) {
        // 设置字体
        Font font = wb.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 10);
        //字体加粗
        font.setBold(true);
        font.setFontName("宋体");
        font.setColor((short) 10);

        // 生成一个样式
        CellStyle headerStyle = wb.createCellStyle();
        //设置字体
        headerStyle.setFont(font);
        //设置顶边框;
        headerStyle.setBorderTop(BorderStyle.THIN);
        //设置右边框;
        headerStyle.setBorderRight(BorderStyle.THIN);
        //设置左边框;
        headerStyle.setBorderLeft(BorderStyle.THIN);
        //设置底边框;
        headerStyle.setBorderBottom(BorderStyle.THIN);
        //设置自动换行;
        headerStyle.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置垂直对齐的样式为居中对齐;
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return headerStyle;
    }

    //获得默认的数据体样式
    protected CellStyle getDataCellStyle(Workbook wb) {
        // 设置字体
        Font font = wb.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 10);
        //字体加粗
//        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        font.setColor((short) 32767);
        // 生成一个样式
        CellStyle dataStyle = wb.createCellStyle();
        //设置字体
        dataStyle.setFont(font);
        //设置顶边框;
        dataStyle.setBorderTop(BorderStyle.THIN);
        //设置右边框;
        dataStyle.setBorderRight(BorderStyle.THIN);
        //设置左边框;
        dataStyle.setBorderLeft(BorderStyle.THIN);
        //设置底边框;
        dataStyle.setBorderBottom(BorderStyle.THIN);
        //设置自动换行;
        dataStyle.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        dataStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置垂直对齐的样式为居中对齐;
        dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return dataStyle;
    }

    // 获得工作簿
    protected Workbook getWorkbook(int excelVersion) {
        Workbook wb = null;
        if (excelVersion == 0) {
            wb = new HSSFWorkbook();
        } else {
            wb = new XSSFWorkbook();
        }
        return wb;
    }

    // 设置表格标题：
    protected void setTitle(Row row, Iterator<String> headersNameIt, Cell cell, CellStyle style) {
        //根据选择的字段生成表头--标题
        short size = 0;
        while (headersNameIt.hasNext()) {
            cell = row.createCell(size);
            cell.setCellValue(headersNameIt.next().toString());
            cell.setCellStyle(style);
            size++;
        }
    }

    @Override
    public int exportBeanExcel(int excelVersion, String title, List<String> headersName, List<String> headersId,
                               List<T> dtoList, OutputStream out) {
        return 0;
    }

    @Override
    public int exportStyleBeanExcel(int excelVersion, String title, List<String> headersName, List<String> headersId,
                                    List<T> dtoList, OutputStream out, StyleInterface styleUtil) {
        return 0;
    }


    @Override
    public int exportStyleBeanExcel(int excelVersion, String title, List<String> headersName,
                                    List<T> dtoList, OutputStream out, StyleInterface styleUtil) {
        return 0;
    }

    @Override
    public Sheet exportPageTitleExcel(Workbook wb, Sheet sheet, List<String> headersName, StyleInterface styleUtil) {
        //表头--标题栏
        Map<Integer, String> headersNameMap = getHeadersNameMap(headersName);
        //设置样式：
        CellStyle headerStyle = null;
        headerStyle = styleUtil.setHeaderStyle(wb);
        if (headerStyle == null) {
            headerStyle = getHeaderCellStyle(wb);
        }
        //行高--先设置行高再设置列宽
        styleUtil.setRowHigh();
        short rowHigh = styleUtil.getRowHigh();
        if (rowHigh == 0) {
            rowHigh = (short) (2 * 256);
        }
        sheet.setDefaultRowHeight(rowHigh);
        //列宽
        styleUtil.setColumnWidth();
        short columnWidth = styleUtil.getColumnWidth();
        if (columnWidth == 0) {
            columnWidth = 15;
        }
        sheet.setDefaultColumnWidth(columnWidth);
        //一个补偿方法，设定特定列宽
        styleUtil.setSpecifiedHighAndWidth(sheet);
        //如果有使用完全自定义方式，则覆盖上面所有的方式
        CellStyle customizedStyle = styleUtil.setHeaderStyle(wb, sheet);
        if (customizedStyle != null) {
            headerStyle = customizedStyle;
        }
        Row row = sheet.createRow(0);
        Cell cell = null;
        Collection c = headersNameMap.values();//拿到表格所有标题的value的集合
        Iterator<String> headersNameIt = c.iterator();//表格标题的迭代器
        //根据选择的字段生成表头--标题
        setTitle(row, headersNameIt, cell, headerStyle);
        return sheet;
    }

    @Override
    public Sheet exportPageContentBeanExcel(Workbook wb, Sheet sheet, List<String> headersId, List<T> dtoList, StyleInterface styleUtil, int pageNum, int pageSize) {
        return sheet;
    }

    @Override
    public Sheet exportPageContentBeanExcel(Workbook wb, Sheet sheet, List<T> dtoList, StyleInterface styleUtil, int pageNum, int pageSize) {
        return sheet;
    }

    @Override
    public Workbook getPageExcelBook(int excelVersion) {
        Workbook wb = getWorkbook(excelVersion);
        return wb;
    }

    @Override
    public Sheet getPageExcelSheet(Workbook workbook, String bookTitle) {
        Sheet sheet = workbook.createSheet(bookTitle);
        return sheet;
    }


    @Override
    public int exportMapExcel(int excelVersion, String title, List<String> headersName, List<String> headersId,
                              List<Map<String, Object>> dtoList, OutputStream out) throws Exception {
        return 0;
    }

    @Override
    public int exportStyleMapExcel(int excelVersion, String title, List<String> headersName, List<String> headersId,
                                   List<Map<String, Object>> dtoList, OutputStream out, StyleInterface styleUtil) throws Exception {
        return 0;
    }

    @Override
    public Sheet exportPageContentMapExcel(Workbook wb, Sheet sheet, List<String> headersId, List<Map<String, Object>> dtoList, StyleInterface styleUtil, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public Sheet exportPageContentMapExcel(Workbook wb, Sheet sheet, List<Map<String, Object>> dtoList, StyleInterface styleUtil, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public int exportStyleMapExcel(int excelVersion, String title, List<String> headersName,
                                   List<Map<String, Object>> dtoList, OutputStream out, StyleInterface styleUtil) throws Exception {
        return 0;
    }
}
