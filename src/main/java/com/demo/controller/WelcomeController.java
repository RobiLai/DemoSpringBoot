package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.exception.DuplicateException;

@Controller
@RequestMapping("/")
public class WelcomeController {
	
	private final static Logger log = LoggerFactory.getLogger(WelcomeController.class);
	
	@Value("${messaggioBenvenuto}")
	private String messaggio;
	
	@GetMapping("/welcome")
	@ResponseBody
	public String welcome() {
		
		log.info("logger di benvenuto a livello info");
		log.debug("logger di benvenuto a livello debug");
		return messaggio;
	}
	
	@GetMapping("/provaException")
	public ResponseEntity<String> provaDuplicateException() throws DuplicateException{
		
		System.out.println("Prova per lancio Duplicate Exception");
		
		if(1==1) {
			throw new DuplicateException();
		}
		
		return new ResponseEntity<String>("Errore per risorsa duplicata", new HttpHeaders(), HttpStatusCode.valueOf(409));
		
	}

}
