package fr.video_game_tournament.webSite.repository;

import fr.video_game_tournament.webSite.CustomProperties;
import fr.video_game_tournament.webSite.model.VideoGame;
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
public class VideoGameInterface {

    @Autowired
    private CustomProperties props;

    /**
     * Get all VideoGame
     * @return An iterable of all VideoGame
     */
    public Iterable<VideoGame> getVideoGames(){
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/video_games";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<VideoGame>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<VideoGame>>() {
                }
        );
        log.debug("Get Team Call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Get a VideoGame by the id
     * @param id The id of the VideoGame
     * @return The VideoGame which matches the id
     */
    public VideoGame getVideoGame(int id) {
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/video_games/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<VideoGame> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                VideoGame.class
        );

        log.debug("Get VideoGame call " + response.getStatusCode().toString());

        return response.getBody();
    }


    /**
     * Add a new VideoGame
     * @param v A new VideoGame(without an id)
     * @return The VideoGame full filled (with an id)
     */
    public VideoGame createVideoGame(VideoGame v){
        String baseApiUrl = props.getApiUrl();
        String createUrl = baseApiUrl + "/video_games";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<VideoGame> request = new HttpEntity<VideoGame>(v);
        ResponseEntity<VideoGame> response = restTemplate.exchange(
                createUrl,
                HttpMethod.POST,
                request,
                VideoGame.class
        );

        log.debug("Create VideoGame call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Update a VideoGame - using the PUT HTTP Method.
     * @param v Existing VideoGame to update
     */
    public VideoGame updateVideoGame(VideoGame v) {
        String baseApiUrl = props.getApiUrl();
        String updateUrl = baseApiUrl + "/video_games/" + v.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<VideoGame> request = new HttpEntity<VideoGame>(v);
        ResponseEntity<VideoGame> response = restTemplate.exchange(
                updateUrl,
                HttpMethod.PUT,
                request,
                VideoGame.class);

        log.debug("Update VideoGame call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Delete a VideoGame using exchange method of RestTemplate
     * instead of delete method in order to log the response status code.
     * @param id The VideoGame to delete
     */
    public void deleteVideoGame(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteUrl = baseApiUrl + "/video_games/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete VideoGame call " + response.getStatusCode().toString());
    }

}
