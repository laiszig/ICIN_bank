package com.laiszig.icin_bank_service.repository;

import com.laiszig.icin_bank_service.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByName(String name);
}
