package fr.video_game_tournament.api.controllers;

import fr.video_game_tournament.api.models.Event;
import fr.video_game_tournament.api.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    /**
     * Create - Add a new event
     * @param event An object event
     * @return The event object saved
     */
    @PostMapping("events")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "created a new resource")
    public Event createRole(@RequestBody Event event){
        return eventService.saveEvent(event);
    }

    /**
     * Read - Get all Event
     * @return - An Iterable object of Event full filled
     */
    @GetMapping("events")
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<Event> getCompetition(){
        return eventService.getEvents();
    }

    /**
     * Read - Get one Event
     * @param id The id of the Event
     * @return A Event object full filled
     */
    @GetMapping("events/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Event getEventById(@PathVariable("id") final int id) {
        Optional<Event> event = eventService.getEventById(id);
        if(event.isPresent()){
            return event.get();
        }
        else {
            return null;
        }
    }

    /**
     * Update - Update an existing Event
     * @param id - The id of the Event to update
     * @param event - The Event object updated
     * @return current Event
     */
    @PutMapping("/events/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Event update(@PathVariable("id") final int id, @RequestBody Event event){
        Optional<Event> r = eventService.getEventById(id);
        if(r.isPresent()) {
            Event currentEvent = r.get();

            String name = event.getName();
            if(name != null){
                currentEvent.setName(name);
            }
            LocalDateTime date = event.getDate();
            if(date != null){
                currentEvent.setDate(date);
            }
            String address = event.getAddress();
            if(address != null){
                currentEvent.setAddress(address);
            }
            eventService.saveEvent(currentEvent);
            return currentEvent;
        }
        else {
            return null;
        }
    }

    /**
     * Delete - Delete a Event
     * @param id - The id of the event to delete
     */
    @DeleteMapping("/events/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "resource deleted successfully")
    public void deleteEvent(@PathVariable("id") final int id){
        eventService.deleteEvent(id);
    }

}
