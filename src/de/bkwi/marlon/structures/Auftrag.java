package de.bkwi.marlon.structures;

/**
 * 
 * Diese Klasse symbolisiert einen Auftrag
 * 
 * @author Marlon Kanngieﬂer
 *
 */
public class Auftrag {

	private String aufNr;
	private String aufDat;
	private Kunde vonKunde;

	/**
	 * Erstellt einen neuen Auftrag
	 */
	public Auftrag() {

	}

	/**
	 * @return die Auftragsnummer
	 */
	public String getAufNr() {
		return aufNr;
	}

	/**
	 * @param aufNr
	 *            the aufNr to set
	 */
	public void setAufNr(String aufNr) {
		this.aufNr = aufNr;
	}

	/**
	 * @return das Auftragsdatum
	 */
	public String getAufDat() {
		return aufDat;
	}

	/**
	 * @param aufDat
	 *            the aufDat to set
	 */
	public void setAufDat(String aufDat) {
		this.aufDat = aufDat;
	}

	/**
	 * @return den Kunden
	 */
	public Kunde getVonKunde() {
		return vonKunde;
	}

	/**
	 * @param vonKunde
	 *            the vonKunde to set
	 */
	public void setVonKunde(Kunde vonKunde) {
		this.vonKunde = vonKunde;
	}
}
