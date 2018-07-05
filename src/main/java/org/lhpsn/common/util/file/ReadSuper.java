package org.lhpsn.common.util.file;

import java.io.File;

/**
 * 读取文件类
 *
 * @author lh
 * @since 1.0.0
 */
abstract class ReadSuper {

    /**
     * 文件
     */
    private File file;

    /**
     * 文件后缀
     */
    private String suffix;

    /**
     * 获取文件内容
     *
     * @return 文件内容
     */
    public abstract String getContent() throws Exception;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
