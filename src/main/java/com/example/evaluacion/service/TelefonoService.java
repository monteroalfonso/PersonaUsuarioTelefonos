package com.example.evaluacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.evaluacion.entity.Persona;
import com.example.evaluacion.entity.Telefono;

@Service
public interface TelefonoService {

	public void createTelefono(List<Telefono> telefono, Persona persona);
	
}