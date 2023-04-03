package fr.video_game_tournament.webSite.service;

import fr.video_game_tournament.webSite.model.User;
import fr.video_game_tournament.webSite.repository.UserInterface;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {

    @Autowired
    private UserInterface userInterface;

    public User getUser(final int id){
        return userInterface.getUser(id);
    }

    public Iterable<User> getUsers() {
        return userInterface.getUsers();
    }

    public void deleteUser(final int id) {
        userInterface.deleteUser(id);;
    }

    public User saveUser(User user) {
        User savedUser;
        if(user.getId() == null) {

            savedUser = userInterface.createUser(user);
        } else {
            savedUser = userInterface.updateUser(user);
        }
        return savedUser;
    }
}
