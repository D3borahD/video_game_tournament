package fr.video_game_tournament.webSite.controller;

import fr.video_game_tournament.webSite.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

//@Controller
public class TeamController {
    @Autowired
    private TeamService service;

   /* @GetMapping("/")
    public String home(Model model){
        Iterable<Team> listTeam = service.getTeams();
        model.addAttribute("teams", listTeam);

        return "home";
    }*/
}
