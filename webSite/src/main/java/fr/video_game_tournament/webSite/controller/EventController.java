package fr.video_game_tournament.webSite.controller;

import fr.video_game_tournament.webSite.model.Competition;
import fr.video_game_tournament.webSite.model.Conference;
import fr.video_game_tournament.webSite.model.Event;
import fr.video_game_tournament.webSite.model.VideoGame;
import fr.video_game_tournament.webSite.service.CompetitionService;
import fr.video_game_tournament.webSite.service.ConferenceService;
import fr.video_game_tournament.webSite.service.EventService;
import fr.video_game_tournament.webSite.service.VideoGameService;
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
//@RequestMapping("/events")
public class EventController {

    //dependency injection
    @Autowired
    private EventService service;
    @Autowired
    private ConferenceService conferenceService;
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private VideoGameService videoGameService;
  /*  private EventController (EventService service) {
        super();
        this.service = service;
    };*/

    // GET ALL EVENT
    @GetMapping("/admin")
        public String eventsAdmin(Model model) {
        Iterable<Event> listEvent = service.getEvents();
        model.addAttribute("events", listEvent);
        // affiche la liste d'evente sur cette page => clean code voir pour migrer vers videogame controller
        Iterable<VideoGame> videoGames = videoGameService.getVideoGames();
        model.addAttribute("videoGames", videoGames);
        return "admin/adminEvent.html";
    }

    // ?
    @GetMapping("/")
    public String events(Model model) {
        Iterable<Event> listEvent = service.getEvents();
        model.addAttribute("events", listEvent);
        Iterable<Conference> conferences = conferenceService.getConferences();
        model.addAttribute("conferences", conferences);
        Iterable<Competition> competitions = competitionService.getCompetitions();
        model.addAttribute("competitions", competitions);
        Iterable<VideoGame> videoGames = videoGameService.getVideoGames();
        model.addAttribute("videoGames", videoGames);
        return "home.html";
    }

    @PostMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") final int id) {
        service.deleteEvent(id);
        // @GetMapping("/admin" => retourne la liste des event) => "admin/adminEvent" (dossier/fichier)
        return "redirect:/admin";
    }

    @PostMapping("/eventForm/{id}")
    public String updateEvent(Model model, @PathVariable("id") final int id) {
        Event event = service.getEvent(id);
        model.addAttribute("event", event);

        Iterable<VideoGame> videoGames = videoGameService.getVideoGames();
        model.addAttribute("videoGames", videoGames);

        //VideoGame videoGame = videoGameService.getVideoGame(id);
        // "admin/updateEventForm" (dossier/fichier)
        return "admin/updateEventForm.html";
    }

    @PostMapping("/saveEvent")
    public String addEvent(@Validated Event newEvent, BindingResult bindingResult, Model model) {
        service.saveEvent(newEvent);
        List<Event> events = (List<Event>) service.getEvents();
        model.addAttribute("events", events);
        // @GetMapping("/admin" => retourne la liste des event) => "admin/adminEvent" (dossier/fichier)
        return "redirect:/admin";

    }
}
