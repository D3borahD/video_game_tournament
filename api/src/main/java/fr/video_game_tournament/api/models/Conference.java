package fr.video_game_tournament.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "conference")
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name="user_id")
    private int userId;

    private String description;

}
