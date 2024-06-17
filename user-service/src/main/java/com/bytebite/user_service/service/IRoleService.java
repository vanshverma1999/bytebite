package com.bytebite.user_service.service;

import com.bytebite.user_service.model.Role;

public interface IRoleService {
    Role createRole(Role role);
    Role findByName(String role);
}
