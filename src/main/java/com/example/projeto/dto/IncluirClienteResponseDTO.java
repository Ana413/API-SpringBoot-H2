package com.example.projeto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeName(value="data")
@JsonTypeInfo(include=As.WRAPPER_OBJECT, use=Id.NAME)
public class IncluirClienteResponseDTO {
	
	@JsonProperty(value="id")
	private Integer id;
	
	public IncluirClienteResponseDTO() {
	}

	public IncluirClienteResponseDTO(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
