package com.andre.helpdeskback.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andre.helpdeskback.domain.Pessoa;
import java.util.List;


public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

	Optional<Pessoa> findByCpf(String cpf);
	Optional<Pessoa> findByEmail(String email);
}
