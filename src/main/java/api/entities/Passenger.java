package api.entities;

public class Passenger {

    private int value;

    private String name;

    private Boolean firstClass;

    public Passenger(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return this.value;
    }

    public String getName() { return this.name; }

    public void setFirstClass(Boolean firstClass) {this.firstClass = firstClass;}

    public Boolean getDate() {
        return this.firstClass;
    }

}
