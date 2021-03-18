package com.example.demo.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Catalogues;
import com.example.demo.Service.CatalogueService;


@RestController
@RequestMapping("/catalogue")
public class CataloguesController {
	
	private final CatalogueService service;

		public CataloguesController(CatalogueService service) {
			super();
			this.service = service;
		}

	    @GetMapping("/catalogues")
	    public ResponseEntity<List<Catalogues>> getAllCatalogue() {
	        List<Catalogues> catalogues = service.findAllCatalogues();
	        return new ResponseEntity<>(catalogues, HttpStatus.OK);
	    }
	    @GetMapping("/catalogues/count")
	    public Long count() {

	        return service.count();
	    }
	    

	    @GetMapping("/find/{idcatalogue}")
	    public ResponseEntity<Catalogues> getcatalogueById (@PathVariable("idcatalogue") Integer idcatalogue) {
	    	Catalogues catalogue = service.findCatalogueByIdCatalogue(idcatalogue);
	        return new ResponseEntity<>(catalogue, HttpStatus.OK);
	    }
	    
	    @PostMapping("/add")
	    public ResponseEntity<Catalogues> addcatalogue(@RequestBody Catalogues catalogue) {
	    	  
	    	Catalogues newcatalogue = service.addCatalogues(catalogue);
	        return new ResponseEntity<>(newcatalogue, HttpStatus.CREATED);
	    }
	    
	    @PutMapping("/update")
	    public ResponseEntity<Catalogues> updatecatalogue(@RequestBody Catalogues catalogue) {
	    	Catalogues updatecatalogue = service.updateCatalogue(catalogue);
	        return new ResponseEntity<>(updatecatalogue, HttpStatus.OK);
	    }
	    @DeleteMapping("/delete/{idcatalogue}")
	    public ResponseEntity<?> deletecatalogue(@PathVariable("idcatalogue") Integer idcatalogue) {
	        service.deleteCatalogue(idcatalogue);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	}

