package fr.video_game_tournament.api.services;

import fr.video_game_tournament.api.models.Event;
import fr.video_game_tournament.api.repositories.EventRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Optional<Event> getEventById(final int id){
        return eventRepository.findById(id);
    }

    public Iterable<Event> getEvents(){
        return eventRepository.findAll();
    }

    public void deleteEvent(final int id){
        eventRepository.deleteById(id);
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
}
