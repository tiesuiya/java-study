package org.lhpsn.common.util.file;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 读取Xls和Xlsx
 *
 * @author lh
 * @since 1.0.0
 */
class ReadXlsAndXlsx extends ReadSuper {
    @Override
    public String getContent() throws Exception {
        String content;
        try (InputStream in = new FileInputStream(getFile())) {
            // 检查文件
            Workbook workbook = null;
            // 获得Workbook工作薄对象
            if ("xls".equals(getSuffix())) {
                // 2003
                workbook = new HSSFWorkbook(in);
            } else if ("xlsx".equals(getSuffix())) {
                // 2007
                workbook = new XSSFWorkbook(in);
            }
            StringBuffer sb = new StringBuffer();
            if (workbook != null) {
                for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                    // 获得当前sheet工作表
                    Sheet sheet = workbook.getSheetAt(sheetNum);
                    if (sheet == null) {
                        continue;
                    }
                    // 获得当前sheet的开始行
                    int firstRowNum = sheet.getFirstRowNum();
                    // 获得当前sheet的结束行
                    int lastRowNum = sheet.getLastRowNum();

                    for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++) {
                        // 获得当前行
                        Row row = sheet.getRow(rowNum);
                        if (row == null) {
                            continue;
                        }
                        // 获得当前行的开始列
                        int firstCellNum = row.getFirstCellNum();
                        // 获得当前行的列数
                        int lastCellNum = row.getPhysicalNumberOfCells();
                        // 循环当前行
                        for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                            Cell cell = row.getCell(cellNum);
                            sb.append(getCellValue(cell));
                        }
                    }
                }
            }
            content = sb.toString();
        }
        return content;
    }

    /**
     * 读取单元格
     *
     * @param cell 单元格
     * @return 单元格内容
     */
    private static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        // 把数字当成String来读，避免出现1读成1.0的情况
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        // 判断数据的类型
        switch (cell.getCellType()) {
            // 数字
            case Cell.CELL_TYPE_NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            // 字符串
            case Cell.CELL_TYPE_STRING:
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            // Boolean
            case Cell.CELL_TYPE_BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            // 公式
            case Cell.CELL_TYPE_FORMULA:
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            // 空值
            case Cell.CELL_TYPE_BLANK:
                cellValue = "";
                break;
            // 故障
            case Cell.CELL_TYPE_ERROR:
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }
}
