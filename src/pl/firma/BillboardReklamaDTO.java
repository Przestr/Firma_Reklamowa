package pl.firma;

import java.math.BigDecimal;
import java.sql.Date;

public class BillboardReklamaDTO {

	int id;
	
	Date dataPowieszenia;
	Date dataSciagniecia;
	BigDecimal kwota;
	int idb;
	int idr;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataPowieszenia() {
		return dataPowieszenia;
	}
	public void setDataPowieszenia(Date dataPowieszenia) {
		this.dataPowieszenia = dataPowieszenia;
	}
	public Date getDataSciagniecia() {
		return dataSciagniecia;
	}
	public void setDataSciagniecia(Date dataSciagniecia) {
		this.dataSciagniecia = dataSciagniecia;
	}
	public BigDecimal getKwota() {
		return kwota;
	}
	public void setKwota(BigDecimal kwota) {
		this.kwota = kwota;
	}
	public int getIdb() {
		return idb;
	}
	public void setIdb(int idb) {
		this.idb = idb;
	}
	public int getIdr() {
		return idr;
	}
	public void setIdr(int idr) {
		this.idr = idr;
	}
	
	
}
