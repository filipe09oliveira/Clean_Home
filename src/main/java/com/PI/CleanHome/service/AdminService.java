package com.PI.CleanHome.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PI.CleanHome.model.Admin;
import com.PI.CleanHome.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
		
	@PersistenceContext
    private EntityManager manager;
	
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}
	
	public Admin get(Long id) {
		return adminRepository.findById(id).get();
		
	}
	public void save(Admin admin) {
		adminRepository.save(admin);
	}
	
	public void delete(Long id) {
		adminRepository.deleteById(id);
	
	}
	
	public Admin findByEmail(String email) {
		
		return adminRepository.findByEmail(email);
	}
	
}
