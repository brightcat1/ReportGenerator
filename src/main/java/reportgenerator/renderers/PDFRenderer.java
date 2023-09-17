package reportgenerator.renderers;

import org.springframework.stereotype.Component;
import reportgenerator.models.Report;
@Component
public class PDFRenderer implements ReportRenderer{
    @Override
    public byte[] render(Report report) {
        return new byte[0];
    }
}
