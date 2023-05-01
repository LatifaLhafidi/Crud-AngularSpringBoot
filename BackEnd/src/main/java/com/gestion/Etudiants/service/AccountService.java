package com.gestion.Etudiants.service;

import com.gestion.Etudiants.model.AppRole;
import com.gestion.Etudiants.model.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addUser(AppUser user);
    AppRole addRole(AppRole role);

    List<AppUser> listeUsers();
    AppUser loadUserByUserName(String userName);
     void addRoleToUser(String userName,String role);
}
