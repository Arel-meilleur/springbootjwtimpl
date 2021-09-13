package com.meilleur.jwt.repository;

import com.meilleur.jwt.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);    // en faisant findByUsername Jpa sait que c'est un select stement
}
