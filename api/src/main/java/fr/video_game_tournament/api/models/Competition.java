package fr.video_game_tournament.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
