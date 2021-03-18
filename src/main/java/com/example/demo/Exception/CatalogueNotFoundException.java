package com.example.demo.Exception;

public class CatalogueNotFoundException  extends RuntimeException{

	 public CatalogueNotFoundException(String message) {
	        super(message);
	    }
	}