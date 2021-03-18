package com.example.demo.Exception;

public class CommandeNotFoundException extends RuntimeException{

	 public CommandeNotFoundException(String message) {
	        super(message);
	    }
	}