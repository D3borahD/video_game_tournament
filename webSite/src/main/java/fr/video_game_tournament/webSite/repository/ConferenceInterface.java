package fr.video_game_tournament.webSite.repository;

import fr.video_game_tournament.webSite.CustomProperties;
import fr.video_game_tournament.webSite.model.Conference;
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
public class ConferenceInterface {

    @Autowired
    private CustomProperties props;

    /**
     * Get all events
     * @return An iterable of all Conference
     */
    public Iterable<Conference> getConferences(){
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/conferences";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Conference>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Conference>>() {
                }
        );
        log.debug("Get Conference Call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Get an Conference by the id
     * @param id The id of the Conference
     * @return The Conference which matches the id
     */
    public Conference getConference(int id) {
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/conferences/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Conference> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                Conference.class
        );

        log.debug("Get Conference call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Add a new Conference
     * @param c A new Conference (without an id)
     * @return The eConference full filled (with an id)
     */
    public Conference createConference(Conference c){
        String baseApiUrl = props.getApiUrl();
        String createUrl = baseApiUrl + "/conferences";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Conference> request = new HttpEntity<Conference>(c);
        ResponseEntity<Conference> response = restTemplate.exchange(
                createUrl,
                HttpMethod.POST,
                request,
                Conference.class);

        log.debug("Create Conference call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Update an Conference - using the PUT HTTP Method.
     * @param c Existing Conference to update
     */
    public Conference updateConference(Conference c) {
        String baseApiUrl = props.getApiUrl();
        String updateUrl = baseApiUrl + "/conferences/" + c.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Conference> request = new HttpEntity<Conference>(c);
        ResponseEntity<Conference> response = restTemplate.exchange(
                updateUrl,
                HttpMethod.PUT,
                request,
                Conference.class);

        log.debug("Update Conference call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Delete a Conference using exchange method of RestTemplate
     * instead of delete method in order to log the response status code.
     * @param id The Conference to delete
     */
    public void deleteConference(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteUrl = baseApiUrl + "/conferences/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Conference call " + response.getStatusCode().toString());
    }

}
