package api.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {

    private String id;

    private String destination;

    private LocalDateTime date;

    private Weather weather;

    private Captain captain;

    private List<Passenger> passengers;

    public Flight(String destination) {
        this.destination = destination;
        this.date = LocalDateTime.now();
        this.passengers = new ArrayList<>();
    }

    public static Builder builder(String destination) {
        return new Builder(destination);
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

    public LocalDateTime getDate() {
        return date;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Captain getCaptain() {
        return captain;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                ", weather=" + weather +
                ", captain=" + captain +
                ", passengers=" + passengers +
                '}';
    }

    public static class Builder {
        private Flight flight;

        private Builder(String destination) {
            this.flight = new Flight(destination);
        }

        public Builder id(String id) {
            this.flight.id = id;
            return this;
        }

        public Builder weather(Weather weather) {
            this.flight.weather = weather;
            return this;
        }

        public Builder user(Captain captain) {
            this.flight.captain = captain;
            return this;
        }

        public Builder passenger(Passenger passenger) {
            this.flight.passengers.add(passenger);
            return this;
        }

        public Flight build() {
            return this.flight;
        }
    }
}
