package pl.firma;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class FirmaReklamowaEJB {
	
	@PersistenceContext(name="firmaReklamowa")
	EntityManager manager;
	
	public void createBillboard(Billboard billboard) {
		manager.persist(billboard);
	}
	
	public List<Billboard> getAllBillboards() {
		Query q = manager.createQuery("select b from Billboard b");
		@SuppressWarnings("unchecked")
		List<Billboard> list = q.getResultList();
		return list;
	}
	
}
