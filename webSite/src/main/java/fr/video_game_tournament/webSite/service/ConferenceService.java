package fr.video_game_tournament.webSite.service;

import fr.video_game_tournament.webSite.model.Conference;
import fr.video_game_tournament.webSite.repository.ConferenceInterface;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ConferenceService {

    @Autowired
    private ConferenceInterface conferenceInterface;

    public Conference getConference(final int id){
        return conferenceInterface.getConference(id);
    }

    public Iterable<Conference> getConferences() {
        return conferenceInterface.getConferences();
    }

    public void deleteConference(final int id) {
        conferenceInterface.deleteConference(id);;
    }

    public Conference saveConference(Conference conference) {
        Conference savedConference;
        if(conference.getId() == null) {
            savedConference = conferenceInterface.createConference(conference);
        } else {
            savedConference = conferenceInterface.updateConference(conference);
        }
        return savedConference;
    }
}
