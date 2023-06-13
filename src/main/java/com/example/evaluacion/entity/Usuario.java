package com.example.evaluacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name="tbl_usuario")
public class Usuario {
	
	public Usuario(Usuario usuario) {
		// TODO Auto-generated constructor stub
		this.id = usuario.getId();
		this.created = usuario.getCreated();
		this.modified = usuario.getModified();
		this.lastLogin = usuario.getLastLogin();
		this.token = usuario.getToken();
		this.isActive = usuario.getIsActive();
		this.persona = usuario.getPersona();
	}

	@Id
	@SequenceGenerator(name="usuario_secuencia",
	sequenceName = "usuario_secuencia",
	initialValue = 2000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "usuario_secuencia")
	@Column(name="usuario_id")
	private Long id;
	
	@Column 
	private String created;

	@Column 
	private String modified;
	
	@Column 
	private String lastLogin;
	
	@Column 
	private String token;
	
	@Column 
	private Boolean isActive;
	
	@OneToOne(fetch = FetchType.EAGER,
			   optional = false
	)
//	@JoinColumn(name = "persona_id" )
	private Persona persona;	
	
}
