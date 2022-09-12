package com.chizzy.jpnd.demo.repository;

import com.chizzy.jpnd.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
