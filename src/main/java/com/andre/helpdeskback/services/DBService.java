package com.andre.helpdeskback.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.helpdeskback.domain.Chamado;
import com.andre.helpdeskback.domain.Cliente;
import com.andre.helpdeskback.domain.Tecnico;
import com.andre.helpdeskback.domain.enums.Perfil;
import com.andre.helpdeskback.domain.enums.Prioridade;
import com.andre.helpdeskback.domain.enums.Status;
import com.andre.helpdeskback.repositories.ChamadoRepository;
import com.andre.helpdeskback.repositories.ClienteRepository;
import com.andre.helpdeskback.repositories.TecnicoRepository;

@Service
public class DBService {
	
	//Injeção de dependenicas
		@Autowired
		private TecnicoRepository tecnicoRepository;
		@Autowired 
		private ClienteRepository clienteRepository;
		@Autowired
		private ChamadoRepository chamadoRepository;
		

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Andre Mendonca", "58744114028", "andre@email.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "32967328022", "linus@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
