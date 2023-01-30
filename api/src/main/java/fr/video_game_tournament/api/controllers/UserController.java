package fr.video_game_tournament.api.controllers;

import fr.video_game_tournament.api.models.User;
import fr.video_game_tournament.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * Read - Get all employees
     * @return - An Iterable object of Employee full filled
     */
    @GetMapping("/users")
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }

    /**
     * Create - Add a new employee
     * @param user An object employee
     * @return The employee object saved
     */
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * Read - Get one user
     * @param id The id of the user
     * @return An User object full filled
     */
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") final Long id){
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()){
            return user.get();
        }
        else {
            return null;
        }
    }

    /**
     * Update - Update an existing employee
     * @param id - The id of the employee to update
     * @param user - The employee object updated
     * @return
     */
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") final Long id, @RequestBody User user) {
        Optional<User> u = userService.getUserById(id);
        if(u.isPresent()){
            User currentUser = u.get();

            String firstname = user.getFirstname();
            if (firstname != null) {
                currentUser.setFirstname(firstname);
            }
            String lastname = user.getLastname();
            if (lastname != null) {
                currentUser.setLastname(lastname);
            }
            String email = user.getEmail();
            if (email != null) {
                currentUser.setEmail(email);
            }
            userService.addUser(currentUser);
            return currentUser;
        }
        else {
            return null;
        }
    }




    /**
     * Delete - Delete an employee
     * @param id - The id of the employee to delete
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") final Long id){
        userService.deleteUser(id);
    }



}
