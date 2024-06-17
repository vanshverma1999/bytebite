package com.bytebite.user_service.controller;

import com.bytebite.user_service.model.Role;
import com.bytebite.user_service.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/role")
public class RoleController {
    private final IRoleService roleService;

    @PostMapping("/")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return ResponseEntity.ok(roleService.createRole(role));
    }
}
