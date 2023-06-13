package com.example.evaluacion.model.request;

import java.util.ArrayList;
import java.util.List;

import com.example.evaluacion.entity.Telefono;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaRequest {

	private String name;
	private String email;
	private String password;

	private List<Telefono> telefonos = new ArrayList();
	
}
