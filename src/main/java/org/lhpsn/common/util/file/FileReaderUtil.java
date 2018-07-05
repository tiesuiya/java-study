package org.lhpsn.common.util.file;

import java.io.File;

/**
 * 文件读取帮助类
 *
 * @author lh
 * @since 1.0.0
 */
public final class FileReaderUtil {

    private FileReaderUtil() {
    }

    /**
     * 读取文件文本内容
     *
     * @param file 文件
     * @return 文件内容
     * @throws Exception Exception
     */
    public static String readContent(File file) throws Exception {
        // 文件名
        String fileName = file.getName();
        // 文件后缀，无小点
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

        ReadSuper readSuper;
        switch (suffix) {
            case "doc":
                readSuper = new ReadDoc();
                break;
            case "docx":
                readSuper = new ReadDocx();
                break;
            case "ppt":
                readSuper = new ReadPpt();
                break;
            case "pptx":
                readSuper = new ReadPptx();
                break;
            case "xls":
            case "xlsx":
                readSuper = new ReadXlsAndXlsx();
                break;
            case "pdf":
                readSuper = new ReadPdf();
                break;
            default:
                readSuper = new ReadTxt();
                break;
        }
        readSuper.setFile(file);
        readSuper.setSuffix(suffix);

        return readSuper.getContent();
    }
}
