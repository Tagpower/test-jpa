package main.java;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJpa {

	private static final Logger LOG = LoggerFactory.getLogger(TestJpa.class);

	public static void main(String[] args) {
		EntityManagerFactory emfact = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = emfact.createEntityManager();
		
		//TODO requête native pr avoir la liste des articles
		
		TypedQuery<Article> q = em.createQuery("SELECT a from Article a", Article.class);
		//TODO afficher le resultat
		
		List<Article> result = q.getResultList();
		
		for (Article a : result) {
			LOG.info(a.toString());
		}
		
		em.close();
		emfact.close();
	}

}
