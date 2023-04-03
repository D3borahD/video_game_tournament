package fr.video_game_tournament.webSite.repository;

import fr.video_game_tournament.webSite.CustomProperties;
import fr.video_game_tournament.webSite.model.Competition;
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
public class CompetitionInterface {

    @Autowired
    private CustomProperties props;

    /**
     * Get all Competition
     * @return An iterable of all Competition
     */
    public Iterable<Competition> getCompetitions(){
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/competitions";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Competition>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Competition>>() {
                }
        );
        log.debug("Get Conference Call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Get a Competition by the id
     * @param id The id of the Competition
     * @return The Competition which matches the id
     */
    public Competition getCompetition(int id) {
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/competitions/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Competition> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                Competition.class
        );

        log.debug("Get Competition call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Add a new Competition
     * @param c A new Competition (without an id)
     * @return The Competition full filled (with an id)
     */
    public Competition createCompetition(Competition c){
        String baseApiUrl = props.getApiUrl();
        String createUrl = baseApiUrl + "/competitions";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Competition> request = new HttpEntity<Competition>(c);
        ResponseEntity<Competition> response = restTemplate.exchange(
                createUrl,
                HttpMethod.POST,
                request,
                Competition.class);

        log.debug("Create Competition call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Update a Competition - using the PUT HTTP Method.
     * @param c Existing Competition to update
     */
    public Competition updateCompetition(Competition c) {
        String baseApiUrl = props.getApiUrl();
        String updateUrl = baseApiUrl + "/competitions/" + c.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Competition> request = new HttpEntity<Competition>(c);
        ResponseEntity<Competition> response = restTemplate.exchange(
                updateUrl,
                HttpMethod.PUT,
                request,
                Competition.class);

        log.debug("Update Competition call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Delete a Competition using exchange method of RestTemplate
     * instead of delete method in order to log the response status code.
     * @param id The Competition to delete
     */
    public void deleteCompetition(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteUrl = baseApiUrl + "/competitions/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Competition call " + response.getStatusCode().toString());
    }

}
