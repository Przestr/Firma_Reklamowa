package pl.firma;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BillboardReklama {
	
	@Id
	@GeneratedValue
	int id;
	
	Date dataPowieszenia;
	Date dataSciagneicia;
	BigDecimal kwota;
	
	@ManyToOne
	public Billboard billboard;
	
	@ManyToOne
	public Reklama reklama;
	
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
	public Date getDataSciagneicia() {
		return dataSciagneicia;
	}
	public void setDataSciagneicia(Date dataSciagneicia) {
		this.dataSciagneicia = dataSciagneicia;
	}
	public BigDecimal getKwota() {
		return kwota;
	}
	public void setKwota(BigDecimal kwota) {
		this.kwota = kwota;
	}
	
}
