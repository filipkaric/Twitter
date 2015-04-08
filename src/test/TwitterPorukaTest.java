/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Filip
 * 
 */
public class TwitterPorukaTest {
	TwitterPoruka tp;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnik() {
		tp.setKorisnik("Filip");

		assertEquals("Filip", tp.getKorisnik());

		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		tp1.setKorisnik("");
		tp2.setKorisnik(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPoruka() {
		tp.setPoruka("Filip je Fica.");

		assertEquals("Filip je Fica.", tp.getPoruka());

		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		tp1.setPoruka(null);
		tp2.setPoruka("Ova poruka treba da ima vise od sto cetrdeset karaktera da bih proverio ovu metodu. Posto ne znam kada cu da stignem do sto cetrdeset samo cu da je iskopiram jos jednom. Ova poruka treba da ima vise od sto cetrdeset karaktera da bih proverio ovu metodu. Posto ne znam kada cu da stignem do sto cetrdeset samo cu da je iskopiram jos jednom");
	}
	@Test
	public void testToString() {
		tp.setKorisnik("Filip");
		tp.setPoruka("Svaka cast premijeru Vucicu. Za samo...");
		
		assertEquals("KORISNIK:Filip PORUKA:Svaka cast premijeru Vucicu. Za samo...",tp.toString());
	}

}
