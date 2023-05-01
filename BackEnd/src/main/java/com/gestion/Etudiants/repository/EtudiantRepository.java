package com.gestion.Etudiants.repository;

import com.gestion.Etudiants.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant ,Long> {
   // @Query("FROM Etudiant WHERE nom =?1")
   // public Iterable<Etudiant> findByName( @Param("nom") String nom);

  //  @Query("select e from Etudiant e where e.nom = :nom")
    //public List <Etudiant> findByName(@Param("nom") String nom);
}
