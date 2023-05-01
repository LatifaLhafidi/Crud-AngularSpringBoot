package com.gestion.Etudiants.repository;

import com.gestion.Etudiants.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {

     //SELECT AppUser.userName, AppUser.password ,
     // AppRole.role FROM AppUser JOIN  AppUserAppRoles
     // ON  AppUser.id= AppUserAppRoles.appUserId JOIN AppRole
     // ON AppRole.idUser=AppUserAppRoles.AppRolesIdUser

     public AppUser findByUserName( String userName);


}
