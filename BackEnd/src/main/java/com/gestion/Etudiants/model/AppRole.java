package com.gestion.Etudiants.model;

import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
public class AppRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long idUser;
    private String role;
    public AppRole() {
    }

    public AppRole(Long idUser,String role) {
        this.idUser = idUser;
        this.role=role;
    }


}

