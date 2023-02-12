package fr.video_game_tournament.api.repositories;

import fr.video_game_tournament.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

    Optional<User> findByEmail(String email);

  /*  @Override
    List<User> findAll(Sort sort);*/

}
