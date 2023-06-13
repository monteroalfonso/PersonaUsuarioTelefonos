package com.example.evaluacion.reposiroty;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.evaluacion.entity.Telefono;
@Repository
public interface TelefonoRepository extends CrudRepository<Telefono, Long> {

}
