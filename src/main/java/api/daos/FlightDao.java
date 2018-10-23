package api.daos;

import api.entities.Flight;

import java.util.List;

public interface FlightDao extends GenericDao<Flight, String> {
    List<Flight> findByPassengerNotEmpty();
}
