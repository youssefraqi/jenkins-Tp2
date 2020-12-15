package com.example.servicepersonne;
import com.example.servicepersonne.Modele.Role;
import com.example.servicepersonne.Repositories.RoleRepository;
import com.example.servicepersonne.service.AccountService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class ServicePersonneApplication  implements CommandLineRunner {

	@Autowired
	AccountService accountService;


	public static void main(String[] args) { SpringApplication.run(ServicePersonneApplication.class, args); }

	@Bean
	BCryptPasswordEncoder getBCPE(){
		return new BCryptPasswordEncoder();


	}

	@Override
	public void run(String... args) throws Exception {
		/*
		accountService.save(new Role(null,"ETUD"));
		accountService.save(new Role(null,"ADMIN"));
		accountService.save(new Role(null,"PROF"));

		 */



	}
}
