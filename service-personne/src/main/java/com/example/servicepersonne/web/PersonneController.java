package com.example.servicepersonne.web;

import com.example.servicepersonne.Modele.CoursItem;
import com.example.servicepersonne.Modele.Personne;
import com.example.servicepersonne.Repositories.CoursItemRepository;
import com.example.servicepersonne.Repositories.PersonneRepository;
import com.example.servicepersonne.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class PersonneController {
    @Autowired
    PersonneRepository appUserRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CoursItemRepository coursItemRepository;
    @PostMapping("/register")
    public Personne register(@RequestBody UserForm userForm){

        return accountService.saveUser(userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword(),userForm.getNom(),userForm.getTel(),userForm.getPrenom());

    }
    @PostMapping("/registerProf")
    public Personne registerProf(@RequestBody UserForm userForm){

        return accountService.saveProf(userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword(),userForm.getNom(),userForm.getTel(),userForm.getPrenom());

    }
    @GetMapping("/users")
    public List<Personne> getpersonnes()
    {
        return appUserRepository.findAll() ;}
    @GetMapping("/getUser/{user}")
    public Personne getUser(@PathVariable("user") String username)
    {
        return appUserRepository.findByUsername(username);
    }
    @GetMapping("/addcours/{personneid}/{coursid}")
    public CoursItem addCours(@PathVariable("personneid") Long personneid, @PathVariable("coursid") Long coursid)
    {
        Personne p =appUserRepository.findById(personneid).get();
        CoursItem c = new CoursItem(null,coursid,null,p);
        coursItemRepository.save(c);
        return c;
    }
}

@Data
class UserForm{
    private String username;
    private String password;
    private String confirmedPassword;
    private String nom;
    private String prenom;
    private String tel;

}
