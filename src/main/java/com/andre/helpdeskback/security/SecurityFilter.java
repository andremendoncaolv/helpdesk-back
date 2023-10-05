package com.andre.helpdeskback.security;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.andre.helpdeskback.domain.Pessoa;
import com.andre.helpdeskback.repositories.PessoaRepository;
import com.andre.helpdeskback.services.UserDetailsServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	private UserDetailsServiceImpl customUserDetailsService;
	
	public SecurityFilter(UserDetailsServiceImpl customUserDetailsService) {
	    this.customUserDetailsService = customUserDetailsService;
	  }
	
	@Autowired
	 TokenService tokenService;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 var token = this.recoverToken(request);
		    if(token !=null){
		      var email = tokenService.validateToken(token);
		      Optional<Pessoa> pessoa = pessoaRepository.findByEmail(email);
		      if (pessoa.isPresent()) {

		        UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
		        var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

		        // Set the authentication in the SecurityContext (if needed)
		        SecurityContextHolder.getContext().setAuthentication(authentication);
		      } else {
		        throw new RuntimeException();
		      }

		    }
		    filterChain.doFilter(request, response);
	}
	private String recoverToken(HttpServletRequest request) {
	    var authHeader = request.getHeader("Authorization");
	    if(authHeader == null) return null;
	    return authHeader.replace("Bearer ", "");
	  }
}
