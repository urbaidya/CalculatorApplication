package com.sopra.scientific.calculator.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int userid;
	private String fullname;
	private String username;
	private String password;
}
