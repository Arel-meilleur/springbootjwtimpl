package com.meilleur.jwt.service;

import com.meilleur.jwt.domain.AppUser;
import com.meilleur.jwt.domain.Role;

import java.util.List;

public interface UserService {

    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
