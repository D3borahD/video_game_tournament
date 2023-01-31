package fr.video_game_tournament.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    //list of player ...
    //@Column(name="player_id")
    //private int playerId;



    //private String image;
}
