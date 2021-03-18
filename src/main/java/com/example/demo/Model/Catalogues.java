package com.example.demo.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;
@Entity
public class Catalogues implements Serializable {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idCatalogue;
    private String nomCatalogues;
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	@JoinColumn(name="idCatalogue",referencedColumnName = "idCatalogue")
     private List<Produit> prods;
	public Long getIdCatalogue() {
		return idCatalogue;
	}
	public void setIdCatalogue(Long idCatalogue) {
		this.idCatalogue = idCatalogue;
	}
	public String getNomCatalogues() {
		return nomCatalogues;
	}
	public void setNomCatalogues(String nomCatalogues) {
		this.nomCatalogues = nomCatalogues;
	}
	public List<Produit> getProds() {
		return prods;
	}
	public void setProds(List<Produit> prods) {
		this.prods = prods;
	}
	public Catalogues(String nomCatalogues) {
		super();
		this.nomCatalogues = nomCatalogues;
	}
	public Catalogues(String nomCatalogues, List<Produit> prods) {
		super();
		this.nomCatalogues = nomCatalogues;
		this.prods = prods;
	}
	public Catalogues() {
		super();
	}
    
}
