package com.example.evaluacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_telefono")
public class Telefono {
	
	@Id
	@SequenceGenerator(name="telefono_secuencia",
	sequenceName = "telefono_secuencia",
	initialValue = 3000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "telefono_secuencia")
	@Column(name="telefono_id")
	private Integer id;
	
	@Column 
	private Long numero;
	
	@Column
	private Integer codigoCiudad;

	@Column 
	private Integer codigoPais;	

	@ManyToOne(fetch = FetchType.LAZY,
			   optional = false
	)
	@JoinColumn(name = "persona_id" )
	private Persona persona;	
	
}
