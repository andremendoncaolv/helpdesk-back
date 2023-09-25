package com.andre.helpdeskback.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.helpdeskback.domain.Tecnico;
import com.andre.helpdeskback.repositories.TecnicoRepository;
import com.andre.helpdeskback.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id:" + id));
	}

}
