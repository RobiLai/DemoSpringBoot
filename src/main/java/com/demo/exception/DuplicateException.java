package com.demo.exception;

public class DuplicateException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String messaggio = "Attenzione: Risorsa Duplicata!";

	public DuplicateException() {
		super();
	}

	public DuplicateException(String messaggio) {
		super();
		this.messaggio = messaggio;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	

}
