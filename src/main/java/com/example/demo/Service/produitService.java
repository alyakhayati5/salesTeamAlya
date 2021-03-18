package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Produit;
import com.example.demo.Repository.prodRepository;


@Service
@Transactional
public class produitService {
	private final prodRepository repo;

	@Autowired
	public produitService(prodRepository repo) {
		super();
		this.repo = repo;
	}
	
	 public Produit addProduit(Produit prod) {
         return repo.save(prod);
   }

     public List<Produit> findAllProduits() {
       return repo.findAll();
   }

   public Produit updateProduit(Produit prod) {
      return repo.save(prod);
    }
    public Produit findProduitByIdProduit(Integer idProduit) {
	   return repo.findProduitByIdProduit(idProduit)
           .orElseThrow(() -> new com.example.demo.Exception.ProduitNotFoundException("Produit by id " + idProduit + " was not found"));
       }

    public Long count() {

     return repo.count();
     }

    public void deleteProduit(Integer idProduit){
       repo.deleteProduitByIdProduit(idProduit);
      }

	

}
