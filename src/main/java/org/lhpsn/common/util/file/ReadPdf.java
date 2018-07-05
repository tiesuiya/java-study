package org.lhpsn.common.util.file;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 读取Pdf
 *
 * @author lh
 * @since 1.0.0
 */
class ReadPdf extends ReadSuper {
    @Override
    public String getContent() throws Exception {
        String content;
        try (InputStream in = new FileInputStream(getFile())) {
            PDFParser parser = new PDFParser(in);
            parser.parse();
            PDDocument document = parser.getPDDocument();
            PDFTextStripper stripper = new PDFTextStripper();
            content = stripper.getText(document);
        }
        return content;
    }
}
