package api.entities;

public class Passenger {

    private String id;

    private String name;

    private String email;

    private boolean firstClass;

    public Passenger(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public Passenger setId(String id) {
        this.id = id;
        return this;
    }

    public String getNick() {
        return name;
    }

    public Passenger setNick(String nick) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
