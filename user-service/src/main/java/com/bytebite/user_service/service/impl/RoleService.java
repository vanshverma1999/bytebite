package com.bytebite.user_service.service.impl;

import com.bytebite.user_service.exception.RoleNotFoundException;
import com.bytebite.user_service.model.Role;
import com.bytebite.user_service.repository.RoleRepository;
import com.bytebite.user_service.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {
    private final RoleRepository roleRepository;
    public Role createRole(Role role){
        return roleRepository.save(role);
    }
    public Role findByName(String role){
        return roleRepository.findByRoleEquals(role).orElseThrow(() -> new RoleNotFoundException("Role not found with name: "+ role));
    }
}
