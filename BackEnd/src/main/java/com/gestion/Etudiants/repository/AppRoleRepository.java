package com.gestion.Etudiants.repository;

import com.gestion.Etudiants.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
     AppRole findByRole(String role);
}
