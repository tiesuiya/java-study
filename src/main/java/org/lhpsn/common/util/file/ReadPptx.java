package org.lhpsn.common.util.file;

import org.apache.poi.xslf.extractor.XSLFPowerPointExtractor;
import org.apache.poi.xslf.usermodel.XMLSlideShow;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 读取Pptx
 *
 * @author lh
 * @since 1.0.0
 */
class ReadPptx extends ReadSuper {
    @Override
    public String getContent() throws Exception {
        String content;
        try (InputStream in = new FileInputStream(getFile())) {
            XMLSlideShow slide = new XMLSlideShow(in);
            XSLFPowerPointExtractor extractor = new XSLFPowerPointExtractor(slide);
            content = extractor.getText();
        }
        return content;
    }
}
