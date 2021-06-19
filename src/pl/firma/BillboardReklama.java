package pl.firma;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BillboardReklama {
	
	@Id
	@GeneratedValue
	int id;
	
	Date dataPowieszenia;
	Date dataSciagneicia;
	BigDecimal kwota;
	
	@ManyToOne
    @JsonBackReference(value="billboard")
	public Billboard billboard;
	
	@ManyToOne
    @JsonBackReference(value="reklama")
	public Reklama reklama;
	
	public Billboard getBillboard() {
		return billboard;
	}
	public void setBillboard(Billboard billboard) {
		this.billboard = billboard;
	}
	public Reklama getReklama() {
		return reklama;
	}
	public void setReklama(Reklama reklama) {
		this.reklama = reklama;
	}
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
