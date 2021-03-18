package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Produit;


public interface prodRepository extends JpaRepository<Produit, Integer>{
	
	void deleteProduitByIdProduit(Integer idProduit);
	Optional<Produit> findProduitByIdProduit(Integer idProduit);
	
}
