package com.andre.helpdeskback.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.andre.helpdeskback.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa implements Serializable{

    private static final long serialVersionUID = 1L;
	
    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
	private List<Chamado> chamados = new ArrayList<>();

	public Cliente() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente(Integer id, String nome, String email, String cpf, String senha) {
		super(id, nome, email, cpf, senha);
		addPerfil(Perfil.CLIENTE);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	} 


}
