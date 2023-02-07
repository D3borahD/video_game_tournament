package fr.video_game_tournament.webSite.service;

import fr.video_game_tournament.webSite.model.Team;
import fr.video_game_tournament.webSite.repository.TeamProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class TeamService {

    @Autowired
    private TeamProxy teamProxy;

    public Team getTeam(final int id){
        return teamProxy.getTeam(id);
    }


    public Iterable<Team> getTeams() {
        return teamProxy.getTeams();
    }

    public void deleteTeam(final int id) {
        teamProxy.deleteTeam(id);;
    }

    public Team saveTeam(Team team) {
        Team savedTeam;

        if(team.getId() == null) {
            // Si l'id est nul, alors c'est une nouvelle team.
            savedTeam = teamProxy.createTeam(team);
        } else {
            savedTeam = teamProxy.updateTeam(team);
        }

        return savedTeam;
    }
}
