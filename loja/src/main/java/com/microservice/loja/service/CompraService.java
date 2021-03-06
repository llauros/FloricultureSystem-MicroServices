package com.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.loja.dto.CompraDTO;
import com.microservice.loja.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	@Autowired
	private RestTemplate client;
	
	@Autowired
	private DiscoveryClient eurekaCLient;	
	
	public void realizaCompra(CompraDTO compra) {

		ResponseEntity<InfoFornecedorDTO> exchange;
		exchange = client.exchange("http://fornecedor/info/" + compra.getEndereco().getEstado(),
				HttpMethod.GET, null, InfoFornecedorDTO.class);
		
		eurekaCLient.getInstances("fornecedor").stream()
		.forEach(fornecedor -> {
			System.out.println("fornecedor: " + fornecedor.getPort());
		});
		
		System.out.println(exchange.getBody().getEndereco());
	}

}
