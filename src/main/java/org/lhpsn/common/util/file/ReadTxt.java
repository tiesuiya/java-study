package org.lhpsn.common.util.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 读取Txt
 *
 * @author lh
 * @since 1.0.0
 */
class ReadTxt extends ReadSuper {
    @Override
    public String getContent() throws Exception {
        String content;
        try (InputStream in = new FileInputStream(getFile())) {
            StringBuilder result = new StringBuilder();
            // 构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String s = null;
            // 使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {
                result.append(System.lineSeparator()).append(s);
            }
            br.close();
            content = result.toString();
        }
        return content;
    }
}
