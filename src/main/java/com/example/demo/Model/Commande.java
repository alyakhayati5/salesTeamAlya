package com.example.demo.Model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Commande implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    	private Long idCommande;
	   private Date dateCmd;
	   private Integer numCmd;
	   private String etatCmd;
	   private LocalDateTime passedAt;
	   private Integer qte;
	@ManyToMany
	 @JoinTable(name = "Ligne_Commande",
     joinColumns = {
             @JoinColumn(name = "idCommande", referencedColumnName = "idCommande",
                     nullable = false, updatable = true)},
     inverseJoinColumns = {
             @JoinColumn(name = "idProduit", referencedColumnName = "idProduit",
                     nullable = false, updatable = true)})
	private List<Produit> prods;
	
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public Date getDateCmd() {
		return dateCmd;
	}
	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}
	public Integer getNumCmd() {
		return numCmd;
	}
	public void setNumCmd(Integer numCmd) {
		this.numCmd = numCmd;
	}
	public String getEtatCmd() {
		return etatCmd;
	}
	public void setEtatCmd(String etatCmd) {
		this.etatCmd = etatCmd;
	}
	public LocalDateTime getPassedAt() {
		return passedAt;
	}
	public void setPassedAt(LocalDateTime passedAt) {
		this.passedAt = passedAt;
	}
	public Integer getQte() {
		return qte;
	}
	public void setQte(Integer qte) {
		this.qte = qte;
	}
	public List<Produit> getProds() {
		return prods;
	}
	public void setProds(List<Produit> prods) {
		this.prods = prods;
	}
	public Commande(Date dateCmd, Integer numCmd, String etatCmd, LocalDateTime passedAt, Integer qte,
			List<Produit> prods) {
		super();
		this.dateCmd = dateCmd;
		this.numCmd = numCmd;
		this.etatCmd = etatCmd;
		this.passedAt = passedAt;
		this.qte = qte;
		this.prods = prods;
	}
	
	public Commande() {
		super();
	}	
	
	/* @OneToMany(fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
		@JoinColumn(name="idCommande",referencedColumnName = "idCommande")
	    private Set<AppUser> users;

*/

	 
}
