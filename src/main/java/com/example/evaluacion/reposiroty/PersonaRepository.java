package com.example.evaluacion.reposiroty;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.evaluacion.entity.Persona;
@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {
	public abstract Persona findByEmail(String email);
}
