package com.example.projeto.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projeto.dto.DadosClienteDTO;
import com.example.projeto.dto.DadosClienteResponseDTO;
import com.example.projeto.mapper.ProjetoApiMapper;
import com.example.projeto.repository.ProjetoApiRepository;
import com.example.projeto.repository.entity.ProjetoApiEntity;
import com.example.projeto.service.ProjetoApiService;

@Service
public class ProjetoApiServiceImpl implements ProjetoApiService{

	@Autowired
	private ProjetoApiRepository projetoApiRepository;
	
	@Override
	@Transactional
	public DadosClienteDTO inserirDadosClientes(DadosClienteDTO body) {
		
		ProjetoApiEntity response =  ProjetoApiMapper.to(body);
		
		response = projetoApiRepository.save(response);
		
		DadosClienteDTO dtoResponse = new DadosClienteDTO();
		dtoResponse.setId(response.getId());
		
		return dtoResponse;
	}

	@Override
	public DadosClienteDTO consultarDadosClientes(Integer id) {
		
		DadosClienteDTO dadosRetorno = new DadosClienteDTO();
		
		Optional<ProjetoApiEntity> response = projetoApiRepository.findById(id);
		
		if(response.isPresent()) {
			dadosRetorno = ProjetoApiMapper.from(response.get());
		}	
		return dadosRetorno;
	}
	
	@Override
	public List<DadosClienteDTO> consultarDadosClientes() {
		
		List<DadosClienteDTO>dadosRetorno = new ArrayList<>();
		
		List<ProjetoApiEntity> response = projetoApiRepository.findAll();
		response.forEach(d -> {
			DadosClienteDTO	dados = ProjetoApiMapper.from(d);
			dadosRetorno.add(dados);
		});

		return dadosRetorno;
	}

	@Override
	public DadosClienteResponseDTO atualizarDadosClientes(DadosClienteDTO body) throws Exception {
		
		DadosClienteResponseDTO dtoResponse = new DadosClienteResponseDTO();
		
		ProjetoApiEntity validaCliente = validaCliente(body.getId());
		validaCliente.setNome(body.getNome());

		ProjetoApiEntity dados = projetoApiRepository.save(validaCliente);
		dtoResponse.setNome(dados.getNome());
		dtoResponse.setId(dados.getId());
		dtoResponse.setCpf(dados.getCpf());

		return dtoResponse;
	}

	@Override
	public String excluirDadosClientes(DadosClienteDTO body) throws Exception {
		
		validaCliente(body.getId());
		
		projetoApiRepository.deleteById(body.getId());
		
		return "Dados do Usuario Excluido";
	}

	
	private ProjetoApiEntity validaCliente(Integer id) throws Exception {
		
		Optional<ProjetoApiEntity> responde = projetoApiRepository.findById(id);
		
		if(responde.isPresent()) {
			return responde.get();
		} else {
			throw new Exception();
		}	
	}
}
