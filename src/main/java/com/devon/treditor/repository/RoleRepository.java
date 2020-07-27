package com.devon.treditor.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devon.treditor.entity.ERole;
import com.devon.treditor.entity.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	Optional<Role> findByName(ERole name);
}
