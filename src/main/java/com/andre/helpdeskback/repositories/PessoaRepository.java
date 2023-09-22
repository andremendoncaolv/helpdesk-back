package com.andre.helpdeskback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andre.helpdeskback.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
