package com.andre.helpdeskback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.andre.helpdeskback.domain.Pessoa;


public interface UsuarioRepository extends JpaRepository<Pessoa, Integer>{

	UserDetails findByEmail(String email);
}
