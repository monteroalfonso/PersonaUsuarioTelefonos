package com.example.evaluacion.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.evaluacion.constants.Constantes;

public class Utils {

	
	public static String getSystenDate() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constantes.DATE_PATTERN);  
		String now = LocalDateTime.now().format(dtf);  		
		return now;
		
	}
	
	public static Boolean validaEmail(String email){
		
		Pattern pattern = Pattern.compile(Constantes.REGEX_PATTERN_EMAIL);
		Matcher matcher = pattern.matcher(email);
	
		return matcher.matches();
		
	}

	public static Boolean validaPassword(String password){
		
		Pattern pattern = Pattern.compile(Constantes.REGEX_PATTERN_PASSWORD);
		Matcher matcher = pattern.matcher(password);
  	    return matcher.matches(); 
		
	}	
	
	public static String getToken() {
	    byte[] randomBytes = new byte[24];
	    Constantes.SECURE_RANDOM.nextBytes(randomBytes);
	    return Constantes.BASE_64_ENCODER.encodeToString(randomBytes);
	}	
	
}
