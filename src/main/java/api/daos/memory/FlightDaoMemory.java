package api.daos.memory;

import api.daos.FlightDao;
import api.entities.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightDaoMemory extends GenericDaoMemory<Flight> implements FlightDao {

    @Override
    public String getId(Flight flight) {
        return flight.getId();
    }

    @Override
    public void setId(Flight flight, String id) {
        flight.setId(id);
    }

    @Override
    public List<Flight> findByPassengerNotEmpty() {
        return this.findAll().stream()
                .filter(theme -> !theme.getPassengers().isEmpty())
                .collect(Collectors.toList());
    }
}
