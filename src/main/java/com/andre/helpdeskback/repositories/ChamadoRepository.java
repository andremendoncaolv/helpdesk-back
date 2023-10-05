package com.andre.helpdeskback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andre.helpdeskback.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
