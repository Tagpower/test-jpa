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
			
		//Query 1 : Liste des articles
		TypedQuery<Article> q1 = em.createQuery("SELECT a from Article a", Article.class);
		
		List<Article> result = q1.getResultList();
		
		for (Article a : result) {
			LOG.info(a.toString());
		}
		
		//Query 2 : Article selon une référence
		TypedQuery<Article> q2 = em.createQuery("SELECT a from Article a WHERE ref=:reference", Article.class);
		q2.setParameter("reference", "A01");
		
		Article result2 = q2.getSingleResult();
		LOG.info("Résultat de la requête 2 : " + result2.toString());
		
		
		//Query 3 : Un bon de commande et ses articles
		TypedQuery<Bon> q3 = em.createQuery("SELECT b FROM Bon b where id=:id", Bon.class);
		
		for(int i=1; i<7; i++) {
			q3.setParameter("id", i);

			Bon result3 = q3.getSingleResult();
			
			LOG.info("Bon de commande " + result3.getNumero());
			for (Article a : result3.getArticles()) {
				LOG.info(a.toString());
			}
		}

		
		

		
		
		em.close();
		emfact.close();
	}

}
