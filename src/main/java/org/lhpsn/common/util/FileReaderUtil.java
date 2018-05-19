package org.lhpsn.common.util;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件读取帮助类
 *
 * @author lh
 * @since 1.0.0
 */
public class FileReaderUtil {

    /**
     * 读取文件文本内容
     *
     * @param file 文件
     * @return 文件内容
     * @throws IOException IOException
     */
    public static String readContent(File file) throws IOException {
        String content = null;

        String fileName = file.getName();
        // 文件后缀，无小点
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

        switch (suffix) {
            case "xls":
                content = readExcel(file);
                break;
            case "xlsx":
                content = FileReaderUtil.readExcel2007(file);
                break;
            case "doc":
                content = FileReaderUtil.readWord(file);
                break;
            case "docx":
                content = FileReaderUtil.readWord2007(file);
                break;
            case "txt":
                content = FileReaderUtil.readFile(file);
                break;
            default:
                // 待续...
                break;
        }

        return content;
    }

    /**
     * 读取文件内容
     *
     * @param file 文件
     * @return 文件内容
     * @throws IOException IOException
     */
    private static String readFile(File file) throws IOException {
        StringBuilder buffer = new StringBuilder();
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = inputStream.read(bytes)) != -1) {
            buffer.append(new String(bytes, 0, length));
        }
        return buffer.toString();
    }

    /**
     * 读取word2003
     *
     * @param file 文件
     * @return 文件内容
     * @throws IOException IOException
     */
    private static String readWord(File file) throws IOException {
        String bodyText;
        try (InputStream inputStream = new FileInputStream(file);
             WordExtractor extractor = new WordExtractor(inputStream)) {
            bodyText = extractor.getText();
        }
        return bodyText;
    }

    /**
     * 处理word2007
     *
     * @param file 文件
     * @return 文件内容
     * @throws IOException IOException
     */
    private static String readWord2007(File file) throws IOException {
        String bodyText;
        try (FileInputStream fis = new FileInputStream(file);
             XWPFDocument xdoc = new XWPFDocument(fis)) {
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            bodyText = extractor.getText();
        }
        return bodyText;
    }

    /**
     * 处理excel2003
     *
     * @param file 文件
     * @return 文件内容
     * @throws IOException IOException
     */
    private static String readExcel(File file) throws IOException {
        String content;
        try (InputStream inputStream = new FileInputStream(file);
             HSSFWorkbook wb = new HSSFWorkbook(inputStream)) {
            ExcelExtractor extractor = new ExcelExtractor(wb);
            extractor.setFormulasNotResults(true);
            extractor.setIncludeSheetNames(false);
            content = extractor.getText();
        }
        return content;
    }

    /**
     * 处理excel2007
     *
     * @param file 文件
     * @return 文件内容
     * @throws IOException IOException
     */
    private static String readExcel2007(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        // 构造 XSSFWorkbook 对象，strPath 传入文件路径
        try (InputStream inputStream = new FileInputStream(file);
             XSSFWorkbook xwb = new XSSFWorkbook(inputStream)) {
            // 循环工作表Sheet
            for (int numSheet = 0; numSheet < xwb.getNumberOfSheets(); numSheet++) {
                XSSFSheet xSheet = xwb.getSheetAt(numSheet);
                if (xSheet == null) {
                    continue;
                }
                // 循环行Row
                for (int rowNum = 0; rowNum <= xSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xRow = xSheet.getRow(rowNum);
                    if (xRow == null) {
                        continue;
                    }
                    // 循环列Cell
                    for (int cellNum = 0; cellNum <= xRow.getLastCellNum(); cellNum++) {
                        XSSFCell xCell = xRow.getCell(cellNum);
                        if (xCell == null) {
                            continue;
                        }
                        xCell.setCellType(XSSFCell.CELL_TYPE_STRING);
                        if (xCell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
                            content.append(xCell.getBooleanCellValue());
                        } else if (xCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                            content.append(xCell.getNumericCellValue());
                        } else {
                            content.append(xCell.getStringCellValue().toString());
                        }
                    }
                }
            }
        }
        return content.toString();
    }
}
