package fr.video_game_tournament.api.controllers;

import fr.video_game_tournament.api.models.VideoGame;
import fr.video_game_tournament.api.services.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VideoGameController {

    @Autowired
    private VideoGameService videoGameService;

    /**
     * Create - Add a new videoGame
     * @param videoGame An object videoGame
     * @return The videoGame object saved
     */
     @PostMapping("video_games")
     @ResponseStatus(code = HttpStatus.CREATED, reason = "created a new resource")
     //@ResponseStatus(code = HttpStatus.CREATED)
      public VideoGame createVideoGame(@RequestBody VideoGame videoGame){
        return videoGameService.saveVideoGame(videoGame);
      }

     /**
     * Read - Get all video games
     * @return - An Iterable object of Video full filled
     */
     @GetMapping("video_games")
    // @ResponseStatus(code = HttpStatus.OK, reason = "OK")
     @ResponseStatus(code = HttpStatus.OK)
     public Iterable<VideoGame> getVideoGames(){
        return videoGameService.getVideoGames();
     }

     /**
     * Read - Get one video game
     * @param id The id of the video game
     * @return A VideoGame object full filled
     */
     @GetMapping("video_games/{id}")
     @ResponseStatus(code = HttpStatus.OK)
     public VideoGame getVideoGameById(@PathVariable("id") final int id) {
         Optional<VideoGame> videoGame = videoGameService.getVideoGameById(id);
         if(videoGame.isPresent()){
             return videoGame.get();
         }
         else {
             return null;
         }
     }

    /**
     * Update - Update an existing video game
     * @param id - The id of the video game to update
     * @param videoGame - The video game object updated
     * @return current video game
     */
     @PutMapping("/video_games/{id}")
     //@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "resource updated successfully")
     @ResponseStatus(code = HttpStatus.NO_CONTENT)
     public VideoGame update(@PathVariable("id") final int id, @RequestBody VideoGame videoGame){
         Optional<VideoGame> v = videoGameService.getVideoGameById(id);
         if(v.isPresent()) {
             VideoGame currentVideoGame = v.get();

             String name = videoGame.getName();
             if(name != null){
                 currentVideoGame.setName(name);
             }
             videoGameService.saveVideoGame(currentVideoGame);
             //getReasonPhrase();
             return currentVideoGame;
         }
         else {
             return null;
         }
     }

    /**
     * Delete - Delete a video game
     * @param id - The id of the video game to delete
     */
    @DeleteMapping("/video_games/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "resource deleted successfully")
    public void deleteVideoGame(@PathVariable("id") final int id){
        videoGameService.deleteVideoGame(id);
    }

}
