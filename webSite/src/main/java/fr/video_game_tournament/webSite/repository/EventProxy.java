package fr.video_game_tournament.webSite.repository;

import fr.video_game_tournament.webSite.CustomProperties;
import fr.video_game_tournament.webSite.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class EventProxy {

    @Autowired
    private CustomProperties props;


    /**
     * Get all events
     * @return An iterable of all event
     */
    public Iterable<Event> getEvents(){
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/events";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Event>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Event>>() {
                }
        );
        log.debug("Get Event Call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Get an event by the id
     * @param id The id of the event
     * @return The event which matches the id
     */
    public Event getEvent(int id) {
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/events/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Event> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                Event.class
        );

        log.debug("Get Event call " + response.getStatusCode().toString());

        return response.getBody();
    }


    /**
     * Add a new event
     * @param e A new event (without an id)
     * @return The event full filled (with an id)
     */
    public Event createEvent(Event e){
        String baseApiUrl = props.getApiUrl();
        String createUrl = baseApiUrl + "/events";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Event> request = new HttpEntity<Event>(e);
        ResponseEntity<Event> response = restTemplate.exchange(
                createUrl,
                HttpMethod.POST,
                request,
                Event.class);

        log.debug("Create Event call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Update an event - using the PUT HTTP Method.
     * @param e Existing event to update
     */
    public Event updateEvent(Event e) {
        String baseApiUrl = props.getApiUrl();
        String updateUrl = baseApiUrl + "/events/" + e.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Event> request = new HttpEntity<Event>(e);
        ResponseEntity<Event> response = restTemplate.exchange(
                updateUrl,
                HttpMethod.PUT,
                request,
                Event.class);

        log.debug("Update Event call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Delete an event using exchange method of RestTemplate
     * instead of delete method in order to log the response status code.
     * @param id The event to delete
     */
    public void deleteEvent(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteUrl = baseApiUrl + "/events/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Event call " + response.getStatusCode().toString());
    }
}
