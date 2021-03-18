package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Commande;

public interface commandeRepository extends JpaRepository<Commande, Integer> {
	
	void deleteCommandeByIdCommande(Integer idCommande);
	Optional<Commande> findCommandeByIdCommande(Integer idCommande);
}
