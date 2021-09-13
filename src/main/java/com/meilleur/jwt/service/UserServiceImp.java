package com.meilleur.jwt.service;

import com.meilleur.jwt.domain.AppUser;
import com.meilleur.jwt.domain.Role;
import com.meilleur.jwt.repository.RoleRepository;
import com.meilleur.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import java.rmi.server.LogStream.log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor // permet a lombook de créer des constructeurs sur mes attributs privé  et les injecté
@Transactional  // Tout dois etre transactionnerl
@Slf4j // On vera se qui ser passera dans le log
public class UserServiceImp implements UserService, UserDetailsService {

//    Logger logger= (Logger) LoggerFactory.getLogger(UserDetailsService.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found in the database");
        }else {
            System.out.println("On veras bien");
        }
        Collection<SimpleGrantedAuthority> autorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            autorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),autorities);
    }

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Sovegarde de {} l'utilisateur" , user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
//        logger.info("Sovagager {} du role", role.getName());
        return roleRepository.save(role);
    }


    @Override
    public void addRoleToUser(String username, String roleName) {
//        logger.info("Ajout  {} du role un utilisateur {}", username, roleName);
        AppUser user = userRepository.findByUsername(username);
        Role role = roleRepository.findRoleByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return userRepository.findAll();
    }


}
