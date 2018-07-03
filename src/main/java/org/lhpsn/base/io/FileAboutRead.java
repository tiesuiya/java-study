package org.lhpsn.base.io;

import java.io.*;

/**
 * 关于文件读取
 *
 * @author lh
 * @since 1.0.0
 */
public class FileAboutRead {

    public static void main(String[] args) throws IOException {

        FileAboutRead ioAboutFile = new FileAboutRead();

        String pathName = "README.MD";
        ioAboutFile.readFileByInputStream(pathName);
    }

    /**
     * 通过InputSteam读文件
     *
     * @param pathName 文件路径
     * @throws IOException IOException
     */
    private void readFileByInputStream(String pathName) throws IOException {
        InputStream inputStream = new FileInputStream(new File(pathName));

        StringBuilder builder = new StringBuilder();
        byte[] bytes = new byte[1024];
        int length;
        while ((length = inputStream.read(bytes)) != -1) {
            builder.append(new String(bytes, 0, length));
        }

        System.out.println(builder.toString());
    }
}