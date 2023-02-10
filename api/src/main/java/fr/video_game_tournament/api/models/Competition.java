package fr.video_game_tournament.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name="nb_player_by_team")
    private int nbPlayerByTeam;
    @Column(name="max_team")
    private int maxTeam;

    @Column(name="event_id")
    private int eventId;


    @OneToMany(
            fetch = FetchType.LAZY,
            cascade={CascadeType.PERSIST}
    )
    @JoinColumn(name = "competition_id")
    private List<Team> teams = new ArrayList<>();

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "video_game_competition",
            joinColumns = @JoinColumn(name = "competition_id"),
            inverseJoinColumns = @JoinColumn(name = "video_game_id")
    )
    private List<VideoGame> videoGames = new ArrayList<>();

}
