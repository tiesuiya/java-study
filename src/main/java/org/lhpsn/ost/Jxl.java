package org.lhpsn.ost;

import jxl.Workbook;
import jxl.write.*;

import java.io.File;
import java.io.IOException;

/**
 * jxl包相关运用
 *
 * @author lh
 * @since 1.0.0
 */
public class Jxl {

    public static void main(String[] args) throws Exception {

        Jxl jxl = new Jxl();
        jxl.integratedUse();
    }

    /**
     * 综合运用
     *
     * @throws IOException    异常
     * @throws WriteException 异常
     */
    private void integratedUse() throws IOException, WriteException {
        // 打开一个xls文件，没有的话程序会自动创建
        WritableWorkbook order = Workbook.createWorkbook(new File("target/JxlTest.xls"));
        // 生成一个工作表
        WritableSheet orderSheet = order.createSheet("第一页", 0);

        // 合并一些单元格,这里的参数意思是从（0,0）到（1,1）的单元格全部合并
        orderSheet.mergeCells(0, 0, 1, 1);
        // 第一列的宽度
        orderSheet.setColumnView(0, 24);
        // 第一行的高度
        orderSheet.setRowView(0, 1910);

        // 创建样式
        // 字体
        WritableFont font1 = new WritableFont(WritableFont.TIMES, 16, WritableFont.BOLD);
        // 单元格格式
        WritableCellFormat format1 = new WritableCellFormat(font1);
        // 把水平对齐方式指定为居中
        format1.setAlignment(jxl.format.Alignment.CENTRE);
        // 把垂直对齐方式指定为居中
        format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);

        // 建立一个label，并进行格式化
        Label label = new Label(0, 0, "Hello Excel!", format1);
        orderSheet.addCell(label);

        order.write();
        order.close();
    }
}
