package api.dtos;

public class CaptainDto {

    private String nick;

    private String email;

    public CaptainDto(String nick, String email) {
        this.nick = nick;
        this.email = email;
    }

    public CaptainDto(String nick) {
        this(nick,null);
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CaptainDto{" +
                "nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
