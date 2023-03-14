package com.mocktrack.api.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mocktrack.api.business.constant.ERole;
import com.mocktrack.api.persistance.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>
{
  Role findByRoleName(ERole roleName);
}
