package fr.video_game_tournament.webSite.controller;

import fr.video_game_tournament.webSite.service.CompetitionService;
import fr.video_game_tournament.webSite.service.EventService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Data
@Controller
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private EventService eventService;

}
