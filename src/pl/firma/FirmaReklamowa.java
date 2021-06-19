package pl.firma;

import java.util.List;

import javax.ejb.Local;

@Local
public interface FirmaReklamowa {
	
	public abstract void createBillboard(Billboard billboard);	
	
	public abstract List<Billboard> getAllBillboards();
	
	public abstract Billboard getBillboard(int id);
	
	public abstract String updateBillboard(Billboard billboard);
	
	public abstract void deleteBillboard(int id);
	
	public abstract void addReklamaToBillboard(BillboardReklama billboardReklama, int idb, int idr);
	
	//REKLAMA
	public abstract void createReklama(Reklama reklama);	
	
	public abstract List<Reklama> getAllReklama();
	
	public abstract Reklama getReklama(int id);
	
	public abstract String updateReklama(Reklama reklama);
	
	public abstract void deleteReklama(int id);

}