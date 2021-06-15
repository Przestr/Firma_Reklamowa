package pl.firma;

import java.util.List;

import javax.ejb.Local;

@Local
public interface FirmaReklamowa {
	
	public abstract void createBillboard(Billboard billboard);	
	
	public abstract List<Billboard> getAllBillboards();

}