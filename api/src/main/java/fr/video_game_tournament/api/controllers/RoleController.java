package fr.video_game_tournament.api.controllers;

import fr.video_game_tournament.api.models.Role;
import fr.video_game_tournament.api.services.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * Create - Add a new role
     * @param role An object role
     * @return The role object saved
     */
    @PostMapping("roles")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "created a new resource")
    public Role createRole(@RequestBody Role role){
        return roleService.saveRole(role);
    }

    /**
     * Read - Get all roles
     * @return - An Iterable object of Role full filled
     */
    @GetMapping("roles")
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<Role> getRole(){
        return roleService.getRoles();
    }

    /**
     * Read - Get one role
     * @param id The id of the role
     * @return A Role object full filled
     */
    @GetMapping("roles/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Role getRoleById(@PathVariable("id") final int id) {
        Optional<Role> role = roleService.getRoleById(id);
        if(role.isPresent()){
            return role.get();
        }
        else {
            return null;
        }
    }

    /**
     * Update - Update an existing role
     * @param id - The id of the role to update
     * @param role - The role object updated
     * @return current role
     */
    @PutMapping("/roles/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Role update(@PathVariable("id") final int id, @RequestBody Role role){
        Optional<Role> r = roleService.getRoleById(id);
        if(r.isPresent()) {
            Role currentRole = r.get();

            String name = role.getName();
            if(name != null){
                currentRole.setName(name);
            }
            roleService.saveRole(currentRole);
            return currentRole;
        }
        else {
            return null;
        }
    }

    /**
     * Delete - Delete a role
     * @param id - The id of the role to delete
     */
    @DeleteMapping("/roles/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "resource deleted successfully")
    public void deleteRole(@PathVariable("id") final int id){
        roleService.deleteRole(id);
    }

}
