package reportgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import reportgenerator.models.Report;
import reportgenerator.renderers.ReportRenderer;
import reportgenerator.utils.ReportDownloader;

public class ReportController {
    @Autowired
    private ReportDownloader reportDownloader;


    @GetMapping("/download/report/pdf")
    @ResponseBody
    public ResponseEntity<byte[]> downloadReportAsPdf(@RequestBody ReportRequest reportRequest, @Qualifier("pdfRenderer") ReportRenderer reportRenderer) {
        Report renderReport = new Report.Builder(reportRequest.getFileFormat()).title(reportRequest.getTitle()).subTitle(reportRequest.getSubTitle()).content(reportRequest.getContent()).footer(reportRequest.getFooter()).build();
        byte[] reportData = reportRenderer.render(renderReport);
        return reportDownloader.downloadAsPdf(reportData);
    }

    @GetMapping("/download/report/html")
    @ResponseBody
    public ResponseEntity<byte[]> downloadReportAsHtml(@RequestBody ReportRequest reportRequest, @Qualifier("htmlRenderer") ReportRenderer reportRenderer) {
        Report renderReport = new Report.Builder(reportRequest.getFileFormat()).title(reportRequest.getTitle()).subTitle(reportRequest.getSubTitle()).content(reportRequest.getContent()).footer(reportRequest.getFooter()).build();
        byte[] reportData = reportRenderer.render(renderReport);
        return reportDownloader.downloadAsPdf(reportData);
    }

    @GetMapping("/download/report/text")
    @ResponseBody
    public ResponseEntity<byte[]> downloadReportAsText(@RequestBody ReportRequest reportRequest, @Qualifier("textRenderer") ReportRenderer reportRenderer) {
        Report renderReport = new Report.Builder(reportRequest.getFileFormat()).title(reportRequest.getTitle()).subTitle(reportRequest.getSubTitle()).content(reportRequest.getContent()).footer(reportRequest.getFooter()).build();
        byte[] reportData = reportRenderer.render(renderReport);
        return reportDownloader.downloadAsPdf(reportData);
    }
    public static class ReportRequest {
        private String fileFormat;
        private String title;
        private String subTitle;
        private String content;
        private String footer;

        public String getFileFormat() {
            return fileFormat;
        }

        public String getTitle() {
            return title;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public String getContent() {
            return content;
        }

        public String getFooter() {
            return footer;
        }

    }
}
