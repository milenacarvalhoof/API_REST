package com.gft.sistema_politico.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.sistema_politico.models.Ministro;

@Repository
public interface MinistroRepository extends JpaRepository<Ministro, Long>{
	
	Page<Ministro> findAll(Pageable pageable);

}
