package reportgenerator.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component("textDownloader")
public class TextDownloader implements ReportDownloader {
    @Override
    public ResponseEntity<byte[]> downloadReport(byte[] reportData) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "text/plain");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.txt");
        return ResponseEntity.ok().headers(headers).body(reportData);
    }
}
