package fr.video_game_tournament.api.services;

import fr.video_game_tournament.api.models.User;
import fr.video_game_tournament.api.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(final Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
