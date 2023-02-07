package fr.video_game_tournament.webSite.model;

import lombok.Data;

@Data
public class User {

    private Integer id;

    private String firstname;

    private String lastname;

    private String phoneNumber;

    private String email;

    private  String password;

    private Boolean enabled;

    private String username;
}
