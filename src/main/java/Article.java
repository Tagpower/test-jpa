package main.java;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Article {
	@Id
	private int id;
	@Column(name="ref")
	private String ref;
	@Column(name="designation")
	private String designation;
	@Column(name="prix")
	private double prix;
	@Column(name="id_fou")
	private int id_fou;
	
	
	public Article() {
		// TODO Auto-generated constructor stub
	}


	public Article(int id, String ref, String designation, double prix, int id_fou) {
		this.id = id;
		this.ref = ref;
		this.designation = designation;
		this.prix = prix;
		this.id_fou = id_fou;
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


	public int getId_fou() {
		return id_fou;
	}


	public void setId_fou(int id_fou) {
		this.id_fou = id_fou;
	}
	
	public String toString() {
		return String.format("Article %2d (%s) : %s - %2.2f€ - Fournisseur %d", id, ref, designation, prix, id_fou);
	}
	
	

}
