package com.testeSRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@CrossOrigin(origins = "https://teste-srm.herokuapp.com")
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<ClientVO>> findAll(){
		return ResponseEntity.ok(clientService.findAll());
	}

	@CrossOrigin(origins = "https://teste-srm.herokuapp.com")
	@PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ClientVO> saveClient(@RequestBody ClientVO client){
		return ResponseEntity.ok(clientService.saveClient(client));
	}
}
