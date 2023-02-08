package fr.video_game_tournament.webSite.controller;

import fr.video_game_tournament.webSite.model.Conference;
import fr.video_game_tournament.webSite.model.Event;
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
//@RequestMapping("/events")
public class EventController {

    //dependency injection
    @Autowired
    private EventService service;
    @Autowired
    private ConferenceService conferenceService;
  /*  private EventController (EventService service) {
        super();
        this.service = service;
    };*/

    // GET ALL EVENT
    @GetMapping("/admin")
        public String eventsAdmin(Model model) {
        Iterable<Event> listEvent = service.getEvents();
        model.addAttribute("events", listEvent);
        return "admin/adminEvent";
    }

    @GetMapping("/")
    public String events(Model model) {
        Iterable<Event> listEvent = service.getEvents();
        model.addAttribute("events", listEvent);
        Iterable<Conference> conferences = conferenceService.getConferences();
        model.addAttribute("conferences", conferences);
        return "home";
    }

    @PostMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") final int id) {
        service.deleteEvent(id);
        return "redirect:/admin";
    }

    @PostMapping("/eventForm/{id}")
    public String updateEvent(Model model, @PathVariable("id") final int id) {
        Event event = service.getEvent(id);
        model.addAttribute("event", event);
        return "admin/updateEventForm";
    }

    // ADD NEW OTHER METHODE // YT MODEL
    @PostMapping("/saveEvent")
    public String addEvent(@Validated Event newEvent, BindingResult bindingResult, Model model) {
        service.saveEvent(newEvent);
        List<Event> events = (List<Event>) service.getEvents();
        model.addAttribute("events", events);
        return "redirect:/admin";
    }


    // ADD NEW EVENT // NOT USED // IT WORK !!!! OC MODEL
    /*@PostMapping("/saveEvent")
    public ModelAndView saveEvent(@ModelAttribute Event event) {
        if(event.getId() != null) {
            Event current = service.getEvent(event.getId());
        }
        service.saveEvent(event);
        return new ModelAndView("redirect:/");
    }*/
    //

    // DELETE methode get
    /*@GetMapping("/events/{id}")
    public String deleteEvent(@PathVariable("id") final int id) {
        service.deleteEvent(id);
        return "redirect:/";
    }*/

    // GET EVENT BY ID // NOT USE AGAIN
   /*@GetMapping("/eventForm/{id}")
    public String editEvent(@PathVariable("id") final int id) {
        service.getEvent(id);
        return "admin/eventForm";
    }*/
}
