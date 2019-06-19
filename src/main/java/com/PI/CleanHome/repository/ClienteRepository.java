package com.PI.CleanHome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.PI.CleanHome.model.Cliente;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	public Cliente findByEmail(String email);

}
