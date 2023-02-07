package fr.video_game_tournament.webSite.controller;

import fr.video_game_tournament.webSite.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
@Controller
//@RequestMapping("/login")
public class LoginController {



    @GetMapping("/login")
    public String displayLoginForm(Model model){
        User user = new User();
        model.addAttribute("loginModel", user);
        return "loginForm.html";
    }



   /* @PostMapping("/processLogin")
    public String processLogin(LoginModel loginModel, Model model){
      //  model.addAttribute("userModel", loginModel);
        return "loginResult";
    }*/

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
