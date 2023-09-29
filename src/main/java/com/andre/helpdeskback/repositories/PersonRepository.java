package com.andre.helpdeskback.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.helpdeskback.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

  boolean existsByCpf(String cpf);

  boolean existsByEmail(String email);

  Optional<Person> findByEmail(String email);
}
