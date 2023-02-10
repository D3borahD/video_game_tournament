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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Data
@Controller
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private EventService eventService;
    @Autowired
    private TeamService teamService;


    @GetMapping("/competition")
    public String competitions(Model model) {
        Iterable<Competition> listCompetition = competitionService.getCompetitions();
        model.addAttribute("competitions", listCompetition);
        return "home";
    }


    @GetMapping("/admin/competition")
    public String listeCompetition(Model model) {
        Iterable<Competition> listCompetition = competitionService.getCompetitions();
        model.addAttribute("competitions", listCompetition);
        return "redirect:/admin";
    }

    @GetMapping("/admin/competition/ranking")
    public String listeCompetitionRanking(Model model) {
        Iterable<Event> listEvent = eventService.getEvents();
        model.addAttribute("events", listEvent);
        Iterable<Competition> competitions = competitionService.getCompetitions();
        model.addAttribute("competitions", competitions);
        Iterable<Team> listTeam = teamService.getTeams();
        model.addAttribute("teams", listTeam);
        return "admin/competitionRanking";
       // return "admin/competitionUpdateForm";
    }
    @GetMapping("/competitionDetail/{id}")
    public String getInformationCompetition(Model model, @PathVariable("id") final int id) {
        Competition competition = competitionService.getCompetition(id);
        model.addAttribute("competition", competition);
        return "competition/competitionDetail";
    }

    @PostMapping("/competitionUpdate/{id}")
    public String updateCompetition(Model model, @PathVariable("id") final int id) {
        Competition competition = competitionService.getCompetition(id);
        model.addAttribute("competition", competition);
        return "admin/competitionUpdateForm";
    }




    @PostMapping("/saveCompetition")
    public String addCompetition(@Validated Competition newCompetition, BindingResult bindingResult, Model model) {
        competitionService.saveCompetition(newCompetition);
        List<Competition> competitions = (List<Competition>) competitionService.getCompetitions();
        model.addAttribute("competitions", competitions);
        return "redirect:/admin";
    }

    @PostMapping("/deleteCompetition/{id}")
    public String deleteCompetition(@PathVariable("id") final int id) {
        competitionService.deleteCompetition(id);
        return "redirect:/admin/competition";
    }

}
