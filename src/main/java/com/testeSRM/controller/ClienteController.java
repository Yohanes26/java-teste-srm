package com.testeSRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testeSRM.model.ClienteVO;
import com.testeSRM.services.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	@ResponseBody
	public List<ClienteVO> findAll(){
		return clienteService.findAll();
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ClienteVO saveCliente(@RequestBody ClienteVO cliente){
		return clienteService.saveCliente(cliente);
	}
}
