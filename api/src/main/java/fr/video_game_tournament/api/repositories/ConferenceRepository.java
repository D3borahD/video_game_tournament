package fr.video_game_tournament.api.repositories;

import fr.video_game_tournament.api.models.Conference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends CrudRepository<Conference, Integer> {

}
