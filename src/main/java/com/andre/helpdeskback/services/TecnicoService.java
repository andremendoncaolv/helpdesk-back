package com.andre.helpdeskback.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.helpdeskback.domain.Pessoa;
import com.andre.helpdeskback.domain.Tecnico;
import com.andre.helpdeskback.domain.dtos.TecnicoDTO;
import com.andre.helpdeskback.repositories.PessoaRepository;
import com.andre.helpdeskback.repositories.TecnicoRepository;
import com.andre.helpdeskback.services.exceptions.DataIntegrityViolationException;
import com.andre.helpdeskback.services.exceptions.ObjectnotFoundException;

import jakarta.validation.Valid;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaService;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id:" + id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);
	}

	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		objDTO.setId(id);
		Tecnico oldObj = findById(id);
//		validaPorCpfEEmail(objDTO);
		oldObj = new Tecnico(objDTO);
		return repository.save(oldObj);
	}
	
	private void validaPorCpfEEmail(TecnicoDTO objDTO) {
		Optional<Pessoa> obj = pessoaService.findByCpf(objDTO.getCpf());	
		if(obj.isPresent()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}
		
		obj = pessoaService.findByEmail(objDTO.getEmail());
		if(obj.isPresent()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}

}
