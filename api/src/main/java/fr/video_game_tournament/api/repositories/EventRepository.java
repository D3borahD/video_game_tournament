package fr.video_game_tournament.api.repositories;

import fr.video_game_tournament.api.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
}
