package com.twitter.poruke;

public class TwitterPoruka {
	/**
	 * atributi klase TwitterPoruka
	 * korisnik predstavlja nadimak koji je korisnik izabrao
	 * poruka je tekst poruke koju korisnik zeli da objavi
	 */
	private String korisnik;
	private String poruka;
	/**
	 * metoda koja vraca atribut korisnik
	 * @return
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * metoda koja postavlja vrednost atributa korisnik
	 * @param korisnik
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.equals("")){
			throw new RuntimeException("Ime korisnika mora biti uneto");}
		this.korisnik = korisnik;
	}
	/**
	 * metoda koja vraca atribut poruka
	 * @return
	 */
	public String getPoruka() {
		return poruka;
	}
	/**
	 * metoda koja postavlja vrednost atributa poruka
	 * @param poruka
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * metoda toString koja vraca korisnika i tekst poruke
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}

}
