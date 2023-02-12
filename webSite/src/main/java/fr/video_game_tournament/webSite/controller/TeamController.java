package fr.video_game_tournament.webSite.controller;

import fr.video_game_tournament.webSite.model.Competition;
import fr.video_game_tournament.webSite.model.Event;
import fr.video_game_tournament.webSite.model.Team;
import fr.video_game_tournament.webSite.model.User;
import fr.video_game_tournament.webSite.service.CompetitionService;
import fr.video_game_tournament.webSite.service.EventService;
import fr.video_game_tournament.webSite.service.TeamService;
import fr.video_game_tournament.webSite.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Data
@Controller
public class TeamController {
    @Autowired
    private TeamService teamService;

    @Autowired
    private UserService userService;
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private EventService eventService;

    @GetMapping("/player")
    public String listCompetition (Model model){
        Iterable<Team> listTeam = teamService.getTeams();
        model.addAttribute("teams", listTeam);
        return "competition/competitionDetail.html";
    }

    @GetMapping("/player/competition")
    public String listCompet (Model model){
        Iterable<Team> listTeam = teamService.getTeams();
        model.addAttribute("teams", listTeam);
        return "redirect:/player";
    }

    @GetMapping("/team")
    public String listCTeam (Model model){
        Iterable<Team> listTeam = teamService.getTeams();
        model.addAttribute("teams", listTeam);
        return "team/teamForm.html";
    }


    @GetMapping("/ranking")
    public String rank (Model model){
        Iterable<Team> listTeam = teamService.getTeams();
        model.addAttribute("teams", listTeam);
        Iterable<Event> listEvent = eventService.getEvents();
        model.addAttribute("events", listEvent);
        Iterable<Competition> competitions = competitionService.getCompetitions();
        model.addAttribute("competitions", competitions);
        return "competition/competitionDetail";
    }

        @GetMapping("/player/subscription")
        public String playerRedirect (Model model){
            Iterable<Team> listTeam = teamService.getTeams();
            model.addAttribute("teams", listTeam);
            return "competition/teamSubscriptionForm";
        }

    //saveScore
    //get value input

//ok
    @PostMapping("/updateRanking")
    public String updateRankingTeam(@Validated Team newTeam, BindingResult bindingResult, Model model) {
        teamService.saveTeam(newTeam);
        List<Team> teams = (List<Team>) teamService.getTeams();
        model.addAttribute("teams", teams);
        //return "home.html";
        //return "admin.competitionUpdateForm.html";
        return "redirect:/admin";
        //return "redirect:/player/subscription";
        //return "competition/playerSubscription";
        //return "competitionDetail";
        //return "redirect:/player";
    }


    @PostMapping("updateTeam/{id}")
    public String updateTeam(Model model, @PathVariable("id") final int id) {
        Iterable<Team> listTeam = teamService.getTeams();
        model.addAttribute("teams", listTeam);

        Iterable<User> listUser = userService.getUsers();
        model.addAttribute("users", listUser);

        //VideoGame videoGame = videoGameService.getVideoGame(id);
        // "admin/updateEventForm" (dossier/fichier)
        return "redirect:/team";
    }

    @PostMapping("/saveTeam")
    public String addTeam(@Validated Team newTeam, BindingResult bindingResult, Model model) {
       teamService.saveTeam(newTeam);
       /* List<Team> teams = (List<Team>) teamService.getTeams();
        model.addAttribute("teams", teams);*/
        Iterable<Team> listTeam = teamService.getTeams();
        model.addAttribute("teams", listTeam);

        return "/competition/teamSubscriptionForm.html";
        //return "redirect:/player/subscription";
        //return "competition/playerSubscription";
        //return "competitionDetail";
        //return "redirect:/player";
    }

    @PostMapping("/deleteTeam/{id}")
    public String deleteTeam(@PathVariable("id") final int id) {
        teamService.deleteTeam(id);
        // @GetMapping("/admin" => retourne la liste des event) => "admin/adminEvent" (dossier/fichier)
        return "redirect:/team";
    }
}
