package com.example.projeto.service;

import java.util.List;

import com.example.projeto.dto.DadosClienteDTO;
import com.example.projeto.dto.DadosClienteResponseDTO;
import com.example.projeto.dto.IncluirClienteResponseDTO;

public interface ProjetoApiService {

	DadosClienteDTO inserirDadosClientes(DadosClienteDTO body);

	DadosClienteDTO consultarDadosClientes(Integer id);
	
	List<DadosClienteDTO> consultarDadosClientes();

	DadosClienteResponseDTO atualizarDadosClientes(DadosClienteDTO body) throws Exception;

	String excluirDadosClientes(DadosClienteDTO body) throws Exception;

}
