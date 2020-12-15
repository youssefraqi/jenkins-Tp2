package com.example.servicepersonne.service;

import com.example.servicepersonne.Modele.Personne;
import com.example.servicepersonne.Modele.Role;

public interface AccountService {
    public Personne saveUser(String username, String password, String confirmedPassword, String nom, String tel, String prenom);
    public Role save(Role role);
    public Personne saveProf(String username, String password, String confirmedPassword, String nom, String tel, String prenom);

    public Personne loadUserByUsername(String username);
    public void addRoleToUser(String username, String rolename);
}
