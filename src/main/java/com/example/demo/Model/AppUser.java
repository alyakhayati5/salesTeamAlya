package com.example.demo.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Value;


@Entity
public class AppUser implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	private String nom;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Role rolename;
	
	private String prenom;
	private String email;
	private String username;
	private String password;
	private String adresse;	
	private Integer deletedBy;
	private LocalDate  deletedAt;
	private Integer deleted;

	@OneToMany(fetch = FetchType.LAZY, 
			    cascade = CascadeType.ALL)
	@JoinColumn(name="idUser",referencedColumnName = "idUser")
	private List<Commande> cmds;
	
	public AppUser() {
		super();
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Role getRolename() {
		return rolename;
	}

	public void setRolename(Role rolename) {
		this.rolename = rolename;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Integer deletedBy) {
		this.deletedBy = deletedBy;
	}

	public LocalDate  getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDate  deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public List<Commande> getCmds() {
		return cmds;
	}

	public void setCmds(List<Commande> cmds) {
		this.cmds = cmds;
	}

	public AppUser(String nom, Role rolename, String prenom, String email, String username, String password,
			String adresse, Integer deletedBy, LocalDate  deletedAt, Integer deleted, List<Commande> cmds) {
		super();
		this.nom = nom;
		this.rolename = rolename;
		this.prenom = prenom;
		this.email = email;
		this.username = username;
		this.password = password;
		this.adresse = adresse;
		this.deletedBy = deletedBy;
		this.deletedAt = deletedAt;
		this.deleted = deleted;
		this.cmds = cmds;
	}

	public AppUser(String nom, Role rolename, String prenom, String email, String username, String password,
			String adresse, LocalDate  deletedAt, Integer deleted) {
		super();
		this.nom = nom;
		this.rolename = rolename;
		this.prenom = prenom;
		this.email = email;
		this.username = username;
		this.password = password;
		this.adresse = adresse;
		this.deletedAt = deletedAt;
		this.deleted = deleted;
	}
	
	
}