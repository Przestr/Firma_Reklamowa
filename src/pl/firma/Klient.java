package pl.firma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Klient{
	
	@Id
	@GeneratedValue
	int id;
	
	String imie;
	String nazwisko;
	String pesel;
	
	@OneToMany(mappedBy="klient",fetch=FetchType.EAGER, orphanRemoval = true)
	@JsonManagedReference(value="klient")
	public List<Faktura> faktury = new ArrayList<Faktura>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public List<Faktura> getFaktury() {
		return faktury;
	}

	public void setFaktury(List<Faktura> faktury) {
		this.faktury = faktury;
	}

	
}
