package pl.firma;

import java.util.List;

import javax.ejb.Local;

@Local
public interface FirmaReklamowa {
	
	public abstract void createBillboard(BillboardDTO dto);	
	
	public abstract List<BillboardDTO> getAllBillboards();
	
	public abstract Billboard getBillboard(int id);
	
	public abstract String updateBillboard(BillboardDTO dto);
	
	public abstract void deleteBillboard(int id);
	
	public abstract void addReklamaToBillboard(BillboardReklamaDTO dto);
	
	//BILLBOARD REKLAMA
	
	public abstract List<BillboardReklamaDTO> getAllBillboardReklama();
	
	public abstract BillboardReklama getBillboardReklama(int id);
	
	public abstract String updateBillboardReklama(BillboardReklamaDTO dto);
	
	public abstract void deleteBillboardReklama(int id);
	
	//REKLAMA
	public abstract void createReklama(Reklama reklama);	
	
	public abstract List<Reklama> getAllReklama();
	
	public abstract Reklama getReklama(int id);
	
	public abstract String updateReklama(Reklama reklama);
	
	public abstract void deleteReklama(int id);
	
	//KLIENT
	public abstract void createKlient(Klient klient);	
	
	public abstract List<Klient> getAllKlient();
	
	public abstract Klient getKlient(int id);
	
	public abstract String updateKlient(Klient klient);
	
	public abstract void deleteKlient(int id);
	
	public abstract List<FakturaDTO> getFaktury(int id);
	
	public abstract List<BillboardDTO> getBillboardyFromKlient(int id);
	
	//FAKTURA
	public abstract void createFaktura(FakturaDTO dto);	
	
	public abstract List<FakturaDTO> getAllFaktura();
	
	public abstract FakturaDTO getFaktura(int id);
	
	public abstract String updateFaktura(FakturaDTO dto);
	
	public abstract void deleteFaktura(int id);
	
	public abstract void addFakturaToKlient(int idf, int idk);
	
	public abstract List<BillboardDTO> getBillboardy(int id);

}