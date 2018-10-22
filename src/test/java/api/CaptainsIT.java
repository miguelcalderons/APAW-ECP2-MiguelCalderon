package api;

import api.apiControllers.CaptainApiController;
import api.dtos.CaptainDto;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CaptainsIT {

    @Test
    void testCreateCaptain() {
        this.createCaptain();
    }

    private String createCaptain() {
        HttpRequest request = HttpRequest.builder(CaptainApiController.CAPTAINS).body(new CaptainDto("uno","uno@email")).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testCaptainInvalidRequest() {
        HttpRequest request = HttpRequest.builder(CaptainApiController.CAPTAINS).path("/invalid").body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateCaptainWithoutCaptainDto() {
        HttpRequest request = HttpRequest.builder(CaptainApiController.CAPTAINS).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateCaptainWithoutCaptainDtoNick() {
        HttpRequest request = HttpRequest.builder(CaptainApiController.CAPTAINS).body(new CaptainDto(null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdateCaptain() {
        String id = this.createCaptain();
        HttpRequest request = HttpRequest.builder(CaptainApiController.CAPTAINS).path(CaptainApiController.ID_ID)
                .expandPath(id).body(new CaptainDto("dos")).put();
        new Client().submit(request);
    }

    @Test
    void testUpdateCaptainWithoutCaptainDto() {
        String id = this.createCaptain();
        HttpRequest request = HttpRequest.builder(CaptainApiController.CAPTAINS).path(CaptainApiController.ID_ID)
                .expandPath(id).body(null).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdateCaptainNotFoundException() {
        HttpRequest request = HttpRequest.builder(CaptainApiController.CAPTAINS).path(CaptainApiController.ID_ID)
                .expandPath("s5FdeGf54D").body(new CaptainDto("dos")).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }
}
