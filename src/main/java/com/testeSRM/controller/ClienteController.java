package com.testeSRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.testeSRM.model.ClienteVO;
import com.testeSRM.services.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@CrossOrigin(origins = "*")
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<ClienteVO>> findAll(){
		return ResponseEntity.ok(clienteService.findAll());
	}

	@CrossOrigin(origins = "*")
	@PostMapping(path = "/salvar", consumes = "application/json", produces = "application/json")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<ClienteVO> saveClient(@RequestBody ClienteVO cliente){
		return ResponseEntity.ok(clienteService.salvarCliente(cliente));
	}
}
