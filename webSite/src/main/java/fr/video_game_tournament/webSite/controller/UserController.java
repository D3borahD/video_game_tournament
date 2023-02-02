package fr.video_game_tournament.webSite.controller;

import fr.video_game_tournament.webSite.model.User;
import fr.video_game_tournament.webSite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String home(Model model){
        Iterable<User> listUser = service.getUsers();
        model.addAttribute("users", listUser);

        return "home";
    }

}
