package com.andre.helpdeskback.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.andre.helpdeskback.domain.Person;
import com.andre.helpdeskback.repositories.PersonRepository;
import com.andre.helpdeskback.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private final PersonRepository personRepository;

  public UserDetailsServiceImpl(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<Person> user = personRepository.findByEmail(email);
    if(user.isPresent()){
      return new UserSS(user.get().getId(), user.get().getEmail(), user.get().getPassword(), user.get().getProfiles());
    }
    throw new UsernameNotFoundException("User Not Found with email: " + email);
  }
}