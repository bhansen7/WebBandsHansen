package Controller;

import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Bands; 
import Model.PepBand;

public class PepBandHelper { 
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BandsHansen");

	public void insertPepBand(PepBand toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<PepBand> showAllPepBand() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<PepBand> allResults = em.createQuery("select li from PepBand li where li.bandType = 'PepBand'", PepBand.class);
		List<PepBand> allPepBand = allResults.getResultList();
		em.close();
		return allPepBand; 
	}

	public void deletePepBand(PepBand toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PepBand> typedQuery = em.createQuery(
				"select li from PepBand li where li.bandId = :selectedId",
				PepBand.class);
		typedQuery.setParameter("selectedId", toDelete.getBandId()); 
		typedQuery.setMaxResults(1);
		Bands result = typedQuery.getSingleResult();
		System.out.println("TEST - result: " + result);
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public PepBand searchForBandById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		PepBand foundItem =  em.find(PepBand.class, idToEdit);
		em.close();
		return foundItem;
	}

	public void updateBands(PepBand toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}
