package pl.firma;

import java.math.BigDecimal;

public class FakturaDTO {
	
	int id;
	BigDecimal kwota;
	String nip;
	int idk;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getKwota() {
		return kwota;
	}
	public void setKwota(BigDecimal kwota) {
		this.kwota = kwota;
	}
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}
	public int getIdk() {
		return idk;
	}
	public void setIdk(int idk) {
		this.idk = idk;
	}
	
}
