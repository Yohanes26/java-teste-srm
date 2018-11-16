package com.testeSRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testeSRM.model.ClientVO;
import com.testeSRM.services.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping
	@ResponseBody
	public List<ClientVO> findAll(){
		return clientService.findAll();
	}
	
	@PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
	public void saveClient(@RequestBody ClientVO client){
		clientService.saveClient(client);
	}
}
