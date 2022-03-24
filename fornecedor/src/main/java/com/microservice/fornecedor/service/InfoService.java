package com.microservice.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.fornecedor.models.InfoFornecedor;
import com.microservice.fornecedor.repository.InfoRepository;

@Service
public class InfoService {

	@Autowired
	private InfoRepository infoRepository;
	
	public InfoFornecedor getInfoPorEstado(String estado) {
		return infoRepository.findByEstado(estado);
	}
}
