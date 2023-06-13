package com.example.evaluacion.reposiroty;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.evaluacion.entity.Persona;
import com.example.evaluacion.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	Usuario findByIsActive(Boolean isactive);
	Usuario findByPersona(Persona persona);
}
