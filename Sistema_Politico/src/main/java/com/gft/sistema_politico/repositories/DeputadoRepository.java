package com.gft.sistema_politico.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.sistema_politico.models.Deputado;

@Repository
public interface DeputadoRepository extends JpaRepository<Deputado, Long>{
	
	Page<Deputado> findAll(Pageable pageable);

}
