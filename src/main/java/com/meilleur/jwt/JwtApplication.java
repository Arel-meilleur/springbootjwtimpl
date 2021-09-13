package com.meilleur.jwt;

import com.meilleur.jwt.domain.AppUser;
import com.meilleur.jwt.domain.Role;
import com.meilleur.jwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    CommandLineRunner run(UserService userService){
//        return args -> {
//            userService.saveRole(new Role(null, "ROLE_USER"));
//            userService.saveRole(new Role(null, "ROLE_MANAGER"));
//            userService.saveRole(new Role(null, "ROLE_ADMIN"));
//            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//
//            userService.saveUser((new AppUser(null, "Best ", "best","1234",new ArrayList<>())));
////            userService.saveUser((new AppUser(null, "Sdsf ", "sdqs","1234",new ArrayList<>())));
////            userService.saveUser((new AppUser(null, "Fdss ", "eze","1234",new ArrayList<>())));
////            userService.saveUser((new AppUser(null, "Qsqds ", "zefef","1234",new ArrayList<>())));
//
//
////            userService.addRoleToUser("best","ROLE_USER");
////            userService.addRoleToUser("ssqd","ROLE_MANAGER");
////            userService.addRoleToUser("besqfdt","ROLE_ADMIN");
////            userService.addRoleToUser("besdst","ROLE_SUPER_ADMIN");
//        };
//    }

}
