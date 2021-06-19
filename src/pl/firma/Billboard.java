package pl.firma;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@XmlRootElement
public class Billboard {
	
	@Id
	@GeneratedValue
	int id;	
	String adres;
	
	@ManyToOne
	public Faktura faktura;
	
	@OneToMany(mappedBy="billboard",fetch = FetchType.EAGER)
	@JsonManagedReference(value="billboard")
	public List<BillboardReklama> billboardReklamy = new ArrayList<BillboardReklama>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public Faktura getFaktura() {
		return faktura;
	}

	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}

	public List<BillboardReklama> getBillboardReklamy() {
		return billboardReklamy;
	}

	public void setBillboardReklamy(List<BillboardReklama> billboardReklamy) {
		this.billboardReklamy = billboardReklamy;
	}

}
