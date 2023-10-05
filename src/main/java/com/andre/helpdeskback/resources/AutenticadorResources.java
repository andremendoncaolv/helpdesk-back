package com.andre.helpdeskback.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andre.helpdeskback.domain.dtos.CredenciasDTO;
import com.andre.helpdeskback.domain.dtos.LoginResponseDTO;
import com.andre.helpdeskback.security.TokenService;
import com.andre.helpdeskback.security.UserSS;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticadorResources {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid CredenciasDTO credenciasDTO) {

		var usernamePassword = new UsernamePasswordAuthenticationToken(credenciasDTO.email(), credenciasDTO.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);

		var token = tokenService.generateToken((UserSS) auth.getPrincipal());
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
}
