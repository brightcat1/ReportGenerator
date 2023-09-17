package reportgenerator.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public class HTMLDownloader implements ReportDownloader {
    @Override
    public ResponseEntity<byte[]> downloadReport(byte[] reportData) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "text/html");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.html");
        return ResponseEntity.ok().headers(headers).body(reportData);
    }
}
