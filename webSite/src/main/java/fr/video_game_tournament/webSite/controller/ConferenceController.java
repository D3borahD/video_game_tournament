package fr.video_game_tournament.webSite.controller;

import fr.video_game_tournament.webSite.model.Conference;
import fr.video_game_tournament.webSite.service.ConferenceService;
import fr.video_game_tournament.webSite.service.EventService;
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
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;
    @Autowired
    private EventService eventService;

    @GetMapping("/conference")
    public String conferences(Model model) {
        Iterable<Conference> listConference = conferenceService.getConferences();
        model.addAttribute("conferences", listConference);
        return "home";
    }

    @GetMapping("/admin/conference")
    public String listeconference(Model model) {
        Iterable<Conference> listConference = conferenceService.getConferences();
        model.addAttribute("conferences", listConference);
        return "redirect:/admin";
    }

    @PostMapping("/deleteConference/{id}")
    public String deleteConference(@PathVariable("id") final int id) {
        conferenceService.deleteConference(id);
        return "redirect:/admin/conference";
    }

    @PostMapping("/conferenceUpdate/{id}")
    public String updateEvent(Model model, @PathVariable("id") final int id) {
        Conference conference = conferenceService.getConference(id);
        model.addAttribute("conference", conference);
        return "admin/conferenceUpdateForm";
    }

    @PostMapping("/saveConference")
    public String addConference(@Validated Conference newConference, BindingResult bindingResult, Model model) {
        conferenceService.saveConference(newConference);
        List<Conference> conferences = (List<Conference>) conferenceService.getConferences();
        model.addAttribute("conferences", conferences);
        return "redirect:/admin";
    }

}
