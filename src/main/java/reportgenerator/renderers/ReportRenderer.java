package reportgenerator.renderers;

import reportgenerator.models.Report;

public interface ReportRenderer {
    byte[] render(Report report);

}
