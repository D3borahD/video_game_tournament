package fr.video_game_tournament.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

/*    @OneToMany(
            fetch = FetchType.LAZY,
            // ON DELETE and ON UPDATE => SET NULL
            cascade={CascadeType.PERSIST}
            // DELETE on cascade
            //cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id")
    private List<User> users = new ArrayList<>();*/

}
