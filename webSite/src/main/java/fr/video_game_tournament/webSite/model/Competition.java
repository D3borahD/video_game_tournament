package fr.video_game_tournament.webSite.model;

import lombok.Data;

@Data
public class Competition {

    private Integer id;
    private String name;
    private int nbPlayerByTeam;
    private int maxTeam;
    private int event_id;

}
