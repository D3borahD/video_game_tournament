package fr.video_game_tournament.api.services;

import fr.video_game_tournament.api.models.VideoGame;
import fr.video_game_tournament.api.repositories.VideoGameRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class VideoGameService {

    @Autowired
    private VideoGameRepository videoGameRepository;

    public Optional<VideoGame> getVideoGameById(final int id){
        return videoGameRepository.findById(id);
    }

    public Iterable<VideoGame> getVideoGames(){
        return videoGameRepository.findAll();
    }

    public void deleteVideoGame(final int id){
        videoGameRepository.deleteById(id);
    }

    public VideoGame saveVideoGame(VideoGame videoGame) {
        return videoGameRepository.save(videoGame);
    }


}
