package pl.firma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
//@XmlRootElement
public class Klient implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
//	@XmlAttribute
	int id;
	String imie;
	String nazwisko;
	String pesel;
	
	@OneToMany(mappedBy="klient",fetch=FetchType.LAZY)
	public List<Faktura> faktury = new ArrayList<Faktura>();

	public int getId() {
		return id;
	}
	
	public String getName() {
		return this.imie;
	}
	public void setName(String name) {
		this.imie = name;
	}
	public String getSurname() {
		return nazwisko;
	}
	public void setModel(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getPesel() {
		return this.pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public void setIdc(int id) {
		this.id = id;
	}	
}
