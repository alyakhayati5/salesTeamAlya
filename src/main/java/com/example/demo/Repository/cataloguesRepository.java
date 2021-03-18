package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.AppUser;
import com.example.demo.Model.Catalogues;


public interface cataloguesRepository extends JpaRepository<Catalogues, Integer>{
	 void deleteCatalogueByIdCatalogue(Integer idCatalogue);
	 Optional<Catalogues> findCatalogueByIdCatalogue(Integer idCatalogue);
}
