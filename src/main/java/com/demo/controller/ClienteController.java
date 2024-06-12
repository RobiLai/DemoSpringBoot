package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.demo.model.Cliente;
import com.demo.repository.ClienteRepository;
import com.demo.services.ClienteService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidationException(MethodArgumentNotValidException ex){
		
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
	
	@GetMapping("/ciaoCliente")
	@ResponseBody
	public String ciaoCliente() {
		return "Ciao Cliente";
	}
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/cercaClienti")
	@ResponseBody
	public Optional<Cliente> getCliente() {
		
		Optional<Cliente> clienti = service.getCliente(1);
		
		return clienti;
	}
	
	@GetMapping("/listaClienti")
	@ResponseBody
	public List<Cliente> getClienti() {
		
		List<Cliente> clienti = service.getClienti();
		
		return clienti;
	}
	
	@PostMapping("/inserisciCliente")
	public ResponseEntity<String> inserisciCliente(@Valid @RequestBody Cliente c){
		
		service.insert(c);
		
		return new ResponseEntity<String>("Inserimento effettuato!",HttpStatus.OK);
		
	}
	
	@PutMapping("/modificaCliente")
	public ResponseEntity<String> modificaCliente(@RequestBody Cliente c){
		
		service.update(c);
		
		return new ResponseEntity<String>("Aggiornamento effettuato!",HttpStatus.OK);
		
	}
	
	@DeleteMapping("/cancellaCliente")
	public ResponseEntity<String> cancellaCliente(@RequestBody Cliente c){
		
		service.delete(c);
		
		return new ResponseEntity<String>("Cancellazione effettuata!",HttpStatus.OK);
		
	}	
	
}
