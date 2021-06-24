package pl.firma;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@XmlRootElement
public class Faktura {
	
	@Id
	@GeneratedValue
//	@XmlAttribute
	int id;
	BigDecimal kwota;
	String nip;
	
	@ManyToOne
    @JsonBackReference(value="faktura")
	public Klient klient;
	
	@OneToMany(mappedBy="faktura",fetch=FetchType.EAGER)
	@JsonManagedReference(value="billboard")
	public List<Billboard> billboardy = new ArrayList<Billboard>();
	
	public Klient getKlient() {
		return klient;
	}
	public void setKlient(Klient klient) {
		this.klient = klient;
	}
	public List<Billboard> getBillboardy() {
		return billboardy;
	}
	public void setBillboardy(List<Billboard> billboardy) {
		this.billboardy = billboardy;
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

}
