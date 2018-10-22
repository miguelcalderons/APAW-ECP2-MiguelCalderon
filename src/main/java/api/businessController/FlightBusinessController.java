package api.businessController;

import api.daos.DaoFactory;
import api.dtos.FlightCreationDto;
import api.dtos.FlightIdReferenceDto;
import api.entities.Captain;
import api.entities.Passenger;
import api.entities.Weather;
import api.entities.Flight;
import api.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class FlightBusinessController {

    public String create(FlightCreationDto flightCreationDto) {
        Captain captain = null;
        if (flightCreationDto.getCaptainId() != null) {
            captain = DaoFactory.getFactory().getCaptainDao().read(flightCreationDto.getCaptainId())
                    .orElseThrow(() -> new NotFoundException("Captain (" + flightCreationDto.getCaptainId() + ")"));
        }
        Flight flight = Flight.builder(flightCreationDto.getReference()).user(captain).weather(flightCreationDto.getWeather()).build();
        DaoFactory.getFactory().flightDao().save(flight);
        return flight.getId();
    }

    public List<FlightIdReferenceDto> readAll() {
        return DaoFactory.getFactory().flightDao().findAll()
                .stream().map(FlightIdReferenceDto::new)
                .collect(Collectors.toList());
    }

    public void delete(String id) {
        DaoFactory.getFactory().flightDao().deleteById(id);
    }

    public void createPassenger(String name, Integer passenger) {
        Flight flight = DaoFactory.getFactory().flightDao().read(name)
                .orElseThrow(() -> new NotFoundException("Flight (" + name + ")"));
        flight.getPassengers().add(new Passenger(passenger, name));
        DaoFactory.getFactory().flightDao().save(flight);
    }

    public Double readAverage(String flightId) {
        Flight flight = DaoFactory.getFactory().flightDao().read(flightId)
                .orElseThrow(() -> new NotFoundException("Flight (" + flightId + ")"));
        return this.average(flight);
    }

    private Double average(Flight flight) {
        return flight.getPassengers()
                .stream().mapToDouble(Passenger::getValue).average()
                .orElse(Double.NaN);
    }

    public void updateWeather(String flightId, Weather weather) {
        Flight flight = DaoFactory.getFactory().flightDao().read(flightId)
                .orElseThrow(() -> new NotFoundException("Flight (" + flightId + ")"));
        flight.setWeather(weather);
        DaoFactory.getFactory().flightDao().save(flight);
    }

    public List<FlightIdReferenceDto> findByAverageGreaterThanEqual(Double value) {
        return DaoFactory.getFactory().flightDao().findByPassengerNotEmpty().stream()
                .filter(flight -> this.average(flight) >= value)
                .map(FlightIdReferenceDto::new)
                .collect(Collectors.toList());
    }

}
