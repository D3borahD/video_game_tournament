package fr.video_game_tournament.webSite.service;

import fr.video_game_tournament.webSite.model.Team;
import fr.video_game_tournament.webSite.repository.TeamInterface;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class TeamService {

    @Autowired
    private TeamInterface teamInterface;

    public Team getTeam(final int id){
        return teamInterface.getTeam(id);
    }

    public Iterable<Team> getTeams() {
        return teamInterface.getTeams();
    }

    public void deleteTeam(final int id) {
        teamInterface.deleteTeam(id);;
    }

    public Team saveTeam(Team team) {
        Team savedTeam;

        if(team.getId() == null) {
            savedTeam = teamInterface.createTeam(team);
        } else {
            savedTeam = teamInterface.updateTeam(team);
        }
        return savedTeam;
    }
}
