package com.gft.sistema_politico.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.sistema_politico.models.Governador;

@Repository
public interface GovernadorRepository extends JpaRepository<Governador, Long>{
	
	Page<Governador> findAll(Pageable pageable);

}
