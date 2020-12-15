package com.example.servicepersonne.sec;

import com.example.servicepersonne.Modele.Personne;
import com.example.servicepersonne.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
        @Autowired
        private AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Personne appUser = accountService.loadUserByUsername(username);
        if(appUser == null) throw new UsernameNotFoundException("invalid user");
        if (!appUser.isActived())
        {
            throw new UsernameNotFoundException("not actived");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        appUser.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getNom()));
        });
        return new User(appUser.getUsername(),appUser.getPassword(),authorities);

    }
}
