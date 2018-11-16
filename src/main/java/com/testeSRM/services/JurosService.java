package com.testeSRM.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testeSRM.model.JurosVO;
import com.testeSRM.repository.JurosRepository;

@Service
public class JurosService {
	@Autowired
	private JurosRepository jurosRepository;
	
	@Transactional
	public List<JurosVO> findAll(){
		return jurosRepository.findAll();
	}
	
	@Transactional
	public void saveJuros(JurosVO juros){
		jurosRepository.save(juros);
	}
}
