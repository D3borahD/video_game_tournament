package fr.video_game_tournament.webSite.service;

import fr.video_game_tournament.webSite.model.Competition;
import fr.video_game_tournament.webSite.repository.CompetitionInterface;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class CompetitionService {

    @Autowired
    private CompetitionInterface competitionInterface;

    public Competition getCompetition(final int id){
        return competitionInterface.getCompetition(id);
    }

    public Iterable<Competition> getCompetitions() {
        return competitionInterface.getCompetitions();
    }

    public void deleteCompetition(final int id) {
        competitionInterface.deleteCompetition(id);;
    }


    public Competition saveCompetition(Competition competition) {
        Competition savedCompetition;

        // Functional rule : name must be capitalized.
        competition.setName(competition.getName().toUpperCase());

        if(competition.getId() == null) {
            savedCompetition = competitionInterface.createCompetition(competition);
        } else {
            savedCompetition = competitionInterface.updateCompetition(competition);
        }
        return savedCompetition;
    }
}
