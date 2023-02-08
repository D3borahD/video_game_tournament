package fr.video_game_tournament.webSite.service;

import fr.video_game_tournament.webSite.model.Event;
import fr.video_game_tournament.webSite.repository.EventInterface;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EventService {

    @Autowired
    private EventInterface eventInterface;


    public void test() {
        System.out.println("test");
    };



    // future methods

    // searchEvents(String searchTerm


    public Event getEvent(final int id){
        return eventInterface.getEvent(id);
    }

    public Iterable<Event> getEvents() {
        return eventInterface.getEvents();
    }

    public void deleteEvent(final int id) {
        eventInterface.deleteEvent(id);;
    }


    public Event saveEvent(Event event) {
        Event savedEvent;

        // Functional rule : name must be capitalized.
        event.setName(event.getName().toUpperCase());

        if(event.getId() == null) {
            savedEvent = eventInterface.createEvent(event);
        } else {
            savedEvent = eventInterface.updateEvent(event);
        }
        return savedEvent;
    }
}
