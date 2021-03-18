package com.example.demo.Model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;
@Entity
public class Produit {
	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
	private String typeProduit;
	private float prix;
	private String designiation;
	private String codeProduit;
	private Integer poids;
	private String reference;
	private Date dateCreation;
	private Date dateExpiration;
    
	@ManyToMany
	 @JoinTable(name = "Ligne_Commande",
    joinColumns = {
            @JoinColumn(name = "idProduit", referencedColumnName = "idProduit",
                    nullable = false, updatable = true)},
    inverseJoinColumns = {
            @JoinColumn(name = "idCommande", referencedColumnName = "idCommande",
                    nullable = false, updatable = true)})
	private List<Commande> cmds;
	
	private String nomProduit;
   // private byte[] image;
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getTypeProduit() {
		return typeProduit;
	}
	public void setTypeProduit(String typeProduit) {
		this.typeProduit = typeProduit;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getDesigniation() {
		return designiation;
	}
	public void setDesigniation(String designiation) {
		this.designiation = designiation;
	}
	public String getCodeProduit() {
		return codeProduit;
	}
	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}
	public Integer getPoids() {
		return poids;
	}
	public void setPoids(Integer poids) {
		this.poids = poids;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public Produit(String typeProduit, float prix, String designiation, String codeProduit, Integer poids,
			String reference, Date dateCreation, Date dateExpiration, String nomProduit) {
		super();
		this.typeProduit = typeProduit;
		this.prix = prix;
		this.designiation = designiation;
		this.codeProduit = codeProduit;
		this.poids = poids;
		this.reference = reference;
		this.dateCreation = dateCreation;
		this.dateExpiration = dateExpiration;
		this.nomProduit = nomProduit;
	}
	public Produit(String typeProduit, float prix, String designiation, String codeProduit, Integer poids,
			String reference, Date dateCreation, Date dateExpiration, Set<Commande> cmd, String nomProduit) {
		super();
		this.typeProduit = typeProduit;
		this.prix = prix;
		this.designiation = designiation;
		this.codeProduit = codeProduit;
		this.poids = poids;
		this.reference = reference;
		this.dateCreation = dateCreation;
		this.dateExpiration = dateExpiration;
		this.nomProduit = nomProduit;
	}
	public Produit() {
		super();
	}
	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", typeProduit=" + typeProduit + ", prix=" + prix + ", designiation="
				+ designiation + ", codeProduit=" + codeProduit + ", poids=" + poids + ", reference=" + reference
				+ ", dateCreation=" + dateCreation + ", dateExpiration=" + dateExpiration 
				+ ", nomProduit=" + nomProduit + "]";
	}
	
	
	
	
}
