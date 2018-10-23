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

    public String getname() {
        return name;
    }

    public Captain setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Captain{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
