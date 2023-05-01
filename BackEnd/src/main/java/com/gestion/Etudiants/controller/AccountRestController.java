package com.gestion.Etudiants.controller;

import com.gestion.Etudiants.model.AppRole;
import com.gestion.Etudiants.model.AppUser;
import com.gestion.Etudiants.service.AccountService;
import lombok.Data;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AccountRestController {
    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping(path="/users")
   // @PostAuthorize("hasAuthority('user')")

    public List<AppUser> getAllUsers(){
       return accountService.listeUsers();
    }
    @PostMapping(path="/user")
   // @PostAuthorize("hasAuthority('admin')")
    public AppUser ajouterUser ( @RequestBody AppUser user){
        return accountService.addUser(user);
    }
    @PostMapping(path="/roles")
    public AppRole ajouterRole ( @RequestBody AppRole role){
        return accountService.addRole(role);
    }
    @PostMapping(path="/addRoleToUser")
    public void addRoleToUser( @RequestBody RoleForm roleForm){
        accountService.addRoleToUser(roleForm.getUserName(),roleForm.getRoleName());
    }
}
@Data
class RoleForm{
    private String userName;
    private String roleName;


        }