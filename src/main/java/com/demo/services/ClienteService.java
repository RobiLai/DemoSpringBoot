package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Cliente;
import com.demo.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public List<Cliente> getClienti(){
		
		return repo.findAll();
		
	}

	public Optional<Cliente> getCliente(int i) {
		
		return repo.findById(i);
	}
	
	@Transactional
	public void insert(Cliente c) {
		
		repo.save(c);
	}
	
	@Transactional
	public void update(Cliente c) {
		
		repo.save(c);
	}
	
	@Transactional
	public void delete(Cliente c) {
		
		repo.deleteById(c.getId());;
	}
}
