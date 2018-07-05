package org.lhpsn.common.util.file;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 读取Doc
 *
 * @author lh
 * @since 1.0.0
 */
class ReadDocx extends ReadSuper {
    @Override
    public String getContent() throws Exception {
        String content;
        try (InputStream in = new FileInputStream(getFile())) {
            XWPFDocument xDoc = new XWPFDocument(in);
            XWPFWordExtractor extractor = new XWPFWordExtractor(xDoc);
            content = extractor.getText();
        }
        return content;
    }
}
