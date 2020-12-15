package com.example.servicepersonne.service;
import com.example.servicepersonne.Modele.Personne;
import com.example.servicepersonne.Modele.Role;
import com.example.servicepersonne.Repositories.PersonneRepository;
import com.example.servicepersonne.Repositories.RoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private PersonneRepository appUserRepository;
    private RoleRepository appRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(PersonneRepository appUserRepository, RoleRepository appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Personne saveUser(String username, String password, String confirmedPassword, String nom, String tel, String prenom) {
        Personne user = appUserRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        Personne appUser = new Personne();
        appUser.setUsername(username);
        appUser.setActived(true);
        appUser.setNom(nom);
        appUser.setPrenom(prenom);
        appUser.setTel(tel);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUserRepository.save(appUser);
        addRoleToUser(username,"ETUD");
        return appUser;
    }
    public Personne saveProf(String username, String password, String confirmedPassword, String nom, String tel, String prenom) {
        Personne user = appUserRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        Personne appUser = new Personne();
        appUser.setUsername(username);
        appUser.setActived(true);
        appUser.setNom(nom);
        appUser.setPrenom(prenom);
        appUser.setTel(tel);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUserRepository.save(appUser);
        addRoleToUser(username,"PROF");
        return appUser;
    }

    @Override
    public Role save(Role role) {
        return appRoleRepository.save(role);
    }

    @Override
    public Personne loadUserByUsername(String username)
    {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        Personne appUser = appUserRepository.findByUsername(username);
        Role appRole = appRoleRepository.findByNom(rolename);
        appUser.getRoles().add(appRole);
    }
}
