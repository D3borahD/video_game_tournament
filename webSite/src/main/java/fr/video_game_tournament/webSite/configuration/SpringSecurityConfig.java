package fr.video_game_tournament.webSite.configuration;

//@Configuration
//@EnableWebSecurity
public class SpringSecurityConfig {

   /* @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                //.password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                .password(passwordEncoder().encode("user"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                //.password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                .password(passwordEncoder().encode("admin"))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
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
        )             .formLogin(withDefaults());

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }*/
}
