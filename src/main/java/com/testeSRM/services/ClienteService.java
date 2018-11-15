package com.testeSRM.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testeSRM.model.ClienteVO;
import com.testeSRM.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public List<ClienteVO> findAll(){
		return clienteRepository.findAll();
	}
}
