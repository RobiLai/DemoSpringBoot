package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
}
