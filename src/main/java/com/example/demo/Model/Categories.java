package com.example.demo.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Categories {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    private String nomCategorie;
    
	@OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	@JoinColumn(name="idCategorie",referencedColumnName = "idCategorie")
	private List<Produit> prods;

	public Categories(String nomCategorie, List<Produit> prods) {
		super();
		this.nomCategorie = nomCategorie;
		this.prods = prods;
	}
	public Categories(String nomCategorie) {
		super();
		this.nomCategorie = nomCategorie;
	}

	public Categories() {
		super();
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public List<Produit> getProds() {
		return prods;
	}

	public void setProds(List<Produit> prods) {
		this.prods = prods;
	}
	
	
}
