package reportgenerator.utils;

import org.springframework.http.ResponseEntity;

public interface Downloader {
    public ResponseEntity<byte[]> downloadReport(byte[] reportData);
}
