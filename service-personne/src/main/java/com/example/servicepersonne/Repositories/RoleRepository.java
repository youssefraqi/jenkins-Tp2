package com.example.servicepersonne.Repositories;

import com.example.servicepersonne.Modele.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByNom(String rolename);

}
