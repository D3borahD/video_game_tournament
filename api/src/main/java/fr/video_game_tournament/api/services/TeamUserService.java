package fr.video_game_tournament.api.services;

import fr.video_game_tournament.api.models.TeamUser;
import fr.video_game_tournament.api.models.User;
import fr.video_game_tournament.api.repositories.TeamUserRepository;
import fr.video_game_tournament.api.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class TeamUserService {

    @Autowired
    private TeamUserRepository teamUserRepository;

    public Iterable<TeamUser> getTeamUsers() {
        return teamUserRepository.findAll();
    }

    public Optional<TeamUser> getTeamUserById(final int id) {
        return teamUserRepository.findById(id);
    }

    public void deleteTeamUser(final int id) {
        teamUserRepository.deleteById(id);
    }

    public TeamUser saveTeamUser(TeamUser teamUser) {
        return teamUserRepository.save(teamUser);
    }

}
