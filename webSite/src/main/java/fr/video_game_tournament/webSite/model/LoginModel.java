package fr.video_game_tournament.webSite.model;


import lombok.Data;
@Data
public class LoginModel {


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginModel() {
        super();
    }

    private String username;
    private String password;


    @Override
    public String toString() {
        return "LoginModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
