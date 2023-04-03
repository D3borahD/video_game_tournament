package fr.video_game_tournament.api.services;

import fr.video_game_tournament.api.models.Role;
import fr.video_game_tournament.api.repositories.RoleRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Optional<Role> getRoleById(final int id){
        return roleRepository.findById(id);
    }

    public Iterable<Role> getRoles(){
        return roleRepository.findAll();
    }

    public void deleteRole(final int id){
        roleRepository.deleteById(id);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
