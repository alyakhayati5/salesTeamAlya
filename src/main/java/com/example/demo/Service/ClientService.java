package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Client;
import com.example.demo.Repository.clientRepository;

@Service
@Transactional
public class ClientService {
	private final clientRepository repo;

	@Autowired
	public ClientService(clientRepository repo) {
		super();
		this.repo = repo;
	}
	
	 public Client addClient(Client client) {
         return repo.save(client);
   }

     public List<Client> findAllClients() {
       return repo.findAll();
   }

   public Client updateClient(Client client) {
      return repo.save(client);
    }


   public Client findClientByIdClient(Integer idClient) {
    	return repo.findClientByIdClient(idClient)
                .orElseThrow(() -> new com.example.demo.Exception.UserNotFoundException("Client by id " + idClient + " was not found"));
    }


    public Long count() {

     return repo.count();
     }
    public void deleteClient(Integer idClient){
       repo.deleteById(idClient);
      }
}
