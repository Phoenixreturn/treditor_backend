package com.devon.treditor.entity.security;

import org.springframework.security.core.GrantedAuthority;

public enum ERole implements GrantedAuthority {
	ROLE_USER, ROLE_MODERATOR, ROLE_ADMIN;

	@Override
	public String getAuthority() {
		return name();
	}
}
