package reportgenerator.renderers;

import org.springframework.stereotype.Component;
import reportgenerator.models.Report;

@Component
public class TextRenderer implements ReportRenderer {
    @Override
    public byte[] render(Report report) {
        StringBuilder text = new StringBuilder();
        text.append("=== " + report.getTitle() + " ===\n")
                .append("--- " + report.getSubTitle() + " ---\n")
                .append(report.getContent() + "\n")
                .append("(c) " + report.getFooter());

        return text.toString().getBytes();
    }
}
