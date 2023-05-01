package com.gestion.Etudiants;

import com.gestion.Etudiants.model.AppRole;
import com.gestion.Etudiants.model.AppUser;
import com.gestion.Etudiants.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class EtudiantsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EtudiantsApplication.class, args);

	}
	@Bean
	PasswordEncoder passwordEncoder (){
		return new BCryptPasswordEncoder();
	}
	@Bean
       CommandLineRunner start (AccountService accountService){
		return args->{
			accountService.addRole(new AppRole(null,"user"));
			accountService.addRole(new AppRole(null,"userManager"));
			accountService.addRole(new AppRole(null,"admin"));

			accountService.addUser(new AppUser(null,"latifa","latifa123", new ArrayList<>()));
			accountService.addUser(new AppUser(null,"tasnime","123456", new ArrayList<>()));
			accountService.addUser(new AppUser(null,"Ahmed","ahmed2022", new ArrayList<>()));

			accountService.addRoleToUser("tasnime", "user");
			accountService.addRoleToUser("Ahmed","userManager");
			accountService.addRoleToUser("latifa","admin");

		};
}
}
