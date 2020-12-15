package com.example.servicepersonne.Repositories;

import com.example.servicepersonne.Modele.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface PersonneRepository extends JpaRepository<Personne,Long> {
    public Personne findByUsername(String username);


}
