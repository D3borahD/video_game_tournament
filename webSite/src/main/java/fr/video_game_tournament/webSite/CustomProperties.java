package fr.video_game_tournament.webSite;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "fr-video-game-tournament-web-site")
public class CustomProperties {
    private String apiUrl;
}
