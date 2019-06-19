package com.PI.CleanHome.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PI.CleanHome.model.Cliente;
import com.PI.CleanHome.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@PersistenceContext
    private EntityManager manager;
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente findOne(Long id) {
		return repository.findById(id).get();
	}
	
	public void save(Cliente cliente) {
		repository.save(cliente);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	
	}
	
	public Cliente findByEmail(String email) {
		
		return repository.findByEmail(email);
		
	}

}
