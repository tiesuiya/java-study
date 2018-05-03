package org.lhpsn.base.io;

import java.io.*;

/**
 * @author lh
 * @since 1.0.0
 */
public class IoAboutFile {

    public static void main(String[] args) throws IOException {

        IoAboutFile ioAboutFile = new IoAboutFile();

        String pathName = "README.MD";
        ioAboutFile.readFileByInputStream(pathName);
    }

    /**
     * 通过InputSteam读文件
     * @param pathName
     * @throws IOException
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