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

import com.example.demo.Model.AppUser;
import com.example.demo.Model.Produit;
import com.example.demo.Service.produitService;

@RestController
@RequestMapping("/produit")
public class ProduitController {
	private final produitService service;

	public ProduitController(produitService service) {
		super();
		this.service = service;
	}
	
	 @GetMapping("/produits")
	    public ResponseEntity<List<Produit>> getAllProduits() {
	        List<Produit> prods = service.findAllProduits();
	        return new ResponseEntity<>(prods, HttpStatus.OK);
	    }
	    @GetMapping("/produits/count")
	    public Long count() {

	        return service.count();
	    }
	    

	    @GetMapping("/find/{idProduit}")
	    public ResponseEntity<Produit> getProduitById (@PathVariable("idProduit") Integer idProduit) {
	    	Produit prod = service.findProduitByIdProduit(idProduit);
	        return new ResponseEntity<>(prod, HttpStatus.OK);
	    }
	    
	    @PostMapping("/add")
	    public ResponseEntity<Produit> addProduit(@RequestBody Produit prod) {
	    	/*user.setDeleted(0);
	    	user.setDeletedBy(user.getIdUser());

	    	user.setDeletedAt(LocalDate.now()); */ 
	    	Produit newprod = service.addProduit(prod);
	        return new ResponseEntity<>(newprod, HttpStatus.CREATED);
	    }
	    
	    @PutMapping("/update")
	    public ResponseEntity<Produit> updateUser(@RequestBody Produit prod) {
	    	Produit updateProd = service.updateProduit(prod);
	        return new ResponseEntity<>(updateProd, HttpStatus.OK);
	    }
	    @DeleteMapping("/delete/{idProduit}")
	    public ResponseEntity<?> deleteProduit(@PathVariable("idProduit") Integer idProduit) {
	        service.deleteProduit(idProduit);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	}
