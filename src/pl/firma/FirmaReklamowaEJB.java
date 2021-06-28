package pl.firma;


import java.util.ArrayList;
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
	public void createBillboard(BillboardDTO dto) {
		Billboard billboard = new Billboard();
		billboard.adres = dto.adres;
		if(dto.idf > 0){
			Faktura faktura = manager.find(Faktura.class, dto.idf);
			billboard.setFaktura(faktura);
		}
		manager.persist(billboard);
	}
	
	public List<BillboardDTO> getAllBillboards() {
		Query q = manager.createQuery("select b from Billboard b");
		@SuppressWarnings("unchecked")
		List<Billboard> list = q.getResultList();
		List<BillboardDTO> dtoList = new ArrayList<BillboardDTO>();
		for(Billboard billboard: list){
			BillboardDTO dto = new BillboardDTO();
			dto.id = billboard.id;
			dto.adres = billboard.adres;
			if(billboard.getFaktura() != null){
				dto.idf = billboard.getFaktura().getId();
			}
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	public Billboard getBillboard(int id) {
		return manager.find(Billboard.class, id);
	}
	
	public void updateBillboard(BillboardDTO dto) {
		Billboard billboard = manager.find(Billboard.class, dto.id);
		billboard.setAdres(dto.getAdres());
		if(dto.getIdf()>0){
			Faktura faktura = manager.find(Faktura.class, dto.idf);
			billboard.setFaktura(faktura);
		}
		billboard = manager.merge(billboard);
	}
	
	public void deleteBillboard(int id) {
		Billboard billboard = manager.find(Billboard.class,id);
		manager.remove(billboard);
	}
	
	public void addReklamaToBillboard(BillboardReklamaDTO dto) {
		BillboardReklama billboardReklama = new BillboardReklama();
		billboardReklama.setDataPowieszenia(dto.getDataPowieszenia());
		billboardReklama.setDataSciagniecia(dto.getDataSciagniecia());
		billboardReklama.setKwota(dto.getKwota());
		Billboard billboard = manager.find(Billboard.class, dto.getIdb());
		Reklama reklama = manager.find(Reklama.class, dto.getIdr());
		billboardReklama.setBillboard(billboard);
		billboardReklama.setReklama(reklama);
		manager.persist(billboardReklama);
	}
	
	//BILLBOARD REKLAMA	
	
	public List<BillboardReklamaDTO> getAllBillboardReklama() {
		Query q = manager.createQuery("select b from BillboardReklama b");
		@SuppressWarnings("unchecked")
		List<BillboardReklama> list = q.getResultList();
		List<BillboardReklamaDTO> dtoList = new ArrayList<BillboardReklamaDTO>();
		for(BillboardReklama billboardReklama: list){
			BillboardReklamaDTO dto = new BillboardReklamaDTO();
			dto.setId(billboardReklama.getId());
			dto.setDataPowieszenia(billboardReklama.getDataPowieszenia());
			dto.setDataSciagniecia(billboardReklama.getDataSciagniecia());
			dto.setKwota(billboardReklama.getKwota());
			if(billboardReklama.getBillboard() != null){
				dto.idb = billboardReklama.getBillboard().getId();
			}
			if(billboardReklama.getReklama() != null){
				dto.idr = billboardReklama.getReklama().getId();
			}
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	public BillboardReklama getBillboardReklama(int id) {
		return manager.find(BillboardReklama.class, id);
	}
	
	public void updateBillboardReklama(BillboardReklamaDTO dto) {
		BillboardReklama billboardReklama = manager.find(BillboardReklama.class, dto.id);
		billboardReklama.setDataPowieszenia(dto.getDataPowieszenia());
		billboardReklama.setDataSciagniecia(dto.getDataSciagniecia());
		billboardReklama.setKwota(dto.getKwota());
		if(dto.getIdb()>0){
			Billboard billboard = manager.find(Billboard.class, dto.idb);
			billboardReklama.setBillboard(billboard);
		}
		if(dto.getIdr()>0){
			Reklama reklama = manager.find(Reklama.class, dto.idr);
			billboardReklama.setReklama(reklama);
		}
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
	
	public List<FakturaDTO> getFaktury(int id) {
		Klient klient =  manager.find(Klient.class, id);
		List<Faktura> list = klient.getFaktury();
		List<FakturaDTO> dtoList = new ArrayList<FakturaDTO>();
		for(Faktura faktura: list){
			FakturaDTO fakturaDTO = new FakturaDTO();
			fakturaDTO.setId(faktura.getId());
			fakturaDTO.setKwota(faktura.getKwota());
			fakturaDTO.setNip(faktura.getNip());
			fakturaDTO.setIdk(faktura.getKlient().getId());
			dtoList.add(fakturaDTO);
		}
		return dtoList;
	}
	
	public List<BillboardDTO> getBillboardyFromKlient(int id){
		List<BillboardDTO> dtoList = new ArrayList<BillboardDTO>();
		Klient klient =  manager.find(Klient.class, id);
		List<Faktura> faktury = klient.getFaktury();
		System.out.println(faktury.size());
		List<Billboard> billboardy = new ArrayList<Billboard>();
		for(Faktura faktura: faktury){
			billboardy.addAll(faktura.getBillboardy());
			System.out.println("EEEE");
		}
		for(Billboard billboard: billboardy){
			BillboardDTO dto = new BillboardDTO();
			dto.setId(billboard.getId());
			dto.setAdres(billboard.getAdres());
			dto.setIdf(billboard.getFaktura().getId());
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	//FAKTURA
	public void createFaktura(FakturaDTO dto) {
		Faktura faktura = new Faktura();
		faktura.kwota = dto.kwota;
		faktura.nip = dto.nip;
		if(dto.idk > 0){
			Klient klient = manager.find(Klient.class, dto.idk);
			faktura.setKlient(klient);
		}
		manager.persist(faktura);
	}
	
	public List<FakturaDTO> getAllFaktura() {
		Query q = manager.createQuery("select f from Faktura f");
		@SuppressWarnings("unchecked")
		List<Faktura> list = q.getResultList();
		List<FakturaDTO> dtoList = new ArrayList<FakturaDTO>();
		for(Faktura faktura: list){
			FakturaDTO dto = new FakturaDTO();
			dto.id = faktura.id;
			dto.kwota = faktura.kwota;
			dto.nip = faktura.nip;
			if(faktura.getKlient() != null){
				dto.idk = faktura.getKlient().getId();
			}
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	public FakturaDTO getFaktura(int id) {
		Faktura faktura =  manager.find(Faktura.class, id);
		FakturaDTO dto = new FakturaDTO();
		dto.id = faktura.id;
		dto.kwota = faktura.kwota;
		dto.nip = faktura.nip;
		if(faktura.getKlient() != null){
			dto.idk = faktura.getKlient().getId();
		}
		return dto;
	}
	
	public void updateFaktura(FakturaDTO dto) {
		Faktura faktura = manager.find(Faktura.class, dto.id);
		faktura.setKwota(dto.getKwota());
		faktura.setNip(dto.getNip());
		if(dto.getIdk()>0){
			Klient klient = manager.find(Klient.class, dto.idk);
			faktura.setKlient(klient);
		}
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
	
	public List<BillboardDTO> getBillboardy(int id) {
		Faktura faktura =  manager.find(Faktura.class, id);
		List<Billboard> list = faktura.getBillboardy();
		List<BillboardDTO> dtoList = new ArrayList<BillboardDTO>();
		for(Billboard billboard: list){
			BillboardDTO billboardDTO = new BillboardDTO();
			billboardDTO.setId(billboard.getId());
			billboardDTO.setAdres(billboard.getAdres());
			billboardDTO.setIdf(billboard.getFaktura().getId());
			dtoList.add(billboardDTO);
		}
		return dtoList;
	}
}
