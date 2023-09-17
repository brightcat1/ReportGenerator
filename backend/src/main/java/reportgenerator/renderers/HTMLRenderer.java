package reportgenerator.renderers;

import org.springframework.stereotype.Component;
import reportgenerator.models.Report;
@Component("htmlRenderer")
public class HTMLRenderer implements ReportRenderer {

    @Override
    public byte[] render(Report report) {
        StringBuilder html = new StringBuilder();
        html.append("<html><head><title>")
                .append(report.getTitle())
                .append("</title></head><body>")
                .append("<h1>").append(report.getTitle()).append("</h1>")
                .append("<h2>").append(report.getSubTitle()).append("</h2>")
                .append("<p>").append(report.getContent()).append("</p>")
                .append("<footer>").append(report.getFooter()).append("</footer>")
                .append("</body></html>");
        return html.toString().getBytes();
    }
}
