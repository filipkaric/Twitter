/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

/**
 * @author Filip
 * 
 */
public class TwitterTest {

	Twitter tw;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tw = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tw = null;
	}

	@Test
	public void testVratiSvePoruke() {
		tw.unesi("Filip", "Ja volim sendvic.");
		assertEquals("KORISNIK:Filip PORUKA:Ja volim sendvic.", tw
				.vratiSvePoruke().getLast().toString());

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesi() {
		tw.unesi("Filip", "OMG");
		assertEquals("Filip", tw.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("OMG", tw.vratiSvePoruke().getLast().getPoruka());
		tw.unesi(null, null);
	}
	@Test
	public void testVratiPoruke() {
		
		tw.unesi("Filip", "Opet slusam whoSee Dje se kupas?");
		tw.unesi("Darko", "Opet sam pao ispit :(");
		
		TwitterPoruka[] a = tw.vratiPoruke(2, "Opet");
		assertEquals("KORISNIK:Filip PORUKA:Opet slusam whoSee Dje se kupas?",a[0].toString());
		assertEquals("KORISNIK:Darko PORUKA:Opet sam pao ispit :(",a[1].toString());
		
	}

}
