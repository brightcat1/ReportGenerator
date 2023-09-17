package reportgenerator.utils;

import org.springframework.http.ResponseEntity;

public interface ReportDownloader {
    public ResponseEntity<byte[]> downloadReport(byte[] reportData);
}
