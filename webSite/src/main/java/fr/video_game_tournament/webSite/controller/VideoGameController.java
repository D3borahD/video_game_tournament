package fr.video_game_tournament.webSite.controller;

import fr.video_game_tournament.webSite.model.VideoGame;
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
public class VideoGameController {

    @Autowired
    private VideoGameService videoGameService;

    @GetMapping("/admin/video_gameEdit")
    public String videoGameList(Model model) {
        Iterable<VideoGame> videoGames = videoGameService.getVideoGames();
        model.addAttribute("videoGames", videoGames);
        return "admin/videoGamesEdit.html";
    }

    @PostMapping("/deleteVideoGame/{id}")
    public String deleteVideoGame(@PathVariable("id") final int id) {
        videoGameService.deleteVideoGame(id);
        return "redirect:/admin/video_gameEdit";
    }


    @PostMapping("/saveVideoGame")
    public String addEvent(@Validated VideoGame newVideoGame, BindingResult bindingResult, Model model) {
        videoGameService.saveVideoGame(newVideoGame);
        List<VideoGame> videoGames = (List<VideoGame>) videoGameService.getVideoGames();
        model.addAttribute("videoGames", videoGames);
        return "redirect:/admin/video_gameEdit";

    }
}
