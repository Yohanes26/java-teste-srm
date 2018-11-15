package com.testeSRM.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ClienteVO {
	
	@Id
	private String id;
	
	private String nome;
	private BigDecimal limiteCredito;
	private String risco;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public String getRisco() {
		return risco;
	}
	public void setRisco(String risco) {
		this.risco = risco;
	}
	
}
