package api;

import api.apicontrollers.FlightApiController;
import api.apicontrollers.CaptainApiController;
import api.dtos.CaptainDto;
import api.dtos.FlightCreationDto;
import api.entities.Weather;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightIT {

    @Test
    void testCreateFlight() {
        this.createFlight("Flight one");
    }

    private String createFlight(String flight) {
        String CaptainId = this.createCaptain();
        HttpRequest request = HttpRequest.builder(FlightApiController.FLIGHTS)
                .body(new FlightCreationDto(flight, Weather.WINDY, CaptainId)).post();
        return (String) new Client().submit(request).getBody();
    }

    private String createCaptain() {
        HttpRequest request = HttpRequest.builder(CaptainApiController.CAPTAINS).body(new CaptainDto("uno","uno@email")).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testCreateFlightCaptainIdIdNotFound() {
        HttpRequest request = HttpRequest.builder(FlightApiController.FLIGHTS)
                .body(new FlightCreationDto("Flight one", Weather.WINDY, "h3rFdEsw")).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }

    @Test
    void testCreateFlightWithoutWeatherCaptainId() {
        HttpRequest request = HttpRequest.builder(FlightApiController.FLIGHTS)
                .body(new FlightCreationDto("Flight one", null, null)).post();
        new Client().submit(request);
    }
}
