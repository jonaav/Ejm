package com.everis.customerms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customer")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "El número de documento no puede ser vacío")
	@Size(min = 8, max = 8, message = "El tamaño de numero de documento es 8")
	private String numberId;
	
	@NotEmpty(message = "El nombre no puede ser vacio")
	private String firstName;
	
	@NotEmpty(message = "El apellido no puede ser vacio")
	private String lastName;
	
	
	@NotEmpty(message = "El correo no puede ser vacio")
	@Email(message = "No es una dirección de correo bien formada")
	@Column(length = 20)
	private String email;
	
	private String photoUrl;
	
	//@NotEmpty(message = "El nombre no puede ser vacio")
	@JoinColumn(name="region_id", foreignKey = @ForeignKey(name="fk_region_id"))
	@ManyToOne
	private Region region;
	
	private String state;
	
	
	
	

}
