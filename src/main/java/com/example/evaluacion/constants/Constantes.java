package com.example.evaluacion.constants;

import java.security.SecureRandom;
import java.util.Base64;

public class Constantes {

	public static final String REGEX_PATTERN_EMAIL = "^(.+)@(.+)$";
	public static final String REGEX_PATTERN_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9]+$";
	public static final String DATE_PATTERN = "yyyy/MM/dd HH:mm:ss";
	public static final Boolean USUARIO_ACTIVO = true;
	public static final Boolean USUARIO_INACTIVO = true;
	public static final SecureRandom SECURE_RANDOM = new SecureRandom();
	public static final Base64.Encoder BASE_64_ENCODER = Base64.getUrlEncoder();	
	public static final String ERROR_FORMATO_CORREO = "Error en el formato de correo ingresado";
	public static final String ERROR_FORMATO_CLAVE = "Error en el formato de la clave(Una mayuscula, una minuscula y un numero)";
	public static final String PERSONA_CREADA = "Persona creada correctamente";
	public static final String PERSONA_EXISTENTE = "El correo ya esta registrado";
	public static final String ERROR_NO_CONTROLADO = "Error no controlado";
	public static final String USUARIO_MODIFICADO = "Usario modificado correctamente";
	public static final String USUARIO_INEXISTENTE = "El correo no existe, no se puede modificar";
	
	
}
