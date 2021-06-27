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
	
	//BILLBOARD REKLAMA	
	
	public List<BillboardReklama> getAllBillboardReklama() {
		Query q = manager.createQuery("select b from BillboardReklama b");
		@SuppressWarnings("unchecked")
		List<BillboardReklama> list = q.getResultList();
		return list;
	}
	
	public BillboardReklama getBillboardReklama(int id) {
		return manager.find(BillboardReklama.class, id);
	}
	
	public void updateBillboardReklama(BillboardReklama billboardReklama) {
		billboardReklama = manager.merge(billboardReklama);
	}
	
	public void deleteBillboardReklama(int id) {
		BillboardReklama billboardReklama = manager.find(BillboardReklama.class,id);
		manager.remove(billboardReklama);
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
	
	//KLIENT
	public void createKlient(Klient klient) {
		manager.persist(klient);
	}
	
	public List<Klient> getAllKlient() {
		Query q = manager.createQuery("select k from Klient k");
		@SuppressWarnings("unchecked")
		List<Klient> list = q.getResultList();
		return list;
	}
	
	public Klient getKlient(int id) {
		return manager.find(Klient.class, id);
	}
	
	public void updateKlient(Klient klient) {
		klient = manager.merge(klient);
	}
	
	public void deleteKlient(int id) {
		Klient klient = manager.find(Klient.class,id);
		manager.remove(klient);
	}
	
	//FAKTURA
	public void createFaktura(Faktura faktura) {
		manager.persist(faktura);
	}
	
	public List<Faktura> getAllFaktura() {
		Query q = manager.createQuery("select f from Faktura f");
		@SuppressWarnings("unchecked")
		List<Faktura> list = q.getResultList();
		return list;
	}
	
	public Faktura getFaktura(int id) {
		return manager.find(Faktura.class, id);
	}
	
	public void updateFaktura(Faktura faktura) {
		faktura = manager.merge(faktura);
	}
	
	public void deleteFaktura(int id) {
		Faktura faktura = manager.find(Faktura.class,id);
		manager.remove(faktura);
	}
	
	public void addFakturaToKlient(int idf, int idk) {
		Klient klient = manager.find(Klient.class,idk);
		Faktura faktura = manager.find(Faktura.class,idf);
		faktura.setKlient(klient);
	}
}
