package com.example.demo.Controller;

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

import com.example.demo.Model.Categories;
import com.example.demo.Service.CategorieService;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
   private final CategorieService service;

public CategorieController(CategorieService service) {
	super();
	this.service = service;
}
   
@GetMapping("/categorie")
public ResponseEntity<List<Categories>> getAllCategories() {
    List<Categories> categorie = service.findAllCategories();
    return new ResponseEntity<>(categorie, HttpStatus.OK);
}
@GetMapping("/categorie/count")
public Long count() {

    return service.count();
}


@GetMapping("/find/{idCategorie}")
public ResponseEntity<Categories> getcategorieById (@PathVariable("idCategorie") Integer idCategorie) {
	Categories categorie = service.findCategorieByIdCategorie(idCategorie);
    return new ResponseEntity<>(categorie, HttpStatus.OK);
}

@PostMapping("/add")
public ResponseEntity<Categories> addcategorie(@RequestBody Categories cat) {
	  
     Categories newcat = service.addCategorie(cat);
    return new ResponseEntity<>(newcat, HttpStatus.CREATED);
}

@PutMapping("/update")
public ResponseEntity<Categories> updatecategorie(@RequestBody Categories cat) {
	Categories updatecat = service.updateCategorie(cat);
    return new ResponseEntity<>(updatecat, HttpStatus.OK);
}
@DeleteMapping("/delete/{idCategorie}")
public ResponseEntity<?> deletecategorie(@PathVariable("idCategorie") Integer idCategorie) {
    service.deleteCategorie(idCategorie);
    return new ResponseEntity<>(HttpStatus.OK);
}
}
