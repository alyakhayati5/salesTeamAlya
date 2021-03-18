package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Categories;
import com.example.demo.Repository.categoriesRepository;

@Service
@Transactional
public class CategorieService {

	
		private final categoriesRepository repo;

		@Autowired
		public CategorieService(categoriesRepository repo) {
			super();
			this.repo = repo;
		}
		
		 public Categories addCategorie(Categories categorie) {
	         return repo.save(categorie);
	   }

	     public List<Categories> findAllCategories() {
	       return repo.findAll();
	   }

	   public Categories updateCategorie(Categories categorie) {
	      return repo.save(categorie);
	    }


	   public Categories findCategorieByIdCategorie(Integer idCategorie) {
	    	return repo.findCategoriesByIdCategorie(idCategorie)
	                .orElseThrow(() -> new com.example.demo.Exception.CategorieNotFoundException("Categorie by id " + idCategorie + " was not found"));
	    }


	    public Long count() {

	     return repo.count();
	     }

	    public void deleteCategorie(Integer idCategorie){
	       repo.deleteCategoriesByIdCategorie(idCategorie);
	      }
}
	
	
	
	
	