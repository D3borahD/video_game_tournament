package fr.video_game_tournament.api.controllers;

import fr.video_game_tournament.api.models.Competition;
import fr.video_game_tournament.api.models.Team;
import fr.video_game_tournament.api.services.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;

    /**
     * Create - Add a new Competition
     * @param competition An object Competition
     * @return The Competition object saved
     */
    @PostMapping("competitions")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "created a new resource")
    public Competition createRole(@RequestBody Competition competition){
        return competitionService.saveCompetition(competition);
    }

    /**
     * Read - Get all Competition
     * @return - An Iterable object of Competition full filled
     */
    @GetMapping("competitions")
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<Competition> getCompetition(){
        return competitionService.getCompetitions();
    }

    /**
     * Read - Get one Competition
     * @param id The id of the Competition
     * @return A Competition object full filled
     */
    @GetMapping("competitions/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Competition getCompetitionById(@PathVariable("id") final int id) {
        Optional<Competition> competition = competitionService.getCompetitionById(id);
        if(competition.isPresent()){
            return competition.get();
        }
        else {
            return null;
        }
    }

    /**
     * Update - Update an existing Competition
     * @param id - The id of the Competition to update
     * @param competition - The Competition object updated
     * @return current Competition
     */
    @PutMapping("/competitions/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Competition update(@PathVariable("id") final int id, @RequestBody Competition competition){
        Optional<Competition> r = competitionService.getCompetitionById(id);
        if(r.isPresent()) {
            Competition currentCompetition = r.get();

            String name = competition.getName();
            if(name != null){
                currentCompetition.setName(name);
            }
            int nbPlayerByTeam = competition.getNbPlayerByTeam();
            if(nbPlayerByTeam != 0){
                currentCompetition.setNbPlayerByTeam(nbPlayerByTeam);
            }
            int maxTeam = competition.getMaxTeam();
            if(maxTeam != 0){
                currentCompetition.setMaxTeam(maxTeam);
            }
            int eventId = competition.getEventId();
            if(eventId != 0){
                currentCompetition.setEventId(eventId);
            }
            competitionService.saveCompetition(currentCompetition);
            return currentCompetition;
        }
        else {
            return null;
        }
    }

    /**
     * Delete - Delete a Competition
     * @param id - The id of the Competition to delete
     */
    @DeleteMapping("/competitions/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "resource deleted successfully")
    public void deleteCompetition(@PathVariable("id") final int id){
        competitionService.deleteCompetition(id);
    }

}
