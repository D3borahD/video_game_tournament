package fr.video_game_tournament.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "video_game")
public class VideoGame {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

}
