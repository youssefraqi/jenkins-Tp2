package com.example.servicepersonne.Modele;

import lombok.Data;

import java.util.Date;

@Data
public class Cours {
    private Long id;
    private String titre;
    private double duree;
    private Date dateDebut;
    private Date dateFin;
}
