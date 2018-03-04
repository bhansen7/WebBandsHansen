package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Bands;
import Model.MarchingBand;

public class MarchingBandHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BandsHansen");

	public void insertMarchingBand(MarchingBand toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<MarchingBand> showAllMarchingBand() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<MarchingBand> allResults = em
				.createQuery("select li from MarchingBand li where li.bandType = 'MarchingBand'", MarchingBand.class);
		List<MarchingBand> allMarchingBand = allResults.getResultList();
		em.close();
		return allMarchingBand;
	}

	public void deleteMarchingBand(MarchingBand toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MarchingBand> typedQuery = em
				.createQuery("select li from MarchingBand li where li.bandId = :selectedId", MarchingBand.class);
		typedQuery.setParameter("selectedId", toDelete.getBandId());
		typedQuery.setMaxResults(1);
		Bands result = typedQuery.getSingleResult();
		System.out.println("TEST - result: " + result);
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public MarchingBand searchForBandById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		MarchingBand foundItem = em.find(MarchingBand.class, idToEdit);
		em.close();
		return foundItem;
	}

	public void updateBands(MarchingBand toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}
