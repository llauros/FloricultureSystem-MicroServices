package com.microservice.loja.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.microservice.loja.dto.CompraDTO;
import com.microservice.loja.dto.InfoFornecedorDTO;

public class CompraService {

	public void realizaCompra(CompraDTO compra) {
		
		RestTemplate client = new RestTemplate();
		ResponseEntity<InfoFornecedorDTO> exchange;
		exchange = client.exchange("http://localhost:8081/info/" + compra.getEndereco().getEstado(),
				HttpMethod.GET, null, InfoFornecedorDTO.class);
		
		System.out.println(exchange.getBody().getEndereco());
	}

}
