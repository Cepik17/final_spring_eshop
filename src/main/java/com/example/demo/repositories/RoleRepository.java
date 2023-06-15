package com.example.demo.repositories;

import com.example.demo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select r from Role r where r.name = 'User'")
    Role getUserRole();

    Role getRoleById(Long id);
    List<Role> getRolesById(Long id);
}
