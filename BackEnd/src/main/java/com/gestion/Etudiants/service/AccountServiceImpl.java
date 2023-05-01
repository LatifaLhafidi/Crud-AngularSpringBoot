package com.gestion.Etudiants.service;

import com.gestion.Etudiants.model.AppRole;
import com.gestion.Etudiants.model.AppUser;
import com.gestion.Etudiants.repository.AppRoleRepository;
import com.gestion.Etudiants.repository.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional

public class AccountServiceImpl implements AccountService {
    private AppRoleRepository appRoleRepository;
    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;


    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository=appRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public AppUser addUser(AppUser user) {
        String pw= user.getPassword();
        user.setPassword(passwordEncoder.encode(pw));

        return appUserRepository.save(user);
    }

    @Override
    public AppRole addRole(AppRole role) {

        return appRoleRepository.save(role);
    }

    @Override
    public List<AppUser> listeUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser loadUserByUserName(String userName) {
        return appUserRepository.findByUserName(userName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
         AppUser user= appUserRepository.findByUserName(userName);
         AppRole role= appRoleRepository.findByRole(roleName);
         user.getAppRoles().add(role);


    }
}
