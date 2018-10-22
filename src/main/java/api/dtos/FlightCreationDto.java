package api.dtos;

import api.entities.Weather;

public class FlightCreationDto {

    private String reference;

    private Weather weather;

    private String captainId;

    public FlightCreationDto(String reference, Weather weather, String userId) {
        this.reference = reference;
        this.weather = weather;
        this.captainId = userId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String getCaptainId() {
        return captainId;
    }

    public void setUserId(String userId) {
        this.captainId = userId;
    }

    @Override
    public String toString() {
        return "FlightCreationDto{" +
                "reference='" + reference + '\'' +
                ", weather=" + weather +
                ", userId='" + captainId + '\'' +
                '}';
    }
}
