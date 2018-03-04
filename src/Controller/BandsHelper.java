package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Bands; 

public class BandsHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BandsHansen");

	public void insertBands(Bands toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<Bands> showAllBands() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Bands> allResults = em.createQuery("select li from Bands li where li.bandType = 'PlainBand'", Bands.class);
		List<Bands> allBands = allResults.getResultList();
		em.close();
		return allBands; 
	}
	


	public void deleteBands(Bands toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Bands> typedQuery = em.createQuery(
				"select li from Bands li where li.bandId = :selectedId",
				Bands.class);
		typedQuery.setParameter("selectedId", toDelete.getBandId()); 
		typedQuery.setMaxResults(1);
		Bands result = typedQuery.getSingleResult();
		System.out.println("TEST - result: " + result);
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Bands searchForBandById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Bands foundItem =  em.find(Bands.class, idToEdit);
		em.close();
		return foundItem; 
	}

	public void updateBands(Bands toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}
