package fr.video_game_tournament.api.services;


import fr.video_game_tournament.api.models.CustomUsersDetails;
import fr.video_game_tournament.api.models.User;
import fr.video_game_tournament.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomUsersDetails(user);
    }
}
