package main.java;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestInsertionJpa {

	private static final Logger LOG = LoggerFactory.getLogger(TestInsertionJpa.class);

	public static void main(String[] args) {
		EntityManagerFactory emfact = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = emfact.createEntityManager();
			
		//INSERTION D'UN ARTICLE
		//Récupération d'un fournisseur
		TypedQuery<Fournisseur> qf = em.createQuery("SELECT f FROM Fournisseur f WHERE f.id = 3", Fournisseur.class);
		Fournisseur fourn = qf.getResultList().get(0);
		Article nouvelArticle = new Article(11, "A99", "Turbine à air comprimé", 90.0, fourn);
		
		EntityTransaction et = em.getTransaction();
//		et.begin();
//		em.persist(nouvelArticle);
//		et.commit();
			
		//TODO insérer un bon de commande avec 2 articles (le nouveau et un autre)	
		Bon nouveauBon = new Bon(7, fourn);
		
		//Récupération d'un article existant
		TypedQuery<Article> qa = em.createQuery("SELECT a FROM Article a WHERE a.id = 6", Article.class);
		Article autreArticle = qa.getResultList().get(0);
		
		nouveauBon.getArticles().add(autreArticle);
		nouveauBon.getArticles().add(nouvelArticle);
		
		et.begin();
		em.persist(nouveauBon);
		et.commit();
		
		

		
		
		em.close();
		emfact.close();
	}

}
