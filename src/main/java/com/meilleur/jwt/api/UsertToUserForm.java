package com.meilleur.jwt.api;

import com.meilleur.jwt.domain.Role;
import com.meilleur.jwt.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsertToUserForm {
//    private final UserService userService;
//
//    @GetMapping("/users")
//    public ResponseEntity<List<User>> getUsers(){
//        return ResponseEntity.ok().body(userService.getUsers());
//    }
//    @PostMapping("/user/save")
//    public ResponseEntity<User> saveUser(@RequestBody User user){
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
//        return ResponseEntity.created(uri).body(userService.saveUser(user));
//    }
//
//    @PostMapping("/role/save")
//    public ResponseEntity<Role> saveRole(@RequestBody Role role){
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
//        return ResponseEntity.created(uri).body(userService.saveRole(role));
//    }

//    @PostMapping("/role/addtouser")
//    public ResponseEntity<?> addRoleToUser(@RequestBody com.meilleur.jwt.controller.RoleToUserForm form){
//        userService.addRoleToUser(form.getUsername(), form.getRoleNmae());
//        return ResponseEntity.ok().build();
//    }



}
//@Data
//class RoleToUserForm {
//    private String username;
//    private String roleNmae;
//}

