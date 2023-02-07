package fr.video_game_tournament.api.controllers;


import fr.video_game_tournament.api.models.Conference;
import fr.video_game_tournament.api.services.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Optional;

@RestController
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    /**
     * Create - Add a new conference
     * @param conference An object conference
     * @return The conference object saved
     */
    @PostMapping("conferences")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "created a new resource")
    public Conference createRole(@RequestBody Conference conference){
        return conferenceService.saveConference(conference);
    }

    /**
     * Read - Get all conferences
     * @return - An Iterable object of conference full filled
     */
    @GetMapping("conferences")
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<Conference> getConference(){
        return conferenceService.getConferences();
    }

    /**
     * Read - Get one Conference
     * @param id The id of the Conference
     * @return A Conference object full filled
     */
    @GetMapping("conferences/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Conference getConferenceById(@PathVariable("id") final int id) {
        Optional<Conference> conference = conferenceService.getConferenceById(id);
        if(conference.isPresent()){
            return conference.get();
        }
        else {
            return null;
        }
    }

    /**
     * Update - Update an existing Conference
     * @param id - The id of the Conference to update
     * @param conference - The Conference object updated
     * @return current Conference
     */
    @PutMapping("/conferences/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Conference update(@PathVariable("id") final int id, @RequestBody Conference conference){
        Optional<Conference> r = conferenceService.getConferenceById(id);
        if(r.isPresent()) {
            Conference currentConference = r.get();

            String name = conference.getName();
            if(name != null){
                currentConference.setName(name);
            }
            LocalTime time = conference.getTime();
            if(time != null){
                currentConference.setTime(time);
            }

            String description = conference.getDescription();
            if(description != null){
                currentConference.setDescription(description);
            }
            conferenceService.saveConference(currentConference);
            return currentConference;
        }
        else {
            return null;
        }
    }

    /**
     * Delete - Delete a Conference
     * @param id - The id of the Conference to delete
     */
    @DeleteMapping("/conferences/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "resource deleted successfully")
    public void deleteConference(@PathVariable("id") final int id){
        conferenceService.deleteConference(id);
    }

}
