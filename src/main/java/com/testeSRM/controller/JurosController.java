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
import com.testeSRM.model.JurosVO;
import com.testeSRM.services.JurosService;

@Controller
@RequestMapping("/juros")
public class JurosController {
	@Autowired
	private JurosService jurosService;
	
	@CrossOrigin(origins = "*")
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<JurosVO>> findAll(){
		return ResponseEntity.ok(jurosService.findAll());
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/salvar", consumes = "application/json", produces = "application/json")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<JurosVO> salvarJuros(@RequestBody JurosVO juros){
		return ResponseEntity.ok(jurosService.salvarJuros(juros));
	}
}
