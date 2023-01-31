package fr.video_game_tournament.api.services;

import fr.video_game_tournament.api.models.Competition;
import fr.video_game_tournament.api.models.VideoGame;
import fr.video_game_tournament.api.repositories.CompetitionRepository;
import fr.video_game_tournament.api.repositories.VideoGameRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class CompetitionService {
    @Autowired
    private CompetitionRepository competitionRepository;

    public Optional<Competition> getCompetitionById(final int id){
        return competitionRepository.findById(id);
    }

    public Iterable<Competition> getCompetitions(){
        return competitionRepository.findAll();
    }

    public void deleteCompetition(final int id){
        competitionRepository.deleteById(id);
    }

    public Competition saveCompetition(Competition competition) {
        return competitionRepository.save(competition);
    }
}
