package com.gestion.Etudiants.controller;
import com.gestion.Etudiants.model.Etudiant;
import com.gestion.Etudiants.service.Etudiantimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")

@RestController
@RequestMapping(value="/api")
public class EtudiantController {
    @Autowired

    private Etudiantimpl etudiantimpl;

    @PostMapping("/etudiants")
    public void add( @RequestBody Etudiant e){
        etudiantimpl.ajouterEtudiant(e);
    }


    @GetMapping ("/etudiants")
       public List <Etudiant> getEtudiants(){
          List <Etudiant> list = etudiantimpl.afficherEtudiants();
         return list;

    }
    @GetMapping("/etudiants/{id}")
    public Etudiant getEtudiant(@PathVariable long id){
        return  etudiantimpl.afficherEtudiant(id);
    }

    @GetMapping("/etudiants/nom")
    //public List<Etudiant> getEtudiantByName(String nom){
       // return etudiantimpl.findByNom(nom);}

     @DeleteMapping("/etudiants/delete/{id}")
    public String deleteEtudiant(@PathVariable long id){
        etudiantimpl.supprimerEtudiant(id);
        return "l'etudiant est bien supprimer";
     }
     @PutMapping("/etudiants/update/{id}")
     public String update( @RequestBody Etudiant e, @PathVariable long id){
         etudiantimpl.modifierEtudiant(e,id);
         return "l'etudian est bien modifier";

     }
}
