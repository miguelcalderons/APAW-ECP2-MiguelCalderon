package api.dtos;

public class ReportDto {

    private Boolean safeLanding;

    private String description;

    public ReportDto(Boolean safeLanding, String description) {
        this.safeLanding = safeLanding;
        this.description = description;
    }

    public Boolean getSafeLanding() {
        return safeLanding;
    }

    public void setNegative(Boolean negative) {
        this.safeLanding = negative;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
