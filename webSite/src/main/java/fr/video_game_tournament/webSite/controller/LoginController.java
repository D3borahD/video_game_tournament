package fr.video_game_tournament.webSite.controller;

import fr.video_game_tournament.webSite.model.LoginModel;
import fr.video_game_tournament.webSite.model.User;
import fr.video_game_tournament.webSite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

//@RestController
@Controller
//@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String displayLoginForm(Model model){
        model.addAttribute("loginModel", new LoginModel());
        return "login/loginForm.html";
    }

    @PostMapping("/processLogin")
    public String processLogin(@Valid LoginModel loginModel, Model model){

     /*   if(bindingResult.hasErrors()){
            model.addAttribute("loginModel", loginModel);
            return "loginForm.html";
        }*/
        model.addAttribute("userModel", loginModel);
        return "login/loginResult";
    }

    @GetMapping("/register")
    public String registerForm(Model model){
        User user = new User();
        model.addAttribute("user", user);

        return "/login/registerForm.html";
    }
    @PostMapping("/processRegister")
    public String processRegistration( User user){

        service.saveUser(user);
        return "login/loginResult";
    }

 /*   @RequestMapping("/*")
    @RolesAllowed("USER")
    public String getUser() {
        return "home";
    }

    @RequestMapping("/admin")
    @RolesAllowed("ADMIN")
    public String getAdmin(){
        return "Welcome, Admin";
    }*/

}
