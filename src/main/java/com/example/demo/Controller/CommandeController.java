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

import com.example.demo.Model.Commande;
import com.example.demo.Service.CommandeService;

@RestController
@RequestMapping("/commande")
public class CommandeController {
	private final CommandeService service;

	public CommandeController(CommandeService service) {
		super();
		this.service = service;
	}
	
	 @GetMapping("/commandes")
	    public ResponseEntity<List<Commande>> getAllCommandes() {
	        List<Commande> cmds = service.findAllCommandes();
	        return new ResponseEntity<>(cmds, HttpStatus.OK);
	    }
	    @GetMapping("/commandes/count")
	    public Long count() {

	        return service.count();
	    }
	    

	    @GetMapping("/find/{idCommande}")
	    public ResponseEntity<Commande> getCommandeById (@PathVariable("idCommande") Integer idCommande) {
	    	Commande cmd = service.findCommandeByIdCommande(idCommande);
	        return new ResponseEntity<>(cmd, HttpStatus.OK);
	    }
	    
	    @PostMapping("/add")
	    public ResponseEntity<Commande> addCommande(@RequestBody Commande cmd) {  
	    	Commande newCmd = service.addCommande(cmd);
	        return new ResponseEntity<>(newCmd, HttpStatus.CREATED);
	    }
	    
	    @PutMapping("/update")
	    public ResponseEntity<Commande> updateCommande(@RequestBody Commande cmd) {
	    	Commande updateCmd = service.updateCommande(cmd);
	        return new ResponseEntity<>(updateCmd, HttpStatus.OK);
	    }
	    @DeleteMapping("/delete/{idCommande}")
	    public ResponseEntity<?> deleteCommande(@PathVariable("idCommande") Integer idCommande) {
	        service.deleteCommande(idCommande);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	}
