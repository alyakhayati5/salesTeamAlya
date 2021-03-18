package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Client;
import com.example.demo.Model.Commande;
import com.example.demo.Repository.clientRepository;
import com.example.demo.Repository.commandeRepository;
@Service
@Transactional
public class CommandeService{

	private final commandeRepository repo;

	@Autowired
	public CommandeService(commandeRepository repo) {
		super();
		this.repo = repo;
	}
	
	 public Commande addCommande(Commande Cmd) {
         return repo.save(Cmd);
   }

     public List<Commande> findAllCommandes() {
       return repo.findAll();
   }

   public Commande updateCommande(Commande Cmd) {
      return repo.save(Cmd);
    }


   public Commande findCommandeByIdCommande(Integer idCommande) {
    	return repo.findCommandeByIdCommande(idCommande)
                .orElseThrow(() -> new com.example.demo.Exception.CommandeNotFoundException("Commande by id " + idCommande + " was not found"));
    }


    public Long count() {

     return repo.count();
     }

    public void deleteCommande(Integer idCommande){
       repo.deleteCommandeByIdCommande(idCommande);
      }
}
