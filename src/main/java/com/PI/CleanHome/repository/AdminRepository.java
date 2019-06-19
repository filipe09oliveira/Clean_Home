package com.PI.CleanHome.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.PI.CleanHome.model.Admin;


@Repository
@Transactional
public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	public Admin findByEmail(String email);
	
	
}
