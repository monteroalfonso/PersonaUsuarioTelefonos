package com.example.evaluacion.model.response;

import com.example.evaluacion.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioResponse {

	private Long id;
	private String created;
	private String modified;	
	private String lastLogin;
	private String token;
	private Boolean isActive;	
	
	public UsuarioResponse(Usuario usuario){
		this.id = usuario.getId();
		this.created = usuario.getCreated();
		this.modified = usuario.getModified();
		this.lastLogin = usuario.getLastLogin();
		this.token = usuario.getToken();
		this.isActive = usuario.getIsActive();	
	}

}