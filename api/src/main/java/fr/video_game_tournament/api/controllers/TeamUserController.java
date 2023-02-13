package fr.video_game_tournament.api.controllers;

import fr.video_game_tournament.api.models.Competition;
import fr.video_game_tournament.api.models.TeamUser;
import fr.video_game_tournament.api.services.CompetitionService;
import fr.video_game_tournament.api.services.TeamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TeamUserController {

    @Autowired
    private TeamUserService teamUserService;

    /**
     * Create - Add a new TeamUser
     * @param teamUser An object TeamUser
     * @return The TeamUser object saved
     */
    @PostMapping("teamUsers")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "created a new resource")
    public TeamUser createRole(@RequestBody TeamUser teamUser){
        return teamUserService.saveTeamUser(teamUser);
    }

    /**
     * Read - Get all TeamUser
     * @return - An Iterable object of TeamUser full filled
     */
    @GetMapping("teamUsers")
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<TeamUser> getTeamUser(){
        return teamUserService.getTeamUsers();
    }

    /**
     * Read - Get one TeamUser
     * @param id The id of the TeamUser
     * @return A TeamUser object full filled
     */
    @GetMapping("teamUsers/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public TeamUser getTeamUserById(@PathVariable("id") final int id) {
        Optional<TeamUser> teamUser = teamUserService.getTeamUserById(id);
        if(teamUser.isPresent()){
            return teamUser.get();
        }
        else {
            return null;
        }
    }

    /**
     * Update - Update an existing TeamUser
     * @param id - The id of the TeamUser to update
     * @param teamUser - The TeamUser object updated
     * @return current TeamUser
     */
    @PutMapping("/teamUsers/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public TeamUser update(@PathVariable("id") final int id, @RequestBody TeamUser teamUser){
        Optional<TeamUser> t = teamUserService.getTeamUserById(id);
        if(t.isPresent()) {
            TeamUser currentTeamUser = t.get();

            int teamId = teamUser.getTeamId();
            if (teamId != 0) {
                currentTeamUser.setTeamId(teamId);
            }
            int userId = teamUser.getUserId();
            if (userId != 0) {
                currentTeamUser.setUserId(teamId);
            }
            teamUserService.saveTeamUser(currentTeamUser);
            return currentTeamUser;
        }

        else {
            return null;
        }
    }

    /**
     * Delete - Delete a teamUser
     * @param id - The id of the teamUsers to delete
     */
    @DeleteMapping("/teamUsers/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "resource deleted successfully")
    public void deleteTeamUser(@PathVariable("id") final int id){
        teamUserService.deleteTeamUser(id);
    }

}
