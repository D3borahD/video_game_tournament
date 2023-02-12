package fr.video_game_tournament.webSite.controller;

import fr.video_game_tournament.webSite.model.Role;
import fr.video_game_tournament.webSite.model.User;
import fr.video_game_tournament.webSite.service.RoleService;
import fr.video_game_tournament.webSite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/user")
    public String listUser(Model model){
        Iterable<User> listUser = userService.getUsers();
        model.addAttribute("users", listUser);
        return "home";
    }

    @GetMapping("/admin/user")
    public String userMangage(Model model){
        Iterable<User> listUser = userService.getUsers();
        model.addAttribute("users", listUser);
        Iterable<Role> listRole = roleService.getRoles();
        model.addAttribute("roles", listRole);
        return "admin/userManage.html";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") final int id) {
        userService.deleteUser(id);
        return "redirect:/admin/user";
    }

    @PostMapping("/saveRoleUser")
    public String updateUser(@Validated User newUser, BindingResult bindingResult, Model model) {
        userService.saveUser(newUser);
        List<User> users = (List<User>) userService.getUsers();
        model.addAttribute("users", users);
        return "redirect:/admin";
    }


}
