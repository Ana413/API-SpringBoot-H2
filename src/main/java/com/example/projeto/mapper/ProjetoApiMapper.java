package com.example.projeto.mapper;

import java.util.Optional;

import com.example.projeto.dto.DadosClienteDTO;
import com.example.projeto.repository.entity.ProjetoApiEntity;

public class ProjetoApiMapper {

	public static ProjetoApiEntity to(DadosClienteDTO body) {
		
		ProjetoApiEntity projetoApiEntity = new ProjetoApiEntity();
		projetoApiEntity.setNome(body.getNome());
		projetoApiEntity.setCpf(body.getCpf());
		projetoApiEntity.setId(body.getId());
		
		return projetoApiEntity;
	}

	public static DadosClienteDTO from(ProjetoApiEntity responde) {
		
		DadosClienteDTO dto = new DadosClienteDTO();
		dto.setCpf(responde.getCpf());
		dto.setId(responde.getId());
		dto.setNome(responde.getNome());
		
		return dto;
	}

}
