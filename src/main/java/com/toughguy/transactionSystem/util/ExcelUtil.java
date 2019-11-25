package com.toughguy.transactionSystem.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;


/**
 * @description: 基于POI的导出Excel工具类
 * @author: liDongSheng
 * @date: 2019/11/20
 **/
public class ExcelUtil {
 
    private static final String XML ="xls";
    private static final String XLSX ="xlsx";
 
    /**
     * @description: //todo 下载Excel (样式为通用样式,sheet页是一个)
     * @author: liDongSheng
     * @param resp response返回
     * @param fileName 文件名 不需要后缀 默认是xlsx
     * @param datas 数据
     * @param titles 表头
     * @param primaryTitle 一级标题
     * */
    public static void exportExcel(HttpServletResponse resp, String fileName,Collection<?> datas, List<String> titles,String primaryTitle)throws Exception{
        resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        resp.addHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "utf-8")+ ".xlsx");
        exportExcel(resp.getOutputStream(),datas,titles,primaryTitle);
    }
 
    /**
     * @description: //todo Excel 写入OutputStream
     * @author: liDongSheng
     * @param out 输出流
     * @param datas 数据
     * @param titles 表头
     * */
    public static void exportExcel(OutputStream out,Collection<?> datas, List<String> titles,String primaryTitle){
    	//创建excel文档
    	XSSFWorkbook wb = new XSSFWorkbook();
        try {
        	//创建表单
            XSSFSheet sheet = wb.createSheet("new sheet");
            writeDataToExcel(wb,sheet,datas,titles,primaryTitle);
            wb.write(out);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
 
    /**
     * @description: // todo 读取上传的Excel文件
     * @author: liDongSheng
     * @param file 上传的文件
     * @param startRow  开始行 0开始
     * @param startCell 开始列 0开始
     * */
    public static List<String[]> readExcel(MultipartFile file, int startRow, int startCell)throws Exception{
        checkFile(file);
        String fileName = file.getOriginalFilename();
        Workbook workbook = getWorkBook(file,fileName);
        List<String []> list = new ArrayList<>();
        if(workbook != null){
            for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if(sheet == null){
                    continue;
                }
                int firstRowNum  = sheet.getFirstRowNum();
                int lastRowNum = sheet.getLastRowNum();
                for(int rowNum = firstRowNum+startRow;rowNum <= lastRowNum;rowNum++){
                    Row row = sheet.getRow(rowNum);
                    if(row == null){
                        continue;
                    }
                    int firstCellNum = row.getFirstCellNum();
                    int lastCellNum = row.getLastCellNum()+1;
                    String[] cells = new String[lastCellNum];
                    for(int cellNum = firstCellNum + startCell; cellNum < lastCellNum;cellNum++){
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
                    }
                    list.add(cells);
                }
            }
        }
        return list;
    }
 
    /**
     * @description: //todo 写Excel
     * @author: liDongSheng
     * @param workbook 工作区
     * @param sheet sheet
     * @param datas 数据
     * @param titles 表头
     * */
    private static void writeDataToExcel(XSSFWorkbook workbook,Sheet sheet, Collection<?> datas, List<String> titles,String primaryTitle){
        int cellIndex =writeTitleToExcel(workbook, sheet, titles);
        writePrimaryTitleToExcel(workbook, sheet, titles,primaryTitle);
        writeDataToExcel(workbook, sheet, datas);
        autoSizeColumns(sheet,cellIndex);
       
    }
 
    /**
     * @description: //todo 写一级标题到Excel
     * @author: liDongSheng
     * @param workbook 工作区
     * @param sheet sheet
     * @param titles 表头
     * @param titles 一级标题
     * */
    private static void writePrimaryTitleToExcel(XSSFWorkbook workbook,Sheet sheet,List<String> titles,String primaryTitle){
    	sheet.addMergedRegion(new CellRangeAddress(0,0,0,titles.size()-1));
    	Font titleFont = workbook.createFont();
        titleFont.setFontName("宋体");
        titleFont.setFontHeightInPoints((short) 18);
        XSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        titleStyle.setBorderBottom(BorderStyle.THIN); //底边框加黑
        titleStyle.setBorderLeft(BorderStyle.THIN);  //左边框加黑
        titleStyle.setBorderRight(BorderStyle.THIN); // 有边框加黑
        titleStyle.setBorderTop(BorderStyle.THIN); //上边框加黑
        titleStyle.setFont(titleFont);
        Row titleRow = sheet.createRow(0);
        titleRow.setHeightInPoints(25);
        for(int i=0;i<titles.size();i++) {
        	 Cell cell = titleRow.createCell(i);
        	 if(i==0) {
        		 cell.setCellValue(primaryTitle);
        	 }
             cell.setCellStyle(titleStyle);
        }
       
    }
    
    /**
     * @description: //todo 写标题到Excel
     * @author: liDongSheng
     * @param workbook 工作区
     * @param sheet sheet
     * @param titles 表头
     * */
    private static int writeTitleToExcel(XSSFWorkbook workbook,Sheet sheet,List<String> titles){
        int colIndex=0;
        Font titleFont = workbook.createFont();
        titleFont.setFontName("宋体");
        titleFont.setFontHeightInPoints((short) 16);
        XSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        titleStyle.setBorderBottom(BorderStyle.THIN); //底边框加黑
        titleStyle.setBorderLeft(BorderStyle.THIN);  //左边框加黑
        titleStyle.setBorderRight(BorderStyle.THIN); // 有边框加黑
        titleStyle.setBorderTop(BorderStyle.THIN); //上边框加黑
        titleStyle.setFont(titleFont);
        Row titleRow = sheet.createRow(1);
        titleRow.setHeightInPoints(20);
        for (String title : titles) {
            Cell cell = titleRow.createCell(colIndex);
            cell.setCellValue(title);
            cell.setCellStyle(titleStyle);
            colIndex++;
        }
        return colIndex;
    }
 
    /**
     * @description: //todo 写内容到Excel
     * @author: liDongSheng
     * @param workbook 工作区
     * @param sheet sheet
     * @param datas 数据
     * */
    private static void writeDataToExcel(XSSFWorkbook workbook,Sheet sheet,Collection<?> datas){
        int rowIndex = 2;
        Font dataFont = workbook.createFont();
        dataFont.setFontName("宋体");
        dataFont.setColor(IndexedColors.BLACK.index);
        dataFont.setFontHeightInPoints((short) 14);
        XSSFCellStyle dataStyle = workbook.createCellStyle();
        dataStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        dataStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        dataStyle.setBorderBottom(BorderStyle.THIN); //底边框加黑
        dataStyle.setBorderLeft(BorderStyle.THIN);  //左边框加黑
        dataStyle.setBorderRight(BorderStyle.THIN); // 有边框加黑
        dataStyle.setBorderTop(BorderStyle.THIN); //上边框加黑
        dataStyle.setFont(dataFont);
        Iterator<?> iterator = datas.iterator();
        while (iterator.hasNext()){
            Row dataRow = sheet.createRow(rowIndex);
            dataRow.setHeightInPoints(20);
            Object data = iterator.next();
            Class clazz = data.getClass();
            Field [] fields = clazz.getDeclaredFields();
            int cellIndex = 0;
            for (Field field: fields){
                Cell cell = dataRow.createCell(cellIndex);
                cell.setCellStyle(dataStyle);
                String fieldName = field.getName();
                String methodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                Method method;
                Object value = null;
                try {
                    method = clazz.getMethod(methodName,new Class[] {});
                    value = method.invoke(data,new Object[] {});
                   if(field.getGenericType().toString().equals("class java.util.Date")) {
                	   value= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
                   }
                }catch (Exception e){
                    e.printStackTrace();
                }
                cell.setCellValue(value+"");
                cellIndex ++;
            }
            rowIndex++;
        }
    }
 
    /**
     * @description: //todo 设置行宽度自适应 列不会设置
     * @author: liDongSheng
     * @param sheet sheet
     * @param columnNumber  结束列
     * */
    private static void autoSizeColumns(Sheet sheet, int columnNumber) {
        for (int i = 0; i < columnNumber; i++) {
            sheet.autoSizeColumn(i);
        }
    }
 
 
    /***
     * //todo 校验文件是否正常
     * @param file 上传的文件
     * @throws Exception
     */
    private static void checkFile(MultipartFile file)throws Exception{
        if (Objects.isNull(file))
            throw new FileNotFoundException("上传文件是空");
        String fileName = file.getOriginalFilename();
        if(!fileName.endsWith(XML) && !fileName.endsWith(XLSX))
            throw new IOException(fileName + "不是excel文件");
    }
 
    /**
     * @description: // todo 获取单元格的值
     * @author: liDongSheng
     * @param cell 单元格
     * @return String
     */
    private static String getCellValue(Cell cell){
        String cellValue = "";
        if(cell == null){
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }
 
    /**
     * @author: liDongSheng
     * @description: //todo 获取上传文件的工作区
     * @param file 上传的文件
     * @param fileName 文件名字
     * @return Workbook
     */
    private static Workbook getWorkBook(MultipartFile file,String fileName) {
        Workbook workbook = null;
        try {
            InputStream is = file.getInputStream();
            if(fileName.endsWith(XML)){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith(XLSX)){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }
 
     /**
     * @author: liDongSheng
     * @description: //todo 获取上传文件的工作区
     * @param file 读取到的文件
     * @return Workbook
     */
    private static Workbook getWorkBook(File file) {
        Workbook workbook = null;
        try {
            InputStream is = new FileInputStream(file);
            if(file.getName().endsWith(XML)){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(file.getName().endsWith(XLSX)){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }
}

