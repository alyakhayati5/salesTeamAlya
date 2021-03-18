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
import com.example.demo.Model.Client;
import com.example.demo.Service.ClientService;

@RestController
@RequestMapping("/Client")
public class ClientController {
    private final ClientService service;

	public ClientController(ClientService service) {
		super();
		this.service = service;
	}
    
	@GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClient() {
        List<Client> clients = service.findAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
    @GetMapping("/clients/count")
    public Long count() {

        return service.count();
    }
    

    @GetMapping("/find/{idClient}")
    public ResponseEntity<Client> getClientByIdClient (@PathVariable("idClient") Integer idClient) {
    	Client client = service.findClientByIdClient(idClient);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
    	
    	Client newclient = service.addClient(client);
        return new ResponseEntity<>(newclient, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
    	Client updateClient = service.updateClient(client);
        return new ResponseEntity<>(updateClient, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{idClient}")
    public ResponseEntity<?> deleteClient(@PathVariable("idClient") Integer idClient) {
        service.deleteClient(idClient);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

