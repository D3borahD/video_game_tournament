package fr.video_game_tournament.webSite.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Team {
    private Integer id;
    private String name;
    private int ranking;
    private int competitionId;
    private List<User> users = new ArrayList<>();
}
