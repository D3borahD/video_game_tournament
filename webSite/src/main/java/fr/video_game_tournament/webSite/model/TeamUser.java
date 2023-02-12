package fr.video_game_tournament.webSite.model;

import lombok.Data;

@Data
public class TeamUser {
    private Integer id;
    private User user;
    private Team Team;

}
