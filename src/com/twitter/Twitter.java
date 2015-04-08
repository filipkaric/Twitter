package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

public class Twitter {
	/**
	 * privatni atribut koji predstavlja listu poruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda koja vraca listu poruka
	 * 
	 * @return listu poruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Metoda Unesi unosi novu poruku tako sto unese korisnika koji zeli da je
	 * objavi i tekst poruke
	 * 
	 * @param korisnik
	 *            ime ili nadimak korisnika
	 * @param poruka
	 *            kratki tekst koji korisnik zeli da objavi
	 */
	public void unesi(String korisnik, String poruka) {
		/**
		 *  Pravi se nova poruka i puni podacima.
		 */
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		/**
		 *  Poruka se unosi u listu na kraj
		 */
		poruke.addLast(tp);
	}

	/**
	 * metoda koja vraca niz poruka sa odgovarajucim tagom. u nizu ima onoliko
	 * poruka koliko korisnik definise
	 * 
	 * @param maxBroj
	 *            maksimalan broj poruka koji ova metoda vraca
	 * @param tag
	 *            parametar na osnovu koga filtriramo poruke (npr #zvezda)
	 * @return vraca niz velicine maxBroj
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		/**
		 * Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		 */
		if (maxBroj <= 0)
			maxBroj = 100;
		/**
		 *  Pomocna promenljiva koja predstavlja brojac upisanih poruka
		 */
		int brojac = 0;
		/**
		 *  Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		 * sve poruke koje u sebi imaju zadati tag
		 * */
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		/** Pretrazuju se poruke i traze se one koje sadrze tag.
		* Ako se nadje neka takva, i ako nije prekoracen maxBroj
		* ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		* se prekida.
		*/
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}
