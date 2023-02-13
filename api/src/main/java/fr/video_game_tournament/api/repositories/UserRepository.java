package fr.video_game_tournament.api.repositories;

import fr.video_game_tournament.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);
}
