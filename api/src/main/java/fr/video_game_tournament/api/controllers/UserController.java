package fr.video_game_tournament.api.controllers;

import fr.video_game_tournament.api.models.User;
import fr.video_game_tournament.api.services.RoleService;
import fr.video_game_tournament.api.services.UserService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {


    @Autowired
    private UserService userService;


    /**
     * Read - Get all users
     * @return - An Iterable object of User full filled
     */
    @GetMapping("/users")
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }

    /**
     * Create - Add a new user
     * @param user An object user
     * @return The user object saved
     */
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * Read - Get one user
     * @param id The id of the user
     * @return An User object full filled
     */
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") final int id){
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()){
            return user.get();
        }
        else {
            return null;
        }
    }

    /**
     * Update - Update an existing user
     * @param id - The id of the user to update
     * @param user - The user object updated
     * @return current user
     */
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") final int id, @RequestBody User user) {
        Optional<User> u = userService.getUserById(id);
        if(u.isPresent()){
            User currentUser = u.get();

            String username = user.getUsername();
            if (username != null) {
                currentUser.setUsername(username);
            }

            String email = user.getEmail();
            if (email != null) {
                currentUser.setEmail(email);
            }
            String password = user.getPassword();
            if (password != null) {
                currentUser.setPassword(password);
            }
            int roleId = user.getRoleId();
            if (roleId != 0) {
                currentUser.setRoleId(roleId);
            }
          /*  boolean enabled = user.getEnabled();
            if (enabled != true) {
                currentUser.setEnabled(enabled);
            }*/
            userService.saveUser(currentUser);
            return currentUser;
        }
        else {
            return null;
        }
    }

    /**
     * Delete - Delete an user
     * @param id - The id of the user to delete
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") final int id){
        userService.deleteUser(id);
    }

}
