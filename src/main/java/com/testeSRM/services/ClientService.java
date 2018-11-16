package com.testeSRM.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testeSRM.model.ClientVO;
import com.testeSRM.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Transactional
	public List<ClientVO> findAll(){
		return clientRepository.findAll();
	}
	
	@Transactional
	public void saveClient(ClientVO client){
		clientRepository.save(client);
	}
}
