package main.java;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Article {
	@Id
	private int id;
	@Column(name="ref", length=30, nullable=false, unique=true)
	private String ref;
	@Column(name="designation", length=300, nullable=false)
	private String designation;
	@Column(name="prix", nullable=false)
	private double prix;
	@ManyToOne
	@JoinColumn(name="id_fou")
	private Fournisseur fourn;
	@ManyToMany(mappedBy="articles")
	private Set<Bon> bons;
	
	
	public Article() {
		// TODO Auto-generated constructor stub
	}


	public Article(int id, String ref, String designation, double prix, Fournisseur fou) {
		this.id = id;
		this.ref = ref;
		this.designation = designation;
		this.prix = prix;
		this.fourn = fou;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRef() {
		return ref;
	}


	public void setRef(String ref) {
		this.ref = ref;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public Fournisseur getFournisseur() {
		return fourn;
	}


	public void setFournisseur(Fournisseur fou) {
		this.fourn = fou;
	}
	
	public Set<Bon> getBons() {
		return bons;
	}


	public void setBons(Set<Bon> bons) {
		this.bons = bons;
	}


	public String toString() {
		return String.format("Article %2d (%s) : %s - %2.2f€ - %s", id, ref, designation, prix, fourn.getNom());
	}
	
	

}
