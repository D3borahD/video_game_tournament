package fr.video_game_tournament.api.controllers;

import fr.video_game_tournament.api.models.Team;
import fr.video_game_tournament.api.models.User;
import fr.video_game_tournament.api.models.VideoGame;
import fr.video_game_tournament.api.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    /**
     * Create - Add a new team
     * @param team An object team
     * @return The team object saved
     */
    @PostMapping("teams")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "created a new resource")
    //@ResponseStatus(code = HttpStatus.CREATED)
    public Team createTeam(@RequestBody Team team){
        return teamService.saveTeam(team);
    }

    /**
     * Read - Get all team
     * @return - An Iterable object of team full filled
     */
    @GetMapping("teams")
    // @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<Team> getVideoGames(){
        return teamService.getTeams();
    }

    /**
     * Read - Get one team
     * @param id The id of the team
     * @return A Team object full filled
     */
    @GetMapping("teams/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Team getTeamById(@PathVariable("id") final int id) {
        Optional<Team> team = teamService.getTeamById(id);
        if(team.isPresent()){
            return team.get();
        }
        else {
            return null;
        }
    }

    /**
     * Update - Update an existing team
     * @param id - The id of the team to update
     * @param team - The team  object updated
     * @return current team
     */
    @PutMapping("/teams/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Team  update(@PathVariable("id") final int id, @RequestBody Team team){
        Optional<Team> t = teamService.getTeamById(id);
        if(t.isPresent()) {
            Team currentTeam = t.get();
            String name = team.getName();
            if(name != null){
                currentTeam.setName(name);
            }
            int ranking = team.getRanking();
            if(ranking != 0){
                currentTeam.setRanking(ranking);
            }
            int competitionId = team.getCompetitionId();
            if(competitionId != 0){
                currentTeam.setCompetitionId(competitionId);
            }
           /* List<User> users = team.getUsers();
            if(users != null){
                currentTeam.setUsers(users);
            }*/
            teamService.saveTeam(currentTeam);
            return currentTeam;
        }
        else {
            return null;
        }
    }

    /**
     * Delete - Delete a team
     * @param id - The id of the team to delete
     */
    @DeleteMapping("/teams/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "resource deleted successfully")
    public void deleteTeam(@PathVariable("id") final int id){
        teamService.deleteTeam(id);
    }


}
