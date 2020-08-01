package com.devon.treditor.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devon.treditor.entity.security.ERole;
import com.devon.treditor.entity.security.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	Optional<Role> findByName(ERole name);
}
