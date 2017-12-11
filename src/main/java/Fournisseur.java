package main.java;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="fournisseur")
public class Fournisseur {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name="nom", nullable=false)
	private String nom;
	@OneToMany(mappedBy="fourn")
	private Set<Article> articles;
	@OneToMany(mappedBy="fourn")
	private Set<Bon> bons;

	public Fournisseur() {
		bons = new HashSet<Bon>();
		articles = new HashSet<Article>();
	}
	
	public Fournisseur(int id, String nom, Set<Article> articles, Set<Bon> bons) {
		this.id = id;
		this.nom = nom;
		this.articles = articles;
		this.bons = bons;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	public Set<Bon> getBons() {
		return bons;
	}

	public void setBons(Set<Bon> bons) {
		this.bons = bons;
	}

	@Override
	public String toString() {
		return String.format("Fournisseur %d : %s", id, nom);
	}

}
