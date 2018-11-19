package com.testeSRM.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testeSRM.model.ClienteVO;
import com.testeSRM.repository.ClientRepository;

@Service
public class ClienteService {

	@Autowired
	private ClientRepository clienteRepository;
	
	@Transactional
	public List<ClienteVO> findAll(){
		return clienteRepository.findAll();
	}
	
	@Transactional
	public ClienteVO salvarCliente(ClienteVO cliente){
		return clienteRepository.save(cliente);
	}
}
