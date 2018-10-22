package api;

import api.apiControllers.ReportApiController;
import api.dtos.ReportDto;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReportIT {

    @Test
    void testCreateCaptain() {
        HttpRequest request = HttpRequest.builder(ReportApiController.REPORT).body(new ReportDto(false, "Mejorable...")).post();
        new Client().submit(request);
    }

    @Test
    void createReportWithoutReportDto() {
        HttpRequest request = HttpRequest.builder(ReportApiController.REPORT).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void createReportWithoutReportDtoSafeLanding() {
        HttpRequest request = HttpRequest.builder(ReportApiController.REPORT).body(new ReportDto(null, "Mejorable...")).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

}
