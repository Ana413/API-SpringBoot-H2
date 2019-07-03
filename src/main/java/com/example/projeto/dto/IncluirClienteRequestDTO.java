package com.example.projeto.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value="data")
@JsonTypeInfo(include=As.WRAPPER_OBJECT, use=Id.NAME)
public class IncluirClienteRequestDTO implements Serializable{

	private static final long serialVersionUID = -1627907604482959253L;

	@JsonProperty(value="nome")
	private String nome;
	
	@JsonProperty(value="cpf")
	private String cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
}
