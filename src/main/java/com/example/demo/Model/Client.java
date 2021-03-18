package com.example.demo.Model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Client implements Serializable{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String pattente;
	private String tel;
	private String Fax;
	private String nomCommerciale;
	

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPattente() {
		return pattente;
	}

	public void setPattente(String pattente) {
		this.pattente = pattente;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public String getNomCommerciale() {
		return nomCommerciale;
	}

	public void setNomCommerciale(String nomCommerciale) {
		this.nomCommerciale = nomCommerciale;
	}

	public Client() {
		super();
	}

	public Client(String nom, String prenom, String email, String adresse, String pattente, String tel, String fax,
			String nomCommerciale) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.pattente = pattente;
		this.tel = tel;
		Fax = fax;
		this.nomCommerciale = nomCommerciale;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", adresse=" + adresse + ", pattente=" + pattente + ", tel=" + tel + ", Fax=" + Fax
				+ ", nomCommerciale=" + nomCommerciale + "]";
	}


}
