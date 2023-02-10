package fr.video_game_tournament.webSite.controller;

import fr.video_game_tournament.webSite.model.Competition;
import fr.video_game_tournament.webSite.model.Event;
import fr.video_game_tournament.webSite.model.Team;
import fr.video_game_tournament.webSite.service.CompetitionService;
import fr.video_game_tournament.webSite.service.EventService;
import fr.video_game_tournament.webSite.service.TeamService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Data
@Controller
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private EventService eventService;

    @GetMapping("/player")
    public String home (Model model){
        Iterable<Team> listTeam = teamService.getTeams();
        model.addAttribute("teams", listTeam);
        return "competition/competitionDetail";
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


    //don't work
    /*@GetMapping("/competition/player/subscription")
    public String playerRedirect (Model model){
        Iterable<Team> listTeam = teamService.getTeams();
        model.addAttribute("teams", listTeam);
        return "redirect:/player";
    }*/


 /*   @GetMapping("/competitionDetail/{id}")
    public String getInformationCompetition(Model model, @PathVariable("id") final int id) {
        Competition competition = competitionService.getCompetition(id);
        model.addAttribute("competition", competition);
        return "competition/competitionDetail";
    }*/




    @PostMapping("/teamRankingUpdate")
    public String updateRanking(@Validated Team newTeam, BindingResult bindingResult, Model model) {
        teamService.saveTeam(newTeam);
        List<Team> teams = (List<Team>) teamService.getTeams();

        model.addAttribute("teams", teams);
        //return "/admin/competitionUpdateForm";
        return "home";
        //return "redirect:/admin/competition/ranking";
        //return "redirect:/admin/competition/ranking";
        //return "redirect:/player/subscription";
        //return "competition/playerSubscription";
        //return "competition/competitionDetail";
        //return "redirect:/player";
    }

    @PostMapping("/saveTeam")
    public String addTeam(@Validated Team newTeam, BindingResult bindingResult, Model model) {
       teamService.saveTeam(newTeam);
        List<Team> teams = (List<Team>) teamService.getTeams();
        model.addAttribute("teams", teams);
        return "home";

        //return "redirect:/player/subscription";

        //return "competition/playerSubscription";
        //return "competitionDetail";
        //return "redirect:/player";

    }
}
