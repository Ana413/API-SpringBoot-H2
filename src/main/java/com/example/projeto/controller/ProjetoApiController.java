package com.example.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto.dto.DadosClienteDTO;
import com.example.projeto.dto.DadosClienteResponseDTO;
import com.example.projeto.service.ProjetoApiService;

@RestController
@RequestMapping("/cliente")
public class ProjetoApiController {

	@Autowired
	private ProjetoApiService service;

	@ResponseBody
	@PostMapping()
	public ResponseEntity<DadosClienteDTO> inserirDadosCliente(@RequestBody DadosClienteDTO body) {

		DadosClienteDTO response = service.inserirDadosClientes(body);

		return ResponseEntity.ok(response);
	}

	@ResponseBody
	@GetMapping()
	public ResponseEntity<DadosClienteDTO> consultarDadosCliente(@RequestParam(value = "id") Integer id) {

		DadosClienteDTO response = service.consultarDadosClientes(id);

		return ResponseEntity.ok(response);
	}
	
	@ResponseBody
	@GetMapping("/consulta")
	public ResponseEntity<List<DadosClienteDTO>> consultarDadosCliente() {

		List<DadosClienteDTO> response = service.consultarDadosClientes();

		return ResponseEntity.ok(response);
	}

	@ResponseBody
	@PatchMapping()
	public ResponseEntity<DadosClienteResponseDTO> atualizarDadosCliente(@RequestBody DadosClienteDTO body) throws Exception {

		DadosClienteResponseDTO response = service.atualizarDadosClientes(body);

		return ResponseEntity.ok(response);
	}
	
	@ResponseBody
	@DeleteMapping()
	public ResponseEntity<String> apagaDadosCliente(@RequestBody DadosClienteDTO body) throws Exception {

		String response = service.excluirDadosClientes(body);

		return ResponseEntity.ok(response);
	}

}
