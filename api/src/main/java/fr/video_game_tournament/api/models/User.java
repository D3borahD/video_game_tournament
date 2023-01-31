package fr.video_game_tournament.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstname;
    private String lastname;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;


}
