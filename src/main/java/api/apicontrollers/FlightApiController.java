package api.apicontrollers;

import api.businesscontroller.FlightBusinessController;
import api.dtos.FlightCreationDto;
import api.dtos.FlightIdReferenceDto;
import api.entities.Weather;
import api.exceptions.ArgumentNotValidException;

import java.util.List;

public class FlightApiController {
    public static final String FLIGHTS = "/flights";

    public static final String ID_ID = "/{id}";

    public static final String PASSENGER = "/passengers";

    public static final String AVERAGE = "/average";

    public static final String WEATHER = "/weather";

    public static final String SEARCH = "/search";

    private FlightBusinessController flightBusinessController = new FlightBusinessController();

    public String create(FlightCreationDto themeDto) {
        this.validate(themeDto, "themeDto");
        this.validate(themeDto.getReference(), "themeDto reference");
        return this.flightBusinessController.create(themeDto);
    }

    public List<FlightIdReferenceDto> readAll() {
        return this.flightBusinessController.readAll();
    }

    public void delete(String id) {
        this.flightBusinessController.delete(id);
    }

    public void createPassenger(String flightId, Integer passenger) {
        this.validate(passenger, "passenger");
        if (passenger < 0 || passenger > 100) {
            throw new ArgumentNotValidException("passenger is between 0 and 100");
        }
        this.flightBusinessController.createPassenger(flightId, passenger);
    }

    public Double readAverage(String flightId) {
        return this.flightBusinessController.readAverage(flightId);
    }

    public void updateWeather(String flightId, Weather weather) {
        this.validate(weather, "weather");
        this.flightBusinessController.updateWeather(flightId, weather);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }

    public List<FlightIdReferenceDto> find(String query) {
        this.validate(query, "query param q");
        if (!"average".equals(query.split(":>=")[0])) {
            throw new ArgumentNotValidException("query param q is incorrect, missing 'average:>='");
        }
        return this.flightBusinessController.findByAverageGreaterThanEqual(Double.valueOf(query.split(":>=")[1]));
    }
}
