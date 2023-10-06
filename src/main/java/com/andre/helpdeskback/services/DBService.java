package com.andre.helpdeskback.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		
		@Autowired
		private BCryptPasswordEncoder encoder;

		public void instanciaDB() {
			
		Tecnico tec1 = new Tecnico(null, "Andre Mendonca", "andre@email.com", "61394022042", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		
		// Criar técnicos
	    Tecnico tec2 = new Tecnico(null,"John Doe", "john.doe@example.com", "03783764386" , encoder.encode("123"));
	    Tecnico tec3 = new Tecnico(null,"Mary Johnson", "mary.johnson@example.com", "11228847614",  encoder.encode("123"));
	    Tecnico tec4 = new Tecnico(null,"Robert Smith", "robert.smith@example.com", "85752968097",  encoder.encode("123"));
	    Tecnico tec5 = new Tecnico(null,"Jane Doe", "jane.doe@example.com", "84445767867",  encoder.encode("123"));
	    Tecnico tec6 = new Tecnico(null,"Michael Johnson", "michael.johnson@example.com", "62218888327",  encoder.encode("123"));
	    Tecnico tec7 = new Tecnico(null,"Emily Smith", "emily.smith@example.com", "92241975583",  encoder.encode("123"));

	    tec2.addPerfil(Perfil.TECNICO);
	    tec3.addPerfil(Perfil.TECNICO);
	    tec4.addPerfil(Perfil.TECNICO);
	    tec5.addPerfil(Perfil.TECNICO);
	    tec6.addPerfil(Perfil.TECNICO);
	    tec7.addPerfil(Perfil.TECNICO);
		
		
		
		Cliente cli1 = new Cliente(null,"Linus Torvalds", "linux@linux.com.br", "14178441590",  encoder.encode("123"));
		Cliente cli2 = new Cliente(null,"Alice Johnson", "alice.johnson@example.com", "36562882168",  encoder.encode("123"));
		Cliente cli3 = new Cliente(null,"David Smith", "david.smith@example.com", "38322565399",  encoder.encode("123"));
		Cliente cli4 = new Cliente(null,"Sarah Doe", "sarah.doe@example.com", "61317166337",  encoder.encode("123"));
		Cliente cli5 = new Cliente(null,"Robert Johnson", "robert.johnson@example.com", "21466730790",  encoder.encode("123"));
		Cliente cli6 = new Cliente(null,"Emily Davis", "emily.davis@example.com", "82987592736",  encoder.encode("123"));
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 02", "Segundo chamado", tec2, cli2);
		Chamado c3 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 03", "Terceiro chamado", tec3, cli3);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, tec6, tec7));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3));
	}
		
		public void instanciaProdDB() {
			Tecnico tec1 = new Tecnico(null, "Andre Mendonca", "andre@email.com", "61394022042", encoder.encode("123"));
			tec1.addPerfil(Perfil.ADMIN);
			
			tecnicoRepository.saveAll(Arrays.asList(tec1));
		}
}
