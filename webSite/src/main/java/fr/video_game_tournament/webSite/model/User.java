package fr.video_game_tournament.webSite.model;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private int roleId;
}
