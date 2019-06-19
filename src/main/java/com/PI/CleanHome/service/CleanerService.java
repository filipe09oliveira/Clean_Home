package com.PI.CleanHome.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PI.CleanHome.model.Cleaner;
import com.PI.CleanHome.repository.CleanerRepository;

@Service
public class CleanerService {
	
	@Autowired
	private CleanerRepository repository;
	
	@PersistenceContext
    private EntityManager manager;
	
	public List<Cleaner> findAll() {
		return repository.findAll();
	}
	
	public List<Cleaner> findAllAtivas() {
		return repository.findAllAtivas();
	}
	
	public List<Cleaner> findAllPendentes() {
		return repository.findAllPendentes();
	}

	public Cleaner findOne(Long id) {
		return repository.findById(id).get();
	}
	
	public void save(Cleaner cleaner) {
		repository.save(cleaner);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	
	}
	
	public Cleaner findByEmail(String email) {
		
		return repository.findByEmail(email);
		
	}
	
	/*public List<Cleaner> findAllPendentes(){
		return repository.findAllPendentes();
		
	}*/
	
}
