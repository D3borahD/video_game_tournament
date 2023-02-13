package fr.video_game_tournament.webSite.configuration;

import fr.video_game_tournament.webSite.model.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                authorize -> authorize
                        //.requestMatchers("/resources/**", "/signup", "/about").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasRole("USER")
                        // the all other request must be authenticate by the login form
                        .anyRequest().authenticated()
                        .and()
                // formulaire de connexion par défault
        )             .formLogin(withDefaults());

        return http.build();
    }

/*    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // autorize the request at the requestMatchers
        http.authorizeHttpRequests(
                authorize -> authorize
                        //.requestMatchers("/resources/**", "/signup", "/about").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasRole("USER")
                        // the all other request must be authenticate by the login form
                        .anyRequest().authenticated()
                        .and()
                // formulaire de connexion par défault
        )             .formLogin()
                .usernameParameter("email")
                .defaultSuccessUrl("/user")
                .and()
                .logout().logoutSuccessUrl("/").permitAll();


        return http.build();
    }*/


}

