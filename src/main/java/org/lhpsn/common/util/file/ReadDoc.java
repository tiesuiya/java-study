package org.lhpsn.common.util.file;

import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 读取Doc
 * @author lh
 * @since 1.0.0
 */
class ReadDoc extends ReadSuper {
    @Override
    public String getContent() throws Exception {
        String content;
        try (InputStream in = new FileInputStream(getFile())) {
            WordExtractor ex = new WordExtractor(in);
            content = ex.getText();
        }
        return content;
    }
}
