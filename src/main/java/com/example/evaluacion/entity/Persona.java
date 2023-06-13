package com.example.evaluacion.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.evaluacion.model.request.PersonaRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_persona")
public class Persona {
	
	public Persona(PersonaRequest personaRequest) {
		// TODO Auto-generated constructor stub
		this.name = personaRequest.getName();
		this.email = personaRequest.getEmail();
		this.password = personaRequest.getPassword();
		this.telefonos = personaRequest.getTelefonos();
	}

	@Id
	@SequenceGenerator(name="persona_secuencia",
	sequenceName = "persona_secuencia",
	initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "persona_secuencia")
	@Column(name="persona_id")
	private Long id;
	
	@Column 
	private String name;

	@Column(unique = true) 
	private String email;
	
	@Column 
	private String password;	
	
	@OneToMany(
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
	)
	private List<Telefono> telefonos = new ArrayList();
	
}
