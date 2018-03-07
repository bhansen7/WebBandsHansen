package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Competition;

public class CompetitionHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BandsHansen");

	public void insertBands(Competition toAdd) {
		// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(toAdd);
			em.getTransaction().commit();
			em.close();
		
	}

	public List<Competition> showAllCompetition() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Competition> allResults = em.createQuery("select li from Competition li", Competition.class);
		List<Competition> allCompetition = allResults.getResultList();
		em.close();
		return allCompetition; 
	}

	//not being implemented at this time
	public void deleteBandFromCompetition(Competition toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Competition> typedQuery = em.createQuery(
				"select li from Competition li where li.competitionId = :selectedId and li.bandId = :selectedBandId",
				Competition.class);
		typedQuery.setParameter("selectedId", toDelete.getCompetitionId()); 
		typedQuery.setParameter("selectedBandId", toDelete.getBandId());
		typedQuery.setMaxResults(1);
		Competition result = typedQuery.getSingleResult();
		System.out.println("TEST - result: " + result);
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

}
