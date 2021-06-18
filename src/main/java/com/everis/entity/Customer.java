package com.everis.entity;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "El número de documento no puede ser vacío")
	@Size(min = 8, max = 8, message = "El tamaño de numero de documento es 8")
	private String numberID;
	
	@NotEmpty(message = "El nombre no puede ser vacio")
	private String firstName;
	
	@NotEmpty(message = "El apellido no puede ser vacio")
	private String lastName;
	
	
	@NotEmpty(message = "El correo no puede ser vacio")
	@Email(message = "No es una dirección de correo bien formada")
	private String email;
	
	private String photoUrl;
	
	@NotEmpty(message = "El nombre no puede ser vacio")
	private Region region;
	
	private String state;
	
	
	
	

}
