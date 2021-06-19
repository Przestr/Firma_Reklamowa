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
	
	//BILLBOARD
	public void createBillboard(Billboard billboard) {
		manager.persist(billboard);
	}
	
	public List<Billboard> getAllBillboards() {
		Query q = manager.createQuery("select b from Billboard b");
		@SuppressWarnings("unchecked")
		List<Billboard> list = q.getResultList();
		return list;
	}
	
	public Billboard getBillboard(int id) {
		return manager.find(Billboard.class, id);
	}
	
	public void updateBillboard(Billboard billboard) {
		billboard = manager.merge(billboard);
	}
	
	public void deleteBillboard(int id) {
		Billboard billboard = manager.find(Billboard.class,id);
		manager.remove(billboard);
	}
	
	public void addReklamaToBillboard(BillboardReklama billboardReklama, int idb, int idr) {
		manager.persist(billboardReklama);
		Billboard billboard = manager.find(Billboard.class, idb);
		Reklama reklama = manager.find(Reklama.class, idr);
		billboardReklama.setBillboard(billboard);
		billboardReklama.setReklama(reklama);
	}
	
	//REKLAMA
	public void createReklama(Reklama reklama) {
		manager.persist(reklama);
	}
	
	public List<Reklama> getAllReklama() {
		Query q = manager.createQuery("select r from Reklama r");
		@SuppressWarnings("unchecked")
		List<Reklama> list = q.getResultList();
		return list;
	}
	
	public Reklama getReklama(int id) {
		return manager.find(Reklama.class, id);
	}
	
	public void updateReklama(Reklama reklama) {
		reklama = manager.merge(reklama);
	}
	
	public void deleteReklama(int id) {
		Reklama reklama = manager.find(Reklama.class,id);
		manager.remove(reklama);
	}
}
