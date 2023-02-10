package fr.video_game_tournament.webSite.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Competition {

    private Integer id;
    private String name;
    private int nbPlayerByTeam;
    private int maxTeam;
    private int eventId;
    private int videoGameId;
    private List<Team> teams = new ArrayList<>();

}
