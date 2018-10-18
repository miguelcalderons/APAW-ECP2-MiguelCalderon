package api.entities;

public class Report {

    private String id;

    private Boolean safeLanding;

    private String message;

    public Report(Boolean safeLanding, String message) {
        this.safeLanding = safeLanding;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getSafeFlight() {
        return safeLanding;
    }

    public String getMessage() {
        return message;
    }
}
