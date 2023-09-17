package reportgenerator.utils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class ReportDownloader {
    public ResponseEntity<byte[]> downloadAsPdf(byte[] reportData){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf");
        return ResponseEntity.ok().headers(headers).body(reportData);
    }

    public ResponseEntity<byte[]> downloadAsHtml(byte[] reportData) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "text/html");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.html");
        return ResponseEntity.ok().headers(headers).body(reportData);
    }

    public ResponseEntity<byte[]> downloadAsTxt(byte[] reportData) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "text/plain");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.txt");
        return ResponseEntity.ok().headers(headers).body(reportData);
    }
}
