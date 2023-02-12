package fr.video_game_tournament.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    //@Column(nullable = false, unique = true)
    private String email;
    //@Column(nullable = false, lenght = 64)
    private String password;
    @Column(name = "role_id")
    private int roleId = 2;
    //private Boolean enabled;




    /*@ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "role_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();*/

}




