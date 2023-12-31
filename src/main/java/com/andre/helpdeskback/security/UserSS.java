package com.andre.helpdeskback.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.andre.helpdeskback.domain.enums.Perfil;

public class UserSS implements UserDetails {

	private static final long serialVersionUID = 1L;
	private final Integer id;
	private final String email;
	private final String password;

	private final Collection<? extends GrantedAuthority> Authorities;

	public UserSS(Integer id, String email, String password, Set<Perfil> perfilSet) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.Authorities = perfilSet.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao()))
				.collect(Collectors.toSet());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Integer getId() {
		return id;
	}

}
