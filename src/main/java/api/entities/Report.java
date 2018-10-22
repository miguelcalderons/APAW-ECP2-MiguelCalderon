package api.entities;

import java.time.LocalDateTime;

public class Report {

    private String id;

    private Boolean safeLanding;

    private String description;

    private LocalDateTime date;

    public Report(Boolean safeLanding, String description) {
        this.safeLanding = safeLanding;
        this.description = description;
        this.date = LocalDateTime.now();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {return this.date;}

    public Boolean getSafeLanding() {
        return this.safeLanding;
    }

    public String getDescription() {
        return this.description;
    }
}
