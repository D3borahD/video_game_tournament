package fr.video_game_tournament.api.services;

import fr.video_game_tournament.api.models.Conference;
import fr.video_game_tournament.api.repositories.ConferenceRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;

    public Optional<Conference> getConferenceById(final int id){
        return conferenceRepository.findById(id);
    }

    public Iterable<Conference> getConferences(){
        return conferenceRepository.findAll();
    }

    public void deleteConference(final int id){
        conferenceRepository.deleteById(id);
    }

    public Conference saveConference(Conference conference) {
        return conferenceRepository.save(conference);
    }
}
