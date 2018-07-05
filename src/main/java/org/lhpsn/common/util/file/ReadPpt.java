package org.lhpsn.common.util.file;

import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.model.TextRun;
import org.apache.poi.hslf.usermodel.SlideShow;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 读取Ppt
 *
 * @author lh
 * @since 1.0.0
 */
class ReadPpt extends ReadSuper {
    @Override
    public String getContent() throws Exception {
        String content;
        try (InputStream in = new FileInputStream(getFile())) {
            StringBuilder builder = new StringBuilder("");
            // path为文件的全路径名称，建立SlideShow
            SlideShow ss = new SlideShow(new HSLFSlideShow(in));
            // 获得每一张幻灯片
            Slide[] slides = ss.getSlides();
            for (Slide slide : slides) {
                // 为了取得幻灯片的文字内容，建立TextRun
                TextRun[] t = slide.getTextRuns();
                for (TextRun aT : t) {
                    // 这里会将文字内容加到content中去
                    builder.append(aT.getText());
                }
                builder.append(slide.getTitle());
            }
            content = builder.toString();
        }
        return content;
    }
}
