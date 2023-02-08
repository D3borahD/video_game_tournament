package fr.video_game_tournament.webSite.model;

import lombok.Data;

import java.time.LocalTime;

@Data
public class Conference {

    private Integer id;
    private String name;
    private LocalTime time;
    private String description;
    private int event_id;
}
