package com.gestion.Etudiants.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
@Data
@Entity

public class AppUser implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String userName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> appRoles =new ArrayList<>();

    public AppUser() {
    }


    public AppUser(Long id, String userName, String password,Collection<AppRole> appRoles) {
        this.id = id;
        this.userName = userName;
        this.password=password;
        this.appRoles = appRoles;
    }


}
