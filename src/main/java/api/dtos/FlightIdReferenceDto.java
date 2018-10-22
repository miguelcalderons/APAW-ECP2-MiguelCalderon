package api.dtos;

import api.entities.Flight;

public class FlightIdReferenceDto {

    private String id;

    private String destination;

    public FlightIdReferenceDto(Flight flight) {
        this.id = flight.getId();
        this.destination = flight.getDestination();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
