package fr.video_game_tournament.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "conference")
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private LocalTime time;

    private String description;

}
