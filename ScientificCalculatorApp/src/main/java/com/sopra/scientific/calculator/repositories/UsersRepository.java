package com.sopra.scientific.calculator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.scientific.calculator.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);

}
