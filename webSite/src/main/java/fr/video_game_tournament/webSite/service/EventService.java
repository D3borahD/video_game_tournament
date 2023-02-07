package fr.video_game_tournament.webSite.service;

import fr.video_game_tournament.webSite.model.Event;
import fr.video_game_tournament.webSite.repository.EventProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EventService {

    @Autowired
    private EventProxy eventProxy;


    public void test() {
        System.out.println("test");
    };



    // future methods

    // searchEvents(String searchTerm


    public Event getEvent(final int id){
        return eventProxy.getEvent(id);
    }

    public Iterable<Event> getEvents() {
        return eventProxy.getEvents();
    }

    public void deleteEvent(final int id) {
        eventProxy.deleteEvent(id);;
    }


    public Event saveEvent(Event event) {
        Event savedEvent;

        // Functional rule : name must be capitalized.
        event.setName(event.getName().toUpperCase());

        if(event.getId() == null) {
            savedEvent = eventProxy.createEvent(event);
        } else {
            savedEvent = eventProxy.updateEvent(event);
        }
        return savedEvent;
    }
}
