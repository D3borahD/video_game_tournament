package fr.video_game_tournament.webSite.service;

import fr.video_game_tournament.webSite.model.Role;
import fr.video_game_tournament.webSite.repository.RoleInterface;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class RoleService {
    @Autowired
    private RoleInterface roleInterface;

    public Role getRole(final int id){
        return roleInterface.getRole(id);
    }

    public Iterable<Role> getRoles() {
        return roleInterface.getRoles();
    }

    public void deleteRole(final int id) {
        roleInterface.deleteRole(id);;
    }

    public Role saveRole(Role role) {
        Role savedRole;
        if(role.getId() == null) {

            savedRole = roleInterface.createRole(role);
        } else {
            savedRole = roleInterface.updateRole(role);
        }
        return savedRole;
    }
}
