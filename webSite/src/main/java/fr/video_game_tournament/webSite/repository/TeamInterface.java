package fr.video_game_tournament.webSite.repository;

import fr.video_game_tournament.webSite.CustomProperties;
import fr.video_game_tournament.webSite.model.Team;
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
public class TeamInterface {
    @Autowired
    private CustomProperties props;

    /**
     * Get all teams
     * @return An iterable of all teams
     */
    public Iterable<Team> getTeams(){
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/teams";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Team>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Team>>() {
                }
        );
        log.debug("Get Team Call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Get a team by the id
     * @param id The id of the team
     * @return The team which matches the id
     */
    public Team getTeam(int id) {
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/teams/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Team> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                Team.class
        );

        log.debug("Get Team call " + response.getStatusCode().toString());

        return response.getBody();
    }


    /**
     * Add a new team
     * @param t A new team (without an id)
     * @return The team full filled (with an id)
     */
    public Team createTeam(Team t){
        String baseApiUrl = props.getApiUrl();
        String createUrl = baseApiUrl + "/teams";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Team> request = new HttpEntity<Team>(t);
        ResponseEntity<Team> response = restTemplate.exchange(
                createUrl,
                HttpMethod.POST,
                request,
                Team.class
        );

        log.debug("Create Team call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Update a team - using the PUT HTTP Method.
     * @param t Existing team to update
     */
    public Team updateTeam(Team t) {
        String baseApiUrl = props.getApiUrl();
        String updateUrl = baseApiUrl + "/teams/" + t.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Team> request = new HttpEntity<Team>(t);
        ResponseEntity<Team> response = restTemplate.exchange(
                updateUrl,
                HttpMethod.PUT,
                request,
                Team.class);

        log.debug("Update Team call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Delete a team using exchange method of RestTemplate
     * instead of delete method in order to log the response status code.
     * @param id The team to delete
     */
    public void deleteTeam(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteUrl = baseApiUrl + "/teams/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Team call " + response.getStatusCode().toString());
    }

}
