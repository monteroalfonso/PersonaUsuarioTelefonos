package com.example.evaluacion.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.evaluacion.entity.Persona;
import com.example.evaluacion.entity.Telefono;
import com.example.evaluacion.reposiroty.TelefonoRepository;
import com.example.evaluacion.service.TelefonoService;

@Service
public class TelefonoServiceImpl implements TelefonoService{

	@Autowired(required=true)
	TelefonoRepository telefonoRepository;

	@Override
	public void createTelefono(List<Telefono> telefono, Persona persona) {
		
    	List<Telefono> telefonos = new ArrayList();
    	
    	for(Telefono element : telefono) {
    		element.setPersona(persona);
    		telefonos.add(element);
    	}
    	
		telefonoRepository.saveAll(telefonos);		
	}	
	
}
