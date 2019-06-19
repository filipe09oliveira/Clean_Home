package com.PI.CleanHome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.PI.CleanHome.model.Cleaner;

@Repository
@Transactional
public interface CleanerRepository extends JpaRepository<Cleaner, Long>{
	
	public Cleaner findByEmail(String email);
	
	@Query(value = "select * from cleaner where status = 'ativo'", nativeQuery = true)
	List<Cleaner> findAllAtivas();
	
	@Query(value = "select * from cleaner where status = 'pendente'", nativeQuery = true)
	List<Cleaner> findAllPendentes();
}
