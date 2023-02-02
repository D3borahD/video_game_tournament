package fr.video_game_tournament.webSite.service;

import fr.video_game_tournament.webSite.model.User;
import fr.video_game_tournament.webSite.repository.UserProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {

    @Autowired
    private UserProxy userProxy;

    public User getUser(final int id){
        return userProxy.getUser(id);
    }


    public Iterable<User> getUsers() {
        return userProxy.getUsers();
    }

        public void deleteUser(final int id) {
            userProxy.deleteUser(id);;
        }

        public User saveUser(User user) {
            User savedUser;

            // Règle de gestion : Le nom de famille doit être mis en majuscule.
            //user.setLastName(employee.getLastName().toUpperCase());

            if(user.getId() == null) {
                // Si l'id est nul, alors c'est un nouvel employé.
                savedUser = userProxy.createUser(user);
            } else {
                savedUser = userProxy.updateUser(user);
            }

            return savedUser;
        }
}
