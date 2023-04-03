package fr.video_game_tournament.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private LocalDate date;
    private String address;

    @OneToMany(
            fetch = FetchType.LAZY,
            // ON DELETE and ON UPDATE => SET NULL
            cascade={CascadeType.PERSIST}
            // DELETE on cascade
            //cascade = CascadeType.ALL
    )
    @JoinColumn(name = "event_id")
    private List<Conference> conferences = new ArrayList<>();

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade={CascadeType.PERSIST}
    )
    @JoinColumn(name = "event_id")
    private List<Competition> competitions = new ArrayList<>();

  /*  @OneToMany(
            fetch = FetchType.LAZY,
            cascade={CascadeType.PERSIST}
    )
    @JoinColumn(name = "event_id")
    private List<Team> teams = new ArrayList<>();*/
}
