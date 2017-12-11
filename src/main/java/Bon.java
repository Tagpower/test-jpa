package main.java;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bon")
public class Bon {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name="numero", nullable=false, unique=true)
	private int numero;
	@Column(name="date_cmde", nullable=false)
	private LocalDate date_cmde;
	@Column(name="delai", nullable=false)
	private int delai;
	@ManyToOne
	@JoinColumn(name="id_fou")
	private Fournisseur fourn;
	@ManyToMany
	@JoinTable(name="compo",
		joinColumns= @JoinColumn(name="id_art", referencedColumnName="id"),
		inverseJoinColumns= @JoinColumn(name="id_bon", referencedColumnName="id")
			
	)
	private Set<Article> articles;
	
	
	public Bon(int id, int numero, LocalDate date_cmde, int delai, Fournisseur fourn, Set<Article> articles) {
		this.id = id;
		this.numero = numero;
		this.date_cmde = date_cmde;
		this.delai = delai;
		this.fourn = fourn;
		this.articles = articles;
	}
	
	public Bon(int id, Fournisseur fourn) {
		this(id, id, LocalDate.now(), 3, fourn, new HashSet<Article>());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LocalDate getDate_cmde() {
		return date_cmde;
	}

	public void setDate_cmde(LocalDate date_cmde) {
		this.date_cmde = date_cmde;
	}



	public int getDelai() {
		return delai;
	}



	public void setDelai(int delai) {
		this.delai = delai;
	}



	public Fournisseur getFourn() {
		return fourn;
	}



	public void setFourn(Fournisseur fourn) {
		this.fourn = fourn;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	public String toString() {
		return String.format("Bon numéro %2d : commandé le %s, délai de %d jours - %s", numero, date_cmde.toString(), delai, fourn.getNom());
	}
	
	

}
