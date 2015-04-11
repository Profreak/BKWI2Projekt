package de.bkwi.marlon.structures;

/**
 * 
 * Diese Klasse symbolisiert einen Kunden
 * 
 * @author Marlon Kanngieﬂer
 *
 */
public class Kunde {

	private String kdName;
	private String kdNr;

	/**
	 * Erstellt einen Kunden
	 */
	public Kunde(String kdNr) {
		this.kdNr = kdNr;
	}

	/**
	 * @return den Name des kunden
	 */
	public String getKdName() {
		return kdName;
	}

	/**
	 * @param kdName
	 *            the kdName to set
	 */
	public void setKdName(String kdName) {
		this.kdName = kdName;
	}

	/**
	 * 
	 * @return die Kundennummer
	 */
	public String getKdNr() {
		return kdNr;
	}

}
