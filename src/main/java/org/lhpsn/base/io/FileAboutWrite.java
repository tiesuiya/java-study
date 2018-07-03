package org.lhpsn.base.io;

import java.io.*;

/**
 * 关于文件写入
 *
 * @author lh
 * @since 1.0.0
 */
public class FileAboutWrite {

    public static void main(String[] args) throws IOException {

        FileAboutWrite ioAboutFile = new FileAboutWrite();

        String content = "我就是内容\n我也是内容\n我还是内容";
        String pathName = "target/fileWrite.txt";
        ioAboutFile.writeFileByOutputStream(pathName, content);
    }

    /**
     * 通过OutputStream读文件
     *
     * @param pathName 文件路径
     * @param content  文件内容
     * @throws IOException IOException
     */
    private void writeFileByOutputStream(String pathName, String content) throws IOException {
        OutputStream outputStream = new FileOutputStream(new File(pathName));
        outputStream.write(content.getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }
}