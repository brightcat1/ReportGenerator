package reportgenerator.renderers;

import org.springframework.stereotype.Component;
import reportgenerator.models.Report;
@Component
public class TextRenderer implements ReportRenderer{
    @Override
    public byte[] render(Report report) {
        return new byte[0];
    }
}
