package reportgenerator.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reportgenerator.models.Report;
import reportgenerator.renderers.ReportRenderer;
import reportgenerator.utils.ReportDownloader;

@RestController
public class ReportController {

    private final ReportRenderer htmlRenderer;
    private final ReportRenderer textRenderer;


    private final ReportDownloader htmlDownloader;
    private final ReportDownloader textDownloader;

    public ReportController(
            @Qualifier("htmlRenderer") ReportRenderer htmlRenderer,
            @Qualifier("textRenderer") ReportRenderer textRenderer,
            @Qualifier("htmlDownloader") ReportDownloader htmlDownloader,
            @Qualifier("textDownloader") ReportDownloader textDownloader) {
        this.htmlRenderer = htmlRenderer;
        this.textRenderer = textRenderer;
        this.htmlDownloader = htmlDownloader;
        this.textDownloader = textDownloader;
    }

    @PostMapping("/download/report/html")
    @ResponseBody
    public ResponseEntity<byte[]> downloadReportAsHtml(@RequestBody ReportRequest reportRequest) {
        try {
            return generateReport(reportRequest, htmlRenderer, htmlDownloader);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/download/report/text")
    @ResponseBody
    public ResponseEntity<byte[]> downloadReportAsText(@RequestBody ReportRequest reportRequest) {
        try {
            return generateReport(reportRequest, textRenderer, textDownloader);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private ResponseEntity<byte[]> generateReport(ReportRequest reportRequest, ReportRenderer renderer, ReportDownloader downloader) {
        Report renderReport = new Report.Builder()
                .title(reportRequest.getTitle())
                .subTitle(reportRequest.getSubTitle())
                .content(reportRequest.getContent())
                .footer(reportRequest.getFooter())
                .build();
        byte[] reportData = renderer.render(renderReport);
        return downloader.downloadReport(reportData);
    }

    public static class ReportRequest {
        private final String title;
        private final String subTitle;
        private final String content;
        private final String footer;

        @JsonCreator
        public ReportRequest(
                @JsonProperty("title") String title,
                @JsonProperty("subTitle") String subTitle,
                @JsonProperty("content") String content,
                @JsonProperty("footer") String footer) {
            this.title = title;
            this.subTitle = subTitle;
            this.content = content;
            this.footer = footer;
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
