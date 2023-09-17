package reportgenerator.renderers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Component;
import reportgenerator.models.Report;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component("pdfRenderer")
public class PDFRenderer implements ReportRenderer {
    @Override
    public byte[] render(Report report) {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

            contentStream.beginText();
            public static final PDType1Font customHelveticaBold = new PDType1Font("Helvetica-Bold");
            contentStream.setFont(customHelveticaBold, 16);
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("Title: " + report.getTitle());
            contentStream.newLineAtOffset(0, -40);
            contentStream.showText("Subtitle: " + report.getSubTitle());
            contentStream.newLineAtOffset(0, -40);
            public static final PDType1Font customHelvetica = new PDType1Font("Helvetica");
            contentStream.setFont(customHelvetica, 12);
            contentStream.showText(report.getContent());
            contentStream.newLineAtOffset(0, -40);
            contentStream.showText("Footer: " + report.getFooter());
            contentStream.endText();
            document.save(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return out.toByteArray();
    }
}
