package fr.video_game_tournament.webSite.service;

import fr.video_game_tournament.webSite.model.VideoGame;
import fr.video_game_tournament.webSite.repository.VideoGameInterface;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class VideoGameService {

    @Autowired
    private VideoGameInterface videoGameInterface;

    public VideoGame getVideoGame(final int id){
        return videoGameInterface.getVideoGame(id);
    }

    public Iterable<VideoGame> getVideoGames() {
        return videoGameInterface.getVideoGames();
    }

    public void deleteVideoGame(final int id) {
        videoGameInterface.deleteVideoGame(id);;
    }

    public VideoGame saveVideoGame(VideoGame videoGame) {
       VideoGame savedVideoGame;

       //  if(videoGame.getId() == null) <= don't work ...
        if(videoGame.getId() == 0) {
            savedVideoGame = videoGameInterface.createVideoGame(videoGame);
        } else {
            savedVideoGame = videoGameInterface.updateVideoGame(videoGame);
        }
        return savedVideoGame;
    }

}
