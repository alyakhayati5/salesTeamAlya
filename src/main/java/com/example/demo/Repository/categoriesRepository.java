package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.AppUser;
import com.example.demo.Model.Categories;

public interface categoriesRepository extends JpaRepository<Categories, Integer>{
	 void deleteCategoriesByIdCategorie(Integer idCategorie);

	 Optional<Categories> findCategoriesByIdCategorie(Integer idCategorie);

}
