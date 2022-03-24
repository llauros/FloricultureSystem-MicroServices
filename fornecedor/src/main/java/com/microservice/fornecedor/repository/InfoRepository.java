package com.microservice.fornecedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.fornecedor.models.InfoFornecedor;

@Repository
public interface InfoRepository extends JpaRepository<InfoFornecedor, Long>{

	InfoFornecedor findByEstado(String estado);
	
}