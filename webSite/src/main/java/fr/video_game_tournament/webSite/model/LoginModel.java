package fr.video_game_tournament.webSite.model;

import lombok.Data;


@Data
public class LoginModel {

    private String email;
    //@NotNull
    //@Size(min =8, max = 15, message = "Le mot de passe doit contenir entre 8 et 15 charactères")
    private String password;

    public LoginModel() {
        super();
    }

    public LoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
