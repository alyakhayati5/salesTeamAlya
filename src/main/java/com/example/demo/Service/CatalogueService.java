package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Catalogues;
import com.example.demo.Repository.cataloguesRepository;
@Service
@Transactional
public class CatalogueService {

		
			private final cataloguesRepository repo;

			@Autowired
			public CatalogueService(cataloguesRepository repo) {
				super();
				this.repo = repo;
			}
			
			 public Catalogues addCatalogues(Catalogues catalogue) {
		         return repo.save(catalogue);
		   }

		     public List<Catalogues> findAllCatalogues() {
		       return repo.findAll();
		   }

		   public Catalogues updateCatalogue(Catalogues catalogue) {
		      return repo.save(catalogue);
		    }


		   public Catalogues findCatalogueByIdCatalogue(Integer idCatalogue) {
		    	return repo.findCatalogueByIdCatalogue(idCatalogue)
		                .orElseThrow(() -> new com.example.demo.Exception.CatalogueNotFoundException("Catalogue by id " + idCatalogue + " was not found"));
		    }


		    public Long count() {

		     return repo.count();
		     }

		    public void deleteCatalogue(Integer idCatalogue){
		       repo.deleteCatalogueByIdCatalogue(idCatalogue);
		      }
	}
		
		
		