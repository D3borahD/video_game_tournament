package fr.video_game_tournament.api.services;

import fr.video_game_tournament.api.models.Team;

import fr.video_game_tournament.api.repositories.TeamRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Optional<Team> getTeamById(final int id){
        return teamRepository.findById(id);
    }

    public Iterable<Team> getTeams(){
        return teamRepository.findAll();
    }

    public void deleteTeam(final int id){
        teamRepository.deleteById(id);
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }
}
