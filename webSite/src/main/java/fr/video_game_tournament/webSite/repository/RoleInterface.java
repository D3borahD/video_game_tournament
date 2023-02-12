package fr.video_game_tournament.webSite.repository;

import fr.video_game_tournament.webSite.CustomProperties;
import fr.video_game_tournament.webSite.model.Role;
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
public class RoleInterface {

    @Autowired
    private CustomProperties props;

    /**
     * Get all Roles
     * @return An iterable of all Roles
     */
    public Iterable<Role> getRoles(){
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/roles";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Role>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Role>>() {
                }
        );
        log.debug("Get Team Call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Get a team by the id
     * @param id The id of the Role
     * @return The Role which matches the id
     */
    public Role getRole(int id) {
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/roles/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Role> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                Role.class
        );

        log.debug("Get Role call " + response.getStatusCode().toString());

        return response.getBody();
    }


    /**
     * Add a new Role
     * @param r A new Role (without an id)
     * @return The Role full filled (with an id)
     */
    public Role createRole(Role r){
        String baseApiUrl = props.getApiUrl();
        String createUrl = baseApiUrl + "/roles";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Role> request = new HttpEntity<Role>(r);
        ResponseEntity<Role> response = restTemplate.exchange(
                createUrl,
                HttpMethod.POST,
                request,
                Role.class
        );

        log.debug("Create Role call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Update a Role - using the PUT HTTP Method.
     * @param r Existing Role to update
     */
    public Role updateRole(Role r) {
        String baseApiUrl = props.getApiUrl();
        String updateUrl = baseApiUrl + "/roles/" + r.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Role> request = new HttpEntity<Role>(r);
        ResponseEntity<Role> response = restTemplate.exchange(
                updateUrl,
                HttpMethod.PUT,
                request,
                Role.class);

        log.debug("Update Role call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Delete a team using exchange method of RestTemplate
     * instead of delete method in order to log the response status code.
     * @param id The Role to delete
     */
    public void deleteRole(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteUrl = baseApiUrl + "/roles/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Role call " + response.getStatusCode().toString());
    }
}
