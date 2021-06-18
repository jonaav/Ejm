package com.everis.entity;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
@Entity
public class Region implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
}
