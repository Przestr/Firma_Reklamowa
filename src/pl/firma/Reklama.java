package pl.firma;

import java.math.BigDecimal;
import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@XmlRootElement
public class Reklama {
	
	@Id
	@GeneratedValue
	int id;
	
	String tresc;
	
	@OneToMany(mappedBy="reklama",fetch = FetchType.EAGER)
	@JsonManagedReference(value="reklama")
	public List<BillboardReklama> billboardReklamy = new ArrayList<BillboardReklama>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTresc() {
		return tresc;
	}

	public void setTresc(String tresc) {
		this.tresc = tresc;
	}

	public List<BillboardReklama> getBillboardReklamy() {
		return billboardReklamy;
	}

	public void setBillboardReklamy(List<BillboardReklama> billboardReklamy) {
		this.billboardReklamy = billboardReklamy;
	}
	

}
