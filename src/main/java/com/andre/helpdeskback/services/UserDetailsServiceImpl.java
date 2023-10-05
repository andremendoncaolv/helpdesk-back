package com.andre.helpdeskback.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.andre.helpdeskback.domain.Pessoa;
import com.andre.helpdeskback.repositories.PessoaRepository;
import com.andre.helpdeskback.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final PessoaRepository pessoaRepository;

    UserDetailsServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Pessoa> usuario = pessoaRepository.findByEmail(email);
		if(usuario.isPresent()) {
			return new UserSS(usuario.get().getId(), usuario.get().getEmail(), usuario.get().getSenha(), usuario.get().getPerfis());
		}
		throw new UsernameNotFoundException("User Not Found with email: " + email);
	}

}
