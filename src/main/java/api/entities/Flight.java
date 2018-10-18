package api.entities;

import java.time.LocalDateTime;

public class Flight {

    private String noFlight;

    private String destination;

    private LocalDateTime date;

    private Weather weather;

    private Passenger passenger;

    private Captain captain;

    public Flight(String destination) {
        this.destination = destination;
        this.date = LocalDateTime.now();
    }

    public static Builder builder(String noFlight, String destination) {
        return new Builder(destination);
    }

    public String getnoFlight() {
        return noFlight;
    }

    public void setnoFlight(String noFlight) {
        this.noFlight = noFlight;
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

    public Passenger getPassenger() {
        return passenger;
    }

    public static class Builder {
        private Flight theme;

        private Builder(String destination) {
            this.theme = new Flight(destination);
        }

        public Builder noFlight(String noFlight) {
            this.theme.noFlight = noFlight;
            return this;
        }

        public Builder weather(Weather weather) {
            this.theme.weather = weather;
            return this;
        }

        public Builder user(Captain captain) {
            this.theme.captain = captain;
            return this;
        }


        public Flight build() {
            return this.theme;
        }
    }
}
