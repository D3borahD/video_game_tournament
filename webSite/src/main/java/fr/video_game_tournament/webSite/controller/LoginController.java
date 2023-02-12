package fr.video_game_tournament.webSite.controller;

import fr.video_game_tournament.webSite.model.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

//@RestController
@Controller
//@RequestMapping("/login")
public class LoginController {



    @GetMapping("/login")
    public String displayLoginForm(Model model){
        model.addAttribute("loginModel", new LoginModel());
        return "login/loginForm.html";
    }



    @PostMapping("/processLogin")
    public String processLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("loginModel", loginModel);
            return "logginForm.html";
        }

        model.addAttribute("userModel", loginModel);
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
