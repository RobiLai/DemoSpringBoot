package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.ClienteDto;
import com.demo.model.Cliente;

@RestController
public class RestProvaDtoController {


	@Autowired
	private ModelMapper clienteMapper;
	
	@GetMapping("/findById")
	public ClienteDto findById(){
		Cliente c = new Cliente();
		c.setId(3);
		c.setNome("Giacomo");
		c.setCognome("Poretti");
		return convertToClienteDto(c);
	}
	
	@GetMapping("/findAll")
	public List<ClienteDto> findAll(){
		
		List<Cliente> listaClienti = new ArrayList<>();
		
		Cliente c1 = new Cliente();
		c1.setId(4);
		c1.setNome("Giova");
		c1.setCognome("Storti");
		
		listaClienti.add(c1);
		
		Cliente c2 = new Cliente();
		c2.setId(5);
		c2.setNome("Aldo");
		c2.setCognome("Baglio");
		
		listaClienti.add(c2);
		
		List<ClienteDto> listaClientiDto = new ArrayList<>();
		
		for(Cliente c : listaClienti) {
			
			ClienteDto clienteDto = new ClienteDto();
			
			clienteDto = convertToClienteDto(c);
			
			listaClientiDto.add(clienteDto);
			
		}
		
		return listaClientiDto;
		
	}
	
	@PostMapping("/createClientebyDto")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ClienteDto createCliente(@RequestBody ClienteDto cDto) {
		
		Cliente c = convertToCliente(cDto);
		c.setId(6);
		c.setNome("Marina");
		c.setCognome("Massironi");
		
		return convertToClienteDto(c);
	}
	
	private ClienteDto convertToClienteDto(Cliente c) {
		
		ClienteDto clienteDto = clienteMapper.map(c,ClienteDto.class);
		
		return clienteDto;
		
	}
	
	private Cliente convertToCliente(ClienteDto cDto) {
		
		Cliente c = clienteMapper.map(cDto,Cliente.class);
		
		return c;
		
	}
	
}
