package api.entities;

public class Captain {

    private String id;

    private String name;

    private String email;

    public Captain(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public Captain setId(String id) {
        this.id = id;
        return this;
    }

    public String getNick() {
        return name;
    }

    public Captain setNick(String nick) {
        this.name = nick;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
