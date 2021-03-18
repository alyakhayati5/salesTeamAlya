package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.time.LocalDateTime;

import javax.persistence.*;

public class LigneCommande {
	//@Id
	Long idligneCmd;

	    LocalDateTime passedAt;

	    int qte;
}
