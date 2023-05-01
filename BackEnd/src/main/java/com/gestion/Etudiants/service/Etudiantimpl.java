package com.gestion.Etudiants.service;

import com.gestion.Etudiants.model.Etudiant;
import com.gestion.Etudiants.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Etudiantimpl {
    @Autowired
    private EtudiantRepository etudiantRepository;

    public Etudiantimpl() {
    }

    public Etudiantimpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }
  public Etudiant ajouterEtudiant ( Etudiant e) {
       return etudiantRepository.save(e) ;
  }
  public List <Etudiant> afficherEtudiants(){
      return etudiantRepository.findAll();
  }
    public  Etudiant afficherEtudiant(long id){
        return etudiantRepository.findById(id).get();

    }
  public String supprimerEtudiant(long id){
      etudiantRepository.deleteById(id);
      return "produit est supprimer " ;


  }
   public Etudiant modifierEtudiant (Etudiant e,long id){
           Etudiant e1= etudiantRepository.findById(id).get();
           e1.setNom(e.getNom());
           e1.setPrenom(e.getPrenom());
           e1.setNote(e.getNote());
          return  etudiantRepository.save(e1);

       }

    //public List<Etudiant> findByNom(String nom) {


   // }
   }







