package com.testeSRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testeSRM.model.JurosVO;
import com.testeSRM.services.JurosService;

@Controller
@RequestMapping("/juros")
public class JurosController {
	@Autowired
	private JurosService jurosService;
	
	@CrossOrigin(origins = "https://teste-srm.herokuapp.com")
	@GetMapping
	@ResponseBody
	public List<JurosVO> findAll(){
		return jurosService.findAll();
	}
	
	@CrossOrigin(origins = "https://teste-srm.herokuapp.com")
	@PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
	public void saveJuros(@RequestBody JurosVO juros){
		jurosService.saveJuros(juros);
	}
}
