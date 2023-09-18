import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reportgenerator.controller.ReportController;
import reportgenerator.models.Report;
import reportgenerator.renderers.ReportRenderer;
import reportgenerator.utils.ReportDownloader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class ReportControllerTest {

    @InjectMocks
    private ReportController reportController;

    @Mock
    private ReportRenderer htmlRenderer;

    @Mock
    private ReportRenderer textRenderer;

    @Mock
    private ReportDownloader htmlDownloader;

    @Mock
    private ReportDownloader textDownloader;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        reportController = new ReportController(htmlRenderer, textRenderer, htmlDownloader, textDownloader);
    }

    @AfterEach
    public void tearDown() {
        Mockito.reset(htmlRenderer, htmlDownloader, textRenderer, textDownloader);
    }

    @Test
    void testDownloadReportAsHtml() {
        ReportController.ReportRequest request = new ReportController.ReportRequest("Test Title", "Test SubTitle", "Test Content", "Test Footer");

        byte[] mockReportData = "Test HTML Report".getBytes();

        ArgumentCaptor<Report> reportCaptor = ArgumentCaptor.forClass(Report.class);
        when(htmlRenderer.render(reportCaptor.capture())).thenReturn(mockReportData);
        when(htmlDownloader.downloadReport(mockReportData)).thenReturn(ResponseEntity.ok(mockReportData));

        ResponseEntity<byte[]> response = reportController.downloadReportAsHtml(request);

        Report capturedReport = reportCaptor.getValue();
        assertEquals("Test Title", capturedReport.getTitle());
        assertEquals("Test SubTitle", capturedReport.getSubTitle());
        assertEquals("Test Content", capturedReport.getContent());
        assertEquals("Test Footer", capturedReport.getFooter());

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Test HTML Report", new String(response.getBody()));
    }

    @Test
    void testDownloadReportAsText() {
        ReportController.ReportRequest request = new ReportController.ReportRequest("Test Title", "Test SubTitle", "Test Content", "Test Footer");

        byte[] mockReportData = "Test Text Report".getBytes();

        ArgumentCaptor<Report> reportCaptor = ArgumentCaptor.forClass(Report.class);
        when(textRenderer.render(reportCaptor.capture())).thenReturn(mockReportData);
        when(textDownloader.downloadReport(mockReportData)).thenReturn(ResponseEntity.ok(mockReportData));

        ResponseEntity<byte[]> response = reportController.downloadReportAsText(request);

        Report capturedReport = reportCaptor.getValue();
        assertEquals("Test Title", capturedReport.getTitle());
        assertEquals("Test SubTitle", capturedReport.getSubTitle());
        assertEquals("Test Content", capturedReport.getContent());
        assertEquals("Test Footer", capturedReport.getFooter());

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Test Text Report", new String(response.getBody()));
    }
}